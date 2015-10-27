package com.uhcrun.mg.events;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.uhcrun.mg.GameDegat;
import com.uhcrun.mg.GameState;
import com.uhcrun.mg.scoreboards.ScoreBoardLobby;
import com.uhcrun.mg.utils.ChatUtils;
import com.uhcrun.mg.utils.TitleManager;

public class PlayerJoin implements Listener {

	int taskLobby;
	public static int timer = 301;
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		
		if(GameState.isState(GameState.LOBBY)){
			
			
			Location lobby = new Location(Bukkit.getWorld("world"), 0, 100, 0);
			p.teleport(lobby);
			
			ScoreBoardLobby.scoreBoardLoad();
						
			p.getInventory().clear();
			
			p.setHealth(20);
			p.setFoodLevel(20);
			
			p.getInventory().setHelmet(new ItemStack(Material.AIR));
			p.getInventory().setChestplate(new ItemStack(Material.AIR));
			p.getInventory().setLeggings(new ItemStack(Material.AIR));
			p.getInventory().setBoots(new ItemStack(Material.AIR));
			
			TitleManager.senTitle(p, "§e§l|| UHCRun ||", "§cLa parie va bientôt commencer !", 20);
			
			int playercount = Bukkit.getServer().getOnlinePlayers().size();
			int maxplayer = Bukkit.getMaxPlayers();
			
			e.setJoinMessage(ChatUtils.getGamePrefix() + ChatColor.WHITE + p.getName() + "§7 a rejoint la partie §a" + "("+playercount+"/"+maxplayer+")");
			
			if(playercount == 2){
				
				taskLobby = Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getPluginManager().getPlugin("UHCRun"), new Runnable() {
					
					@Override
					public void run() {
						timer--;
						
						if(timer <= 301 && timer !=0){
							ScoreBoardLobby.scoreBoardLoad();
							for (Player pls:Bukkit.getOnlinePlayers()){
							TitleManager.sendActionBar(pls, "§7La partie commence dans §e" + timer + " secondes§7.");
							}
							
						}
						
						if(timer == 300){
							Bukkit.broadcastMessage(ChatUtils.getGamePrefix() + "§6La partie commence dans §e5 minutes§6.");
						}
						if(timer == 240){
							Bukkit.broadcastMessage(ChatUtils.getGamePrefix() + "§6La partie commence dans §e4 minutes§6.");
						}
						if(timer == 180){
							Bukkit.broadcastMessage(ChatUtils.getGamePrefix() + "§6La partie commence dans §e3 minutes§6.");
						}
						if(timer == 120){
							Bukkit.broadcastMessage(ChatUtils.getGamePrefix() + "§6La partie commence dans §e2 minutes§6.");
						}
						if(timer == 60){
							Bukkit.broadcastMessage(ChatUtils.getGamePrefix() + "§6La partie commence dans §e1 minute§6.");
						}
						if(timer == 50 || timer == 40 || timer == 30 || timer == 20 || timer == 10 || timer == 5 || timer == 4 || timer == 3 || timer == 2){
							Bukkit.broadcastMessage(ChatUtils.getGamePrefix() + "§6La partie commence dans " + ChatColor.YELLOW + timer + " secondes§6.");
						}
						if(timer == 1){
							Bukkit.broadcastMessage(ChatUtils.getGamePrefix() + "§6La partie commence dans " + ChatColor.YELLOW + timer + " seconde§6.");
						}
						
						if(timer == 0){
							Bukkit.getScheduler().cancelTask(taskLobby);
							Bukkit.broadcastMessage(ChatUtils.getGamePrefix() + "§eLa partie vient de commencer !");
							GameState.setState(GameState.TELEPORTATIONA);
							for(Player pls : Bukkit.getOnlinePlayers()){
								int r = new Random().nextInt(101);
								Location arena = new Location(Bukkit.getWorld("world"), r, 100, r);
								pls.teleport(arena);
								pls.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 24000, 1));
								pls.getInventory().clear();
								
								pls.setGameMode(GameMode.SURVIVAL);
							}
							
							GameDegat.Degat();
						}
					}
				
				}, 20, 20);
				
				if(playercount == 50){
					timer = 11;
				}
			}

		}else if (GameState.isState(GameState.TELEPORTATIONA) || GameState.isState(GameState.DEGATACTIF) || GameState.isState(GameState.TELEPORTATIONB) || GameState.isState(GameState.DEGATPVP) || GameState.isState(GameState.FINISH)){
			p.setGameMode(GameMode.SPECTATOR);
			//p.setGameMode(GameMode.SPECTATOR);
			e.setJoinMessage(null);		}
	}


}
