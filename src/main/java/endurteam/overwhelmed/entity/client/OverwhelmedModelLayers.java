package endurteam.overwhelmed.entity.client;

import endurteam.overwhelmed.Overwhelmed;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class OverwhelmedModelLayers {
    public static final EntityModelLayer HORNET =
            new EntityModelLayer(new Identifier(Overwhelmed.MOD_ID, "hornet"), "main");
}