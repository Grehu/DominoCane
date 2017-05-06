package hackatheon.beczka.dominocane;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ScrollActivity extends AppCompatActivity {

    TextView tv;
    TouchImageView image;

    private void action()
    {
        String s = "";
        for (int i =0; i<100; i++)
        {
            s+= "Linia " + i + "\n";
        }
        tv.setText(s);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);

        tv = (TextView) findViewById(R.id.textView8);
        image = (TouchImageView) findViewById(R.id.imageView2);

        action();
    }
}
