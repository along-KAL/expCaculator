package com.example.slidingmenufragmenttest.fragment;


import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

import changshu.Changshu;

import com.example.calculatorjykal.R;



import com.example.calculatorjykal.CalculatorActivity;
import com.example.calculatorjykal.Caogao;
import com.example.calculatorjykal.Cigen;
import com.example.slidingmenufragmenttest.fragment.Daojishi;
import com.example.slidingmenufragmenttest.fragment.Guanyu;
import com.example.slidingmenufragmenttest.fragment.Jisuanqi;
import com.example.slidingmenufragmenttest.fragment.MenuFragment;
import com.example.slidingmenufragmenttest.fragment.Pingfen;
import com.example.slidingmenufragmenttest.fragment.Jinzhizh;
import com.example.slidingmenufragmenttest.fragment.Yijianfankui;

import datapd.DatePickerView;
import net.simonvt.menudrawer.MenuDrawer;
import net.simonvt.menudrawer.Position;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.InputType;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

@SuppressLint("NewApi")
public class Jisuanqi extends Fragment implements OnClickListener{
	LinearLayout ll;
	Button btnDel;
	Button btnPlu ;
	Button btnMin ;
	Button btnMul ;
	Button btnDiv ;
	Button btnEqu;
	Button btnTono ;
	Button btnLeft ;
	Button btnRight;
	Button houtui ;
	Button qianjin ;
	Button guangbiaotui ;
	Button guangbiaoqian;
	Button sin ;
	Button cos ;
	Button tan ;
	Button asin ;
	Button acos;
	Button atan ;
	Button lg ;
	Button ln;
	Button cifang ;
	Button genhao ;
	Button Pi ;
	Button E ;
	Button baifengao ;
	Button shuangguohao;
	Button huiche ;
	Button changshu ;
	//num 数字按钮
	Button num0 ;
	Button num1;
	Button num2 ;
	Button num3 ;
	Button num4 ;
	Button num5 ;
	Button num6 ;
	Button num7 ;
	Button num8 ;
	Button num9 ;
	Button dot ;
	
