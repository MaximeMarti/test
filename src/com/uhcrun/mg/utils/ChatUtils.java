package com.uhcrun.mg.utils;

public class ChatUtils {
	
	static String prefix = "§8[§9UHCRUN§8] ";
	static String playerprefix = "§7[§fJoueur§7]";
	static String spectatorprefix = "§7[§8SPEC§7]]";

	
	public static String getGamePrefix(){
		return prefix;
	}
	
	public static String getPlayerPrefix(){
		return playerprefix;
	}
	
	public static String getSpectatorPrefix(){
		return spectatorprefix;
	}


}