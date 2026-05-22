package be.isach.ultracosmetics.config;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.Arrays;
import java.util.List;

public abstract class CustomConfiguration extends YamlConfiguration {
    @Override
    public void addDefault(String path, Object defaultValue) {
        if (!contains(path)) {
            set(path, defaultValue);
        }
    }

    public void addDefault(String path, Object defaultValue, String... comments) {
        addDefault(path, defaultValue, Arrays.asList(comments));
    }

    public void addDefault(String path, Object defaultValue, List<String> comments) {
        if (!contains(path)) {
            set(path, defaultValue, comments);
        }
    }

    public abstract ConfigurationSection createSection(String path, String... comments);

    public void set(String path, Object value, String... comments) {
        set(path, value, Arrays.asList(comments));
    }

    public abstract void set(String path, Object value, List<String> comments);

    public abstract List<String> comments(String path);
}
