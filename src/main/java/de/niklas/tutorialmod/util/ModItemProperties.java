package de.niklas.tutorialmod.util;

import de.niklas.tutorialmod.TutorialMod;
import de.niklas.tutorialmod.component.ModDateComponentTypes;
import de.niklas.tutorialmod.item.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.MaceItem;

public class ModItemProperties {
    public static void addCustomItemProperties(){
        ItemProperties.register(ModItems.CHISEL.get(), ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "used"),
                (itemStack, clientLevel, livingEntity, i) -> itemStack.get(ModDateComponentTypes.COORDINATES.get()) != null ? 1f :0f);
    }
}
