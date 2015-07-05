package com.CatchDrop.TimeAndScore;

public class ScoreAccumulator {
	
	private static long currentScore = 0;
	private static int totalTime = 0;
	
	public static void incraseBy(int value){
		currentScore += value;
	}
	
	public static void decreaseBy(int value){
		if (currentScore - value <= 0) {
			currentScore = 0;
		}
		else{
			currentScore -= value;
		}
	}
	
	public static long getScore(){
		return currentScore;
	}
	
	public static String getScoreString(){
		return String.valueOf(currentScore);
	}
	
	public static void setTotalTime(int total){
		totalTime = total;
	}
	
	public static int getTotalTime(){
		return totalTime;
	}
	
	public static String getTotalTimeString(){
		
		int min = 0, 
			sec = 0,
			total_time = totalTime;
		while(total_time > 59){
			total_time -= 60;
			min++;
		}
		sec = total_time;
		
		return min + ":" + sec;
	}
	
}
