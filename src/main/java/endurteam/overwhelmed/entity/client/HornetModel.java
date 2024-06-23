// Made with Blockbench 4.10.1
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package endurteam.overwhelmed.entity.client;

import endurteam.overwhelmed.entity.HornetEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class HornetModel<T extends HornetEntity> extends EntityModel<T> {
    private final ModelPart head;
    private final ModelPart antenna;
    private final ModelPart front_legs;
    private final ModelPart body;
    private final ModelPart middle_legs;
    private final ModelPart back_legs;
    private final ModelPart left_wing;
    private final ModelPart right_wing;
    public HornetModel(ModelPart root) {
        this.head = root.getChild("head");
        this.antenna = root.getChild("antenna");
        this.front_legs = root.getChild("front_legs");
        this.body = root.getChild("body");
        this.middle_legs = body.getChild("middle_legs");
        this.back_legs = this.body.getChild("back_legs");
        this.left_wing = root.getChild("left_wing");
        this.right_wing = root.getChild("right_wing");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create().uv(0, 24).cuboid(-4.0F, -4.0F, -9.0F, 8.0F, 8.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 12.0F, 0.0F));

        ModelPartData antenna = modelPartData.addChild("antenna", ModelPartBuilder.create().uv(26, 33).cuboid(0.0F, -3.0F, -8.0F, 8.0F, 4.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 11.0F, -9.0F, 0.0F, 0.7854F, 0.0F));

        ModelPartData front_legs = modelPartData.addChild("front_legs", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, 0.0F, 0.0F, 4.0F, 3.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 16.0F, -5.0F));

        ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-5.0F, -5.0F, 0.0F, 10.0F, 10.0F, 14.0F, new Dilation(0.0F))
                .uv(1, 40).cuboid(0.0F, 3.0F, 12.0F, 0.0F, 8.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 12.0F, 0.0F, -0.6545F, 0.0F, 0.0F));

        ModelPartData back_legs = body.addChild("back_legs", ModelPartBuilder.create().uv(0, 3).cuboid(-3.0F, 0.0F, 0.0F, 6.0F, 3.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 5.0F, 4.0F, 0.6981F, 0.0F, 0.0F));

        ModelPartData middle_legs = body.addChild("middle_legs", ModelPartBuilder.create().uv(0, 3).cuboid(-3.0F, 0.0F, 0.0F, 6.0F, 3.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 5.0F, 1.0F, 0.6981F, 0.0F, 0.0F));

        ModelPartData left_wing = modelPartData.addChild("left_wing", ModelPartBuilder.create().uv(28, 0).cuboid(0.0F, 0.0F, 0.0F, 14.0F, 0.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(3.0F, 8.0F, 3.0F));

        ModelPartData right_wing = modelPartData.addChild("right_wing", ModelPartBuilder.create().uv(28, 0).mirrored().cuboid(-14.0F, 0.0F, 0.0F, 14.0F, 0.0F, 8.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-3.0F, 8.0F, 3.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }
    @Override
    public void setAngles(HornetEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.left_wing.roll = MathHelper.sin(ageInTicks * 2) * (float)Math.PI * 0.125f;
        this.right_wing.roll = -this.left_wing.roll;
        // default pitch is -0.6545
        float j = MathHelper.sin(ageInTicks / ((float)Math.PI * 3f));
        this.body.pitch = MathHelper.map(MathHelper.sin(ageInTicks / ((float)Math.PI * 3f)), -1f, 1f, -0.4f, -0.8f);
        this.middle_legs.pitch = j * 0.3f;
        this.back_legs.pitch = j * 0.3f;

    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        head.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        antenna.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        front_legs.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        body.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        left_wing.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        right_wing.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }
}