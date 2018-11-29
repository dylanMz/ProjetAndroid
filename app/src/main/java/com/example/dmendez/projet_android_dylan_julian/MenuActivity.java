package com.example.dmendez.projet_android_dylan_julian;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class MenuActivity extends Fragment implements View.OnClickListener{

    private MainActivity mainactivity;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {



        // Read xml file and return View object.
        // inflate(@LayoutRes int resource, @Nullable ViewGroup root, boolean attachToRoot)
        View view= inflater.inflate(R.layout.activity_menu, container, false);
        return view;



    }

    // Called when a fragment is first attached to its context.
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof MainActivity) {
            this.mainactivity = (MainActivity) context;
        }

    }

    @Override
    public void onClick(View view) {


    }
}
