package net.dungdealers.diapersplus.datagen;

import net.dungdealers.diapersplus.util.DPTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class DPBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public DPBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(DPTags.DPBlockTags.DUMMY_BLOCK_TAG)
                .add(Blocks.DIRT);
    }
}
