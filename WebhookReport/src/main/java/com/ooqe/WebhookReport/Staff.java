package com.ooqe.WebhookReport;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

public class Staff {
    private static final String TAG = "staff";

    public static boolean isStaff(Player player) {
        return player.getScoreboardTags().contains(TAG);
    }

    public static Set<Player> getStaff() {
        Set<Player> taggedStaff = new HashSet<>();
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.getScoreboardTags().contains(TAG)) {
                taggedStaff.add(player);
            }
        }
        return taggedStaff;
    }

    public static void send(String message) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.getScoreboardTags().contains(TAG)) {
                player.sendMessage(message);
            }
        }
    }
}
