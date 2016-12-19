package com.mygdx.game.Game;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.OneSpriteAnimatedActor;

/**
 * Created by Vince on 2016. 12. 19..
 */

public class ExplosionActor extends OneSpriteAnimatedActor {
    public ExplosionActor() {
        super(Assets.manager.get(Assets.EXPLOSION_TEXTUREATLAS));
        setFps(30);

        addListener(new ClickListener()
        {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                running = !running;
            }
        });
    }

}