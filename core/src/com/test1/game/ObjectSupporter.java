package com.test1.game;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class ObjectSupporter {

	Bucket bucket;
	Drop drop;
	Array<Drop> drops;
	
	long dropsGathered;
	long dropsMissed;
	
	long lastTimeFromDrop;

	
	
	public ObjectSupporter() {
		bucket = new Bucket();
		drops = new Array<Drop>();
		dropsGathered = 0;
		dropsMissed = 0;
		spawnNewDrop();
	}
	
	
	public Bucket getBucket(){
		return bucket;
	}
	
	public Drop getFirstDrop(){
		return drops.first();
	}
	
	public void spawnNewDrop(){
//		drop = new Drop(MathUtils.random(0, 800 - 64), 480);
//		drop.x = MathUtils.random(0, 800 - 64);
//		drop.y = 480;
		drops.add(new Drop(MathUtils.random(0, 800 - 64), 480));
		lastTimeFromDrop = TimeUtils.nanoTime();
	}
	
	public void dropping(float delta){
		
		if (drops.size != 0){
			for (Drop d : drops) {
				d.y -= 200 * delta;
				d.coliz.y = d.y;
				
				if (d.y < 0){
					dropsMissed++;
					drops.removeIndex(0);
				}
				
				if (d.coliz.overlaps(bucket.coliz)){
//					System.out.println("Collision!");
					dropsGathered++;
					drops.removeIndex(0);
				}
				
			}
		}
		
		
	}
	
	
}
