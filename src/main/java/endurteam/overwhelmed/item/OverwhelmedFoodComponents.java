package endurteam.overwhelmed.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class OverwhelmedFoodComponents {

    public static final FoodComponent COOKED_SNAIL =
            new FoodComponent.Builder().nutrition(4).saturationModifier(0.8F).build();
    public static final FoodComponent SNAIL =
            new FoodComponent.Builder().nutrition(2).saturationModifier(0.3F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 600, 0), 0.6F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 600, 0), 0.4F).build();
    public static final FoodComponent SNAIL_STEW =
            new FoodComponent.Builder().nutrition(6).saturationModifier(15.0F).build();

    public static final FoodComponent VANILLA_COOKIE =
            new FoodComponent.Builder().nutrition(4).saturationModifier(0.4F).snack().build();
    public static final FoodComponent VANILLA_ICE_CREAM =
            new FoodComponent.Builder().nutrition(6).saturationModifier(1.2F).snack().build();

    public static final FoodComponent PEPPERMINT =
            new FoodComponent.Builder().nutrition(2).saturationModifier(0.6F).snack().build();
    public static final FoodComponent MINT_ICE_CREAM =
            new FoodComponent.Builder().nutrition(6).saturationModifier(1.2F).snack().build();

}