package endurteam.overwhelmed.entity.client;

import endurteam.overwhelmed.Overwhelmed;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class OverwhelmedModelLayers {
    public static final EntityModelLayer BUTTERFLY =
            new EntityModelLayer(new Identifier(Overwhelmed.MOD_ID, "butterfly"), "main");
    public static final EntityModelLayer SNAIL =
            new EntityModelLayer(new Identifier(Overwhelmed.MOD_ID, "snail"), "main");
    public static final EntityModelLayer MOTH =
            new EntityModelLayer(new Identifier(Overwhelmed.MOD_ID, "moth"), "main");
    public static final EntityModelLayer HORNET =
            new EntityModelLayer(new Identifier(Overwhelmed.MOD_ID, "hornet"), "main");
}