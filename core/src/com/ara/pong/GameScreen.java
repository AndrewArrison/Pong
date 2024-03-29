package com.ara.pong;

import com.ara.pong.Entity.Ball;
import com.ara.pong.Entity.ComputerPaddle;
import com.ara.pong.Entity.Paddle;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameScreen extends ScreenAdapter {

	private ShapeRenderer shapeRenderer;
	private SpriteBatch spriteBatch;
	private BitmapFont bitmapFont;
	private Ball ball;
	private Paddle player_paddle;
	private ComputerPaddle aiPaddle;


	@Override
	public void show () {
		shapeRenderer = new ShapeRenderer();
		spriteBatch = new SpriteBatch();
		bitmapFont = new BitmapFont();
		ball = new Ball(this);
		player_paddle = new Paddle();
		aiPaddle = new ComputerPaddle(this);
	}

    @Override
	public void render (float delta) {
		ball.update(delta);
		player_paddle.update(delta);
		aiPaddle.update(delta);
    	ScreenUtils.clear(0, 0, 0, 1);
		// Gdx.app.log("GameScreen", "Render");
		shapeRenderer.begin(ShapeType.Filled);
		player_paddle.render(shapeRenderer);
		aiPaddle.render(shapeRenderer);
		ball.render(shapeRenderer);
		shapeRenderer.end();
		spriteBatch.begin();
		ball.renderScore(bitmapFont, spriteBatch);
		bitmapFont.draw(spriteBatch, "Clone By - ARA", 750, 50);
		bitmapFont.draw(spriteBatch, "ARA Interactive", 750,30);
		spriteBatch.end();
	}

	@Override
	public void dispose () {
        shapeRenderer.dispose();
		bitmapFont.dispose();
		spriteBatch.dispose();
		// Gdx.app.log("GameScreen", "Dispose");
	}

	public Ball gBall() {
		return ball;
	}

	public Paddle gPaddle() {
		return player_paddle;
	}

}
