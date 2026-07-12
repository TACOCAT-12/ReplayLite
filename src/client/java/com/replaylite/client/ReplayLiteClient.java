package com.replaylite.client;

import com.replaylite.ReplayLite;
import net.fabricmc.api.ClientModInitializer;

public class ReplayLiteClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ReplayLite.LOGGER.info("Client initialization complete.");
    }
}