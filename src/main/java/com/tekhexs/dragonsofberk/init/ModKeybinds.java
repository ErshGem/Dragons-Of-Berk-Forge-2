package com.tekhexs.dragonsofberk.init;

import com.mojang.blaze3d.platform.InputConstants;
import com.tekhexs.dragonsofberk.DragonsOfBerk;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.ClientRegistry;

public class ModKeybinds {
    public static KeyMapping DRAGON_DESCEND;

    public static void init() {
        DRAGON_DESCEND = registerKey("descend", "key.category." + DragonsOfBerk.MOD_ID, InputConstants.KEY_Z);
    }

    private static KeyMapping registerKey(String name, String category, int keycode) {
        KeyMapping key = new KeyMapping("key." + DragonsOfBerk.MOD_ID + "." + name, keycode, category);
        ClientRegistry.registerKeyBinding(key);
        return key;
    }
}