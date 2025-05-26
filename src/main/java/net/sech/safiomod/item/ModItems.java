package net.sech.safiomod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sech.safiomod.SafioMod;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SafioMod.MOD_ID);

    public static final RegistryObject<Item> TOTEMKISSER = ITEMS.register("totemkisser",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ETETOTEM = ITEMS.register("etetotem",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ALBERT = ITEMS.register("albert",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
