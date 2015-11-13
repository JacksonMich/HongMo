package com.example.whx.hongmo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by ZhuTalan on 2015/11/5.
 */
public class ConnectionActivity extends Activity{

    private NotifiableViewFlipper viewFlipper;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connection);
        new CustomActionBar(this).setActionBarLayout(R.layout.actionbar);
        setAdView();
    }
    private void setAdView(){

        int[] images = {R.mipmap.ad1,R.mipmap.ad2};
        viewFlipper = (NotifiableViewFlipper)findViewById(R.id.viewFlipper);
        Advertise advertise = new Advertise(this,viewFlipper);
        advertise.setAdImages(images);
        advertise.addAdFlipperImageViews();
    }
}

