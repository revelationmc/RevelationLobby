package listeners;

import main.Lobby;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import utils.ColourUtils;

public class ChatListener implements Listener {

    Lobby l;
    public ChatListener(Lobby l){
        this.l = l;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event){
        Player player = event.getPlayer();
        String prefix = l.getLuckPerms().getUserManager().getUser(player.getUniqueId()).getCachedData().getMetaData().getPrefix();
        if(prefix != null){
            event.setFormat(ColourUtils.colour(prefix + player.getDisplayName() + " &8\u00BB &r" + event.getMessage()));
            player.setPlayerListName(ColourUtils.colour(prefix + player.getDisplayName()));
        } else {
            event.setFormat(ColourUtils.colour("&r" + player.getDisplayName() + " &8\u00BB &r" + event.getMessage()));
        }
    }

}
