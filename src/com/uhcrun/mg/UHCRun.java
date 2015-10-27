package com.uhcrun.mg;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.bukkit.plugin.java.JavaPlugin;

import com.uhcrun.mg.GameState;
import com.uhcrun.mg.commands.CommandsManager;
import com.uhcrun.mg.events.EventsManager;
import com.uhcrun.mg.utils.WorldUtils;

public class UHCRun extends JavaPlugin {
	
	public void onEnable(){
		registerCommands();
		GameState.setState(GameState.LOBBY);
		EventsManager.registerEvents(this);
		Bukkit.getServer().getWorld("world").setPVP(false);
		
	
	for(World world : Bukkit.getWorlds()){
		WorldBorder wb = world.getWorldBorder();
		wb.setCenter(0, 0);
		wb.setSize(500);
	}
}
	
	public void onDisable(){
		WorldUtils.deleteWorld("world");
		Bukkit.getWorld("world").setGameRuleValue("naturalRegeneration", "false");
	}
	
	public void registerCommands(){
		getCommand("fs").setExecutor(new CommandsManager());
	}

}

