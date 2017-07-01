package com.example.module.about;


import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import com.example.main.R;


@SuppressLint("NewApi")
public class Guanyu extends Fragment {
	private TextView t1 ;
	private TextView t2 ;
	private TextView t3 ;
	private TextView t4 ;
	private TextView t5 ;
	private TextView t6 ;
	private TextView t7 ;
	public Guanyu(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_guanyu, container, false);
        t1 = (TextView)rootView.findViewById(R.id.gytext);
        t2 = (TextView)rootView.findViewById(R.id.gytext1);
        t3 = (TextView)rootView.findViewById(R.id.gytext2);
        t4 = (TextView)rootView.findViewById(R.id.gytext3);
        t5 = (TextView)rootView.findViewById(R.id.gytext4);
        t6 = (TextView)rootView.findViewById(R.id.gytext5);
        t7= (TextView)rootView.findViewById(R.id.gytext6);
        
       /* AnimationSet set = new AnimationSet(false);
       
        Animation animation = new AlphaAnimation(0.1f,1.0f);   
        animation.setDuration(8000);
        set.addAnimation(animation);
        
        Animation  animation1 = new TranslateAnimation(0, 0, -45, 0);  
        animation1.setDuration(5500); 
        set.addAnimation(animation1);
        
        Animation  animation2 = new TranslateAnimation(0, 0, 25, 0);  
        animation1.setDuration(5500); 
        set.addAnimation(animation2);
        
        LayoutAnimationController controller = new LayoutAnimationController(set, 1);
        
        
        controller.getAnimationForView(t1);
        */
        Animation  animation11 = new TranslateAnimation(0, 0, -35, 0);  
        animation11.setDuration(600);
      
        t1.setAnimation(animation11);
        
       /* Animation animation = new AlphaAnimation(0.0F,1.0f);   //AlphaAnimation 控制渐变透明的动画效果
        animation.setDuration(800);
        animation.setStartOffset(200);
        Animation animation2 = new AlphaAnimation(0.0F,1.0f);   //AlphaAnimation 控制渐变透明的动画效果
        animation2.setDuration(800);
        animation2.setStartOffset(300);
        Animation animation3 = new AlphaAnimation(0.0F,1.0f);   //AlphaAnimation 控制渐变透明的动画效果
        animation3.setDuration(800);
        animation3.setStartOffset(400);
        Animation animation4 = new AlphaAnimation(0.0F,1.0f);   //AlphaAnimation 控制渐变透明的动画效果
        animation4.setDuration(800);
        animation4.setStartOffset(500);
        Animation animation5 = new AlphaAnimation(0.0F,1.0f);   //AlphaAnimation 控制渐变透明的动画效果
        animation5.setDuration(800);
        animation5.setStartOffset(600);
        Animation animation6 = new AlphaAnimation(0.0F,1.0f);   //AlphaAnimation 控制渐变透明的动画效果
        animation6.setDuration(800);
        animation6.setStartOffset(700);
        t2.setAnimation(animation);
        t3.setAnimation(animation2);
        t4.setAnimation(animation3);
        t5.setAnimation(animation4);
        t6.setAnimation(animation5);
        t7.setAnimation(animation6);*/
        Animation animation5 = new AlphaAnimation(0.0F,1.0f);
        Animation animation111 = new TranslateAnimation(0,0,100,0);   
        animation111.setDuration(500);
        animation111.setStartOffset(900);
        animation5.setDuration(800);
        animation5.setStartOffset(900);
        AnimationSet   Animation_Set1=new AnimationSet(true);
        Animation_Set1.addAnimation(animation5);
        Animation_Set1.addAnimation(animation111);
        
        Animation animation6 = new AlphaAnimation(0.0F,1.0f);
        Animation animation22 = new TranslateAnimation(0,0,80,0);   
        animation22.setDuration(500);
        animation22.setStartOffset(800);
        animation6.setDuration(800);
        animation6.setStartOffset(800);
        AnimationSet   Animation_Set2=new AnimationSet(true);
        Animation_Set2.addAnimation(animation6);
        Animation_Set2.addAnimation(animation22);
        
        Animation animation7 = new AlphaAnimation(0.0F,1.0f);
        Animation animation33 = new TranslateAnimation(0,0,60,0);   
        animation33.setDuration(500);
        animation33.setStartOffset(700);
        animation7.setDuration(800);
        animation7.setStartOffset(700);
        AnimationSet   Animation_Set3=new AnimationSet(true);
        Animation_Set3.addAnimation(animation7);
        Animation_Set3.addAnimation(animation33);
        
        Animation animation8 = new AlphaAnimation(0.0F,1.0f);
        Animation animation44 = new TranslateAnimation(0,0,40,0);   
        animation44.setDuration(500);
        animation44.setStartOffset(600);
        animation8.setDuration(800);
        animation8.setStartOffset(600);
        AnimationSet   Animation_Set4=new AnimationSet(true);
        Animation_Set4.addAnimation(animation8);
        Animation_Set4.addAnimation(animation44);
        
        Animation animation9 = new AlphaAnimation(0.0F,1.0f);
        Animation animation55 = new TranslateAnimation(0,0,20,0);   
        animation55.setDuration(500);
        animation55.setStartOffset(500);
        animation9.setDuration(800);
        animation9.setStartOffset(500);
        AnimationSet   Animation_Set5=new AnimationSet(true);
        Animation_Set5.addAnimation(animation9);
        Animation_Set5.addAnimation(animation55);
        
        
        Animation animation10 = new AlphaAnimation(0.0F,1.0f);
        Animation animation66 = new TranslateAnimation(0,0,10,0);   
        animation66.setDuration(500);
        animation66.setStartOffset(400);
        animation10.setDuration(800);
        animation10.setStartOffset(400);
        AnimationSet   Animation_Set6=new AnimationSet(true);
        Animation_Set6.addAnimation(animation10);
        Animation_Set6.addAnimation(animation66);
        
       /* Animation animation = new AlphaAnimation(0.0F,1.0f);
        Animation animation77 = new TranslateAnimation(0,0,10,0);   
        animation77.setDuration(500);
        animation77.setStartOffset(300);
        animation.setDuration(800);
        animation.setStartOffset(300);
        AnimationSet   Animation_Set7=new AnimationSet(true);
        Animation_Set7.addAnimation(animation);
        Animation_Set7.addAnimation(animation77);*/
        t7.setAnimation(Animation_Set1);
        t6.setAnimation(Animation_Set2);
        t5.setAnimation(Animation_Set3);
        t4.setAnimation(Animation_Set4);
        t3.setAnimation(Animation_Set5);
        t2.setAnimation(Animation_Set6);
      //  t1.setAnimation(Animation_Set7);
//        t2.startAnimation(animation2);
//        t3.startAnimation(animation2);
//        t4.startAnimation(animation2);
//        t5.startAnimation(animation2);
//        t6.startAnimation(animation2);
//        t7.startAnimation(animation2);
//        
//       
//        t2.startAnimation(animation);
//        t3.startAnimation(animation);
//        t4.startAnimation(animation);
//        t5.startAnimation(animation);
//        t6.startAnimation(animation);
//        t7.startAnimation(animation);
        return rootView;
    }
}
