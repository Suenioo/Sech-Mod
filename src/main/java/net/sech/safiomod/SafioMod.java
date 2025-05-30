package net.sech.safiomod;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.sech.safiomod.block.ModBlocks;
import net.sech.safiomod.entity.ModEntities;
import net.sech.safiomod.entity.client.BoykisserRenderer;
import net.sech.safiomod.entity.client.ChechuRenderer;
import net.sech.safiomod.item.ModCreativeModeTabs;
import net.sech.safiomod.item.ModItems;
import net.sech.safiomod.item.custom.EteTotem;
import net.sech.safiomod.item.custom.TotemKisser;
import net.sech.safiomod.loot.ModLootModifiers;
import net.sech.safiomod.network.ModNetworkHandler;
import net.sech.safiomod.sound.ModSounds;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(SafioMod.MOD_ID)
public class SafioMod {
    public static final String MOD_ID = "safiomod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public SafioMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModSounds.register(modEventBus);

        ModEntities.register(modEventBus);

        ModLootModifiers.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);
        MinecraftForge.EVENT_BUS.register(TotemKisser.class);
        MinecraftForge.EVENT_BUS.register(EteTotem.class);
        ModNetworkHandler.register();
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ModItems.TOTEMKISSER);
            event.accept(ModItems.ETETOTEM);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntities.CHECHU.get(), ChechuRenderer::new);
            EntityRenderers.register(ModEntities.BOYKISSER.get(), BoykisserRenderer::new);
        }
    }
}
