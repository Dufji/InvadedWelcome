package com.dufji.invadedwelcome;

import com.dufji.invadedwelcome.Commands.CreditsCommand;
import com.dufji.invadedwelcome.Commands.buchCommand;
import com.dufji.invadedwelcome.Commands.resetCounterCommand;
import com.dufji.invadedwelcome.Events.UserJoinEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class InvadedWelcome extends JavaPlugin {
    @Override
    public void onEnable() {
        if (!getDataFolder().exists()) getDataFolder().mkdir();
        saveDefaultConfig();
        getCommand("credits").setExecutor(new CreditsCommand());
        getCommand("resetcounter").setExecutor(new resetCounterCommand());
        getCommand("buch").setExecutor(new buchCommand());
        Bukkit.getServer().getPluginManager().registerEvents(new UserJoinEvent(), this);
        if (this.getConfig().getInt("amount-joined") <= 0) {
            this.getConfig().set("amount-joined", 1);
            this.saveConfig();
            this.reloadConfig();
        }
        Bukkit.getLogger().info("[InvadedWelcome] InvadedWelcome is now ENABLED!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("[InvadedWelcome] InvadedWelcome has been DISABLED!");
    }
}
