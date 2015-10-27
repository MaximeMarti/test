package com.uhcrun.mg.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import com.uhcrun.mg.GameState;


public class PlayerMoveItem implements Listener {

	@EventHandler
	public void onPlayerDamage(InventoryClickEvent e){
		
		if(GameState.isState(GameState.LOBBY)){
			e.setCancelled(true);
		}else if(GameState.isState(GameState.FINISH)){
			e.setCancelled(true);
		}else if (GameState.isState(GameState.DEGATACTIF) || GameState.isState(GameState.DEGATACTIF)){
			e.setCancelled(false);
			
		}
	}

}

