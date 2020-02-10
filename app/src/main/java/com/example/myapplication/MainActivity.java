package com.example.myapplication;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ListView listView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listview) ;


      /*  ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("Ours brun");
        arrayList.add("Chameau");
        arrayList.add("Montbéliarde");
        arrayList.add("Renard roux");
        arrayList.add("Koala");
        arrayList.add("Lion");
        arrayList.add("Panda géant");
                    */
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,AnimalList.getNameArray());

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                Intent intent = new Intent(MainActivity.this, AnimalActivity.class);
                final String item = (String) parent.getItemAtPosition(position);
                intent.putExtra("i", item);
                startActivity(intent);
            }
        });






    }


}
