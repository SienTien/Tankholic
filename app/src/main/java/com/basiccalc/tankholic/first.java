package com.basiccalc.tankholic;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class first extends AppCompatActivity implements OnClickListener, AdapterView.OnItemSelectedListener {

    private ImageButton next;
    private Spinner spinType, spinBudget,spinSize;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    public static final String keysize = "size";

    private int split = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        next= (ImageButton) findViewById(R.id.nextButton);
        spinType = (Spinner) findViewById(R.id.spinnerType);
        spinBudget = (Spinner) findViewById(R.id.spinnerBudget);
        spinSize = (Spinner) findViewById(R.id.spinnerSize);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.spinBudget, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(
                this, R.array.spinType, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spinBudget.setAdapter(adapter);
        spinBudget.setOnItemSelectedListener(this);

        spinType.setAdapter(adapter1);
        spinType.setOnItemSelectedListener(this);
        //spinSize.setOnItemSelectedListener(this);

        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = preferences.edit();


        next.setOnClickListener(this);

    }


    public void onItemSelected(AdapterView<?> parent, View v, int position,
                               long id) {

        String sp1= String.valueOf(spinBudget.getSelectedItem());


        if(sp1.contentEquals("$500-1,000")) {
            List<String> list = new ArrayList<String>();
            list.add("10G-29G");
            ;//You should add items from db here (first spinner)

            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            spinSize.setAdapter(dataAdapter);
            editor.putString(keysize,"size1");
            editor.apply();

        }
        else if(sp1.contentEquals("$1,000-2,000")) {
            List<String> list = new ArrayList<String>();
            list.add("10G-29G");
            list.add("29G-65G");
           //you should add items from db here(2nd spinner)

            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter2.notifyDataSetChanged();
            spinSize.setAdapter(dataAdapter2);
            editor.putString(keysize,"size2");
            editor.apply();

        }

        else if(sp1.contentEquals("$2,000-5,000")) {
            List<String> list = new ArrayList<String>();
            list.add("10G-29G");
            list.add("29G-65G");
            list.add("65G-90G");
            //you should add items from db here(2nd spinner)

            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter2.notifyDataSetChanged();
            spinSize.setAdapter(dataAdapter2);
            editor.putString(keysize,"size3");
            editor.apply();

        }

        else if(sp1.contentEquals("$5,000-10,000")) {
            List<String> list = new ArrayList<String>();
            list.add("10G-29G");
            list.add("29G-65G");
            list.add("65G-90G");
            list.add("90G-120G");
            //you should add items from db here(2nd spinner)

            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter2.notifyDataSetChanged();
            spinSize.setAdapter(dataAdapter2);
            editor.putString(keysize,"size4");
            editor.apply();

        }






    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Do nothing
    }



    @Override
    public void onClick(View v) {

        String type= String.valueOf(spinType.getSelectedItem());

        if(type.contentEquals("Coral Reef Tank"))
        {

            Intent i = new Intent(first.this,choose_coral.class);
            startActivity(i);
        }
        else if(type.contentEquals("Fish Only Tank"))
        {

            Intent i = new Intent(first.this,choose_fish.class);
            startActivity(i);
        }


    }
}
