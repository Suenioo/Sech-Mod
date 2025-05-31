package net.sech.safiomod.entity.custom;

import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class BoykisserEntity extends Monster {
    public BoykisserEntity(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;


    @Override
    public void tick() {
        super.tick();

        if(this.level().isClientSide()) {
            setUpAnimationStates();
        }
    }

    private void setUpAnimationStates() {
        if(this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }
    }

    @Override
    protected void updateWalkAnimation(float pPartialTick) {
        float f;
        if(this.getPose() == Pose.STANDING) {
            f = Math.min(pPartialTick * 6F, 1f);
        } else {
            f = 0f;
        }

        this.walkAnimation.update(f, 0.2f);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 0.8D));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0F));

        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 40D)
                .add(Attributes.FOLLOW_RANGE, 32D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D)
                .add(Attributes.ATTACK_DAMAGE, 2.0D)
                .add(Attributes.ATTACK_KNOCKBACK, 0.5D)
                .add(Attributes.ARMOR_TOUGHNESS, 0.1D);
    }

    @Override
    public boolean doHurtTarget(Entity target) {
        boolean flag = super.doHurtTarget(target);

        if (flag && target instanceof Player player) {
            // Probabilidad del 35%
            if (this.level().random.nextFloat() < 0.35F) {
                boolean removedFood = removeAllFoodFromInventory(player);

                if (removedFood) {
                    this.setHealth(this.getMaxHealth()); // Se cura completamente

                    // Sonido de comer
                    this.level().playSound(
                            null,
                            this.blockPosition(),
                            SoundEvents.PLAYER_BURP,
                            SoundSource.HOSTILE,
                            1.0F,
                            0.9F
                    );

                    // Partículas de carne
                    if (!this.level().isClientSide && this.level() instanceof ServerLevel serverLevel) {
                        serverLevel.sendParticles(
                                new ItemParticleOption(ParticleTypes.ITEM, new ItemStack(Items.COOKED_BEEF)),
                                this.getX(), this.getY() + 1.0D, this.getZ(),
                                10,
                                0.2D, 0.2D, 0.2D,
                                0.1D
                        );
                    }
                }
            }
        }

        return flag;
    }


    private boolean removeAllFoodFromInventory(Player player) {
        boolean removed = false;

        for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
            ItemStack stack = player.getInventory().getItem(i);
            if (isFood(stack)) {
                player.getInventory().setItem(i, ItemStack.EMPTY);
                removed = true;
            }
        }

        return removed;
    }

    private boolean isFood(ItemStack stack) {
        return stack != null && !stack.isEmpty() && stack.isEdible();
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return SoundEvents.CAT_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.CAT_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.CAT_DEATH;
    }
}