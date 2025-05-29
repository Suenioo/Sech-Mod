package net.sech.safiomod.item.custom;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.sech.safiomod.network.AutoTotemActivatePacket;
import net.sech.safiomod.network.EteTotemActivatePacket;
import net.sech.safiomod.network.ModNetworkHandler;
import net.sech.safiomod.sound.ModSounds;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class AutoTotem extends Item implements ICurioItem {

    public AutoTotem(Properties properties) {
        super(properties);
        MinecraftForge.EVENT_BUS.register(this);
    }


    @SubscribeEvent
    public void onPlayerDeath(LivingDeathEvent event) {
        if (!(event.getEntity() instanceof ServerPlayer player)) return;
        if (player.level().isClientSide) return;

        CuriosApi.getCuriosInventory(player).ifPresent(curiosHandler -> {
            var curiosMap = curiosHandler.getCurios();

            curiosMap.forEach((slotId, slotHandler) -> {
                // Solo actuar en el slot "belt"
                if (!slotId.equals("belt")) return;

                var stacks = slotHandler.getStacks();
                for (int i = 0; i < stacks.getSlots(); i++) {
                    ItemStack stack = stacks.getStackInSlot(i);
                    if (stack.getItem() instanceof AutoTotem) {
                        // Cancelar la muerte
                        event.setCanceled(true);

                        // Animación y sonido
                        ModNetworkHandler.sendToClient(player, new AutoTotemActivatePacket());
                        player.level().playSound(
                                null, // null para que lo oigan todos los jugadores cerca
                                player.getX(),
                                player.getY(),
                                player.getZ(),
                                SoundEvents.TOTEM_USE,
                                net.minecraft.sounds.SoundSource.PLAYERS,
                                1.0f, // volumen
                                1.0f  // pitch
                        );

                        // Efectos de tótem
                        player.setHealth(4.0F);
                        player.removeAllEffects();
                        player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 0));
                        player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 60, 2));
                        player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 100, 0));

                        // Consumir el ítem
                        stacks.setStackInSlot(i, ItemStack.EMPTY);
                        return;
                    }
                }
            });
        });
    }
}

