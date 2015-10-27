package com.uhcrun.mg.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import com.uhcrun.mg.GameState;

public class MotdManager implements Listener {
	
	@EventHandler
	public void onMotd(ServerListPingEvent e){
		if(GameState.isState(GameState.LOBBY)){
			e.setMotd("§6UHCRun §7| §aAttente de joueur... \n§3Merci de patienter...");
		}else if(GameState.isState(GameState.DEGATACTIF) || GameState.isState(GameState.DEGATPVP)){
			e.setMotd("§6UHCRun §7| §aLa partie est en cours \n§3Merci d'attendre la fin");
		}else if(GameState.isState(GameState.FINISH)){
			e.setMotd("§6UHCRun §7| §c§lLa partie va reboot... \n§3Veuillez patienter...");
		}
	}

}
