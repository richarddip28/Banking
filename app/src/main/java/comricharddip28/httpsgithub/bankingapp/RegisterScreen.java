package comricharddip28.httpsgithub.bankingapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Richard Dip on 4/15/2018.
 */


public class RegisterScreen extends AppCompatActivity {

    Button button;
    Intent i;
    CheckBox beneficiaryIsChecked;
    FirebaseAuth firebaseAuth;
    DatabaseReference dataRef;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    String uid;


    public void init(){

        button = findViewById(R.id.button4);
        i = new Intent(this, Beneficiary.class);
        beneficiaryIsChecked = findViewById(R.id.checkBox);
        firebaseAuth = FirebaseAuth.getInstance();

        dataRef = FirebaseDatabase.getInstance().getReference();
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        editor = prefs.edit();
    }

    public void nextScreen(){
        if(beneficiaryIsChecked.isChecked())
            i = new Intent(this, Beneficiary.class);
        else
            i = new Intent(this, Employment.class);
    }

    public void convert() {
        EditText txt_email = findViewById(R.id.email);
        EditText txt_password = findViewById(R.id.password);
        EditText txt_fname = findViewById(R.id.firstname);
        EditText txt_lname = findViewById(R.id.lastname);
        EditText txt_phone = findViewById(R.id.phone);
        EditText txt_unitnum = findViewById(R.id.unitnum);
        EditText txt_address = findViewById(R.id.address);

        String email = txt_email.getText().toString();
        String fname = txt_fname.getText().toString();
        String lname = txt_lname.getText().toString();
        String phone = txt_phone.getText().toString();
        String unitnum = txt_unitnum.getText().toString();
        String address = txt_address.getText().toString();

        UserInformation user = new UserInformation(email,fname,lname,phone,unitnum,address);
        uid = firebaseAuth.getCurrentUser().getUid();
        editor.putString("uid",uid);
        editor.commit();

        dataRef.child(uid).child("userinfo").setValue(user);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerscreen);
        init();


        final EditText txt_email = findViewById(R.id.email);
        final EditText txt_password = findViewById(R.id.password);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog progressDialog = ProgressDialog.show(RegisterScreen.this, "Please wait...", "Processing...", true);
                (firebaseAuth.createUserWithEmailAndPassword(txt_email.getText().toString(),txt_password.getText().toString())).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if (task.isSuccessful()) {
                            Toast.makeText(RegisterScreen.this, "Registration successful", Toast.LENGTH_LONG).show();
                            convert();
                        }
                        else
                        {
                            Log.e("ERROR", task.getException().toString());
                        }
                    }
                });
                nextScreen();
                startActivity(i);
            }
        });
    }
}
