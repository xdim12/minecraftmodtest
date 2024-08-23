package net.xdim12.funmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import net.xdim12.funmod.init.ModBlock;
import net.xdim12.funmod.init.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FunMod implements ModInitializer {
	public static final String MOD_ID = "funmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlock.registerModBlock();

		BlockRenderLayerMap.INSTANCE.putBlock(ModBlock.SECRET_BLOCK, RenderLayer.getCutout());


	}
}