package com.zpedroo.commandblocker.listeners;

import com.zpedroo.commandblocker.utils.FileUtils;
import com.zpedroo.commandblocker.utils.config.Messages;
import org.apache.commons.lang.StringUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class PlayerGeneralListeners implements Listener {

    @EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = true)
    public void onCommandPreProcess(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        String command = StringUtils.replace(event.getMessage().split(" ")[0], "/", "");
        if (command.contains(":")) {
            event.setCancelled(true);
            player.sendMessage(Messages.BLOCKED_COMMAND);
            return;
        }

        if (!FileUtils.get().getStringList(FileUtils.Files.CONFIG, "Blocked-Commands").contains(command)) return;
        if (FileUtils.get().getStringList(FileUtils.Files.CONFIG, "Whitelisted-Admins").contains(player.getName())) return;

        event.setCancelled(true);
        player.sendMessage(Messages.BLOCKED_COMMAND);
    }
}