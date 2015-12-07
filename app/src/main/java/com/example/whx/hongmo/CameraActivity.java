package com.example.whx.hongmo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.os.Handler;
import android.os.Handler.Callback;

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

        timer.sendEmptyMessageDelayed(1,2000);
    }

    Handler timer = new Handler(new Callback(){

        public boolean handleMessage(android.os.Message msg){
            switch(msg.what){
                case 1:
                    Intent intent = new Intent();
                    intent.setClass(CameraActivity.this,SuccessLayout.class);
                    startActivity(intent);
                    finish();
                    break;
            }
            return true;
        }
    });
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
