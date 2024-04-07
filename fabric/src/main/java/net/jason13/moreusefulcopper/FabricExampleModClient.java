package net.jason13.moreusefulcopper;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.jason13.moreusefulcopper.entity.client.CopperGolemModel;
import net.jason13.moreusefulcopper.entity.client.CopperGolemRenderer;
import net.jason13.moreusefulcopper.entity.layer.ModModelLayers;
import net.jason13.moreusefulcopper.registry.FabricRegistry;

public class FabricExampleModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		EntityModelLayerRegistry.registerModelLayer(ModModelLayers.COPPER_GOLEM, CopperGolemModel::createBodyLayer);
		
		EntityRendererRegistry.register(FabricRegistry.COPPER_GOLEM, CopperGolemRenderer::new);
	}
}
