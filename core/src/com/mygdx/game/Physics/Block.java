package com.mygdx.game.Physics;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyBaseClasses.OneSpriteStaticActor;

/**
 * Created by tanulo on 2016. 12. 19..
 */
public class Block {

    Texture t;
    public OneSpriteStaticActor actor;

    public float[] getPoz() {
        float t[] = new float[2];
        t[0] = actor.getX();
        t[1] = actor.getY();
        return t;
    }

    public float getWidth() {
        return actor.getWidth();
    }
    public float getHeight() {
        return actor.getHeight();
    }

}
