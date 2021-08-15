package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.Timer;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	private Music music;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		// 135 seconds track
		music = Gdx.audio.newMusic(Gdx.files.internal("24STRINGSBASSSOLO1.mp3"));
		music.play();

		Timer.instance().scheduleTask(new Timer.Task() {
			@Override
			public void run() {
				music.setPosition(134); // expect it to play for only 1 second, instead it plays almost 10.
			}
		}, 0.1f);
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		music.dispose();
	}
}
