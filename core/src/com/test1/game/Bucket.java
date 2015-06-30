package com.test1.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Bucket extends Actor{
	
	int x;
	int y;
	int width;
	int height;
	Texture texture;
	Rectangle coliz;
	float rotate;
	
	public Bucket() {
		x = 800 / 2 - 64 / 2;
		y = 10;
		width = 64;
		height = 64;
		rotate = 0;
		texture = AssetLoader.bucket_img;
		coliz = new Rectangle(x + 5, y + 45, (int) (width * 0.85), height / 6);
	}
	
	
	public void moveBucket(int tx, float delta){
		
		if (x + 32 - 5 > tx ){
			x -= 600 * delta;
			if (rotate < 30){
				rotate += 100 * delta;
			}
			coliz.x = x + 5;
			return;
		}else if (x + 32 + 5 < tx){
			if (rotate > -30){
				rotate -= 100 * delta;
			}
			x += 600 * delta;
			coliz.x = x + 5;
			return;
		}
		
		if (rotate > 0 + 1){
			rotate -= 100 * delta;
		}else if (rotate < 0 - 1){
			rotate += 100 * delta;
		}
	}
	
	@Override
	public void act(float delta) {
		
		
		
	}
}
