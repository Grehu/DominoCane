package hackatheon.beczka.dominocane;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;

public class DominoCane extends Activity {


    //TODO: zaimplementowac ciala metod do poszczegolnych guzikow
    public void camera()
    {
//        Intent i = new Intent(this, ScrollActivity.class);
//        tartActivity(i);
    }

    public void exhibition()
    {
//        Intent i = new Intent(this, ScrollActivity.class);
//        tartActivity(i);
    }

    public void map()
    {
//        Intent i = new Intent(this, ScrollActivity.class);
//        tartActivity(i);
    }

    public void OP()
    {
//        Intent i = new Intent(this, ScrollActivity.class);
//        tartActivity(i);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_domino_cane);

        ImageButton buttonCamera = (ImageButton)findViewById(R.id.imageButtonStart);
        ImageButton buttonExhibition = (ImageButton)findViewById(R.id.imageButtonExpo);
        ImageButton buttonMap = (ImageButton)findViewById(R.id.imageButtonMap);
        ImageButton buttonOP = (ImageButton)findViewById(R.id.imageButtonOP);

        buttonCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                camera();
            }
        });

        buttonExhibition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exhibition();
            }
        });

        buttonMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                map();
            }
        });

        buttonOP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OP();
            }
        });

//        Button informacje_szczegolowe = (Button) findViewById(R.id.button);
//
//        informacje_szczegolowe.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(DominoCane.this, Pop.class));
//            }
//        });

    }
}
