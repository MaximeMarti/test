package com.uhcrun.mg.events;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import com.uhcrun.mg.utils.WinDetector;

public class PlayerRespawn implements Listener {

	@EventHandler
	public void onRespawnPlayer(PlayerRespawnEvent e){
		Player p = e.getPlayer();
		
		Location spectator = new Location(Bukkit.getWorld("world"), 0, 200, 0);
		p.teleport(spectator);
		
		p.setGameMode(GameMode.SPECTATOR);
		
		WinDetector.CheckWinner();
	}
}
