package net.dungdealers.diapersplus;

import net.dungdealers.diapersplus.DPItems.DPItems;
import net.dungdealers.diapersplus.DPItems.DPItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Diapers implements ModInitializer {
	public static final String MOD_ID = "diapersplus";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("poop");
		DPItems.registerModItems();

	}
}