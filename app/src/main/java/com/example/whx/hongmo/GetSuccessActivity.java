package com.example.whx.hongmo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by ZhuTalan on 2015/11/11.
 */
public class GetSuccessActivity extends Activity implements View.OnClickListener{
    private NotifiableViewFlipper viewFlipper;
    private Button confirm;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.getsuccess_layout);
        new CustomActionBar(this).setActionBarLayout(R.layout.actionbar);
        setAdView();

        confirm = (Button)findViewById(R.id.confirm);
        confirm.setOnClickListener(this);
    }

    private void setAdView(){

        int[] images = {R.mipmap.ad1,R.mipmap.ad2};
        viewFlipper = (NotifiableViewFlipper)findViewById(R.id.viewFlipper);
        Advertise advertise = new Advertise(this,viewFlipper);
        advertise.setAdImages(images);
        advertise.addAdFlipperImageViews();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.confirm:
                finish();
                break;
        }
    }
}
