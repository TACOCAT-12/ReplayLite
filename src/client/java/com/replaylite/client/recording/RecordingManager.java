package com.replaylite.client.recording;

import com.replaylite.ReplayLite;
import net.minecraft.client.MinecraftClient;

import java.util.ArrayList;
import java.util.List;

public class RecordingManager {

    private static boolean recording = false;

    private static final List<FrameData> frames = new ArrayList<>();

    public static void startRecording() {

        recording = true;
        frames.clear();

        ReplayLite.LOGGER.info("======================================");
        ReplayLite.LOGGER.info("Recording Started");
        ReplayLite.LOGGER.info("======================================");
    }

    public static void stopRecording() {

        recording = false;

        ReplayLite.LOGGER.info("======================================");
        ReplayLite.LOGGER.info("Recording Stopped");
        ReplayLite.LOGGER.info("Frames Captured: {}", frames.size());
        ReplayLite.LOGGER.info("======================================");
    }

    public static void tick() {

        if (!recording) {
            return;
        }

        MinecraftClient client = MinecraftClient.getInstance();

        if (client.player == null) {
            return;
        }

        frames.add(new FrameData(
                client.player.getX(),
                client.player.getY(),
                client.player.getZ(),
                client.player.getYaw(),
                client.player.getPitch(),
                System.currentTimeMillis()
        ));
    }

    public static boolean isRecording() {
        return recording;
    }

}