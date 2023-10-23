package com.heliozz.complexrpg.client.model;

import com.heliozz.complexrpg.ComplexRPG;
import com.heliozz.complexrpg.content.entity.mobs.Harpooner;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;

public class HarpoonerModel<T extends Harpooner> extends HumanoidModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ComplexRPG.MODID, "harpooner"), "main");
	
	public HarpoonerModel(ModelPart root) {
		super(root);
	}
}
