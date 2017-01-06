package com.example.shashank.iccca;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener  {

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
        viewFlipper.setFlipInterval(5000);
        viewFlipper.startFlipping();

    }

    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    /*public boolean onCreateOptionsMenu(Menu menu) {
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

           Home home=new Home();
           FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.abcd,home).commit();
            findViewById(R.id.content_main).setVisibility(View.GONE);
        }
        else if (id == R.id.call_for_papers)
        {
            call_for_papers call_for_papers=new call_for_papers();
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.abcd,call_for_papers).commit();
            findViewById(R.id.content_main).setVisibility(View.GONE);
        }
        else if (id == R.id.registration)
        {

            Registration registration=new Registration();
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.abcd,registration).commit();
            findViewById(R.id.content_main).setVisibility(View.GONE);
        }
        else if (id == R.id.workshop)
        {
            Workshop workshop=new Workshop();
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.abcd,workshop).commit();
            findViewById(R.id.content_main).setVisibility(View.GONE);
        }
        else if(id==R.id.important_links)
        {
            Important_links important_links=new Important_links();
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.abcd,important_links).commit();
            findViewById(R.id.content_main).setVisibility(View.GONE);
        }

        else if(id== R.id.sponcer)
        {
            Sponcer sponcer= new Sponcer();
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.abcd,sponcer).commit();
            findViewById(R.id.content_main).setVisibility(View.GONE);
        }


        else if (id == R.id.Contact_us)
        {
            Contact_us contact_us=new Contact_us();
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.abcd,contact_us).commit();
            findViewById(R.id.content_main).setVisibility(View.GONE);
        }
        else if (id == R.id.FAQ)
        {
            Faq faq=new Faq();
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.abcd,faq).commit();
            findViewById(R.id.content_main).setVisibility(View.GONE);
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
    }

    public void ic15(View v)
    {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.iccca2015.com/")));
    }

    public void ic16(View v)
    {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.iccca2016.com/")));
    }



    public void image(View v) {
        int id = v.getId();

        if (id == R.id.image1)
        {

            Toast.makeText(this,"pro1",Toast.LENGTH_LONG).show();
        }
        if (id == R.id.image2)
        {

            Toast.makeText(this,"pro2",Toast.LENGTH_LONG).show();
        }
        if (id == R.id.image3)
        {

            Toast.makeText(this,"pro3",Toast.LENGTH_LONG).show();
        }
        if (id == R.id.image4)
        {

            Toast.makeText(this,"pro4",Toast.LENGTH_LONG).show();
        }
        if (id == R.id.image5)
        {

            Toast.makeText(this,"pro5",Toast.LENGTH_LONG).show();
        }
        if (id == R.id.image6)
        {

            Toast.makeText(this,"pro6",Toast.LENGTH_LONG).show();
        }if (id == R.id.image7)
        {

            Toast.makeText(this,"pro7",Toast.LENGTH_LONG).show();
        }
        if (id == R.id.image8)
        {

            Toast.makeText(this,"pro8",Toast.LENGTH_LONG).show();
        }



    }

}





