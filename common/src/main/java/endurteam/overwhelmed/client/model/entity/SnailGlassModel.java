/**
 *  Overwhelmed, a Minecraft overhauling and adding new features to the Overworld's surface!<br>
 *  Copyright (C) 2023-2024 Endurteam<br>
 *  <br>
 *  This program is free software: you can redistribute it and/or modify<br>
 *  it under the terms of the GNU General Public License as published by<br>
 *  the Free Software Foundation, either version 3 of the License, or<br>
 *  any later version.<br>
 *  <br>
 *  This program is distributed in the hope that it will be useful,<br>
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of<br>
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the<br>
 *  GNU General Public License for more details.<br>
 *  <br>
 *  You should have received a copy of the GNU General Public License with<br>
 *  the Minecraft Linking Exception<br>
 *  along with this program.  If not, see <https://www.gnu.org/licenses/> and<br>
 *  <https://gist.github.com/triphora/588f353802a3b0ea649e4fc85f75e583/>
 */

// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
package endurteam.overwhelmed.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import endurteam.overwhelmed.client.animation.definitions.SnailAnimation;
import endurteam.overwhelmed.world.entity.animal.Snail;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.NotNull;


public class SnailGlassModel<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart root;
	private final ModelPart body;
	private final ModelPart shell;
	private final ModelPart left_antennae;
	private final ModelPart right_antennae;

	public SnailGlassModel(ModelPart root) {
		this.root = root;
		this.body = root.getChild("body");
		this.shell = root.getChild("shell");
		this.left_antennae = root.getChild("left_antennae");
		this.right_antennae = root.getChild("right_antennae");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create()
				.texOffs(0, 0).addBox(-1.5F, -1.0F, -3.0F, 3.0F, 2.0F, 7.0F,
						new CubeDeformation(-0.1F)), PartPose.offset(0.0F, 23.0F, 0.0F));

		PartDefinition shell = partdefinition.addOrReplaceChild("shell", CubeListBuilder.create()
				.texOffs(0, 9).addBox(-2.0F, -2.5F, -2.5F, 4.0F, 5.0F, 5.0F,
						new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 20.5F, 1.5F,
				-0.3927F, 0.0F, 0.0F));

		PartDefinition left_antennae = partdefinition.addOrReplaceChild("left_antennae", CubeListBuilder.create()
				.texOffs(0, 1).addBox(0.5F, -0.5F, -2.0F, 0.0F, 1.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, 22.5F, -2.5F, -0.3927F, 0.0F, 0.0F));

		PartDefinition right_antennae = partdefinition.addOrReplaceChild("right_antennae", CubeListBuilder
				.create().texOffs(0, 0).addBox(-0.5F, -0.5F, -2.0F, 0.0F, 1.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, 22.5F, -2.5F, -0.3927F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
						  float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		if (entity.walkDist > 0) {
			this.animateWalk(SnailAnimation.SNAIL_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		} else if (entity.isAlive()) {
			this.animate(((Snail) entity).idleAnimationState, SnailAnimation.SNAIL_IDLE, ageInTicks, 1f);
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		shell.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_antennae.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_antennae.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public @NotNull ModelPart root() {
		return this.root;
	}
}