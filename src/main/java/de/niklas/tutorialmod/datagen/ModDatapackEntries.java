package de.niklas.tutorialmod.datagen;

import de.niklas.tutorialmod.TutorialMod;
import de.niklas.tutorialmod.trims.ModTrimMaterials;
import de.niklas.tutorialmod.trims.ModTrimPatterns;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModDatapackEntries extends DatapackBuiltinEntriesProvider {
public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
        .add(Registries.TRIM_MATERIAL, ModTrimMaterials::bootstrap)
        .add(Registries.TRIM_PATTERN, ModTrimPatterns::bootstrap);


    public ModDatapackEntries(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(TutorialMod.MOD_ID));
    }
}
