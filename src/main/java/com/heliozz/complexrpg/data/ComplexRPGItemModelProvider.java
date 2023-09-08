package com.heliozz.complexrpg.data;

import com.heliozz.complexrpg.ComplexRPG;
import com.heliozz.complexrpg.content.ComplexRPGItems;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ComplexRPGItemModelProvider extends ItemModelProvider {
	public ComplexRPGItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ComplexRPG.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() throws IllegalStateException {
        ComplexRPGItems.ITEMS.getEntries().forEach(regObject -> {
        	switch(ComplexRPGItems.getMap().get(regObject.getId().getPath())) {
			case HANDHELD:
				handheldItem(regObject);
				break;
			case SIMPLE:
				simpleItem(regObject);
				break;
			default:
				throw new IllegalStateException("[SimplestRPGException, DataGeneration] Unable to generate model for: " + regObject.getId().toString());
        	}
        });
        
        ComplexRPGItems.SPAWN_EGGS.getEntries().forEach(regObject -> {
        	withExistingParent(regObject.getId().getPath(),
        			new ResourceLocation("item/template_spawn_egg"));
        });
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ComplexRPG.MODID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(ComplexRPG.MODID,"item/" + item.getId().getPath()));
    }
}
