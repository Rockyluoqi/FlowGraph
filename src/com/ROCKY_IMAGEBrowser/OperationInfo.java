package com.ROCKY_IMAGEBrowser;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class OperationInfo extends Fragment {

    private String tag;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        tag = getTag();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setText(tag);
        return textView;
    }
}
