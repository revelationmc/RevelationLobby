package main;

import listeners.ChatListener;
import listeners.JoinListener;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class Lobby extends JavaPlugin {

    @Override
    public void onEnable(){
        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new ChatListener(this), this);
        runSetup();
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
