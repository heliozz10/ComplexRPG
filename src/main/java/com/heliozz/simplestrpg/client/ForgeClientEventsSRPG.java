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
	private static Minecraft minecraft = Minecraft.getInstance();
	
	@SubscribeEvent
	public static void onLevelRenderTest(RenderLevelStageEvent event) {
		if(event.getStage() == RenderLevelStageEvent.Stage.AFTER_SKY) {
			Vector3f view = event.getCamera().getPosition().toVector3f();
			float realTicks = minecraft.getPartialTick() + minecraft.level.getGameTime();
			PoseStack poseStack = event.getPoseStack();
			poseStack.pushPose();
			MultiBufferSource.BufferSource bufferSource = Minecraft.getInstance().renderBuffers().bufferSource();
			VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.lines());
			Vector3f start = new Vector3f(0.0F, 100.0F, 0.0F);
			Vector3f next = new Vector3f(1.0F, 101.0F, 0.0F);
			Vector4f color = new Vector4f(1.0F, 0.0F, 0.0F, 1.0F);
			ClientUtil.lineFromTo(view, poseStack, vertexConsumer, start, next, color, color);
			poseStack.popPose();
		}
	}
}
