package com.replaylite;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReplayLite implements ModInitializer {

    public static final String MOD_ID = "replaylite";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("======================================");
        LOGGER.info("ReplayLite initialized successfully!");
        LOGGER.info("Common initialization complete.");
        LOGGER.info("======================================");
    }

    public static Identifier id(String path) {
        return Identifier.of(MOD_ID, path);
    }
}