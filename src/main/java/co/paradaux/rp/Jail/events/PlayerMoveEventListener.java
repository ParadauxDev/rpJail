package co.paradaux.rp.Jail.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;

public class PlayerMoveEventListener implements Listener {

    private Plugin plugin;

    public PlayerMoveEventListener(Plugin p) {
        this.plugin = p;
    }


    @EventHandler
    public void onMove(PlayerMoveEvent e) {}

}
