package de.niklas.tutorialmod.item.custom;

import de.niklas.tutorialmod.entity.ModEntities;
import de.niklas.tutorialmod.entity.custom.RadiationProjectileEntity;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class RadiationStaffItem extends Item {
    public RadiationStaffItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (!level.isClientSide) {
            RadiationProjectileEntity projectile = new RadiationProjectileEntity(ModEntities.RADIATION_PROJECTILE.get(), level);
            projectile.setOwner(player);
            projectile.setPos(player.getX(), player.getEyeY() - 0.1, player.getZ());
            projectile.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 0.5F);

            level.addFreshEntity(projectile);

            level.playSound(null, player.getX(), player.getY(), player.getZ(),
                    SoundEvents.BLAZE_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F);

            // Optional: Cooldown
            player.getCooldowns().addCooldown(this, 20);
        }

        player.swing(hand, true);
        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }
}
