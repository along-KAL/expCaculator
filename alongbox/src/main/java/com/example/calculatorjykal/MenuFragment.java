package com.example.calculatorjykal;

import java.util.ArrayList;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;


import com.example.adapter.NavDrawerListAdapter;
import com.example.entity.NavDrawerItem;


@SuppressLint("NewApi")
public class MenuFragment extends Fragment implements OnItemClickListener {
	private ImageView im;
	private ListView mDrawerList;
	private String[] mNavMenuTitles;
	private TypedArray mNavMenuIconsTypeArray;
	private ArrayList<NavDrawerItem> mNavDrawerItems;
	private NavDrawerListAdapter mAdapter;
	private SLMenuListOnItemClickListener mCallback;
	private int selected = -1;

	@Override
	public void onAttach(Activity activity) {
		try {
			mCallback = (SLMenuListOnItemClickListener) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " must implement OnResolveTelsCompletedListener");
		}
		super.onAttach(activity);
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View rootView = inflater.inflate(R.layout.fragment_menu,null);
	 // im = (ImageView)rootView.findViewById(R.id.im);
		findView(rootView);
		
		return rootView;
	}

	private void findView(View rootView) {
		
		mDrawerList = (ListView) rootView.findViewById(R.id.left_menu);  
		
		//System.out.println(mDrawerList);
		mNavMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);  
        // nav drawer icons from resources  
        mNavMenuIconsTypeArray = getResources()  
                    .obtainTypedArray(R.array.nav_drawer_icons);  
              
        mNavDrawerItems = new ArrayList<NavDrawerItem>();  
  
        // adding nav drawer items to array  
        // ??????
        mNavDrawerItems.add(new NavDrawerItem(mNavMenuTitles[0], mNavMenuIconsTypeArray  
                .getResourceId(0, -1)));  
        // ???????
        mNavDrawerItems.add(new NavDrawerItem(mNavMenuTitles[1], mNavMenuIconsTypeArray  
                .getResourceId(1, -1)));  
        // ??????
        mNavDrawerItems.add(new NavDrawerItem(mNavMenuTitles[2], mNavMenuIconsTypeArray  
                .getResourceId(2, -1)));  
        // ?????
        mNavDrawerItems.add(new NavDrawerItem(mNavMenuTitles[3], mNavMenuIconsTypeArray  
                .getResourceId(3, -1) ));  
        //????
        mNavDrawerItems.add(new NavDrawerItem(mNavMenuTitles[4], mNavMenuIconsTypeArray  
                .getResourceId(4, -1)));  

        mNavDrawerItems.add(new NavDrawerItem(mNavMenuTitles[5], mNavMenuIconsTypeArray  
                .getResourceId(5, -1)));  

        mNavDrawerItems.add(new NavDrawerItem(mNavMenuTitles[6], mNavMenuIconsTypeArray  
                .getResourceId(6, -1)));  

        mNavDrawerItems.add(new NavDrawerItem(mNavMenuTitles[7], mNavMenuIconsTypeArray  
                .getResourceId(7, -1)));  

        mNavDrawerItems.add(new NavDrawerItem(mNavMenuTitles[8], mNavMenuIconsTypeArray  
                .getResourceId(8, -1)));

        mNavDrawerItems.add(new NavDrawerItem(mNavMenuTitles[9], mNavMenuIconsTypeArray  
                .getResourceId(9, -1)));


    
        // Recycle the typed array  
        mNavMenuIconsTypeArray.recycle();
         // System.out.println(mNavDrawerItems);
        // setting the nav drawer list adapter  
       mAdapter = new NavDrawerListAdapter(getActivity(),mNavDrawerItems); 
  AnimationSet set = new AnimationSet(false);
      /*   Animation animation = new AlphaAnimation(0.1f,1.0f);
       animation.setDuration(800);
       set.addAnimation(animation);
       */
   Animation  animation = new TranslateAnimation(-20, 0, 0, 0);    //RotateAnimation  ???????????????Ч??  
      animation.setDuration(200);
      set.addAnimation(animation);
      LayoutAnimationController controller = new LayoutAnimationController(set, 0);
       mDrawerList.setLayoutAnimation(controller);

        mDrawerList.setAdapter(mAdapter);  
        mDrawerList.setOnItemClickListener(this);  
        
        if(selected!=-1){
        	mDrawerList.setItemChecked(selected, true);  
            mDrawerList.setSelection(selected);  
        }else{
        	mDrawerList.setItemChecked(0, true);  
            mDrawerList.setSelection(0);  
        }
      
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		
        mDrawerList.setItemChecked(position, true);
        mDrawerList.setSelection(position);  
        
        if(mCallback!=null){
        	mCallback.selectItem(position, mNavMenuTitles[position]);
        }
        selected = position;
	}

	/**
     * 左侧菜单 点击回调接口
     * @author FX_SKY
     *
     */
    public interface SLMenuListOnItemClickListener{
    	
    	public void selectItem(int position,String title);
    }
}
