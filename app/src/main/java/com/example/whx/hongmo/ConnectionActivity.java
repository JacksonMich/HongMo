package com.example.whx.hongmo;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by ZhuTalan on 2015/11/5.
 */
public class ConnectionActivity extends Activity{

    private NotifiableViewFlipper viewFlipper;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connection);

        CustomActionBar actionBar = new CustomActionBar(this);
        actionBar.setActionBarLayout(R.layout.actionbar);
        actionBar.setTitle("连接状态");

        testAd();
    }

    private void testAd(){

        int r = (int)(Math.random()*10);
        if(r%2==0) {
            setAdView();
        }else{

        }
    }

    private void setAdView(){

        int[] images = {R.mipmap.guanggaotu,R.mipmap.guanggaotu};
        viewFlipper = (NotifiableViewFlipper)findViewById(R.id.viewFlipper);
        Advertise advertise = new Advertise(this,viewFlipper);
        advertise.setAdImages(images);
        advertise.addAdFlipperImageViews();
    }
}

