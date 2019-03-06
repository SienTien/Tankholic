package com.basiccalc.tankholic;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import java.util.LinkedHashSet;

import static com.basiccalc.tankholic.first.keysize;

public class choose_fish extends AppCompatActivity implements View.OnClickListener{

    ListView listview;

    //size3 & 4
    String fishnameSize3[] = {"Wrasse","Foxface","Tang","Goby","Angel Fish","Chromis","Anthias","Eel","Hawkfish","Clownfish","Cardinal","Trigger"};
    Integer imageIdSize3[] = {R.drawable.wrasse,R.drawable.foxface,R.drawable.tang,R.drawable.goby,R.drawable.angel,
            R.drawable.chromis,R.drawable.anthias,R.drawable.eel,R.drawable.hawkfish,R.drawable.clown,R.drawable.cardinal,R.drawable.trigger};
    //size2
    String fishnameSize2[] = {"Wrasse","Goby","Angel Fish","Chromis","Eel","Hawkfish","Clownfish","Cardinal"};
    Integer imageIdSize2[] = {R.drawable.wrasse,R.drawable.goby,R.drawable.angel,R.drawable.chromis,R.drawable.eel,R.drawable.hawkfish,
            R.drawable.clown,R.drawable.cardinal};
    //size1
    String fishnameSize1[] = {"Wrasse","Goby","Chromis","Clownfish","Cardinal"};
    Integer imageIdSize1[] = {R.drawable.wrasse,R.drawable.goby,R.drawable.chromis,R.drawable.clown,R.drawable.cardinal};
    Custom_fish_listview customFishListview;
    SharedPreferences shareSize;
    CheckBox checkBox;
    String tanksize;


    //share the selected list to the result page
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    LinkedHashSet<String> selectedItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_fish);

        listview = (ListView) findViewById(R.id.listview_fish);
        shareSize = PreferenceManager.getDefaultSharedPreferences(this);
        tanksize = shareSize.getString(keysize,"nothing");

        //decides what tank choice user can choose depends on their budget
        if(tanksize.equals("size4") || tanksize.equals("size3"))
        {
            customFishListview = new Custom_fish_listview(this,fishnameSize3,imageIdSize3,checkBox);
        }
        else if(tanksize.equals("size2"))
        {
            customFishListview = new Custom_fish_listview(this,fishnameSize2,imageIdSize2,checkBox);
        }
        else if(tanksize.equals("size1"))
        {
            customFishListview = new Custom_fish_listview(this,fishnameSize1,imageIdSize1,checkBox);
        }


        listview.setAdapter(customFishListview);
        selectedItems=new LinkedHashSet<>();
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sharedPreferences.edit();

    }



    public void onClick(View v) {
        String str="";

        for(int i=0;i<customFishListview.getSelectedfish().size();i++)
        {
            selectedItems.add(customFishListview.getSelectedfish().get(i));
            str+=customFishListview.getSelectedfish().get(i)+"\n";

        }

        if(customFishListview.getSelectedfish().size() == 0)
        {
            selectedItems.add("Let's go back choose something!");
        }
        editor.putStringSet("keySelectedFish",selectedItems);
        editor.apply();
        Toast.makeText(this,"You've selected:\n"+str, Toast.LENGTH_LONG).show();


        Log.d("seleted fishhh",customFishListview.getSelectedfish().toString());
        Log.d("key fish",selectedItems.toString());



        Intent i = new Intent(choose_fish.this,ScrollableTabsActivity.class);
        startActivity(i);

    }


}
