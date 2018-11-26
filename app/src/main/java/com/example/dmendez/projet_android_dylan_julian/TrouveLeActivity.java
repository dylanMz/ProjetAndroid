package com.example.dmendez.projet_android_dylan_julian;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TrouveLeActivity extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        // Read xml file and return View object.

        // inflate(@LayoutRes int resource, @Nullable ViewGroup root, boolean attachToRoot)

        View view= inflater.inflate(R.layout.activity_trouve_le, container, false);
        return view;
    }
}
