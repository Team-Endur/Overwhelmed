// Made with Blockbench 4.10.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
package endurteam.overwhelmed.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class ButterflyModel<T extends Entity> extends EntityModel<T> {
    private final ModelPart body;
    private final ModelPart right_wing;
    private final ModelPart left_wing;

    public ButterflyModel(ModelPart root) {
        this.body = root.getChild("body");
        this.right_wing = root.getChild("right_wing");
        this.left_wing = root.getChild("left_wing");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(8, 5).cuboid(-0.5F, -0.5F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F))
                .uv(6, 8).cuboid(-0.5F, -0.5F, -5.5F, 0.0F, 2.0F, 3.0F, new Dilation(0.0F))
                .uv(0, 7).cuboid(0.5F, -0.5F, -5.5F, 0.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 16.5F, 0.0F, -0.589F, 0.0F, 0.0F));

        ModelPartData right_wing = modelPartData.addChild("right_wing", ModelPartBuilder.create().uv(0, 5).cuboid(-4.0F, 0.0F, -2.5F, 4.0F, 0.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 16.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

        ModelPartData left_wing = modelPartData.addChild("left_wing", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, 0.0F, -2.5F, 4.0F, 0.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, 16.0F, 0.0F, -0.7854F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 32, 32);
    }
    @Override
    public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        body.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        right_wing.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        left_wing.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }
}