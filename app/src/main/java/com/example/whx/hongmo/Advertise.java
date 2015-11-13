package com.example.whx.hongmo;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by whx on 2015/11/4.
 */
public class Advertise implements OnFlipListener{

    private int[] adImages;
    // 轮番广告Flipper
    private NotifiableViewFlipper adViewFlipper;
    // Flipper内的ImageView数组，保留引用，目前没什么用
    private ImageView[] adFlipperImageViews;
    private Context context;

    public Advertise(){

    }
    public Advertise(Context context,NotifiableViewFlipper adViewFlipper){
        this.context = context;
        this.adViewFlipper = adViewFlipper;
    }

    public void setAdImages(int[] adImages){
        this.adImages = adImages;
    }
    /**
     * 初始化插入轮番广告
     */
    public void addAdFlipperImageViews() {
        int len = adImages.length;
        adFlipperImageViews = new ImageView[len];
        for (int i = 0; i < len; i++) {
            ImageView imageView = makeAdFlipperImageView();
            imageView.setImageResource(adImages[i]);
            imageView.setOnClickListener(adFlipperImageViewListener);
//            adFlipperImageViews[i] = imageView;
            adViewFlipper.addView(imageView);
           }
        }

    /**
     * 工厂生产轮番广告容器ImageView对象
     * @return
     */
    private ImageView makeAdFlipperImageView() {
        ImageView i = new ImageView(context);
        i.setBackgroundColor(0xFF000000);
        i.setScaleType(ImageView.ScaleType.FIT_XY);
        i.setLayoutParams(new NotifiableViewFlipper.LayoutParams(
            NotifiableViewFlipper.LayoutParams.MATCH_PARENT,
            NotifiableViewFlipper.LayoutParams.MATCH_PARENT));
            return i;
        }

    /**
     * 每个广告的点击事件监听器
     */
     private View.OnClickListener adFlipperImageViewListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Toast.makeText(context,adViewFlipper.getDisplayedChild()+"",Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public void onShowPrevious(NotifiableViewFlipper flipper) {

    }

    @Override
    public void onShowNext(NotifiableViewFlipper flipper) {

    }
}
