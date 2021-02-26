package org.Deniable.Utils;

import net.milkbowl.vault.chat.Chat;
import org.Deniable.Lobby;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.channel.Channel;
import org.javacord.api.entity.channel.ServerTextChannel;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageBuilder;

import java.util.Collection;
import java.util.Locale;

public class Discord { //ODE0ODEwODk3MjY4NzM2MDAx.YDjRyA.PY9CeGm_zyfdZgQQxlxPk3OFbTk

    public static Lobby plugin = Lobby.getPlugin(Lobby.class);
    public static Chat chat = plugin.getChat();
    public static DiscordApi api;




    public static void InitDiscordBot() {
        api = new DiscordApiBuilder().setToken("ODE0ODEwODk3MjY4NzM2MDAx.YDjRyA.PY9CeGm_zyfdZgQQxlxPk3OFbTk").login().join();

        System.out.println("BOT CONNECTED.");
    }

    public static void SendMessage(String message, Player p) {
       TextChannel Channel = api.getTextChannelById("814815589007622184").get();


        MessageBuilder messageBuilder = new MessageBuilder();
        messageBuilder.append(message);

       messageBuilder.send(Channel);
    }

    public static void Shutdown() {
        api.disconnect();
    }


}
