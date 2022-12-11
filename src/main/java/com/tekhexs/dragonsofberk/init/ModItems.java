package com.tekhexs.dragonsofberk.init;

import com.tekhexs.dragonsofberk.DragonsOfBerk;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, DragonsOfBerk.MOD_ID);

    public static final RegistryObject<Item> CRAB = ITEMS.register( "crab",
            () -> new Item (new Item.Properties().tab(ModCreativeModeTab.DOB_ITEMS)));
    public static final RegistryObject<Item> EEL = ITEMS.register( "eel",
            () -> new Item (new Item.Properties().tab(ModCreativeModeTab.DOB_ITEMS)));
    public static final RegistryObject<Item> DRAGON_NIP = ITEMS.register( "dragon_nip",
            () -> new Item (new Item.Properties().tab(ModCreativeModeTab.DOB_ITEMS)));

    public static final RegistryObject<Item> NIGHT_FURY_SCALE = ITEMS.register( "night_fury_scale",
            () -> new Item (new Item.Properties().tab(ModCreativeModeTab.DOB_ITEMS)));
    public static final RegistryObject<Item> DEADLY_NADDER_SCALE = ITEMS.register( "deadly_nadder_scale",
            () -> new Item (new Item.Properties().tab(ModCreativeModeTab.DOB_ITEMS)));
    public static final RegistryObject<Item> MONSTROUS_NIGHTMARE_SCALE = ITEMS.register( "monstrous_nightmare_scale",
            () -> new Item (new Item.Properties().tab(ModCreativeModeTab.DOB_ITEMS)));
    public static final RegistryObject<Item> GRONCKLE_SCALE = ITEMS.register( "gronckle_scale",
            () -> new Item (new Item.Properties().tab(ModCreativeModeTab.DOB_ITEMS)));

    public static final RegistryObject<Item> VALKA_STAFF = ITEMS.register( "valka_staff",
            () -> new Item (new Item.Properties().tab(ModCreativeModeTab.DOB_ITEMS)));
    public static final RegistryObject<Item> VIKING_AXE = ITEMS.register( "viking_axe",
            () -> new Item (new Item.Properties().tab(ModCreativeModeTab.DOB_ITEMS)));

    // spawn eggs
    public static final RegistryObject<ForgeSpawnEggItem> NIGHTMARE_SPAWN_EGG =
            ITEMS.register("monstrous_nightmare_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.MONSTROUS_NIGHTMARE,
                    0x6D1D08, 0xD86A12, new Item.Properties()
                    .tab(ModCreativeModeTab.DOB_SPAWNS)
                    .stacksTo(64)));
    public static final RegistryObject<ForgeSpawnEggItem> NADDER_SPAWN_EGG =
            ITEMS.register("deadly_nadder_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.DEADLY_NADDER,
                    0x00BFFF, 0xFFE400, new Item.Properties()
                    .tab(ModCreativeModeTab.DOB_SPAWNS)
                    .stacksTo(64)));
    public static final RegistryObject<ForgeSpawnEggItem> ZIPPLEBACK_SPAWN_EGG =
            ITEMS.register("zippleback_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.ZIPPLEBACK,
                    0x53804e, 0x7e3333, new Item.Properties()
                    .tab(ModCreativeModeTab.DOB_SPAWNS)
                    .stacksTo(64)));

    public static void register(IEventBus eventBus){ITEMS.register(eventBus);}

    private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
        return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }
}
