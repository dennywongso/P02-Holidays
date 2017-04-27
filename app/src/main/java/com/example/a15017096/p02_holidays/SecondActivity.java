package com.example.a15017096.p02_holidays;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    ArrayAdapter aa;
    ArrayList<Holiday> alSecular, alEthic;
    ListView lv;
    TextView tvDesc;
    ArrayList<Holiday> clicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent i = getIntent();
        int post = i.getIntExtra("index",0);
        alSecular = new ArrayList<Holiday>();
        alEthic = new ArrayList<Holiday>();
        lv = (ListView)findViewById(R.id.lv2);
        tvDesc = (TextView)findViewById(R.id.tvDesc);
        alSecular.add(new Holiday("New Year's Day","1 Jan 2017","new_year"));
        alSecular.add(new Holiday("Labor Day","1 May 2017","labour_day"));
        alSecular.add(new Holiday("National Day","9 August 2017","national_day"));
        alEthic.add(new Holiday("Christmas Day","25 December 2017","christmas_day"));
        alEthic.add(new Holiday("Chinese New Year","28-29 Jan 2017","cny"));
        alEthic.add(new Holiday("Good friday","14 April 2017","good_friday"));
        clicked = new ArrayList<Holiday>();

        if(post == 0){
            tvDesc.setText("Secular");
            aa = new HolidayAdapter(this, R.layout.row, alSecular);
            clicked = alSecular;
        } else {
            tvDesc.setText("Ethnic & Religion");
            aa = new HolidayAdapter(this, R.layout.row, alEthic);
            clicked = alEthic;
        }
        lv.setAdapter(aa);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Holiday selectedHol = clicked.get(position);

                Toast.makeText(SecondActivity.this, selectedHol.getName()
                                + ", Date: " + selectedHol.getDate(),
                        Toast.LENGTH_SHORT).show();
            }
        });



    }
}
