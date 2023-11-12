package net.dungdealers.diapersplus.DPItems;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.dungdealers.diapersplus.Diapers;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class DPItems {
    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));


    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries){
        entries.add(RUBY);
    }
                                                         //make a dummy item
    private static Item registerItem (String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Diapers.MOD_ID, name), item);
    }
    public static void registerModItems() {
        //TutorialMod and TutorialMod = Diapers for us
      Diapers.LOGGER.info("Registering Mod Items for " + Diapers.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(DPItems::addItemsToIngredientTabItemGroup);
            }
    }

