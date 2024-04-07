package net.jason13.moreusefulcopper;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.jason13.monolib.methods.BlockMethods;
import net.jason13.moreusefulcopper.entity.custom.CopperGolemEntity;
import net.jason13.moreusefulcopper.loot.ModLootTableModifiers;
import net.jason13.moreusefulcopper.registry.FabricRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.block.Blocks;

public class FabricExampleMod implements ModInitializer {
    
    public boolean debuggingEnabled = false;
    
    @Override
    public void onInitialize() {
        
        // This method is invoked by the Fabric mod loader when it is ready
        // to load your mod. You can access Fabric and Common code in this
        // project.

        // Use Fabric to bootstrap the Common mod.
        CommonConstants.LOG.info("Hello Fabric world!");
        CommonClass.init();
        
        FabricRegistry.register();
        
        registerModEntityAttributes();
        
        ModLootTableModifiers.modifyLootTables();
        
        ServerTickEvents.START_SERVER_TICK.register(new PlayerTickHandler());
        
    }
    
    private static void registerModEntityAttributes() {
        FabricDefaultAttributeRegistry.register(FabricRegistry.COPPER_GOLEM, CopperGolemEntity.createAttributes());
    }
    
    public class PlayerTickHandler implements ServerTickEvents.StartTick {
        @Override
        public void onStartTick(MinecraftServer server) {
            for (ServerPlayer player : server.getPlayerList().getPlayers()) {
                
                boolean leftHandCommand = BlockMethods.compareBlockToItemStack(Blocks.COMMAND_BLOCK, player.getOffhandItem());
                boolean rightHandCommand = BlockMethods.compareBlockToItemStack(Blocks.COMMAND_BLOCK, player.getMainHandItem());
                
                if (!debuggingEnabled && leftHandCommand && rightHandCommand) {
                    debuggingEnabled = true;
                    player.sendSystemMessage(Component.literal("debuggingEnabled" + CommonConstants.MOD_NAME));
                }
            }
        }
    }
}
