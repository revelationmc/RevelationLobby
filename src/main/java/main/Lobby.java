package main;

import listeners.ChatListener;
import listeners.JoinListener;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import utils.ColourUtils;

public class Lobby extends JavaPlugin {

    @Override
    public void onEnable(){
        Bukkit.getPluginManager().registerEvents(new JoinListener(this), this);
        Bukkit.getPluginManager().registerEvents(new ChatListener(this), this);
        runSetup();
        Bukkit.getOnlinePlayers().forEach(player -> {
           player.setPlayerListHeaderFooter(ColourUtils.colour("&b&lRevelation &3&lNetwork"), ColourUtils.colour("&a&lIP: &arevelationmc.net"));
        });
    }

    private void runSetup(){
        RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
        if (provider != null) {
            LuckPerms api = provider.getProvider();
        }
    }

    public LuckPerms getLuckPerms(){
        return LuckPermsProvider.get();
    }


    @Override
    public void onDisable(){

    }

}
