package net.dungdealers.diapersplus.mixin;

import com.google.common.collect.Lists;
import net.dungdealers.diapersplus.DPStatusEffects.DPStatusEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerAbilities;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Util;
import net.minecraft.util.math.Box;
import net.minecraft.world.Difficulty;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;

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
