package net.sech.safiomod.network;

import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;
import net.sech.safiomod.item.ModItems;

import java.util.function.Supplier;

public class TotemKisserActivatePacket {

    public TotemKisserActivatePacket() {
    }

    public static void encode(TotemKisserActivatePacket msg, FriendlyByteBuf buf) {
        // No data to encode
    }

    public static TotemKisserActivatePacket decode(FriendlyByteBuf buf) {
        return new TotemKisserActivatePacket();
    }

    public static void handle(TotemKisserActivatePacket msg, Supplier<NetworkEvent.Context> context) {
        context.get().enqueueWork(() -> {
            Minecraft.getInstance().gameRenderer.displayItemActivation(new ItemStack(ModItems.TOTEMKISSER.get()));
        });
        context.get().setPacketHandled(true);
    }
}
