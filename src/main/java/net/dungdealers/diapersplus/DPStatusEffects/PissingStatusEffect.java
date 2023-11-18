package net.dungdealers.diapersplus.DPStatusEffects;

import net.dungdealers.diapersplus.DiapersPlus;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.sound.SoundCategory;

public class PissingStatusEffect extends StatusEffect {
    private double pissingSpotX = 0;
    private double pissingSpotY = 0;
    private double pissingSpotZ = 0;
    private boolean isPlaying = false;

    public boolean getIsPlaying() { return isPlaying; }

    public void setPissingSpotX(double x) { pissingSpotX = x; }

    public void setPissingSpotY(double y) { pissingSpotY = y; }

    public void setPissingSpotZ(double z) { pissingSpotZ = z; }

    public void setIsPlaying(boolean playing) {
        isPlaying = playing;
    }

    public PissingStatusEffect() { super(StatusEffectCategory.HARMFUL, 0xCCDA19); }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        if (getIsPlaying()) {
            new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        setIsPlaying(false);
                        setPissingSpotX(0);
                        setPissingSpotY(0);
                        setPissingSpotZ(0);
                    }
                },
                (long) duration * 50
            );
        }
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (!getIsPlaying() && !entity.getWorld().isClient) {
            entity.getWorld().playSound(
                null,
                entity.getBlockPos(),
                DiapersPlus.PISSING_SOUND_EVENT,
                SoundCategory.AMBIENT,
                1f,
                1f);
            setIsPlaying(true);
        }
    }
}
