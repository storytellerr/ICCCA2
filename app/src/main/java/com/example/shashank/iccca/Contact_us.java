package com.example.shashank.iccca;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import static java.security.AccessController.getContext;

public class Contact_us extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Contact us");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed(); // Implemented by activity
            }
        });


    }

    public void fbb(View v)
    {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/parma.astya")));
    }
    public void twitt(View v)
    {
       // startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/parma.astya")));
    }

}
