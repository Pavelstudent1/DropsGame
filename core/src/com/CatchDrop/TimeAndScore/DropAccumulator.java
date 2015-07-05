package com.CatchDrop.TimeAndScore;

public class DropAccumulator {
	
	private static int drop_collected = 0;
	private static int drop_missed = 0;
	
	public static void collectDrop(){
		drop_collected++;
	}
	
	public static void missedDrop(){
		drop_missed++;
	}
	
	public static String getCollected(){
		return String.valueOf(drop_collected);
	}
	
	public static String getMissed(){
		return String.valueOf(drop_missed);
	}
}
