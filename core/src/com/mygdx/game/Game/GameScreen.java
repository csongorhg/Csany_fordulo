package com.mygdx.game.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.mygdx.game.MyBaseClasses.MyScreen;
import com.mygdx.game.MyGdxGame;

/**
 * Created by tuskeb on 2016. 10. 31..
 */

public class GameScreen extends MyScreen {

    public static final String PREFS = "Valami";
    private Preferences preferences = Gdx.app.getPreferences(PREFS);
    protected GameStage gameStage;

    public GameScreen(MyGdxGame game) {
        super(game);
    }

    @Override
    public void init() {
        super.init();
        setBackGroundColor(0.2f,0.4f,0.8f);
        gameStage = new GameStage(new ExtendViewport(1280,720,new OrthographicCamera(1280,720)), spriteBatch, game);
        Gdx.input.setInputProcessor(gameStage);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        gameStage.act(delta);
        gameStage.draw();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void dispose() {
        preferences.flush();
        super.dispose();
    }

    @Override
    public void hide() {
        preferences.flush();
        super.hide();
    }
}
