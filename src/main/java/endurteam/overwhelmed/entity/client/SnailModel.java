// Made with Blockbench 4.10.1
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package endurteam.overwhelmed.entity.client;

import endurteam.overwhelmed.entity.SnailEntity;
import endurteam.overwhelmed.entity.animation.SnailAnimations;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;


public class SnailModel<T extends SnailEntity> extends SinglePartEntityModel<T> {
	private final ModelPart root;
	private final ModelPart shell;
	private final ModelPart saddle;
	private final ModelPart left_antenna;
	private final ModelPart right_antenna;
	private final ModelPart body;
	public SnailModel(ModelPart root) {
		this.root = root;
		this.shell = root.getChild("shell");
		this.saddle = root.getChild("saddle");
		this.left_antenna = root.getChild("left_antenna");
		this.right_antenna = root.getChild("right_antenna");
		this.body = root.getChild("body");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData shell = modelPartData.addChild("shell", ModelPartBuilder.create().uv(0, 30).cuboid(-6.0F, -8.3902F, -6.0384F, 12.0F, 16.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 14.0F, 0.0F, -0.1963F, 0.0F, 0.0F));

		ModelPartData saddle = modelPartData.addChild("saddle", ModelPartBuilder.create().uv(40, 0).cuboid(-6.0F, -8.3902F, -6.0384F, 12.0F, 8.0F, 16.0F, new Dilation(0.5F))
				.uv(0, 8).cuboid(-4.0F, -11.3902F, -4.0384F, 8.0F, 3.0F, 2.0F, new Dilation(0.1F)), ModelTransform.of(0.0F, 14.0F, 0.0F, -0.1963F, 0.0F, 0.0F));

		ModelPartData left_antenna = modelPartData.addChild("left_antenna", ModelPartBuilder.create().uv(4, 0).cuboid(0.4142F, -0.7857F, -5.8241F, 2.0F, 0.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, 20.0F, -12.0F, -0.589F, -0.7854F, 0.0F));

		ModelPartData right_antenna = modelPartData.addChild("right_antenna", ModelPartBuilder.create().uv(0, 0).cuboid(-2.4142F, -0.7857F, -5.8241F, 2.0F, 0.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, 20.0F, -12.0F, -0.589F, 0.7854F, 0.0F));

		ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -2.0F, -12.0F, 8.0F, 6.0F, 24.0F, new Dilation(-0.1F)), ModelTransform.pivot(0.0F, 20.0F, 0.0F));
		return TexturedModelData.of(modelData, 128, 128);
	}
	@Override
	public void setAngles(SnailEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);

		this.animateMovement(SnailAnimations.WALKING, limbSwing, limbSwingAmount, 8.0F, 2.5F);
		this.updateAnimation(entity.idleAnimationState, SnailAnimations.IDLING, ageInTicks, 1.0F);
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		shell.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		saddle.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		left_antenna.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		right_antenna.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		body.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return this.root;
	}
}