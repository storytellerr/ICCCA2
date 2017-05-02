package com.example.shashank.iccca;


import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class News extends Fragment {


    private Firebase mref;
    private TextView tv,tv2,tv3,cen;
    Button btn;
    private String url="https://iccca2-337f7.firebaseio.com/";

    public News() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vv= inflater.inflate(R.layout.fragment_news, container, false);
        tv=(TextView)vv.findViewById(R.id.tvvv);
        tv2=(TextView)vv.findViewById(R.id.tvvv2);
        tv3=(TextView)vv.findViewById(R.id.tvvv3);
        cen=(TextView)vv.findViewById(R.id.cen);
        if(isNetworkAvailable()==false)
        {
            Toast.makeText(getContext(),"NO INTERNET CONNECTION",Toast.LENGTH_LONG).show();
        }
        return vv;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Firebase.setAndroidContext(getContext());
        mref = new Firebase(url);
        mref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    //Getting the data from snapshot
                    Log.v("warning","hello4");
                    Person person = postSnapshot.getValue(Person.class);
                    //Adding it to a string
                    String string = "News:1-: " + person.getName() +  "\n\n";

                    String string2="News:2-: " +  person.getWsn()+ "\n\n";

                    String string3="News:3-: " +  person.getNew()+ "\n\n";
                    //Displaying it on textview
                    if(person.getName()!=null)
                        tv.setText(string);
                    if(person.getWsn()!=null)
                        tv2.setText(string2);
                    if(person.getNew()!=null)
                     tv3.setText(string3);
                    if((person.getName()==null) && (person.getWsn()==null )&& (person.getNew()==null))
                        cen.setText("No news ");

                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

                Toast.makeText(getContext(),"NO INTERNET CONNECTION",Toast.LENGTH_LONG).show();
                System.out.println("The read failed: " + firebaseError.getMessage());
            }


        });

    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getContext().getSystemService(getContext().CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}
