package main;

import commands.GamemodeCommand;
import commands.HoloCommand;
import commands.SpeedCommand;
import listeners.*;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import utils.ColourUtils;

public class Lobby extends JavaPlugin {

    @Override
    public void onEnable(){
        runSetup();
        Bukkit.getPluginManager().registerEvents(new JoinListener(this), this);
        Bukkit.getPluginManager().registerEvents(new ChatListener(this), this);
        Bukkit.getPluginManager().registerEvents(new QuitListener(this), this);
        Bukkit.getPluginManager().registerEvents(new HungerListener(), this);
        Bukkit.getPluginManager().registerEvents(new InvListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlateListener(), this);
        Bukkit.getPluginCommand("holo").setExecutor(new HoloCommand());
        Bukkit.getPluginCommand("gamemode").setExecutor(new GamemodeCommand());
        Bukkit.getPluginCommand("speed").setExecutor(new SpeedCommand());
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
