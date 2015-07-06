package com.CatchDrop.screens;

import java.util.prefs.BackingStoreException;

import com.CatchDrop.TimeAndScore.GameTimers;
import com.CatchDrop.TimeAndScore.ScoreAccumulator;
import com.CatchDrop.gameObjects.Bucket;
import com.CatchDrop.gameObjects.Drop;
import com.CatchDrop.gameObjects.RainGenerator;
import com.CatchDrop.helpers.AssetLoader;
import com.CatchDrop.helpers.InputHelper;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.TimeUtils;

public class GameScreen implements Screen {
	
	private OrthographicCamera cam;
	private InputHelper input;
	private SpriteBatch batcher;
	private RainGenerator rg;
	private ShapeRenderer shaper;
	private BitmapFont fonter;
	
	private boolean debug_mode = false;
	private GameTimers timer;
	private Bucket bucket;
	private float runTime;
	private Game game;

	public GameScreen(Game game) {
		
		this.game = game;
		cam = new OrthographicCamera();
		cam.setToOrtho(false, 800, 480);
		
		timer = new GameTimers(15);
		
		bucket = new Bucket();
		rg = new RainGenerator(bucket, timer);
		
		
		input = new InputHelper(bucket);
		Gdx.input.setInputProcessor(input);
		
		batcher = new SpriteBatch();
		batcher.setProjectionMatrix(cam.combined);
		
		fonter = new BitmapFont();
		
		shaper = new ShapeRenderer();
		shaper.setProjectionMatrix(cam.combined);
		
		timer.startTimer();
		
		runTime = 0;
	}
	
	
	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(final float delta) {
		runTime += delta;
		
		bucket.moveBucket(input.outer_x, delta);
        rg.dropping(delta);
        if (rg.isSpawnNeed()){
        	rg.spawnNewDrop();
        }
       
        
        batcher.begin();
        batcher.disableBlending();
        batcher.draw(AssetLoader.kitchen_img, 0, 0);
        batcher.enableBlending();
        
        AssetLoader.font_InGameScore.draw(batcher, "Collected: " + ScoreAccumulator.getScoreString(), 5, 480);
        AssetLoader.font_InGameScore.draw(batcher, "Elapsed: " + timer.getCurrentTimeString(), 5, 440);
        
        
        if (timer.isGameOver()){
        	timer.stopTimer();
        	ScoreAccumulator.setTotalTime(timer.getTotalTime());
        	game.setScreen(new EndGameScreen(game));
        }
        
        batcher.draw(bucket.getTexture(), bucket.getX(), bucket.getY(), bucket.getWidth() / 2, 
        		bucket.getHeight() / 2, bucket.getWidth(), bucket.getHeight(), 1, 1, 
        		bucket.getRotate(), 0, 0, bucket.getWidth(), bucket.getHeight(), false, false);
        
        for (Drop d : rg.getDropsData()) {
        	batcher.draw(AssetLoader.drops_animation.getKeyFrame(runTime), 
        			d.getX(), d.getY(), d.getWidth() / 2, d.getHeight() / 2, 
        			d.getWidth(), d.getHeight(), d.getScaleX(), d.getScaleY(), 0.0f);
		}
        
        batcher.end();
        
        if (debug_mode){
	        shaper.begin(ShapeType.Filled);
	        shaper.rect(bucket.getColizShape().x, bucket.getColizShape().y, bucket.getColizShape().width, 
	        			bucket.getColizShape().height);
	        for (Drop d : rg.getDropsData()) {
	        	shaper.setColor(Color.RED);
	        	shaper.rect(d.getColizShape().x, d.getColizShape().y, d.getColizShape().width, 
	        				d.getColizShape().height);
			}
	        shaper.end();
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
		shaper.dispose();
		fonter.dispose();
	}

}
