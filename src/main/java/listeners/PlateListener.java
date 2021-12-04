package listeners;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

public class PlateListener implements Listener {

    @EventHandler
    public void onPlate(PlayerInteractEvent event){
        if(event.getAction().equals(Action.PHYSICAL)){
            if(event.getClickedBlock().getType() == Material.STONE_PRESSURE_PLATE ||
                    event.getClickedBlock().getType() == Material.HEAVY_WEIGHTED_PRESSURE_PLATE ||
                    event.getClickedBlock().getType() == Material.LIGHT_WEIGHTED_PRESSURE_PLATE){
                Player p = event.getPlayer();
                p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 7, 1);
                p.playEffect(EntityEffect.WOLF_SMOKE);
                p.setVelocity(p.getLocation().getDirection().multiply(4));

            }
        }
    }

}
