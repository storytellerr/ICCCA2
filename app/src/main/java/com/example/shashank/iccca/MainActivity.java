package com.example.shashank.iccca;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener  {



    boolean doubleBackToExitPressedOnce = false;
   Animation fade_in,fade_out;
    ViewFlipper viewFlipper;

    protected void onCreate(Bundle savedInstanceState)

    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        viewFlipper =(ViewFlipper)findViewById(R.id.viewFlipper);
        fade_in= AnimationUtils.loadAnimation(this,android.R.anim.fade_in);
        fade_out=AnimationUtils.loadAnimation(this,android.R.anim.fade_out);
        viewFlipper.setInAnimation(fade_in);
        viewFlipper.setInAnimation(fade_out);
        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(4000);
        viewFlipper.startFlipping();

       TextView tv1 = (TextView)findViewById(R.id.textview1);
        tv1.setText(Html.fromHtml("<a href=https://www.facebook.com/shashank.sharma.560272>Shashank sharma"));
        tv1.setMovementMethod(LinkMovementMethod.getInstance());
    }



    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }

    /*public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


      public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/


    /*public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/


    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home)
        {

            startActivity(new Intent(this,MainActivity.class));
        }
        else if(id ==R.id.schedule)
        {
            startActivity(new Intent(this,Schedule.class));
        }
        /*else if (id == R.id.call_for_papers)
        {
            startActivity(new Intent(this,Callpaper.class));
        }*/
        else if (id == R.id.registration)
        {

            startActivity(new Intent(this,Registration.class));
        }
        else if (id == R.id.workshop)
        {
            startActivity(new Intent(this,Tab.class));
        }
        else if(id==R.id.important_links)
        {
            startActivity(new Intent(this,Important_links.class));
        }

        else if(id== R.id.sponcer)
        {
            startActivity(new Intent(this,Sponcer.class));
        }


        else if (id == R.id.Contact_us)
        {
            startActivity(new Intent(this,Contact_us.class));
        }
        else if (id == R.id.FAQ)
        {
            startActivity(new Intent(this,Faq.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

 public void fb(View v)
 {
     startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.facebook.com/iccca2017/")));
 }

    public void twit(View v)
    {
        Toast.makeText(this,"twitter",Toast.LENGTH_LONG).show();
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://mobile.twitter.com/@iccca2017")));

    }

    public void mail(View v)
    {
        final Intent email=new Intent(Intent.ACTION_SEND);
        email.setType("plain/text");
        email.putExtra(Intent.EXTRA_EMAIL,new String[]{"technojam@gmail.com"});
        //email.putExtra();

    }

    public void web(View v)
    {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://iccca.in/")));
    }

    public void star(View v)
    {
        Toast.makeText(this,"rate us",Toast.LENGTH_LONG).show();
    }





    public void image(View v) {
        int id = v.getId();

        if (id == R.id.image1)
        {

            Intent in = new Intent(MainActivity.this,Picone.class);
            startActivity(in);
        }
        if (id == R.id.image2)
        {

            Intent in = new Intent(MainActivity.this,Pictwo.class);
            startActivity(in);
        }
        if (id == R.id.image3)
        {

            Intent in = new Intent(MainActivity.this,Picthree.class);
            startActivity(in);
        }
        if (id == R.id.image4)
        {

            Intent in = new Intent(MainActivity.this,Picfour.class);
            startActivity(in);
        }
        if (id == R.id.image5)
        {

            Intent in = new Intent(MainActivity.this,Picfive.class);
            startActivity(in);
        }
        if (id == R.id.image6)
        {

            Intent in = new Intent(MainActivity.this,Picsix.class);
            startActivity(in);

        }if (id == R.id.image7)
        {

            Intent in = new Intent(MainActivity.this,Picseven.class);
            startActivity(in);
        }
        if (id == R.id.image8)
        {

            Intent in = new Intent(MainActivity.this,Piceight.class);
            startActivity(in);
        }



    }

}





