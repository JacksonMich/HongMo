package com.example.whx.hongmo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by ZhuTalan on 2015/11/11.
 */
public class CameraActivity extends Activity implements View.OnClickListener{
    private NotifiableViewFlipper viewFlipper;
    private Button confirm;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mycamera_layout);

        CustomActionBar actionBar = new CustomActionBar(this);
        actionBar.setActionBarLayout(R.layout.actionbar);
        actionBar.setTitle("图像显示");

        setAdView();

        confirm = (Button)findViewById(R.id.quitAccount);
        confirm.setOnClickListener(this);
    }


    private void setAdView(){

        int[] images = {R.mipmap.guanggaotu,R.mipmap.guanggaotu};
        viewFlipper = (NotifiableViewFlipper)findViewById(R.id.viewFlipper);
        Advertise advertise = new Advertise(this,viewFlipper);
        advertise.setAdImages(images);
        advertise.addAdFlipperImageViews();

        viewFlipper.setVisibility(View.VISIBLE);
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
