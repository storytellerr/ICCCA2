package com.example.shashank.iccca;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Config;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class Schedule extends AppCompatActivity {

    private Firebase mref;
    private TextView tv;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        Firebase.setAndroidContext(this);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Schedule");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed(); // Implemented by activity
            }
        });

        tv = (TextView) findViewById(R.id.name);
        mref = new Firebase(Config."https://iccca2-337f7.firebaseio.com/");
        Toast.makeText(Schedule.this, "first", Toast.LENGTH_SHORT).show();
        mref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    //Getting the data from snapshot
                    Fireapp person = postSnapshot.getValue(Fireapp.class);

                    //Adding it to a string
                    String string = "Name: " + person.getName() + "\nAddress: " + person.getTime() + "\n\n";

                    Toast.makeText(Schedule.this, "second", Toast.LENGTH_SHORT).show();
                    //Displaying it on textview
                    tv.setText(string);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                Toast.makeText(Schedule.this, "third", Toast.LENGTH_SHORT).show();
                System.out.println("The read failed: " + firebaseError.getMessage());
            }


        });
    }
}