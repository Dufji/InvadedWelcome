package com.dufji.welcomeplus.Commands;

import com.dufji.welcomeplus.WelcomePlus;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class CreditsCommand implements CommandExecutor {
    private final Plugin plugin = WelcomePlus.getPlugin(WelcomePlus.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        player.sendMessage(
                ChatColor.GRAY + "--------------" + ChatColor.AQUA + ChatColor.BOLD + plugin.getName() + ChatColor.GRAY + "----------\n" + ChatColor.RESET + "" +
                        ChatColor.GRAY + "Written By: " + ChatColor.AQUA + "Dufji" + ChatColor.RESET + "\n" +
                        ChatColor.GRAY + "Github: " + ChatColor.AQUA + "https://www.github.com/Dufji" + ChatColor.RESET + "\n" +
                        ChatColor.RED + "You" + ChatColor.WHITE + "Tube: " + ChatColor.AQUA + "https://www.youtube.com/c/Dufji" + ChatColor.RESET + "\n" +
                        ChatColor.GRAY + "--------------------------------------"
        );

        return true;
    }
}
