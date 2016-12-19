package com.mygdx.game.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;

import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.Menu.StarStream;
import com.mygdx.game.MyBaseClasses.MyStage;
import com.mygdx.game.MyBaseClasses.OneSpriteStaticActor;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Physics.BadShip;
import com.mygdx.game.Physics.Dot;
import com.mygdx.game.Physics.SpaceShip;

import java.util.Vector;

/**
 * Created by tuskeb on 2016. 10. 31..
 */

public class GameStage extends MyStage {
    public static final String PREF_COUNT = "PREF_COUNT";
    public static SpaceShip ship;
    public static Vector<BadShip> badships;
    public static Vector<Dot> reddot;
    public static Vector<Dot> greendot;
    private OneSpriteStaticActor starRotate;
    private float width, height;


    public GameStage(Viewport viewport, Batch batch, MyGdxGame game) {
        super(viewport, batch, game);
    }

    @Override
    public void init() {
        /*addActor(starRotate= new StarRotate());
        starRotate.setSize(width,height);
        starRotate.setX(getViewport().getWorldWidth()/2);

        starRotate.setZIndex(0);

        StarStream.size[0] = width;
        StarStream.size[1] = height;*/
        addActor(starRotate = new OneSpriteStaticActor(Assets.manager.get(Assets.STAR)));

        ship = new SpaceShip();
        addActor(ship.actor);
        ship.actor.setPosition(width/2-ship.actor.getWidth()/2,height/10*9);

        badships = new Vector<BadShip>();
        greendot = new Vector<Dot>();
        reddot = new Vector<Dot>();

    }

    @Override
    public void act(float delta) {
        super.act(delta);
        shipPhysics();
        enemyPhysics();
        greenPhysics();
        redPhysics();
        backgroundPhysics();
    }

    private void shipPhysics() {
        ship.actor.setX(ship.actor.getX() + Gdx.input.getAccelerometerX());
    }

    private void enemyPhysics() {
    }

    private void greenPhysics() {
    }

    private void redPhysics() {
    }

    private void backgroundPhysics() {

    }

    @Override
    protected void resized() {
        super.resized();
        setCameraResetToLeftBottomOfScreen();
        width = (((ExtendViewport)getViewport()).getWorldWidth());
        height = ((getViewport()).getWorldHeight());
    }

}
