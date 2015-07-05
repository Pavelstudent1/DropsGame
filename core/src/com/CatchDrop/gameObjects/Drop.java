package com.CatchDrop.gameObjects;

import com.CatchDrop.helpers.AssetLoader;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Drop {
	
	int x;
	int y;
	int width;
	int height;
	
	float scaleX;
	float scaleY;
	
	Texture texture;
	Rectangle coliz;
	float bonusTime;
	int scorePoints;
	
	public Drop(int tx, int ty) {
		x = tx;
		y = ty;
		texture = AssetLoader.drop_img;
		width = texture.getWidth();
		height = texture.getHeight();
		
		scaleX = scaleY = 1.0f;
		
		bonusTime = 1.0f;
		scorePoints = 100;
		coliz = new Rectangle(x + 25, y, width / 4, height / 4);
	}
	
	public Rectangle getColizShape(){
		return coliz;
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

	public float getScaleX() {
		return scaleX;
	}

	public float getScaleY() {
		return scaleY;
	}
	
	
}
