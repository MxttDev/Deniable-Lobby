package org.Deniable;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import net.milkbowl.vault.chat.Chat;
import org.Deniable.Commands.Server.Admin;
import org.Deniable.Commands.Server.Spawn;
import org.Deniable.Events.Player.*;
import org.Deniable.Events.Player.Misc.Anti;
import org.Deniable.Events.Security.BlockBreak;
import org.Deniable.GUI.AdminGUI.AdminGUIManager;
import org.Deniable.GUI.CosmeticGUI.Glow.CosmeticGlowSET;
import org.Deniable.GUI.CosmeticGUI.JoinMessages.CosmeticJoinMInteract;
import org.Deniable.GUI.GUIManager;
import org.Deniable.Utils.ChatConfig;
import org.Deniable.Utils.Glow;
import org.Deniable.Utils.PlayerConfig;
import org.Deniable.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;

public class Lobby extends JavaPlugin implements Listener, PluginMessageListener {

    FileConfiguration config = getConfig();
    public Chat chat = null;

    @Override
    public void onEnable() {
        getLogger().info("Plugin has initiated.");

        config.options().copyDefaults(true);

        setupChat();

        setupCommands();
        setupEvents();

        updateScoreboard();

        ChatConfig.createChatConfig();


        getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            public void run() {
                for (Player a : getServer().getOnlinePlayers()) {
                    updateScoreboard();
                }
            }
        }, 1, 500);

    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin disabled!");
    }

    private void setupEvents() {
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new JoinBasics(this,chat), this);
        getServer().getPluginManager().registerEvents(new BlockBreak(), this);
        getServer().getPluginManager().registerEvents(new bossBar(this,chat),this);
        getServer().getPluginManager().registerEvents(new Tablist(this,chat),this);
        getServer().getPluginManager().registerEvents(new JoinMessages(this,chat),this);
        getServer().getPluginManager().registerEvents(new onChat(this,chat),this);
        getServer().getPluginManager().registerEvents(new PlayerConfig(this),this);
        getServer().getPluginManager().registerEvents(new JoinConfig(this,chat),this);
        getServer().getPluginManager().registerEvents(new Inventory(),this);
        getServer().getPluginManager().registerEvents(new Anti(this,chat),this);
        getServer().getPluginManager().registerEvents(new GUIManager(),this);
        getServer().getPluginManager().registerEvents(new CosmeticGlowSET(),this);
        getServer().getPluginManager().registerEvents(new CosmeticJoinMInteract(),this);

        getServer().getPluginManager().registerEvents(new AdminGUIManager(this,chat),this);

        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", this);
    }

    private void setupCommands() {
        this.getCommand("spawn").setExecutor(new Spawn(this, chat));
        this.getCommand("admin").setExecutor(new Admin(this,chat));
    }

    private boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        return chat != null;
    }

    public Chat getChat() {
        return chat;
    }

    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        if (!channel.equals("BungeeCord")) {
            return;
        }

        ByteArrayDataInput in = ByteStreams.newDataInput(message);
        String subchannel = in.readUTF();

        if (subchannel.equals("PlayerCount")) {
            String server = in.readUTF();
            Utils.count.put(server, in.readInt());

        }

    }

    public void ReloadTheConfig() {
        reloadConfig();
    }


    // EVENTS

    @EventHandler
    public void OnJoin(PlayerJoinEvent e) {
        updateScoreboard();
    }

    private void updateScoreboard() {
        for (Player a : Bukkit.getServer().getOnlinePlayers()) {
            org.bukkit.scoreboard.Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
            Objective obj = board.registerNewObjective("Main", "dummy", Utils.format( "&6&lDENIABLE"));
            obj.setDisplaySlot(DisplaySlot.SIDEBAR);

            Score a1 = obj.getScore(Utils.format("&e &a"));
            Score a2 = obj.getScore(Utils.format("Rank: &e"+Utils.getRank(a)));
            Score a3 = obj.getScore(Utils.format("Level: &e0"));
            Score a4 = obj.getScore(Utils.format("&e &b"));
            Score a5 = obj.getScore(Utils.format("Online: &e"+Utils.getServerCount(a, "ALL")));
            Score a6 = obj.getScore(Utils.format("&e "));
            Score a7 = obj.getScore(Utils.format("&eplay.deniable.net"));

            a1.setScore(7);
            a2.setScore(6);
            a3.setScore(5);
            a4.setScore(4);
            a5.setScore(3);
            a6.setScore(2);
            a7.setScore(1);
            a.setScoreboard(board);

        }
    }

}
