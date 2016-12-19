//https://github.com/tuskeb/mester
package com.mygdx.game.GlobalClasses;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;

public class Assets {

	public static AssetManager manager;
	public static final String CHARS = "0123456789öüóqwertzuiopőúasdfghjkléáűíyxcvbnm'+!%/=()ÖÜÓQWERTZUIOPŐÚASDFGHJKLÉÁŰÍYXCVBNM?:_*<>#&@{}[],-.";

	//FONT
	static final FreetypeFontLoader.FreeTypeFontLoaderParameter fontParameter = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
	static {
		fontParameter.fontFileName = "Font/Pixelfont.ttf";
		fontParameter.fontParameters.size = 50;
		fontParameter.fontParameters.characters = CHARS;
		fontParameter.fontParameters.color = Color.WHITE;
	}
	public static final AssetDescriptor<BitmapFont> PIXEL_FONT
			= new AssetDescriptor<BitmapFont>(fontParameter.fontFileName, BitmapFont.class, fontParameter);


	static final FreetypeFontLoader.FreeTypeFontLoaderParameter fontParameter2 = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
	static {
		fontParameter2.fontFileName = "Font/AppleStormXbdIta.otf";
		fontParameter2.fontParameters.size = 50;
		fontParameter2.fontParameters.characters = CHARS;
		fontParameter2.fontParameters.color = Color.WHITE;
	}
	public static final AssetDescriptor<BitmapFont> APPLESTORMITA_FONT
			= new AssetDescriptor<BitmapFont>(fontParameter2.fontFileName, BitmapFont.class, fontParameter2);



	//MUSIC
	public static final AssetDescriptor<Music> GAMEMUSIC
			= new AssetDescriptor<Music>("Music/bensound-epic.mp3", Music.class);



	//ATLAS
	public static final AssetDescriptor<TextureAtlas> EXPLOSION_TEXTUREATLAS
			= new AssetDescriptor<TextureAtlas>("Explosion/explosion.atlas", TextureAtlas.class);



	//TEXTURE
	public static final AssetDescriptor<Texture> BACKGROUND
			= new AssetDescriptor<Texture>("Play/space.png", Texture.class);
	public static final AssetDescriptor<Texture> PLAY
			= new AssetDescriptor<Texture>("Menu/play.png", Texture.class);
	public static final AssetDescriptor<Texture> SETTINGS
			= new AssetDescriptor<Texture>("Menu/cog.png", Texture.class);
	public static final AssetDescriptor<Texture> EXIT
			= new AssetDescriptor<Texture>("Menu/exit.png", Texture.class);
	public static final AssetDescriptor<Texture> MYSHIP
			= new AssetDescriptor<Texture>("Play/myship.png", Texture.class);
	public static final AssetDescriptor<Texture> ASTEROIDA
			= new AssetDescriptor<Texture>("Play/asteroida.png", Texture.class);
	public static final AssetDescriptor<Texture> BADSHIP
			= new AssetDescriptor<Texture>("Play/badship.png", Texture.class);
	public static final AssetDescriptor<Texture> REDDOT
			= new AssetDescriptor<Texture>("Play/reddot.png", Texture.class);
	public static final AssetDescriptor<Texture> GREENDOT
			= new AssetDescriptor<Texture>("Play/greendot.png", Texture.class);
	public static final AssetDescriptor<Texture> BACK
			= new AssetDescriptor<Texture>("Menu/back.png", Texture.class);
	public static final AssetDescriptor<Texture> SOUND
			= new AssetDescriptor<Texture>("Menu/sound.png", Texture.class);
	public static final AssetDescriptor<Texture> NOSOUND
			= new AssetDescriptor<Texture>("Menu/nosound.png", Texture.class);
	public static final AssetDescriptor<Texture> STAR
			= new AssetDescriptor<Texture>("Play/space.png", Texture.class);



    public static void prepare() {
		manager = new AssetManager();
		Texture.setAssetManager(manager);
	}

	public static void load() {
		FileHandleResolver resolver = new InternalFileHandleResolver();
		manager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
		manager.setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));
		manager.setLoader(BitmapFont.class, ".otf", new FreetypeFontLoader(resolver));

		manager.load(BACKGROUND);
		manager.load(PLAY);
		manager.load(SETTINGS);
		manager.load(EXIT);
		manager.load(MYSHIP);
		manager.load(ASTEROIDA);
		manager.load(STAR);
		manager.load(BADSHIP);
		manager.load(GREENDOT);
		manager.load(REDDOT);
		manager.load(BACK);
		manager.load(SOUND);
		manager.load(NOSOUND);


		manager.load(EXPLOSION_TEXTUREATLAS);

		manager.load(GAMEMUSIC);

		manager.load(PIXEL_FONT);
		manager.load(APPLESTORMITA_FONT);
	}

    public static void afterLoaded() {
        //manager.get(MUSIC).setLooping(true);
    }

	public static void unload() {
		manager.dispose();
	}


}
