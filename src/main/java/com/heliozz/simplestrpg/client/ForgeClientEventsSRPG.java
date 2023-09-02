package com.heliozz.simplestrpg.client;

import org.joml.Vector3f;
import org.joml.Vector4f;
import org.slf4j.Logger;

import com.heliozz.simplestrpg.SimplestRPG;
import com.heliozz.simplestrpg.util.ClientUtil;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.logging.LogUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = SimplestRPG.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeClientEventsSRPG {
	private static final Logger LOGGER = LogUtils.getLogger();
	
	@SubscribeEvent
	public static void onLevelRenderTest(RenderLevelStageEvent event) {
		if(event.getStage() == RenderLevelStageEvent.Stage.AFTER_SKY) {
			Vector3f view = event.getCamera().getPosition().toVector3f();
			Minecraft minecraft = Minecraft.getInstance();
			float realTicks = minecraft.getPartialTick() + minecraft.level.getGameTime();
			LOGGER.info(Float.toString(realTicks));
			PoseStack poseStack = event.getPoseStack();
			poseStack.pushPose();
			MultiBufferSource.BufferSource bufferSource = Minecraft.getInstance().renderBuffers().bufferSource();
			VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.lines());
			Vector3f pos = new Vector3f(0.0F, 100.5F, 0.0F);
			ClientUtil.lineFromTo(view, poseStack, vertexConsumer, 
					pos, new Vector3f(pos).add((float) Math.cos(2.0D * Math.PI * ((double)realTicks/20.0D) - Math.PI/2), 0.0F, (float) Math.sin(2.0D * Math.PI * ((double)realTicks/20.0D)- Math.PI/2)), 
					new Vector4f(1.0F, 0.0F, 0.0F, 1.0F), new Vector4f(0.0F, 0.0F, 1.0F, 1.0F));
			poseStack.popPose();
		}
	}
}
