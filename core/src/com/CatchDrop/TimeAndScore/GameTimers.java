package com.CatchDrop.TimeAndScore;
	
	import com.badlogic.gdx.utils.Timer;
	import com.badlogic.gdx.utils.Timer.Task;

	public class GameTimers {
		
		private Timer timer;
		private volatile float currentTime;
		private int timeFromStart;
		private volatile boolean isGameOver = false;

		public GameTimers(int initialTime) {
			currentTime = initialTime;
			timeFromStart = 0;
			timer = new Timer();
		}
		
		public void startTimer(){
			timer.scheduleTask(new Task() {
				
				public void run() {
					
					if (currentTime <= 1.0){
						isGameOver = true;
					}else{
						timeFromStart++;
						currentTime--;
					}
				}
			}, 0.0f, 1.0f);
		}
		
		public boolean isGameOver(){
			return isGameOver;
		}
		
		public float getCurrentTime(){
			return currentTime;
		}
		
		public String getCurrentTimeString(){
			return String.valueOf((int)currentTime);
		}
		
		public void addTimeBonus(float bonus){
			currentTime += bonus;
		}
		
		public void stopTimer(){
			timer.stop();
			timer.clear();
		}
		
		public int getTotalTime(){
			return timeFromStart;
		}
}
