package com.ooqe.WebhookReport;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReportCommand implements CommandExecutor {
    @Override

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (args.length == 0) {

            sender.sendMessage(ChatColor.RED + "Usage: /report <player>");
            return true;

        }


        Player target = Bukkit.getPlayer(args[0]);
        Player player = (Player) sender;

        if (target == null) {

            sender.sendMessage(ChatColor.RED + "Player not found.");
            return true;

        }

        if (target.getUniqueId().equals(player.getUniqueId())) {

            sender.sendMessage(ChatColor.RED + "You can't report yourself.");
            return true;

        }

        ReportName.playerName = player.getName();
        ReportTarget.targetName = target.getName();
        ReportGUI.open(player);
        return true;

    }
}
