package com.mygdx.game.GameDescription;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.MyButton;
import com.mygdx.game.MyBaseClasses.MyLabel;
import com.mygdx.game.MyBaseClasses.MyStage;
import com.mygdx.game.MyGdxGame;

/**
 * Created by tuskeb on 2016. 09. 30..
 */
public class DescriptionStage extends MyStage {

    private TextButton textButton;
    private MyLabel myLabel;
    private String s;




    public DescriptionStage(Viewport viewport, Batch batch, MyGdxGame game) {
        super(viewport, batch, game);
    }


    public void init() {
        addBackEventStackListener();

        s = "asd";

        myLabel = new MyLabel(s, OtherStageLabelStyle());
        addActor(myLabel);

        textButton = new MyButton("Back", game.getTextButtonStyle());
        textButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreenBackByStackPop();
            }
        });
        addActor(textButton);


        resized();
    }

    private Label.LabelStyle OtherStageLabelStyle(){
            Label.LabelStyle style;
            style = new com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle();
            style.font = Assets.manager.get(Assets.APPLESTORMITA_FONT);
            style.fontColor = Color.YELLOW;
            Pixmap p = new Pixmap(1,1, Pixmap.Format.RGB888);
            p.setColor(0.4f,0.2f,0.8f, 0.5f);
            p.fill();
            return style;
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    protected void resized() {
        super.resized();
        setCameraResetToLeftBottomOfScreen();

        textButton.setPosition(((ExtendViewport)getViewport()).getMinWorldWidth()/2 - textButton.getWidth()/2, 0);
        myLabel.setPosition(((ExtendViewport) getViewport()).getMinWorldWidth()/2-myLabel.getWidth()/2, ((ExtendViewport) getViewport()).getMinWorldHeight()-myLabel.getHeight()-10f);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
