package com.example.whx.hongmo;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by ZhuTalan on 2015/11/7.
 */
public class ProgressActivity extends Activity {
    private NotifiableViewFlipper viewFlipper;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress);
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
