package com.example.whx.hongmo;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

/**
 * Created by whx on 2015/11/5.
 */
public class MainActivity extends Activity implements View.OnClickListener{

    private Button startRenzhengBtn,personalInfoBtn,connectBtn,process,recordBtn;
    private NotifiableViewFlipper viewFlipper;
    private MyReceiver receiver;
    private int counterForJustFuckingFun=0;
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CustomActionBar actionBar = new CustomActionBar(this);
        actionBar.setActionBarLayout(R.layout.actionbar);
        actionBar.setBackVisible(View.INVISIBLE);
        actionBar.setTitle("首页");

        initContent();
        testAd();

        registerRec();
    }

    private void initContent(){

        relativeLayout = (RelativeLayout)findViewById(R.id.m_R1);

        startRenzhengBtn = (Button)findViewById(R.id.startRenzheng);
        startRenzhengBtn.setOnClickListener(this);

        recordBtn = (Button)findViewById(R.id.record);
        recordBtn.setOnClickListener(this);

        personalInfoBtn = (Button)findViewById(R.id.personalInfo);
        personalInfoBtn.setOnClickListener(this);

        connectBtn = (Button)findViewById(R.id.connectDevice);
        connectBtn.setOnClickListener(this);

        process = (Button)findViewById(R.id.process);
        process.setOnClickListener(this);
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

        RelativeLayout.LayoutParams lp=(RelativeLayout.LayoutParams)relativeLayout.getLayoutParams();

        int height  = lp.height;

        height = height - Advertise.HEIGHT;

        lp.height=height;

        relativeLayout.setLayoutParams(lp);

        relativeLayout.setLayoutParams(lp);

        viewFlipper.setVisibility(View.VISIBLE);
    }

    private void registerRec(){

        receiver = new MyReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.whx.hongmo");
        registerReceiver(receiver,intentFilter);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.startRenzheng:
                Intent intent2 = new Intent();
                intent2.setClass(this,CameraActivity.class);
                startActivity(intent2);
                break;
            case R.id.personalInfo:
                Intent intent1 = new Intent();
                intent1.setClass(this,PersonalInfoActivity.class);
                startActivity(intent1);
                break;
            case R.id.connectDevice:
                counterForJustFuckingFun++;
                if(counterForJustFuckingFun%2==0) {
                    Intent intent3 = new Intent();
                    intent3.setClass(this, ConnectionActivity.class);
                    startActivity(intent3);
                    break;
                }
                else {
                    Intent intent3 = new Intent();
                    intent3.setClass(this, ConnectionFailActivity.class);
                    startActivity(intent3);
                    break;
                }
            case R.id.process:
                counterForJustFuckingFun++;
                if(counterForJustFuckingFun%2==0){
                Intent intent4 = new Intent();
                intent4.setClass(this,ProgressActivity.class);
                startActivity(intent4);
                break;
                }
                else if(counterForJustFuckingFun%3==0){
                    Intent intent4 = new Intent();
                    intent4.setClass(this,GetFailedActivity.class);
                    startActivity(intent4);
                    break;
                }
                else{
                    Intent intent4 = new Intent();
                    intent4.setClass(this,GetSuccessActivity.class);
                    startActivity(intent4);
                    break;
                }
            case R.id.record:
                Intent intent5 = new Intent();
                intent5.setClass(this,RecordActivity.class);
                startActivity(intent5);
                break;
        }
    }


}
