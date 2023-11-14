package net.dungdealers.diapersplus.datagen;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.data.DataOutput;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;

public class DPRecipeProvider extends RecipeProvider {
    public DPRecipeProvider(DataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {

    }
}
