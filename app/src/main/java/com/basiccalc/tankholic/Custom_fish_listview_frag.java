package com.basiccalc.tankholic;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Custom_fish_listview_frag extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] itemname;
    private final Integer[] imgid;

    public Custom_fish_listview_frag(Activity context, String[] itemname, Integer[] imgid) {
        super(context, R.layout.listview_fishname_frag, itemname);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.itemname=itemname;
        this.imgid=imgid;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.listview_fishname_frag, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.textViewFishfrag);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.fishImgfrag);

        if(itemname[position]!=null) {
            txtTitle.setText(itemname[position]);
            if(itemname[position] != "Let's go back choose something!") {
                imageView.setImageResource(imgid[position]);
            }
            else
                imageView.setImageResource(0);
        }

        return rowView;

    };
}
