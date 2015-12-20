package com.example.whx.hongmo;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by ZhuTalan on 2015/11/11.
 */
public class GetSuccessActivity extends Activity implements View.OnClickListener{
    private NotifiableViewFlipper viewFlipper;
    private Button confirm;
    SharedInfo sharedInfo;
    private TextView name;
    private ListView recordList;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.getsuccess_layout);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        CustomActionBar actionBar = new CustomActionBar(this);
        actionBar.setActionBarLayout(R.layout.actionbar);
        actionBar.setTitle("领取状态");
        recordList = (ListView)findViewById(R.id.record_list);
        setData();
    }
    private void setData(){
        String[] titles = {"2015年11月","2015年10月","2015年9月"};
        String[] subtitles = {"11月10日 10:25","10月10日 10:25","9月10日 10:25"};
        String[] lingquzhuangtai = {"成功","成功","成功","成功"};
        String[] lingqujine = {"1200元","200元","200元"};

        RecordListAdapter adapter = new RecordListAdapter(this);
        adapter.setSource(titles, subtitles, lingquzhuangtai, lingqujine);

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
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.quitAccount:
                finish();
                break;
        }
    }
}
