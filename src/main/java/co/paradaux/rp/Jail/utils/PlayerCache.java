package co.paradaux.rp.Jail.utils;

import org.bukkit.Location;

import java.util.UUID;


public class PlayerCache {

    private final UUID id;
    private Location primaryLoc, secondaryLoc;

    public PlayerCache(UUID id, Location primaryLoc, Location secondaryLoc) {

        this.id = id;
        this.primaryLoc = primaryLoc;
        this.secondaryLoc = secondaryLoc;

    }





}
