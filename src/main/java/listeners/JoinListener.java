package listeners;

import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import utils.ColourUtils;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        String name = player.getDisplayName();
        String newName = name.substring(name.indexOf("|")+1);
        String playerName = newName.trim();
        event.setJoinMessage(ColourUtils.colour("&e" + playerName + "&6 entered the lobby."));
        player.playSound(player.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_BLAST, 5, 1);
        player.sendTitle(ColourUtils.colour("&b&lRevelation &3&lNetwork"), ColourUtils.colour("&aNice to see you!"), 30, 40, 30);
        player.setGameMode(GameMode.ADVENTURE);
    }

}
