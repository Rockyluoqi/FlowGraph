package com.ROCKY_IMAGEBrowser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
//import android.view.View;
//import android.view.animation.Animation;
//import android.view.animation.Animation.AnimationListener;
//import android.view.animation.AnimationUtils;
import com.ROCKY.IMAGEBrowser.R;


public class StartActivity extends Activity {

    private Handler handler = new Handler();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //View view = View.inflate(this,R.layout.start_layout,null);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.start_layout);

        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                gohome();
                // TODO Auto-generated method stub

            }
        }, 500);
    }

    public void gohome() {

        Intent intent = new Intent(StartActivity.this, MainActivity.class);
        startActivity(intent);
        StartActivity.this.finish();
        //Intent.setclass(StartActivity.this,MainActivity.class);
        //StartActivity.this.startActivity(intent);
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

}
