package com.ROCKY_IMAGEBrowser;


import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.ROCKY.IMAGEBrowser.R;

import java.io.BufferedInputStream;
import java.io.IOException;

public class ChangeBigActivity extends Activity implements OnSeekBarChangeListener {
    private int minWidth = 80;
    private ImageView imageView;
    private TextView textView1, textView2;
    private Matrix matrix = new Matrix();

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress,
                                  boolean fromUser) {
        if (seekBar.getId() == R.id.seekBar1) {
            int newWidth = progress + minWidth;
            int newHeight = (int) (newWidth * 3 / 4);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(newWidth,
                    newHeight));
            textView1.setText("width : " + newWidth + "height : " + newHeight);
        } else if (seekBar.getId() == R.id.seekBar1) {

            String s = getIntent().getStringExtra("filename");
            BufferedInputStream bf;
            AssetManager assetManager = getAssets();
            Bitmap bitmap;
            try {
                bf = new BufferedInputStream(assetManager
                        .open("images/" + s));
                bitmap = BitmapFactory.decodeStream(bf);

                Matrix matrix = new Matrix();

                matrix.setRotate(progress);

                bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);

                imageView.setImageBitmap(bitmap);
                textView2.setText(progress + "度");
            } catch (IOException e) {

                e.printStackTrace();
            }

        }

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        imageView = (ImageView) findViewById(R.id.imageView);
        SeekBar seekBar1 = (SeekBar) findViewById(R.id.seekBar1);
        SeekBar seekBar2 = (SeekBar) findViewById(R.id.seekBar2);
        textView1 = (TextView) findViewById(R.id.textview1);
        textView2 = (TextView) findViewById(R.id.textview2);
        //seekBar1.setOnSeekBarChangeListener(this);
        //seekBar2.setOnSeekBarChangeListener(this);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        seekBar1.setMax(dm.widthPixels - minWidth);
    }
}