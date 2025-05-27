package net.sech.safiomod.item.custom;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.sech.safiomod.network.EteTotemActivatePacket;
import net.sech.safiomod.network.ModNetworkHandler;
import net.sech.safiomod.network.TotemKisserActivatePacket;
import net.sech.safiomod.sound.ModSounds;

public class EteTotem extends Item {
    public EteTotem(Properties properties) {
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

        if (mainHand.getItem() instanceof EteTotem) {
            totemStack = mainHand;
            slotUsed = EquipmentSlot.MAINHAND;
        } else if (offHand.getItem() instanceof EteTotem) {
            totemStack = offHand;
            slotUsed = EquipmentSlot.OFFHAND;
        }

        if (!totemStack.isEmpty()) {
            // Cancelar la muerte
            event.setCanceled(true);

            // Animación de tótem
            ModNetworkHandler.sendToClient(player, new EteTotemActivatePacket());
            player.level().playSound(
                    null, // null para que lo oigan todos los jugadores cerca
                    player.getX(),
                    player.getY(),
                    player.getZ(),
                    ModSounds.ACTIVATE_ETE_TOTEM.get(),
                    net.minecraft.sounds.SoundSource.PLAYERS,
                    1.0f, // volumen
                    1.0f  // pitch
            );

            // Revivir al jugador
            player.setHealth(8.0F);
            player.removeAllEffects();
            player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 350, 0));
            player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 200, 1));
            player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 800, 0));

            // Quitar el ítem
            player.setItemSlot(slotUsed, ItemStack.EMPTY);
        }
    }
}
