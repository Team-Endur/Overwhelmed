package endurteam.overwhelmed.entity.client;

import endurteam.overwhelmed.Overwhelmed;
import endurteam.overwhelmed.entity.MothEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class MothRenderer extends MobEntityRenderer<MothEntity, MothModel<MothEntity>> {
    public MothRenderer(EntityRendererFactory.Context context) {
        super(context, new MothModel<>(context.getPart(OverwhelmedModelLayers.MOTH)), 0.6F);
    }

    @Override
    public Identifier getTexture(MothEntity moth) {
        return new Identifier(Overwhelmed.MOD_ID, "textures/entity/moth/moth_" + moth.getVariant().asString() + ".png");
    }

    @Override
    public void render(MothEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
