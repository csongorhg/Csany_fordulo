package com.mygdx.game.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.MyScreen;
import com.mygdx.game.MyBaseClasses.MyStage;
import com.mygdx.game.MyBaseClasses.OneSpriteStaticActor;
import com.mygdx.game.MyGdxGame;

/**
 * Created by tuskeb on 2016. 10. 31..
 */

public class GameScreen extends MyScreen {

    public static final String PREFS = "Valami";
    private Preferences preferences = Gdx.app.getPreferences(PREFS);
    protected GameStage gameStage;
    protected MyStage bgStage;
    private float width, height;

    public GameScreen(MyGdxGame game) {
        super(game);
    }

    @Override
    public void init() {
        super.init();
        gameStage = new GameStage(new ExtendViewport(1280,720,new OrthographicCamera(1280,720)), spriteBatch, game);
        Gdx.input.setInputProcessor(gameStage);

        //háttér
        bgStage = new MyStage(new StretchViewport(90,160, new OrthographicCamera(90,160)), spriteBatch, game) {

            private OneSpriteStaticActor backGroudActor;

            @Override
            public void init() {
                resized();
                addActor(backGroudActor = new OneSpriteStaticActor(Assets.manager.get(Assets.STAR)));
                backGroudActor.setSize(width,height);
            }

            @Override
            protected void resized() {
                width = ((getViewport()).getWorldWidth());
                height = ((getViewport()).getWorldHeight());
            }
        };
        //háttér vége
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        bgStage.draw();
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
