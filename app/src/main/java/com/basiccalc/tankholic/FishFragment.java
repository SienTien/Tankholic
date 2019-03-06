package com.basiccalc.tankholic;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;


public class FishFragment extends Fragment {
    SharedPreferences shareFishname;
    SharedPreferences.Editor editor;
    ListView listview;
    Set<String> fishname = new LinkedHashSet<>();
    Set<String> fishImg = new LinkedHashSet<>();
    Custom_fish_listview_frag customFishListview;

    ArrayList<String> fishnameArr;
    public FishFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fish, container, false);
        listview = (ListView)v.findViewById(R.id.listview_fishfrag);
        shareFishname = PreferenceManager.getDefaultSharedPreferences(this.getContext());
        fishname = shareFishname.getStringSet("keySelectedFish",null);
        Integer fishImgInt[] ;
        String fishNameString[];
        ArrayList<Integer> fishImgArr = new ArrayList<>();
        fishnameArr = new ArrayList<>(fishname);

        for(int i = 0; i<fishnameArr.size();i++)
        {
            switch(fishnameArr.get(i))
            {
                case"Wrasse":

                    fishImgArr.add( R.drawable.wrasse);
                    break;
                case "Foxface":

                    fishImgArr.add( R.drawable.foxface);
                    break;
                case "Tang":

                    fishImgArr.add( R.drawable.tang);
                    break;
                case "Goby":

                    fishImgArr.add( R.drawable.goby);
                    break;
                case "Angel Fish":

                    fishImgArr.add( R.drawable.angel);
                    break;
                case "Chromis":

                    fishImgArr.add( R.drawable.chromis);
                    break;
                case "Anthias":

                    fishImgArr.add( R.drawable.anthias);
                    break;
                case "Eel":

                    fishImgArr.add( R.drawable.eel);
                    break;

                case "Hawkfish":
                        fishImgArr.add( R.drawable.hawkfish);
                        break;
                case "Clownfish":

                    fishImgArr.add( R.drawable.clown);
                    break;
                case "Cardinal":

                    fishImgArr.add( R.drawable.cardinal);
                    break;
                case "Trigger":

                    fishImgArr.add( R.drawable.trigger);
                    break;
            }
        }

        fishImgInt = new Integer[fishImgArr.size()];
        for (int i = 0; i < fishImgArr.size(); i++) {
            fishImgInt[i] = fishImgArr.get(i);
        }
        fishNameString = new String[fishnameArr.size()];
        for (int i = 0; i < fishnameArr.size(); i++) {
            fishNameString[i] = fishnameArr.get(i);
        }
        Log.d("listview_coralImg",fishImgInt.toString());
        Log.d("listview_namefish",Arrays.toString(fishNameString));
        customFishListview = new Custom_fish_listview_frag(getActivity(),fishNameString,fishImgInt);
        listview.setAdapter(customFishListview);
        return v;
    }
}

