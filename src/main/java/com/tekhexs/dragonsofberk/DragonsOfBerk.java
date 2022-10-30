package com.tekhexs.dragonsofberk;

import com.tekhexs.dragonsofberk.init.ModItems;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(DragonsOfBerk.MOD_ID)
public class DragonsOfBerk
{
    public static final String MOD_ID = "dragonsofberk";
    public static final Logger LOGGER = LogManager.getLogger();
    public DragonsOfBerk() {
        //Misc
        IEventBus eventbus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        MinecraftForge.EVENT_BUS.register(this);
        eventbus.addListener(this::setup);

        //Registries
        ModItems.register(eventbus);

        //Config
    }
    private void setup(final FMLCommonSetupEvent event) {
    }
}