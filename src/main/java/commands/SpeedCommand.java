package commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import utils.ColourUtils;

public class SpeedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        double speed = Double.parseDouble(args[0]);
        if(args.length == 0){
            p.sendMessage(ColourUtils.colour("&b&lLobby &8\u00BB&3 Invalid arguments, try &b/speed [speed]"));
            return true;
        }
        if(args.length == 1){
            if(p.isFlying()){
                p.setFlySpeed((float) speed/10);
                p.sendMessage(ColourUtils.colour("&b&lLobby &8\u00BB&3 Your speed was set to &b" + speed));
                return true;
            } else {
                p.setWalkSpeed((float) speed/10);
                p.sendMessage(ColourUtils.colour("&b&lLobby &8\u00BB&3 Your speed was set to &b" + speed));
            }
        }
        return false;
    }
}
