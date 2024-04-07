package net.jason13.moreusefulcopper.registry;

import net.jason13.moreusefulcopper.CommonConstants;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class ModHorseArmorItem extends Item {
	private static final String TEX_FOLDER = "textures/entity/horse/";
	private final int protection;
	private final ResourceLocation texture;
	
	public ModHorseArmorItem(int p_41364_, String material, Item.Properties properties) {
		this(p_41364_, new ResourceLocation(CommonConstants.MOD_ID, "textures/entity/horse/armor/horse_armor_" + material + ".png"), properties);
	}
	
	public ModHorseArmorItem(int p_41364_, ResourceLocation p_41365_, Item.Properties p_41366_) {
		super(p_41366_);
		this.protection = p_41364_;
		this.texture = p_41365_;
	}
	
	public ResourceLocation getTexture() {
		return this.texture;
	}
	
	public int getProtection() {
		return this.protection;
	}
}