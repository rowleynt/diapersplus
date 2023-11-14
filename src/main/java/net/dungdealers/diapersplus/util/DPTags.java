package net.dungdealers.diapersplus.util;

import net.dungdealers.diapersplus.DiapersPlus;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class DPTags {
    public static class DPBlockTags {
        public static final TagKey<Block> DUMMY_BLOCK_TAG = createTag("dummy_block_tag");
        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(DiapersPlus.MOD_ID, name));
        }
    }
    public static class DPItemTags {
        public static final TagKey<Item> DUMMY_ITEM_TAG = createTag("dummy_item_tag");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(DiapersPlus.MOD_ID, name));
        }
    }
}
