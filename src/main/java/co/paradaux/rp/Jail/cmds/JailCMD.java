package co.paradaux.rp.Jail.cmds;

import co.paradaux.rp.Jail.api.Sidebar;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class JailCMD implements CommandExecutor {

    /*
         username # of laps
    /jail {user} {#} {reason}


     */
    private FileConfiguration file;

    public JailCMD (FileConfiguration file) {
        this.file = file;
    }


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player p = (Player) commandSender;
        p.setScoreboard(Sidebar.buildSidebar(file, 5));
        return true;
    }
}
