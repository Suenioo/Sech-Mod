package net.sech.safiomod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sech.safiomod.SafioMod;
import net.sech.safiomod.item.custom.EteTotem;
import net.sech.safiomod.item.custom.TotemKisser;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SafioMod.MOD_ID);

    public static final RegistryObject<Item> TOTEMKISSER = ITEMS.register("totemkisser",
            () -> new TotemKisser(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> ETETOTEM = ITEMS.register("etetotem",
            () -> new EteTotem(new Item.Properties()));

    public static final RegistryObject<Item> ALBERT = ITEMS.register("albert",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
