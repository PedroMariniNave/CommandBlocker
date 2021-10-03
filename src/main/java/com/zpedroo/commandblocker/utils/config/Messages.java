package com.zpedroo.commandblocker.utils.config;

import com.zpedroo.commandblocker.utils.FileUtils;
import org.bukkit.ChatColor;

public class Messages {

    public static final String BLOCKED_COMMAND = getColored(FileUtils.get().getString(FileUtils.Files.CONFIG, "Messages.blocked-command"));

    private static String getColored(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }
}