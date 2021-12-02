package listeners;

import main.Lobby;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import utils.ColourUtils;

public class JoinListener implements Listener {

    Lobby l;
    public JoinListener(Lobby l){
        this.l = l;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        String prefix = l.getLuckPerms().getUserManager().getUser(player.getUniqueId()).getCachedData().getMetaData().getPrefix();
        String newName = prefix.substring(prefix.indexOf("|")+1);
        String playerName = newName.trim();
        event.setJoinMessage(ColourUtils.colour("&e" + playerName + "&6 entered the lobby."));
        player.playSound(player.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_BLAST, 5, 1);
        player.sendTitle(ColourUtils.colour("&b&lRevelation &3&lNetwork"), ColourUtils.colour("&aNice to see you!"), 30, 40, 30);
        player.setGameMode(GameMode.ADVENTURE);
        if(prefix != null){
            player.setPlayerListName(ColourUtils.colour(prefix + player.getDisplayName()));
        } else {
            player.setPlayerListName(ColourUtils.colour("&r" + player.getDisplayName()));
        }
        Bukkit.getOnlinePlayers().forEach(p -> {
            p.setPlayerListHeaderFooter(ColourUtils.colour("&b&lRevelation &3&lNetwork"), ColourUtils.colour("&a&lIP: &arevelationmc.net"));
        });
    }

}
