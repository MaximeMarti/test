package com.uhcrun.mg.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockCanBuildEvent;

import com.uhcrun.mg.GameState;

public class PlayerBlocks implements Listener {

	@EventHandler
	public void onPlayer(BlockCanBuildEvent e){
		if(GameState.isState(GameState.LOBBY)){
			e.setBuildable(false);
		}else if(GameState.isState(GameState.FINISH)){
			e.setBuildable(false);
		}else if (GameState.isState(GameState.DEGATACTIF) || GameState.isState(GameState.DEGATACTIF)){
			e.setBuildable(true);


		}
		
	}

}
