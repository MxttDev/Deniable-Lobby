package org.Deniable.Commands.Server;

import net.milkbowl.vault.chat.Chat;
import org.Deniable.Lobby;
import org.Deniable.Utils.Utils;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Spawn implements CommandExecutor {

    double X;
    double Y;
    double Z;

    Lobby plugin;
    private Chat chat = null;

    public Spawn(Lobby main, Chat chat) {
        this.plugin = main;
        this.chat = chat;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Utils.playerConsleCheck(sender); // Check if player is not console.

        Player p = (Player) sender;

        if (args.length == 1){
            if (args[0].equals("set")) {
                if (p.hasPermission("Senior.Staff")) {
                    X = p.getLocation().getX();
                    Y = p.getLocation().getY();
                    Z = p.getLocation().getZ();
                    plugin.getConfig().set("System.Spawn.X", X);
                    plugin.getConfig().set("System.Spawn.Y", Y);
                    plugin.getConfig().set("System.Spawn.Z", Z);
                    plugin.saveConfig();
                    p.sendMessage(Utils.format(plugin.getConfig().getString("Commands.Spawn.Set")));
                }
            }
        } else {
            X = plugin.getConfig().getDouble("System.Spawn.X");
            Y = plugin.getConfig().getDouble("System.Spawn.Y");
            Z = plugin.getConfig().getDouble("System.Spawn.Z");

            p.teleport(new Location(p.getWorld(), X, Y, Z, 180, 0));
            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 3.0F, 0.5F);


        }
        return false;
    }


}
