package com.mygdx.game.Menu;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.OneSpriteStaticActor;

/**
 * Created by tanulo on 2016. 12. 19..
 */
public class StarStream extends OneSpriteStaticActor {

    private boolean createNew=false;
    public static float size[] = new float[2];

    public StarStream() {
        super(Assets.manager.get(Assets.STAR));
    }

    @Override
    public void init() {
        super.init();
        //setScale(3);
        setSize(size[0],size[1]);
        setZIndex(0);
        setPosition(-getWidth(),0);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        setX(getX()+120*delta);
        setZIndex(0);
        if (getX()>getStage().getViewport().getWorldWidth()){
            getStage().getActors().removeValue(this,true);
        }
        if (getX()>=0 && !createNew){
            createNew = true;
            getStage().addActor(new StarStream());
            Actor a = getStage().getActors().get(getStage().getActors().size-1);
            a.setPosition(getX()-a.getWidth(),0);
        }

    }
}
