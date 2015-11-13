package com.example.whx.hongmo;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;


/**
 * Created by ZhuTalan on 2015/11/5.
 */

public class CameraActivity extends Activity {
    private Button btn_camera_capture = null;
    private Button btn_camera_cancel = null;
    private Button btn_camera_ok = null;
    private Camera camera = null;
    private MySurfaceView mySurfaceView = null;

    private byte[] buffer = null;

    private final int TYPE_FILE_IMAGE = 1;

    private NotifiableViewFlipper viewFlipper;

    private Camera.PictureCallback pictureCallback = new Camera.PictureCallback() {

        @Override
        public void onPictureTaken(byte[] data, Camera camera) {
            if (data == null) {
                Log.i("MyPicture", "picture taken data: null");
            } else {
                Log.i("MyPicture", "picture taken data: " + data.length);
            }

            buffer = new byte[data.length];
            buffer = data.clone();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mycamera_layout);

        new CustomActionBar(this).setActionBarLayout(R.layout.actionbar);
        setAdView();
        btn_camera_capture = (Button) findViewById(R.id.camera_capture);
        btn_camera_ok = (Button) findViewById(R.id.camera_ok);
        btn_camera_cancel = (Button) findViewById(R.id.camera_cancel);


        btn_camera_capture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (camera == null) {
                    Toast.makeText(getApplicationContext(), "出错了！", Toast.LENGTH_SHORT).show();
                } else {
                    camera.takePicture(null, null, pictureCallback);
                }
                btn_camera_capture.setVisibility(View.INVISIBLE);
                btn_camera_ok.setVisibility(View.VISIBLE);
                btn_camera_cancel.setVisibility(View.VISIBLE);
            }
        });
        btn_camera_ok.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int fun=(int)(Math.random()*100)+1;
                if(fun>=50) {
                    Intent intent = new Intent();
                    intent.setClass(CameraActivity.this, SuccessLayout.class);
                    startActivity(intent);
               }
                else{
                    Intent intent = new Intent();
                    intent.setClass(CameraActivity.this, ConnectionFailActivity.class);
                    startActivity(intent);
               }
                //camera.startPreview();
                btn_camera_capture.setVisibility(View.VISIBLE);
                btn_camera_ok.setVisibility(View.INVISIBLE);
                btn_camera_cancel.setVisibility(View.INVISIBLE);
            }
        });
        btn_camera_cancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(CameraActivity.this, CameraActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        camera.release();
        camera = null;
    }

    @TargetApi(9)
    @Override
    protected void onResume() {
        super.onResume();

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
			camera = Camera.open(0);
            camera.setDisplayOrientation(90);
		} else {
			camera = Camera.open();
            camera.setDisplayOrientation(90);
		}
        if (camera == null) {
        }
        mySurfaceView = new MySurfaceView(getApplicationContext(), camera);
        FrameLayout preview = (FrameLayout) findViewById(R.id.camera_preview);
        preview.addView(mySurfaceView);
    }

    private void setAdView(){

        int[] images = {R.mipmap.ad1,R.mipmap.ad2};
        viewFlipper = (NotifiableViewFlipper)findViewById(R.id.viewFlipper);
        Advertise advertise = new Advertise(this,viewFlipper);
        advertise.setAdImages(images);
        advertise.addAdFlipperImageViews();
    }
}





