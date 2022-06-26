package com.example.hacked;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class Dashboard extends AppCompatActivity {
    RelativeLayout yamunotri, gangotri, kedarnath, badrinath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_dashboard );
        yamunotri = findViewById( R.id.yamuntori_view );
        gangotri = findViewById( R.id.gantori_view );
        kedarnath = findViewById( R.id.kedarnath_view );
        badrinath = findViewById( R.id.badrinath_view );


        yamunotri.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( getBaseContext(), Places.class );
                i.putExtra( "Name", "Yamunotri" );
                startActivity( i );
            }
        } );
        gangotri.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( getBaseContext(), Places.class );
                i.putExtra( "Name", "Gangotri" );
                startActivity( i );
            }
        } );
        kedarnath.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( getBaseContext(), Places.class );
                i.putExtra( "Name", "Kedarnath" );
                startActivity( i );
            }
        } );
        badrinath.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( getBaseContext(), Places.class );
                i.putExtra( "Name", "Badrinath" );
                startActivity( i );
            }
        } );
    }
}