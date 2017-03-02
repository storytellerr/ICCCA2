package com.example.shashank.iccca;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;

import java.util.Timer;
import java.util.TimerTask;

public class Splashscreen extends AppCompatActivity {


    ShimmerTextView tv,tv1;
    Shimmer shimmer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        tv = (ShimmerTextView) findViewById(R.id.shimmer_tv);
        tv1=(ShimmerTextView) findViewById(R.id.shimmer_tv1);

        shimmer = new Shimmer();
        shimmer.setDuration(1400);
        shimmer.start(tv);
        shimmer.start(tv1);

        new Timer().schedule(new TimerTask(){
            public void run() {
                startActivity(new Intent(Splashscreen.this,MainActivity.class));
               finish();
            }
        },2000);

    }
}
