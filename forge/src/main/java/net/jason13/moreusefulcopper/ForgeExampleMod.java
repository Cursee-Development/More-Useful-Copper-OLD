package net.jason13.moreusefulcopper;

import net.jason13.monolib.methods.BlockMethods;
import net.jason13.moreusefulcopper.entity.client.CopperGolemModel;
import net.jason13.moreusefulcopper.entity.client.CopperGolemRenderer;
import net.jason13.moreusefulcopper.entity.custom.CopperGolemEntity;
import net.jason13.moreusefulcopper.entity.layer.ModModelLayers;
import net.jason13.moreusefulcopper.loot.ModLootModifiers;
import net.jason13.moreusefulcopper.registry.ForgeCauldronBehaviorRegistry;
import net.jason13.moreusefulcopper.registry.ForgeRegistry;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(CommonConstants.MOD_ID)
public class ForgeExampleMod {
    
    public boolean debuggingEnabled = false;
    
    public ForgeExampleMod() {
    
        // This method is invoked by the Forge mod loader when it is ready
        // to load your mod. You can access Forge and Common code in this
        // project.
    
        // Use Forge to bootstrap the Common mod.
        CommonConstants.LOG.info("Hello Forge world!");
        CommonClass.init();
        
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        
        bus.addListener(this::commonSetup);
        
        ForgeRegistry.register(bus);
        
        ModLootModifiers.register(bus);
        
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    public void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            // ForgeCauldronBehaviorRegistry.registerCopperBucketToWaterMap();
        });
    }
    
    @SubscribeEvent
    public void onStartTick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            for (ServerPlayer player : event.getServer().getPlayerList().getPlayers()) {
                
                boolean leftHandCommand = BlockMethods.compareBlockToItemStack(Blocks.COMMAND_BLOCK, player.getOffhandItem());
                boolean rightHandCommand = BlockMethods.compareBlockToItemStack(Blocks.COMMAND_BLOCK, player.getMainHandItem());
                
                if (!debuggingEnabled && leftHandCommand && rightHandCommand) {
                    debuggingEnabled = true;
                    player.sendSystemMessage(Component.literal("debuggingEnabled" + CommonConstants.MOD_NAME));
                }
            }
        }
    }
    
    
    @Mod.EventBusSubscriber(modid = CommonConstants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public class ClientEvents{
        @SubscribeEvent
        public static void onClientSetup(final FMLClientSetupEvent event) {
            event.enqueueWork(() -> {
                EntityRenderers.register(ForgeRegistry.COPPER_GOLEM.get(), CopperGolemRenderer::new);
            });
        }
    }
    
    @Mod.EventBusSubscriber(modid = CommonConstants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public class ModEvents{
        @SubscribeEvent
        public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
            event.registerLayerDefinition(ModModelLayers.COPPER_GOLEM_LAYER, CopperGolemModel::createBodyLayer);
        }
        
        @SubscribeEvent
        public static void registerAttributes(EntityAttributeCreationEvent event) {
            event.put(ForgeRegistry.COPPER_GOLEM.get(), CopperGolemEntity.createAttributes().build());
        }
    }
    
}