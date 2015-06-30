package com.test1.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainMenuScreen implements Screen {
	
	private OrthographicCamera cam;
	private BitmapFont fonter;
	private SpriteBatch batcher;
	private Game game;

	public MainMenuScreen(Game game) {
		
		this.game = game;
		cam = new OrthographicCamera();
		cam.setToOrtho(false, 800, 480);
		
		batcher = new SpriteBatch();
		batcher.setProjectionMatrix(cam.combined);
		fonter = new BitmapFont();
		
	}
	
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        batcher.begin();
        fonter.draw(batcher, "WELCOME to CatchDropGame", 300, 300);
        fonter.draw(batcher, "Tap anywhere to start!", 300, 250);
        batcher.end();
        
        if (Gdx.input.isTouched()){
        	game.setScreen(new GameScreen());
        	dispose();
        }
		
	}

	@Override
	public void resize(int width, int height) {
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
