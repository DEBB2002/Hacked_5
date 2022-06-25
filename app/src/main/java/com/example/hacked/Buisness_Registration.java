package com.example.hacked;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

public class Buisness_Registration extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String[] buisness= { "Hotels/Restaurant", "Guide"};
    String buis=" ";
    EditText name, email, password, confirmpassword;
    Button submit;


    private ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    FirebaseDatabase firebaseDatabase;
    FirebaseStorage firebaseStorage;
    CheckBox guidecheck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_buisness_registration );

        Spinner s1=findViewById( R.id.spinner1 );
        s1.setOnItemSelectedListener(this);

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,buisness);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        s1.setAdapter(aa);
        submit.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                String nametext = name.getText().toString();
                String emailtext = email.getText().toString();
                String passwordtext = password.getText().toString();
                if (emailtext != "" && passwordtext != "" && nametext != "") {

                }
            }
        } );





    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
buis=buisness[position];
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged( hasCapture );
    }
}