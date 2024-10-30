package com.bulain.flyway.database;

import org.flywaydb.core.api.FlywayException;
import org.flywaydb.core.extensibility.PluginMetadata;
import org.flywaydb.core.internal.util.FileUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Ext Database Extension.
 */
public class ExtDatabaseExtension implements PluginMetadata {

    public String getDescription() {
        return "Ext database support " + readVersion();
    }

    private static String readVersion() {
        try {
            return FileUtils.copyToString(
                    ExtDatabaseExtension.class.getClassLoader().getResourceAsStream("com/bulain/flyway/database/version.txt"),
                    StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new FlywayException("Unable to read extension version: " + e.getMessage(), e);
        }
    }
}