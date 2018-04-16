package comricharddip28.httpsgithub.bankingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainPage extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    DatabaseReference myRef,employ_ref;
    String uid;
    TextView u_fname, u_lname, u_email, u_phone, u_unitnum, u_address;
    TextView b_fname, b_lname, b_phone, b_unitnum, b_address;
    TextView c_name, c_title, c_phone, c_unitnum, c_address, c_salary;
    DatabaseReference ref, e_ref;
    String[] personal_infolist = {"fname", "lname", "email", "phone", "unitnum", "address"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);


        u_fname = findViewById(R.id.fname_text);
        u_lname = findViewById(R.id.lname_text);
        u_email = findViewById(R.id.email_text);
        u_phone = findViewById(R.id.phone_text);
        u_unitnum = findViewById(R.id.unitnum_text);
        u_address = findViewById(R.id.address_text);

        b_fname = findViewById(R.id.b_fname);
        b_lname = findViewById(R.id.b_lname);
        b_phone = findViewById(R.id.b_phone);
        b_unitnum = findViewById(R.id.b_unitnum);
        b_address = findViewById(R.id.b_address);

        c_name = findViewById(R.id.c_name);
        c_title = findViewById(R.id.c_title);
        c_phone = findViewById(R.id.c_phone);
        c_unitnum = findViewById(R.id.c_unitnum);
        c_address = findViewById(R.id.c_address);
        c_salary = findViewById(R.id.c_salary);

        firebaseAuth = FirebaseAuth.getInstance();
        uid = firebaseAuth.getCurrentUser().getUid();


        //PERSONAL INFORMATION
        myRef = FirebaseDatabase.getInstance().getReference().child(uid).child("userinfo");

        ref = myRef.child("fname");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                u_fname.setText(dataSnapshot.getValue(String.class));
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

         ref = myRef.child("lname");
         ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                u_lname.setText(dataSnapshot.getValue(String.class));
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        ref = myRef.child("email");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                u_email.setText(dataSnapshot.getValue(String.class));
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        ref = myRef.child("phone");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                u_phone.setText(dataSnapshot.getValue(String.class));
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        ref = myRef.child("unitnum");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                u_unitnum.setText(dataSnapshot.getValue(String.class));
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        ref = myRef.child("address");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                u_address.setText(dataSnapshot.getValue(String.class));
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        //BENEFICIARY STUFF

        myRef = FirebaseDatabase.getInstance().getReference().child(uid).child("beneficiaryinfo");

        ref = myRef.child("fname");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                b_fname.setText(dataSnapshot.getValue(String.class));
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        ref = myRef.child("lname");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                b_lname.setText(dataSnapshot.getValue(String.class));
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        ref = myRef.child("phone");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                b_phone.setText(dataSnapshot.getValue(String.class));
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        ref = myRef.child("civic");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                b_unitnum.setText(dataSnapshot.getValue(String.class));
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        ref = myRef.child("address");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                b_address.setText(dataSnapshot.getValue(String.class));
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        //EMPLOYMENT STUFF

        employ_ref = FirebaseDatabase.getInstance().getReference().child(uid).child("employementinfo");

        e_ref = employ_ref.child("cname");
        e_ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                c_name.setText(dataSnapshot.getValue(String.class));
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        e_ref = employ_ref.child("title");
        e_ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                c_title.setText(dataSnapshot.getValue(String.class));
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        e_ref = employ_ref.child("phone");
        e_ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                c_phone.setText(dataSnapshot.getValue(String.class));
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        e_ref = employ_ref.child("civic");
        e_ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                c_unitnum.setText(dataSnapshot.getValue(String.class));
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        e_ref = employ_ref.child("address");
        e_ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                c_address.setText(dataSnapshot.getValue(String.class));
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        e_ref = employ_ref.child("salary");
        e_ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                c_salary.setText(dataSnapshot.getValue(String.class));
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });





    }
}
