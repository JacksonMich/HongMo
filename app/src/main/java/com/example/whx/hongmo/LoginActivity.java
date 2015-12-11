package com.example.whx.hongmo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity implements View.OnClickListener{

//    private NotifiableViewFlipper viewFlipper;
    private Button loginBtn;
    private EditText userID,userName;
    private String ID,name;
    private boolean flag1=false,flag2=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


//        setAdView();
        loginBtn = (Button)findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(this);

        userID = (EditText)findViewById(R.id.userIdText);
//        userID.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                if(userID.hasFocus()==false){
//                    ID = userID.getText().toString();
//                    if (ID.length() != 18 || ID.length() != 15) {
//                        Toast.makeText(LoginActivity.this, "身份证号只能为15或18位", Toast.LENGTH_SHORT).show();
//                    } else {
//                        flag2 = true;
//                    }
//                }
//
//            }
//        });

        userName = (EditText)findViewById(R.id.userNameText);
        userName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (userName.hasFocus() == false) {
                    name = userName.getText().toString();
//                    Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
//                    Matcher m = p.matcher(name);
                    if (!checkNameChese(name)) {
                        Toast.makeText(LoginActivity.this, "姓名只能为汉字", Toast.LENGTH_SHORT).show();
                    } else if(name.equals("")){
                        Toast.makeText(LoginActivity.this,"请输入完整信息",Toast.LENGTH_LONG).show();

                    }else {
                        flag1 = true;
                    }
                }
            }
        });

    }

    @Override
    public void onClick(View v) {
        loginBtn.setFocusable(true);
        loginBtn.setFocusableInTouchMode(true);
        loginBtn.requestFocus();
        loginBtn.requestFocusFromTouch();
        ID = userID.getText().toString();
        if (ID.length() != 18 && ID.length() != 15) {
            Toast.makeText(LoginActivity.this, "身份证号只能为15或18位", Toast.LENGTH_SHORT).show();
        }else if(flag1){
            if(loginSuccess(ID,name)){
                Intent intent = new Intent();
                intent.setClass(this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        }else{
            Toast.makeText(LoginActivity.this, "姓名只能为汉字", Toast.LENGTH_SHORT).show();
        }

    }

    private boolean loginSuccess(String id,String name){

        String sex = new IdOperate().getSexStr(id);
        String age = new IdOperate().getBirthStr(id);
        String address = new IdToAddress(this).getAddress(new IdOperate().getAddressStr(id));

        SharedInfo sharedInfo = new SharedInfo(this);
        sharedInfo.setInfo(name,id,sex,age,address);
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
    private  boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            return true;
        }
        return false;
    }
    private  boolean checkNameChese(String name)
    {
        boolean res=true;
        char [] cTemp = name.toCharArray();
        for(int i=0;i<name.length();i++)
        {
            if(!isChinese(cTemp[i]))
            {
                res=false;
                break;
            }
        }
        return res;
    }
}
