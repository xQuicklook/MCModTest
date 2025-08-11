package de.niklas.tutorialmod;

import com.mojang.logging.LogUtils;
import de.niklas.tutorialmod.block.ModBlocks;
import de.niklas.tutorialmod.block.entity.ModBlockEntities;
import de.niklas.tutorialmod.block.entity.renderer.PedestalBlockEntityRenderer;
import de.niklas.tutorialmod.component.ModDateComponentTypes;
import de.niklas.tutorialmod.effect.ModEffects;
import de.niklas.tutorialmod.enchantment.ModEnchantmentEffects;
import de.niklas.tutorialmod.entity.ModEntities;
import de.niklas.tutorialmod.entity.client.ChairRenderer;
import de.niklas.tutorialmod.entity.client.TomahawkProjectileRenderer;
import de.niklas.tutorialmod.entity.client.TriceratopsRenderer;
import de.niklas.tutorialmod.item.ModCreativeModeTabs;
import de.niklas.tutorialmod.item.ModItems;
import de.niklas.tutorialmod.loot.ModLootModifiers;
import de.niklas.tutorialmod.particle.AlexandriteParticles;
import de.niklas.tutorialmod.particle.ModParticles;
import de.niklas.tutorialmod.potion.ModPotions;
import de.niklas.tutorialmod.recipe.ModRecipes;
import de.niklas.tutorialmod.screen.ModMenuTypes;
import de.niklas.tutorialmod.screen.custom.GrowthChamberMenu;
import de.niklas.tutorialmod.screen.custom.GrowthChamberScreen;
import de.niklas.tutorialmod.screen.custom.PedestalScreen;
import de.niklas.tutorialmod.sound.ModSounds;
import de.niklas.tutorialmod.util.ModItemProperties;
import de.niklas.tutorialmod.villager.ModVillagers;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TutorialMod.MOD_ID)
public class TutorialMod {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "tutorialmod";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();


    public TutorialMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);


        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModDateComponentTypes.register(modEventBus);
        ModSounds.register(modEventBus);

        ModEffects.register(modEventBus);
        ModPotions.register(modEventBus);

        ModEnchantmentEffects.register(modEventBus);
        ModEntities.register(modEventBus);

        ModVillagers.register(modEventBus);
        ModParticles.register(modEventBus);

        ModLootModifiers.register(modEventBus);
        ModBlockEntities.register(modEventBus);

        ModMenuTypes.register(modEventBus);
        ModRecipes.register(modEventBus);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            ComposterBlock.COMPOSTABLES.put(ModItems.KOHLRABI.get(), 0.4f);
            ComposterBlock.COMPOSTABLES.put(ModItems.KOHLRABI_SEEDS.get(), 0.2f);
        });
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event){
    if(event.getTabKey() == CreativeModeTabs.INGREDIENTS){
        event.accept(ModItems.ALEXANDRITE);
        event.accept(ModItems.RAW_ALEXANDRITE);
    }
    if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS){
        event.accept(ModBlocks.ALEXANDRITE_BLOCK);
        event.accept(ModBlocks.RAW_ALEXANDRITE_BLOCK);
    }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            ModItemProperties.addCustomItemProperties();

            EntityRenderers.register(ModEntities.TRICERATOPS.get(), TriceratopsRenderer::new);
            EntityRenderers.register(ModEntities.TOMAHAWK.get(), TomahawkProjectileRenderer::new);

            EntityRenderers.register(ModEntities.CHAIR.get(), ChairRenderer::new);

            MenuScreens.register(ModMenuTypes.PEDESTAL_MENU.get(), PedestalScreen::new);
            MenuScreens.register(ModMenuTypes.GROWTH_CHAMBER_MENU.get(), GrowthChamberScreen::new);
        }

        @SubscribeEvent
        public static void registerParticleProvider(RegisterParticleProvidersEvent event){
            event.registerSpriteSet(ModParticles.ALEXANDRITE_PARTICLES.get(), AlexandriteParticles.Provider::new);
        }

        @SubscribeEvent
        public static void registerBER(EntityRenderersEvent.RegisterRenderers event){
            event.registerBlockEntityRenderer(ModBlockEntities.PEDESTAL_BE.get(), PedestalBlockEntityRenderer::new);
        }
    }
}
