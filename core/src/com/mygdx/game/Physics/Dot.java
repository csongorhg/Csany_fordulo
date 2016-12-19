package com.mygdx.game.Physics;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.OneSpriteStaticActor;

/**
 * Created by tanulo on 2016. 12. 19..
 */
public class Dot extends Block {

    public static float arany;

    public Dot(boolean green) {
        if(green)
            actor = new OneSpriteStaticActor(Assets.manager.get(Assets.GREENDOT));
        else
            actor = new OneSpriteStaticActor(Assets.manager.get(Assets.REDDOT));
        actor.setSize(actor.getWidth()*arany,actor.getHeight()*arany);
    }
}
