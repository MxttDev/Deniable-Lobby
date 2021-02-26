package org.Deniable.Utils;



import com.mongodb.*;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import net.milkbowl.vault.chat.Chat;
import org.Deniable.Lobby;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import javax.print.Doc;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;


public class Mongo implements Listener {

    public static Lobby plugin = Lobby.getPlugin(Lobby.class);
    public static Chat chat = plugin.getChat();

    public static MongoDatabase mongoDatabase;
    public static MongoCollection mongoCollection;

    public static HashMap<UUID, Integer> permissionLvl = new HashMap<UUID, Integer>();

    public Mongo(Lobby pl) {
        plugin = pl;
    }


    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        createPlayerData(e.getPlayer()); // Creates the users file in database.

        initPlayerPerms(e.getPlayer());

        checkData(e.getPlayer());

    }

    public static void SetupMongoDB() throws UnknownHostException {
        MongoClientURI uri = new MongoClientURI("mongodb+srv://Admin:admin@data.rpud2.mongodb.net/Players?retryWrites=true&w=majority");
        MongoClient mongoClient = new MongoClient(uri);
        mongoDatabase = mongoClient.getDatabase("Data");
        mongoCollection = mongoDatabase.getCollection("Players");

        System.out.println("Database CONNECTED.");
    }

    private void initPlayerPerms(Player p) {
        if (chat.getPrimaryGroup(p).equals("default")) {
            permissionLvl.put(p.getUniqueId(), 0);
        }else if (chat.getPrimaryGroup(p).equals("vip")) {
            permissionLvl.put(p.getUniqueId(), 1);
        } else if (chat.getPrimaryGroup(p).equals("elite")) {
            permissionLvl.put(p.getUniqueId(), 2);
        } else if (chat.getPrimaryGroup(p).equals("pro")) {
            permissionLvl.put(p.getUniqueId(), 3);
        } else if (chat.getPrimaryGroup(p).equals("ultra")) {
            permissionLvl.put(p.getUniqueId(), 4);
        } else {
            permissionLvl.put(p.getUniqueId(), 4);
        }

        if (getData(p).get("Permission Level") != permissionLvl.get(p.getUniqueId())) {
            InsertPlayerData(p, "Permission Level", permissionLvl.get(p.getUniqueId()));
        }

    }

    private void createPlayerData(Player p) {
        Document playerDataExist = (Document) mongoCollection.find(new Document("UUID", p.getUniqueId().toString())).first();

        if (playerDataExist == null) {
            Document playerData = new Document();

            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();

            playerData.append("UUID", p.getUniqueId().toString());
            playerData.append("Name", p.getName());
            playerData.append("Prefix", chat.getPlayerPrefix(p));
            playerData.append("Discord", "Not linked");
            playerData.append("First Join", formatter.format(date));
            playerData.append("Join Message", "&7<Player> &bhas arrived!");
            playerData.append("Permission Level", 0);
            playerData.append("Playtime", "0D, 0H");
            playerData.append("Last Online", "0D, 0H");

            mongoCollection.insertOne(playerData);
            System.out.println("NEW USER CREATED: " + p.getName());
        }

    }

    private void checkData(Player p ) {
        Document playerData = (Document) mongoCollection.find(new Document("UUID", p.getUniqueId().toString())).first();

        if (playerData != null) {
            if (getData(p).get("Name") != p.getName()) {
                InsertPlayerData(p, "Name", p.getName());
            }
            if (getData(p).get("Prefix") != chat.getPlayerPrefix(p)) {
                InsertPlayerData(p, "Prefix", chat.getPlayerPrefix(p));
            }
            if (!getData(p).get("Discord").equals("Not linked")) {
                InsertPlayerData(p, "Discord", "IDK");
            }
            if (getData(p).get("Permission Level") != permissionLvl.get(p.getUniqueId())) {
                InsertPlayerData(p, "Permission Level", permissionLvl.get(p.getUniqueId()));
            }

        }



    }

    public static Document getData(Player p) {
        Document PlayerData = (Document) mongoCollection.find(new Document("UUID", p.getUniqueId().toString())).first();
        return PlayerData;
    }

    public static void InsertPlayerData(Player p, String object, Object newValueObject) {
        Document PlayerData = (Document) mongoCollection.find(new Document("UUID", p.getUniqueId().toString())).first();

        if (PlayerData != null) {
            Bson newValue = new Document(object, newValueObject);
            Bson updatedOperation = new Document("$set", newValue);
            mongoCollection.updateOne(PlayerData, updatedOperation);

            System.out.println("OPERATION UPDATED.");
        } else {
            System.out.println("FAILED. NO DATA FOUND!");
        }

    }

}
