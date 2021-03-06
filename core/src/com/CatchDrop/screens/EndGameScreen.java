package com.CatchDrop.screens;

import com.CatchDrop.TimeAndScore.DropAccumulator;
import com.CatchDrop.TimeAndScore.GameTimers;
import com.CatchDrop.TimeAndScore.ScoreAccumulator;
import com.CatchDrop.helpers.AssetLoader;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EndGameScreen implements Screen{
	
	private OrthographicCamera cam;
	private BitmapFont fonter;
	private SpriteBatch batcher;
	private Game game;
	
	
	public EndGameScreen(Game game) {
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

        AssetLoader.font_EndGameScore.draw(batcher, "Total score: " + ScoreAccumulator.getScoreString(), 5, 400);
        AssetLoader.font_EndGameScore.draw(batcher, "Drop collected: " + DropAccumulator.getCollected(), 5, 350);
        AssetLoader.font_EndGameScore.draw(batcher, "Drop missed: " + DropAccumulator.getMissed(), 5, 300);
        AssetLoader.font_EndGameScore.draw(batcher, "Total time: " + ScoreAccumulator.getTotalTimeString(), 5, 250);
        
        
        batcher.end();
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
		// TODO Auto-generated method stub
		
	}

}
