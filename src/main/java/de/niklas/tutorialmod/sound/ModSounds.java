package de.niklas.tutorialmod.sound;

import de.niklas.tutorialmod.TutorialMod;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, TutorialMod.MOD_ID);

    public static final RegistryObject<SoundEvent> CHISEL_USE = registerSoundEvent("chisel_use");

    private static final RegistryObject<SoundEvent> MAGIC_BLOCK_BREAK = registerSoundEvent("magic_block_break");
    private static final RegistryObject<SoundEvent> MAGIC_BLOCK_STEP = registerSoundEvent("magic_block_step");
    private static final RegistryObject<SoundEvent> MAGIC_BLOCK_PLACE = registerSoundEvent("magic_block_place");
    private static final RegistryObject<SoundEvent> MAGIC_BLOCK_HIT = registerSoundEvent("magic_block_hit");
    private static final RegistryObject<SoundEvent> MAGIC_BLOCK_FALL = registerSoundEvent("magic_block_fall");

    public static final ForgeSoundType MAGIC_BLOCK_SOUNDS = new ForgeSoundType(1f, 1f, ModSounds.MAGIC_BLOCK_BREAK, ModSounds.MAGIC_BLOCK_STEP
            ,ModSounds.MAGIC_BLOCK_PLACE, ModSounds.MAGIC_BLOCK_HIT, ModSounds.MAGIC_BLOCK_FALL);

    public static final RegistryObject<SoundEvent> BAR_BRAWL = registerSoundEvent("bar_brawl");
    public static final ResourceKey<JukeboxSong> BAR_BRAWL_KEY = ResourceKey.create(Registries.JUKEBOX_SONG,
            ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "bar_brawl"));

    private static RegistryObject<SoundEvent> registerSoundEvent(String name){
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus){
        SOUND_EVENTS.register(eventBus);
    }
}
