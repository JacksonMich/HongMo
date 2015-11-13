package com.example.whx.hongmo;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by whx on 2015/11/4.
 */
public class PersonalInfoActivity extends Activity implements View.OnClickListener{

    private TextView userNameText,userSexText,userIDText,userAgeText;
    private Button quitAccount;
    SharedInfo sharedInfo;
    private NotifiableViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_info);
        new CustomActionBar(this).setActionBarLayout(R.layout.actionbar);
        sharedInfo = new SharedInfo(this);

        initContent();
        setAdView();

    }

    private void initContent(){
        userNameText = (TextView)findViewById(R.id.userName);
        userSexText = (TextView)findViewById(R.id.sex);
        userIDText = (TextView)findViewById(R.id.userID);
        userAgeText = (TextView)findViewById(R.id.userAge);

        quitAccount = (Button)findViewById(R.id.quitAccount);
        quitAccount.setOnClickListener(this);
    }

    private void saveInfo(){
//        String userName,userSex,userID,userShebao,phoneNumber;
//        userName = userNameText.getText().toString();
//        userSex = userSexText.getText().toString();
//        userID = userIDText.getText().toString();
//        userShebao = userAgeText.getText().toString();
//
//
//        SharedInfo sharedInfo = new SharedInfo(this);
//        sharedInfo.setInfo(userName,userSex,userID,userShebao,phoneNumber);
//        sharedInfo.setIsUser(true);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.quitAccount:
                quitAccount();

                Intent intent1 = new Intent();
                intent1.setAction("com.example.whx.hongmo");
                sendBroadcast(intent1);

                Intent intent = new Intent();
                intent.setClass(this,LoginActivity.class);
                startActivity(intent);

                finish();

                break;

        }
    }

    private void quitAccount(){

        sharedInfo.setIsUser(false);
    }
    private void setAdView(){

        int[] images = {R.mipmap.ad1,R.mipmap.ad2};
        viewFlipper = (NotifiableViewFlipper)findViewById(R.id.viewFlipper);
        Advertise advertise = new Advertise(this,viewFlipper);
        advertise.setAdImages(images);
        advertise.addAdFlipperImageViews();
    }
}
