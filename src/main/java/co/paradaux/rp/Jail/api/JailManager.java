package co.paradaux.rp.Jail.api;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.Date;

public class JailManager {

    public JailManager(FileConfiguration file) {

    }

    public String[] getHistoricRecord (Player p) {
        return new String[] {};
    }

    public void addHistoricRecord (String PlayerUUID, String reason, int laps, String JailerUUID, Date time) {

    }
}
