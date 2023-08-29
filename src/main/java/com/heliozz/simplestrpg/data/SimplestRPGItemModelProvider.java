package com.heliozz.simplestrpg.data;

import com.heliozz.simplestrpg.SimplestRPG;
import com.heliozz.simplestrpg.content.SimplestRPGItems;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class SimplestRPGItemModelProvider extends ItemModelProvider {
	public SimplestRPGItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, SimplestRPG.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        handheldItem(SimplestRPGItems.CRIMSON_DAGGER);
        
        SimplestRPGItems.SPAWN_EGGS.getEntries().forEach(regObject -> {
        	withExistingParent(regObject.getId().getPath(),
        			new ResourceLocation("item/template_spawn_egg"));
        });
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(SimplestRPG.MODID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(SimplestRPG.MODID,"item/" + item.getId().getPath()));
    }
}
