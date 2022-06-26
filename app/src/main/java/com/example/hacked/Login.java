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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

public class Login extends AppCompatActivity {
    private ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    FirebaseDatabase firebaseDatabase;
    FirebaseStorage firebaseStorage;

    EditText email,password;
    Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login );
        mAuth=FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please Wait...");
        progressDialog.setCancelable(false);
        email=findViewById( R.id.email );
        password=findViewById( R.id.password);
        login=findViewById( R.id.log_btn );
        login.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressDialog.show();
                String email1=email.getText().toString();
                String pass1=password.getText().toString();
                mAuth.signInWithEmailAndPassword(email1,pass1 ).addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {progressDialog.dismiss();
                            startActivity( new Intent(Login.this,Dashboard.class) );}
                        else{
                            Toast.makeText( getApplicationContext(), "Login FAiled Check Credentials", Toast.LENGTH_SHORT ).show();
                        }}

                } );








            }
        } );



    }
    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser == null) {
            // No user is signed in
        } else {
            // User logged in
            Intent i=new Intent( getBaseContext(),Dashboard.class );
            startActivity( i );
        }
    }
}