package com.ooqe.WebhookReport;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ReportGUI {

    public static void open(Player player) {
        First.FirstBox = "Swearing";
        Second.SecondBox = "Cheating";
        Third.ThirdBox = "Bug Abuse";
        Fourth.FourthBox = "Dox";
        Fifth.FifthBox = "Inappropriate Skin";
        Inventory gui = Bukkit.createInventory(null, 9, ChatColor.BLUE + "Report Menu");

        ItemStack reportItemFirst = new ItemStack(Material.PAPER); // First
        ItemMeta metaFirst = reportItemFirst.getItemMeta();
        metaFirst.setDisplayName(ChatColor.RED + First.FirstBox);
        reportItemFirst.setItemMeta(metaFirst);
        gui.setItem(2, reportItemFirst);

        ItemStack reportItemSecond = new ItemStack(Material.TNT); // Second
        ItemMeta metaSecond = reportItemSecond.getItemMeta();
        metaSecond.setDisplayName(ChatColor.RED + Second.SecondBox);
        reportItemSecond.setItemMeta(metaSecond);
        gui.setItem(3, reportItemSecond);

        ItemStack reportItemThird = new ItemStack(Material.BEDROCK); // Third
        ItemMeta metaThird = reportItemThird.getItemMeta();
        metaThird.setDisplayName(ChatColor.RED + Third.ThirdBox);
        reportItemThird.setItemMeta(metaThird);
        gui.setItem(4, reportItemThird);

        ItemStack reportItemFourth = new ItemStack(Material.BROWN_DYE); // Fourth
        ItemMeta metaFourth = reportItemFourth.getItemMeta();
        metaFourth.setDisplayName(ChatColor.RED + Fourth.FourthBox);
        reportItemFourth.setItemMeta(metaFourth);
        gui.setItem(5, reportItemFourth);

        ItemStack reportItemFifth = new ItemStack(Material.SPIDER_SPAWN_EGG); // Fifth
        ItemMeta metaFifth = reportItemFifth.getItemMeta();
        metaFifth.setDisplayName(ChatColor.RED + Fifth.FifthBox);
        reportItemFifth.setItemMeta(metaFifth);
        gui.setItem(6, reportItemFifth);

        player.openInventory(gui);

        }

    }