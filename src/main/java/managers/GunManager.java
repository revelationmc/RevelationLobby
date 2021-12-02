package managers;

import main.Lobby;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import utils.ColourUtils;

public class GunManager implements Listener {

    Lobby l;
    ItemStack gun = new ItemStack(Material.BLAZE_ROD, 1);
    public GunManager(Lobby l){
        this.l = l;
    }

    public void giveGun(Player p){
        Inventory inv = p.getInventory();
        ItemMeta meta = gun.getItemMeta();
        meta.setDisplayName(ColourUtils.colour("&b&lLobby Gun"));
        meta.setUnbreakable(true);
        gun.setItemMeta(meta);
        inv.setItem(2, gun);
    }

    public void onGunShoot(PlayerInteractEvent event){
        Player player = event.getPlayer();
        Inventory inv = player.getInventory();
        if(event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK ||
        event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR){
            if(player.getItemOnCursor() == gun){
                player.launchProjectile(Snowball.class);
                player.launchProjectile(Snowball.class);
                Bukkit.getScheduler().scheduleSyncDelayedTask(l, () -> {
                    player.getItemOnCursor().setType(Material.BARRIER);
                }, 0L);
                Bukkit.getScheduler().scheduleSyncDelayedTask(l, () -> {
                    inv.getItem(2).setType(gun.getType());
                    inv.getItem(2).setItemMeta(gun.getItemMeta());
                }, 60L);
            } return;
        }
    }

    public void onSnowballHit(ProjectileHitEvent event){
        if(event.getHitEntity() instanceof Player){
            Player player = (Player) event.getHitEntity();
            player.setVelocity(player.getLocation().getDirection().multiply(3));
        }
        event.getEntity().getWorld().playSound(event.getEntity().getLocation(), Sound.ENTITY_ENDER_PEARL_THROW, 5, 1);
        event.getEntity().getWorld().playEffect(event.getEntity().getLocation(), Effect.SMOKE, 5, 5);
    }

}
