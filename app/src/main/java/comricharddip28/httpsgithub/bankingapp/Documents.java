package comricharddip28.httpsgithub.bankingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Richard Dip on 4/15/2018.
 */

public class Documents extends AppCompatActivity{

    Button button;
    Intent i;

    public void init(){

        button = findViewById(R.id.button5);
        i = new Intent(this, Funding.class);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documents);
        init();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
            }
        });
    }
}
