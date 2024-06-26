// Made with Blockbench 4.10.1
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package endurteam.overwhelmed.entity.client;

import endurteam.overwhelmed.entity.MothEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class MothModel<T extends MothEntity> extends SinglePartEntityModel<T> {
    private final ModelPart root;
    private final ModelPart body;
    private final ModelPart right_wing;
    private final ModelPart left_wing;
    private final ModelPart legs1;
    private final ModelPart legs2;
    private final ModelPart legs3;
    public MothModel(ModelPart root) {
        this.root = root;
        this.body = root.getChild("body");
        this.right_wing = body.getChild("right_wing");
        this.left_wing = body.getChild("left_wing");
        this.legs1 = body.getChild("legs1");
        this.legs2 = body.getChild("legs2");
        this.legs3 = body.getChild("legs3");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(18, 17).cuboid(-1.5F, -1.5F, -4.5F, 3.0F, 3.0F, 9.0F, new Dilation(0.0F))
                .uv(0, 2).cuboid(1.5F, -1.5F, -9.5F, 0.0F, 2.0F, 5.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-1.5F, -1.5F, -9.5F, 0.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 16.0F, 0.0F, -0.589F, 0.0F, 0.0F));

        ModelPartData right_wing = body.addChild("right_wing", ModelPartBuilder.create().uv(0, 13).cuboid(-7.0F, 0.0F, -6.5F, 7.0F, 0.0F, 13.0F, new Dilation(0.0F)), ModelTransform.of(-1.5F, -1.0F, 0.0F, -0.2182F, 0.0F, 0.0F));

        ModelPartData left_wing = body.addChild("left_wing", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, 0.0F, -6.5F, 7.0F, 0.0F, 13.0F, new Dilation(0.0F)), ModelTransform.of(1.5F, -1.0F, 0.0F, -0.2182F, 0.0F, 0.0F));

        ModelPartData legs1 = body.addChild("legs1", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, 0.0F, 0.0F, 3.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 1.5F, -2.5F, 0.6545F, 0.0F, 0.0F));

        ModelPartData legs2 = body.addChild("legs2", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, 0.0F, 0.0F, 3.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 1.5F, -1.0F, 0.6545F, 0.0F, 0.0F));

        ModelPartData legs3 = body.addChild("legs3", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, 0.0F, 0.0F, 3.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 1.5F, 0.5F, 0.6545F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }
    @Override
    public void setAngles(MothEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);

        float sinAge = MathHelper.sin(ageInTicks);
        this.left_wing.roll = sinAge * (float)Math.PI * 0.14f - 0.75f;
        this.right_wing.roll = -this.left_wing.roll;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        body.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart getPart() {
        return this.root;
    }
}