	 /*AnimationSet  Anima_Set1;
	 AnimationSet  Anima_Set2;
	 AnimationSet  Anima_Set3;
	 AnimationSet  Anima_Set4;
	 AnimationSet  Anima_Set5;
	 AnimationSet  Anima_Set6;
	 AnimationSet  Anima_Set7;
	 AnimationSet  Anima_Set8;
	 AnimationSet  Anima_Set9;
	 AnimationSet  Anima_Set10;
	 AnimationSet  Anima_Set11;
	 AnimationSet  Anima_Set12;
	 AnimationSet  Anima_Set13;
	 AnimationSet  Anima_Set14;
	 AnimationSet  Anima_Set15;
	 AnimationSet  Anima_Set16;
	 AnimationSet  Anima_Set17;
	 AnimationSet  Anima_Set18;
	 AnimationSet  Anima_Set19;
	 AnimationSet  Anima_Set20;
	 AnimationSet  Anima_Set21;
	 AnimationSet  Anima_Set22;
	 AnimationSet  Anima_Set23;
	 AnimationSet  Anima_Set24;
	 AnimationSet  Anima_Set25;
	 AnimationSet  Anima_Set26;
	 AnimationSet  Anima_Set27;
	 AnimationSet  Anima_Set28;
	 AnimationSet  Anima_Set29;
	 AnimationSet  Anima_Set30;
	 AnimationSet  Anima_Set31;
	 AnimationSet  Anima_Set32;
	 AnimationSet  Anima_Set33;
	 AnimationSet  Anima_Set34;
	 AnimationSet  Anima_Set35;
	 AnimationSet  Anima_Set36;
	 AnimationSet  Anima_Set37;
	 AnimationSet  Anima_Set38;
	 AnimationSet  Anima_Set39;
	 AnimationSet  Anima_Set40;*/
	 String d="";
	 String dd = "";
	 String ss = "";
	String[] ouo = new String[255];
	String[] jilu = new String[255];
	int jiaobiao=0;
 	int c = 0;
 	int f = 0;
 	int h = 1;
 	int h1 = 0; 
	int index=0;
	Bitmap bmp;
	 EditText rsText ;
	public Jisuanqi(){}

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_jisuanqi, container, false);
       
       

    //去复制和粘贴
        
	rsText = (EditText)rootView.findViewById(R.id.rsText);
	rsText.setImeOptions(EditorInfo.IME_FLAG_NO_EXTRACT_UI);  
    
	rsText.setCustomSelectionActionModeCallback(new ActionMode.Callback() {

		@Override
		public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean onCreateActionMode(ActionMode mode, Menu menu) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void onDestroyActionMode(ActionMode mode) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
			// TODO Auto-generated method stub
			return false;
		}
    	
    	
    });
	//去除输入法焦点
										
	rsText.setImeOptions(EditorInfo.IME_FLAG_NO_EXTRACT_UI);  

      if (android.os.Build.VERSION.SDK_INT <= 10) {
  		
          rsText.setInputType(InputType.TYPE_NULL);
  } else {
  	getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
          try {
                  Class<EditText> cls = EditText.class;
                  Method setSoftInputShownOnFocus;
                  setSoftInputShownOnFocus = cls.getMethod("setSoftInputShownOnFocus", boolean.class);
                  setSoftInputShownOnFocus.setAccessible(true);
                  setSoftInputShownOnFocus.invoke(rsText, false);
          } catch (Exception e) {
                  e.printStackTrace();
          }
          try {
                  Class<EditText> cls = EditText.class;
                  Method setShowSoftInputOnFocus;
                  setShowSoftInputOnFocus = cls.getMethod("setShowSoftInputOnFocus", boolean.class);
                  setShowSoftInputOnFocus.setAccessible(true);
                  setShowSoftInputOnFocus.invoke(rsText, false);
          } catch (Exception e) {
                  e.printStackTrace();
          }
  }
	
     /* if(savedInstanceState!=null){
    	  
    	  rsText.setText(savedInstanceState.getString("edittext"));
      }*/
      
      
	//fun 功能按钮
      
      final TableRow TableRow1  = (TableRow)rootView.findViewById(R.id.TableRow1);
      final TableRow TableRow2  = (TableRow)rootView.findViewById(R.id.TableRow2);
      final TableRow TableRow3  = (TableRow)rootView.findViewById(R.id.TableRow3);
      final TableRow TableRow4  = (TableRow)rootView.findViewById(R.id.TableRow4);
      final TableRow TableRow5  = (TableRow)rootView.findViewById(R.id.TableRow5);
      final TableRow TableRow6 = (TableRow)rootView.findViewById(R.id.TableRow6);
      final TableRow TableRow7  = (TableRow)rootView.findViewById(R.id.TableRow7);
      final TableRow TableRow8  = (TableRow)rootView.findViewById(R.id.TableRow8);
      ll= (LinearLayout)rootView.findViewById(R.id.lay);
	 btnDel = (Button)rootView.findViewById(R.id.delete);
	 btnPlu = (Button)rootView.findViewById(R.id.plus);
	 btnMin = (Button)rootView.findViewById(R.id.minus);
	btnMul = (Button)rootView.findViewById(R.id.multiply);
	 btnDiv = (Button)rootView.findViewById(R.id.division);
	 btnEqu = (Button)rootView.findViewById(R.id.equ);
	 btnTono = (Button)rootView.findViewById(R.id.tonone);
	 btnLeft = (Button)rootView.findViewById(R.id.left);
	 btnRight = (Button)rootView.findViewById(R.id.right);
	 houtui = (Button)rootView.findViewById(R.id.houtui);
	 qianjin = (Button)rootView.findViewById(R.id.qianjin);
	guangbiaotui = (Button)rootView.findViewById(R.id.guangbiaotui);
	 guangbiaoqian = (Button)rootView.findViewById(R.id.guangbiaoqian);
	 sin = (Button)rootView. findViewById(R.id.sin);
	 cos = (Button)rootView.findViewById(R.id.cos);
	 tan = (Button)rootView.findViewById(R.id.tan);
	 asin = (Button) rootView.findViewById(R.id.asin);
	 acos = (Button)rootView. findViewById(R.id.acos);
	 atan = (Button)rootView. findViewById(R.id.atan);
	lg = (Button)rootView. findViewById(R.id.lg);
