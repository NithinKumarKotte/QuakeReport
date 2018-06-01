package com.example.android.quakereport;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.graphics.drawable.GradientDrawable;

import java.util.List;

/**
 * Created by Nithin on 05/04/2018.
 */

public class QuakeAdapter extends ArrayAdapter<EQParameters> {

    public QuakeAdapter(@NonNull Context context, @NonNull List objects) {
        super(context,0, objects);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final EQParameters QA= getItem(position);
        View listItem= convertView;
        String city1,city2="";
        String initialCity= QA.getCity();
        if(initialCity.contains("of")) {
            city1 = initialCity.substring(0, initialCity.indexOf("of") + 3);
            Log.v("city1", city1);
            city2 = initialCity.substring(initialCity.indexOf("of") + 3, initialCity.length());
            Log.v("city2", city2);
        }else{
            city1="";
            city2=initialCity;
        }

        if(listItem==null){
            listItem= LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        TextView mag = (TextView) listItem.findViewById(R.id.mag);
        mag.setText(Double.toString(QA.getMag()));
        GradientDrawable magnitudeCircle = (GradientDrawable) mag.getBackground();

        if(QA.getMag()>=9.1){
            magnitudeCircle.setColor(getContext().getResources().getColor(R.color.magnitude10plus));

        }
        if(QA.getMag()>=8.1 && QA.getMag()<=9.0){
            magnitudeCircle.setColor(getContext().getResources().getColor(R.color.magnitude9));
        }
        if(QA.getMag()>=7.1 && QA.getMag()<=8.0){
            magnitudeCircle.setColor(getContext().getResources().getColor(R.color.magnitude8));
        }

        if(QA.getMag()>=6.1 && QA.getMag()<=7.0){
            magnitudeCircle.setColor(getContext().getResources().getColor(R.color.magnitude7));
        }
        if(QA.getMag()>=5.1 && QA.getMag()<=6.0){
            magnitudeCircle.setColor(getContext().getResources().getColor(R.color.magnitude6));
        }
        if(QA.getMag()>=4.1 && QA.getMag()<=5.0){
            magnitudeCircle.setColor(getContext().getResources().getColor(R.color.magnitude5));
        }
        if(QA.getMag()>=3.1 && QA.getMag()<=4.0){
            magnitudeCircle.setColor(getContext().getResources().getColor(R.color.magnitude4));
        }
        if(QA.getMag()>=2.1 && QA.getMag()<=3.0){
            magnitudeCircle.setColor(getContext().getResources().getColor(R.color.magnitude3));
        }
        if(QA.getMag()>=1.1 && QA.getMag()<=2.0){
            magnitudeCircle.setColor(getContext().getResources().getColor(R.color.magnitude2));
        }
        if(QA.getMag()>=0.1 && QA.getMag()<=1.0){
            magnitudeCircle.setColor(getContext().getResources().getColor(R.color.magnitude1));
        }

        TextView cityProximity = (TextView) listItem.findViewById(R.id.city);
        cityProximity.setText(city1);
        cityProximity.setTextColor(getContext().getResources().getColor(R.color.colorPrimaryDark));

        TextView cityName = (TextView) listItem.findViewById(R.id.city2);
        cityName.setText(city2);
        cityName.setTextColor(getContext().getResources().getColor(R.color.colorPrimaryDark));

        TextView date = (TextView) listItem.findViewById(R.id.date);
        date.setText(QA.getDate());
        date.setTextColor(getContext().getResources().getColor(R.color.colorPrimaryDark));



        return listItem;
    }
}
