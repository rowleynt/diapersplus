package net.dungdealers.diapersplus;

import net.dungdealers.diapersplus.datagen.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class DiapersPlusDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(DPBlockTagProvider::new);
		pack.addProvider(DPItemTagProvider::new);
		pack.addProvider(DPModelProvider::new);
		pack.addProvider((FabricDataGenerator.Pack.Factory<DPRecipeProvider>) DPRecipeProvider::new);
		pack.addProvider(DPLootTableProvider::new);
	}
}
