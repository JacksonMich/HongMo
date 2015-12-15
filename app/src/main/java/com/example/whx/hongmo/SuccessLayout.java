package com.example.whx.hongmo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by ZhuTalan on 2015/11/11.
 */
public class SuccessLayout extends Activity implements View.OnClickListener{
    private NotifiableViewFlipper viewFlipper;
    private Button confirm;
    private TextView name,sex,age,pID,place;
    SharedInfo sharedInfo;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.success_info);

        CustomActionBar actionBar = new CustomActionBar(this);
        actionBar.setActionBarLayout(R.layout.actionbar);
        actionBar.setTitle("认证状态");

        sharedInfo = new SharedInfo(this);

        confirm = (Button)findViewById(R.id.quitAccount);
        confirm.setOnClickListener(this);

        initContent();
        setPersonalInfo();
    }
    private void initContent(){
        name=(TextView)findViewById(R.id.sex);
        sex=(TextView)findViewById(R.id.userAge);
        age=(TextView)findViewById(R.id.userID);
        pID=(TextView)findViewById(R.id.textView2);
        place=(TextView)findViewById(R.id.textView4);
    }
    private void setPersonalInfo(){
        SharedInfo sharedInfo = new SharedInfo(this);
        name.setText(sharedInfo.getInfo()[0]);
        sex.setText(sharedInfo.getInfo()[1]);
        age.setText(sharedInfo.getInfo()[3]);
        pID.setText(sharedInfo.getInfo()[2]);
        place.setText(sharedInfo.getInfo()[4]);

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
