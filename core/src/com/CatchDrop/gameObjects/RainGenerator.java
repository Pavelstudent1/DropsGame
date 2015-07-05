package com.CatchDrop.gameObjects;

import com.CatchDrop.TimeAndScore.DropAccumulator;
import com.CatchDrop.TimeAndScore.GameTimers;
import com.CatchDrop.TimeAndScore.ScoreAccumulator;
import com.CatchDrop.helpers.Collisions;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class RainGenerator {
	
	Array<Drop> drops;
	
	long dropsGathered;
	long dropsMissed;
	long spawnSpeed;
	
	long lastTimeFromDrop;
	private GameTimers timer;
	private Bucket bucket;
	
		
	public RainGenerator(Bucket bucket, GameTimers timer) {
		this.timer = timer;
		this.bucket = bucket;
		drops = new Array<Drop>();
		dropsGathered = 0;
		dropsMissed = 0;
		spawnSpeed = 800000000;
		spawnNewDrop();
	}

	public void spawnNewDrop(){
		Drop d = new Drop(MathUtils.random(0, 800 - 64), 480);
		d.scaleX = d.scaleY = MathUtils.random(0.5f, 1f);
		d.bonusTime *= d.scaleX;
		d.scorePoints *= d.scaleX;
		drops.add(d);
		lastTimeFromDrop = TimeUtils.nanoTime();
	}
	
	public boolean isSpawnNeed(){
		return TimeUtils.nanoTime() - lastTimeFromDrop > spawnSpeed ? true : false;
	}
	
	public Array<Drop> getDropsData(){
		return drops;
	}

	
	public void dropping(float delta){
		
		if (drops.size != 0){
			for (Drop d : drops) {
				d.y -= 200 * delta;
				d.coliz.y = d.y + 5;
				
				if (d.y < 0){
					DropAccumulator.missedDrop();
					ScoreAccumulator.decreaseBy(d.scorePoints / 2);
					drops.removeIndex(0);
				}
				
				if (Collisions.isIntersection(d, bucket)){
					DropAccumulator.collectDrop();
					ScoreAccumulator.incraseBy(d.scorePoints);
					timer.addTimeBonus(d.bonusTime);
					drops.removeIndex(0);
				}
				
			}
		}

	}

}