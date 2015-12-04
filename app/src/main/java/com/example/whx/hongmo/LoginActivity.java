package com.example.whx.hongmo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity implements View.OnClickListener{

//    private NotifiableViewFlipper viewFlipper;
    private Button loginBtn;
    private EditText userID,userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

//        setAdView();
        loginBtn = (Button)findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(this);

        userID = (EditText)findViewById(R.id.userIdText);
        userName = (EditText)findViewById(R.id.userNameText);
//        userSex = (EditText)findViewById(R.id.userSexText);

    }

    @Override
    public void onClick(View v) {
        if(loginSuccess()){
            Intent intent = new Intent();
            intent.setClass(this,MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }
    }

    private boolean loginSuccess(){
        String ID = userID.getText().toString();
        String name = userName.getText().toString();
//        String sex = userSex.getText().toString();

        SharedInfo sharedInfo = new SharedInfo(this);
        sharedInfo.setInfo(name,ID);
        sharedInfo.setIsUser(true);

        return true;
    }
//    private void setAdView(){
//
//        int[] images = {R.mipmap.guanggaotu,R.mipmap.guanggaotu};
//        viewFlipper = (NotifiableViewFlipper)findViewById(R.id.viewFlipper);
//        Advertise advertise = new Advertise(this,viewFlipper);
//        advertise.setAdImages(images);
//        advertise.addAdFlipperImageViews();
//    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
    }
}
