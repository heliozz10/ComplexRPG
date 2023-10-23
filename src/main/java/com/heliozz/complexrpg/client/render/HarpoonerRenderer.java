package com.heliozz.complexrpg.client.render;

import com.heliozz.complexrpg.ComplexRPG;
import com.heliozz.complexrpg.client.model.HarpoonerModel;
import com.heliozz.complexrpg.content.entity.mobs.Harpooner;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class HarpoonerRenderer extends MobRenderer<Harpooner, HarpoonerModel<Harpooner>>{
	private static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(ComplexRPG.MODID, "textures/entity/harpooner.png");

	public HarpoonerRenderer(EntityRendererProvider.Context ctx) {
	    super(ctx, new HarpoonerModel<>(ctx.bakeLayer(HarpoonerModel.LAYER_LOCATION)), 0.5F);
	}
	
	public ResourceLocation getTextureLocation(Harpooner entity) {
	    return TEXTURE_LOCATION;
	}
}
