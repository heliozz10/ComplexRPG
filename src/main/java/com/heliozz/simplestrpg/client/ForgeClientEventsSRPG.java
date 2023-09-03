package com.heliozz.simplestrpg.client;

import org.joml.Vector3f;
import org.slf4j.Logger;

import com.heliozz.simplestrpg.SimplestRPG;
import com.heliozz.simplestrpg.util.ClientUtil;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.BufferUploader;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.logging.LogUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = SimplestRPG.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeClientEventsSRPG {
	private static final Logger LOGGER = LogUtils.getLogger();
	private static Minecraft minecraft = Minecraft.getInstance();
	private static final ResourceLocation TEST_LOCATION = new ResourceLocation("textures/gui/container/creative_inventory/tab_inventory.png");
	
	@SubscribeEvent
	public static void onLevelRenderTest(RenderLevelStageEvent event) {
		if(event.getStage() == RenderLevelStageEvent.Stage.AFTER_PARTICLES) {
			RenderSystem.setShader(GameRenderer::getPositionTexShader);
			RenderSystem.setShaderTexture(0, TEST_LOCATION);
			RenderSystem.enableBlend();
			Vector3f view = event.getCamera().getPosition().toVector3f();
			PoseStack poseStack = event.getPoseStack();
			poseStack.pushPose();
			Tesselator tesselator = Tesselator.getInstance();
            BufferBuilder vertexConsumer = tesselator.getBuilder();
            vertexConsumer.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
			Vector3f pos1 = new Vector3f(-1.0F, 100.0F, -1.0F);
			Vector3f pos2 = new Vector3f(1.0F, 100.0F, -1.0F);
			Vector3f pos3 = new Vector3f(1.0F, 100.0F, 1.0F);
			Vector3f pos4 = new Vector3f(-1.0F, 100.0F, 1.0F);
			ClientUtil.vec3fVertex(view, poseStack, vertexConsumer, pos4).uv(0.0F, 0.0F).endVertex();
			ClientUtil.vec3fVertex(view, poseStack, vertexConsumer, pos3).uv(1.0F, 0.0F).endVertex();
			ClientUtil.vec3fVertex(view, poseStack, vertexConsumer, pos2).uv(1.0F, 1.0F).endVertex();
			ClientUtil.vec3fVertex(view, poseStack, vertexConsumer, pos1).uv(0.0F, 1.0F).endVertex();
			BufferUploader.drawWithShader(vertexConsumer.end());
			poseStack.popPose();
			RenderSystem.disableBlend();
		}
	}
}
