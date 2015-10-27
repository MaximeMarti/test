package com.uhcrun.mg.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import com.uhcrun.mg.GameState;

public class PlayerBreak implements Listener {

	@EventHandler
	public void onPlayerEat(BlockBreakEvent e){
		if(GameState.isState(GameState.LOBBY)){
			e.setCancelled(true);
		}else if(GameState.isState(GameState.FINISH)){
			e.setCancelled(true);
		}else if (GameState.isState(GameState.DEGATACTIF) || GameState.isState(GameState.DEGATACTIF)){
			e.setCancelled(false);
			
		}
	}

}