ln = (Button)rootView. findViewById(R.id.ln);
	 cifang = (Button)rootView.findViewById(R.id.cifang);
	genhao = (Button)rootView. findViewById(R.id.genhao);
 Pi = (Button)rootView.findViewById(R.id.pi);
	 E = (Button)rootView.findViewById(R.id.e);
	 baifengao = (Button)rootView.findViewById(R.id.baifenhao);
	 shuangguohao = (Button)rootView.findViewById(R.id.shuangguohao);
	 huiche = (Button)rootView.findViewById(R.id.huiche);
	 changshu = (Button)rootView.findViewById(R.id.changshu);
	//num 数字按钮
	 num0 = (Button)rootView.findViewById(R.id.num0);
	 num1 = (Button)rootView.findViewById(R.id.num1);
	 num2 = (Button)rootView.findViewById(R.id.num2);
 num3 = (Button)rootView.findViewById(R.id.num3);
	 num4 = (Button)rootView.findViewById(R.id.num4);
	 num5 = (Button)rootView.findViewById(R.id.num5);
	 num6 = (Button)rootView.findViewById(R.id.num6);
	 num7 = (Button)rootView.findViewById(R.id.num7);
	 num8 = (Button)rootView.findViewById(R.id.num8);
	 num9 = (Button)rootView.findViewById(R.id.num9);
	 dot = (Button)rootView.findViewById(R.id.dot);
	
	//listener
	btnTono.setOnClickListener(this);
	btnLeft.setOnClickListener(this);
	btnRight.setOnClickListener(this);
	btnDel.setOnClickListener(this);
	btnPlu.setOnClickListener(this);
	btnMin.setOnClickListener(this);
	btnMul.setOnClickListener(this);
	btnDiv.setOnClickListener(this);
	btnEqu.setOnClickListener(this);
	  num0.setOnClickListener(this);
	  num1.setOnClickListener(this);
	 
	  num2.setOnClickListener(this);
	  num3.setOnClickListener(this);
	  num4.setOnClickListener(this);
	  num5.setOnClickListener(this);
	  num6.setOnClickListener(this);
	  num7.setOnClickListener(this);
	  num8.setOnClickListener(this);
	  num9.setOnClickListener(this);
	  dot.setOnClickListener(this);
	  houtui.setOnClickListener(this);
	  qianjin.setOnClickListener(this);
	  guangbiaotui.setOnClickListener(this);
	  guangbiaoqian.setOnClickListener(this);
	  sin.setOnClickListener(this);
	  cos.setOnClickListener(this);
	  tan.setOnClickListener(this);
	  asin.setOnClickListener(this);
	  acos.setOnClickListener(this);
	  atan.setOnClickListener(this);
	  lg.setOnClickListener(this);
	  ln.setOnClickListener(this);
	  lg.setOnClickListener(this);
	  genhao.setOnClickListener(this);
	  cifang.setOnClickListener(this);
	  Pi.setOnClickListener(this);
	  E.setOnClickListener(this);
	  shuangguohao.setOnClickListener(this);
	  baifengao.setOnClickListener(this);
	  huiche.setOnClickListener(this);
	  changshu.setOnClickListener(this);
	  //监听屏幕动静
      /*ll.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
     	    @Override
     	    public boolean onPreDraw() {
     	    	ll.getViewTreeObserver().removeOnPreDrawListener(this);
     	    	ll.buildDrawingCache();
     	    	
     	         bmp = ll.getDrawingCache();
     	      // System.out.println(bmp);
     	        return true;
     	    }
     	});*/
	/*  Thread newThread; //声明一个子线程
      newThread = new Thread(new Runnable() {
          @Override
                  public void run() {
                  try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                
                 // ll.getViewTreeObserver().removeOnPreDrawListener(this);
      	    	ll.buildDrawingCache();
      	    	
      	         bmp = ll.getDrawingCache();
     
                  }
              });
          newThread.start(); */
	  
	  
	  rsText.setOnClickListener(new OnClickListener() {
		long firsTime = 0;
		@Override
		public void onClick(View arg0) {
			jiaobiao=rsText.getSelectionStart();
			//int index1 = rsText.getSelectionStart();
			//if(index1==0){}else{
			//if(rsText.getText().charAt(index1-1)==' '||rsText.getText().charAt(index1-1)==' '){
			//	rsText.setSelection(index1-1);
			//}}
			long secondTime;
			secondTime = System.currentTimeMillis();
			if(secondTime-firsTime>200){
				firsTime = secondTime;
				return ;
			}else{

//			Toast t1 = Toast.makeText(getActivity(), "ss",Toast.LENGTH_SHORT);
//			t1.show();
			String s = rsText.getText().toString();
			Bundle b = new Bundle();
			b.putString("name",s);
			Intent i = new Intent(getActivity(),Caogao.class);
			
//startActivity(i);
			i.putExtras(b);
			startActivityForResult(i, 0);
			
			getActivity().overridePendingTransition(R.anim.jdonghua,R.anim.cdonghua);
		}
	}});
	   

	  SharedPreferences sp = getActivity().getSharedPreferences("Edittext",  
              getActivity().MODE_PRIVATE);  
      // music_progress为XML文件的文件名  
      rsText.setText(sp.getString("edittext",null));
      index =sp.getInt("index", index);
    
      rsText.setSelection(index);
      //Animation  animation1 = new TranslateAnimation(-20, 0, 0 , 0);   
   
      
     // Animation  animation2 = new TranslateAnimation(20, 0, 0 , 0); 
      // AnimationSet   Animation_Set1=new AnimationSet(true);
    //  AnimationSet   Animation_Set2=new AnimationSet(true);
      //animation1.setDuration(800);
     // animation2.setDuration(800);
      /*Animation animation = new AlphaAnimation(0.3F,1.0f);   
      animation.setDuration(800);*/
      //animation.setStartOffset(600);
      
      final Animation animation1 = new AlphaAnimation(0.0F,1.0f);   
      animation1.setDuration(800);
      animation1.setStartOffset(100);
      
      final Animation animation2 = new AlphaAnimation(0.0F,1.0f);   
      animation2.setDuration(800);
      animation2.setStartOffset(400);
      
      final Animation animation3 = new AlphaAnimation(0.0F,1.0f);   
      animation3.setDuration(800);
      animation3.setStartOffset(600);
      
      final Animation animation4 = new AlphaAnimation(0.0F,1.0f);   
      animation4.setDuration(800);
      animation4.setStartOffset(800);
      
    /*  Animation animation5 = new AlphaAnimation(0.3F,1.0f);   
      animation5.setDuration(800);
      animation5.setStartOffset(500);*/
      
     /* Animation animation6 = new AlphaAnimation(0.3F,1.0f);   
      animation6.setDuration(800);
      animation6.setStartOffset(600);*/
      
     /* Animation animation7 = new AlphaAnimation(0.3F,1.0f);   
      animation7.setDuration(800);
      animation7.setStartOffset(700);*/
     /* Animation_Set2.addAnimation(animation);
      Animation_Set2.addAnimation(animation2);
      Animation_Set1.addAnimation(animation1);
      Animation_Set1.addAnimation(animation);
      */
      Thread newThread; //声明一个子线程
      newThread = new Thread(new Runnable() {
          @Override
                  public void run() {
        	  TableRow1.startAnimation(animation1);
              TableRow2.startAnimation(animation1);
              TableRow3.startAnimation(animation2);
              TableRow4.startAnimation(animation2);
              TableRow5.startAnimation(animation3);
              TableRow6.startAnimation(animation3);
              TableRow7.startAnimation(animation4);
              TableRow8.startAnimation(animation4);
                  }
              });
          newThread.start(); 
     
     
 //  dongHua(Anima_Set1);
   /*dongHua(Anima_Set2);
   dongHua(Anima_Set3);
   dongHua(Anima_Set4);
   dongHua(Anima_Set5);
   dongHua(Anima_Set6);
   dongHua(Anima_Set7);
   dongHua(Anima_Set8);
   dongHua(Anima_Set9);
   dongHua(Anima_Set10);
   dongHua(Anima_Set11);
   dongHua(Anima_Set12);
   dongHua(Anima_Set13);
   dongHua(Anima_Set14);
   dongHua(Anima_Set15);
   dongHua(Anima_Set16);
   dongHua(Anima_Set17);
   dongHua(Anima_Set18);
   dongHua(Anima_Set19);
   dongHua(Anima_Set20);
   dongHua(Anima_Set21);
   dongHua(Anima_Set22);
   dongHua(Anima_Set23);
   dongHua(Anima_Set24);
   dongHua(Anima_Set25);
   dongHua(Anima_Set26);
   dongHua(Anima_Set27);
   dongHua(Anima_Set28);
   dongHua(Anima_Set29);
   dongHua(Anima_Set30);
   dongHua(Anima_Set31);
   dongHua(Anima_Set32);
   dongHua(Anima_Set33);
   dongHua(Anima_Set34);
   dongHua(Anima_Set35);
   dongHua(Anima_Set36);
   dongHua(Anima_Set37);
   dongHua(Anima_Set38);
   dongHua(Anima_Set39);
   dongHua(Anima_Set40);
      */
    
 
      
	  

	  return rootView;
		}
	  
	
	
	
	
	
	@Override  
    public void onDestroy() {  
	
		super.onDestroy();
		SharedPreferences sp = getActivity().getSharedPreferences("Edittext",  
                getActivity().MODE_PRIVATE);  
        sp.edit().putString("edittext", rsText.getText().toString()).commit();
     
        sp.edit().putInt("index", index).commit();
	}
	
	
	@Override
	public void onSaveInstanceState(Bundle state) {
        super.onSaveInstanceState(state);
        state.putString("edittext", rsText.getText().toString());
    }

