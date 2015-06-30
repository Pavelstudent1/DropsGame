package com.test1.game;

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
	private com.test1.game.InputHelper input;
	private SpriteBatch batcher;
	private ObjectSupporter obj;
	private ShapeRenderer shaper;
	private BitmapFont fonter;
	
	private boolean debug_mode = true;

	public GameScreen() {
		
		cam = new OrthographicCamera();
		cam.setToOrtho(false, 800, 480); //при Y-вверх, отрисовка текстуры из начальной (x,y) идёт ВВЕРХ,
										 //т.е. начальная точка - НИЖНИЙ ЛЕВЫЙ угол текстуры!!!
		
		obj = new ObjectSupporter();

		input = new InputHelper(obj);
		Gdx.input.setInputProcessor(input);
		
		batcher = new SpriteBatch();
		batcher.setProjectionMatrix(cam.combined);
		
		fonter = new BitmapFont();
		
		shaper = new ShapeRenderer();
		shaper.setProjectionMatrix(cam.combined);
	}
	
	
	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(final float delta) {
		
//        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
        obj.bucket.moveBucket(input.outer_x, delta);
        obj.dropping(delta);
        if (TimeUtils.nanoTime() - obj.lastTimeFromDrop > 1000000000){
        	obj.spawnNewDrop();
        }
       
        
        batcher.begin();
        
        batcher.draw(AssetLoader.kitchen_img, 0, 0);
        fonter.draw(batcher, "Collected: " + obj.dropsGathered, 5, 480);
        fonter.draw(batcher, "Missed: " + obj.dropsMissed, 5, 460);
        
//        batcher.draw(obj.getBucket().texture, obj.getBucket().x, obj.getBucket().y);
        batcher.draw(obj.bucket.texture, obj.bucket.x, obj.bucket.y, obj.bucket.width / 2, obj.bucket.height / 2, 
        		obj.bucket.width, obj.bucket.height, 1, 1, obj.bucket.rotate, 
        		0, 0, obj.bucket.width, obj.bucket.height, false, false);
        for (Drop d : obj.drops) {
        	batcher.draw(d.texture, d.x, d.y);
		}
        
        batcher.end();
        
        if (debug_mode){
	        shaper.begin(ShapeType.Filled);
	        shaper.rect(obj.bucket.coliz.x, obj.bucket.coliz.y, obj.bucket.coliz.width, obj.bucket.coliz.height);
	        for (Drop d : obj.drops) {
	        	shaper.setColor(Color.RED);
	        	shaper.rect(d.coliz.x, d.coliz.y, d.coliz.width, d.coliz.height);
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
