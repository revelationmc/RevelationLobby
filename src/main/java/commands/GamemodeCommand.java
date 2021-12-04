package commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import utils.ColourUtils;

public class GamemodeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        switch(args.length){
            case 0:
                p.sendMessage(ColourUtils.colour("&b&lLobby &8\u00BB&3 " + "Invalid arguments. /gm [gamemode]"));
                break;
            case 1:
                switch(args[0]){
                    case "s":
                    case "0":
                        p.setGameMode(GameMode.SURVIVAL);
                        p.sendMessage(ColourUtils.colour("&b&lLobby &8\u00BB&3 " + "Gamemode set to &aSURVIVAL&3."));
                        break;
                    case "c":
                    case "1":
                        p.setGameMode(GameMode.CREATIVE);
                        p.sendMessage(ColourUtils.colour("&b&lLobby &8\u00BB&3 " + "Gamemode set to &aCREATIVE&3."));
                        break;
                    case "a":
                    case "2":
                        p.setGameMode(GameMode.ADVENTURE);
                        p.sendMessage(ColourUtils.colour("&b&lLobby &8\u00BB&3 " + "Gamemode set to &aADVENTURE&3."));
                        break;
                    case "sp":
                    case "3":
                        p.setGameMode(GameMode.SPECTATOR);
                        p.sendMessage(ColourUtils.colour("&b&lLobby &8\u00BB&3 " + "Gamemode set to &aSPECTATOR&3."));
                        break;
                    default:
                        p.sendMessage(ColourUtils.colour("&b&lLobby &8\u00BB&3 " + "Huh?"));
                        break;
                }
                break;
        }



        return true;
    }
}
