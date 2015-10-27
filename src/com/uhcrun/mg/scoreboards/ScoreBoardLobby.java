package com.uhcrun.mg.scoreboards;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import com.uhcrun.mg.GameState;
import com.uhcrun.mg.events.PlayerJoin;

public class ScoreBoardLobby {
	
	public static void scoreBoardLoad(){
		if(GameState.isState(GameState.LOBBY)){
			
			ScoreboardManager manager = Bukkit.getScoreboardManager();
			Scoreboard board = manager.getNewScoreboard();
			Objective objective = board.registerNewObjective("Points", "dummy");
			
			for(Player pls : Bukkit.getOnlinePlayers()){
				
				objective.setDisplaySlot(DisplaySlot.SIDEBAR);
				objective.setDisplayName("§e§l|| UHCRun ||");
				
				String time = new SimpleDateFormat("mm:ss").format(new Date(PlayerJoin.timer * 1000));
				int playercount = Bukkit.getServer().getOnlinePlayers().size();
				int maxplayer = Bukkit.getMaxPlayers();
				
				Score score1 = objective.getScore("§e ");
				score1.setScore(4);
				
				Score score2 = objective.getScore("Etape: §7§lLobby");
				score2.setScore(3);
				
				Score score3 = objective.getScore("§e ");
				score3.setScore(3);
				
				Score score4 = objective.getScore("Joueurs: §a§l" + playercount + "/" + maxplayer);
				score4.setScore(2);
				
				Score score5 = objective.getScore("Début dans: §a§l" + time);
				score5.setScore(1);

				
				pls.setScoreboard(board);
				
			}
		}else{
			return;
		}
		
	}

}
