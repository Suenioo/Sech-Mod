package net.sech.safiomod.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.world.level.Level;
import net.sech.safiomod.network.ModNetworkHandler;
import net.sech.safiomod.network.TotemKisserActivatePacket;
import net.sech.safiomod.sound.ModSounds;

public class TotemKisser extends Item {
    public TotemKisser(Properties properties) {
        super(properties);
    }

    @SubscribeEvent
    public static void onPlayerDeath(LivingDeathEvent event) {
        if (!(event.getEntity() instanceof ServerPlayer player)) return;
        if (player.level().isClientSide) return;

        ItemStack totemStack = ItemStack.EMPTY;
        EquipmentSlot slotUsed = null;

        ItemStack mainHand = player.getMainHandItem();
        ItemStack offHand = player.getOffhandItem();

        if (mainHand.getItem() instanceof TotemKisser) {
            totemStack = mainHand;
            slotUsed = EquipmentSlot.MAINHAND;
        } else if (offHand.getItem() instanceof TotemKisser) {
            totemStack = offHand;
            slotUsed = EquipmentSlot.OFFHAND;
        }

        if (!totemStack.isEmpty()) {
            // Cancelar la muerte
            event.setCanceled(true);

            // Animación de tótem
            ModNetworkHandler.sendToClient(player, new TotemKisserActivatePacket());
            player.level().playSound(
                    null, // null para que lo oigan todos los jugadores cerca
                    player.getX(),
                    player.getY(),
                    player.getZ(),
                    ModSounds.ACTIVATE_TOTEM_KISSER.get(),
                    net.minecraft.sounds.SoundSource.PLAYERS,
                    1.0f, // volumen
                    1.0f  // pitch
            );

            // Revivir al jugador
            player.setHealth(1.0F);
            player.removeAllEffects();
            player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 900, 1));
            player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 100, 1));
            player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 800, 0));

            // Quitar el ítem
            player.setItemSlot(slotUsed, ItemStack.EMPTY);
        }
    }
}
