package net.dungdealers.diapersplus.DPStatusEffects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class PissingStatusEffect extends StatusEffect {
    public PissingStatusEffect() {
        super(
                StatusEffectCategory.HARMFUL,
                0xCCDA19);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        //Does not work
        entity.setMovementSpeed(0);
    }
}
