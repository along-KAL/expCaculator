package com.example.slidingmenufragmenttest.fragment;

import java.util.ArrayList;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.ListFragment;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;


import com.example.calculatorjykal.R;
import com.example.slidingmenufragmenttest.adapter.NavDrawerListAdapter;
import com.example.slidingmenufragmenttest.entity.NavDrawerItem;


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
        // 计算器  
        mNavDrawerItems.add(new NavDrawerItem(mNavMenuTitles[0], mNavMenuIconsTypeArray  
                .getResourceId(0, -1)));  
        // 进制转换 
        mNavDrawerItems.add(new NavDrawerItem(mNavMenuTitles[1], mNavMenuIconsTypeArray  
                .getResourceId(1, -1)));  
        // 到几日  
        mNavDrawerItems.add(new NavDrawerItem(mNavMenuTitles[2], mNavMenuIconsTypeArray  
                .getResourceId(2, -1)));  
        // 计时器
        mNavDrawerItems.add(new NavDrawerItem(mNavMenuTitles[3], mNavMenuIconsTypeArray  
                .getResourceId(3, -1) ));  
        //分享
        mNavDrawerItems.add(new NavDrawerItem(mNavMenuTitles[4], mNavMenuIconsTypeArray  
                .getResourceId(4, -1)));  
        //评分  
        mNavDrawerItems.add(new NavDrawerItem(mNavMenuTitles[5], mNavMenuIconsTypeArray  
                .getResourceId(5, -1)));  
        // 反馈  
        mNavDrawerItems.add(new NavDrawerItem(mNavMenuTitles[6], mNavMenuIconsTypeArray  
                .getResourceId(6, -1)));  
        //关于
        mNavDrawerItems.add(new NavDrawerItem(mNavMenuTitles[7], mNavMenuIconsTypeArray  
                .getResourceId(7, -1)));  
        //juzhen
        mNavDrawerItems.add(new NavDrawerItem(mNavMenuTitles[8], mNavMenuIconsTypeArray  
                .getResourceId(8, -1))); 
        //tongji
        mNavDrawerItems.add(new NavDrawerItem(mNavMenuTitles[9], mNavMenuIconsTypeArray  
                .getResourceId(9, -1))); 
      //  jihe
        mNavDrawerItems.add(new NavDrawerItem(mNavMenuTitles[10], mNavMenuIconsTypeArray  
                .getResourceId(10, -1))); 
     
    
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
   Animation  animation = new TranslateAnimation(-20, 0, 0, 0);    //RotateAnimation  控制画平移度变化的动画效果  
      animation.setDuration(200);
      set.addAnimation(animation);
      LayoutAnimationController controller = new LayoutAnimationController(set, 0);
       mDrawerList.setLayoutAnimation(controller);
       
      // Animation  animation1 = new TranslateAnimation(0, 0, -25, 0);    //RotateAnimation  控制画平移度变化的动画效果  
       //animation1.setDuration(550); 
      
       //im.setAnimation(animation1);
        //System.out.println(mAdapter);
    	/*ScaleInAnimationAdapter scaleInAnimationAdapter = new ScaleInAnimationAdapter(mAdapter, 60f);
		scaleInAnimationAdapter.setListView(mDrawerList);

		mDrawerList.setAdapter(scaleInAnimationAdapter);*/
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
		
		// update selected item and title, then close the drawer  
        mDrawerList.setItemChecked(position, true);  
        mDrawerList.setSelection(position);  
        
        if(mCallback!=null){
        	mCallback.selectItem(position, mNavMenuTitles[position]);
        }
        selected = position;
	}

	/**
     * 宸︿晶鑿滃崟 鐐瑰嚮鍥炶皟鎺ュ彛
     * @author FX_SKY
     *
     */
    public interface SLMenuListOnItemClickListener{
    	
    	public void selectItem(int position,String title);
    }
}
/*<LinearLayout
android:layout_width="match_parent"
android:layout_height="wrap_content" 

android:layout_gravity="bottom">
<Button
android:id="@+id/button11"
android:layout_weight="1"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:layout_marginLeft="2dp"
android:layout_marginRight="5dp"
android:background="@drawable/anniu3"
 />
<Button
android:id="@+id/button22"
android:layout_weight="1"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
 android:layout_marginRight="5dp"
android:background="@drawable/anniu3"
/>
<Button
android:id="@+id/button33"
android:layout_weight="1"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:layout_marginRight="5dp"
android:background="@drawable/anniu3"
/>
<Button
android:id="@+id/button44"
android:layout_weight="1"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:layout_marginLeft="5dp"
android:layout_marginRight="2dp"
android:background="@drawable/anniu3"
 />
</LinearLayout>*/