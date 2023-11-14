package net.dungdealers.diapersplus.DPStatusEffects;

import net.dungdealers.diapersplus.Diapers;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class DPStatusEffects {
    public static final StatusEffect PISSING = new PissingStatusEffect();

    public static void registerModStatusEffects() {
        Diapers.LOGGER.info("Registering Mod Status Effects for " + Diapers.MOD_ID);
        Registry.register(Registries.STATUS_EFFECT, new Identifier(Diapers.MOD_ID, "pissing"), PISSING);
        Registry.register(Registries.SOUND_EVENT, Diapers.PISSING_SOUND, Diapers.PISSING_SOUND_EVENT);
    }
}
