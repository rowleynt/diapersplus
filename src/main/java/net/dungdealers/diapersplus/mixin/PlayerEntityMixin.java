package net.dungdealers.diapersplus.mixin;

import net.dungdealers.diapersplus.DPStatusEffects.DPStatusEffects;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity implements Random {
    @Shadow public abstract boolean isSpectator();

    @Shadow public abstract boolean isCreative();

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    /**
     * @author big large
     * A method to check whether the PlayerEntity has the pissing status effect.
     *
     * @return A boolean
     * @see some bitches
     */
    @Unique
    Random rand = Random.create();
    @Unique
    int randint;
    @Unique
    int tickCount = 0;
    @Final
    @Unique
    private final int PISSING_DURATION = 200;
    @Final
    @Unique
    private final int MAX_RANDOM_NUMBER = 1000000;
    @Unique
    StatusEffectInstance pissingStatus =
        new StatusEffectInstance(
            DPStatusEffects.PISSING,
            PISSING_DURATION,
            0,
            false,
            true
        );

    /**
     * @author big large
     *
     * Returns a boolean representing whether the player currently has the
     * pissing status.
     *
     * @return boolean for pissing status
     * @see a therapist
     */
    @Unique
    private boolean isPissing() {
        return this.hasStatusEffect(DPStatusEffects.PISSING);
    }

    /**
     * @author big large
     *
     * Generates a random number between 0 and the value of MAX_RANDOM_NUMBER. If the random
     * number is equal to 69 (the sex number), and the player is not currently pissing, then
     * apply the pissing status effect.
     *
     * @see you later alligator
     */
    @Unique
    private void tryAddPissingStatus() {
        randint = rand.nextBetween(0, MAX_RANDOM_NUMBER);
        if(randint == 69 && !this.isPissing() && (!this.isSpectator() && !this.isCreative()))
            this.addStatusEffect(pissingStatus);
    }

    /**
     * @author big large
     *
     * Overwrites the isImmobile method of the PlayerEntity class. If the player currently has
     * the pissing status effect (lol), this method will return True and will render the player
     * immobile.
     *
     * @reason funny
     * @return Parent class is immobile OR Player is sleeping OR Player is pissing
     * @see these nuts
     */
    @Overwrite
    public boolean isImmobile() {
        return super.isImmobile() || this.isSleeping() || this.isPissing();
    }

    @Inject(method="tick()V", at=@At("HEAD"))
    public void injectTick(CallbackInfo info) {
        this.tryAddPissingStatus();
    }
}
