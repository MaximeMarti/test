package com.uhcrun.mg;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.uhcrun.mg.GameState;
import com.uhcrun.mg.scoreboards.ScoreBoardTeleportation;
import com.uhcrun.mg.utils.ChatUtils;
import com.uhcrun.mg.utils.TitleManager;

public class GameTeleportation {

	
	static int task;
	public static int time = 1141;
	public static void Teleportation(){
		task = Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getPluginManager().getPlugin("UHCRun"), new Runnable(){			
			
			@Override
			public void run() {
				time--;
				
				if(time <= 1141 && time !=0){
					ScoreBoardTeleportation.scoreBoardLoad();
					for (Player pls:Bukkit.getOnlinePlayers()){
					TitleManager.sendActionBar(pls, "§7Les dégats seront actifs dans: §e" + time + " secondes§7.");
					}
					
				}
				if(time == 10 || time == 5 || time == 4 || time == 3 || time == 2){
					Bukkit.broadcastMessage(ChatUtils.getGamePrefix() + "§6Les dégats seront actif dans:§e "+time+" secondes§6.");
				}
				if(time == 1){
					Bukkit.broadcastMessage(ChatUtils.getGamePrefix() + "§6Les dégats seront actif dans: §e1 seconde§6.");
				}
				if(time <= 0){
					Bukkit.getScheduler().cancelTask(task);
					//Bukkit.getServer().getWorld("world").setPVP(false);
					Bukkit.broadcastMessage(ChatUtils.getGamePrefix() + "§6Les dégats sont maintenant actifs !");
					GameState.setState(GameState.TELEPORTATIONB);
					Teleportation();

					

				}
			}
	
		}, 20, 20);
	
	}
	
	public static void DegatPvP(){
		
	}

}
