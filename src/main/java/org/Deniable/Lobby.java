package org.Deniable;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import net.milkbowl.vault.chat.Chat;
import org.Deniable.Commands.Player.gmc;
import org.Deniable.Commands.Player.gms;
import org.Deniable.Commands.Server.Admin;
import org.Deniable.Commands.Server.Spawn;
import org.Deniable.Events.Player.*;
import org.Deniable.Events.Player.Misc.Anti;
import org.Deniable.GUI.AdminGUI.AdminGUIManager;
import org.Deniable.GUI.CosmeticGUI.Glow.CosmeticGlowSET;
import org.Deniable.GUI.CosmeticGUI.JoinMessages.CosmeticJoinMInteract;
import org.Deniable.GUI.GUIManager;
import org.Deniable.Utils.ChatConfig;
import org.Deniable.Utils.Discord;
import org.Deniable.Utils.Mongo;
import org.Deniable.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;

import java.net.UnknownHostException;

public class Lobby extends JavaPlugin implements Listener, PluginMessageListener {

    FileConfiguration config = getConfig();
    private ProtocolManager protocolManager;
    public Chat chat = null;

    @Override
    public void onEnable() {
        getLogger().info("Plugin has initiated.");
        protocolManager = ProtocolLibrary.getProtocolManager();

        config.options().copyDefaults(true);

        setupChat();

        setupCommands();
        setupEvents();

        updateScoreboard();

        ChatConfig.createChatConfig();
        Discord.InitDiscordBot();

        try {
            Mongo.SetupMongoDB();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

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
        Discord.Shutdown();
    }

    private void setupEvents() {
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new JoinBasics(this,chat), this);
        getServer().getPluginManager().registerEvents(new bossBar(this,chat),this);
        getServer().getPluginManager().registerEvents(new Tablist(this,chat),this);

        getServer().getPluginManager().registerEvents(new onChat(this,chat),this);
        getServer().getPluginManager().registerEvents(new Mongo(this),this);

        getServer().getPluginManager().registerEvents(new Inventory(),this);
        getServer().getPluginManager().registerEvents(new Anti(this,chat),this);
        getServer().getPluginManager().registerEvents(new GUIManager(),this);
        getServer().getPluginManager().registerEvents(new CosmeticGlowSET(),this);
        getServer().getPluginManager().registerEvents(new CosmeticJoinMInteract(),this);
        getServer().getPluginManager().registerEvents(new Blocks(), this);

        getServer().getPluginManager().registerEvents(new AdminGUIManager(this,chat),this);

        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", this);
    }

    private void setupCommands() {
        this.getCommand("spawn").setExecutor(new Spawn(this, chat));
        this.getCommand("admin").setExecutor(new Admin(this,chat));
        this.getCommand("gmc").setExecutor(new gmc(this,chat));
        this.getCommand("gmS").setExecutor(new gms(this,chat));
    }

    private boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        return chat != null;
    }

    public Chat getChat() {
        return chat;
    }

    @Override
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
        if (subchannel.equals("GetServer")) {
            String Servername = in.readUTF();
            Utils.serverName.put(Servername.toUpperCase(), Servername.toUpperCase());
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

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
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
            Score a6 = obj.getScore(Utils.format("Lobby: &e"+Utils.getServerName(a, "Lobby1")));
            Score a7 = obj.getScore(Utils.format("&e "));
            Score a8 = obj.getScore(Utils.format("&eplay.deniable.net"));

            a1.setScore(8);
            a2.setScore(7);
            a3.setScore(6);
            a4.setScore(5);
            a5.setScore(4);
            a6.setScore(3);
            a7.setScore(2);
            a8.setScore(1);
            a.setScoreboard(board);

        }
    }

}
