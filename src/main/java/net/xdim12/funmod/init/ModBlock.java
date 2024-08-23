package net.xdim12.funmod.init;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.xdim12.funmod.FunMod;
import net.xdim12.funmod.init.Blocks.TouletBlock;

public class ModBlock {
    public static final Block SECRET_BLOCK = registerWithItem("secret_block", new TouletBlock(AbstractBlock.Settings.create()
            .strength(5.0f, 6.0f)
            .requiresTool()));

    private static Block registerBlock(String name, Block block){
        return Registry.register(Registries.BLOCK, Identifier.of(FunMod.MOD_ID, name), block);
    }
    private static Block registerWithItem(String name, Block block, Item.Settings settings){
        Block registered = registerBlock(name, block);
        ModItems.registerItem(name, new BlockItem(registered, settings));
        return registered;
    }
    private static Block registerWithItem(String name, Block block){
        return registerWithItem(name, block, new Item.Settings());
    }

    public static void registerModBlock() {
        FunMod.LOGGER.info("Registering Mod Block for" + FunMod.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(SECRET_BLOCK);
        });
    }
}
