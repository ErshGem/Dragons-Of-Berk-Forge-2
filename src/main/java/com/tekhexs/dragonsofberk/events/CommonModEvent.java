package com.tekhexs.dragonsofberk.events;

import com.tekhexs.dragonsofberk.entity.EntityDeadlyNadder;
import com.tekhexs.dragonsofberk.entity.EntityMonstrousNightmare;
import com.tekhexs.dragonsofberk.init.ModEntities;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(*
        modid = "dragonsofberk",
        bus = Mod.EventBusSubscriber.Bus.MOD
)
public class CommonModEvent {
    public CommonModEvent() {
    }

    @SubscribeEvent
    public static void onAttributeCreate(EntityAttributeCreationEvent event) {
        event.put(ModEntities.MONSTROUS_NIGHTMARE.get(), EntityMonstrousNightmare.createAttributes().build());
        event.put(ModEntities.DEADLY_NADDER.get(), EntityDeadlyNadder.createAttributes().build());
    }
}
