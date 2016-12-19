package com.mygdx.game.Score;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Game.GameStage;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.Menu.MenuScreen;
import com.mygdx.game.Menu.MenuStage;
import com.mygdx.game.Menu.StarStream;
import com.mygdx.game.MyBaseClasses.MyLabel;
import com.mygdx.game.MyBaseClasses.MyStage;
import com.mygdx.game.MyBaseClasses.OneSpriteStaticActor;
import com.mygdx.game.MyGdxGame;

/**
 * Created by Kicsi on 2016. 12. 19..
 */

public class ScoreStage extends MyStage{

    private float width, height;
    private MyLabel myLabel, myLabel2;
    private OneSpriteStaticActor back;
    private OneSpriteStaticActor sound;
    private StarStream starStream;

    public ScoreStage(Viewport viewport, Batch batch, MyGdxGame game) {
        super(viewport, batch, game);
    }

    public void init() {
        addBackEventStackListener();
        resized();

        addActor(starStream= new StarStream());
        starStream.setX(getViewport().getWorldWidth()-starStream.getWidth());
        starStream.setSize(width,height);
        starStream.setZIndex(0);

        StarStream.size[0] = width;
        StarStream.size[1] = height;

        soundgenerate();

        myLabel = new MyLabel("Score: "+ GameStage.score+"\n\rTime: "+GameStage.time[0]+":"+GameStage.time[1], game.getLabelStyle());
        addActor(myLabel);
        myLabel.setZIndex(1);
        myLabel.setPosition(width/2-myLabel.getWidth()/2, height-sound.getHeight()-10f);

        /*myLabel2 = new MyLabel("NEW BEST SCORE", game.getLabelStyle());
        addActor(myLabel2);
        myLabel2.setZIndex(1);
        myLabel2.setPosition(width/2-myLabel2.getWidth()/2, myLabel.getY()-myLabel2.getHeight()-10f);*/

        back = new OneSpriteStaticActor(Assets.manager.get(Assets.BACK));
        addActor(back);
        back.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreenBackByStackPop();
            }
        });
        back.setZIndex(1);
        back.setPosition(width/2-back.getWidth()/2, myLabel.getY()-back.getHeight()-10f);
    }

    void soundgenerate(){
        //SOUND
        sound = new OneSpriteStaticActor(MenuStage.musicPlay? Assets.manager.get(Assets.SOUND):Assets.manager.get(Assets.NOSOUND));
        if(MenuStage.musicPlay) MenuScreen.gMusic.setVolume(1f);
        else MenuScreen.gMusic.setVolume(0f);
        sound.setSize(100f,100f);
        sound.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                MenuStage.musicPlay=!MenuStage.musicPlay;
                soundgenerate();
            }
        });
        sound.setZIndex(1);
        sound.setPosition(width-sound.getWidth(),height-sound.getHeight());
        addActor(sound);
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
