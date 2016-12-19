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
    private StarRotate starRotate;
    private float width, height;
    private float timer;
    public static int time[], score;


    public GameStage(Viewport viewport, Batch batch, MyGdxGame game) {
        super(viewport, batch, game);
    }

    @Override
    public void init() {
        time = new int[2];
        timer=0;
        score = 0;

        resized();

        addActor(starRotate= new StarRotate());
        starRotate.setSize(width,height);

        starRotate.setZIndex(0);

        StarStream.size[0] = width;
        StarStream.size[1] = height;
        addActor(starRotate = new StarRotate());

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
        timer+=delta;
        int t = (int)(timer/60*100);
        time[0] = t/60;
        time[1] = t%60;
        shipPhysics();
        enemyPhysics();
        greenPhysics();
        redPhysics();
        backgroundPhysics();
    }

    private void shipPhysics() {
        if (ship.actor.getX() <= width && ship.actor.getX() >= -1) {
            ship.actor.setX(ship.actor.getX() + Gdx.input.getAccelerometerY());
        }
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
