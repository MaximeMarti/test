package com.uhcrun.mg.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import com.uhcrun.mg.GameState;

public class WinDetector {
		
		public static void CheckWinner(){
			
			if(GameState.isState(GameState.DEGATACTIF) || GameState.isState(GameState.TELEPORTATIONB)){
				
				int lifeplayer = 0;
				
				for(Player pls : Bukkit.getOnlinePlayers()){
					if(pls.getGameMode() == GameMode.SURVIVAL){
						lifeplayer ++;
					}
				}
				
				if(lifeplayer == 1){
					for(Player pls : Bukkit.getOnlinePlayers()){
						if(pls.getGameMode() == GameMode.SURVIVAL){
							GameState.setState(GameState.FINISH);
							Finish();
						}

					}
				}
				
				if(lifeplayer == 0){
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "restart");
				}
				
			}else if(GameState.isState(GameState.LOBBY) || GameState.isState(GameState.FINISH)){
				return;
			}
		}
		
		static int task;
		static int countdown = 11;
		
		public static void Finish(){
			for(Player pls : Bukkit.getOnlinePlayers()){
				if(pls.getGameMode() == GameMode.SURVIVAL){
					
					task = Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getPluginManager().getPlugin("HungerGames"), new Runnable(){
						
						@Override
						public void run() {
							countdown--;
							
							if(countdown == 10 || countdown == 5){
								Bukkit.broadcastMessage(ChatUtils.getGamePrefix() + ChatColor.GOLD + pls.getName() + " §eest le gagnant du HungerGames !");
							}
							
							if(countdown == 1 || countdown == 2){
								for(Player plsall : Bukkit.getOnlinePlayers()){
									plsall.kickPlayer("§cMerci d'avoir joué sur nos HungerGames !");
								}
							}
							
							if(countdown == 0){
								Bukkit.getScheduler().cancelTask(task);
								Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "restart");
							}
						}
					}, 20, 20);
			}
		}
	}
		
}

