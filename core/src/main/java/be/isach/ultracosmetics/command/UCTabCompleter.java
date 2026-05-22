package be.isach.ultracosmetics.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UCTabCompleter implements TabCompleter {

    private final CommandManager cm;

    public UCTabCompleter(CommandManager cm) {
        this.cm = cm;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        List<String> options = new ArrayList<>();
        if (args.length <= 1) {
            for (SubCommand sc : cm.getCommands()) {
                if (sender.hasPermission(sc.getPermission())) {
                    options.add(sc.getName());
                }
            }
        } else {
            for (SubCommand sc : cm.getCommands()) {
                if (sc.getName().equalsIgnoreCase(args[0])) {
                    sc.tabComplete(sender, args, options);
                    break;
                }
            }
        }
        options.replaceAll(String::toLowerCase);
        Collections.sort(options);
        return StringUtil.copyPartialMatches(args[args.length - 1], options, new ArrayList<>());
    }
}
