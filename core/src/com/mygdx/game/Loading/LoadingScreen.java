package com.mygdx.game.Loading;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.Menu.MenuScreen;
import com.mygdx.game.MyBaseClasses.MyScreen;
import com.mygdx.game.GlobalClasses.*;
import com.mygdx.game.MyBaseClasses.MyStage;
import com.mygdx.game.MyBaseClasses.OneSpriteAnimatedActor;
import com.mygdx.game.MyBaseClasses.OneSpriteStaticActor;
import com.mygdx.game.MyGdxGame;

import Music.GameMusic;


public class LoadingScreen extends MyScreen {


	private Stage stage;
	private OneSpriteStaticActor text;
	private float elapsedTime = 0;
	private BitmapFont bitmapFont = new BitmapFont();
	private OneSpriteAnimatedActor picture;
	private GameMusic gameMusic;
	GlyphLayout layout;

    public LoadingScreen(MyGdxGame game) {
		super(game);
		stage = new Stage();


		FreeTypeFontGenerator fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("Font/acmeregular.ttf"));
		FreeTypeFontGenerator.FreeTypeFontParameter fontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		fontParameter.size = 25;
		bitmapFont = fontGenerator.generateFont(fontParameter);

		picture = new OneSpriteAnimatedActor("Menu/load.txt")
		{
			@Override
			public void init() {
				super.init();
				setFps(12);
			}

			@Override
			public void act(float delta) {
				super.act(delta);
				setRotation(360-elapsedTime*100);
			}
		};
		stage.addActor(picture);

		picture.setPosition(stage.getWidth()/2- picture.getWidth()/2,stage.getHeight()/2- picture.getHeight()/2);

		text = new OneSpriteStaticActor("Menu/justszoveg.png");
		stage.addActor(text);
		text.setPosition(stage.getWidth()/2-text.getWidth()/2,stage.getHeight()/2-text.getHeight()/2);


    }


    @Override
	public void show() {
	    Assets.manager.finishLoading();
		Assets.load();
	}

	@Override
	public void render(float delta) {
		super.render(delta);
		stage.act(delta);
		stage.draw();

		layout = new GlyphLayout(bitmapFont, "Betöltés: "+(int)(Assets.manager.getProgress()*100f)+" %");
		float width = layout.width;

		spriteBatch.begin();
		bitmapFont.draw(spriteBatch,"Betöltés: "+ ((int)(Assets.manager.getProgress()*100f))+" %", Gdx.graphics.getWidth()/2-width/2,text.getY()+80);
		spriteBatch.end();


		if (elapsedTime > 4.0 && Assets.manager.update()) {
			Assets.afterLoaded();
			music();
			game.setScreen(new MenuScreen(game));
		}

		elapsedTime+=delta;

	}

	private void music() {
		gameMusic = new GameMusic();
		gameMusic.addMusic(Assets.manager.get(Assets.TESTSOUND));
		gameMusic.act();
	}

	@Override
	public void hide() {

	}

	@Override
	public void init() {
		setBackGroundColor(0f, 0f, 0f);
	}
}