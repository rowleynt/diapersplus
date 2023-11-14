package net.dungdealers.diapersplus;

import net.dungdealers.diapersplus.DPItems.DPItems;
import net.dungdealers.diapersplus.DPStatusEffects.DPStatusEffects;
import net.fabricmc.api.ModInitializer;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DiapersPlus implements ModInitializer {
	public static final String MOD_ID = "diapersplus";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final Identifier PISSING_SOUND = new Identifier("diapersplus:pissingsound");
	public static SoundEvent PISSING_SOUND_EVENT = SoundEvent.of(PISSING_SOUND);

	@Override
	public void onInitialize() {
		LOGGER.info("poop");
		DPItems.registerModItems();
		DPStatusEffects.registerModStatusEffects();
	}
}