package com.github.ydal251.sharpnessonkill;

import io.th0rgal.oraxen.mechanics.Mechanic;
import io.th0rgal.oraxen.mechanics.MechanicFactory;
import org.bukkit.configuration.ConfigurationSection;

public class SharpnessOnKillMechanic extends Mechanic{
    private final double chance;
    private final Integer maxlvl;
    public static final String  mechanic_id = "sharpnessonkill";

    public SharpnessOnKillMechanic(MechanicFactory mechanicFactory, ConfigurationSection section){
        super (mechanicFactory, section);
        this.chance = section.getDouble("chance");
        this.maxlvl = section.getInt("maxlvl");
    }
    public double getChance() { return chance; }
    public int getMaxlvl() { return maxlvl; }
}
