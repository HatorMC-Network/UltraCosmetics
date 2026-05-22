package be.isach.ultracosmetics.config;

import org.bukkit.configuration.InvalidConfigurationException;

import java.io.IOException;

@FunctionalInterface
public interface FunctionalConfigLoader {
    public void load(CustomConfiguration config) throws IOException, InvalidConfigurationException;
}
