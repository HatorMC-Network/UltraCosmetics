package be.isach.ultracosmetics.config;

import org.bukkit.configuration.ConfigurationSection;

import java.util.Arrays;
import java.util.List;

// to be used on 1.18.1 and above, where Spigot supports comment preservation
public class AutoCommentConfiguration extends CustomConfiguration {

    @Override
    public void set(String path, Object value, List<String> comments) {
        set(path, value);
        setComments(path, comments);
    }

    @Override
    public ConfigurationSection createSection(String path, String... comments) {
        ConfigurationSection section = createSection(path);
        setComments(path, Arrays.asList(comments));
        return section;
    }

    @Override
    public List<String> comments(String path) {
        return getComments(path);
    }

}
