package org.Deniable.Commands.Player;

import net.milkbowl.vault.chat.Chat;
import org.Deniable.Lobby;
import org.Deniable.Utils.Utils;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class gms implements CommandExecutor {
    Lobby plugin;
    private Chat chat = null;

    public gms(Lobby main, Chat chat) {
        this.plugin = main;
        this.chat = chat;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Utils.playerConsleCheck(sender); // Check if player is not console.

        Player p = (Player) sender;

        if (p.hasPermission("Lobby.gamemode")) {
            p.setGameMode(GameMode.SURVIVAL);
            p.sendMessage(Utils.format("&bYour gamemode has been updated to &3Survival&b!"));
        } else {
            p.sendMessage(Utils.format("&cInsufficient Permissions!"));
        }
        return false;
    }

}


