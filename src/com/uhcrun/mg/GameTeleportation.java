package com.uhcrun.mg;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.uhcrun.mg.GameState;
import com.uhcrun.mg.scoreboards.ScoreBoardTeleportation;
import com.uhcrun.mg.utils.ChatUtils;
import com.uhcrun.mg.utils.TitleManager;

public class GameTeleportation {

	
	static int taskTeleportationt;
	public static int time = 1141;
	public static void Degat(){
		taskTeleportationt = Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getPluginManager().getPlugin("UHCRun"), new Runnable(){
			
			@Override
			public void run() {
				time--;
				
				if(time <= 1141 && time >=0){
					ScoreBoardTeleportation.scoreBoardLoad();
					for (Player pls:Bukkit.getOnlinePlayers()){
					TitleManager.sendActionBar(pls, "§7Téléportation dans: §e" + time + " secondes§7.");
					}
				}

				if(time == 10 || time == 5 || time == 4 || time == 3 || time == 2){
					Bukkit.broadcastMessage(ChatUtils.getGamePrefix() + "§6Téléportation dans:§e "+time+" secondes§6.");
				}
				if(time == 1){
					Bukkit.broadcastMessage(ChatUtils.getGamePrefix() + "§6Téléportation dans: §e1 seconde§6.");
				}
				if(time == 0){
					Bukkit.getScheduler().cancelTask(taskTeleportationt);
					Bukkit.broadcastMessage(ChatUtils.getGamePrefix() + "§6Téléportation !");
					GameState.setState(GameState.TELEPORTATIONB);
					Degat();
					
				}
				
				//GameTeleportation.Teleportation();
				
			}
	
		}, 20, 20);
	
	}
	
	public static void Teleportation(){
		
	}

}
