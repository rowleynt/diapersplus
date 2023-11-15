package net.dungdealers.diapersplus.DPStatusEffects;

import net.dungdealers.diapersplus.DiapersPlus;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class DPStatusEffects {
    public static final StatusEffect PISSING = new PissingStatusEffect();

    public static void registerModStatusEffects() {
        DiapersPlus.LOGGER.info("Registering Mod Status Effects for " + DiapersPlus.MOD_ID);
        PISSING.addAttributeModifier(
                EntityAttributes.GENERIC_MOVEMENT_SPEED,
                "91AEAA56-376B-4498-935B-2F7F68070635",
                -10.0f,
                EntityAttributeModifier.Operation.ADDITION
        ).addAttributeModifier(
                EntityAttributes.GENERIC_ATTACK_DAMAGE,
                "648D7064-6A60-4F59-8ABE-C2C23A6DD7A9",
                -5.0f,
                EntityAttributeModifier.Operation.ADDITION
        );
        Registry.register(Registries.STATUS_EFFECT, new Identifier(DiapersPlus.MOD_ID, "pissing"), PISSING);
        Registry.register(Registries.SOUND_EVENT, DiapersPlus.PISSING_SOUND, DiapersPlus.PISSING_SOUND_EVENT);
    }
}
