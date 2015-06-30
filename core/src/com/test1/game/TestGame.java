package com.test1.game;

import com.badlogic.gdx.Game;

public class TestGame extends Game {
	
	@Override
	public void create() {
		AssetLoader.load();
		setScreen(new MainMenuScreen(this));
	}
	
	@Override
	public void render() {
		super.render();
	}
	
	@Override
	public void dispose() {
		
		AssetLoader.dispose();
		
		super.dispose();
	}
}
