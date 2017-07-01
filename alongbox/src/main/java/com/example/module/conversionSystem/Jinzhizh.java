package com.example.module.conversionSystem;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.main.R;

import java.lang.reflect.Method;
import java.math.BigInteger;


@SuppressLint("NewApi")
public class Jinzhizh extends Fragment implements OnClickListener{
	private EditText edittext2;
	private EditText edittext8;
	private EditText edittext10;
	private EditText edittext16;
	private TextView t1;
	private TextView t2;
	private TextView t3;
	private TextView t4;
	public Jinzhizh(){}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		setHasOptionsMenu(true);
		
		super.onCreate(savedInstanceState);
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_jinzhi, container, false);
        TableRow TableRow1  = (TableRow)rootView.findViewById(R.id.TableRow11);
        TableRow TableRow2  = (TableRow)rootView.findViewById(R.id.TableRow22);
        TableRow TableRow3  = (TableRow)rootView.findViewById(R.id.TableRow33);
        TableRow TableRow4  = (TableRow)rootView.findViewById(R.id.TableRow44);
        t1  = (TextView)rootView.findViewById(R.id.textview2);
        t2  = (TextView)rootView.findViewById(R.id.textview8);
        t3  = (TextView)rootView.findViewById(R.id.textview10);
        t4  = (TextView)rootView.findViewById(R.id.textview16);
        edittext2 = (EditText)rootView.findViewById(R.id.edittext2);
        edittext8 = (EditText)rootView.findViewById(R.id.edittext8);
        edittext10 = (EditText)rootView.findViewById(R.id.edittext10);
        edittext16 = (EditText)rootView.findViewById(R.id.edittext16);
        Button threeo = (Button)rootView.findViewById(R.id.threeo);
        Button twoo = (Button)rootView.findViewById(R.id.twoo);
        Button oneo = (Button)rootView.findViewById(R.id.oneo);
        Button yi = (Button)rootView.findViewById(R.id.yi);
        Button tuige = (Button)rootView.findViewById(R.id.tuige);
        Button fuhao = (Button)rootView.findViewById(R.id.fuhao);
        Button er = (Button)rootView.findViewById(R.id.er);
        Button san = (Button)rootView.findViewById(R.id.san);
        Button si = (Button)rootView.findViewById(R.id.si);
        Button wu = (Button)rootView.findViewById(R.id.wu);
        Button liu = (Button)rootView.findViewById(R.id.liu);
        Button qi = (Button)rootView.findViewById(R.id.qi);
        Button ba = (Button)rootView.findViewById(R.id.ba);
        Button jiu = (Button)rootView.findViewById(R.id.jiu);
        Button a = (Button)rootView.findViewById(R.id.a);
        Button b = (Button)rootView.findViewById(R.id.b);
        Button c = (Button)rootView.findViewById(R.id.c);
        Button d = (Button)rootView.findViewById(R.id.d);
        Button e = (Button)rootView.findViewById(R.id.e);
        Button f = (Button)rootView.findViewById(R.id.f);
        threeo.setOnClickListener(this);
        twoo.setOnClickListener(this);
        oneo.setOnClickListener(this);
        yi.setOnClickListener(this);
        tuige.setOnClickListener(this);
        fuhao.setOnClickListener(this);
        er.setOnClickListener(this);
        san.setOnClickListener(this);
        si.setOnClickListener(this);
        wu.setOnClickListener(this);
        liu.setOnClickListener(this);
        qi.setOnClickListener(this);
        ba.setOnClickListener(this);
        jiu.setOnClickListener(this);
        a.setOnClickListener(this);
        b.setOnClickListener(this);
        c.setOnClickListener(this);
        d.setOnClickListener(this);
        e.setOnClickListener(this);
        f.setOnClickListener(this);
        chujiaodian(edittext2);
        chujiaodian(edittext8);
        chujiaodian(edittext10);
        chujiaodian(edittext16);
        
      //获取保存数据 
        SharedPreferences sp = getActivity().getSharedPreferences("Edittext",  
                getActivity().MODE_PRIVATE);  
        // music_progress为XML文件的文件名  
        edittext2.setText(sp.getString("edittext2", null));
        edittext8.setText(sp.getString("edittext8", null));
        edittext10.setText(sp.getString("edittext10", null));
        edittext16.setText(sp.getString("edittext16", null));
        Animation  animation1 = new TranslateAnimation(-30, 0, 0 , 0);
        animation1.setDuration(800);
      //  animation1.setStartOffset(500);
      /*  t1.setAnimation(animation1);
        Animation  animation2 = new TranslateAnimation(-30, 0, 0 , 0);
        animation2.setDuration(800);
        animation2.setStartOffset(100);
        t2.setAnimation(animation2);
        Animation  animation3 = new TranslateAnimation(-30, 0, 0 , 0);
        animation3.setDuration(800);
        animation3.setStartOffset(400);
        t3.setAnimation(animation3);
        Animation  animation4 = new TranslateAnimation(-30, 0, 0 , 0);
        animation4.setDuration(800);
        animation4.setStartOffset(600);
        t4.setAnimation(animation4);*/
       // Animation  animation1 = new TranslateAnimation(-30, 0, 0 , 0);    //RotateAnimation  控制画平移度变化的动画效果  
       // animation1.setDuration(800); 
     //   Animation  animation2 = new TranslateAnimation(30, 0, 0 , 0);    //RotateAnimation  控制画平移度变化的动画效果  
      //  animation2.setDuration(800);
        Animation animation = new AlphaAnimation(0.0F,1.0f);   //AlphaAnimation 控制渐变透明的动画效果
        animation.setDuration(800);
       // animation.setStartOffset(500);
        Animation animation2 = new AlphaAnimation(0.0F,1.0f);   //AlphaAnimation 控制渐变透明的动画效果
        animation2.setDuration(800);
        animation2.setStartOffset(100);
        Animation animation3 = new AlphaAnimation(0.0F,1.0f);   //AlphaAnimation 控制渐变透明的动画效果
        animation3.setDuration(800);
        animation3.setStartOffset(300);
        Animation animation4 = new AlphaAnimation(0.0F,1.0f);   //AlphaAnimation 控制渐变透明的动画效果
        animation4.setDuration(800);
        animation4.setStartOffset(500);
        
        Animation animation5 = new AlphaAnimation(0.0F,1.0f);
        Animation animation11 = new TranslateAnimation(-40,0,0,0);   
        animation11.setDuration(500);
        animation11.setStartOffset(900);
        animation5.setDuration(800);
        animation5.setStartOffset(900);
        AnimationSet   Animation_Set1=new AnimationSet(true);
        Animation_Set1.addAnimation(animation5);
        Animation_Set1.addAnimation(animation11);
        
        Animation animation6 = new AlphaAnimation(0.0F,1.0f);
        Animation animation22 = new TranslateAnimation(-40,0,0,0);   
        animation22.setDuration(500);
        animation22.setStartOffset(800);
        animation6.setDuration(800);
        animation6.setStartOffset(800);
        AnimationSet   Animation_Set2=new AnimationSet(true);
        Animation_Set2.addAnimation(animation6);
        Animation_Set2.addAnimation(animation22);
        
        Animation animation7 = new AlphaAnimation(0.0F,1.0f);
        Animation animation33 = new TranslateAnimation(-40,0,0,0);   
        animation33.setDuration(500);
        animation33.setStartOffset(700);
        animation7.setDuration(800);
        animation7.setStartOffset(700);
        AnimationSet   Animation_Set3=new AnimationSet(true);
        Animation_Set3.addAnimation(animation7);
        Animation_Set3.addAnimation(animation33);
        
        Animation animation8 = new AlphaAnimation(0.0F,1.0f);
        Animation animation44 = new TranslateAnimation(-40,0,0,0);   
        animation44.setDuration(500);
        animation44.setStartOffset(600);
        animation8.setDuration(800);
        animation8.setStartOffset(600);
        AnimationSet   Animation_Set4=new AnimationSet(true);
        Animation_Set4.addAnimation(animation8);
        Animation_Set4.addAnimation(animation44);
        
        TableRow1.setAnimation(animation);
        TableRow2.setAnimation(animation2);
       TableRow3.setAnimation(animation3);
        TableRow4.setAnimation(animation4);
        t1.setAnimation(Animation_Set1);
        t2.setAnimation(Animation_Set2);
        t3.setAnimation(Animation_Set3);
        t4.setAnimation(Animation_Set4);
        
      
       // animation1.setStartOffset(600);
        
        //animation1.setStartOffset(800);
       
      /*   Animation Animation_Alpha=new AlphaAnimation(0.0f, 1.0f);
         Animation  Animation_Scale =new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f,   
        		    Animation.RELATIVE_TO_PARENT, 0.1f, Animation.ABSOLUTE, 0.1f);
        
       //nimation Animation_Translate=new TranslateAnimation(30.0f, -80.0f, 30.0f, 300.0f);
       //nimation Animation_Rotate=new RotateAnimation(0.0f, +350.0f,
       //              Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF, 0.5f); 
        AnimationSet Animation_Set=new AnimationSet(true);
        
        Animation_Alpha.setDuration(1000);
        Animation_Scale.setDuration(400);
      //Animation_Translate.setDuration(1000); 
       //nimation_Rotate.setDuration(1000); 

        Animation_Set.addAnimation(Animation_Scale);
        //Animation_Set.addAnimation(Animation_Scale1);
    // Animation_Set.addAnimation(Animation_Rotate);
       Animation_Set.addAnimation(Animation_Alpha);
     //Animation_Set.addAnimation(Animation_Translate);
       TableRow1.setAnimation(Animation_Set);*/
       
       
       
       
        return rootView;
    }
	
	 public void onDestroy() {
			super.onDestroy();
			SharedPreferences sp = getActivity().getSharedPreferences("Edittext",  
	        getActivity().MODE_PRIVATE); 
			Editor editor = sp.edit();
			//星期
			editor.putString("edittext2", edittext2.getText().toString());
			editor.putString("edittext8", edittext8.getText().toString());
			editor.putString("edittext10", edittext10.getText().toString());
			editor.putString("edittext16", edittext16.getText().toString());
			editor.commit();
			}
	@Override
	public void onClick(View arg0) {
		
		Button btn = (Button)arg0;	
		
		
		 Animation Animation_Alpha=new AlphaAnimation(1.0f, 0.1f);
	      Animation_Alpha.setDuration(400);
	      btn.startAnimation(Animation_Alpha);
	      
		String s2 = btn.getText().toString();
		try{
		if(edittext2.hasFocus()){
			int index = edittext2.getSelectionStart();
			
			if(s2.equals("0")||s2.equals("1")||s2.equals("-")||s2.equals("000")||s2.equals("00"))
			{
				
		index = index+1;
		
		if(s2.equals("000"))
			index=index+2;
		if(s2.equals("00"))
			index=index+1;
		
			edittext2.setText(edittext2.getText().toString()+s2);
			if(edittext2.getText().toString().equals("-")){}else{
			BigInteger bi2 = new BigInteger(edittext2.getText().toString(),2);
			
			edittext8.setText(bi2.toString(8));
			 edittext10.setText(bi2.toString(10));
			 edittext16.setText(bi2.toString(16));
			}
			 
				}else
			if(btn.getText().equals("清除")){
				if(index==0){
					index=1;
				}else{
				edittext2.getText().delete(index-1, index);
				}
				index = index -1;
				if(index>0){
					if(edittext2.getText().toString().equals("-")){}else{
				BigInteger bi2 = new BigInteger(edittext2.getText().toString(),2);
				edittext8.setText(bi2.toString(8));
				 edittext10.setText(bi2.toString(10));
				 edittext16.setText(bi2.toString(16));}}else
				 {
					 edittext8.setText("");
					 edittext10.setText("");
					 edittext16.setText("");
				 }
			}else{
				//Toast.makeText(getActivity(), "二进制o(?s□?t)o你懂的！", Toast.LENGTH_SHORT).show();
				showToast("二进制o(?s□?t)o你懂的！");
	}
			edittext2.setSelection(index);
		}
		
if(edittext8.hasFocus()){
	int index = edittext8.getSelectionStart();
	if(s2.equals("0")||s2.equals("1")||s2.equals("-")||s2.equals("000")||s2.equals("00")||s2.equals("2")||s2.equals("3")||s2.equals("4")||s2.equals("5")||s2.equals("6")||s2.equals("7"))
	{
		index = index+1;
		
		if(s2.equals("000"))
			index=index+2;
		if(s2.equals("00"))
			index=index+1;
			edittext8.setText(edittext8.getText().toString()+s2);
			if(edittext8.getText().toString().equals("-")){}else{
			BigInteger bi2 = new BigInteger(edittext8.getText().toString(),8);
			edittext2.setText(bi2.toString(2));
			 edittext10.setText(bi2.toString(10));
			 edittext16.setText(bi2.toString(16));
			}
		}else
	if(btn.getText().equals("清除")){
		if(index==0){
			index=1;
		}else{
		edittext8.getText().delete(index-1, index);
		}
		index = index -1;
		if(index>0){
			if(edittext8.getText().toString().equals("-")){}else{
		BigInteger bi2 = new BigInteger(edittext8.getText().toString(),8);
		edittext2.setText(bi2.toString(2));
		 edittext10.setText(bi2.toString(10));
		 edittext16.setText(bi2.toString(16));}}else
		 {
			 edittext2.setText("");
			 edittext10.setText("");
			 edittext16.setText("");
		 }
	}else{
		showToast("八进制o(?s□?t)o你懂的！");
	}
	edittext8.setSelection(index);
	}
if(edittext10.hasFocus()){
	int index = edittext10.getSelectionStart();
	if(s2.equals("0")||s2.equals("1")||s2.equals("-")||s2.equals("000")||s2.equals("00")||s2.equals("2")||s2.equals("3")||s2.equals("4")||s2.equals("5")||s2.equals("6")||s2.equals("7")||s2.equals("8")||s2.equals("9"))
	{
		index = index+1;
		
		if(s2.equals("000"))
			index=index+2;
		if(s2.equals("00"))
			index=index+1;
	edittext10.setText(edittext10.getText().toString()+s2);
	if(edittext10.getText().toString().equals("-")){}else{
	BigInteger bi2 = new BigInteger(edittext10.getText().toString(),10);
	edittext8.setText(bi2.toString(8));
	 edittext2.setText(bi2.toString(2));
	 edittext16.setText(bi2.toString(16));}
}else
	if(btn.getText().equals("清除")){
		if(index==0){
			index=1;
		}else{
		edittext10.getText().delete(index-1, index);
		}
		index = index -1;
		if(index>0){
			if(edittext10.getText().toString().equals("-")){}else{
		BigInteger bi2 = new BigInteger(edittext10.getText().toString(),10);
		edittext8.setText(bi2.toString(8));
		 edittext2.setText(bi2.toString(2));
		 edittext16.setText(bi2.toString(16));}}else
		 {edittext8.setText("");
		 edittext2.setText("");
		 edittext16.setText("");}
	}else{
		showToast("十进制o(?s□?t)o你懂的！");
		}
	edittext10.setSelection(index);
}
if(edittext16.hasFocus()){
	int index = edittext16.getSelectionStart();
	if(s2.equals("0")||s2.equals("1")||s2.equals("-")||s2.equals("000")||s2.equals("00")||s2.equals("2")||s2.equals("3")||s2.equals("4")||s2.equals("5")||s2.equals("6")||s2.equals("7")||s2.equals("8")||s2.equals("9")||s2.equals("a")||s2.equals("b")||s2.equals("c")||s2.equals("d")||s2.equals("e")||s2.equals("f"))
	{
index = index+1;
		
		if(s2.equals("000"))
			index=index+2;
		if(s2.equals("00"))
			index=index+1;
	edittext16.setText(edittext16.getText().toString()+s2);
	if(edittext16.getText().toString().equals("-")){}else{
	BigInteger bi2 = new BigInteger(edittext16.getText().toString(),16);
	edittext8.setText(bi2.toString(8));
	 edittext10.setText(bi2.toString(10));
	 edittext2.setText(bi2.toString(2));}
}else
	if(btn.getText().equals("清除")){
		if(index==0){
			index=1;
		}else{
		edittext16.getText().delete(index-1, index);
		}
		index = index -1;
		if(index>0){
			if(edittext16.getText().toString().equals("-")){}else{
		BigInteger bi2 = new BigInteger(edittext16.getText().toString(),16);
		edittext8.setText(bi2.toString(8));
		 edittext10.setText(bi2.toString(10));
		 edittext2.setText(bi2.toString(2));
			}}else
		 {edittext8.setText("");
		 edittext10.setText("");
		 edittext2.setText("");}
		}else{
		showToast("十六进制o(?s□?t)o你懂的！");
	}
	edittext16.setSelection(index);
	}}catch(Exception e){
		showToast("o(?s□?t)o出错喽！");
	}
	}
	
	
