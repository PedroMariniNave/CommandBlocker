package com.zpedroo.commandblocker;

import com.zpedroo.commandblocker.listeners.PlayerGeneralListeners;
import com.zpedroo.commandblocker.utils.FileUtils;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandBlocker extends JavaPlugin {

    public void onEnable() {
        new FileUtils(this);

        registerListeners();
    }

    private void registerListeners() {
        getServer().getPluginManager().registerEvents(new PlayerGeneralListeners(), this);
    }
}