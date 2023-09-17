package com.heliozz.complexrpg.client.model;

import org.slf4j.Logger;

import com.heliozz.complexrpg.ComplexRPG;
import com.heliozz.complexrpg.content.entity.mobs.Stonecrawler;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.logging.LogUtils;

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


public class StonecrawlerModel<T extends Stonecrawler> extends EntityModel<T> {
	private static final Logger LOGGER = LogUtils.getLogger();
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ComplexRPG.MODID, "stonecrawler"), "main");
	private final ModelPart 
		body, 
			mainBodyBone, 
				body0, 
				rightArm, 
					rightArm0, 
					rightArmBone, 
						rightHand,
				leftArm,
					leftArm0,
					leftArmBone,
						leftHand,
				head,
			bodyBone,
				body1,
				rightLeg,
					rightLegBone,
						rightLeg1,
						rightFoot,
				leftLeg,
					leftLegBone,
						leftLeg1,
						leftFoot;
	
	
	public StonecrawlerModel(ModelPart root) {
		this.body = root.getChild("body");
		this.mainBodyBone = body.getChild("mainBodyBone");
		this.body0 = mainBodyBone.getChild("body0_r1");
		this.rightArm = mainBodyBone.getChild("rightArm");
		this.rightArm0 = rightArm.getChild("rightArm0_r1");
		this.rightArmBone = rightArm.getChild("rightArmBone");
		this.rightHand = rightArmBone.getChild("rightHand_r1");
		this.leftArm = mainBodyBone.getChild("leftArm");
		this.leftArm0 = leftArm.getChild("leftArm0_r1");
		this.leftArmBone = leftArm.getChild("leftArmBone");
		this.leftHand = leftArmBone.getChild("leftHand_r1");
		this.head = mainBodyBone.getChild("head");
		this.bodyBone = body.getChild("bodyBone");
		this.body1 = bodyBone.getChild("body1_r1");
		this.rightLeg = bodyBone.getChild("rightLeg");
		this.rightLegBone = rightLeg.getChild("rightLegBone");
		this.rightLeg1 = rightLegBone.getChild("rightLeg1_r1");
		this.rightFoot = rightLegBone.getChild("rightFoot_r1");
		this.leftLeg = bodyBone.getChild("leftLeg");
		this.leftLegBone = leftLeg.getChild("leftLegBone");
		this.leftLeg1 = leftLegBone.getChild("leftLeg1_r1");
		this.leftFoot = leftLegBone.getChild("leftFoot_r1");
		
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 7.0F, 0.0F));
		
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

		PartDefinition bodyBone = body.addOrReplaceChild("bodyBone", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body1_r1 = bodyBone.addOrReplaceChild("body1_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -1.0F, 8.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.6109F, 0.0F, 0.0F));

		PartDefinition rightLeg = bodyBone.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(52, 0).addBox(-3.0F, -2.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 3.0F, 7.5F, -0.3927F, 0.0F, 0.0F));

		PartDefinition rightLegBone = rightLeg.addOrReplaceChild("rightLegBone", CubeListBuilder.create(), PartPose.offset(0.0F, 6.0F, 0.0F));
		
		PartDefinition rightLeg1_r1 = rightLegBone.addOrReplaceChild("rightLeg1_r1", CubeListBuilder.create().texOffs(52, 11).addBox(-3.0F, -1.2426F, -1.2574F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition rightFoot_r1 = rightLegBone.addOrReplaceChild("rightFoot_r1", CubeListBuilder.create().texOffs(26, 0).addBox(-3.0F, 6.45F, -0.5F, 3.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition leftLeg = bodyBone.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(52, 0).addBox(0.0F, -2.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 3.0F, 7.5F, -0.3927F, 0.0F, 0.0F));

		PartDefinition leftLegBone = leftLeg.addOrReplaceChild("leftLegBone", CubeListBuilder.create(), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition leftLeg1_r1 = leftLegBone.addOrReplaceChild("leftLeg1_r1", CubeListBuilder.create().texOffs(52, 11).addBox(0.0F, -1.2426F, -1.2574F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition leftFoot_r1 = leftLegBone.addOrReplaceChild("leftFoot_r1", CubeListBuilder.create().texOffs(26, 0).addBox(0.0F, 6.45F, -0.5F, 3.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));
		
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.xRot = headPitch * ((float)Math.PI / 180F);
		this.head.yRot = netHeadYaw * ((float)Math.PI / 180F);
		long startedTick = entity.getStartedCrawlingTick();
		long stoppedTick = entity.getStoppedCrawlingTick();
		if(startedTick == -1) {
			float ticksAfterStopped = ageInTicks - stoppedTick;
			if(ticksAfterStopped > 15.0F) {
				this.mainBodyBone.y = this.bodyBone.y = 0.0F;
				this.bodyBone.xRot = 0.0F;
				this.rightLeg.z = 7.5F;
				this.leftLeg.z = 7.5F;
				this.rightArm.z = -7.0F;
				this.leftArm.z = -7.0F;
				this.rightLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 0.9F * limbSwingAmount - (float) (Math.PI / 8);
				this.leftLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.9F * limbSwingAmount - (float) (Math.PI / 8);
				this.rightArm.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.9F * limbSwingAmount;
				this.leftArm.xRot = Mth.cos(limbSwing * 0.6662F) * 0.9F * limbSwingAmount;
			} else {
				float interpolation2 = (float) Math.pow(ticksAfterStopped/15.0F - 1.0F, 5.0F);
				this.rightLeg.z = 7.5F;
				this.leftLeg.z = 7.5F;
				this.rightArm.z = -7.0F;
				this.leftArm.z = -7.0F;
				this.mainBodyBone.y = this.bodyBone.y = -16.0F * interpolation2;
				this.bodyBone.xRot = (float) -((Math.PI/4) * interpolation2);
				this.rightLeg.xRot = this.leftLeg.xRot = (float) (-(Math.PI * 17/72) * interpolation2 - Math.PI/8);
				this.rightArm.xRot = this.leftArm.xRot = (float) ((Math.PI * 17/36) * interpolation2);
			}
		}
		if(stoppedTick == -1) {
			float ticksAfterStarted = ageInTicks - startedTick;
			if(ticksAfterStarted > 15.0F) {
				this.mainBodyBone.y = this.bodyBone.y = 16.0F;
				this.bodyBone.xRot = (float) Math.PI/4;
				this.rightLeg.z = 2.0F * Mth.sin(limbSwing * 0.6662F) + 7.5F;
				this.leftLeg.z = 2.0F * Mth.sin(limbSwing * 0.6662F + (float)Math.PI) + 7.5F;
				this.rightArm.z = 2.0F * Mth.sin(limbSwing * 0.6662F + (float)Math.PI) - 7.0F;
				this.leftArm.z = 2.0F * Mth.sin(limbSwing * 0.6662F) - 7.0F;
				this.rightLeg.xRot = this.leftLeg.xRot = (float) (-(Math.PI * 17/72) * (-1.0F) - Math.PI/8);
				this.rightArm.xRot = this.leftArm.xRot = -(float) (Math.PI * 17/36);
			} else {
				float interpolation1 = (float) (Math.pow(1.0F - ticksAfterStarted/15.0F, 5.0F) - 1.0D);
				this.mainBodyBone.y = this.bodyBone.y = -16.0F * interpolation1;
				this.bodyBone.xRot = (float) -((Math.PI/4) * interpolation1);
				this.rightLeg.xRot = this.leftLeg.xRot = (float) (-(Math.PI * 17/72) * interpolation1 - Math.PI/8);
				this.rightArm.xRot = this.leftArm.xRot = (float) ((Math.PI * 17/36) * interpolation1);
			}
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}