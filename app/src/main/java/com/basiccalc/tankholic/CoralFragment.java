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
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static com.basiccalc.tankholic.first.keysize;


public class CoralFragment extends Fragment {

    SharedPreferences shareCoralname;
    SharedPreferences.Editor editor;
    ListView listview;
    Set<String> coralname = new LinkedHashSet<>();

    Custom_coral_listview_frag customCoralListview;

    ArrayList<String> coralnameArr ;
    ArrayList<Integer> coralImgArr;
    public CoralFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_coral, container, false);
        listview = (ListView)v.findViewById(R.id.listview_coralfrag);
        shareCoralname = PreferenceManager.getDefaultSharedPreferences(this.getContext());
        coralname = shareCoralname.getStringSet("keySelectedCoral",null);
        Integer coralImgInt[] ;
        String coralNameString[];
        coralnameArr = new ArrayList<>(coralname);
        coralImgArr = new ArrayList<>();

        for(int j=0; j<coralname.size();j++)
        {
           switch( coralnameArr.get(j))

            {
                case "Sun Coral":
                    coralImgArr.add(R.drawable.sun) ;
                    break;
                case"Sea Fan":
                    coralImgArr.add(R.drawable.seafan);
                    break;
                case "Gorgonian":
                    coralImgArr.add(R.drawable.gorgonian);
                    break;
                case "Euphyllia":
                    coralImgArr.add(R.drawable.euphyllia);
                    break;
                case "Brain Coral":
                    coralImgArr.add(R.drawable.brain);
                    break;
                case "Scolymia":
                    coralImgArr.add(R.drawable.scolymia);
                    break;
                case "Gonipora":
                    coralImgArr.add(R.drawable.goniopora);
                    break;
                    case "Chalice":
                        coralImgArr.add(R.drawable.chalice);
                case "Candy Cane":
                    coralImgArr.add(R.drawable.candycane);
                    break;
                case "Mushroom":
                    coralImgArr.add(R.drawable.mushroom);
                    break;
                case "Montipora":
                    coralImgArr.add(R.drawable.montipora);
                    break;
                case "Birdnest":
                    coralImgArr.add(R.drawable.birdnest);
                    break;
                case "Acropora":
                    coralImgArr.add(R.drawable.acropora);
                    break;
                default:
                    coralImgArr.add(0);
                    break;

            }
        }
       coralImgInt = new Integer[coralImgArr.size()];
        for (int i = 0; i <coralImgArr.size(); i++) {
            coralImgInt[i] = coralImgArr.get(i);
        }
        coralNameString = new String[coralnameArr.size()];
        for (int i = 0; i < coralnameArr.size(); i++) {
            coralNameString [i] = coralnameArr.get(i);
        }

        customCoralListview = new Custom_coral_listview_frag(getActivity(),coralNameString,coralImgInt);
        listview.setAdapter(customCoralListview);
        return v;
    }
}