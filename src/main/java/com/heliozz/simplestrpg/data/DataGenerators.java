package com.heliozz.simplestrpg.data;

import com.heliozz.simplestrpg.SimplestRPG;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SimplestRPG.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
	@SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        
        generator.addProvider(event.includeClient(), new SimplestRPGItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeServer(), new SimplestRPGRecipeProvider(packOutput));
	}
}
