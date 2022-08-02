package com.dufji.invadedwelcome.Events;

import com.dufji.invadedwelcome.InvadedWelcome;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;


public class UserJoinEvent implements Listener {
    private static Plugin plugin = InvadedWelcome.getPlugin(InvadedWelcome.class);

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        int playerCount = plugin.getConfig().getInt("amount-joined");
        String message = plugin.getConfig().getString("welcome-message")
                .replace("{player}", player.getDisplayName())
                .replace("{server}", plugin.getConfig().getString("server-name"))
                .replace("{uniqueJoined}", String.valueOf(playerCount));

        event.setJoinMessage(null); // Stopping the default join message from being sent.

        if(!event.getPlayer().hasPlayedBefore()) {
            Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', message));
            playerCount++;
            plugin.getConfig().set("amount-joined", playerCount);
            plugin.saveConfig();
            plugin.reloadConfig();
        }
    }

    @EventHandler
    public void onUserLeave(PlayerQuitEvent event) {
        event.setQuitMessage(null); // Stopping the default quit message from being sent.
        // Yeah?! I put the quit event in the user join event, what are you gonna do about it?
    }
}
