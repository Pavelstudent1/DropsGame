package com.test1.game;

import com.badlogic.gdx.InputProcessor;

public class InputHelper implements InputProcessor{
	
	private ObjectSupporter obj;
	
	int outer_x;
	int outer_y;

	public InputHelper(final ObjectSupporter objgen) {
	
		this.obj = objgen;
		outer_x = objgen.bucket.x;
		
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
		
//		System.out.println("touchDown");
		outer_x = screenX;
		outer_y = screenY;
//		System.out.println("Tapped at [" + screenX + "," + screenY + "]");
		
		
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
