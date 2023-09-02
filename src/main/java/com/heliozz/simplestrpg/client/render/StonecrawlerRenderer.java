package com.heliozz.simplestrpg.client.render;

import com.heliozz.simplestrpg.SimplestRPG;
import com.heliozz.simplestrpg.client.model.StonecrawlerModel;
import com.heliozz.simplestrpg.content.entity.mobs.Stonecrawler;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class StonecrawlerRenderer extends MobRenderer<Stonecrawler, StonecrawlerModel<Stonecrawler>>{
	private static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(SimplestRPG.MODID, "textures/entity/stonecrawler.png");

	public StonecrawlerRenderer(EntityRendererProvider.Context ctx) {
	    super(ctx, new StonecrawlerModel<>(ctx.bakeLayer(StonecrawlerModel.LAYER_LOCATION)), 0.7F);
	}

	public ResourceLocation getTextureLocation(Stonecrawler entity) {
	    return TEXTURE_LOCATION;
	}
}