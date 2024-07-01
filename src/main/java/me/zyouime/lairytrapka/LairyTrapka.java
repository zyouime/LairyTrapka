package me.zyouime.lairytrapka;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class LairyTrapka implements ModInitializer {

    public static boolean itemRenderer;

    @Override
    public void onInitialize() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (key.wasPressed()) {
                itemRenderer = !itemRenderer;
            }
        });
    }

    private static final KeyBinding key = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key.lairytrapka.bind",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_G,
            "key.category.lairytrapka.category"
    ));
}
