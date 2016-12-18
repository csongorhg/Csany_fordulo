package Music;

import com.badlogic.gdx.utils.Disposable;

import java.util.ArrayList;

/**
 * Created by tuskeb on 2016. 12. 09..
 */

public class GameMusic implements Disposable{

    private static boolean musicPlay = true;
    private static float volume = 1;
    private ArrayList<com.badlogic.gdx.audio.Music> musics = new ArrayList<com.badlogic.gdx.audio.Music>();
    private int nowPlayed = -1;

    public void addMusic(com.badlogic.gdx.audio.Music music){
        music.setVolume(volume);
        music.setLooping(true);
        music.stop();
        musics.add(music);
    }

    public void act(){
        boolean play = false;
        for (com.badlogic.gdx.audio.Music m: musics) {
            if (m.isPlaying()){
                if (!musicPlay){
                    m.stop();
                }else{
                    play = true;
                }
            }
            if (m.getVolume()!=volume){
                m.setVolume(volume);
            }
        }
        if (nowPlayed==-1 && !play && musicPlay){
            if (musics.size()>0){
                musics.get(nowPlayed = (int)Math.floor(Math.random()*musics.size())).play();
            }
        }
    }

    public void dispose() {
        for (com.badlogic.gdx.audio.Music m : musics) {
            m.stop();
        }
    }

    public void setMusicVolume(float f) {
        volume = f;
    }

    public float getMusicVolume() {
        return volume;
    }
}
