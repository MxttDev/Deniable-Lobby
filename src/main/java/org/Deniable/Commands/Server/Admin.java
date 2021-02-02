package org.Deniable.Commands.Server;

import net.milkbowl.vault.chat.Chat;
import org.Deniable.GUI.AdminGUI.AdminGUI;
import org.Deniable.Lobby;
import org.Deniable.Utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Admin implements CommandExecutor {

    Lobby plugin;
    private Chat chat = null;

    public Admin(Lobby main, Chat chat) {
        this.plugin = main;
        this.chat = chat;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Utils.playerConsleCheck(sender); // Check if player is not console.

        Player p = (Player) sender;

        if (p.hasPermission("Senior.Staff")) {
            AdminGUI.openAdminGUI(p);
        } else {
            p.sendMessage(ChatColor.RED+"Insufficient Permissions!");
        }
        return false;
    }



}
