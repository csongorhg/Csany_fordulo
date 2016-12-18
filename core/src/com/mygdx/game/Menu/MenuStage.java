package com.mygdx.game.Menu;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.MyButton;
import com.mygdx.game.MyBaseClasses.MyStage;
import com.mygdx.game.OtherScr.OtherScreen;
import com.mygdx.game.MyGdxGame;

import Music.GameMusic;

/**
 * Created by tuskeb on 2016. 09. 30..
 */
public class MenuStage extends MyStage {

    private TextButton textButton, textButton2, textButton3, textButton4;
    private TextButton.TextButtonStyle textButtonStyle;
    private GameMusic gameMusic;

    public MenuStage(Viewport viewport, Batch batch, MyGdxGame game) {
        super(viewport, batch, game);
    }


    public void init()
    {

        addBackEventStackListener();

        gameMusic = new GameMusic();
        gameMusic.addMusic(Assets.manager.get(Assets.TESTSOUND));



        textButton = new MyButton("Play", game.getTextButtonStyle());
        textButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new OtherScreen(game));
            }
        });

        textButton.setPosition(0,0);
        addActor(textButton);
    }


    @Override
    public void act(float delta) {
        super.act(delta);
        gameMusic.act();
        //gameMusic.setMusicVolume(gameMusic.getMusicVolume()-0.01f); //hangerő állítás
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
