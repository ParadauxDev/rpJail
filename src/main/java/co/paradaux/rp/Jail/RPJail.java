package co.paradaux.rp.Jail;

import co.paradaux.rp.Jail.cmds.JailCMD;
import co.paradaux.rp.Jail.cmds.JailHistoryCMD;
import co.paradaux.rp.Jail.cmds.RPRollCMD;
import co.paradaux.rp.Jail.events.PlayerMoveEventListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class RPJail extends JavaPlugin {

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

        getCommand("jail").setExecutor(new JailCMD());
        getCommand("jailhistory").setExecutor(new JailHistoryCMD());
        getCommand("rproll").setExecutor(new RPRollCMD());

        Bukkit.getPluginManager().registerEvents(new PlayerMoveEventListener(this), this);
    }

    public void onDisable() {

        // Only here so we can investigate crash reports
        getLogger().info("[RPJail] has been disabled.");

    }


}
