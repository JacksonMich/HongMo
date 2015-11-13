package com.example.whx.hongmo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by whx on 2015/11/5.
 */
public class LaunchActivity extends Activity{

    private final int GOTO_MAIN_ACTIVITY = 0;
    private final int GOTO_LOGIN_ACTIVITY = 1;
    private boolean isUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch);

        isUser = new SharedInfo(this).getIsUser();
        if(isUser){
            mHandler.sendEmptyMessageDelayed(GOTO_MAIN_ACTIVITY, 2000);
        }else{
            mHandler.sendEmptyMessageDelayed(GOTO_LOGIN_ACTIVITY, 2000);
        }

    }

    Handler mHandler = new Handler(new Handler.Callback() {

        public boolean handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case GOTO_MAIN_ACTIVITY:
                    Intent intent = new Intent();
                    intent.setClass(LaunchActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                    break;
                case GOTO_LOGIN_ACTIVITY:
                    Intent intent1 = new Intent();
                    intent1.setClass(LaunchActivity.this, LoginActivity.class);
                    startActivity(intent1);
                    finish();
                    break;
                default:
                    break;
            }
            return true;

        }
    });
}
