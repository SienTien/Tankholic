package com.basiccalc.tankholic;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Custom_fish_listview extends ArrayAdapter<String> implements View.OnClickListener, AdapterView.OnItemClickListener {

    private String fishname[];
    private Integer imageId[];
    private Activity context;
    private CheckBox checkBox;
    ArrayList<String> selectedfish = new ArrayList<String>();
    ArrayList<Integer> selectedImage = new ArrayList<Integer>();
    boolean[] checkedStates;


    public Custom_fish_listview(Activity context, String[] fishname,Integer[] imageId, CheckBox checkBox)
    {
        super(context,R.layout.listview_fishname,fishname);
        this.context = context;
        this.fishname = fishname;
        this.imageId = imageId;
        this.checkBox = checkBox;
        this.checkedStates = new boolean[fishname.length];
    }



    @Override
    public View getView(final int position, View convertView, ViewGroup parent)
    {

        View r = convertView;
        ViewHolder viewHolder = null;

        if(r == null)
        {
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r = layoutInflater.inflate(R.layout.listview_fishname, null, true);
            viewHolder = new ViewHolder(r);
            r.setTag(viewHolder);

            viewHolder.checkBox.setOnClickListener(this);
        }
        else
        {
            viewHolder = (ViewHolder) r.getTag();
        }

        viewHolder.img.setImageResource(imageId[position]);
        viewHolder.txt.setText(fishname[position]);
        viewHolder.checkBox.setTag(position);

        //add the checked fish into the arraylist
        //remove the uncheked fish
        viewHolder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkedStates[position] = !checkedStates[position];
                if (((CheckBox) v).isChecked()) {
                    selectedfish.add(fishname[position]);
                    selectedImage.add(imageId[position]);
                }
                else{
                    selectedfish.remove(fishname[position]);
                    selectedImage.remove(imageId[position]);
                }
                    Log.d("working", fishname[position]);

                Log.d("fishselectedinlistview",selectedfish.toString());

            }
        });
        viewHolder.checkBox.setChecked(checkedStates[position]);

        return r;
    }

    /**
     * return the selected fishlist
     * @return arraylist
     */
    public ArrayList<String> getSelectedfish() {
        return selectedfish;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }


    class ViewHolder
    {
        TextView txt;
        ImageView img;
        CheckBox checkBox;

        ViewHolder(View v)
        {

            txt= (TextView) v.findViewById(R.id.textViewFish);
            img = (ImageView) v.findViewById(R.id.coralImgfrag);
            checkBox = (CheckBox) v.findViewById(R.id.checkBox);


        }
    }
}

