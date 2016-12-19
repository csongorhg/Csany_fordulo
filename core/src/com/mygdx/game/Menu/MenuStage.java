package com.mygdx.game.Menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.MyButton;
import com.mygdx.game.MyBaseClasses.MyStage;
import com.mygdx.game.MyBaseClasses.OneSpriteStaticActor;
import com.mygdx.game.OtherScr.OtherScreen;
import com.mygdx.game.MyGdxGame;

import Music.GameMusic;

/**
 * Created by tuskeb on 2016. 09. 30..
 */
public class MenuStage extends MyStage {

    private TextButton textButton, textButton2, textButton3, textButton4;
    private TextButton.TextButtonStyle textButtonStyle;
    private OneSpriteStaticActor play, settings, exit;
    private GameMusic gameMusic;
    private float width, height;

    public MenuStage(Viewport viewport, Batch batch, MyGdxGame game) {
        super(viewport, batch, game);
    }


    public void init()
    {

        addBackEventStackListener();

        resized();

        //PLAY
        play = new OneSpriteStaticActor(Assets.manager.get(Assets.PLAY));
        play.setSize(200,200);
        play.setPosition(width*(1/4f) - play.getWidth()/2, height/2 - play.getHeight()/2);
        play.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new OtherScreen(game) );
            }
        });
        addActor(play);



        //SETTINGS
        settings = new OneSpriteStaticActor(Assets.manager.get(Assets.SETTINGS));
        settings.setSize(200,200);
        settings.setPosition(width*(2/4f) - settings.getWidth()/2, height/2 - settings.getHeight()/2);
        /*settings.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new SettingsScreen(game) );
            }
        });*/
        addActor(settings);



        //EXIT
        exit = new OneSpriteStaticActor(Assets.manager.get(Assets.EXIT));
        exit.setSize(200,200);
        exit.setPosition(width*(3/4f) - exit.getWidth()/2, height/2 - exit.getHeight()/2);
        exit.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                Gdx.app.exit();
                }
        });
        addActor(exit);



    }


    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    protected void resized() {
        super.resized();
        setCameraResetToLeftBottomOfScreen();
        width = (((ExtendViewport)getViewport()).getWorldWidth());
        height = ((getViewport()).getWorldHeight());
    }
}
