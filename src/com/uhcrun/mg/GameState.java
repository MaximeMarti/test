package com.uhcrun.mg;

import com.uhcrun.mg.GameState;

public enum GameState {

	LOBBY(true), TELEPORTATIONA(false), DEGATACTIF(false), TELEPORTATIONB(false), DEGATPVP(false), FINISH(false);
	
	private boolean canJoin;
	
	private static GameState currentState;
	
	GameState(boolean canJoin){
		this.canJoin = canJoin;
	}

	public boolean canJoin(){
		return canJoin;
	}
	
	public static void setState(GameState state){
		GameState.currentState = state;
	}
	
	public static boolean isState(GameState state){
		return GameState.currentState == state;
	}
	
	public static GameState getState(){
		return currentState;
	}
	
}