package com.CatchDrop.helpers;

import com.CatchDrop.gameObjects.Bucket;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

public class InputHelper implements InputProcessor{
	
	public int outer_x;
	public int outer_y;

	public InputHelper(Bucket bucket) {
		
		outer_x = Gdx.graphics.getWidth() / 2; //начальное положение ведёрка
		
	}
	
	
	
	@Override
	public boolean keyDown(final int keycode) {
		
		return false;
	}

	@Override
	public boolean keyUp(final int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(final char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(final int screenX, final int screenY, final int pointer, final int button) {
		
		outer_x = screenX;
		outer_y = screenY;
			
		return false;
	}

	@Override
	public boolean touchUp(final int screenX, final int screenY, final int pointer, final int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(final int screenX, final int screenY, final int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(final int screenX, final int screenY) {

		return false;
	}

	@Override
	public boolean scrolled(final int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
