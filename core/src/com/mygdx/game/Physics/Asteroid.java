package com.mygdx.game.Physics;

import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.OneSpriteStaticActor;

/**
 * Created by tanulo on 2016. 12. 19..
 */
public class Asteroid extends Block {

    public static float arany;

    public Asteroid() {
        actor = new OneSpriteStaticActor(Assets.manager.get(Assets.ASTEROIDA));
        actor.setSize(actor.getWidth()*arany,actor.getHeight()*arany);
    }
}
