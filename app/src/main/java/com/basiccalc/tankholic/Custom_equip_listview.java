package com.basiccalc.tankholic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Custom_equip_listview extends ArrayAdapter<String>  {

    private String equipment[];
    private Integer imageId[];
    private Context context;

    public Custom_equip_listview(Context context, String[] equipname, Integer[] imageId)
    {
        super(context,R.layout.listview_equipment,equipname);
        this.context = context;
        this.equipment = equipname;
        this.imageId = imageId;

    }



    @Override
    public View getView(final int position, View convertView, ViewGroup parent)
    {

        View r = convertView;
        Custom_equip_listview.ViewHolder viewHolder = null;

        if(r == null)
        {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            r = inflater.inflate(R.layout.listview_equipment, null, true);
            viewHolder = new Custom_equip_listview.ViewHolder(r);
            r.setTag(viewHolder);

        }
        else
        {
            viewHolder = (Custom_equip_listview.ViewHolder) r.getTag();
        }

        viewHolder.img.setImageResource(imageId[position]);
        viewHolder.txt.setText(equipment[position]);


        return r;
    }


    class ViewHolder
    {
        TextView txt;
        ImageView img;

        ViewHolder(View v)
        {

            txt= (TextView) v.findViewById(R.id.textViewEquip);
            img = (ImageView) v.findViewById(R.id.coralImgfrag);


        }
    }
}


