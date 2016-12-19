package com.mygdx.game.GameDescription;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.mygdx.game.MyBaseClasses.MyScreen;
import com.mygdx.game.MyGdxGame;

/**
 * Created by tuskeb on 2016. 09. 30...
 */
public class DescriptionScreen extends MyScreen {
    protected DescriptionStage descriptionStage;

    public DescriptionScreen(MyGdxGame game) {
        super(game);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        descriptionStage.act(delta);
        descriptionStage.draw();

    }

    @Override
    public void init() {
        r = 1;
        g = 0.5f;
        b = 0.3f;
        descriptionStage = new DescriptionStage(new ExtendViewport(1280,720,new OrthographicCamera(1280,720)), spriteBatch, game);
        Gdx.input.setInputProcessor(descriptionStage);
    }
}
