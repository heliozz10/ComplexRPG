package com.heliozz.simplestrpg.util;

import org.joml.Vector3f;
import org.joml.Vector4f;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

public class ClientUtil {
	public static void lineFromTo(Vector3f view, PoseStack poseStack, VertexConsumer vertexConsumer, Vector3f pos1, Vector3f pos2, Vector4f color1, Vector4f color2) {
		Vector3f direction = (new Vector3f(pos2)).sub(pos1).normalize();
		vertexConsumer.vertex(poseStack.last().pose(), pos1.x - view.x, pos1.y - view.y, pos1.z - view.z)
						.color(color1.x, color1.y, color1.z, color1.w)
						.normal(poseStack.last().normal(), -direction.x, -direction.y, -direction.z)
						.endVertex();
		vertexConsumer.vertex(poseStack.last().pose(), pos2.x - view.x, pos2.y - view.y, pos2.z - view.z)
						.color(color2.x, color2.y, color2.z, color2.w)
						.normal(poseStack.last().normal(), direction.x, direction.y, direction.z)
						.endVertex();
	}
}
