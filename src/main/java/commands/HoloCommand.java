package commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import utils.ColourUtils;

public class HoloCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
        Player player = (Player) sender;
        if(args.length == 0){
            player.sendMessage(ColourUtils.colour("&b&lLobby &8\u00BB&3 Huh? Invalid arguments."));
        }
        if(args.length == 1){
            player.sendMessage(ColourUtils.colour("&b&lLobby &8\u00BB&3 Invalid arguments. Try /holo create [text]"));
        }
        if(args.length > 1){
            if(args[0].equalsIgnoreCase("create")){
                Location lowY = new Location(player.getWorld(), player.getLocation().getX(), player.getLocation().getY()-2,
                        player.getLocation().getZ());
                String a = "";
                for(int i = 1; i < args.length; i++){
                    String text = (args[i] + " ");
                    a = (a + text);
                }
                ArmorStand holo = (ArmorStand) player.getWorld().spawnEntity(lowY, EntityType.ARMOR_STAND);
                holo.setVisible(false);
                holo.setCustomNameVisible(true);
                holo.setCustomName(ColourUtils.colour(a));
                holo.setGravity(false);
                player.sendMessage(ColourUtils.colour("&b&lLobby &8\u00BB&3 Created a hologram at your location."));
            }
        }
        return true;
    }
}
