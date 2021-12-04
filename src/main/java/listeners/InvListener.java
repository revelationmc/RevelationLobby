package listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InvListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){
        if(!event.getWhoClicked().isOp() || !event.getWhoClicked().hasPermission("lobby.bypass")){
            event.setCancelled(true);
        }
    }

}
