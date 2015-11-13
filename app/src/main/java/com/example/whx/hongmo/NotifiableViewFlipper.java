package com.example.whx.hongmo;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ViewFlipper;

/**
 * Created by whx on 2015/11/4.
 */
public class NotifiableViewFlipper extends ViewFlipper implements OnFlipListener{

    private OnFlipListener onFlipListener;


    public NotifiableViewFlipper(Context context) {
        super(context);
    }

    public NotifiableViewFlipper(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setOnFlipListener(OnFlipListener onFlipListener){

        this.onFlipListener = onFlipListener;
    }

    @Override
    public void onShowPrevious(NotifiableViewFlipper flipper) {

        super.showPrevious();
        if(hasFlipListener()){
            onFlipListener.onShowPrevious(this);
        }
    }

    @Override
    public void onShowNext(NotifiableViewFlipper flipper) {

        super.showNext();
        if(hasFlipListener()){
           onFlipListener.onShowNext(this);
        }
    }
    private boolean hasFlipListener(){
        return onFlipListener != null;
    }
}
