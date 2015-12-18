package com.example.whx.hongmo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by whx on 2015/10/19.
 */
public class GuideActivity extends Activity implements ViewPager.OnPageChangeListener,View.OnClickListener{

    //引导图片资源
    private static final int[] guidPictures = { R.mipmap.page1,
            R.mipmap.page2, R.mipmap.page3};

    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private List<View> views;
    private ImageButton startButton;
    //记录当前选中位置
    private int currentIndex;
    //private GestureDetector gestureDetector;
    private final int GOTO_LOGIN_ACTIVITY = 2;

//    GestureUtils.Screen screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guid);
        views = new ArrayList<View>();

        LinearLayout.LayoutParams mParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);

        viewPager = (ViewPager) findViewById(R.id.viewpager);

        ImageView iv;View v;
        //初始化引导图片列表
        for(int i=0; i<guidPictures.length; i++) {
            v = LayoutInflater.from(this).inflate(R.layout.guid_view,viewPager,false);
            iv = (ImageView)v.findViewById(R.id.ivPic);
            iv.setImageResource(guidPictures[i]);
            views.add(v);
        }

//        v = LayoutInflater.from(this).inflate(R.layout.guid_last_view,viewPager,false);
//        startButton = (ImageButton)v.findViewById(R.id.ibStart);
//        startButton.setOnClickListener(this);
//        views.add(v);


        //初始化Adapter
        viewPagerAdapter = new ViewPagerAdapter(views);
        viewPager.setAdapter(viewPagerAdapter);
        //绑定回调
        viewPager.setOnPageChangeListener(this);

        //mHandler.sendEmptyMessageDelayed(GOTO_MAIN_ACTIVITY, 2000);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


    }

    @Override
    public void onPageSelected(int position) {

        if(position==2){
            mHandler.sendEmptyMessageDelayed(GOTO_LOGIN_ACTIVITY, 1000);
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

        //Log.i("------------",state+"");
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.setClass(GuideActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

//    GestureDetector.OnGestureListener onGestureListener = new GestureDetector.SimpleOnGestureListener(){
//        @Override
//        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
//                               float velocityY) {
//            float x = e2.getX() - e1.getX();
//            float y = e2.getY() - e1.getY();
//            //限制必须得划过屏幕的1/3才能算划过
//            float x_limit = screen.widthPixels / 3;
//            float y_limit = screen.heightPixels / 3;
//            float x_abs = Math.abs(x);
//            float y_abs = Math.abs(y);
//            if(x_abs >= y_abs){
//                //gesture left or right
//                if(x > x_limit || x < -x_limit){
//                    if(x>0){
//                        Log.i("-------------","right");
//                    }else if(x<0){
//                        Log.i("-------------","left");
//                    }
//                }
//            }
//            return true;
//        }
//
//    };
    Handler mHandler = new Handler(new Callback() {

        public boolean handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case GOTO_LOGIN_ACTIVITY:
                    Intent intent2 = new Intent(GuideActivity.this,LoginActivity.class);
                    startActivity(intent2);
                    finish();
                    break;
                default:
                    break;
            }
            return true;

        }
    });
}
