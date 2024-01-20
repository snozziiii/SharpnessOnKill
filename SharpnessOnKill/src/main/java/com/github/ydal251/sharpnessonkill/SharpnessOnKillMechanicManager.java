package com.github.ydal251.sharpnessonkill;

import io.th0rgal.oraxen.api.OraxenItems;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import java.util.Random;

public class SharpnessOnKillMechanicManager implements Listener {
    private final SharpnessOnKillMechanicFactory factory;
    public SharpnessOnKillMechanicManager(SharpnessOnKillMechanicFactory factory) {this.factory = factory; }

    @EventHandler(ignoreCancelled = true)
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getPlayer();
        Player killer = player.getKiller();
        if (killer == null) return;
        ItemStack item = killer.getInventory().getItemInMainHand();
        String itemID = OraxenItems.getIdByItem(item);
        SharpnessOnKillMechanic mechanic = (SharpnessOnKillMechanic) factory.getMechanic(item);
        if (factory.isNotImplementedIn(itemID)) return;
        if (mechanic == null) return;

        double chance = mechanic.getChance();
        int maxlvl = mechanic.getMaxlvl();
        int level = item.getEnchantmentLevel(Enchantment.DAMAGE_ALL);

        if (level < maxlvl && new Random().nextDouble() < chance)
        {
            item.addEnchantment(Enchantment.DAMAGE_ALL, level+1);
            killer.sendPlainMessage("Your Weapon Has Gained a Level of Sharpness");
        }
    }
}
