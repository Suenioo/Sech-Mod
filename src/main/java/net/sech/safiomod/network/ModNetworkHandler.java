package net.sech.safiomod.network;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;
import net.sech.safiomod.SafioMod;

public class ModNetworkHandler {

    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(SafioMod.MOD_ID, "network"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );

    public static void register() {
        INSTANCE.messageBuilder(TotemKisserActivatePacket.class, 0, NetworkDirection.PLAY_TO_CLIENT)
                .encoder(TotemKisserActivatePacket::encode)
                .decoder(TotemKisserActivatePacket::decode)
                .consumerNetworkThread(TotemKisserActivatePacket::handle)
                .add();

        INSTANCE.messageBuilder(EteTotemActivatePacket.class, 1, NetworkDirection.PLAY_TO_CLIENT)
                .encoder(EteTotemActivatePacket::encode)
                .decoder(EteTotemActivatePacket::decode)
                .consumerNetworkThread(EteTotemActivatePacket::handle)
                .add();

        INSTANCE.messageBuilder(AutoTotemActivatePacket.class, 2, NetworkDirection.PLAY_TO_CLIENT)
                .encoder(AutoTotemActivatePacket::encode)
                .decoder(AutoTotemActivatePacket::decode)
                .consumerNetworkThread(AutoTotemActivatePacket::handle)
                .add();

        // Aquí puedes registrar otros paquetes si lo necesitas
    }

    public static <MSG> void sendToClient(ServerPlayer player, MSG message) {
        INSTANCE.sendTo(message, player.connection.connection, NetworkDirection.PLAY_TO_CLIENT);
    }
}
