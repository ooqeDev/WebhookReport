package com.ooqe.WebhookReport;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    @Override

    public void onEnable() {

        getCommand("Report").setExecutor(new ReportCommand());
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new ReportListener(), this);
        getLogger().info("Webhook Report Enabled");

    }

    @Override

    public void onDisable() {

        getLogger().info("Webhook Report Disabled");

    }
}