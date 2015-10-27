package com.uhcrun.mg.events;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.uhcrun.mg.utils.ChatUtils;

public class ChatManager implements Listener {
	
	@EventHandler
	public void chatManager(AsyncPlayerChatEvent e){
		e.getFormat();
		Player p = e.getPlayer();
		
		if(p.getGameMode() == GameMode.SPECTATOR){
			e.setFormat(ChatUtils.getSpectatorPrefix() + p.getDisplayName() + " : §7§o" +e.getMessage());
		}else if(p.getGameMode() == GameMode.ADVENTURE || p.getGameMode() == GameMode.SURVIVAL){
			e.setFormat(ChatUtils.getPlayerPrefix() + p.getDisplayName() + " : §f" +e.getMessage());

		}
	}

}
