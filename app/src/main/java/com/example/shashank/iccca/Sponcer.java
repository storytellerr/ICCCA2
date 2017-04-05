package com.example.shashank.iccca;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Sponcer extends AppCompatActivity {
    Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    ExpandableListView expandableListView;
    ExpandableListAdapterr expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponcer);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitle("Sponcer");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed(); // Implemented by activity
            }
        });

        expandableListView = (ExpandableListView) findViewById(R.id.spnexp);
        expandableListDetail = Sponcerdata.getData();
        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
        expandableListAdapter = new ExpandableListAdapterr(this, expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);

    }
}
