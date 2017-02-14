package com.example.slidingmenufragmenttest.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.calculatorjykal.R;

@SuppressLint("NewApi")
public class Caidananima extends Fragment {
	
	public Caidananima(){}
	
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		/*LinearLayout l = new LinearLayout(getActivity());
		ImageView ii = new ImageView(getActivity());*/
        View rootView = inflater.inflate(R.layout.caidananima, container, false);
         
        return rootView;
    }
}
