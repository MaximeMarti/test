package com.uhcrun.mg;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.uhcrun.mg.GameState;
import com.uhcrun.mg.scoreboards.ScoreBoardTeleportation;
import com.uhcrun.mg.utils.ChatUtils;
import com.uhcrun.mg.utils.TitleManager;

public class GameDegat {

	
	static int taskDegat;
	public static int time = 30;
	public static void Degat(){
		taskDegat = Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getPluginManager().getPlugin("UHCRun"), new Runnable(){
			
			@Override
			public void run() {
				time--;
				
				if(time <= 30 && time !=0){
					ScoreBoardTeleportation.scoreBoardLoad();
					for (Player pls:Bukkit.getOnlinePlayers()){
					TitleManager.sendActionBar(pls, "§7Dégats actifs dans: §e" + time + " secondes§7.");
					}
				}

				if(time == 10 || time == 5 || time == 4 || time == 3 || time == 2){
					Bukkit.broadcastMessage(ChatUtils.getGamePrefix() + "§6Les dégats seront actif dans:§e "+time+" secondes§6.");
				}
				if(time == 1){
					Bukkit.broadcastMessage(ChatUtils.getGamePrefix() + "§6Les dégats seront actif dans: §e1 seconde§6.");
				}
				if(time <= 0){
					Bukkit.getScheduler().cancelTask(taskDegat);
					Bukkit.broadcastMessage(ChatUtils.getGamePrefix() + "§6Les dégats sont maintenant actifs !");
					GameState.setState(GameState.DEGATACTIF);
					Degat();
					

				}
			}
	
		}, 20, 20);
	
	}
	
	public static void Teleportation(){
		
	}

}
