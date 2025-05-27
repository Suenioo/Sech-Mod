package net.sech.safiomod.network;

import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;
import net.sech.safiomod.item.ModItems;

import java.util.function.Supplier;

public class EteTotemActivatePacket {

    public EteTotemActivatePacket() {
    }

    public static void encode(EteTotemActivatePacket msg, FriendlyByteBuf buf) {
        // No data to encode
    }

    public static EteTotemActivatePacket decode(FriendlyByteBuf buf) {
        return new EteTotemActivatePacket();
    }

    public static void handle(EteTotemActivatePacket msg, Supplier<NetworkEvent.Context> context) {
        context.get().enqueueWork(() -> {
            Minecraft.getInstance().gameRenderer.displayItemActivation(new ItemStack(ModItems.ETETOTEM.get()));
        });
        context.get().setPacketHandled(true);
    }
}
