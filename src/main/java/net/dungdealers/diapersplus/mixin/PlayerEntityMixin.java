package net.dungdealers.diapersplus.mixin;

import net.dungdealers.diapersplus.DPStatusEffects.DPStatusEffects;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.*;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {
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
    private boolean isPissing() {
        return this.hasStatusEffect(DPStatusEffects.PISSING);
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
}
