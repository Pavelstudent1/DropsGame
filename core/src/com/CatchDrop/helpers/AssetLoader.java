package com.CatchDrop.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {
	
	public static Texture drop_img;
	public static Texture bucket_img;
	public static Texture kitchen_img;
	
	private static Texture dropsAnimation;
	public static Animation drops_animation;
	
	public static BitmapFont font_StartScreen;
	public static BitmapFont font_InGameScore;
	public static BitmapFont font_EndGameScore;
	
	public static void load(){
		
		drop_img = new Texture("droplet.png");
		bucket_img = new Texture("bucket.png");
		kitchen_img = new Texture("kitchen.png");
		
		dropsAnimation = new Texture("drop_anim.png");
		dropsAnimation.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		TextureRegion 
			drop_f1 = new TextureRegion(dropsAnimation, 0, 0, 64, 64),
			drop_f2 = new TextureRegion(dropsAnimation, 64, 0, 64, 64),
			drop_f3 = new TextureRegion(dropsAnimation, 128, 0, 64, 64),
			drop_f4 = new TextureRegion(dropsAnimation, 0, 64, 64, 64),
			drop_f5 = new TextureRegion(dropsAnimation, 64, 64, 64, 64),
			drop_f6 = new TextureRegion(dropsAnimation, 128, 64, 64, 64);
		
		TextureRegion[] drops = {drop_f1, drop_f2, drop_f3, drop_f4, drop_f5, drop_f6};
		drops_animation = new Animation(0.1f, drops);
		drops_animation.setPlayMode(Animation.PlayMode.LOOP);
		
		font_StartScreen = new BitmapFont(Gdx.files.internal("DropGameFont.fnt"));
		font_EndGameScore = new BitmapFont(Gdx.files.internal("EndGameFont.fnt"));
		font_InGameScore = new BitmapFont(Gdx.files.internal("InGameFont.fnt"));
	}
	
	public static void dispose(){
		
		drop_img.dispose();
		bucket_img.dispose();
		kitchen_img.dispose();
		
		dropsAnimation.dispose();
		font_StartScreen.dispose();
		font_InGameScore.dispose();
		font_EndGameScore.dispose();
	}
}
