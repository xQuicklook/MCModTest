package de.niklas.tutorialmod.entity.custom;

import de.niklas.tutorialmod.entity.ModEntities;
import de.niklas.tutorialmod.item.ModItems;
import de.niklas.tutorialmod.particle.ModParticles;
import net.minecraft.core.particles.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

public class RadiationProjectileEntity extends AbstractArrow {

    public RadiationProjectileEntity(EntityType<? extends RadiationProjectileEntity> type, Level level) {
        super(type, level);
    }

    /*public RadiationProjectileEntity(Level level, LivingEntity shooter) {
        super(ModEntities.RADIATION_PROJECTILE.get(), shooter, level);
    }*/

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);

        if (!this.level().isClientSide) {
            if (result.getEntity() instanceof LivingEntity living) {
                living.hurt(this.damageSources().magic(), 6.0F);
                living.addEffect(new MobEffectInstance(MobEffects.POISON, 100, 1));

                AreaEffectCloud cloud = new AreaEffectCloud(this.level(), this.getX(), this.getY(), this.getZ());
                cloud.setRadius(2.5F);
                cloud.setDuration(100); // 5 Sekunden
                cloud.setParticle(new DustParticleOptions(new Vector3f(0.0F, 1.0F, 0.0F), 1.0F));
                cloud.addEffect(new MobEffectInstance(MobEffects.POISON, 100, 1));

                this.level().addFreshEntity(cloud);
                this.discard();
            }
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);

        if (!this.level().isClientSide) {
            // Giftwolke erstellen
            AreaEffectCloud cloud = new AreaEffectCloud(this.level(), this.getX(), this.getY(), this.getZ());
            cloud.setRadius(2.5F);
            cloud.setDuration(100); // 5 Sekunden
            cloud.setParticle(new DustParticleOptions(new Vector3f(0.0F, 1.0F, 0.0F), 1.0F));
            cloud.addEffect(new MobEffectInstance(MobEffects.POISON, 100, 3));

            this.level().addFreshEntity(cloud);
            this.discard();
        }
    }

    @Override
    protected ItemStack getPickupItem() {
        return ItemStack.EMPTY; // Nicht aufsammelbar
    }

    @Override
    protected @NotNull ItemStack getDefaultPickupItem() {
        return null;
    }

}
