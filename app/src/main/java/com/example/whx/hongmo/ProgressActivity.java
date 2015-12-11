package com.example.whx.hongmo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ZhuTalan on 2015/11/7.
 */
public class ProgressActivity extends Activity {
    private NotifiableViewFlipper viewFlipper;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress);

        CustomActionBar actionBar = new CustomActionBar(this);
        actionBar.setActionBarLayout(R.layout.actionbar);
        actionBar.setTitle("采集进度");

        setContent();
    }

    private void setContent(){

        ImageView imageView1 = (ImageView)findViewById(R.id.p_imageview1);
        ImageView imageView2 = (ImageView)findViewById(R.id.p_imageview2);
        ImageView imageView3 = (ImageView)findViewById(R.id.p_imageview3);
        ImageView imageView4 = (ImageView)findViewById(R.id.p_imageview4);
        ImageView imageView5 = (ImageView)findViewById(R.id.p_imageview5);
        ImageView imageView6 = (ImageView)findViewById(R.id.p_imageview6);
        ImageView imageView7 = (ImageView)findViewById(R.id.p_imageview7);

        TextView collection = (TextView)findViewById(R.id.p_collection);
        TextView collection_time = (TextView)findViewById(R.id.p_collection_time);

        TextView renzheng = (TextView)findViewById(R.id.p_renzheng);
        TextView renzheng_time = (TextView)findViewById(R.id.p_renzheng_time);

        TextView wait  = (TextView)findViewById(R.id.p_wait);
        TextView wait_time = (TextView)findViewById(R.id.p_wait_time);

        TextView success = (TextView)findViewById(R.id.p_success);
        TextView success_time = (TextView)findViewById(R.id.p_success_time);

        wait.setTextColor(0xa5a5a5);
        wait_time.setVisibility(View.INVISIBLE);

        success.setTextColor(0xa5a5a5);
        success_time.setVisibility(View.INVISIBLE);

    }
    private void setAdView(){

        int[] images = {R.mipmap.guanggaotu,R.mipmap.guanggaotu};
        viewFlipper = (NotifiableViewFlipper)findViewById(R.id.viewFlipper);
        Advertise advertise = new Advertise(this,viewFlipper);
        advertise.setAdImages(images);
        advertise.addAdFlipperImageViews();

        viewFlipper.setVisibility(View.VISIBLE);
    }
}
