package com.heliozz.simplestrpg.client.render;

import com.heliozz.simplestrpg.SimplestRPG;
import com.heliozz.simplestrpg.client.model.AwakenedCowModel;
import com.heliozz.simplestrpg.content.entity.mobs.AwakenedCow;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class AwakenedCowRenderer extends MobRenderer<AwakenedCow, AwakenedCowModel<AwakenedCow>>{
	private static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(SimplestRPG.MODID, "textures/entity/awakened_cow.png");

	public AwakenedCowRenderer(EntityRendererProvider.Context ctx) {
	    super(ctx, new AwakenedCowModel<>(ctx.bakeLayer(AwakenedCowModel.LAYER_LOCATION)), 0.7F);
	}
	
	public ResourceLocation getTextureLocation(AwakenedCow entity) {
	    return TEXTURE_LOCATION;
	}
}
