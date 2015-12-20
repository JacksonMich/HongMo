package com.example.whx.hongmo;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by whx on 2015/11/11.
 */
public class RecordActivity extends Activity{

    private NotifiableViewFlipper viewFlipper;
    private ListView recordList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.record);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        CustomActionBar actionBar = new CustomActionBar(this);
        actionBar.setActionBarLayout(R.layout.actionbar);
        actionBar.setTitle("验证记录");

        recordList = (ListView)findViewById(R.id.record_list);
        setData();
    }
    private void setData(){

        TextView name = (TextView)findViewById(R.id.name);
        String uname = new SharedInfo(this).getInfo()[0];
        name.setText(uname);

        String[] titles = {"2015年11月","2015年11月","2015年11月"};
        String[] subtitles = {"11月10日 10:25","11月10日 10:25","11月10日 10:25"};
        String[] lingquzhuangtai = {"领取失败","成功","成功","成功"};
        String[] lingqujine = {"身份信息有误","200元","200元"};

        RecordListAdapter adapter = new RecordListAdapter(this);
        adapter.setSource(titles, subtitles,lingquzhuangtai,lingqujine);

        recordList.setAdapter(adapter);
    }


    private void setAdView(){

        int[] images = {R.mipmap.guanggaotu,R.mipmap.guanggaotu};
        viewFlipper = (NotifiableViewFlipper)findViewById(R.id.viewFlipper);
        Advertise advertise = new Advertise(this,viewFlipper);
        advertise.setAdImages(images);
        advertise.addAdFlipperImageViews();

        viewFlipper.setVisibility(View.VISIBLE);
    }
}
