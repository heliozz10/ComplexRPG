package com.heliozz.simplestrpg.client.render;

import com.heliozz.simplestrpg.SimplestRPG;
import com.heliozz.simplestrpg.client.model.StonecrawlerModel;
import com.heliozz.simplestrpg.content.entity.mobs.Stonecrawler;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class StonecrawlerRenderer extends MobRenderer<Stonecrawler, StonecrawlerModel<Stonecrawler>>{
	private static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(SimplestRPG.MODID, "textures/entity/stonecrawler.png");

	public StonecrawlerRenderer(EntityRendererProvider.Context ctx) {
	    super(ctx, new StonecrawlerModel<>(ctx.bakeLayer(StonecrawlerModel.LAYER_LOCATION)), 0.7F);
	}
	
	public void render(Stonecrawler entity, float f, float f1, PoseStack poseStack, MultiBufferSource bufferSource, int i) {
	    super.render(entity, f, f1, poseStack, bufferSource, i);
	}

	public ResourceLocation getTextureLocation(Stonecrawler entity) {
	    return TEXTURE_LOCATION;
	}
}