package net.sech.safiomod.network;

import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;
import net.sech.safiomod.item.ModItems;

import java.util.function.Supplier;

public class AutoTotemActivatePacket {

    public AutoTotemActivatePacket() {
    }

    public static void encode(AutoTotemActivatePacket msg, FriendlyByteBuf buf) {
        // No data to encode
    }

    public static AutoTotemActivatePacket decode(FriendlyByteBuf buf) {
        return new AutoTotemActivatePacket();
    }

    public static void handle(AutoTotemActivatePacket msg, Supplier<NetworkEvent.Context> context) {
        context.get().enqueueWork(() -> {
            Minecraft.getInstance().gameRenderer.displayItemActivation(new ItemStack(ModItems.AUTOTOTEM.get()));
        });
        context.get().setPacketHandled(true);
    }
}
