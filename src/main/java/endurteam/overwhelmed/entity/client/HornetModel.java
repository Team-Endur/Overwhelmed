// Made with Blockbench 4.10.1
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package endurteam.overwhelmed.entity.client;

import endurteam.overwhelmed.entity.HornetEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class HornetModel<T extends HornetEntity> extends EntityModel<T> {
    private final ModelPart head;
    private final ModelPart antenna;
    private final ModelPart legs1;
    private final ModelPart body;
    private final ModelPart legs2;
    private final ModelPart legs3;
    private final ModelPart stinger;
    private final ModelPart left_wing;
    private final ModelPart right_wing;
    public HornetModel(ModelPart root) {
        this.head = root.getChild("head");
        this.antenna = root.getChild("antenna");
        this.legs1 = root.getChild("legs1");
        this.body = root.getChild("body");
        this.legs2 = this.body.getChild("legs2");
        this.legs3 = this.body.getChild("legs3");
        this.stinger = this.body.getChild("stinger");
        this.left_wing = this.body.getChild("left_wing");
        this.right_wing = this.body.getChild("right_wing");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create().uv(0, 24)
                .cuboid(-4.0F, -4.0F, -9.0F, 8.0F, 8.0F, 9.0F, new Dilation(0.0F)),
                ModelTransform.pivot(0.0F, 12.0F, 0.0F));

        ModelPartData antenna = modelPartData.addChild("antenna", ModelPartBuilder.create().uv(26, 33)
                .cuboid(0.0F, -3.0F, -8.0F, 8.0F, 4.0F, 8.0F, new Dilation(0.0F)),
                ModelTransform.of(0.0F, 11.0F, -9.0F, 0.0F, 0.7854F, 0.0F));

        ModelPartData legs1 = modelPartData.addChild("legs1", ModelPartBuilder.create().uv(0, 0)
                .cuboid(-2.0F, 0.0F, 0.0F, 4.0F, 3.0F, 0.0F, new Dilation(0.0F)),
                ModelTransform.pivot(0.0F, 16.0F, -5.0F));

        ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(0, 0)
                .cuboid(-5.0F, -5.0F, 0.0F, 10.0F, 10.0F, 14.0F, new Dilation(0.0F)),
                ModelTransform.of(0.0F, 12.0F, 0.0F, -0.6545F, 0.0F, 0.0F));

        ModelPartData legs2 = body.addChild("legs2", ModelPartBuilder.create().uv(0, 3)
                .cuboid(-3.0F, 0.0F, 0.0F, 6.0F, 3.0F, 0.0F, new Dilation(0.0F)),
                ModelTransform.of(0.0F, 5.0F, 1.0F, 0.6545F, 0.0F, 0.0F));

        ModelPartData legs3 = body.addChild("legs3", ModelPartBuilder.create().uv(0, 3)
                .cuboid(-3.0F, 0.0F, 0.0F, 6.0F, 3.0F, 0.0F, new Dilation(0.0F)),
                ModelTransform.of(0.0F, 5.0F, 4.0F, 0.6545F, 0.0F, 0.0F));

        ModelPartData stinger = body.addChild("stinger", ModelPartBuilder.create().uv(1, 40)
                .cuboid(0.0F, 0.0F, -2.0F, 0.0F, 8.0F, 2.0F, new Dilation(0.0F)),
                ModelTransform.pivot(0.0F, 3.0F, 14.0F));

        ModelPartData left_wing = body.addChild("left_wing", ModelPartBuilder.create().uv(28, 0)
                .cuboid(0.0F, 0.0F, 0.0F, 14.0F, 0.0F, 8.0F, new Dilation(0.0F)),
                ModelTransform.of(3.0F, -5.0F, 0.0F, 0.6545F, 0.0F, 0.0F));

        ModelPartData right_wing = body.addChild("right_wing", ModelPartBuilder.create().uv(28, 0)
                .mirrored().cuboid(-14.0F, 0.0F, 0.0F, 14.0F, 0.0F, 8.0F,
                        new Dilation(0.0F)).mirrored(false), ModelTransform.of(-3.0F, -5.0F, 0.0F,
                0.6545F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }
    @Override
    public void setAngles(HornetEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
                          float headPitch) {
    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green,
                       float blue, float alpha) {
        head.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        antenna.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        legs1.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        body.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        legs2.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        legs3.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        stinger.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        left_wing.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        right_wing.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);

    }

}