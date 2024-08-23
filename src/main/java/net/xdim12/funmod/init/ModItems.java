package net.xdim12.funmod.init;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.xdim12.funmod.FunMod;
import net.xdim12.funmod.List.FoodList;
import net.xdim12.funmod.material.Materials;


public class ModItems {
//    public static final Item FIRE_SWORD = registerItem("fire_sword", new Fire_Sword(new Item.Settings()));
    public static final Item FIRE_SWORD = registerItem("fire_sword", new SwordItem(Materials.INSTANCE, new Item.Settings().attributeModifiers(
            SwordItem.createAttributeModifiers(Materials.INSTANCE, 100, -1.4F))));
    public static final Item FIRE_AXE = registerItem("fire_axe", new Item(new Item.Settings().maxCount(16)));
    public static final Item COCAINE = registerItem("cocaine", new Item(new Item.Settings().food(FoodList.COCAINE_LIST).maxCount(64)));


    public static Item registerItem(String name, Item  item) {
        return Registry.register(Registries.ITEM, Identifier.of(FunMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        FunMod.LOGGER.info("Registering Mod Items for" + FunMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(FIRE_SWORD);
            entries.add(FIRE_AXE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(COCAINE);
        });
    }
}
