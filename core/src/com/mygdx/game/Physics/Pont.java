package com.mygdx.game.Physics;

import com.mygdx.game.MyBaseClasses.OneSpriteStaticActor;

/**
 * Created by tanulo on 2016. 12. 19..
 */
public class Pont {

    private float x;
    private float y;

    public Pont(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public static boolean utkozik(OneSpriteStaticActor a, OneSpriteStaticActor b){
        if(a.getY() > b.getY() + b.getHeight() || a.getY()+ a.getHeight() < b.getY() || a.getX() > b.getX() + b.getWidth() || a.getX()+ a.getWidth() < b.getX()){
            return false;
        }
        return true;
    }
}
