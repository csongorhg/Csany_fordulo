package com.mygdx.game.Menu;

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

    public MenuStage(Viewport viewport, Batch batch, MyGdxGame game) {
        super(viewport, batch, game);
    }


    public void init()
    {

        addBackEventStackListener();



        play = new OneSpriteStaticActor(Assets.manager.get(Assets.PLAY));
        play.setSize(300,300);
        play.setPosition(((ExtendViewport)getViewport()).getMinWorldWidth()/2 - play.getWidth()/2,
                ((ExtendViewport)getViewport()).getMinWorldHeight());
        play.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new OtherScreen(game) );
            }
        });
        addActor(play);

        resized();

        System.out.println(play.getX()+" "+play.getY());

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
    }
}
