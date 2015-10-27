package com.uhcrun.mg.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.World;

public class WorldUtils {
		
		public static void deleteWorld(String worldName){
			World world = Bukkit.getWorld(worldName);
			File f = new File(worldName);
			if(f == null || world == null) return;
			Bukkit.unloadWorld(world, false);
			try{
				FileUtils.deleteDirectory(f);
			}catch(IOException e){
				e.printStackTrace();
		}
			
	}
}

