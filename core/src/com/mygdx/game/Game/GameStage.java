package com.mygdx.game.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.Menu.StarStream;
import com.mygdx.game.MyBaseClasses.MyStage;
import com.mygdx.game.MyBaseClasses.OneSpriteStaticActor;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Physics.Asteroid;
import com.mygdx.game.Physics.BadShip;
import com.mygdx.game.Physics.Dot;
import com.mygdx.game.Physics.SpaceShip;
import com.mygdx.game.Score.ScoreScreen;

import java.util.Vector;

/**
 * Created by tuskeb on 2016. 10. 31..
 */

public class GameStage extends MyStage {
    public static final String PREF_COUNT = "PREF_COUNT";
    public static SpaceShip ship;
    public static Vector<BadShip> badships;
    public static Vector<Asteroid> asteroids;
    public static Vector<Dot> reddot;
    public static Vector<Dot> greendot;
    private StarRotate starRotate;
    private float width, height;
    private float speed = 0.5f;
    private float timer;
    public static int time[], score;
    OneSpriteStaticActor back;


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

        addActor(starRotate= new StarRotate());
        starRotate.setSize(width,height);

        starRotate.setZIndex(0);

        StarStream.size[0] = width;
        StarStream.size[1] = height;
        addActor(starRotate = new StarRotate());

        ship = new SpaceShip();
        addActor(ship.actor);
        float arany = (width/5.0f)/ship.actor.getHeight()/4;
        Dot.arany = arany/1.5f;
        BadShip.arany = arany/1.5f;

        ship.actor.setSize(ship.getWidth()*arany,ship.getHeight()*arany);
        ship.actor.setPosition(width/2-(ship.actor.getWidth()*arany)/2,(height/10));

        badships = new Vector<BadShip>();
        greendot = new Vector<Dot>();
        reddot = new Vector<Dot>();
        asteroids = new Vector<Asteroid>();

        generateBadShips();
        generateAsteroids();
    }

    private void generateBadShips() {
        BadShip b = new BadShip();
        float plusz = (width-width/b.getWidth())/((width/b.getWidth())+2);
        float x = plusz+b.actor.getWidth()/1.5f;
        for (int i = 0; i < width/b.getWidth()-1; i++){
            System.out.println(i);
            b = new BadShip();
            addActor(b.actor);
            badships.add(b);
            b.actor.setSize(b.getWidth(),b.getHeight());
            b.actor.setPosition(x,height-b.getHeight());
            x += plusz+b.actor.getWidth()/1.5f;
        }
    }

    private void generateAsteroids() {

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
        for (int i = 0; i < badships.size() ; i++){
        }
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
