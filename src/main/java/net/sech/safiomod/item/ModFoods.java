package net.sech.safiomod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties HOLODET = new FoodProperties.Builder()
            .meat()
            .nutrition(3)
            .saturationMod(0.8F)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 20), 0.3F).build();

}
