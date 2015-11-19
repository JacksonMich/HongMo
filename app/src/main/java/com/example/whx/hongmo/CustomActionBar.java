package com.example.whx.hongmo;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by whx on 2015/11/6.
 */
public class CustomActionBar {

    private Activity context;
    private TextView back;
    private TextView title;

    public CustomActionBar(){

    }
    public CustomActionBar(Activity context){
        this.context = context;
    }

    public void setActionBarLayout( int layoutId ){
        ActionBar actionBar = context.getActionBar();
        if( null != actionBar ){
            actionBar.setDisplayShowHomeEnabled( false );
            actionBar.setDisplayShowCustomEnabled(true);
            LayoutInflater inflator = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v = inflator.inflate(layoutId, null);
            ActionBar.LayoutParams layout = new ActionBar.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,LinearLayout.LayoutParams.FILL_PARENT);
            actionBar.setCustomView(v,layout);

            back = (TextView)v.findViewById(R.id.back);
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.finish();
                }
            });

            title = (TextView)v.findViewById(R.id.yemian_title);
        }
    }
    public void setTitle(String title){

        this.title.setText(title);
    }
    public void setBackVisible(int visible){
        back.setVisibility(visible);
    }
}
