package com.test1.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Drop extends Actor{
	
	int x;
	int y;
	int width;
	int height;
	Texture texture;
	Rectangle coliz;
	
	public Drop(int tx, int ty) {
		x = tx;
		y = ty;
		texture = AssetLoader.drop_img;
		width = texture.getWidth();
		height = texture.getHeight();
		coliz = new Rectangle(x + 25, y, width / 4, height / 4);
	}
	
}
