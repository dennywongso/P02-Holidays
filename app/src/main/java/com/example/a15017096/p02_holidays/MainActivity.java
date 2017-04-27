package com.example.a15017096.p02_holidays;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    ArrayAdapter aa;
    ArrayList<String> al;
    TextView tv10;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView)findViewById(R.id.lv1);
        al = new ArrayList<String>();
        al.add("Secular");
        al.add("Ethnic & Religion");
        

        aa = new ArrayAdapter(this, android.R.layout.simple_list_item_1, al);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int selectedCat = position;

                Intent intent = new Intent( getBaseContext(), SecondActivity.class);
                intent.putExtra("index",selectedCat);

                startActivity(intent);



            }
        });
    }
}
