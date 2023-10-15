package com.heliozz.complexrpg.client.model;

import com.heliozz.complexrpg.content.entity.mobs.Soulmite;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class SoulmiteModel<T extends Soulmite> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "soulmite"), "main");
	private final ModelPart main;
	private final ModelPart tail;
	private final ModelPart tail1;

	public SoulmiteModel(ModelPart root) {
		this.main = root.getChild("main");
		this.tail = root.getChild("tail");
		this.tail1 = root.getChild("tail1");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(23, 21).addBox(-3.0F, -5.0F, -11.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-5.0F, -6.0F, -6.0F, 9.0F, 6.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(21, 16).addBox(-3.0F, -7.0F, 1.0F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition spike2_r1 = main.addOrReplaceChild("spike2_r1", CubeListBuilder.create().texOffs(18, 28).addBox(-1.0F, 3.0F, 2.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.0F, -4.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition spike3_r1 = main.addOrReplaceChild("spike3_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -2.0F, 8.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -4.0F, 0.4363F, 0.0F, 0.0F));

		PartDefinition spike1_r1 = main.addOrReplaceChild("spike1_r1", CubeListBuilder.create().texOffs(23, 31).addBox(-1.0F, -8.0F, -3.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -4.0F, -0.4465F, 0.019F, -0.0056F));

		PartDefinition spike_r1 = main.addOrReplaceChild("spike_r1", CubeListBuilder.create().texOffs(31, 31).addBox(-1.0F, -6.0F, 1.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -4.0F, 0.9343F, 0.0123F, 0.0206F));

		PartDefinition body1_r1 = main.addOrReplaceChild("body1_r1", CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, -7.0F, 0.0F, 7.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -4.0F, 0.2136F, -0.0134F, 0.014F));

		PartDefinition tail = partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 26).addBox(-3.0F, -5.0F, 4.0F, 5.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition tail1 = partdefinition.addOrReplaceChild("tail1", CubeListBuilder.create().texOffs(28, 0).addBox(-2.0F, -3.0F, 7.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.tail.yRot = Mth.cos((float) (Math.PI * ageInTicks));
		this.tail.yRot = 1.2F * Mth.cos((float) (Math.PI * ageInTicks));
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tail1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}