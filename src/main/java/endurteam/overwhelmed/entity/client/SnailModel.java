// Made with Blockbench 4.10.1
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package endurteam.overwhelmed.entity.client;

import endurteam.overwhelmed.entity.SnailEntity;
import endurteam.overwhelmed.entity.animation.SnailAnimations;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;


public class SnailModel<T extends SnailEntity> extends SinglePartEntityModel<T> {
	private final ModelPart snail;
	public SnailModel(ModelPart root) {
		this.snail = root.getChild("snail");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData snail = modelPartData.addChild("snail", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData shell = snail.addChild("shell", ModelPartBuilder.create().uv(0, 30).cuboid(-6.0F, -8.3902F, -6.0384F, 12.0F, 16.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -10.0F, 0.0F, -0.1963F, 0.0F, 0.0F));

		ModelPartData saddle = snail.addChild("saddle", ModelPartBuilder.create().uv(0, 8).cuboid(-4.0F, -11.3902F, -4.0384F, 8.0F, 3.0F, 2.0F, new Dilation(0.1F))
				.uv(40, 0).cuboid(-6.0F, -8.3902F, -6.0384F, 12.0F, 8.0F, 16.0F, new Dilation(0.5F)), ModelTransform.of(0.0F, -10.0F, 0.0F, -0.1963F, 0.0F, 0.0F));

		ModelPartData left_antenna = snail.addChild("left_antenna", ModelPartBuilder.create().uv(2, 0).cuboid(0.4142F, -0.7857F, -5.8241F, 2.0F, 0.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, -4.0F, -12.0F, -0.589F, -0.7854F, 0.0F));

		ModelPartData right_antenna = snail.addChild("right_antenna", ModelPartBuilder.create().uv(-2, 0).cuboid(-2.4142F, -0.7857F, -5.8241F, 2.0F, 0.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, -4.0F, -12.0F, -0.589F, 0.7854F, 0.0F));

		ModelPartData body = snail.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -2.0F, -12.0F, 8.0F, 6.0F, 24.0F, new Dilation(-0.1F)), ModelTransform.pivot(0.0F, -4.0F, 0.0F));
		return TexturedModelData.of(modelData, 128, 128);
	}
	@Override
	public void setAngles(SnailEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);

		this.animateMovement(SnailAnimations.WALKING, limbSwing, limbSwingAmount, 2F, 2.5F);
		this.updateAnimation(entity.idleAnimationState, SnailAnimations.IDLING, ageInTicks, 1F);
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		snail.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return snail;
	}
}