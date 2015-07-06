package com.CatchDrop.screens;

import com.CatchDrop.helpers.AssetLoader;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class StartMenuScreen implements Screen{
	
	private OrthographicCamera cam;
	private BitmapFont fonter;
	private SpriteBatch batcher;
	private Game game;
	
	private int stopPoint;
	private int currentPoint;
	
	public StartMenuScreen(final Game game) {
		this.game = game;
		cam = new OrthographicCamera();
		cam.setToOrtho(false, 800, 480);
		
		batcher = new SpriteBatch();
		batcher.setProjectionMatrix(cam.combined);
		fonter = new BitmapFont();
		
		stopPoint = 300;
		currentPoint = 500;
		
	}
	
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(final float delta) {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        batcher.begin();
        
        if (currentPoint > stopPoint) {
			currentPoint -= 200 * delta;
		}
        AssetLoader.font_StartScreen.draw(batcher, "Welcome to CatchDropGame", 120, currentPoint);
        
        if (currentPoint <= stopPoint ){
        	AssetLoader.font_StartScreen.draw(batcher, "Tap anywhere to start", 190, 150);
        }
        
        batcher.end();
        
        if (currentPoint <= stopPoint && Gdx.input.isTouched()){
        	game.setScreen(new GameScreen(game));
        	dispose();
        }
	}

	@Override
	public void resize(final int width, final int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		batcher.dispose();
		fonter.dispose();
	}

}
