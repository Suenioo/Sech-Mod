package net.sech.safiomod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.sech.safiomod.SafioMod;
import net.sech.safiomod.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SafioMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> SECHSAFIO_TAB = CREATIVE_MODE_TABS.register("sechsafio_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.TOTEMKISSER.get()))
                    .title(Component.translatable("creativetab.sechsafio_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.TOTEMKISSER.get());
                        output.accept(ModItems.ETETOTEM.get());
                        output.accept(ModItems.ALBERT.get());

                        output.accept(ModBlocks.ALBERT_ORE.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
