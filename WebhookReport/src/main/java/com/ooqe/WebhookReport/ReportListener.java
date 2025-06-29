package com.ooqe.WebhookReport;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.ItemStack;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URI;

public class ReportListener implements Listener {

    private final String WEBHOOK_URL = "Paste your webhook link here :3";

    @EventHandler

    public void onInventoryClick(InventoryClickEvent event) {

        if (!(event.getWhoClicked() instanceof Player))
            return;

        Player player = (Player) event.getWhoClicked();
        event.setCancelled(true);
        ItemStack clicked = event.getCurrentItem();
        String displayName = ChatColor.stripColor(clicked.getItemMeta().getDisplayName());

        if (!event.getView().getTitle().equals(ChatColor.BLUE + "Report Menu"))
            return;

        if (clicked == null || !clicked.hasItemMeta())
            return;

        if (displayName.startsWith(First.FirstBox)) {
            player.closeInventory();
            String reportedName = ReportTarget.targetName;
            String reporterName = player.getName();
            player.sendMessage(ChatColor.GREEN + "You reported " + ChatColor.YELLOW + reportedName + ChatColor.RED + " for " + First.FirstBox);
            Staff.send(ChatColor.BLUE + "<WebhookReport> " + ChatColor.RED + reporterName +  " reported "  + reportedName + " for " + First.FirstBox);
            sendToWebhook("**" + reporterName + "** reported **" + reportedName + " for " + First.FirstBox + "**");
        }

        if (displayName.startsWith(Second.SecondBox)) {

            player.closeInventory();
            String reportedName = ReportTarget.targetName;
            String reporterName = player.getName();
            player.sendMessage(ChatColor.GREEN + "You reported " + ChatColor.YELLOW + reportedName + ChatColor.RED + " for " + Second.SecondBox);
            Staff.send(ChatColor.BLUE + "<WebhookReport> " + ChatColor.RED + reporterName + " reported " + reportedName + " for " + Second.SecondBox);
            sendToWebhook("**" + reporterName + "** reported **" + reportedName + " for " + Second.SecondBox + "**");

        }

        if (displayName.startsWith(Third.ThirdBox)) {

            player.closeInventory();
            String reportedName = ReportTarget.targetName;
            String reporterName = player.getName();
            player.sendMessage(ChatColor.GREEN + "You reported " + ChatColor.YELLOW + reportedName + ChatColor.RED + " for " + Third.ThirdBox);
            Staff.send(ChatColor.BLUE + "<WebhookReport> " +  ChatColor.RED + reporterName + " reported " + reportedName + " for " + Third.ThirdBox);
            sendToWebhook("**" + reporterName + "** reported **" + reportedName + " for " + Third.ThirdBox + "**");

        }

        if (displayName.startsWith(Fourth.FourthBox)) {

            player.closeInventory();
            String reportedName = ReportTarget.targetName;
            String reporterName = player.getName();
            player.sendMessage(ChatColor.GREEN + "You reported " + ChatColor.YELLOW + reportedName + ChatColor.RED + " for " + Fourth.FourthBox);
            Staff.send(ChatColor.BLUE + "<WebhookReport> " +  ChatColor.RED + reporterName + " reported " + reportedName + " for " + Fourth.FourthBox);
            sendToWebhook("**" + reporterName + "** reported **" + reportedName + " for " + Fourth.FourthBox + "**");

        }

        if (displayName.startsWith(Fifth.FifthBox)) {

            player.closeInventory();
            String reportedName = ReportTarget.targetName;
            String reporterName = player.getName();
            player.sendMessage(ChatColor.GREEN + "You reported " + ChatColor.YELLOW + reportedName + ChatColor.RED + " for " + Fifth.FifthBox);
            Staff.send(ChatColor.BLUE + "<WebhookReport> " +  ChatColor.RED + reporterName + " reported " + reportedName + " for " + Fifth.FifthBox);
            sendToWebhook("**" + reporterName + "** reported **" + reportedName + " for " + Fifth.FifthBox + "**");

        }
    }

    @EventHandler

    public void onInventoryDrag(InventoryDragEvent event) {

        if (!(event.getWhoClicked() instanceof Player)) return;
        Player player = (Player) event.getWhoClicked();
        if (!event.getView().getTitle().equals(ChatColor.BLUE + "Report Menu")) return;
        event.setCancelled(true);
    }

    private void sendToWebhook(String content) {

        try {

            URI uri = URI.create(WEBHOOK_URL);
            URL url = uri.toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);
            String jsonPayload = "{\"content\": \"" + content + "\"}";

            try (OutputStream os = connection.getOutputStream()) {

                byte[] input = jsonPayload.getBytes("utf-8");
                os.write(input, 0, input.length);

            }

            connection.getResponseCode();
            connection.disconnect();

        }

        catch (Exception e) {
            e.printStackTrace();

        }
    }
}
