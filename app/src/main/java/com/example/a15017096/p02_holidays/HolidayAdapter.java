package com.example.a15017096.p02_holidays;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 15017096 on 27/4/2017.
 */

public class HolidayAdapter extends ArrayAdapter<Holiday> {
    private Context context;
    private ArrayList<Holiday> Al;
    private TextView tvDate, tvHoliday;
    private ImageView iv1;

    public HolidayAdapter(Context context, int resource, ArrayList<Holiday> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        Al= objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvDate = (TextView) rowView.findViewById(R.id.tvDate);
        // Get the ImageView object
        tvHoliday = (TextView) rowView.findViewById(R.id.tvHoliday);
        iv1 = (ImageView)rowView.findViewById(R.id.iv1);



       Holiday currentHoliday = Al.get(position);

        tvDate.setText(currentHoliday.getDate());
        tvHoliday.setText(currentHoliday.getName());

        String image =currentHoliday.getImage();
        int resID = this.context.getResources().getIdentifier(image , "drawable", this.context.getPackageName());
        iv1.setImageResource(resID);

        return rowView;

    }
}
