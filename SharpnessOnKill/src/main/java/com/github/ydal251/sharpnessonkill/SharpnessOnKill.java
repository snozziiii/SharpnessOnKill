package com.github.ydal251.sharpnessonkill;

import org.bukkit.plugin.java.JavaPlugin;
import io.th0rgal.oraxen.mechanics.MechanicsManager;

public final class SharpnessOnKill extends JavaPlugin {

    @Override
    public void onEnable() {
        MechanicsManager.registerMechanicFactory(SharpnessOnKillMechanic.mechanic_id, new SharpnessOnKillMechanicFactory(SharpnessOnKillMechanic.mechanic_id), true);
    }

    @Override
    public void onDisable() {
    }
}
