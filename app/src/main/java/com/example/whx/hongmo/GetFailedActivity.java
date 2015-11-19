package com.example.whx.hongmo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by ZhuTalan on 2015/11/11.
 */
public class GetFailedActivity extends Activity implements View.OnClickListener{
    private NotifiableViewFlipper viewFlipper;
    private Button confirm;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.getfailed_layout);

        CustomActionBar actionBar = new CustomActionBar(this);
        actionBar.setActionBarLayout(R.layout.actionbar);
        actionBar.setTitle("领取状态");

        testAd();

        confirm = (Button)findViewById(R.id.quitAccount);
        confirm.setOnClickListener(this);
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
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.quitAccount:
               finish();
                break;
        }
    }
}
