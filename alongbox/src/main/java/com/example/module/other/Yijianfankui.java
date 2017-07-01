package com.example.module.other;


import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.main.R;


@SuppressLint("NewApi")
public class Yijianfankui extends Fragment {
	
	public Yijianfankui(){}
	
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_yijianfankui, container, false);
         
        return rootView;
    }
}
