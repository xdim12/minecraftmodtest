package net.xdim12.funmod.material;

import net.minecraft.block.Block;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.xdim12.funmod.init.ModItems;

public class Materials implements ToolMaterial{
    public static final Materials INSTANCE = new Materials();
        @Override
        public int getDurability() {
            return 1000;
        }

        @Override
        public float getMiningSpeedMultiplier() {
            return 20.0F;
        }

        @Override
        public float getAttackDamage() {
            return 10.0F;
        }


        @Override
        public TagKey<Block> getInverseTag() {
            return BlockTags.INCORRECT_FOR_NETHERITE_TOOL;
        }

        @Override
        public int getEnchantability() {
            return 22;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.ofItems(ModItems.FIRE_SWORD, Items.POTATO);

    }
}
