package hackatheon.beczka.dominocane;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.HashMap;

import hackatheon.beczka.dominocane.db.BiconObject;
import hackatheon.beczka.dominocane.db.XMLParser;

public class DominoCane extends AppCompatActivity {
    private HashMap<Integer, Object> resources = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BiconObject.setCurrentContext(this);
        loadResources();
        setContentView(R.layout.activity_domino_cane);
    }

    private void loadResources() {
        try {
            HashMap<String, BiconObject> map = XMLParser.parse(getResources().openRawResource(R.raw.objects));
        } catch (IOException e) {
            Log.e(DominoCane.class.getName(), "Error in loadResources method: "+e.getLocalizedMessage());
        } catch (XmlPullParserException e) {
            Log.e(DominoCane.class.getName(), "Error in loadResources method: "+e.getLocalizedMessage());
        }
    }
}
