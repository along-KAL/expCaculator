package com.example.module.other;


import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.main.R;


@SuppressLint("NewApi")
public class Pingfen extends Fragment {
	
	public Pingfen(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_pingfen, container, false);
         
        return rootView;
    }
}
