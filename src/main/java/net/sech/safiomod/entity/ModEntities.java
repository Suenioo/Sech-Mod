package net.sech.safiomod.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sech.safiomod.SafioMod;
import net.sech.safiomod.entity.custom.BoykisserEntity;
import net.sech.safiomod.entity.custom.ChechuEntity;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SafioMod.MOD_ID);

    public static final RegistryObject<EntityType<ChechuEntity>> CHECHU =
            ENTITY_TYPES.register("chechu", () -> EntityType.Builder.of(ChechuEntity::new, MobCategory.CREATURE)
                    .sized(1f, 1.6f).build("chechu"));

    public static final RegistryObject<EntityType<BoykisserEntity>> BOYKISSER =
            ENTITY_TYPES.register("boykisser", () -> EntityType.Builder.of(BoykisserEntity::new, MobCategory.CREATURE)
                    .sized(0.5f, 2f).build("boykisser"));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
