package hackatheon.beczka.dominocane.db;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;

import java.io.InputStream;

import hackatheon.beczka.dominocane.R;

/**
 * Created by Grzegorz on 06.05.2017.
 */

public class BiconObject {
    private static Context context;

    private String name;
    private String description;
    private int imgID;
    private int audioID;

    public BiconObject(String name, String description, String img, String audio) throws Resources.NotFoundException {
        this.name = name;
        this.description = description;
        this.imgID = context.getResources().getIdentifier(img, "drawable", context.getPackageName()+"ttt");
        this.audioID = context.getResources().getIdentifier(audio, "raw", context.getPackageName());
        if(imgID == 0){
            imgID = R.drawable.unknown;
        }
        if(audioID == 0){
            audioID = R.raw.silence;
        }
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Drawable getImg() {
        return context.getResources().getDrawable(imgID);
    }

    public int getImgId() {
        return imgID;
    }

    public InputStream getAudio() {
        return context.getResources().openRawResource(audioID);
    }

    public int getAudioID() {
        return audioID;
    }

    public static void setCurrentContext(Context context){
        BiconObject.context = context;
    }
}
