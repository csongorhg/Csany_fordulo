package com.mygdx.game.Physics;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.OneSpriteStaticActor;

/**
 * Created by tanulo on 2016. 12. 19..
 */
public class BadShip extends Block {

    public BadShip() {
        actor = new OneSpriteStaticActor(Assets.manager.get(Assets.BADSHIP));
    }
}
