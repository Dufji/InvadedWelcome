package com.dufji.welcomeplus;

import com.dufji.welcomeplus.Commands.CreditsCommand;
import com.dufji.welcomeplus.Commands.BuchCommand;
import com.dufji.welcomeplus.Commands.ResetCounterCommand;
import com.dufji.welcomeplus.Events.UserJoinEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class WelcomePlus extends JavaPlugin {
    @Override
    public void onEnable() {
        if (!getDataFolder().exists()) getDataFolder().mkdir();
        saveDefaultConfig();
        getCommand("credits").setExecutor(new CreditsCommand());
        getCommand("resetcounter").setExecutor(new ResetCounterCommand());
        getCommand("buch").setExecutor(new BuchCommand());
        Bukkit.getServer().getPluginManager().registerEvents(new UserJoinEvent(), this);
        if (this.getConfig().getInt("amount-joined") <= 0) {
            this.getConfig().set("amount-joined", 1);
            this.saveConfig();
            this.reloadConfig();
        }
        Bukkit.getLogger().info("[Welcome+] WelcomePLUS is now ENABLED!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("[Welcome+] WelcomePLUS has been DISABLED!");
    }
}
