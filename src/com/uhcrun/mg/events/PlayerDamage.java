package com.uhcrun.mg.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import com.uhcrun.mg.GameState;

public class PlayerDamage implements Listener {
	
	@EventHandler
	public void onPlayerDamage(EntityDamageEvent e){
		if(GameState.isState(GameState.LOBBY) || GameState.isState(GameState.TELEPORTATIONA) || GameState.isState(GameState.TELEPORTATIONB)){
			e.setCancelled(true);
		}else if(GameState.isState(GameState.FINISH)){
			e.setCancelled(true);
		}else if (GameState.isState(GameState.DEGATACTIF) || GameState.isState(GameState.DEGATPVP)){
			e.setCancelled(false);
			
		}
		
	}

}
