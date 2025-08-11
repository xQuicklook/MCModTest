package de.niklas.tutorialmod.event;

import de.niklas.tutorialmod.TutorialMod;
import de.niklas.tutorialmod.entity.ModEntities;
import de.niklas.tutorialmod.entity.client.TomahawkProjectileModel;
import de.niklas.tutorialmod.entity.client.TriceratopsModel;
import de.niklas.tutorialmod.entity.custom.TriceratopsEntity;
import net.minecraft.world.entity.SpawnPlacementType;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(TriceratopsModel.LAYER_LOCATION, TriceratopsModel::createBodyLayer);
        event.registerLayerDefinition(TomahawkProjectileModel.LAYER_LOCATION, TomahawkProjectileModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){
        event.put(ModEntities.TRICERATOPS.get(), TriceratopsEntity.createAttributes().build());
    }

    @SubscribeEvent
    public static void registerSpawnPlacement(SpawnPlacementRegisterEvent event){
        event.register(ModEntities.TRICERATOPS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
    }
}
