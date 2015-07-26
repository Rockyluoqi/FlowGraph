package com.ROCKY_IMAGEBrowser;

import android.app.*;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.*;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.*;
import android.view.animation.AnimationSet;
import android.widget.*;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;


import com.ROCKY.IMAGEBrowser.R;

import java.io.BufferedInputStream;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Luoqi
 * Date: 14-1-1
 * Time: 下午9:31
 * To change this template use File | Settings | File Templates.
 */

import java.io.BufferedInputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.graphics.Matrix.*;


public class BigActivity extends Activity {

    private ImageView img;

    private TextView v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bigimg);


        v = (TextView) findViewById(R.id.tv_container);
        final int id = getIntent().getIntExtra("id", -1);
        final String s = getIntent().getStringExtra("filename");
        v.setText("id is " + getId(id) + "     filename is :" + getFileName(s));

        img = (ImageView) findViewById(R.id.img);
        BufferedInputStream buf;
        AssetManager assetManager = getAssets();
        Bitmap bitmap;
        try {
            buf = new BufferedInputStream(assetManager
                    .open("images/" + s));
            bitmap = BitmapFactory.decodeStream(buf);
            img.setImageBitmap(bitmap)
            ;
        } catch (IOException e) {

            e.printStackTrace();
        }


        //得到actionBar
        final String[] listNames = getResources().getStringArray(R.array.operation);
        ActionBar actionBar = getActionBar();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getBaseContext(),
                android.R.layout.simple_spinner_dropdown_item, listNames);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

        ActionBar.OnNavigationListener navigationListener = new ActionBar.OnNavigationListener() {
            @Override
            public boolean onNavigationItemSelected(int itemPosition, long itemId) {
                if (listNames[itemPosition].equals("旋转")) {
                    Toast.makeText(getApplicationContext(), "lalalala", Toast.LENGTH_SHORT).show();
//                    int id = getIntent().getIntExtra("id", -1);
//                    String ss = getIntent().getStringExtra("filename");
                    //Intent intent = new Intent(BigActivity.this, ChangeBigActivity.class);
                    //intent.putExtra("id", id);
                    //intent.putExtra("filename", s);
                    //startActivity(intent);
                }
                return false;
            }
        };
        actionBar.setListNavigationCallbacks(adapter, navigationListener);

    }

    String getFileName(String s) {
        if (s == null || "".equals(s)) return "filename cannot be found,it is null or it is no c";
        return s;
    }

    String getId(int id) {
        if (id == -1) return "no id found";
        return "" + id;
    }

    /*public void onProgressChanged(SeekBar seekBar,int progress,boolean fromuser)
    {
        static int minWidth = 80;
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        seekBar.setMax(dm.widthPixels-minWidth);


        if(seekBar.getId()==R.id.seekBar1)
        {
            int newWidth = progress+minWidth;
            int newHeight = (int)(newWidth*3/4);

            img.setLayoutParams(new LinearLayout.LayoutParams(newWidth,newHeight));
            v.setText("图像宽度："+newWidth+"Height:"+newHeight);
        }

        //处理图像旋转
        else if(seekBar.getId()==R.id.seekBar1)
        {
            String s = getIntent().getStringExtra("filename");
            BufferedInputStream bf;
            AssetManager assetManager = getAssets();
            Bitmap bitmap;
            try {
                bf = new BufferedInputStream(assetManager
                        .open("images/" + s));
                bitmap = BitmapFactory.decodeStream(bf);

                Matrix matrix =new Matrix();

                matrix.setRotate(progress);

                bitmap = Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),matrix,true);

                img.setImageBitmap(bitmap);
                v.setText(progress +"度");
            } catch (IOException e) {

                e.printStackTrace();
            }

        }
    }*/

    class DropDown implements ActionBar.OnNavigationListener {
        String[] listNames = getResources().getStringArray(R.array.operation);

        @Override
        public boolean onNavigationItemSelected(int itemPosition, long itemId) {

            //return true;
            MyFragment myFragment = new MyFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("key", itemPosition + 1);
            myFragment.setArguments(bundle);

//            OperationInfo operation = new OperationInfo();
//            FragmentManager manager = getFragmentManager();
//            FragmentTransaction transaction = manager.beginTransaction();
            //讲activity中的内容换位对应选择的fragment
            //transaction.replace(R.id.,myFragment);
//            transaction.commit();

//            for(String s :listNames) {
//                if(s.equals("旋转")){
//                    int id = getIntent().getIntExtra("id", -1);
//                    String ss = getIntent().getStringExtra("filename");
//
//                    Intent intent = new Intent(BigActivity.this, ChangeBigActivity.class);
//                    intent.putExtra("id", id);
//                    intent.putExtra("filename", ss);
//                    startActivity(intent);
//                    continue;
//                }
//            }

            return true;
        }

    }

    class MyFragment extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {


            Context context = this.getActivity();

            TextView tv = new TextView(context);

            Bundle arc = this.getArguments();

            int tabs = arc.getInt("key");

            tv.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
                    LayoutParams.WRAP_CONTENT));

            tv.setText("hello actionbar " + tabs);

            return tv;
        }
    }
}
