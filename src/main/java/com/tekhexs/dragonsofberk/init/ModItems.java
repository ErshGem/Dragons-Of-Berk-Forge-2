package com.tekhexs.dragonsofberk.init;

import com.tekhexs.dragonsofberk.DragonsOfBerk;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, DragonsOfBerk.MOD_ID);

    public static final RegistryObject<Item> CRAB = ITEMS.register( "crab",
            () -> new Item (new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static void register(IEventBus eventBus){ITEMS.register(eventBus);}

    private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
        return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }
}