/*
public void onActivityResult(int requestCode ,int resultCode,Intent date){
	  switch(resultCode){
	  case RESULT_OK:
		  String d = date.getExtras().getString("s");
		  rsText.setText(d);
		  break;
		  default:
			  break;
	  }
  }

*/

@Override
public void onClick(View e) {
	
	//System.out.println(rsText.hasFocus()+"-------->");
//	Editable editable = rsText.getText();
	index = rsText.getSelectionStart();
	Button btn = (Button)e;
	
	Animation Animation_Alpha=new AlphaAnimation(1.0f, 0.1f);
    // Animation  Animation_Scale =new ScaleAnimation(0.0f, 1.4f, 0.0f, 1.4f,   
 //  Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
     Animation_Alpha.setDuration(400);
     btn.startAnimation(Animation_Alpha);
	String a = rsText.getText().toString();
	
	//String rus;
	if(btn.findViewById(R.id.changshu)!=null){
		//changshu.startAnimation(dongHua(Anima_Set1));
		
		Changshu  datePickerView = new Changshu(getActivity(),R.style.CustomDialog,
      			new Changshu.OnDateSetListener() {
      			@Override
      			public void onDateSet(DatePicker view, int yearz,
      			int monthOfYearz, int dayOfMonthz,String e, Bitmap bmp1) { 
      				String sss = rsText.getText().toString();
      				//System.out.println(index+"index");
      				String ss = null ;
      				if(index!=0){ ss = String.valueOf(sss.charAt(index-1));
      				//System.out.println(ss+"index");
      				}
      				
      				if(index==0){rsText.getText().insert(index,e);
      				index = index+1;
      				jiaobiao=rsText.getSelectionStart();}
      				else if(ss.equals("(")||ss.equals("+")||ss.equals("-")||ss.equals("×")||ss.equals("÷")||ss.equals("^")||ss.equals("√")||ss.equals("\n")){rsText.getText().insert(index,e);
      				index = index+1;
      				jiaobiao=rsText.getSelectionStart();}
      				else{}
      			
     }           
	           },
	           2014,     //传入年份
	         8,     //传入月份
	           1    //传入天数    
	           ,null,bmp);
		 datePickerView.myShow();
	}
	
	
	
		else if(btn.findViewById(R.id.houtui)!=null){
			//houtui.clearAnimation();
			//houtui.startAnimation(dongHua(Anima_Set2));
		houtui();
		index=rsText.getText().length();
	}
	else if(btn.findViewById(R.id.qianjin)!=null){
		//qianjin.startAnimation(dongHua(Anima_Set3));
		qianjin();
		index=rsText.getText().length();
	}
	else if(btn.findViewById(R.id.guangbiaotui)!=null){
	//	guangbiaotui.startAnimation(dongHua(Anima_Set4));
		if(index==0)
			index=1;
		index=index-1;
	}
	else if(btn.findViewById(R.id.guangbiaoqian)!=null){
		//guangbiaoqian.startAnimation(dongHua(Anima_Set5));
		if(index<rsText.getText().length())
			++index;
		
	}
	else if(btn.findViewById(R.id.sin)!=null){
		//sin.startAnimation(dongHua(Anima_Set6));
		rsText.getText().insert(index,"sin()");
		index = index+4;
		jiaobiao=rsText.getSelectionStart();
	}
	else if(btn.findViewById(R.id.cos)!=null){
	//cos.startAnimation(dongHua(Anima_Set7));
		rsText.getText().insert(index,"cos()");
		index = index+4;
		jiaobiao=rsText.getSelectionStart();
	}
	else if(btn.findViewById(R.id.tan)!=null){
		//tan.startAnimation(dongHua(Anima_Set8));
		rsText.getText().insert(index,"tan()");
		index = index+4;
		jiaobiao=rsText.getSelectionStart();
	}
	else if(btn.findViewById(R.id.asin)!=null){
		//asin.startAnimation(dongHua(Anima_Set9));
		jiaobiao=rsText.getSelectionStart();
		rsText.getText().insert(index,"asin()");
		index = index+5;
	}else if(btn.findViewById(R.id.acos)!=null){
		//acos.startAnimation(dongHua(Anima_Set10));
		jiaobiao=rsText.getSelectionStart();
		rsText.getText().insert(index,"acos()");
		index = index+5;
	}
	
	else if(btn.findViewById(R.id.atan)!=null){
		//atan.startAnimation(dongHua(Anima_Set11));
		rsText.getText().insert(index,"atan()");
		index = index+5;
		jiaobiao=rsText.getSelectionStart();
	}
	
	else if(btn.findViewById(R.id.lg)!=null){
		//lg.startAnimation(dongHua(Anima_Set12));
		rsText.getText().insert(index,"lg()");
		index = index+3;
		jiaobiao=rsText.getSelectionStart();
	}
	else if(btn.findViewById(R.id.ln)!=null){

		//ln.startAnimation(dongHua(Anima_Set13));
		
		rsText.getText().insert(index,"ln()");
		index = index+3;
		jiaobiao=rsText.getSelectionStart();
	}
	else if(btn.findViewById(R.id.pi)!=null){
//	Pi.startAnimation(dongHua(Anima_Set14));
		rsText.getText().insert(index,"∏");
		index = index+1;
		jiaobiao=rsText.getSelectionStart();
		}
	else if(btn.findViewById(R.id.e)!=null){
	//	e.startAnimation(dongHua(Anima_Set15));
		rsText.getText().insert(index,"e");
		index = index+1;
		jiaobiao=rsText.getSelectionStart();
		}
	else if(btn.findViewById(R.id.shuangguohao)!=null){
		//shuangguohao.startAnimation(dongHua(Anima_Set16));
		rsText.getText().insert(index,"()");
		index = index+1;
		jiaobiao=rsText.getSelectionStart();
		}
	
	else if(btn.findViewById(R.id.huiche)!=null){
		//huiche.startAnimation(dongHua(Anima_Set17));
		rsText.getText().insert(index,"\n");
		index = index+1;
		jiaobiao=rsText.getSelectionStart();
		}
	else if(btn.getText().equals("C")){
	//	btnTono.startAnimation(dongHua(Anima_Set18));
		rsText.setText("");
		d="";
		index=0;
	}
	else if(btn.getText().equals("清除")){ 
		//btnDel.startAnimation(dongHua(Anima_Set19));
		//实现清除等号是结果也清除
		if(index==0){}else{
		if(rsText.getText().charAt(index-1)=='='){
			if(rsText.getText().toString().indexOf("\n", index)==-1){}
			else
			rsText.getText().replace(index, rsText.getText().toString().indexOf("\n", index), "");
		}
			
		
		}
		
		
		if(a==null || a.trim().length()==0)
			return; 
		else
		{
			if(index==0){
				index=1;
			}else{
			rsText.getText().delete(index-1, index);
			}
			index = index -1;
		}
		
		jiaobiao=index;
	}
	

	
	else if(btn.getText().equals("="))
	{
		//btnEqu.startAnimation(dongHua(Anima_Set20));
		
		if(a.equals("")){}else{
		a = a.replace("×", "*");
		a = a.replace("÷", "/");
	 	
//实现光标位置计算功能
		if(jiaobiao<a.length()){
			//System.out.println("jiaobiao"+jiaobiao);
			//System.out.println(a.charAt(jiaobiao)=='\n');
				if(a.charAt(jiaobiao)=='\n'){
					jiaobiao--;
					if(jiaobiao==-1)jiaobiao=0;
					if(jiaobiao>=0&&a.charAt(jiaobiao)=='\n'){
						jiaobiao=0;
					}
					}}
		
		if(jiaobiao>0){
				if(a.lastIndexOf("\n",jiaobiao)==-1&&a.indexOf("\n", jiaobiao)==-1){
					dd=a;
					if(dd.contains("="))
		        	{
		        	dd=dd.substring(0, dd.indexOf("="));
		        	}
		        	else
		        	{}
					}
				
				else if(a.lastIndexOf("\n",jiaobiao)==-1){
	        	
	        	dd=a.substring(0,a.indexOf("\n", jiaobiao));
	        	if(dd.contains("="))
	        	{
	        	dd=dd.substring(0, dd.indexOf("="));
	        	}
	        	else
	        	{}
	        	}
	        else
	        {
	        	
	        	if(a.indexOf("\n", jiaobiao)==-1){
	            	dd=a.substring(a.lastIndexOf("\n",jiaobiao)+1,a.length());
	            	}
	            else{
	            	
	        	if(a.lastIndexOf("\n",jiaobiao)==a.indexOf("\n", jiaobiao)){}else
	            	dd=a.substring(a.lastIndexOf("\n",jiaobiao)+1,a.indexOf("\n", jiaobiao));
	        	}
	        	if(dd.contains("="))
	        	{
	        		dd=dd.substring(0, dd.indexOf("="));
	        	}
	        	else
	        	{}
	        	
			}
	    
	        ss=Cigen.ciFang("#("+dd+")#");
	        if(ss==" "){
	        	d=a;
	        	
	    		showToast("o(╯□╰)o出错喽！");
	        	//Toast.makeText(getActivity(), "o(╯□╰)o出错喽！", Toast.LENGTH_SHORT).show();
	        	}
	        else{
	        if(ss.endsWith(".0"))
	        	ss=ss.substring(0, ss.length()-2);
	        ss=dd+"="+ss;
	      
	        if(a.lastIndexOf("\n",jiaobiao)==-1&&a.indexOf("\n", jiaobiao)==-1){
	        	d=ss+"\n";
	        }
	        else if(a.lastIndexOf("\n",jiaobiao)==-1)
	        {
	        d=ss+"\n"+a.substring(a.indexOf("\n", jiaobiao), a.length());
	   
	        }
	        else
	        {
	       
	        	if(a.indexOf("\n", jiaobiao)==-1){
	                d=a.substring(0, a.lastIndexOf("\n",jiaobiao)+1)+ss+"\n";}
	               else{
	            	   d=a.substring(0, a.lastIndexOf("\n",jiaobiao)+1)+ss+"\n"+a.substring(a.indexOf("\n", jiaobiao), a.length());}
	        }
	         
	        }}else{d=a;jiaobiao=rsText.getSelectionStart();}
		if(d.contains("\n\n\n")){d=d.replace("\n\n\n", "\n\n");}
		if(d==null || a.trim().length()==0)
			return;
		d=d.replace("*", "×");
		d=d.replace("/", "÷");
		rsText.setText(d);
		//System.out.println("jao"+jiaobiao);
		if(d.indexOf("\n", jiaobiao)==-1){
			
			index=d.length();
		}else{
			//System.out.println(jiaobiao+"   ji");
		index = d.indexOf("\n", jiaobiao)+1;
		}
		
		a=null;
	
				
		c=0;
		f=0;
		//index=rsText.getText().length();
		
		}
		
	}
	else{
		
		/*if(btn.getText().equals("(")){
			btnLeft.startAnimation(dongHua(Anima_Set21));
		}else if(btn.getText().equals(")"))
        {
			btnRight.startAnimation(dongHua(Anima_Set22));
        }
		else if(btn.getText().equals("+"))
        {
			btnPlu.startAnimation(dongHua(Anima_Set23));
        }else if(btn.getText().equals("-"))
        {
			btnMin.startAnimation(dongHua(Anima_Set24));
        }else if(btn.getText().equals("×"))
        {
			btnMul.startAnimation(dongHua(Anima_Set25));
        }else if(btn.getText().equals("÷"))
        {
			btnDiv.startAnimation(dongHua(Anima_Set26));
        }else if(btn.getText().equals("√"))
        {
			genhao.startAnimation(dongHua(Anima_Set27));
        }else if(btn.getText().equals("^"))
        {
			cifang.startAnimation(dongHua(Anima_Set28));
        }else if(btn.getText().equals("%"))
        {
			baifengao.startAnimation(dongHua(Anima_Set29));
        }else if(btn.getText().equals("0"))
        {
			num0.startAnimation(dongHua(Anima_Set30));
        }
        else if(btn.getText().equals("1"))
        {
			num1.startAnimation(dongHua(Anima_Set31));
        }else if(btn.getText().equals("2"))
        {
			num2.startAnimation(dongHua(Anima_Set32));
        }else if(btn.getText().equals("3"))
        {
			num3.startAnimation(dongHua(Anima_Set33));
        }else if(btn.getText().equals("4"))
        {
			num4.startAnimation(dongHua(Anima_Set34));
        }else if(btn.getText().equals("5"))
        {
			num5.startAnimation(dongHua(Anima_Set35));
        }else if(btn.getText().equals("6"))
        {
			num6.startAnimation(dongHua(Anima_Set36));
        }else if(btn.getText().equals("7"))
        {
			num7.startAnimation(dongHua(Anima_Set37));
        }else if(btn.getText().equals("8"))
        {
			num8.startAnimation(dongHua(Anima_Set38));
        }else if(btn.getText().equals("9"))
        {
			num9.startAnimation(dongHua(Anima_Set39));
        }else if(btn.getText().equals("."))
        {
			dot.startAnimation(dongHua(Anima_Set40));
        }*/
		
		rsText.getText().insert(index, btn.getText());
		index = index+1;
		jiaobiao=rsText.getSelectionStart();
		 ss = rsText.getText().toString();
		if(index>=2){
		//实现符号取代功能
		if(Pattern.matches("[+\\-\\^\\÷\\.\\%\\√\\×]", String.valueOf(ss.charAt(index-2)))&&Pattern.matches("[+\\-\\^\\√\\÷\\.\\%\\×]", String.valueOf(ss.charAt(index-1)))){
			if((ss.charAt(index-1)=='√'&&ss.charAt(index-2)!='^'&&ss.charAt(index-2)!='√')||(ss.charAt(index-2)=='%'&&ss.charAt(index-1)=='%'))
			{}else{
			rsText.getText().delete(index-2, index-1);
			
			
			index = index-1;}
		}
		}
		//实现结果快速计算功能
		if(jiaobiao<3){
			return;
		}
	else{
		int jiaobiao1;
		int jiaobiao2;
		int jiaobiao3;
		
		
	
	if(ss.charAt(jiaobiao-2)=='\n'&&Pattern.matches("[+\\-\\×\\÷]", String.valueOf(ss.charAt(jiaobiao-1)))){
		
if(ss.length()==index){
	jiaobiao1=jiaobiao-2;
	jiaobiao2=ss.length()-2;
	jiaobiao3=jiaobiao-1;
}

else {
	jiaobiao1=jiaobiao;
	jiaobiao2=ss.length();
	jiaobiao3=jiaobiao;
}

	rsText.setText(ss.substring(0, jiaobiao-1)+ss.substring(ss.lastIndexOf("=",jiaobiao)+1, ss.indexOf("\n", ss.lastIndexOf( "=",ss.indexOf("\n", jiaobiao-2))))+btn.getText()+ss.substring(jiaobiao1, jiaobiao2));
		ss = rsText.getText().toString();
	if(jiaobiao2==jiaobiao-2){index=ss.length();}
	else{	index=ss.indexOf("\n", jiaobiao3);}
		
	}
	}
		
	}
	
	//实现记录功能
		if(btn.findViewById(R.id.houtui)==null&&btn.findViewById(R.id.qianjin)==null){
	    h1=h;
		jilu[h++] = rsText.getText().toString();
		if(h==255){
			h=254;
			for(int q=0;q<=253;q++){
				jilu[q]=jilu[q+1];
			}
		}
		}
	 
	  rsText.setSelection(index);
		

}









