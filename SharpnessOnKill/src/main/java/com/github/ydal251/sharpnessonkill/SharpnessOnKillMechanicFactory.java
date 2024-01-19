package com.github.ydal251.sharpnessonkill;

import io.th0rgal.oraxen.OraxenPlugin;
import io.th0rgal.oraxen.mechanics.Mechanic;
import io.th0rgal.oraxen.mechanics.MechanicFactory;
import io.th0rgal.oraxen.mechanics.MechanicsManager;
import org.bukkit.configuration.ConfigurationSection;

public class SharpnessOnKillMechanicFactory extends MechanicFactory{

    public SharpnessOnKillMechanicFactory(String mechanicID) {
        super(mechanicID);
        MechanicsManager.registerListeners(OraxenPlugin.get(), SharpnessOnKillMechanic.mechanic_id, new SharpnessOnKillMechanicManager(this));
    }

    @Override
    public Mechanic parse(ConfigurationSection itemMechanicConfiguration) {
        Mechanic mechanic = new SharpnessOnKillMechanic(this, itemMechanicConfiguration);
        addToImplemented(mechanic);
        return mechanic;
    }
}
