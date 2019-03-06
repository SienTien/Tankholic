package com.basiccalc.tankholic;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class view_tank extends AppCompatActivity implements View.OnClickListener{

    ImageButton newtank, viewtank, web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_tank);

        newtank = (ImageButton) findViewById(R.id.newtank);
        viewtank = (ImageButton) findViewById(R.id.viewtank);
        web = (ImageButton) findViewById(R.id.web);


        newtank.setOnClickListener(this);
        viewtank.setOnClickListener(this);
        web.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.newtank:
                Intent i = new Intent(view_tank.this,first.class);
                startActivity(i);
                break;
            case R.id.viewtank:
                Intent j = new Intent(view_tank.this,ScrollableTabsActivity.class);
                startActivity(j);
                break;

            case R.id.web:
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.tankholic.com"));
                startActivity(intent);


        }
    }
}
