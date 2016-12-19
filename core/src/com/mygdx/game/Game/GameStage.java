package com.mygdx.game.Game;

import com.badlogic.gdx.graphics.g2d.Batch;

import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyBaseClasses.MyStage;
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


    public GameStage(Viewport viewport, Batch batch, MyGdxGame game) {
        super(viewport, batch, game);
    }

    @Override
    public void init() {
        ship = new SpaceShip();
        badships = new Vector<BadShip>();
        greendot = new Vector<Dot>();
        reddot = new Vector<Dot>();
    }

    @Override
    public void act(float delta) {
        shipPhysics();
        enemyPhysics();
        greenPhysics();
        redPhysics();
    }

    private void shipPhysics() {
    }

    private void enemyPhysics() {
    }

    private void greenPhysics() {
    }

    private void redPhysics() {
    }

}
