package com.heliozz.complexrpg.client;

import org.joml.Vector3f;

import com.heliozz.complexrpg.ComplexRPG;
import com.heliozz.complexrpg.util.ClientUtil;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.BufferUploader;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = ComplexRPG.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeClientEventsCRPG {
	private static final ResourceLocation TEST_LOCATION = new ResourceLocation(ComplexRPG.MODID, "textures/misc/test.png");
	
	//@SubscribeEvent
	public static void onLevelRenderTest(RenderLevelStageEvent event) {
		if(event.getStage() == RenderLevelStageEvent.Stage.AFTER_PARTICLES) {
			RenderSystem.setShader(GameRenderer::getPositionTexShader);
			RenderSystem.setShaderTexture(0, TEST_LOCATION);
			RenderSystem.enableBlend();
			Vector3f view = event.getCamera().getPosition().toVector3f();
			PoseStack poseStack = event.getPoseStack();
			Tesselator tesselator = Tesselator.getInstance();
            BufferBuilder vertexConsumer = tesselator.getBuilder();

			Vector3f[] pos = {new Vector3f(1.0F, 101.0F, -1.0F),
								new Vector3f(1.0F, 99.0F, -1.0F),
								new Vector3f(-1.0F, 99.0F, -1.0F),
								new Vector3f(-1.0F, 101.0F, -1.0F)};
			
            vertexConsumer.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
            
			ClientUtil.vec3fVertex(view, poseStack, vertexConsumer, pos[0]).uv(0.0F, 0.0F).endVertex();
			ClientUtil.vec3fVertex(view, poseStack, vertexConsumer, pos[1]).uv(0.0F, 1.0F).endVertex();
			ClientUtil.vec3fVertex(view, poseStack, vertexConsumer, pos[2]).uv(1.0F, 1.0F).endVertex();
			ClientUtil.vec3fVertex(view, poseStack, vertexConsumer, pos[3]).uv(1.0F, 0.0F).endVertex();
			
			ClientUtil.vec3fVertex(view, poseStack, vertexConsumer, pos[3]).uv(1.0F, 0.0F).endVertex();
			ClientUtil.vec3fVertex(view, poseStack, vertexConsumer, pos[2]).uv(1.0F, 1.0F).endVertex();
			ClientUtil.vec3fVertex(view, poseStack, vertexConsumer, pos[1]).uv(0.0F, 1.0F).endVertex();
			ClientUtil.vec3fVertex(view, poseStack, vertexConsumer, pos[0]).uv(0.0F, 0.0F).endVertex();
			
			BufferUploader.drawWithShader(vertexConsumer.end());
			RenderSystem.disableBlend();
		}
	}
}
