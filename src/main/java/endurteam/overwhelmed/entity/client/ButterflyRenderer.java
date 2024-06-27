package endurteam.overwhelmed.entity.client;

import endurteam.overwhelmed.entity.ButterflyEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class ButterflyRenderer extends MobEntityRenderer<ButterflyEntity, ButterflyModel<ButterflyEntity>> {
    public ButterflyRenderer(EntityRendererFactory.Context context) {
        super(context, new ButterflyModel<>(context.getPart(OverwhelmedModelLayers.BUTTERFLY)), 0.6F);
    }

    @Override
    public Identifier getTexture(ButterflyEntity butterfly) {
        return butterfly.getTextureId();
    }

    @Override
    public void render(ButterflyEntity butterfly, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(butterfly, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
