package com.heliozz.simplestrpg.client.model;

import java.util.function.Supplier;

import com.heliozz.simplestrpg.SimplestRPG;
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
import net.minecraft.world.entity.Entity;

// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class StonecrawlerModel<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(SimplestRPG.MODID, "stonecrawler"), "main");
	private final ModelPart body;
	
	public StonecrawlerModel(ModelPart root) {
		this.body = root.getChild("body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 7.0F, 0.0F));

		PartDefinition bodyBone = body.addOrReplaceChild("bodyBone", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body1_r1 = bodyBone.addOrReplaceChild("body1_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -1.0F, 8.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.6109F, 0.0F, 0.0F));

		PartDefinition rightLeg = bodyBone.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(52, 0).addBox(-3.0F, -2.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 3.0F, 7.5F, -0.3927F, 0.0F, 0.0F));

		PartDefinition rightLegBone = rightLeg.addOrReplaceChild("rightLegBone", CubeListBuilder.create(), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition rightFoot_r1 = rightLegBone.addOrReplaceChild("rightFoot_r1", CubeListBuilder.create().texOffs(26, 0).addBox(-3.0F, 6.45F, -0.5F, 3.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition rightLeg1_r1 = rightLegBone.addOrReplaceChild("rightLeg1_r1", CubeListBuilder.create().texOffs(52, 11).addBox(-3.0F, -1.2426F, -1.2574F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition leftLeg = bodyBone.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(52, 0).addBox(0.0F, -2.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 3.0F, 7.5F, -0.3927F, 0.0F, 0.0F));

		PartDefinition leftLegBone = leftLeg.addOrReplaceChild("leftLegBone", CubeListBuilder.create(), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition leftLeg1_r1 = leftLegBone.addOrReplaceChild("leftLeg1_r1", CubeListBuilder.create().texOffs(52, 11).addBox(0.0F, -1.2426F, -1.2574F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition leftFoot_r1 = leftLegBone.addOrReplaceChild("leftFoot_r1", CubeListBuilder.create().texOffs(26, 0).addBox(0.0F, 6.45F, -0.5F, 3.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition mainBodyBone = body.addOrReplaceChild("mainBodyBone", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body0_r1 = mainBodyBone.addOrReplaceChild("body0_r1", CubeListBuilder.create().texOffs(0, 14).addBox(-4.5F, -4.2F, -9.0F, 9.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition rightArm = mainBodyBone.addOrReplaceChild("rightArm", CubeListBuilder.create(), PartPose.offset(-4.0F, -3.0F, -7.0F));

		PartDefinition rightArm0_r1 = rightArm.addOrReplaceChild("rightArm0_r1", CubeListBuilder.create().texOffs(0, 42).addBox(-3.0F, -2.0F, -2.0F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition rightArmBone = rightArm.addOrReplaceChild("rightArmBone", CubeListBuilder.create().texOffs(12, 44).addBox(-3.0F, -0.5465F, -1.1407F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 10.0F, 1.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition rightHand_r1 = rightArmBone.addOrReplaceChild("rightHand_r1", CubeListBuilder.create().texOffs(26, 0).addBox(-3.0F, 7.9606F, -4.6179F, 3.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2182F, 0.0F, 0.0F));

		PartDefinition leftArm = mainBodyBone.addOrReplaceChild("leftArm", CubeListBuilder.create(), PartPose.offset(4.0F, -3.0F, -7.0F));

		PartDefinition leftArm0_r1 = leftArm.addOrReplaceChild("leftArm0_r1", CubeListBuilder.create().texOffs(0, 42).addBox(0.0F, -2.0F, -2.0F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition leftArmBone = leftArm.addOrReplaceChild("leftArmBone", CubeListBuilder.create().texOffs(12, 44).addBox(0.0F, -0.5465F, -1.1407F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 10.0F, 1.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition leftHand_r1 = leftArmBone.addOrReplaceChild("leftHand_r1", CubeListBuilder.create().texOffs(26, 0).addBox(0.0F, 7.9606F, -4.6179F, 3.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2182F, 0.0F, 0.0F));

		PartDefinition head = mainBodyBone.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 28).addBox(-3.0F, -7.0F, -5.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, -9.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}