package com.heliozz.complexrpg.client.render;

import com.heliozz.complexrpg.ComplexRPG;
import com.heliozz.complexrpg.client.model.SoulmiteModel;
import com.heliozz.complexrpg.content.entity.mobs.Soulmite;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SoulmiteRenderer extends MobRenderer<Soulmite, SoulmiteModel<Soulmite>> {
	private static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(ComplexRPG.MODID, "textures/entity/soulmite.png");

	public SoulmiteRenderer(EntityRendererProvider.Context ctx) {
	    super(ctx, new SoulmiteModel<>(ctx.bakeLayer(SoulmiteModel.LAYER_LOCATION)), 0.7F);
	}

	public ResourceLocation getTextureLocation(Soulmite entity) {
	    return TEXTURE_LOCATION;
	}
}