//除去焦点	
	public void chujiaodian(EditText et){
		et.setImeOptions(EditorInfo.IME_FLAG_NO_EXTRACT_UI);  

	      if (android.os.Build.VERSION.SDK_INT <= 10) {
	  		
	          et.setInputType(InputType.TYPE_NULL);
	  } else {
	  	getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
	          try {
	                  Class<EditText> cls = EditText.class;
	                  Method setSoftInputShownOnFocus;
	                  setSoftInputShownOnFocus = cls.getMethod("setSoftInputShownOnFocus", boolean.class);
	                  setSoftInputShownOnFocus.setAccessible(true);
	                  setSoftInputShownOnFocus.invoke(et, false);
	          } catch (Exception e) {
	                  e.printStackTrace();
	          }
	          try {
	                  Class<EditText> cls = EditText.class;
	                  Method setShowSoftInputOnFocus;
	                  setShowSoftInputOnFocus = cls.getMethod("setShowSoftInputOnFocus", boolean.class);
	                  setShowSoftInputOnFocus.setAccessible(true);
	                  setShowSoftInputOnFocus.invoke(et, false);
	          } catch (Exception e) {
	                  e.printStackTrace();
	          }
	  }
		
		
	}
//解决toast问题	
	private Toast mToast;
    public void showToast(String text) {  
        if(mToast == null) {  
            mToast = Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT);  
        } else {  
            mToast.setText(text);    
            mToast.setDuration(Toast.LENGTH_SHORT);  
        }  
        mToast.show();  
    }  
      
    public void cancelToast() {  
            if (mToast != null) {  
                mToast.cancel();  
            }  
        }  
      
    public void onBackPressed() {  

            cancelToast();  
            super.getActivity().onBackPressed();  
        }
    
    //退格长按处理
//	@Override
//	public boolean onLongClick(View arg0) {
//		
//		if(edittext2.hasFocus()){
//			int index = edittext2.getSelectionStart();
//			
//				int a=0;
//				a=a+1;
//				if(a==1000)
//					
//				if(index==0){
//					index=1;
//				}else{
//				edittext2.getText().delete(index-1, index);
//				}
//				index = index -1;
//				if(index>0){
//					if(edittext2.getText().toString().equals("-")){}else{
//				BigInteger bi2 = new BigInteger(edittext2.getText().toString(),2);
//				edittext8.setText(bi2.toString(8));
//				 edittext10.setText(bi2.toString(10));
//				 edittext16.setText(bi2.toString(16));}}else
//				 {
//					 edittext8.setText("");
//					 edittext10.setText("");
//					 edittext16.setText("");
//				 }
//			}
//		
//		return false;
//	}
    
    
}
