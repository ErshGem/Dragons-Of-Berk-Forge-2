package com.tekhexs.dragonsofberk.events;

import com.tekhexs.dragonsofberk.DragonsOfBerk;
import com.tekhexs.dragonsofberk.client.render.RenderDeadlyNadder;
import com.tekhexs.dragonsofberk.client.render.RenderMonstrousNightmare;
import com.tekhexs.dragonsofberk.client.render.RenderZippleback;
import com.tekhexs.dragonsofberk.init.ModEntities;
import com.tekhexs.dragonsofberk.init.ModKeybinds;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = DragonsOfBerk.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetup {
    public static void clientSetup(FMLClientSetupEvent event) {
        //ModKeybinds.init();
        //Items
    }

    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.MONSTROUS_NIGHTMARE.get(), RenderMonstrousNightmare::new);
        event.registerEntityRenderer(ModEntities.DEADLY_NADDER.get(), RenderDeadlyNadder::new);
        event.registerEntityRenderer(ModEntities.ZIPPLEBACK.get(), RenderZippleback::new);
    }
}