private void houtui(){
	if(h1>0)
	rsText.setText(jilu[--h1]);
}

private void qianjin(){
	if(h1<h-1)
	rsText.setText(jilu[++h1]);
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
  
  public AnimationSet dongHua(AnimationSet anim ) {  
	  
	  Animation Animation_Alpha=new AlphaAnimation(1.0f, 0.1f);
      Animation  Animation_Scale =new ScaleAnimation(0.0f, 1.4f, 0.0f, 1.4f,   
    Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
      Animation_Alpha.setDuration(600);
    //  Animation_Scale.setDuration(400);
	  anim=new AnimationSet(true);
	//  anim.addAnimation(Animation_Scale);
	  anim.addAnimation(Animation_Alpha);
	return anim;
  }
/***
 * @param  exp 算数表达式
 * @return 根据表达式返回结果
 */
/*private String getRs(String exp){
	Youxiansuanfa y = new Youxiansuanfa();
	try{
	exp = filterExp(exp);
	
	String result = y.evaluateExpression(exp);
	return result;
	}
	catch(Exception e){
		e.printStackTrace();
		return " ";
	}
	//	Interpreter bsh = new Interpreter();
       // Number result = null;
	//	try {
		//	exp = filterExp(exp);
		//	result = (Number)bsh.eval(exp);
		//} catch (EvalError e) {
		//	e.printStackTrace();
			
	
		//	return " ";
			
		//}   
		//return result.doubleValue()+"";
}

	
/**
 * @param exp 算数表达式
 * @return 因为计算过程中,全程需要有小数参与.
 */
/*	private String filterExp(String exp) {
	String num[] = exp.split("");
	String temp = null;
	int begin=0,end=0;
	 for (int i = 1; i < num.length; i++) {
		 temp = num[i];
		 if(temp.matches("[+-/()*]")){
			 if(temp.equals(".")) continue;
			 end = i - 1;  
			 temp = exp.substring(begin, end);
			 if(temp.trim().length() > 0 && temp.indexOf(".")<0)
				 num[i-1] = num[i-1]+".0";
			 begin = end + 1;
		 }
	 }
	 return Arrays.toString(num).replaceAll("[\\[\\], ]", "");
}*/

}



