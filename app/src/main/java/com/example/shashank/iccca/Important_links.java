package com.example.shashank.iccca;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class Important_links extends AppCompatActivity {
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_important_links);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Important Links");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed(); // Implemented by activity
            }
        });



    }
    public void broucher(View v)
    {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://iccca.in/downlaod_files/brochureICCCA2017.pdf")));
    }

    public void author(View v)
    {
        //startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://iccca.in/")));
        Toast.makeText(this,"Author Registration Form",Toast.LENGTH_LONG).show();

    }

    public void attendees(View v)
    {
        //startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://iccca.in/")));
        Toast.makeText(this,"Attendees Registration Form",Toast.LENGTH_LONG).show();
    }

    public void guweb(View v)
    {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://galgotiasuniversity.edu.in/")));
    }

    public void ieeecopy(View v)
    {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://iccca.in/downlaod_files/IEEECopy.pdf")));

    }

    public void ieeeformat(View v)
    {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://iccca.in/downlaod_files/ICCCA2017.docx")));

    }

    public void bug(View v)
    {
        Toast.makeText(this,"contact shashank sharma",Toast.LENGTH_LONG).show();
        startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/shashank.sharma.560272")));
    }

    public void ic15(View v)
    {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.iccca2015.com/")));
    }

    public void ic16(View v)
    {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.iccca2016.com/")));
    }
}
