package net.jason13.moreusefulcopper.entity.client;

import net.jason13.moreusefulcopper.CommonConstants;
import net.jason13.moreusefulcopper.entity.custom.CopperGolemEntity;
import net.jason13.moreusefulcopper.entity.layer.ModModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CopperGolemRenderer extends MobRenderer<CopperGolemEntity, CopperGolemModel<CopperGolemEntity>> {
	
	public static final ResourceLocation COPPER_GOLEM_LOCATION = new ResourceLocation(CommonConstants.MOD_ID, "textures/entity/copper_golem/copper_golem.png");
	
	public CopperGolemRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new CopperGolemModel<>(pContext.bakeLayer(ModModelLayers.COPPER_GOLEM_LAYER)), 1.0F);
	}
	
	@Override
	public ResourceLocation getTextureLocation(CopperGolemEntity copperGolemEntity) {
		return COPPER_GOLEM_LOCATION;
	}
}
