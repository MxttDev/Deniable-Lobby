package org.Deniable.GUI.CosmeticGUI.JoinMessages;

import org.Deniable.Lobby;
import org.Deniable.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PreviewJoinMessage {
    public static Lobby plugin = Lobby.getPlugin(Lobby.class);

    public static void PreviewMessage(String JoinMessage, Player p) {
        p.closeInventory();
        String name = Utils.getPrefix(p)+p.getName();
        String format = Utils.format(JoinMessage).replace("<Player>", name);

        p.sendMessage(Utils.format("&a "));
        p.sendMessage(Utils.format(format));
        p.sendMessage(Utils.format("&a "));

        Bukkit.getScheduler().runTaskLater(plugin, () -> CosmeticJoinM.openMainGUI(p), 20 * 3); // 3 SECONDS


    }

}
