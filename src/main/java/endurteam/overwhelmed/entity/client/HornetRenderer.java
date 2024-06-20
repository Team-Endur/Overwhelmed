package endurteam.overwhelmed.entity.client;

import endurteam.overwhelmed.Overwhelmed;
import endurteam.overwhelmed.entity.HornetEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class HornetRenderer extends MobEntityRenderer<HornetEntity, HornetModel<HornetEntity>> {
    private static final Identifier TEXTURE = new Identifier(Overwhelmed.MOD_ID, "textures/entity/hornet.png");

    public HornetRenderer(EntityRendererFactory.Context context) {
        super(context, new HornetModel<>(context.getPart(OverwhelmedModelLayers.HORNET)), 0.6F);
    }

    @Override
    public Identifier getTexture(HornetEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(HornetEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
