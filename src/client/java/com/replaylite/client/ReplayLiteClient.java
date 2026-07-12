package com.replaylite.client;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReplayLiteClient implements ClientModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger("ReplayLite");

    @Override
    public void onInitializeClient() {
        LOGGER.info("======================================");
        LOGGER.info("ReplayLite has loaded successfully!");
        LOGGER.info("Version: v0.1.0-alpha");
        LOGGER.info("======================================");
    }
}