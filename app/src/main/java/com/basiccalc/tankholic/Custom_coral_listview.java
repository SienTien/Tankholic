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

public class Custom_coral_listview extends ArrayAdapter<String> implements View.OnClickListener, AdapterView.OnItemClickListener {

    private String coralname[];
    private Integer imageId[];
    private Activity context;
    private CheckBox checkBox;
    ArrayList<String> selectedcoral = new ArrayList<String>();
    ArrayList<Integer> selectedImage = new ArrayList<Integer>();
    boolean[] checkedStates;


    public Custom_coral_listview(Activity context, String[] coralname,Integer[] imageId, CheckBox checkBox)
    {
        super(context,R.layout.listview_coralname,coralname);
        this.context = context;
        this.coralname = coralname;
        this.imageId = imageId;
        this.checkBox = checkBox;
        checkedStates = new boolean[coralname.length];
    }



    @Override
    public View getView(final int position, View convertView, ViewGroup parent)
    {

        View r = convertView;
        ViewHolder viewHolder = null;

        if(r == null)
        {
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r = layoutInflater.inflate(R.layout.listview_coralname, null, true);
            viewHolder = new ViewHolder(r);
            r.setTag(viewHolder);

            viewHolder.checkBox.setOnClickListener(this);
        }
        else
        {
            viewHolder = (ViewHolder) r.getTag();
        }

        viewHolder.img.setImageResource(imageId[position]);
        viewHolder.txt.setText(coralname[position]);
        viewHolder.checkBox.setTag(position);
        viewHolder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkedStates[position] = !checkedStates[position]; //avoid random checked checkbox
                if (((CheckBox) v).isChecked()) {
                    selectedcoral.add(coralname[position]);
                }
                else{
                    selectedcoral.remove(coralname[position]);
                }
                Log.d("working", coralname[position]);

                Log.d("coralselectedinlistview",selectedcoral.toString());

            }
        });
        viewHolder.checkBox.setChecked(checkedStates[position]);

        return r;
    }

    public ArrayList<String> getSelectedcoral() {
        return selectedcoral;
    }
    public ArrayList<Integer> getSelectedImage(){
        return selectedImage;
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

            txt= (TextView) v.findViewById(R.id.textViewCoral);
            img = (ImageView) v.findViewById(R.id.coralImg);
            checkBox = (CheckBox) v.findViewById(R.id.checkBox);


        }
    }
}

