package com.example.shashank.iccca;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class OneFragment extends Fragment{

    public OneFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vv =inflater.inflate(R.layout.fragment_one, container, false);
        TextView tvv=(TextView) vv.findViewById(R.id.tvv);
        tvv.setText(Html.fromHtml("<a href=http://iccca.in/downlaod_files/Registration_Form_Workshop_ICCCA2017.docx>Click here to"));
        tvv.setMovementMethod(LinkMovementMethod.getInstance());
        return vv;
    }

}
