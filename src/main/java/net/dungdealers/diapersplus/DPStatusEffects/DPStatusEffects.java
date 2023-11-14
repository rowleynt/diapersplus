package net.dungdealers.diapersplus.DPStatusEffects;

import net.dungdealers.diapersplus.DiapersPlus;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class DPStatusEffects {
    public static final StatusEffect PISSING = new PissingStatusEffect();

    public static void registerModStatusEffects() {
        DiapersPlus.LOGGER.info("Registering Mod Status Effects for " + DiapersPlus.MOD_ID);
        Registry.register(Registries.STATUS_EFFECT, new Identifier(DiapersPlus.MOD_ID, "pissing"), PISSING);
        Registry.register(Registries.SOUND_EVENT, DiapersPlus.PISSING_SOUND, DiapersPlus.PISSING_SOUND_EVENT);
    }
}
