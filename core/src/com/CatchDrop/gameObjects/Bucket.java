package com.CatchDrop.gameObjects;

import com.CatchDrop.helpers.AssetLoader;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Bucket {
	
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
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Texture getTexture() {
		return texture;
	}

	public float getRotate() {
		return rotate;
	}

	public Rectangle getColizShape(){
		return coliz;
	}
	
	public Bucket getBucket(){
		return this;
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
}
