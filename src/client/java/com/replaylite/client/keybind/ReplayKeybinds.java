package com.replaylite.client.keybind;

import com.replaylite.client.recording.RecordingManager;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.option.KeyBinding.Category;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;
import net.minecraft.util.Identifier;

public class ReplayKeybinds {

    private static KeyBinding toggleRecordingKey;

    public static void register() {

        toggleRecordingKey = KeyBindingHelper.registerKeyBinding(
                new KeyBinding(
                        "key.replaylite.toggle_recording",
                        InputUtil.Type.KEYSYM,
                        GLFW.GLFW_KEY_F8,
                        Category.create(Identifier.of("replaylite", "general"))
                )
        );

        ClientTickEvents.END_CLIENT_TICK.register(client -> {

            // This runs once every client tick (~20 times per second)
            RecordingManager.tick();

            while (toggleRecordingKey.wasPressed()) {

                if (RecordingManager.isRecording()) {
                    RecordingManager.stopRecording();
                } else {
                    RecordingManager.startRecording();
                }

                if (client.player != null) {

                    if (RecordingManager.isRecording()) {
                        client.player.sendMessage(
                                Text.literal("§a▶ Recording Started"),
                                false
                        );
                    } else {
                        client.player.sendMessage(
                                Text.literal("§c■ Recording Stopped"),
                                false
                        );
                    }
                }
            }
        });
    }
}