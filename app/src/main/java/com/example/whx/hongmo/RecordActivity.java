package com.example.whx.hongmo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

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
        new CustomActionBar(this).setActionBarLayout(R.layout.actionbar);
        recordList = (ListView)findViewById(R.id.record_list);
        setAdView();
        setData();
    }
    private void setData(){
        String[] titles = {"第一组数据","第二组数据","第三组数据"};
        String[] subtitles = {"blablabla","blablabla","blablabla"};

        RecordListAdapter adapter = new RecordListAdapter(this);
        adapter.setTitles(titles,subtitles);

        recordList.setAdapter(adapter);
    }

    private void setAdView(){

        int[] images = {R.mipmap.ad1,R.mipmap.ad2};
        viewFlipper = (NotifiableViewFlipper)findViewById(R.id.viewFlipper);
        Advertise advertise = new Advertise(this,viewFlipper);
        advertise.setAdImages(images);
        advertise.addAdFlipperImageViews();
    }
}
