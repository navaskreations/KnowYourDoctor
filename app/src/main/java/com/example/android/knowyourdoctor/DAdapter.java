package com.example.android.knowyourdoctor;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by navas on 8/18/2017.
 */

public class DAdapter extends ArrayAdapter<DDetails> {

    public  DAdapter(Activity  context, ArrayList<DDetails> dDetails){
        super(context,0,dDetails);
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       // View view = super.getView(position, convertView, parent);

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        DDetails currentView = getItem(position);

        TextView textView1 = (TextView) view.findViewById(R.id.text1);
        textView1.setText(currentView.getDName());

        TextView textView2 = (TextView) view.findViewById(R.id.text2);
        textView2.setText(currentView.getDSpeciality());

        ImageView imgView = (ImageView) view.findViewById(R.id.imgView);
        imgView.setImageResource(currentView.getdImgResourceId());


        return view;
    }
}
