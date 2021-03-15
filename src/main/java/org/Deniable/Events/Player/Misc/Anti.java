package org.Deniable.Events.Player.Misc;

import net.milkbowl.vault.chat.Chat;
import org.Deniable.Lobby;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class Anti implements Listener {
    Lobby plugin;
    private Chat chat = null;

    public Anti(Lobby main, Chat chat) {
        this.plugin = main;
        this.chat = chat;
    }

    @EventHandler
    public void OnVoiDamage(PlayerMoveEvent e) {
        Player p = e.getPlayer();

        if (p.getLocation().getBlockY() <= 90) {
            Double X = plugin.getConfig().getDouble("System.Spawn.X");
            Double Y = plugin.getConfig().getDouble("System.Spawn.Y");
            Double Z = plugin.getConfig().getDouble("System.Spawn.Z");

            p.teleport(new Location(p.getWorld(), X, Y, Z, 180, 0));
            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 3.0F, 0.5F);
            p.setHealth(20);
        }

    }

    @EventHandler
    public void onHunger(FoodLevelChangeEvent e) {
        e.setFoodLevel(20);
        e.setCancelled(true);
    }

    @EventHandler
    public void onLeaveDecay(LeavesDecayEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onAnvilUse(PlayerInteractEvent e) {
        Player p = e.getPlayer();

        if (p.getGameMode() != GameMode.CREATIVE) {
            if (e.getAction() == Action.RIGHT_CLICK_BLOCK && (e.getClickedBlock().getType() == Material.ANVIL)) { e.setCancelled(true); }
            if (e.getAction() == Action.RIGHT_CLICK_BLOCK && (e.getClickedBlock().getType() == Material.HOPPER)) {e.setCancelled(true);}
            if (e.getAction() == Action.RIGHT_CLICK_BLOCK && (e.getClickedBlock().getType() == Material.CRAFTING_TABLE)) {e.setCancelled(true);}
            if (e.getAction() == Action.RIGHT_CLICK_BLOCK && (e.getClickedBlock().getType() == Material.OAK_TRAPDOOR)) {e.setCancelled(true);}
            if (e.getAction() == Action.RIGHT_CLICK_BLOCK && (e.getClickedBlock().getType() == Material.SPRUCE_TRAPDOOR)) {e.setCancelled(true);}
            if (e.getAction() == Action.RIGHT_CLICK_BLOCK && (e.getClickedBlock().getType() == Material.CHEST)) {e.setCancelled(true);}
            if (e.getAction() == Action.RIGHT_CLICK_BLOCK && (e.getClickedBlock().getType() == Material.TRAPPED_CHEST)) {e.setCancelled(true);}
            if (e.getAction() == Action.RIGHT_CLICK_BLOCK && (e.getClickedBlock().getType() == Material.ENDER_CHEST)) {e.setCancelled(true);}
            if (e.getAction() == Action.RIGHT_CLICK_BLOCK && (e.getClickedBlock().getType() == Material.ACACIA_FENCE_GATE)) {e.setCancelled(true);}
            if (e.getAction() == Action.RIGHT_CLICK_BLOCK && (e.getClickedBlock().getType() == Material.LOOM)) {e.setCancelled(true);}
            if (e.getAction() == Action.RIGHT_CLICK_BLOCK && (e.getClickedBlock().getType() == Material.ENCHANTING_TABLE)) {e.setCancelled(true);}
            if (e.getAction() == Action.RIGHT_CLICK_BLOCK && (e.getClickedBlock().getType() == Material.PAINTING)) {e.setCancelled(true);}
            if (e.getAction() == Action.RIGHT_CLICK_BLOCK && (e.getClickedBlock().getType() == Material.ARMOR_STAND)) {e.setCancelled(true);}
        }
    }

    @EventHandler
    public void Armorstand(PlayerInteractAtEntityEvent e) {
        Player p = e.getPlayer();
        if (p.getGameMode() != GameMode.CREATIVE) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onGeneralDamage(EntityDamageEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onInteractPainting(PlayerInteractEvent e) {
        Player p = e.getPlayer();

        if (e.getAction() == Action.PHYSICAL && e.getClickedBlock().getType() == Material.PAINTING) { e.setCancelled(true);}
        if (e.getAction() == Action.PHYSICAL && e.getClickedBlock().getType() == Material.MAP) { e.setCancelled(true);}
        if (e.getAction() == Action.PHYSICAL && e.getClickedBlock().getType() == Material.ITEM_FRAME) { e.setCancelled(true);}

    }

    @EventHandler
    public void CropAbuse(PlayerInteractEvent e) {
        Player p =e.getPlayer();

        if (e.getAction() == Action.PHYSICAL && e.getClickedBlock().getType() == Material.FARMLAND) {
            e.setCancelled(true);
        }

    }

}
