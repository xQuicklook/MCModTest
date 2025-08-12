package de.niklas.tutorialmod.entity.client;

import de.niklas.tutorialmod.entity.ModEntities;
import de.niklas.tutorialmod.entity.custom.ChairEntity;
import de.niklas.tutorialmod.entity.custom.RadiationProjectileEntity;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.EntityRenderersEvent;

public class RadiationStaffRenderer extends EntityRenderer<RadiationProjectileEntity> {
    public RadiationStaffRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
    }

    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer(ModEntities.RADIATION_PROJECTILE.get(), RadiationStaffRenderer::new);
    }

    @Override
    public ResourceLocation getTextureLocation(RadiationProjectileEntity pEntity) {
        return null;
    }

    @Override
    public boolean shouldRender(RadiationProjectileEntity pLivingEntity, Frustum pCamera, double pCamX, double pCamY, double pCamZ) {
        return true;
    }
}
