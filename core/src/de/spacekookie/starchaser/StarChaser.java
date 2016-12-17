package de.spacekookie.starchaser;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class StarChaser extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img, background;
	Vector2 position;

	ShipInputHandle input;

	@Override
	public void create() {
		batch = new SpriteBatch();
		img = new Texture("artpack1/uss_pixel.png");
		background = new Texture("artpack1/background.png");

		position = new Vector2(250, 150);
		input = new ShipInputHandle(position);

		Gdx.input.setInputProcessor(input);
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		input.update();

		batch.begin();
		batch.draw(background, 0, 0);
		batch.draw(img, position.x, position.y);
		batch.end();
	}

	@Override
	public void dispose() {
		batch.dispose();
		img.dispose();
	}
}
