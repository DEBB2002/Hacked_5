package com.example.hacked;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

public class Register extends AppCompatActivity {
    EditText name, email, password, confirmpassword;
    Button submit;


    private ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    FirebaseDatabase firebaseDatabase;
    FirebaseStorage firebaseStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_register );

        name=findViewById( R.id.fname );
        email=findViewById( R.id.email );
        password=findViewById( R.id.pasword);
        progressDialog = new ProgressDialog( this );
        progressDialog.setMessage( "Please Wait" );
        progressDialog.setCancelable( false );
        firebaseDatabase = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();
        submit=findViewById( R.id.reg_btn );

        submit.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                String nametext = name.getText().toString();
                String emailtext = email.getText().toString();
                String passwordtext = password.getText().toString();
                if (emailtext != "" && passwordtext != "" && nametext != "") {
                    Register( nametext, emailtext, passwordtext );
                }
            }
        } );








    }
    private void Register(String name, String email1, String password1) {
        if (email1 != null && password1 != null) {
            mAuth.createUserWithEmailAndPassword( email1, password1 ).addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText( Register.this, "User Created Successfully", Toast.LENGTH_SHORT ).show();
                        DatabaseReference databaseReference = firebaseDatabase.getReference().child( "Users" ).child( mAuth.getUid() );
                        Users users = new Users( mAuth.getUid(), name, email1 );
                        databaseReference.push().setValue( users ).addOnCompleteListener( new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    progressDialog.dismiss();

                                    Toast.makeText( Register.this, "User Created data stored", Toast.LENGTH_SHORT ).show();
                                    startActivity( new Intent(Register.this,Login.class) );


                                }
                                else{
                                    progressDialog.dismiss();
                                    Toast.makeText( Register.this,"Bello",Toast.LENGTH_SHORT ).show();
                                }

                            }
                        } );

                    }
                }
            } );
        }
    }

}