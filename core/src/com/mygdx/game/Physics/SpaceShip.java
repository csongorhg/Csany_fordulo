package com.mygdx.game.Physics;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyBaseClasses.OneSpriteActor;

/**
 * Created by tanulo on 2016. 12. 19..
 */
public class SpaceShip extends Block {

    private OneSpriteActor oneSpriteActor;

    public SpaceShip(int id, float weight, Texture t) {
        super(id, weight, t);
        //oneSpriteActor = new OneSpriteActor(Assets.manager.get(Assets));
    }
}
