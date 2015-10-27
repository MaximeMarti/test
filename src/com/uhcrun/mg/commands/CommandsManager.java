package com.uhcrun.mg.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.uhcrun.mg.events.PlayerJoin;

public class CommandsManager implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		Player p = (Player) sender;
		if(p.hasPermission("uhcrun.start") || p.isOp()){
			if(label.equalsIgnoreCase("fs")){
				PlayerJoin.timer = 25;
				p.sendMessage("§c§lLa partie va démarrer !");
			}
		}

		return false;
	}

}
