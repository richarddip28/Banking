package comricharddip28.httpsgithub.bankingapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Richard Dip on 4/15/2018.
 */

public class Employment extends AppCompatActivity {

    Button button;
    Intent i;
    DatabaseReference dataRef;
    SharedPreferences prefs;
    Spinner spinner;

    public void init(){

        button = findViewById(R.id.button4);
        i = new Intent(this, Documents.class);
        spinner = findViewById(R.id.spinner);
        dataRef = FirebaseDatabase.getInstance().getReference();
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
    }

    public void convert() {

        EditText txt_cname = findViewById(R.id.company_name);
        EditText txt_unit = findViewById(R.id.unitnum);
        EditText txt_address = findViewById(R.id.address);
        EditText txt_phone = findViewById(R.id.phone);
        EditText txt_title = findViewById(R.id.job_title);

        String cname = txt_cname.getText().toString();
        String unit = txt_unit.getText().toString();
        String address = txt_address.getText().toString();
        String phone = txt_phone.getText().toString();
        String title = txt_title.getText().toString();
        String salary = spinner.getSelectedItem().toString();

        String uid = prefs.getString("uid", null);

        EmploymentInfo user = new EmploymentInfo(cname,unit,address,phone,title,salary);

        dataRef.child(uid).child("employementinfo").setValue(user);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employment);
        init();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convert();
                startActivity(i);
            }
        });
    }
}
