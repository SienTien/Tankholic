package com.basiccalc.tankholic;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ListView;

import java.util.ArrayList;

import static com.basiccalc.tankholic.first.keysize;


public class EquipFragment extends Fragment {
    ListView listview;
    String equipmentname[] = {"Skimmer","Heater","Light","Tank","Stand","Plumbing","Return Pump","Power Head",
    "Calcium Reactor", "Dosing Pump","Control System","Sump"};
    Integer imageId[] = {R.drawable.skimmer,R.drawable.heater,R.drawable.light,R.drawable.tank,R.drawable.stand,R.drawable.plumbing,
    R.drawable.returnpump,R.drawable.powerhead,R.drawable.calcium,R.drawable.dosing,R.drawable.control,R.drawable.sump};

    Custom_equip_listview customEquipListview;
    public EquipFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_equip, container, false);
        listview = (ListView)v.findViewById(R.id.listview_equip);

        customEquipListview = new Custom_equip_listview(getActivity(),equipmentname, imageId);
        Log.d("listview_equip",customEquipListview.toString());
        listview.setAdapter(customEquipListview);
        return v;
    }


}

