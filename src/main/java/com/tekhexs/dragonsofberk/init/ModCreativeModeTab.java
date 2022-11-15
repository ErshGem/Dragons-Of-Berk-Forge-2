package com.tekhexs.dragonsofberk.init;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab
{
    public static final CreativeModeTab DOB_ITEMS = new CreativeModeTab("dob_items") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.DRAGON_NIP.get());
        }
    };

    public static final CreativeModeTab DOB_SPAWNS = new CreativeModeTab("dob_spawns") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.NIGHTMARE_SPAWN_EGG.get());
        }
    };
}