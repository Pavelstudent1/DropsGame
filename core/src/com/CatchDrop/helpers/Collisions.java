package com.CatchDrop.helpers;

import com.CatchDrop.gameObjects.Bucket;
import com.CatchDrop.gameObjects.Drop;

public class Collisions {

	
	static public boolean isIntersection(Drop drop, Bucket bucket){
	
		return drop.getColizShape().overlaps(bucket.getColizShape());
	}
	
	
}
