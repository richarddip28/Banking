package comricharddip28.httpsgithub.bankingapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Richard Dip on 4/15/2018.
 */

public class Beneficiary extends AppCompatActivity {

    Button button;
    Intent i;
    DatabaseReference dataRef;
    SharedPreferences prefs;

    public void init(){

        button = findViewById(R.id.button3);
        i = new Intent(this, Employment.class);
        dataRef = FirebaseDatabase.getInstance().getReference();
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
    }

    public void convert() {

        EditText txt_fname = findViewById(R.id.firstname);
        EditText txt_lname = findViewById(R.id.lastname);
        EditText txt_phone = findViewById(R.id.phone);
        EditText txt_unitnum = findViewById(R.id.unitnum);
        EditText txt_address = findViewById(R.id.address);

        String fname = txt_fname.getText().toString();
        String lname = txt_lname.getText().toString();
        String phone = txt_phone.getText().toString();
        String unitnum = txt_unitnum.getText().toString();
        String address = txt_address.getText().toString();
        String uid = prefs.getString("uid", null);

        BeneficiaryInfo user = new BeneficiaryInfo(fname,lname,phone,unitnum,address);

        dataRef.child(uid).child("beneficiaryinfo").setValue(user);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beneficiary);
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
