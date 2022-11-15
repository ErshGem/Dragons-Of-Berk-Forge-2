package com.tekhexs.dragonsofberk;

import net.minecraftforge.common.ForgeConfigSpec;

public class DOBConfig {
    static final ForgeConfigSpec CLIENT;
    static final ForgeConfigSpec COMMON;
    static final ForgeConfigSpec SERVER;

    private static final ForgeConfigSpec.BooleanValue CAMERA_FLIGHT;
    public static boolean cameraFlight()
    {
        return CAMERA_FLIGHT.get();
    }

    static // common
    {
        var configurator = new ForgeConfigSpec.Builder();

        COMMON = configurator.build();
    }

    static // server
    {
        var configurator = new ForgeConfigSpec.Builder();

        SERVER = configurator.build();
    }

    static // client
    {
        var configurator = new ForgeConfigSpec.Builder();

        CAMERA_FLIGHT = configurator.comment("Should flight controls use the game camera (true) or vertical keybinds? (false)")
                .define("camera_flight_controls", true);

        CLIENT = configurator.build();
    }
}
