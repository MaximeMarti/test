package com.uhcrun.mg.scoreboards;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import com.uhcrun.mg.GameState;

public class ScoreBoardTeleportation {

	public static void scoreBoardLoad(){
		if(GameState.isState(GameState.TELEPORTATIONA)){
			
			ScoreboardManager manager = Bukkit.getScoreboardManager();
			Scoreboard board = manager.getNewScoreboard();
			Objective objective = board.registerNewObjective("Points", "dummy");
			
			for(Player pls : Bukkit.getOnlinePlayers()){
								
				objective.setDisplaySlot(DisplaySlot.SIDEBAR);
				objective.setDisplayName("§e§l|| UHCRun ||");
				
				
				Score score1 = objective.getScore("§e ");
				score1.setScore(6);
				
				Score score2 = objective.getScore("Etape: §7§lPréparation");
				score2.setScore(5);
				
				Score score3 = objective.getScore("§e ");
				score3.setScore(4);
				
				Score score4 = objective.getScore("Dégats actif:§a§l ✔");
				score4.setScore(3);
				
				Score score5 = objective.getScore("§e ");
				score5.setScore(2);
				
				Score score6 = objective.getScore("Téléportation: §a§l" );//+ time
				score6.setScore(1);

				
				pls.setScoreboard(board);
				
			}
		}else{
			return;
		}

	}
	
}
