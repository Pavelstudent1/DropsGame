package com.test1.game;

import com.badlogic.gdx.graphics.Texture;

public class AssetLoader {
	
	static Texture drop_img;
	static Texture bucket_img;
	static Texture kitchen_img;
	
	public static void load(){
		
		drop_img = new Texture("droplet.png");
		bucket_img = new Texture("bucket.png");
		kitchen_img = new Texture("kitchen.png");
		
	}
	
	public static void dispose(){
		drop_img.dispose();
		bucket_img.dispose();
		kitchen_img.dispose();
	}
	
}
