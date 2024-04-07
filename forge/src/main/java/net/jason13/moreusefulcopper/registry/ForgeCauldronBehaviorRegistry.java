package net.jason13.moreusefulcopper.registry;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMaps;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.core.Position;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.core.dispenser.AbstractProjectileDispenseBehavior;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LayeredCauldronBlock;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

import static net.minecraft.core.cauldron.CauldronInteraction.*;

public class ForgeCauldronBehaviorRegistry {
	public static Object2ObjectMap<Item, CauldronInteraction> CAULDRON_WATER_MAP = new Object2ObjectOpenHashMap();
	
	public static void registerCopperBucketToWaterMap() {
		Map<Item, CauldronInteraction> syncronizedCauldronMap = Object2ObjectMaps.synchronize(CAULDRON_WATER_MAP);
		
		// CAULDRON_WATER_MAP.put(Items.BUCKET, (p_175725_, p_175726_, p_175727_, p_175728_, p_175729_, p_175730_) -> {
		// 	return fillBucket(p_175725_, p_175726_, p_175727_, p_175728_, p_175729_, p_175730_, new ItemStack(ForgeRegistry.COPPER_WATER_BUCKET.get()), (p_175660_) -> {
		// 		return (Integer)p_175660_.getValue(LayeredCauldronBlock.LEVEL) == 3;
		// 	}, SoundEvents.BUCKET_FILL);
		// });
		
		CAULDRON_WATER_MAP.put(ForgeRegistry.COPPER_WATER_BUCKET.get(), FILL_WATER);
		
		CauldronInteraction.WATER.putAll(syncronizedCauldronMap);
	}
}
