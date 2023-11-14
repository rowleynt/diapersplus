package net.dungdealers.diapersplus.DPStatusEffects;

import net.dungdealers.diapersplus.Diapers;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.sound.SoundCategory;

public class PissingStatusEffect extends StatusEffect {
    private double pissingSpotX = 0;
    private double pissingSpotY = 0;
    private double pissingSpotZ = 0;
    private boolean isPlaying = false;



    public double getPissingSpotX() {
        return pissingSpotX;
    }

    public double getPissingSpotY() {
        return pissingSpotY;
    }

    public double getPissingSpotZ() {
        return pissingSpotZ;
    }

    public boolean getIsPlaying() {
        return isPlaying;
    }

    public void setPissingSpotX(double x) {
        pissingSpotX = x;
    }

    public void setPissingSpotY(double y) {
        pissingSpotY = y;
    }

    public void setPissingSpotZ(double z) {
        pissingSpotZ = z;
    }

    public void setIsPlaying(boolean playing) {
        isPlaying = playing;
    }

    public PissingStatusEffect() {
        super(
                StatusEffectCategory.HARMFUL,
                0xCCDA19);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        if (!getIsPlaying()) {
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
        if (entity.isOnGround()) {
            entity.setVelocity(0, 0, 0);
            if (getPissingSpotX() == 0 && getPissingSpotY() == 0 && getPissingSpotZ() == 0) {
                setPissingSpotX(entity.getX());
                setPissingSpotY(entity.getY());
                setPissingSpotZ(entity.getZ());
            }
            entity.teleport(getPissingSpotX(), getPissingSpotY(), getPissingSpotZ());

            if (!getIsPlaying() && !entity.getWorld().isClient) {
                entity.getWorld().playSound(
                    null,
                    entity.getBlockPos(),
                    Diapers.PISSING_SOUND_EVENT,
                    SoundCategory.AMBIENT,
                    1f,
                    1f
                );
                setIsPlaying(true);
            }
        }
    }
}
