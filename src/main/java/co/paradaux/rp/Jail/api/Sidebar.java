package co.paradaux.rp.Jail.api;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.scoreboard.*;

public class Sidebar {

    public static Scoreboard buildSidebar(FileConfiguration file, Integer lapsRemaining) {
        final Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        final Objective obj = board.registerNewObjective("lapsRemaining", "dummy");

        obj.setDisplayName(ChatColor.translateAlternateColorCodes('&', file.getString("scoreboard.header")));
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);

        // Dynamic Data
        final Team lives = board.registerNewTeam("lives");
        lives.addEntry(ChatColor.GRAY.toString());
        lives.setPrefix(ChatColor.translateAlternateColorCodes('&', file.getString("scoreboard.laps-remaining-prefix")));
        lives.setSuffix(ChatColor.translateAlternateColorCodes('&',file.getString("scoreboard.laps-remaining-color") + lapsRemaining));

        // Static Data
        final Score empty1 = obj.getScore("");
        final Score empty2 = obj.getScore(" ");

        final Score web1 = obj.getScore(ChatColor.RED + "You are a Beta Tester!");
        final Score web2 = obj.getScore(ChatColor.GRAY + "--------------------");
        final Score web3 = obj.getScore(ChatColor.RED + "rpJail by ParadauxDev");

        // Set Placement

        empty1.setScore(6);
        obj.getScore(ChatColor.GRAY.toString()).setScore(5);
        empty2.setScore(4);

        web1.setScore(3);
        web2.setScore(3);
        web3.setScore(1);

        return board;
    }

}
