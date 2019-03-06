package com.basiccalc.tankholic;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedHashSet;

import static com.basiccalc.tankholic.first.keysize;

public class choose_coral extends AppCompatActivity implements View.OnClickListener{

    ListView listview;
    String coralnameSize1[] = {"Sun Coral","Sea Fan","Gorgonian","Euphyllia","Brain Coral",
            "Scolymia","Gonipora","Chalice","Candy Cane","Mushroom",
            "Montipora"};
    Integer imageIdSize1[] = {R.drawable.sun,R.drawable.seafan,R.drawable.gorgonian,R.drawable.euphyllia,R.drawable.brain,
            R.drawable.scolymia, R.drawable.goniopora,R.drawable.chalice,R.drawable.candycane,R.drawable.mushroom,
            R.drawable.montipora,R.drawable.birdnest,R.drawable.acropora};

    String coralnameSize2[] = {"Sun Coral","Sea Fan","Gorgonian","Euphyllia","Brain Coral",
            "Scolymia","Gonipora","Chalice","Candy Cane","Mushroom"};
    Integer imageIdSize2[] = {R.drawable.sun,R.drawable.seafan,R.drawable.gorgonian,R.drawable.euphyllia,R.drawable.brain,
            R.drawable.scolymia, R.drawable.goniopora,R.drawable.chalice,R.drawable.candycane,R.drawable.mushroom};

    Custom_coral_listview customCoralListview;
    SharedPreferences shareSize;
    CheckBox checkBox;
    String tanksize;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    LinkedHashSet<String> selectedItems;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_coral);



        listview = (ListView) findViewById(R.id.listview_coral);
        shareSize = PreferenceManager.getDefaultSharedPreferences(this);
        tanksize = shareSize.getString(keysize,"nothing");
        if(tanksize.equals("size4") ||tanksize.equals("size3") || tanksize.equals("size2") ) {
            customCoralListview = new Custom_coral_listview(this, coralnameSize1, imageIdSize1, checkBox);

        }
        else {
            customCoralListview = new Custom_coral_listview(this, coralnameSize2, imageIdSize2, checkBox);
        }
        listview.setAdapter(customCoralListview);
        selectedItems=new LinkedHashSet<>();

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sharedPreferences.edit();

    }

    @Override
    public void onClick(View v) {

        String str="";


        for(int i=0;i<customCoralListview.getSelectedcoral().size();i++)
        {
            selectedItems.add(customCoralListview.getSelectedcoral().get(i));
            str+=customCoralListview.getSelectedcoral().get(i)+"\n";
        }
        if(customCoralListview.getSelectedcoral().size() == 0)
        {
            selectedItems.add("Let's go back choose something!");
        }
        editor.putStringSet("keySelectedCoral",selectedItems);
        editor.apply();

        Toast.makeText(this,"You've selected:\n"+str, Toast.LENGTH_LONG).show();
        Log.d("seleted fish",customCoralListview.getSelectedcoral().toString());
        Log.d("key coral",selectedItems.toString());

        Intent i = new Intent(choose_coral.this,choose_fish.class);
        startActivity(i);

    }
}
