/*
package com.ROCKY_IMAGEBrowser;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.HashMap;

*/
/**
 * Created with IntelliJ IDEA.
 * User: Luoqi
 * Date: 14-1-1
 * Time: 下午9:56
 * To change this template use File | Settings | File Templates.
 *//*


public class ImageAdapter extends BaseAdapter{

    private HashMap<Integer, Bitmap> imgCache = new HashMap<Integer, Bitmap>();
    private Context mContext;
    private int mGalleryBackground;
    private ArrayList<String> mArrayList;
    //item的数量
    private int mCount;

    public ImageAdapter(Context c, ArrayList<String> list){
        mContext = c;
        mArrayList = list;
    }

    public int getCount() {
        // TODO Auto-generated method stub
        return mArrayList.size();
        //return Integer.MAX_VALUE;
    }

    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        //获得一个新的imageview
        ImageView imgView = new ImageView(mContext);
        Bitmap current = imgCache.getInstance();
        if(current == null){
            current = BitmapFactory.decodeFile(mArrayList.get(position));

            imgCache.put(position, current);
        }

        imgView.setImageBitmap(current);
        imgView.setScaleType(ImageView.ScaleType.FIT_XY);
        imgView.setLayoutParams(new Gallery.LayoutParams(140, 90));
        imgView.setBackgroundResource(mGalleryBackground);

        //deleteHappen = false;
        return imgView;
    }

}*/
