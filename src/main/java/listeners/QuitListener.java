package listeners;

import main.Lobby;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import utils.ColourUtils;

public class QuitListener implements Listener {

    Lobby l;
    public QuitListener(Lobby l){
        this.l = l;
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();
        String prefix = l.getLuckPerms().getUserManager().getUser(player.getUniqueId()).getCachedData().getMetaData().getPrefix();
        event.setQuitMessage(ColourUtils.colour("&b\u00BB\u00BB " + prefix + player.getName() + " &3left the lobby."));
    }

}
