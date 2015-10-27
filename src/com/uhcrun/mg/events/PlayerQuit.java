package com.uhcrun.mg.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import com.uhcrun.mg.GameState;
import com.uhcrun.mg.scoreboards.ScoreBoardLobby;
import com.uhcrun.mg.scoreboards.ScoreBoardTeleportation;
import com.uhcrun.mg.utils.WinDetector;

public class PlayerQuit implements Listener {

	@EventHandler
	public void onQuit(PlayerQuitEvent e){
		
		if(GameState.isState(GameState.LOBBY)){
			ScoreBoardLobby.scoreBoardLoad();
		}else if (GameState.isState(GameState.TELEPORTATIONA) || GameState.isState(GameState.DEGATACTIF) || GameState.isState(GameState.FINISH)){
			WinDetector.CheckWinner();
			ScoreBoardTeleportation.scoreBoardLoad();
		}

	}
}
