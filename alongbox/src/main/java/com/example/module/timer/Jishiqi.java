package com.example.module.timer;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;

import com.example.module.timer.jishiqi.FragmentActivityListener;
import com.example.main.R;
import com.example.module.timer.selecttimee.ScreenInfo;

import java.util.ArrayList;

@SuppressLint("NewApi")
public class Jishiqi extends Fragment{
	
	private ViewPager viewPager;
	private ArrayList<View> pageViews;
	Button onetime, moretime;
	ImageView youbiao;
	Animation am;
	public static SeekBar seekBar = null;
	int w;
	float prearg1 = 0;

	@SuppressLint("NewApi")
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.index, container, false);
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
		//setContentView(R.layout.index);
		
		viewPager = (ViewPager) rootView.findViewById(R.id.pager);
		youbiao = (ImageView) rootView.findViewById(R.id.youbiao);
		onetime = (Button)rootView. findViewById(R.id.onetime);
		moretime = (Button)rootView. findViewById(R.id.moretime);
		Button btns[] = { onetime, moretime };
		seekBar = new SeekBar(this.getActivity());
		seekBar.setMax(5);
		InItView();
		viewPager.setAdapter(new myPagerView());

		ScreenInfo s = new ScreenInfo(this.getActivity());
		w = s.getWidth() / 2;
		LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) youbiao
				.getLayoutParams();
		lp.width = w;
		youbiao.setLayoutParams(lp);

		viewPager.setOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageSelected(int arg0) {
				selsct(arg0);
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				if (arg1 != 0) {
					float all = w * arg1;
					am = new TranslateAnimation(prearg1, all, 0, 0);
					am.setFillAfter(true);
					am.setDuration(200);
					youbiao.startAnimation(am);
					prearg1 = all;
				}
			}
			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
		});
		selsct(0);
		for (int i = 0; i < 2; i++) {
			final int a = i;
			btns[a].setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					viewPager.setCurrentItem(a);
					selsct(a);
				}
			});
		}
		 return rootView;
	}

		
	

 
		 
    
	private void selsct(int arg0) {
		Button btns[] = { onetime, moretime };
		for (int i = 0; i < 2; i++) {
			final int a = i;
			if (a == arg0) {
				// btns[a].setBackgroundResource(R.drawable.selectbtn);
			} else {
				// btns[a].setBackgroundResource(R.drawable.startbutton);
			}
		}
	}

	void InItView() {
		if(getActivity() instanceof FragmentActivityListener){
			 
			pageViews  =  ((FragmentActivityListener)getActivity()).getViewPage();
		 
		    }
	}

	class myPagerView extends PagerAdapter {
		// ��ʾ��Ŀ
		@Override
		public int getCount() {
			return pageViews.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public int getItemPosition(Object object) {
			return super.getItemPosition(object);
		}

		@Override
		public void destroyItem(View arg0, int arg1, Object arg2) {
			((ViewPager) arg0).removeView(pageViews.get(arg1));
		}

		@Override
		public Object instantiateItem(View arg0, int arg1) {
			((ViewPager) arg0).addView(pageViews.get(arg1));
			return pageViews.get(arg1);
		}
	}
	
/*	public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
        	
        	
        	
        	
        	
        	
        	if(SaveRun.getisdaojishi() || SaveRun.getisjishi()){
            new AlertDialog.Builder(this)
                    .setTitle("��ʾ")
                    .setMessage("���ڼ�ʱ�У�ȷ��Ҫ�˳���")
                    .setNegativeButton("ȡ��",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog,
                                        int which) {
                                	dialog.cancel();
                                }
                            })
                    .setPositiveButton("ȷ��",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                        int whichButton) {
                                    finish();
                                }
                            }).setNeutralButton("��̨",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                        int whichButton) {
                                	Intent i= new Intent(Intent.ACTION_MAIN);
                                	i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); 
                                	i.addCategory(Intent.CATEGORY_HOME);
                                	startActivity(i);
                                }
                            }).create().show();
        	}else{
        		finish();
        	}
            return true;
            
        }else {
            return super.onKeyDown(keyCode, event);
        }
    }*/
}