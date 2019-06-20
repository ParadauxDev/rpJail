package co.paradaux.rp.Jail;

import co.paradaux.rp.Jail.cmds.JailCMD;
import co.paradaux.rp.Jail.cmds.JailHistoryCMD;
import co.paradaux.rp.Jail.cmds.RPJailCMD;
import co.paradaux.rp.Jail.events.PlayerMoveEventListener;
import com.google.common.cache.CacheBuilder;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class RPJail extends JavaPlugin {

    public static HashMap<String, Integer> jailedPlayers = new HashMap<>();
    public static Cache<UUID, PlayerCache> playerCache = CacheBuilder.newBuilder()
            .maximumSize(10_000)
            .expireAfterWrite(10, TimeUnit.MINUTES)
            .build();



    public void onEnable() {

        getLogger().info(new String[] {
                "+ ------------------------------------ +\n",
                "|        Running rpJail v1.0.0         |\n",
                "|       © Rían Errity (Paradaux)       |\n",
                "|         https://paradaux.co          |\n",
                "+ ------------------------------------ +\n"
        }.toString());

        getLogger().info("This plugin was made specifically for ThyV#0001 by ParadauxDev");
        getLogger().info("Build Information: 20-6-19init-8e75a895-5169-45e4-8dba-1b35d6e7c39a-SNAPSHOT");

        this.getConfig().options().copyDefaults();
        saveDefaultConfig();

        getCommand("jail").setExecutor(new JailCMD(getConfig()));
        getCommand("jailhistory").setExecutor(new JailHistoryCMD());
        getCommand("rpjail").setExecutor(new RPJailCMD());

        Bukkit.getPluginManager().registerEvents(new PlayerMoveEventListener(this), this);
        WorldEditPlugin worldEdit =
    }

    public void onDisable() {

        // Only here so we can investigate crash reports
        getLogger().info("[RPJail] has been disabled.");

    }

    public static PlayerCache getCache(UUID id) {
        PlayerCache cache = playerCache.getIfPresent(id);

        if (cache == null) {
            cache = new PlayerCache(id);
            playerCache.put(id, cache);
        }

        return cache;
    }


}
