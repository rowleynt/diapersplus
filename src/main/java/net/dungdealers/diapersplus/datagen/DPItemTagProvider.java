package net.dungdealers.diapersplus.datagen;

import net.dungdealers.diapersplus.util.DPTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class DPItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public DPItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }
    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(DPTags.DPItemTags.DUMMY_ITEM_TAG)
                .add(Items.STICK);
    }
}
