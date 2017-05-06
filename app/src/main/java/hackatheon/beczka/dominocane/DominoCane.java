package hackatheon.beczka.dominocane;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DominoCane extends AppCompatActivity {

    public void reaction()
    {
        Intent i = new Intent(this, ScrollActivity.class);
        startActivity(i);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_domino_cane);

        Button b = (Button)findViewById(R.id.button1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reaction();
                Button informacje_szczegolowe = (Button) findViewById(R.id.button);

                informacje_szczegolowe.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(DominoCane.this, Pop.class));
                    }
                });
            }
        });
    }
}
