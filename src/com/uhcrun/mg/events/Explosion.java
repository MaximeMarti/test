package com.uhcrun.mg.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExplosionPrimeEvent;

import com.uhcrun.mg.GameState;

public class Explosion implements Listener {

	@EventHandler
	public void onPlayerEat(ExplosionPrimeEvent e){
		if(GameState.isState(GameState.LOBBY)){
			e.setCancelled(true);
		}else if(GameState.isState(GameState.FINISH)){
			e.setCancelled(true);
		}else if (GameState.isState(GameState.DEGATACTIF) || GameState.isState(GameState.DEGATACTIF)){
			e.setCancelled(false);
			
		}
	}

}

