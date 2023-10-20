package com.heliozz.complexrpg.client.render;

import com.heliozz.complexrpg.ComplexRPG;
import com.heliozz.complexrpg.client.model.PossessedCowModel;
import com.heliozz.complexrpg.content.entity.mobs.PossessedCow;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class PossessedCowRenderer extends MobRenderer<PossessedCow, PossessedCowModel<PossessedCow>> {
	private static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(ComplexRPG.MODID, "textures/entity/possessed_cow.png");

	public PossessedCowRenderer(EntityRendererProvider.Context ctx) {
	    super(ctx, new PossessedCowModel<>(ctx.bakeLayer(PossessedCowModel.LAYER_LOCATION)), 0.7F);
	}

	public ResourceLocation getTextureLocation(PossessedCow entity) {
	    return TEXTURE_LOCATION;
	}
}
