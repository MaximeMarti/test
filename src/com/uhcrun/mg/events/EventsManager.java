package com.uhcrun.mg.events;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class EventsManager {

	public static void registerEvents(Plugin pl){
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new PlayerJoin(), pl);
		pm.registerEvents(new PlayerQuit(), pl);
		pm.registerEvents(new PlayerRespawn(), pl);
		pm.registerEvents(new MotdManager(), pl);
		pm.registerEvents(new PlayerDamage(), pl);
		pm.registerEvents(new PlayerEat(), pl);
		pm.registerEvents(new PlayerBlocks(), pl);
		pm.registerEvents(new PlayerBreak(), pl);
		pm.registerEvents(new PlayerDrop(), pl);
		pm.registerEvents(new PlayerMoveItem(), pl);
		pm.registerEvents(new ChatManager(), pl);
		pm.registerEvents(new Explosion(), pl);


	}
}	