package com.example.slidingmenufragmenttest.fragment;

import java.lang.reflect.Method;
import java.text.DecimalFormat;

import com.example.calculatorjykal.R;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Jihe extends Fragment implements OnClickListener,OnLongClickListener{
	 private Button mButton;
	    private PopupWindow mPopupWindow;
	  //屏幕高
		int pm_G;
		int pm_K;
		LinearLayout jh_ll;
		View rootView;
		
		 EditText editText1;
         EditText editText2 ;
         EditText editText3 ;
         EditText editText4 ;
         EditText editText5 ;
         EditText editText6 ;
         EditText editText7 ;
         EditText editText8 ;
         //textview
         TextView textView1 ;
         TextView textView2 ;
         TextView textView3 ;
         TextView textView4 ;
         TextView textView5 ;
         TextView textView6 ;
         TextView textView7;
         TextView textView8 ;
         int index_1=0;
         int index_2=0;
         int index_3=0;
         int index_4=0;
         int index_5=0;
         int index_6=0;
         int index_7=0;
         int index_8=0;
         //
         int sign = 0 ;
       //
       double N=0;
     	 double alpha=0;
    	 double a=0;
    	 double P=0;
    	 double A=0;
    	//
    	 double b=0;
    	 double c=0;
    	 double beta=0;
    	double gamma =0;
    	
    	
    	
    	//三角形
    	double alpha_text=0;
    	 double a_text=0;
    	 double A_text=0;
    	 double N_text=0;
    	 double P_text=0;
    	 //
    	 double b_text=0;
    	 double c_text=0;
    	 double beta_text=0;
    	 double gamma_text=0;
    	 //圆
    	 double C=0;
    	 double d=0;
    	 double r=0;
    	 
    	 double C_text=0;
    	 double d_text=0;
    	 double r_text=0;
    	 //椭圆
    	 double p=0;
    	 double q=0;
    	 
    	 double p_text=0;
    	 double q_text=0;
    	 
    	 //正三角形
    	 double h=0;
    	 
    	 double h_text=0;
    	 //3d
    	 double V=0;
    	 double V_text=0;
    	 //柱体
    	 double B=0;
    	 double B_text=0;
         
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
      rootView = inflater.inflate(R.layout.fragment_jihe, container, false);
        
      //获得屏幕大小
      		DisplayMetrics dm = new DisplayMetrics();
      		this.getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
      		pm_K = dm.widthPixels;//宽度
      		pm_G = dm.heightPixels ;//高度
      		 TableLayout jh_tl = (TableLayout)rootView.findViewById(R.id.jh_tl);
      		ScrollView  jh_sl = (ScrollView)rootView.findViewById(R.id.scrollView_jh);
      		 mButton = (Button) rootView.findViewById(R.id.btn_test_popupwindow);
      		 jh_ll = (LinearLayout)rootView.findViewById(R.id.jh_ll);
      		 //设置控件大小
             android.view.ViewGroup.LayoutParams lp_jh;        
             lp_jh=jh_tl.getLayoutParams();
             lp_jh.height= pm_G*2/5;      
             jh_tl.setLayoutParams(lp_jh);
             
             android.view.ViewGroup.LayoutParams ls_jh;        
             ls_jh=jh_sl.getLayoutParams();
             ls_jh.height=pm_G/2;        
             jh_sl.setLayoutParams(ls_jh);
             
             android.view.ViewGroup.LayoutParams bt_jh;        
             bt_jh=mButton.getLayoutParams();
             bt_jh.height=pm_G/20;        
             mButton.setLayoutParams(bt_jh);
          //button
             //button
             Button quanshan = (Button)rootView.findViewById(R.id.quanshan_jh);
             Button dian_jh = (Button)rootView.findViewById(R.id.dian_jh);
             Button jisuan_jh = (Button)rootView.findViewById(R.id.jisuan_jh);
             Button qingchu_jh = (Button)rootView.findViewById(R.id.qingchu_jh);
             Button lin_jh = (Button)rootView.findViewById(R.id.lin_jh);
             Button yi_jh = (Button)rootView.findViewById(R.id.yi_jh);
             Button er_jh = (Button)rootView.findViewById(R.id.er_jh);
             Button san_jh = (Button)rootView.findViewById(R.id.san_jh);
             Button si_jh = (Button)rootView.findViewById(R.id.si_jh);
             Button wu_jh = (Button)rootView.findViewById(R.id.wu_jh);
             Button liu_jh = (Button)rootView.findViewById(R.id.liu_jh);
             Button qi_jh = (Button)rootView.findViewById(R.id.qi_jh);
             Button ba_jh = (Button)rootView.findViewById(R.id.ba_jh);
             Button jiu_jh = (Button)rootView.findViewById(R.id.jiu_jh);
             
        
             //btn
             quanshan.setOnClickListener(this);
             dian_jh.setOnClickListener(this);
             jisuan_jh.setOnClickListener(this);
             qingchu_jh.setOnClickListener(this);
             qingchu_jh.setOnLongClickListener(this);
             lin_jh.setOnClickListener(this);
             yi_jh.setOnClickListener(this);
             er_jh.setOnClickListener(this);
             san_jh.setOnClickListener(this);
             si_jh.setOnClickListener(this);
             wu_jh.setOnClickListener(this);
             liu_jh.setOnClickListener(this);
             qi_jh.setOnClickListener(this);
             ba_jh.setOnClickListener(this);
             jiu_jh.setOnClickListener(this);
           //Edittext
              editText1 = (EditText)rootView.findViewById(R.id.editText1);
              editText2 = (EditText)rootView.findViewById(R.id.editText2);
              editText3 = (EditText)rootView.findViewById(R.id.editText3);
              editText4 = (EditText)rootView.findViewById(R.id.editText4);
              editText5 = (EditText)rootView.findViewById(R.id.editText5);
              editText6 = (EditText)rootView.findViewById(R.id.editText6);
              editText7 = (EditText)rootView.findViewById(R.id.editText7);
              editText8 = (EditText)rootView.findViewById(R.id.editText8);
             //textview
              textView1 = (TextView)rootView.findViewById(R.id.textView1);
              textView2 = (TextView)rootView.findViewById(R.id.textView2);
              textView3 = (TextView)rootView.findViewById(R.id.textView3);
              textView4 = (TextView)rootView.findViewById(R.id.textView4);
              textView5 = (TextView)rootView.findViewById(R.id.textView5);
              textView6 = (TextView)rootView.findViewById(R.id.textView6);
              textView7 = (TextView)rootView.findViewById(R.id.textView7);
              textView8 = (TextView)rootView.findViewById(R.id.textView8);
            //出焦点
      		chujiaodian(editText1);
      		chujiaodian(editText2);
      		chujiaodian(editText3);
      		chujiaodian(editText4);
      		chujiaodian(editText5);
      		chujiaodian(editText6);
      		chujiaodian(editText7);
      		chujiaodian(editText8);
        //popwindows
             
        View popupView = this.getActivity().getLayoutInflater().inflate(R.layout.jihepopwindow, null);
        ImageButton jh_zhengN = (ImageButton)popupView.findViewById(R.id.JH1button1);
        ImageButton jh_sanjiaoxing = (ImageButton)popupView.findViewById(R.id.JH1button2);
        ImageButton jh_yuan = (ImageButton)popupView.findViewById(R.id.JH1button3);
        ImageButton jh_tuoyuan = (ImageButton)popupView.findViewById(R.id.JH1button4);
        ImageButton jh_zhengsanjiaoxing = (ImageButton)popupView.findViewById(R.id.JH1button5);
        ImageButton jh_zhuiti = (ImageButton)popupView.findViewById(R.id.JH1button6);
        ImageButton jh_tuoqiu = (ImageButton)popupView.findViewById(R.id.JH1button7);
        ImageButton jh_zhuti = (ImageButton)popupView.findViewById(R.id.JH1button8);
      //  ImageButton jh_lingxing = (ImageButton)popupView.findViewById(R.id.JH1button6);
        ImageButton jh_zhijiaosanjiaoxing = (ImageButton)popupView.findViewById(R.id.JH2button1);
        ImageButton jh_dengyaosanjiaoxing = (ImageButton)popupView.findViewById(R.id.JH2button2);
        ImageButton jh_lingxing = (ImageButton)popupView.findViewById(R.id.JH2button3);
        ImageButton jh_tixing = (ImageButton)popupView.findViewById(R.id.JH2button4);
        ImageButton jh_pingxingsibianxing = (ImageButton)popupView.findViewById(R.id.JH2button5);
        ImageButton jh_qiu = (ImageButton)popupView.findViewById(R.id.JH2button6);
        ImageButton jh_simianti = (ImageButton)popupView.findViewById(R.id.JH2button7);
        ImageButton jh_yuanzhu = (ImageButton)popupView.findViewById(R.id.JH2button8);
      //  ImageButton jh_changfangxing = (ImageButton)popupView.findViewById(R.id.JH2button6);
        //设置监听
        jh_zhengN.setOnClickListener(this);
        jh_sanjiaoxing.setOnClickListener(this);
        jh_yuan.setOnClickListener(this);
        jh_tuoyuan.setOnClickListener(this);
        jh_zhengsanjiaoxing.setOnClickListener(this);
        jh_zhuiti.setOnClickListener(this);
        jh_tuoqiu.setOnClickListener(this);
        jh_zhuti.setOnClickListener(this);
        
        //
        jh_zhijiaosanjiaoxing.setOnClickListener(this);
        jh_dengyaosanjiaoxing.setOnClickListener(this);
        jh_lingxing.setOnClickListener(this);
        jh_tixing.setOnClickListener(this);
        jh_pingxingsibianxing.setOnClickListener(this);
        jh_qiu.setOnClickListener(this);
        jh_simianti.setOnClickListener(this);
        jh_yuanzhu.setOnClickListener(this);
      //  jh_changfangxing.setOnClickListener(this);
        mPopupWindow = new PopupWindow(popupView, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, true);
        mPopupWindow.setTouchable(true);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable(getResources(), (Bitmap) null));
       
       // mPopupWindow.setAnimationStyle(R.style.PopupAnimation);
        
        mButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
            	 
            	 mPopupWindow.showAsDropDown(v);
            	// mPopupWindow.update();
            }
        });
    return  rootView;   
	}

        @Override
        public void onClick(View v) {
        	Editable edit1 = editText1.getEditableText();//获取EditText的文字
        	Editable edit2 = editText2.getEditableText();
        	Editable edit3 = editText3.getEditableText();
        	Editable edit4 = editText4.getEditableText();
        	Editable edit5 = editText5.getEditableText();
        	Editable edit6 = editText6.getEditableText();
        	Editable edit7 = editText7.getEditableText();
        	Editable edit8 = editText8.getEditableText();
        	index_1 = editText1.getSelectionStart();
    		index_2 = editText2.getSelectionStart();
    		index_3 = editText3.getSelectionStart();
    		index_4 = editText4.getSelectionStart();
    		index_5 = editText5.getSelectionStart();
    		index_6 = editText6.getSelectionStart();
    		index_7 = editText7.getSelectionStart();
    		index_8 = editText8.getSelectionStart();
    		
        	switch (v.getId()) {
        	
        	case R.id.JH1button1:
        		sign = 11;
        		textView1.setVisibility(View.VISIBLE);
        		textView2.setVisibility(View.VISIBLE);
        		textView3.setVisibility(View.VISIBLE);
        		textView4.setVisibility(View.VISIBLE);
        		textView5.setVisibility(View.VISIBLE);
        		textView6.setVisibility(View.GONE);
        		textView7.setVisibility(View.GONE);
        		textView8.setVisibility(View.GONE);	
        		textView1.setText("面积(A)");
        		textView2.setText("周长(P)");
        		textView3.setText("边数(N)");
        		textView4.setText("边长(a)");
        		textView5.setText("a所对的角(α)[度]");
        	
        	editText1.setVisibility(View.VISIBLE);
        	editText2.setVisibility(View.VISIBLE);
        	editText3.setVisibility(View.VISIBLE);
        	editText4.setVisibility(View.VISIBLE);
        	editText5.setVisibility(View.VISIBLE);
        	editText6.setVisibility(View.GONE);
        	editText7.setVisibility(View.GONE);
        	editText8.setVisibility(View.GONE);
        	mPopupWindow.dismiss(); //响应点击事件之后关闭Men
        	break;
        	case R.id.JH1button2:
        		sign=12;
        		textView1.setVisibility(View.VISIBLE);
        		textView2.setVisibility(View.VISIBLE);
        		textView3.setVisibility(View.VISIBLE);
        		textView4.setVisibility(View.VISIBLE);
        		textView5.setVisibility(View.VISIBLE);
        		textView6.setVisibility(View.VISIBLE);
        		textView7.setVisibility(View.VISIBLE);
        		textView8.setVisibility(View.VISIBLE);	
        		textView1.setText("面积(A)");
        		textView2.setText("周长(P)");
        		textView3.setText("边长(a)");
        		textView4.setText("边长(b)");
        		textView5.setText("边长(c)");
        		textView6.setText("a所对的角(α)[度]");
        		textView7.setText("b所对的角(β)[度]");
        		textView8.setText("c所对的角(γ)[度]");
        	editText1.setVisibility(View.VISIBLE);
        	editText2.setVisibility(View.VISIBLE);
        	editText3.setVisibility(View.VISIBLE);
        	editText4.setVisibility(View.VISIBLE);
        	editText5.setVisibility(View.VISIBLE);
        	editText6.setVisibility(View.VISIBLE);
        	editText7.setVisibility(View.VISIBLE);
        	editText8.setVisibility(View.VISIBLE);
        	mPopupWindow.dismiss(); //响应点击事件之后关闭Menu 
        		break;
        	case R.id.JH1button3:
        		sign=13;
        		textView1.setVisibility(View.VISIBLE);
        		textView2.setVisibility(View.VISIBLE);
        		textView3.setVisibility(View.VISIBLE);
        		textView4.setVisibility(View.VISIBLE);
        		textView5.setVisibility(View.GONE);
        		textView6.setVisibility(View.GONE);
        		textView7.setVisibility(View.GONE);
        		textView8.setVisibility(View.GONE);	
        		textView1.setText("面积(A)");
        		textView2.setText("周长(P)");
        		textView3.setText("直径(d)");
        		textView4.setText("半径(r)");
        		
        	editText1.setVisibility(View.VISIBLE);
        	editText2.setVisibility(View.VISIBLE);
        	editText3.setVisibility(View.VISIBLE);
        	editText4.setVisibility(View.VISIBLE);
        	editText5.setVisibility(View.GONE);
        	editText6.setVisibility(View.GONE);
        	editText7.setVisibility(View.GONE);
        	editText8.setVisibility(View.GONE);
        	mPopupWindow.dismiss(); //响应点击事件之后关闭Menu 
        		break;
        	case R.id.JH1button4:
        		sign=14;
        		textView1.setVisibility(View.VISIBLE);
        		textView2.setVisibility(View.VISIBLE);
        		textView3.setVisibility(View.VISIBLE);
        		textView4.setVisibility(View.VISIBLE);
        		textView5.setVisibility(View.GONE);
        		textView6.setVisibility(View.GONE);
        		textView7.setVisibility(View.GONE);
        		textView8.setVisibility(View.GONE);	
        		textView1.setText("面积(A)");
        		textView2.setText("直径(P)");
        		textView3.setText("直径(q)");
        		textView4.setText("周长(C)");
        	
        	editText1.setVisibility(View.VISIBLE);
        	editText2.setVisibility(View.VISIBLE);
        	editText3.setVisibility(View.VISIBLE);
        	editText4.setVisibility(View.VISIBLE);
        	editText5.setVisibility(View.GONE);
        	editText6.setVisibility(View.GONE);
        	editText7.setVisibility(View.GONE);
        	editText8.setVisibility(View.GONE);
        	mPopupWindow.dismiss(); //响应点击事件之后关闭Menu 
        		break;
        	case R.id.JH1button5:
        		sign=15;
        		textView1.setVisibility(View.VISIBLE);
        		textView2.setVisibility(View.VISIBLE);
        		textView3.setVisibility(View.VISIBLE);
        		textView4.setVisibility(View.VISIBLE);
        		textView5.setVisibility(View.GONE);
        		textView6.setVisibility(View.GONE);
        		textView7.setVisibility(View.GONE);
        		textView8.setVisibility(View.GONE);	
        		textView1.setText("面积(A)");
        		textView2.setText("周长(P)");
        		textView3.setText("边长(a)");
        		textView4.setText("高(h)");
        	
        	editText1.setVisibility(View.VISIBLE);
        	editText2.setVisibility(View.VISIBLE);
        	editText3.setVisibility(View.VISIBLE);
        	editText4.setVisibility(View.VISIBLE);
        	editText5.setVisibility(View.GONE);
        	editText6.setVisibility(View.GONE);
        	editText7.setVisibility(View.GONE);
        	editText8.setVisibility(View.GONE);
        	mPopupWindow.dismiss(); //响应点击事件之后关闭Menu 
        		break;
        	case R.id.JH1button6:
        		sign=16;
        		textView1.setVisibility(View.VISIBLE);
        		textView2.setVisibility(View.VISIBLE);
        		textView3.setVisibility(View.VISIBLE);
        		textView4.setVisibility(View.VISIBLE);
        		textView5.setVisibility(View.VISIBLE);
        		textView6.setVisibility(View.GONE);
        		textView7.setVisibility(View.GONE);
        		textView8.setVisibility(View.GONE);	
        		textView1.setText("面积(A)");
        		textView2.setText("体积(V)");
        		textView3.setText("半径(r)");
        		textView4.setText("直径(d)");
        		textView5.setText("高(h)");
        	
        	editText1.setVisibility(View.VISIBLE);
        	editText2.setVisibility(View.VISIBLE);
        	editText3.setVisibility(View.VISIBLE);
        	editText4.setVisibility(View.VISIBLE);
        	editText5.setVisibility(View.VISIBLE);
        	editText6.setVisibility(View.GONE);
        	editText7.setVisibility(View.GONE);
        	editText8.setVisibility(View.GONE);
        	mPopupWindow.dismiss(); //响应点击事件之后关闭Menu 
        		break;
        	case R.id.JH1button7:
        		sign=17;
        		textView1.setVisibility(View.VISIBLE);
        		textView2.setVisibility(View.VISIBLE);
        		textView3.setVisibility(View.VISIBLE);
        		textView4.setVisibility(View.VISIBLE);
        		textView5.setVisibility(View.VISIBLE);
        		textView6.setVisibility(View.GONE);
        		textView7.setVisibility(View.GONE);
        		textView8.setVisibility(View.GONE);	
        		textView1.setText("面积(A)");
        		textView2.setText("体积(V)");
        		textView3.setText("Semi-axis(a)");
        		textView4.setText("Semi-axis(b)");
        		textView5.setText("Semi-axis(c)");
        	
        	editText1.setVisibility(View.VISIBLE);
        	editText2.setVisibility(View.VISIBLE);
        	editText3.setVisibility(View.VISIBLE);
        	editText4.setVisibility(View.VISIBLE);
        	editText5.setVisibility(View.VISIBLE);
        	editText6.setVisibility(View.GONE);
        	editText7.setVisibility(View.GONE);
        	editText8.setVisibility(View.GONE);
        	mPopupWindow.dismiss(); //响应点击事件之后关闭Menu 
        		break;
        	case R.id.JH1button8:
        		sign=18;
        		textView1.setVisibility(View.VISIBLE);
        		textView2.setVisibility(View.VISIBLE);
        		textView3.setVisibility(View.VISIBLE);
        		textView4.setVisibility(View.VISIBLE);
        		textView5.setVisibility(View.VISIBLE);
        		textView6.setVisibility(View.VISIBLE);
        		textView7.setVisibility(View.GONE);
        		textView8.setVisibility(View.GONE);	
        		textView1.setText("面积(A)");
        		textView2.setText("Base area(B)");
        		textView3.setText("体积 (V)");
        		textView4.setText("边数 (N)");
        		textView5.setText("边长 (a)");
        		textView6.setText("高 (h)");
        	editText1.setVisibility(View.VISIBLE);
        	editText2.setVisibility(View.VISIBLE);
        	editText3.setVisibility(View.VISIBLE);
        	editText4.setVisibility(View.VISIBLE);
        	editText5.setVisibility(View.VISIBLE);
        	editText6.setVisibility(View.VISIBLE);
        	editText7.setVisibility(View.GONE);
        	editText8.setVisibility(View.GONE);
        	mPopupWindow.dismiss(); //响应点击事件之后关闭Menu 
        		break;
        	case R.id.JH2button1:
        		sign=21;
        		textView1.setVisibility(View.VISIBLE);
        		textView2.setVisibility(View.VISIBLE);
        		textView3.setVisibility(View.VISIBLE);
        		textView4.setVisibility(View.VISIBLE);
        		textView5.setVisibility(View.VISIBLE);
        		textView6.setVisibility(View.VISIBLE);
        		textView7.setVisibility(View.GONE);
        		textView8.setVisibility(View.GONE);	
        		textView1.setText("面积(A)");
        		textView2.setText("边长(a)");
        		textView3.setText("边长(b)");
        		textView4.setText("边长(c)");
        		textView5.setText("a所对的角(α)[度]");
        		textView6.setText("b所对的角(β)[度]");
        	
        	editText1.setVisibility(View.VISIBLE);
        	editText2.setVisibility(View.VISIBLE);
        	editText3.setVisibility(View.VISIBLE);
        	editText4.setVisibility(View.VISIBLE);
        	editText5.setVisibility(View.VISIBLE);
        	editText6.setVisibility(View.VISIBLE);
        	editText7.setVisibility(View.GONE);
        	editText8.setVisibility(View.GONE);
        	mPopupWindow.dismiss(); //响应点击事件之后关闭Menu 
        		break;
        	case R.id.JH2button2:
        		sign=22;
        		textView1.setVisibility(View.VISIBLE);
        		textView2.setVisibility(View.VISIBLE);
        		textView3.setVisibility(View.VISIBLE);
        		textView4.setVisibility(View.VISIBLE);
        		textView5.setVisibility(View.VISIBLE);
        		textView6.setVisibility(View.VISIBLE);
        		textView7.setVisibility(View.VISIBLE);
        		textView8.setVisibility(View.GONE);	
        		textView1.setText("面积(A)");
        		textView2.setText("周长(P)");
        		textView3.setText("边长(a)");
        		textView4.setText("边长(b)");
        		textView5.setText("高(h)");
        		textView6.setText("a所对的角(α)[度]");
        		textView7.setText("b所对的角(β)[度]");
        		
        	editText1.setVisibility(View.VISIBLE);
        	editText2.setVisibility(View.VISIBLE);
        	editText3.setVisibility(View.VISIBLE);
        	editText4.setVisibility(View.VISIBLE);
        	editText5.setVisibility(View.VISIBLE);
        	editText6.setVisibility(View.VISIBLE);
        	editText7.setVisibility(View.VISIBLE);
        	editText8.setVisibility(View.GONE);
        	mPopupWindow.dismiss(); //响应点击事件之后关闭Menu 
        		break;
        	case R.id.JH2button3:
        		sign=23;
        		textView1.setVisibility(View.VISIBLE);
        		textView2.setVisibility(View.VISIBLE);
        		textView3.setVisibility(View.VISIBLE);
        		textView4.setVisibility(View.VISIBLE);
        		textView5.setVisibility(View.VISIBLE);
        		textView6.setVisibility(View.VISIBLE);
        		textView7.setVisibility(View.GONE);
        		textView8.setVisibility(View.GONE);	
        		textView1.setText("面积(A)");
        		textView2.setText("周长(P)");
        		textView3.setText("边长(a)");
        		textView4.setText("直径(p)");
        		textView5.setText("直径(q)");
        		textView6.setText("a所对的角(α)[度]");
        		
        	editText1.setVisibility(View.VISIBLE);
        	editText2.setVisibility(View.VISIBLE);
        	editText3.setVisibility(View.VISIBLE);
        	editText4.setVisibility(View.VISIBLE);
        	editText5.setVisibility(View.VISIBLE);
        	editText6.setVisibility(View.VISIBLE);
        	editText7.setVisibility(View.GONE);
        	editText8.setVisibility(View.GONE);
        	mPopupWindow.dismiss(); //响应点击事件之后关闭Menu 
        		break;
        	case R.id.JH2button4:
        		sign=24;
        		textView1.setVisibility(View.VISIBLE);
        		textView2.setVisibility(View.VISIBLE);
        		textView3.setVisibility(View.VISIBLE);
        		textView4.setVisibility(View.VISIBLE);
        		textView5.setVisibility(View.VISIBLE);
        		textView6.setVisibility(View.VISIBLE);
        		textView7.setVisibility(View.GONE);
        		textView8.setVisibility(View.GONE);	
        		textView1.setText("面积(A)");
        		textView2.setText("周长(P)");
        		textView3.setText("边长(a)");
        		textView4.setText("边长(b)");
        		textView5.setText("边长(c)");
        		textView6.setText("Side(d)");
        		
      		
        	editText1.setVisibility(View.VISIBLE);
        	editText2.setVisibility(View.VISIBLE);
        	editText3.setVisibility(View.VISIBLE);
        	editText4.setVisibility(View.VISIBLE);
        	editText5.setVisibility(View.VISIBLE);
        	editText6.setVisibility(View.VISIBLE);
        	editText7.setVisibility(View.GONE);
        	editText8.setVisibility(View.GONE);
        	mPopupWindow.dismiss(); //响应点击事件之后关闭Menu 
        		break;
        	case R.id.JH2button5:
        		sign=25;
        		textView1.setVisibility(View.VISIBLE);
        		textView2.setVisibility(View.VISIBLE);
        		textView3.setVisibility(View.VISIBLE);
        		textView4.setVisibility(View.VISIBLE);
        		textView5.setVisibility(View.VISIBLE);
        		textView6.setVisibility(View.VISIBLE);
        		textView7.setVisibility(View.GONE);
        		textView8.setVisibility(View.GONE);	
        		textView1.setText("面积(A)");
        		textView2.setText("周长(P)");
        		textView3.setText("边长(a)");
        		textView4.setText("边长(b)");
        		textView5.setText("高(h)");
        		textView6.setText("a所对的角(α)[度]");
        		
        		
        	editText1.setVisibility(View.VISIBLE);
        	editText2.setVisibility(View.VISIBLE);
        	editText3.setVisibility(View.VISIBLE);
        	editText4.setVisibility(View.VISIBLE);
        	editText5.setVisibility(View.VISIBLE);
        	editText6.setVisibility(View.VISIBLE);
        	editText7.setVisibility(View.GONE);
        	editText8.setVisibility(View.GONE);
        	mPopupWindow.dismiss(); //响应点击事件之后关闭Menu 
        		break;
        	case R.id.JH2button6:
        		sign=26;
        		textView1.setVisibility(View.VISIBLE);
        		textView2.setVisibility(View.VISIBLE);
        		textView3.setVisibility(View.VISIBLE);
        		textView4.setVisibility(View.VISIBLE);
        		textView5.setVisibility(View.GONE);
        		textView6.setVisibility(View.GONE);
        		textView7.setVisibility(View.GONE);
        		textView8.setVisibility(View.GONE);	
        		textView1.setText("面积(A)");
        		textView2.setText("体积 (V)");
        		textView3.setText("半径 (r)");
        		textView4.setText("直径 (d)");

        	editText1.setVisibility(View.VISIBLE);
        	editText2.setVisibility(View.VISIBLE);
        	editText3.setVisibility(View.VISIBLE);
        	editText4.setVisibility(View.VISIBLE);
        	editText5.setVisibility(View.GONE);
        	editText6.setVisibility(View.GONE);
        	editText7.setVisibility(View.GONE);
        	editText8.setVisibility(View.GONE);
        	mPopupWindow.dismiss(); //响应点击事件之后关闭Menu 
        		break;
        		
         	case R.id.JH2button7:
        		sign=27;
        		textView1.setVisibility(View.VISIBLE);
        		textView2.setVisibility(View.VISIBLE);
        		textView3.setVisibility(View.VISIBLE);
        		textView4.setVisibility(View.GONE);
        		textView5.setVisibility(View.GONE);
        		textView6.setVisibility(View.GONE);
        		textView7.setVisibility(View.GONE);
        		textView8.setVisibility(View.GONE);	
        		textView1.setText("面积(A)");
        		textView2.setText("体积(V)");
        		textView3.setText("边长(a)");

        	editText1.setVisibility(View.VISIBLE);
        	editText2.setVisibility(View.VISIBLE);
        	editText3.setVisibility(View.VISIBLE);
        	editText4.setVisibility(View.GONE);
        	editText5.setVisibility(View.GONE);
        	editText6.setVisibility(View.GONE);
        	editText7.setVisibility(View.GONE);
        	editText8.setVisibility(View.GONE);
        	mPopupWindow.dismiss(); //响应点击事件之后关闭Menu 
        		break;
          	case R.id.JH2button8:
        		sign=28;
        		textView1.setVisibility(View.VISIBLE);
        		textView2.setVisibility(View.VISIBLE);
        		textView3.setVisibility(View.VISIBLE);
        		textView4.setVisibility(View.VISIBLE);
        		textView5.setVisibility(View.VISIBLE);
        		textView6.setVisibility(View.GONE);
        		textView7.setVisibility(View.GONE);
        		textView8.setVisibility(View.GONE);	
        		textView1.setText("面积(A)");
        		textView2.setText("体积(V)");
        		textView3.setText("半径(r)");
        		textView4.setText("直径(d)");
        		textView5.setText("高(h)");
        	
        		
        	editText1.setVisibility(View.VISIBLE);
        	editText2.setVisibility(View.VISIBLE);
        	editText3.setVisibility(View.VISIBLE);
        	editText4.setVisibility(View.VISIBLE);
        	editText5.setVisibility(View.VISIBLE);
        	editText6.setVisibility(View.GONE);
        	editText7.setVisibility(View.GONE);
        	editText8.setVisibility(View.GONE);
        	mPopupWindow.dismiss(); //响应点击事件之后关闭Menu 
        		break;
        	case R.id.dian_jh:
if(editText1.hasFocus()){
	if (index_1 < 0 || index_1 >= edit1.length() ){
		edit1.append(".");
	}else{
		edit1.insert(index_1,".");//光标所在位置插入文字
	 }
    			}else if(editText2.hasFocus()){
    				if (index_2 < 0 || index_2 >= edit2.length() ){
    					edit2.append(".");
    				}else{
    					edit2.insert(index_2,".");//光标所在位置插入文字
    				 }
    			}else if(editText3.hasFocus()){
    				if (index_3 < 0 || index_3 >= edit3.length() ){
    					edit3.append(".");
    				}else{
    					edit3.insert(index_3,".");//光标所在位置插入文字
    				 }
    			}else if(editText4.hasFocus()){
    				if (index_4 < 0 || index_4 >= edit4.length() ){
    					edit4.append(".");
    				}else{
    					edit4.insert(index_4,".");//光标所在位置插入文字
    				 }
    			}else if(editText5.hasFocus()){
    				if (index_5 < 0 || index_5 >= edit5.length() ){
    					edit5.append(".");
    				}else{
    					edit5.insert(index_5,".");//光标所在位置插入文字
    				 }
    			}else if(editText6.hasFocus()){
    				if (index_6 < 0 || index_6 >= edit6.length() ){
    					edit6.append(".");
    				}else{
    					edit6.insert(index_6,".");//光标所在位置插入文字
    				 }
    			}else if(editText7.hasFocus()){
    				if (index_7 < 0 || index_7 >= edit7.length() ){
    					edit7.append(".");
    				}else{
    					edit7.insert(index_7,".");//光标所在位置插入文字
    				 }
    			}else if(editText8.hasFocus()){
    				if (index_8 < 0 || index_8 >= edit8.length() ){
    					edit8.append(".");
    				}else{
    					edit8.insert(index_8,".");//光标所在位置插入文字
    				 }
    			}
++index_1;
++index_2;
++index_3;
++index_4;
++index_5;
++index_6;
++index_7;
++index_8;
        		break;
        
        	case R.id.qingchu_jh:
if(editText1.hasFocus()){
	if(index_1==0){
		index_1=1;
	}else{
		edit1.delete(index_1-1, index_1);
	 }
    			}else if(editText2.hasFocus()){
    				if(index_2==0){
    					index_2=1;
    				}else{
    					edit2.delete(index_2-1, index_2);
    				 }
    				
    			}else if(editText3.hasFocus()){
    				if(index_3==0){
    					index_3=1;
    				}else{
    					edit3.delete(index_3-1, index_3);
    				 }
    				
    			}else if(editText4.hasFocus()){
    				if(index_4==0){
    					index_4=1;
    				}else{
    					edit4.delete(index_4-1, index_4);
    				 }
    				
    			}else if(editText5.hasFocus()){
    				if(index_5==0){
    					index_5=1;
    				}else{
    					edit5.delete(index_5-1, index_5);
    				 }
    				
    			}else if(editText6.hasFocus()){
    				if(index_6==0){
    					index_6=1;
    				}else{
    					edit6.delete(index_6-1, index_6);
    				 }
    				
    			}else if(editText7.hasFocus()){
    				if(index_7==0){
    					index_7=1;
    				}else{
    					edit7.delete(index_7-1, index_7);
    				 }
    				
    			}else if(editText8.hasFocus()){
    				if(index_8==0){
    					index_8=1;
    				}else{
    					edit8.delete(index_8-1, index_8);
    				 }   				
    			}
--index_1;
--index_2;
--index_3;
--index_4;
--index_5;
--index_6;
--index_7;
--index_8;
        		break;
        	case R.id.lin_jh:
        		if(editText1.hasFocus()){
        			if (index_1 < 0 || index_1 >= edit1.length() ){
        				edit1.append("0");
        			}else{
        				edit1.insert(index_1,"0");//光标所在位置插入文字
        			 }
        		    			}else if(editText2.hasFocus()){
        		    				if (index_2 < 0 || index_2 >= edit2.length() ){
        		    					edit2.append("0");
        		    				}else{
        		    					edit2.insert(index_2,"0");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText3.hasFocus()){
        		    				if (index_3 < 0 || index_3 >= edit3.length() ){
        		    					edit3.append("0");
        		    				}else{
        		    					edit3.insert(index_3,"0");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText4.hasFocus()){
        		    				if (index_4 < 0 || index_4 >= edit4.length() ){
        		    					edit4.append("0");
        		    				}else{
        		    					edit4.insert(index_4,"0");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText5.hasFocus()){
        		    				if (index_5 < 0 || index_5 >= edit5.length() ){
        		    					edit5.append("0");
        		    				}else{
        		    					edit5.insert(index_5,"0");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText6.hasFocus()){
        		    				if (index_6 < 0 || index_6 >= edit6.length() ){
        		    					edit6.append("0");
        		    				}else{
        		    					edit6.insert(index_6,"0");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText7.hasFocus()){
        		    				if (index_7 < 0 || index_7 >= edit7.length() ){
        		    					edit7.append("0");
        		    				}else{
        		    					edit7.insert(index_7,"0");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText8.hasFocus()){
        		    				if (index_8 < 0 || index_8 >= edit8.length() ){
        		    					edit8.append("0");
        		    				}else{
        		    					edit8.insert(index_8,"0");//光标所在位置插入文字
        		    				 }
        		    			}
        		++index_1;
        		++index_2;
        		++index_3;
        		++index_4;
        		++index_5;
        		++index_6;
        		++index_7;
        		++index_8;
        		break;
        	case R.id.yi_jh:
        		if(editText1.hasFocus()){
        			if (index_1 < 0 || index_1 >= edit1.length() ){
        				edit1.append("1");
        			}else{
        				edit1.insert(index_1,"1");//光标所在位置插入文字
        			 }
        		    			}else if(editText2.hasFocus()){
        		    				if (index_2 < 0 || index_2 >= edit2.length() ){
        		    					edit2.append("1");
        		    				}else{
        		    					edit2.insert(index_2,"1");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText3.hasFocus()){
        		    				if (index_3 < 0 || index_3 >= edit3.length() ){
        		    					edit3.append("1");
        		    				}else{
        		    					edit3.insert(index_3,"1");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText4.hasFocus()){
        		    				if (index_4 < 0 || index_4 >= edit4.length() ){
        		    					edit4.append("1");
        		    				}else{
        		    					edit4.insert(index_4,"1");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText5.hasFocus()){
        		    				if (index_5 < 0 || index_5 >= edit5.length() ){
        		    					edit5.append("1");
        		    				}else{
        		    					edit5.insert(index_5,"1");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText6.hasFocus()){
        		    				if (index_6 < 0 || index_6 >= edit6.length() ){
        		    					edit6.append("1");
        		    				}else{
        		    					edit6.insert(index_6,"1");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText7.hasFocus()){
        		    				if (index_7 < 0 || index_7 >= edit7.length() ){
        		    					edit7.append("1");
        		    				}else{
        		    					edit7.insert(index_7,"1");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText8.hasFocus()){
        		    				if (index_8 < 0 || index_8 >= edit8.length() ){
        		    					edit8.append("1");
        		    				}else{
        		    					edit8.insert(index_8,"1");//光标所在位置插入文字
        		    				 }
        		    			}
        		++index_1;
        		++index_2;
        		++index_3;
        		++index_4;
        		++index_5;
        		++index_6;
        		++index_7;
        		++index_8;
        		break;
        	case R.id.er_jh:
        		if(editText1.hasFocus()){
        			if (index_1 < 0 || index_1 >= edit1.length() ){
        				edit1.append("2");
        			}else{
        				edit1.insert(index_1,"2");//光标所在位置插入文字
        			 }
        		    			}else if(editText2.hasFocus()){
        		    				if (index_2 < 0 || index_2 >= edit2.length() ){
        		    					edit2.append("2");
        		    				}else{
        		    					edit2.insert(index_2,"2");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText3.hasFocus()){
        		    				if (index_3 < 0 || index_3 >= edit3.length() ){
        		    					edit3.append("2");
        		    				}else{
        		    					edit3.insert(index_3,"2");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText4.hasFocus()){
        		    				if (index_4 < 0 || index_4 >= edit4.length() ){
        		    					edit4.append("2");
        		    				}else{
        		    					edit4.insert(index_4,"2");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText5.hasFocus()){
        		    				if (index_5 < 0 || index_5 >= edit5.length() ){
        		    					edit5.append("2");
        		    				}else{
        		    					edit5.insert(index_5,"2");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText6.hasFocus()){
        		    				if (index_6 < 0 || index_6 >= edit6.length() ){
        		    					edit6.append("2");
        		    				}else{
        		    					edit6.insert(index_6,"2");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText7.hasFocus()){
        		    				if (index_7 < 0 || index_7 >= edit7.length() ){
        		    					edit7.append("2");
        		    				}else{
        		    					edit7.insert(index_7,"2");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText8.hasFocus()){
        		    				if (index_8 < 0 || index_8 >= edit8.length() ){
        		    					edit8.append("2");
        		    				}else{
        		    					edit8.insert(index_8,"2");//光标所在位置插入文字
        		    				 }
        		    			}
        		++index_1;
        		++index_2;
        		++index_3;
        		++index_4;
        		++index_5;
        		++index_6;
        		++index_7;
        		++index_8;
        		break;
        	case R.id.san_jh:
        		if(editText1.hasFocus()){
        			if (index_1 < 0 || index_1 >= edit1.length() ){
        				edit1.append("3");
        			}else{
        				edit1.insert(index_1,"3");//光标所在位置插入文字
        			 }
        		    			}else if(editText2.hasFocus()){
        		    				if (index_2 < 0 || index_2 >= edit2.length() ){
        		    					edit2.append("3");
        		    				}else{
        		    					edit2.insert(index_2,"3");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText3.hasFocus()){
        		    				if (index_3 < 0 || index_3 >= edit3.length() ){
        		    					edit3.append("3");
        		    				}else{
        		    					edit3.insert(index_3,"3");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText4.hasFocus()){
        		    				if (index_4 < 0 || index_4 >= edit4.length() ){
        		    					edit4.append("3");
        		    				}else{
        		    					edit4.insert(index_4,"3");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText5.hasFocus()){
        		    				if (index_5 < 0 || index_5 >= edit5.length() ){
        		    					edit5.append("3");
        		    				}else{
        		    					edit5.insert(index_5,"3");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText6.hasFocus()){
        		    				if (index_6 < 0 || index_6 >= edit6.length() ){
        		    					edit6.append("3");
        		    				}else{
        		    					edit6.insert(index_6,"3");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText7.hasFocus()){
        		    				if (index_7 < 0 || index_7 >= edit7.length() ){
        		    					edit7.append("3");
        		    				}else{
        		    					edit7.insert(index_7,"3");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText8.hasFocus()){
        		    				if (index_8 < 0 || index_8 >= edit8.length() ){
        		    					edit8.append("3");
        		    				}else{
        		    					edit8.insert(index_8,"3");//光标所在位置插入文字
        		    				 }
        		    			}
        		++index_1;
        		++index_2;
        		++index_3;
        		++index_4;
        		++index_5;
        		++index_6;
        		++index_7;
        		++index_8;
        		break;
        	case R.id.si_jh:
        		if(editText1.hasFocus()){
        			if (index_1 < 0 || index_1 >= edit1.length() ){
        				edit1.append("4");
        			}else{
        				edit1.insert(index_1,"4");//光标所在位置插入文字
        			 }
        		    			}else if(editText2.hasFocus()){
        		    				if (index_2 < 0 || index_2 >= edit2.length() ){
        		    					edit2.append("4");
        		    				}else{
        		    					edit2.insert(index_2,"4");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText3.hasFocus()){
        		    				if (index_3 < 0 || index_3 >= edit3.length() ){
        		    					edit3.append("4");
        		    				}else{
        		    					edit3.insert(index_3,"4");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText4.hasFocus()){
        		    				if (index_4 < 0 || index_4 >= edit4.length() ){
        		    					edit4.append("4");
        		    				}else{
        		    					edit4.insert(index_4,"4");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText5.hasFocus()){
        		    				if (index_5 < 0 || index_5 >= edit5.length() ){
        		    					edit5.append("4");
        		    				}else{
        		    					edit5.insert(index_5,"4");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText6.hasFocus()){
        		    				if (index_6 < 0 || index_6 >= edit6.length() ){
        		    					edit6.append("4");
        		    				}else{
        		    					edit6.insert(index_6,"4");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText7.hasFocus()){
        		    				if (index_7 < 0 || index_7 >= edit7.length() ){
        		    					edit7.append("4");
        		    				}else{
        		    					edit7.insert(index_7,"4");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText8.hasFocus()){
        		    				if (index_8 < 0 || index_8 >= edit8.length() ){
        		    					edit8.append("4");
        		    				}else{
        		    					edit8.insert(index_8,"4");//光标所在位置插入文字
        		    				 }
        		    			}
        		++index_1;
        		++index_2;
        		++index_3;
        		++index_4;
        		++index_5;
        		++index_6;
        		++index_7;
        		++index_8;
        		break;
        	case R.id.wu_jh:
        		if(editText1.hasFocus()){
        			if (index_1 < 0 || index_1 >= edit1.length() ){
        				edit1.append("5");
        			}else{
        				edit1.insert(index_1,"5");//光标所在位置插入文字
        			 }
        		    			}else if(editText2.hasFocus()){
        		    				if (index_2 < 0 || index_2 >= edit2.length() ){
        		    					edit2.append("5");
        		    				}else{
        		    					edit2.insert(index_2,"5");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText3.hasFocus()){
        		    				if (index_3 < 0 || index_3 >= edit3.length() ){
        		    					edit3.append("5");
        		    				}else{
        		    					edit3.insert(index_3,"5");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText4.hasFocus()){
        		    				if (index_4 < 0 || index_4 >= edit4.length() ){
        		    					edit4.append("5");
        		    				}else{
        		    					edit4.insert(index_4,"5");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText5.hasFocus()){
        		    				if (index_5 < 0 || index_5 >= edit5.length() ){
        		    					edit5.append("5");
        		    				}else{
        		    					edit5.insert(index_5,"5");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText6.hasFocus()){
        		    				if (index_6 < 0 || index_6 >= edit6.length() ){
        		    					edit6.append("5");
        		    				}else{
        		    					edit6.insert(index_6,"5");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText7.hasFocus()){
        		    				if (index_7 < 0 || index_7 >= edit7.length() ){
        		    					edit7.append("5");
        		    				}else{
        		    					edit7.insert(index_7,"5");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText8.hasFocus()){
        		    				if (index_8 < 0 || index_8 >= edit8.length() ){
        		    					edit8.append("5");
        		    				}else{
        		    					edit8.insert(index_8,"5");//光标所在位置插入文字
        		    				 }
        		    			}
        		++index_1;
        		++index_2;
        		++index_3;
        		++index_4;
        		++index_5;
        		++index_6;
        		++index_7;
        		++index_8;
        		break;
        	case R.id.liu_jh:
        		if(editText1.hasFocus()){
        			if (index_1 < 0 || index_1 >= edit1.length() ){
        				edit1.append("6");
        			}else{
        				edit1.insert(index_1,"6");//光标所在位置插入文字
        			 }
        		    			}else if(editText2.hasFocus()){
        		    				if (index_2 < 0 || index_2 >= edit2.length() ){
        		    					edit2.append("6");
        		    				}else{
        		    					edit2.insert(index_2,"6");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText3.hasFocus()){
        		    				if (index_3 < 0 || index_3 >= edit3.length() ){
        		    					edit3.append("6");
        		    				}else{
        		    					edit3.insert(index_3,"6");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText4.hasFocus()){
        		    				if (index_4 < 0 || index_4 >= edit4.length() ){
        		    					edit4.append("6");
        		    				}else{
        		    					edit4.insert(index_4,"6");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText5.hasFocus()){
        		    				if (index_5 < 0 || index_5 >= edit5.length() ){
        		    					edit5.append("6");
        		    				}else{
        		    					edit5.insert(index_5,"6");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText6.hasFocus()){
        		    				if (index_6 < 0 || index_6 >= edit6.length() ){
        		    					edit6.append("6");
        		    				}else{
        		    					edit6.insert(index_6,"6");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText7.hasFocus()){
        		    				if (index_7 < 0 || index_7 >= edit7.length() ){
        		    					edit7.append("6");
        		    				}else{
        		    					edit7.insert(index_7,"6");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText8.hasFocus()){
        		    				if (index_8 < 0 || index_8 >= edit8.length() ){
        		    					edit8.append("6");
        		    				}else{
        		    					edit8.insert(index_8,"6");//光标所在位置插入文字
        		    				 }
        		    			}
        		++index_1;
        		++index_2;
        		++index_3;
        		++index_4;
        		++index_5;
        		++index_6;
        		++index_7;
        		++index_8;
        		break;
        	case R.id.qi_jh:
        		if(editText1.hasFocus()){
        			if (index_1 < 0 || index_1 >= edit1.length() ){
        				edit1.append("7");
        			}else{
        				edit1.insert(index_1,"7");//光标所在位置插入文字
        			 }
        		    			}else if(editText2.hasFocus()){
        		    				if (index_2 < 0 || index_2 >= edit2.length() ){
        		    					edit2.append("7");
        		    				}else{
        		    					edit2.insert(index_2,"7");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText3.hasFocus()){
        		    				if (index_3 < 0 || index_3 >= edit3.length() ){
        		    					edit3.append("7");
        		    				}else{
        		    					edit3.insert(index_3,"7");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText4.hasFocus()){
        		    				if (index_4 < 0 || index_4 >= edit4.length() ){
        		    					edit4.append("7");
        		    				}else{
        		    					edit4.insert(index_4,"7");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText5.hasFocus()){
        		    				if (index_5 < 0 || index_5 >= edit5.length() ){
        		    					edit5.append("7");
        		    				}else{
        		    					edit5.insert(index_5,"7");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText6.hasFocus()){
        		    				if (index_6 < 0 || index_6 >= edit6.length() ){
        		    					edit6.append("7");
        		    				}else{
        		    					edit6.insert(index_6,"7");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText7.hasFocus()){
        		    				if (index_7 < 0 || index_7 >= edit7.length() ){
        		    					edit7.append("7");
        		    				}else{
        		    					edit7.insert(index_7,"7");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText8.hasFocus()){
        		    				if (index_8 < 0 || index_8 >= edit8.length() ){
        		    					edit8.append("7");
        		    				}else{
        		    					edit8.insert(index_8,"7");//光标所在位置插入文字
        		    				 }
        		    			}
        		++index_1;
        		++index_2;
        		++index_3;
        		++index_4;
        		++index_5;
        		++index_6;
        		++index_7;
        		++index_8;
        		break;
        	case R.id.ba_jh:
        		if(editText1.hasFocus()){
        			if (index_1 < 0 || index_1 >= edit1.length() ){
        				edit1.append("8");
        			}else{
        				edit1.insert(index_1,"8");//光标所在位置插入文字
        			 }
        		    			}else if(editText2.hasFocus()){
        		    				if (index_2 < 0 || index_2 >= edit2.length() ){
        		    					edit2.append("8");
        		    				}else{
        		    					edit2.insert(index_2,"8");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText3.hasFocus()){
        		    				if (index_3 < 0 || index_3 >= edit3.length() ){
        		    					edit3.append("8");
        		    				}else{
        		    					edit3.insert(index_3,"8");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText4.hasFocus()){
        		    				if (index_4 < 0 || index_4 >= edit4.length() ){
        		    					edit4.append("8");
        		    				}else{
        		    					edit4.insert(index_4,"8");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText5.hasFocus()){
        		    				if (index_5 < 0 || index_5 >= edit5.length() ){
        		    					edit5.append("8");
        		    				}else{
        		    					edit5.insert(index_5,"8");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText6.hasFocus()){
        		    				if (index_6 < 0 || index_6 >= edit6.length() ){
        		    					edit6.append("8");
        		    				}else{
        		    					edit6.insert(index_6,"8");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText7.hasFocus()){
        		    				if (index_7 < 0 || index_7 >= edit7.length() ){
        		    					edit7.append("8");
        		    				}else{
        		    					edit7.insert(index_7,"8");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText8.hasFocus()){
        		    				if (index_8 < 0 || index_8 >= edit8.length() ){
        		    					edit8.append("8");
        		    				}else{
        		    					edit8.insert(index_8,"8");//光标所在位置插入文字
        		    				 }
        		    			}
        		++index_1;
        		++index_2;
        		++index_3;
        		++index_4;
        		++index_5;
        		++index_6;
        		++index_7;
        		++index_8;
        		break;
        	case R.id.jiu_jh:
        		if(editText1.hasFocus()){
        			if (index_1 < 0 || index_1 >= edit1.length() ){
        				edit1.append("9");
        			}else{
        				edit1.insert(index_1,"9");//光标所在位置插入文字
        			 }
        		    			}else if(editText2.hasFocus()){
        		    				if (index_2 < 0 || index_2 >= edit2.length() ){
        		    					edit2.append("9");
        		    				}else{
        		    					edit2.insert(index_2,"9");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText3.hasFocus()){
        		    				if (index_3 < 0 || index_3 >= edit3.length() ){
        		    					edit3.append("9");
        		    				}else{
        		    					edit3.insert(index_3,"9");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText4.hasFocus()){
        		    				if (index_4 < 0 || index_4 >= edit4.length() ){
        		    					edit4.append("9");
        		    				}else{
        		    					edit4.insert(index_4,"9");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText5.hasFocus()){
        		    				if (index_5 < 0 || index_5 >= edit5.length() ){
        		    					edit5.append("9");
        		    				}else{
        		    					edit5.insert(index_5,"9");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText6.hasFocus()){
        		    				if (index_6 < 0 || index_6 >= edit6.length() ){
        		    					edit6.append("9");
        		    				}else{
        		    					edit6.insert(index_6,"9");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText7.hasFocus()){
        		    				if (index_7 < 0 || index_7 >= edit7.length() ){
        		    					edit7.append("9");
        		    				}else{
        		    					edit7.insert(index_7,"9");//光标所在位置插入文字
        		    				 }
        		    			}else if(editText8.hasFocus()){
        		    				if (index_8 < 0 || index_8 >= edit8.length() ){
        		    					edit8.append("9");
        		    				}else{
        		    					edit8.insert(index_8,"9");//光标所在位置插入文字
        		    				 }
        		    			}
        		++index_1;
        		++index_2;
        		++index_3;
        		++index_4;
        		++index_5;
        		++index_6;
        		++index_7;
        		++index_8;
        		break;
        	case R.id.quanshan_jh:
        		
	        		editText1.setText("");
	        		index_1=0;
	    			editText2.setText("");
	        		index_2=0;	
	    			editText3.setText("");
	        		index_3=0;		
	    			editText4.setText("");
	        		index_4=0;  	
	    			editText5.setText("");
	        		index_5=0;   	
	    			editText6.setText("");
	        		index_6=0;    		
	    			editText7.setText("");
	        		index_7=0;    		
	    			editText8.setText("");
	        		index_8=0;
	    	
        		break;
        		//jisuan
        	case R.id.jisuan_jh:
        		//赋值
            	if(sign ==11){
            		try{
            		if( editText1.getText().toString().equals(""))
            		A=0;else
            		A=Double.parseDouble( editText1.getText().toString());
            		if(editText2.getText().toString().equals(""))
            		P=0;else
            		P=Double.parseDouble( editText2.getText().toString());
            		if(editText3.getText().toString().equals(""))
            		N=0;else
            		N=Double.parseDouble( editText3.getText().toString());
            		if(editText4.getText().toString().equals(""))
            		a=0;else
            		a=Double.parseDouble( editText4.getText().toString());
            		if(editText5.getText().toString().equals(""))
            		alpha=0;else            	
            		alpha=Math.toRadians(Double.parseDouble( editText5.getText().toString()));
            		}catch(Exception e){Toast.makeText(getActivity(), "输入有误！", Toast.LENGTH_SHORT).show();}
            		ZNBX();
            		ZNBXtext();
            	}
            	else if(sign ==12){
            		try{
                		if( editText1.getText().toString().equals(""))
                		A=0;else
                		A=Double.parseDouble( editText1.getText().toString());
                		if(editText2.getText().toString().equals(""))
                		P=0;else
                		P=Double.parseDouble( editText2.getText().toString());
                		if(editText3.getText().toString().equals(""))
                		a=0;else
                		a=Double.parseDouble( editText3.getText().toString());
                		if(editText4.getText().toString().equals(""))
                		b=0;else
                		b=Double.parseDouble( editText4.getText().toString());
                		if(editText5.getText().toString().equals(""))
                		c=0;else
                	    c=Double.parseDouble( editText5.getText().toString());
                		if(editText6.getText().toString().equals(""))
                    		alpha=0;else
                    		alpha=Math.toRadians(Double.parseDouble( editText6.getText().toString()));
                    		if(editText7.getText().toString().equals(""))
                    		beta=0;else
                    		beta=Math.toRadians(Double.parseDouble( editText7.getText().toString()));
                    		if(editText8.getText().toString().equals(""))
                    		gamma=0;else
                    		gamma=Math.toRadians(Double.parseDouble( editText8.getText().toString()));
                		}catch(Exception e){Toast.makeText(getActivity(), "输入有误！", Toast.LENGTH_SHORT).show();}
            			RYSJX();
                		RYSJXtext();
            	}
            	else if(sign ==13){
            		try{
                		if( editText1.getText().toString().equals(""))
                		A=0;else
                		A=Double.parseDouble( editText1.getText().toString());
                		if(editText2.getText().toString().equals(""))
                		C=0;else
                		C=Double.parseDouble( editText2.getText().toString());
                		if(editText3.getText().toString().equals(""))
                		d=0;else
                		d=Double.parseDouble( editText3.getText().toString());
                		if(editText4.getText().toString().equals(""))
                			
                		r=0;else
                		r=Double.parseDouble( editText4.getText().toString());
                		
                		}catch(Exception e){Toast.makeText(getActivity(), "输入有误！", Toast.LENGTH_SHORT).show();}
                		YUAN();
                		YUANtext();
            	}
            	else if(sign==14){
            		try{
                		if( editText1.getText().toString().equals(""))
                		A=0;else
                		A=Double.parseDouble( editText1.getText().toString());
                		if(editText2.getText().toString().equals(""))
                		p=0;else
                		p=Double.parseDouble( editText2.getText().toString());
                		if(editText3.getText().toString().equals(""))
                		q=0;else
                		q=Double.parseDouble( editText3.getText().toString());
                		if(editText4.getText().toString().equals(""))
                			
                		C=0;else
                		C=Double.parseDouble( editText4.getText().toString());
                		
                		}catch(Exception e){Toast.makeText(getActivity(), "输入有误！", Toast.LENGTH_SHORT).show();}
            		TUOYUAN();
            		TUOYUANtext();
            	}
            	else if(sign==15){
            		try{
                		if( editText1.getText().toString().equals(""))
                		A=0;else
                		A=Double.parseDouble( editText1.getText().toString());
                		if(editText2.getText().toString().equals(""))
                		P=0;else
                		P=Double.parseDouble( editText2.getText().toString());
                		if(editText3.getText().toString().equals(""))
                		a=0;else
                		a=Double.parseDouble( editText3.getText().toString());
                		if(editText4.getText().toString().equals(""))
                			
                		h=0;else
                		h=Double.parseDouble( editText4.getText().toString());
                		
                		}catch(Exception e){Toast.makeText(getActivity(), "输入有误！", Toast.LENGTH_SHORT).show();}
            		ZHENGSANJIAOXING();
            		ZHENGSANJIAOXINGtext();
            	}
            	else if(sign ==16){
            		try{
                		if( editText1.getText().toString().equals(""))
                		A=0;else
                		A=Double.parseDouble( editText1.getText().toString());
                		if(editText2.getText().toString().equals(""))
                		V=0;else
                		V=Double.parseDouble( editText2.getText().toString());
                		if(editText3.getText().toString().equals(""))
                		r=0;else
                		r=Double.parseDouble( editText3.getText().toString());
                		if(editText4.getText().toString().equals(""))
                			
                		d=0;else
                		d=Double.parseDouble( editText4.getText().toString());
                		if(editText5.getText().toString().equals(""))
                			
                    		h=0;else
                    		h=Double.parseDouble( editText5.getText().toString());
                		
                		}catch(Exception e){Toast.makeText(getActivity(), "输入有误！", Toast.LENGTH_SHORT).show();}
            		ZHUITI();
            		ZHUITItext();
            	}
else if(sign ==17){
	try{
		if( editText1.getText().toString().equals(""))
		A=0;else
		A=Double.parseDouble( editText1.getText().toString());
		if(editText2.getText().toString().equals(""))
		V=0;else
		V=Double.parseDouble( editText2.getText().toString());
		if(editText3.getText().toString().equals(""))
		a=0;else
		a=Double.parseDouble( editText3.getText().toString());
		if(editText4.getText().toString().equals(""))
			
		b=0;else
		b=Double.parseDouble( editText4.getText().toString());
		if(editText5.getText().toString().equals(""))
			
    		c=0;else
    		c=Double.parseDouble( editText5.getText().toString());
		
		}catch(Exception e){Toast.makeText(getActivity(), "输入有误！", Toast.LENGTH_SHORT).show();}
	TUOQIU();
	TUOQIUtext();
            	}
else if(sign ==18){
	try{
		if( editText1.getText().toString().equals(""))
		A=0;else
		A=Double.parseDouble( editText1.getText().toString());
		if(editText2.getText().toString().equals(""))
		B=0;else
		B=Double.parseDouble( editText2.getText().toString());
		if(editText3.getText().toString().equals(""))
		V=0;else
		V=Double.parseDouble( editText3.getText().toString());
		if(editText4.getText().toString().equals(""))
			
		N=0;else
		N=Double.parseDouble( editText4.getText().toString());
		if(editText5.getText().toString().equals(""))
			
    		a=0;else
    		a=Double.parseDouble( editText5.getText().toString());
		
if(editText6.getText().toString().equals(""))
			
    		h=0;else
    		h=Double.parseDouble( editText6.getText().toString());
		
		}catch(Exception e){Toast.makeText(getActivity(), "输入有误！", Toast.LENGTH_SHORT).show();}
	ZHUITI();
	ZHUITItext();
}
            	else if(sign ==21){
            		try{
                		if( editText1.getText().toString().equals(""))
                		A=0;else
                		A=Double.parseDouble( editText1.getText().toString());
                		if(editText2.getText().toString().equals(""))
                		a=0;else
                		a=Double.parseDouble( editText2.getText().toString());
                		if(editText3.getText().toString().equals(""))
                		b=0;else
                		b=Double.parseDouble( editText3.getText().toString());
                		if(editText4.getText().toString().equals(""))
                			
                		c=0;else
                		c=Double.parseDouble( editText4.getText().toString());
                		if(editText5.getText().toString().equals(""))
                			
                    		alpha=0;else
                    			alpha=Double.parseDouble( editText5.getText().toString());
                		if(editText6.getText().toString().equals(""))
                			
                    		beta=0;else
                    		beta=Double.parseDouble( editText6.getText().toString());
                		
                		}catch(Exception e){Toast.makeText(getActivity(), "输入有误！", Toast.LENGTH_SHORT).show();}
            		ZHIJIAOSANJIAOXING();
            		ZHIJIAOSANJIAOXINGtext();
            		
            	}
            	else if(sign==22){
            		try{
                		if( editText1.getText().toString().equals(""))
                		A=0;else
                		A=Double.parseDouble( editText1.getText().toString());
                		if( editText2.getText().toString().equals(""))
                    		P=0;else
                    		P=Double.parseDouble( editText2.getText().toString());
                		if(editText3.getText().toString().equals(""))
                		a=0;else
                		a=Double.parseDouble( editText3.getText().toString());
                		if(editText4.getText().toString().equals(""))
                		b=0;else
                		b=Double.parseDouble( editText4.getText().toString());
                		if(editText5.getText().toString().equals(""))
                			
                		h=0;else
                		h=Double.parseDouble( editText5.getText().toString());
                		if(editText6.getText().toString().equals(""))
                			
                    		alpha=0;else
                    			alpha=Double.parseDouble( editText6.getText().toString());
                		if(editText7.getText().toString().equals(""))
                			
                    		beta=0;else
                    		beta=Double.parseDouble( editText7.getText().toString());
                		
                		}catch(Exception e){Toast.makeText(getActivity(), "输入有误！", Toast.LENGTH_SHORT).show();}
            		DENGYAOSANJIAOXING();
            		DENGYAOSANJIAOXINGtext();
            	}
            	else if(sign==23){
            		try{
                		if( editText1.getText().toString().equals(""))
                		A=0;else
                		A=Double.parseDouble( editText1.getText().toString());
                		if( editText2.getText().toString().equals(""))
                    		P=0;else
                    		P=Double.parseDouble( editText2.getText().toString());
                		if(editText3.getText().toString().equals(""))
                		a=0;else
                		a=Double.parseDouble( editText3.getText().toString());
                		if(editText4.getText().toString().equals(""))
                		p=0;else
                		p=Double.parseDouble( editText4.getText().toString());
                		if(editText5.getText().toString().equals(""))
                			
                		q=0;else
                		q=Double.parseDouble( editText5.getText().toString());
                		if(editText6.getText().toString().equals(""))
                			
                    		alpha=0;else
                    			alpha=Double.parseDouble( editText6.getText().toString());
                		
                		
                		}catch(Exception e){Toast.makeText(getActivity(), "输入有误！", Toast.LENGTH_SHORT).show();}
            		LINGXING();
            		LINGXINGtext();
            	}
            	else if(sign==24){
            		try{
                		if( editText1.getText().toString().equals(""))
                		A=0;else
                		A=Double.parseDouble( editText1.getText().toString());
                		if( editText2.getText().toString().equals(""))
                    		P=0;else
                    		P=Double.parseDouble( editText2.getText().toString());
                		if(editText3.getText().toString().equals(""))
                		a=0;else
                		a=Double.parseDouble( editText3.getText().toString());
                		if(editText4.getText().toString().equals(""))
                		b=0;else
                		b=Double.parseDouble( editText4.getText().toString());
                		if(editText5.getText().toString().equals(""))
                			
                		c=0;else
                		c=Double.parseDouble( editText5.getText().toString());
                		if(editText6.getText().toString().equals(""))
                			
                    		d=0;else
                    			d=Double.parseDouble( editText6.getText().toString());
                		
                		
                		}catch(Exception e){Toast.makeText(getActivity(), "输入有误！", Toast.LENGTH_SHORT).show();}
            		TIXING();
            		TIXINGtext();
            	}
            	else if(sign==25){
            		try{
                		if( editText1.getText().toString().equals(""))
                		A=0;else
                		A=Double.parseDouble( editText1.getText().toString());
                		if( editText2.getText().toString().equals(""))
                    		P=0;else
                    		P=Double.parseDouble( editText2.getText().toString());
                		if(editText3.getText().toString().equals(""))
                		a=0;else
                		a=Double.parseDouble( editText3.getText().toString());
                		if(editText4.getText().toString().equals(""))
                		b=0;else
                		b=Double.parseDouble( editText4.getText().toString());
                		if(editText5.getText().toString().equals(""))
                			
                		h=0;else
                		h=Double.parseDouble( editText5.getText().toString());
                		if(editText6.getText().toString().equals(""))
                			
                    		alpha=0;else
                    			alpha=Double.parseDouble( editText6.getText().toString());
                		
                		
                		}catch(Exception e){Toast.makeText(getActivity(), "输入有误！", Toast.LENGTH_SHORT).show();}
            		PINGXINGSIBIANXING();
            		PINGXINGSIBIANXINGtext();
            	}
            	else if(sign ==26){
            		try{
                		if( editText1.getText().toString().equals(""))
                		A=0;else
                		A=Double.parseDouble( editText1.getText().toString());
                		if( editText2.getText().toString().equals(""))
                    		V=0;else
                    		V=Double.parseDouble( editText2.getText().toString());
                		if(editText3.getText().toString().equals(""))
                		r=0;else
                		r=Double.parseDouble( editText3.getText().toString());
                		if(editText4.getText().toString().equals(""))
                		d=0;else
                		d=Double.parseDouble( editText4.getText().toString());
                		
                		
                		
                		}catch(Exception e){Toast.makeText(getActivity(), "输入有误！", Toast.LENGTH_SHORT).show();}
            		QIU();
            		QIUtext();
            	}
            	else if(sign ==27){
            		try{
                		if( editText1.getText().toString().equals(""))
                		A=0;else
                		A=Double.parseDouble( editText1.getText().toString());
                		if( editText2.getText().toString().equals(""))
                    		V=0;else
                    		V=Double.parseDouble( editText2.getText().toString());
                		if(editText3.getText().toString().equals(""))
                		a=0;else
                		a=Double.parseDouble( editText3.getText().toString());
                		
                		
                		
                		
                		}catch(Exception e){Toast.makeText(getActivity(), "输入有误！", Toast.LENGTH_SHORT).show();}
            		SIMIANTI();
            		SIMIANTItext();
            	}
            	else if(sign ==28){
            		try{
                		if( editText1.getText().toString().equals(""))
                		A=0;else
                		A=Double.parseDouble( editText1.getText().toString());
                		if( editText2.getText().toString().equals(""))
                    		V=0;else
                    		V=Double.parseDouble( editText2.getText().toString());
                		if(editText3.getText().toString().equals(""))
                		r=0;else
                		r=Double.parseDouble( editText3.getText().toString());
                		if(editText4.getText().toString().equals(""))
                		d=0;else
                		d=Double.parseDouble( editText4.getText().toString());
                		if(editText5.getText().toString().equals(""))
                			
                		h=0;else
                		h=Double.parseDouble( editText5.getText().toString());

                		}catch(Exception e){Toast.makeText(getActivity(), "输入有误！", Toast.LENGTH_SHORT).show();}
            		YUANZHU();
            		YUANZHUtext();
            	}
        		
        		break;
        }
        	if(editText1.hasFocus()){
        		editText1.setSelection(index_1);
    			
    		}else if(editText2.hasFocus()){
    			editText2.setSelection(index_2);
    		}
    		else if(editText3.hasFocus()){
    			editText3.setSelection(index_3);
    		}
    		else if(editText4.hasFocus()){
    			editText4.setSelection(index_4);
    		}
    		else if(editText5.hasFocus()){
    			editText5.setSelection(index_5);
    		}
    		else if(editText6.hasFocus()){
    			editText6.setSelection(index_6);
    		}
    		else if(editText7.hasFocus()){
    			editText7.setSelection(index_7);
    		}
    		else if(editText8.hasFocus()){
    			editText8.setSelection(index_8);
    		}
        
        	
        	
        }
        
//算正n变形
        public  void ZNBX(){
        	
        	if(N!=0&&alpha==0)
        	{
        		
        		alpha=(N-2)*Math.PI/N ;
        		ZNBX();
        	}
     	
        	else if(P!=0&&a!=0&&alpha==0){
        		
        		alpha=(P/a-2)*Math.PI/(P/a);
        		ZNBX();
        		}

        	else if(A!=0&&N!=0&&a==0)
        	{
        	
        		a=Math.sqrt(4*A/((Math.cos(Math.PI/N)/Math.sin(Math.PI/N))*N));
        	
        		ZNBX();
        		}
    	
        	else if(P!=0&&N!=0&&a==0){
        		
        		a=P/N;
        		
        		ZNBX();
        	}
      	
        	else
        	if(N!=0&&a!=0&&P==0)
        	{
        	
        		P=N*a;
        		ZNBX();
        		}
       	
        	else
        	if(N!=0&&a!=0&&A==0){
        	
        		A=N*Math.pow(a, 2)*Math.cos(Math.PI/N)/(4*Math.sin(Math.PI/N));
        		ZNBX();
        	}
        	else
        	if(alpha!=0&&N==0){
        		
        		N=-2*(Math.PI)/(alpha-(Math.PI));
        	
        		ZNBX();
        	}
        	
       	else if
        	(P!=0&&a!=0&&N==0){
        		
        		N=P/a;
        		ZNBX();
        		
        	}
            	
        	}
        
         void ZNBXtext(){      	
        	 if(A==0||P==0||a==0||N==0||alpha==0){ Toast.makeText(getActivity(), "数据不够！无法计算！", Toast.LENGTH_SHORT).show();return;}
         	
         	else{
        		alpha_text=(N-2)*Math.PI/N ;  	
        	//	alpha=(P/a-2)*Math.PI/(P/a);   
        	//	a=Math.sqrt(4*A/((Math.cos(Math.PI/N)/Math.sin(Math.PI/N))*N)); 
        		a_text=P/N;
        		P_text=N*a;  	
        		A_text=N*Math.pow(a, 2)*Math.cos(Math.PI/N)/(4*Math.sin(Math.PI/N));      	
        	//	N=-2*(Math.PI)/(alpha-(Math.PI));
        	     		N_text=P/a;
        		if(Math.abs(alpha_text-alpha)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;}
        		if(Math.abs(a_text-a)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;}
        		if(Math.abs(A_text-A)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;}
        		if(Math.abs(N_text-N)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;} 
        		if(Math.abs(P_text-P)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;}
        }
        		DecimalFormat df1 = new DecimalFormat("###.###########");   
        		DecimalFormat df2 = new DecimalFormat("###.###########");
        		DecimalFormat df3 = new DecimalFormat("###.###########");
        		DecimalFormat df4 = new DecimalFormat("###.###########");
        		DecimalFormat df5 = new DecimalFormat("###.###########");
            	
        	 editText1.setText(String.valueOf(df1.format(A)));
        	 editText2.setText(String.valueOf(df2.format(P)));
        	 editText3.setText(String.valueOf(df3.format(N)));
        	 editText4.setText(String.valueOf(df4.format(a)));
        	 editText5.setText(String.valueOf(df5.format(Math.toDegrees(alpha))));
        	 }
    	
//任意三角形
         public void RYSJX(){
        	 if(beta!=0&&gamma!=0&&alpha==0){
        		 alpha=Math.PI-beta-gamma;
        		 System.out.println("alpha1="+alpha);
        		 RYSJX();
        	 }else
        		if(A!=0&&alpha==0&&beta!=0&&c!=0)
            	{
            		
        			alpha=Math.asin(2*A/(Math.sqrt(Math.pow(2*A/(c*Math.sin(beta)), 2)+Math.pow(c, 2)-2*(2*A/(c*Math.sin(beta)))*c*Math.cos(beta))*c));
        			System.out.println("alpha2="+alpha);
        			RYSJX();
            	}
         	
            	else if(alpha==0&&b!=0&&c!=0&&a!=0){
            		
            		alpha=Math.acos((Math.pow(b, 2)+Math.pow(c, 2)-Math.pow(a, 2))/(2*b*c));
            		System.out.println("alpha3="+alpha);
            		RYSJX();
            		}

            	else if(alpha==0&&a!=0&&c!=0&&gamma!=0)
            	{
            	
            		alpha=Math.asin(a*Math.sin(gamma)/c);
            		System.out.println("alpha4="+alpha);
            		RYSJX();
            		}
        	
            	else if(alpha==0&&a!=0&&b!=0&&beta!=0){
            		
            		alpha=Math.asin(a*Math.sin(beta)/b);
            		System.out.println("alpha5="+alpha);
            		RYSJX();
            	}
          	
            	else
            	if(beta==0&&alpha!=0&&gamma!=0)
            	{
            	
            		beta=Math.PI-alpha-gamma;
            		System.out.println("beta1="+beta);
            		RYSJX();
            		}
           	
            	else
            	if(beta==0&&alpha!=0&&b!=0&&a!=0){
            	
            		beta=Math.asin(b*Math.sin(alpha)/a) ;
            		System.out.println("beta2="+beta);
            		RYSJX();
            	}
            	else
            	if(beta==0&&a!=0&&c!=0&&b!=0){
            		
            		beta=Math.acos((Math.pow(a, 2)+Math.pow(c, 2)-Math.pow(b, 2))/(2*a*c));
            		System.out.println("beta3="+beta);
            		RYSJX();
            	}
            	
           	else if
            	(gamma==0&&alpha!=0&&beta!=0){
            		
           		gamma=Math.PI-alpha-beta;
           		System.out.println("gamma1="+gamma);
           		RYSJX();
            		
            	}
           	else if
        	(gamma==0&&A!=0&&c!=0&&beta!=0){
        		
           	
           		gamma=Math.sin(2*A/(Math.sqrt(Math.pow(2*A/(c*Math.sin(beta)), 2)+Math.pow(c, 2)-2*(2*A/(c*Math.sin(beta)))*c*Math.cos(beta))*2*A/(c*Math.sin(beta))));
           		System.out.println("gamma2="+gamma);
           		RYSJX();
        		
        	}
           	else if
        	(gamma==0&&c!=0&&a!=0&&alpha!=0){
        		
           		gamma=Math.asin(c*Math.sin(alpha)/a);
           		System.out.println("gamma3="+gamma);
       		RYSJX();
        		
        	}
           	else if
        	(gamma==0&&a!=0&&b!=0&&c!=0){
        		
           		gamma=Math.acos((Math.pow(a, 2)+Math.pow(b, 2)-Math.pow(c, 2))/(2*a*b));
           		System.out.println("gamma4="+gamma);
       		RYSJX();
        		
        	}
           	else if
        	(gamma==0&&b!=0&&c!=0&&beta!=0){
        		
           		gamma=Math.asin(c*Math.sin(beta)/b);
           		System.out.println("gamma5="+gamma);
       		RYSJX();
        		
        	}
           	else if
        	(a==0&&c!=0&&alpha!=0&&gamma!=0){
        		
           		a=c*Math.sin(alpha)/Math.sin(gamma) ;
           		System.out.println("a1="+a);
       		RYSJX();
        		
        	}
        	else if
        	(a==0&&b!=0&&alpha!=0&&beta!=0){
        		
        		a=b*Math.sin(alpha)/Math.sin(beta);
        		System.out.println("a2="+a);
       		RYSJX();
        		
        	}
        	else if
        	(a==0&&c!=0&&alpha!=0&&beta!=0){
        		
        		a=c*Math.sin(alpha)/Math.sin(Math.PI-alpha-beta);
        		System.out.println("a3="+a);
       		RYSJX();
        		
        	}
        	else if
        	(a==0&&A!=0&&c!=0&&beta!=0){
        		
        		 a=2*A/(c*Math.sin(beta)) ;
        		 System.out.println("a4="+a);
       		RYSJX();
        		
        	}
        	else if
        	(a==0&&b!=0&&c!=0&&alpha!=0){
        		
        		a=Math.sqrt(Math.pow(b, 2)+Math.pow(c, 2)-2*b*c*Math.cos(alpha));
        		System.out.println("a5="+a);
       		RYSJX();
        		
        	}
        	else if
        	(b==0&&c!=0&&beta!=0&&gamma!=0){
        		
        		b=c*Math.sin(beta)/Math.sin(gamma);
        		System.out.println("b1="+b);
       		RYSJX();
        		
        	}
        	else if
        	(b==0&&a!=0&&beta!=0&&alpha!=0){
        		
        		b=a*Math.sin(beta)/Math.sin(alpha);
        		System.out.println("b2="+b);
       		RYSJX();
        		
        	}
        	else if
        	(b==0&&c!=0&&beta!=0&&alpha!=0){
        		
        		b=c*Math.sin(beta)/Math.sin(Math.PI-alpha-beta);
        		System.out.println("b3="+b);
       		RYSJX();
        		
        	}
        	else if
        	(b==0&&a!=0&&c!=0&&beta!=0){
        		
        		b=Math.sqrt(a*a+c*c-2*a*c*Math.cos(beta));
        		System.out.println("b4="+b);
       		RYSJX();
        		
        	}
        	else if
        	(b==0&&A!=0&&c!=0&&alpha!=0){
        		
        		b=2*A/(c*Math.sin(alpha));
        		System.out.println("b5="+b);
       		RYSJX();
        		
        	}
        	else if
        	(b==0&&a!=0&&c!=0&&beta!=0){
        		
        		b=Math.sqrt(Math.pow(a, 2)+Math.pow(c, 2)-2*a*c*Math.cos(beta)) ;
        		System.out.println("b6="+b);
       		RYSJX();
        		
        	}
        	else if
        	(c==0&&b!=0&&gamma!=0&&beta!=0){
        		
        		c=b*Math.sin(gamma)/Math.sin(beta);
        		System.out.println("c1="+c);
       		RYSJX();
        		
        	}
        	else if
        	(c==0&&a!=0&&b!=0&&gamma!=0){
        		
        		c=Math.sqrt(Math.pow(a, 2)+Math.pow(b, 2)-2*a*b*Math.cos(gamma));
        		System.out.println("c2="+c);
       		RYSJX();
        		
        	}
        	else if
        	(A==0&&a!=0&&c!=0&&beta!=0){
        		
        		A=a*c*Math.sin(beta)/2 ;
        		System.out.println("A1="+A);
       		RYSJX();
        		
        	}
        	else if
        	(A==0&&a!=0&&b!=0&&gamma!=0){
        		
        		A=a*b*Math.sin(gamma)/2 ;
        		System.out.println("A2="+A);
       		RYSJX();
        		
        	}
        	else if
        	(A==0&&c!=0&&b!=0&&alpha!=0){
        		
        		A=b*c*Math.sin(alpha)/2 ;
        		System.out.println("A3="+A);
       		RYSJX();
        		
        	}
        	else if
        	(A==0&&c!=0&&b!=0&&a!=0){
        		
        		A=Math.sqrt((a+b+c)*(-a+b+c)*(a-b+c)*(a+b-c))/4;
        		System.out.println("A4="+A);
       		RYSJX();
        		
        	}
        	else if
        	(P==0&&c!=0&&b!=0&&a!=0){
        		
        		P=a+b+c;
        		System.out.println("P1="+P);
       		RYSJX();
        		
        	}
         }
         void RYSJXtext(){      	
        	 if(A==0||P==0||a==0||b==0||c==0||alpha==0||beta==0||gamma==0){ Toast.makeText(getActivity(), "数据不够！无法计算！", Toast.LENGTH_SHORT).show();return;}
         	
         	else{
         		alpha_text=Math.PI-beta-gamma;	
         		beta_text=Math.PI-alpha-gamma;  
         		gamma_text=Math.PI-alpha-beta;
         				a_text=c*Math.sin(alpha)/Math.sin(gamma);
         						b_text=c*Math.sin(beta)/Math.sin(gamma)  	;
         								c_text=b*Math.sin(gamma)/Math.sin(beta)   	;
         										A_text=a*c*Math.sin(beta)/2 ;
         												P_text=a+b+c;
        	     	
        		if(Math.abs(alpha_text-alpha)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;}
        		if(Math.abs(a_text-a)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;}
        		if(Math.abs(A_text-A)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;}
        		if(Math.abs(b_text-b)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;} 
        		if(Math.abs(P_text-P)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;}
        		if(Math.abs(gamma_text-gamma)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;}
        		if(Math.abs(beta_text-beta)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;} 
        		if(Math.abs(c_text-c)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;}
        }
        		DecimalFormat df1 = new DecimalFormat("###.###########");   
        		DecimalFormat df2 = new DecimalFormat("###.###########");
        		DecimalFormat df3 = new DecimalFormat("###.###########");
        		DecimalFormat df4 = new DecimalFormat("###.###########");
        		DecimalFormat df5 = new DecimalFormat("###.###########");
        		DecimalFormat df6 = new DecimalFormat("###.###########");
        		DecimalFormat df7 = new DecimalFormat("###.###########");
        		DecimalFormat df8 = new DecimalFormat("###.###########");
            	
        	 editText1.setText(String.valueOf(df1.format(A)));
        	 editText2.setText(String.valueOf(df2.format(P)));
        	 editText3.setText(String.valueOf(df3.format(a)));
        	 editText4.setText(String.valueOf(df4.format(b)));
        	 editText5.setText(String.valueOf(df5.format(c)));
        	 editText6.setText(String.valueOf(df6.format(Math.toDegrees(alpha))));
        	 editText7.setText(String.valueOf(df7.format(Math.toDegrees(beta))));
        	 editText8.setText(String.valueOf(df8.format(Math.toDegrees(gamma))));
        	 }    
         
 //圆
         public void YUAN(){
        	 if(r==0&&d!=0)
         	{
         		
        		 r=d/2;
        		 YUAN();
         	}
      	
         	else if(r==0&&A!=0){
         		
         		r=Math.sqrt(A/Math.PI);
         		YUAN();
         		}

         	else if(A==0&&r!=0)
         	{
         	
         		A=Math.PI*Math.pow(r, 2);
         	
         		YUAN();
         		}
     	
         	else if(C==0&&d!=0){
         		
         		C=Math.PI*d;
         		
         		YUAN();
         	}
       	
         	else
         	if(d==0&&C!=0)
         	{
         	
         		d=C/Math.PI;
         		YUAN();
         		}
        	
         	else
         	if(d==0&&r!=0){
         	
         		d=r*2;
         		YUAN();
         	}
         
         }
         void YUANtext(){

         	 if(A==0||C==0||d==0||r==0){ Toast.makeText(getActivity(), "数据不够！无法计算！", Toast.LENGTH_SHORT).show();return;}
          	
          	else{
          		r_text=d/2;  	
          		A_text=Math.PI*Math.pow(r, 2);
          		C_text=Math.PI*d;
          		d_text=C/Math.PI;  	
         		
         	     		
         		if(Math.abs(r_text-r)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;}
         		if(Math.abs(A_text-A)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;}
         		if(Math.abs(C_text-C)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;}
         		if(Math.abs(d_text-d)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;} 
         		
         }
         		DecimalFormat df1 = new DecimalFormat("###.###########");   
         		DecimalFormat df2 = new DecimalFormat("###.###########");
         		DecimalFormat df3 = new DecimalFormat("###.###########");
         		DecimalFormat df4 = new DecimalFormat("###.###########");
         	
         	 editText1.setText(String.valueOf(df1.format(A)));
         	 editText2.setText(String.valueOf(df2.format(C)));
         	 editText3.setText(String.valueOf(df3.format(d)));
         	 editText4.setText(String.valueOf(df4.format(r)));
         	
         }
        
  //椭圆
         public void TUOYUAN(){
        	 if(A==0&&p!=0&&q!=0)
          	{
          		
        		 A=Math.PI*p*q;
        		 TUOYUAN();
          	}
       	
          	else if(p==0&&A!=0&&q!=0){
          		
          		p=A/(Math.PI*q);
          		 TUOYUAN();
          		}

          	else if(C==0&&p!=0&&q!=0)
          	{
          	
          		C=Math.PI*(p+q)*(1+3*Math.pow((p-q)/(p+q), 2)/(10+Math.sqrt(4-3*Math.pow((p-q)/(p+q), 2))));
          	
          		TUOYUAN();
          		}
      	
          	else if(q==0&&p!=0&&A!=0){
          		
          		q=A/(Math.PI*p);
          		
          		TUOYUAN();
          	}
        	
          	
         }
         void TUOYUANtext(){
        	 if(A==0||C==0||q==0||p==0){ Toast.makeText(getActivity(), "数据不够！无法计算！", Toast.LENGTH_SHORT).show();return;}
           	
           	else{
           		A_text=Math.PI*p*q;  	
           		C_text=Math.PI*(p+q)*(1+3*Math.pow((p-q)/(p+q), 2)/(10+Math.sqrt(4-3*Math.pow((p-q)/(p+q), 2))));
           		p_text=A/(Math.PI*q);
           		q_text=A/(Math.PI*p);  	
          		
          	     		
          		if(Math.abs(r_text-r)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;}
          		if(Math.abs(A_text-A)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;}
          		if(Math.abs(C_text-C)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;}
          		if(Math.abs(d_text-d)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;} 
          		
          }
          		DecimalFormat df1 = new DecimalFormat("###.###########");   
          		DecimalFormat df2 = new DecimalFormat("###.###########");
          		DecimalFormat df3 = new DecimalFormat("###.###########");
          		DecimalFormat df4 = new DecimalFormat("###.###########");
          	
          	 editText1.setText(String.valueOf(df1.format(A)));
          	 editText2.setText(String.valueOf(df2.format(p)));
          	 editText3.setText(String.valueOf(df3.format(q)));
          	 editText4.setText(String.valueOf(df4.format(C)));
          	
         }
         
      //正三角形
         public void ZHENGSANJIAOXING(){
        	 if(A==0&&a!=0)
           	{
           		
        		 A=Math.pow(a, 2)*Math.sqrt(3)/4;
        		 ZHENGSANJIAOXING();
           	}
        	
           	else if(A==0&&a!=0&&h!=0){
           		
           		A=a*h/2; 
           		ZHENGSANJIAOXING();
           		}

           	else if(P==0&&a!=0)
           	{
           	
           		P=3*a;
           	
           		ZHENGSANJIAOXING();
           		}
       	
           	else if(h==0&&a!=0){
           		
           		h=a*Math.sqrt(3)/2;
           		
           		ZHENGSANJIAOXING();
           	}
           	else if(a==0&&A!=0){
           		
           		a=Math.sqrt(A*4/Math.sqrt(3));
           		
           		ZHENGSANJIAOXING();
           	}
			else if(a==0&&P!=0){
		
					a=P/3;
           		
           		ZHENGSANJIAOXING();
           	}
			else if(a==0&&h!=0){
	
				a=h*2/Math.sqrt(3);
           		
           		ZHENGSANJIAOXING();
           	}
         }
         void ZHENGSANJIAOXINGtext(){

        	 if(A==0||P==0||a==0||h==0){ Toast.makeText(getActivity(), "数据不够！无法计算！", Toast.LENGTH_SHORT).show();return;}
            	
            	else{
            		A_text=a*h/2 ;  	
            		P_text=3*a;
            		a_text=a=P/3;
            		h_text=a*Math.sqrt(3)/2 ;  	
           		
           	     		
           		if(Math.abs(A_text-A)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;}
           		if(Math.abs(P_text-P)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;}
           		if(Math.abs(a_text-a)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;}
           		if(Math.abs(h_text-h)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;} 
           		
           }
           		DecimalFormat df1 = new DecimalFormat("###.###########");   
           		DecimalFormat df2 = new DecimalFormat("###.###########");
           		DecimalFormat df3 = new DecimalFormat("###.###########");
           		DecimalFormat df4 = new DecimalFormat("###.###########");
           	
           	 editText1.setText(String.valueOf(df1.format(A)));
           	 editText2.setText(String.valueOf(df2.format(P)));
           	 editText3.setText(String.valueOf(df3.format(a)));
           	 editText4.setText(String.valueOf(df4.format(h)));
           	
         }
         
         //菱形
         public void LINGXING(){
        	 if(a==0&&P!=0)
            	{
            		
        		 a=P/4;
        		 LINGXING();
            	}
         	
            	else if(a==0&&p!=0&&q!=0){
            		
            		a=Math.sqrt(Math.pow(p/2, 2)+Math.pow(q/2, 2));
            		 LINGXING();
            		}

            	else if(a==0&&q!=0&&A!=0)
            	{
            	
            		a=Math.sqrt(Math.pow(q/2, 2)+Math.pow(A/q, 2));
            	
            		LINGXING();
            		}
        	
            	else if(a==0&&A!=0&&alpha!=0){
            		
            		a=Math.sqrt(A/Math.sin(alpha));
            		
            		LINGXING();
            	}
            	else if(a==0&&p!=0&&alpha!=0){
            		
            		 a=(p/Math.sin(alpha/2))/2;
            		
            		 LINGXING();
            	}
 			else if(a==0&&q!=0&&alpha!=0){
 		
 				a=(q/Math.cos(alpha/2))/2;
            		
 				LINGXING();
            	}
 			else if(alpha==0&&A!=0&&P!=0){
 	
 				alpha=Math.asin(A/Math.pow(P/4, 2));
            		
 				LINGXING();
            	}
 			else if(alpha==0&&p!=0&&a!=0){
 			 	
 				 alpha=2*Math.asin(p/(2*a)) ;
            		
 				LINGXING();
            	}
 			else if(alpha==0&&p!=0&&q!=0){
 			 	
 				alpha=Math.atan(p/q)*2;
           		
				LINGXING();
           	}
else if(p==0&&alpha!=0&&a!=0){
 			 	
	p=Math.sin(alpha/2)*a*2 ;
           		
				LINGXING();
           	}
else if(p==0&&A!=0&&q!=0){
	 	
	p=2*A/q;
           		
				LINGXING();
           	}
else if(p==0&&alpha!=0&&q!=0){
 	
	p=Math.tan(alpha/2)*q;
           		
				LINGXING();
           	}
else if(P==0&&a!=0){
 	
	P=4*a;
           		
				LINGXING();
           	}
else if(q==0&&A!=0&&p!=0){
 	
	q=2*A/p;
           		
				LINGXING();
           	}
else if(q==0&&alpha!=0&&a!=0){
 	
	q=Math.cos(alpha/2)*2*a;
           		
				LINGXING();
           	}
else if(q==0&&alpha!=0&&p!=0){
 	
	q=p/Math.tan(alpha/2);
           		
				LINGXING();
           	}
else if(A==0&&alpha!=0&&a!=0){
 	
	A=Math.pow(a, 2)*Math.sin(alpha);
           		
				LINGXING();
           	}
else if(A==0&&p!=0&&q!=0){
 	
	A=(p*q)/2;
           		
				LINGXING();
           	}
         }
         void LINGXINGtext(){
        	 if(A==0||P==0||a==0||p==0||q==0||alpha==0){ Toast.makeText(getActivity(), "数据不够！无法计算！", Toast.LENGTH_SHORT).show();return;}
           	
           	else{
           		A_text=(p*q)/2 ;
           		P_text =4*a;
           		a_text=P/4 ;
           		p_text=2*A/q  ;
           		q_text=2*A/p  ;  	
           		alpha_text = Math.atan(p/q)*2;
           		
          		if(Math.abs(A_text-A)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;}
          		if(Math.abs(P_text-P)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;} 
          		if(Math.abs(a_text-a)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;}
          		if(Math.abs(p_text-p)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;}
          		if(Math.abs(q_text-q)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;} 
          		if(Math.abs(alpha_text-alpha)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;}
          		
          		
          }
          		DecimalFormat df1 = new DecimalFormat("###.###########");   
          		DecimalFormat df2 = new DecimalFormat("###.###########");
          		DecimalFormat df3 = new DecimalFormat("###.###########");
          		DecimalFormat df4 = new DecimalFormat("###.###########");
          		DecimalFormat df5 = new DecimalFormat("###.###########");
          		DecimalFormat df6 = new DecimalFormat("###.###########");
          	
          	
          	 editText1.setText(String.valueOf(df1.format(A)));
          	 editText2.setText(String.valueOf(df2.format(P)));
          	 editText3.setText(String.valueOf(df3.format(a)));
          	 editText4.setText(String.valueOf(df4.format(p)));
          	 editText5.setText(String.valueOf(df5.format(q)));
          	 editText6.setText(String.valueOf(df6.format(alpha)));
          
          	
        	
         }
         
         //直角三角形
         public void ZHIJIAOSANJIAOXING(){
        	 if(b==0&&A!=0&&a!=0)
            	{
            		
        		 b=2*A/a;
        		 ZHIJIAOSANJIAOXING();
            	}
         	
            	else if(b==0&&c!=0&&a!=0){
            		
            		b=Math.sqrt(Math.pow(c, 2)-Math.pow(a, 2));
            		ZHIJIAOSANJIAOXING();
            		}

            	else if(b==0&&a!=0&&alpha!=0)
            	{
            	
            		b=a/Math.tan(alpha);
            	
            		ZHIJIAOSANJIAOXING();
            		}
        	
            	else if(b==0&&beta!=0&&a!=0){
            		
            		 b=Math.sin(beta)*(a/Math.cos(beta));
            		
            		 ZHIJIAOSANJIAOXING();
            	}
            	else if(b==0&&alpha!=0&&c!=0){
            		
            		b=Math.cos(alpha)*c;
            		
            		 ZHIJIAOSANJIAOXING();
            	}
 			else if(b==0&&beta!=0&&c!=0){
 		
 				b=Math.sin(beta)*c;
            		
 				ZHIJIAOSANJIAOXING();
            	}
 			else if(c==0&&a!=0&&b!=0){
 	
 				c=Math.sqrt(Math.pow(a, 2)+Math.pow(b, 2));
            		
 				ZHIJIAOSANJIAOXING();
            	}
 			else if(c==0&&a!=0&&alpha!=0){
 			 	
 				c=a/Math.sin(alpha) ;
            		
 				ZHIJIAOSANJIAOXING();
            	}
else if(c==0&&a!=0&&beta!=0){
 			 	
	c=a/Math.cos(beta);
            		
 				ZHIJIAOSANJIAOXING();
            	}
else if(c==0&&b!=0&&alpha!=0){
	 	
	c=b/Math.cos(alpha);
            		
 				ZHIJIAOSANJIAOXING();
            	}
else if(c==0&&b!=0&&beta!=0){
 	
	c=b/Math.sin(beta);
            		
 				ZHIJIAOSANJIAOXING();
            	}
else if(alpha==0&&a!=0&&c!=0){
 	
	alpha=Math.asin(a/c);
            		
 				ZHIJIAOSANJIAOXING();
            	}
else if(alpha==0&&beta!=0){
 	
	alpha=Math.PI/2-beta;
            		
 				ZHIJIAOSANJIAOXING();
            	}
else if(beta==0&&b!=0&&c!=0){
 	
	beta=Math.asin(b/c) ;
            		
 				ZHIJIAOSANJIAOXING();
            	}
else if(beta==0&&alpha!=0){
 	
	beta=Math.PI/2-alpha;
            		
 				ZHIJIAOSANJIAOXING();
            	}
else if(h==0&&a!=0&&b!=0&&c!=0){
 	
	h=a*b/c;
            		
 				ZHIJIAOSANJIAOXING();
            	}
else if(P==0&&a!=0&&b!=0&&c!=0){
 	
	P=a+b+c;
            		
 				ZHIJIAOSANJIAOXING();
            	}
else if(a==0&&A!=0&&b!=0){
 	
	a=2*A/b;
            		
 				ZHIJIAOSANJIAOXING();
            	}
else if(a==0&&alpha!=0&&b!=0){
 	
	a=Math.tan(alpha)*b;
            		
 				ZHIJIAOSANJIAOXING();
            	}
else if(a==0&&beta!=0&&b!=0){
 	
	a=Math.cos(beta)*b/Math.sin(beta);
            		
 				ZHIJIAOSANJIAOXING();
            	}
else if(a==0&&alpha!=0&&c!=0){
 	
	a=Math.sin(alpha)*c;
            		
 				ZHIJIAOSANJIAOXING();
            	}
else if(a==0&&beta!=0&&c!=0){
 	
	a=Math.cos(beta)*c;
            		
 				ZHIJIAOSANJIAOXING();
            	}
else if(A==0&&a!=0&&b!=0){
 	
	A=a*b/2;
            		
 				ZHIJIAOSANJIAOXING();
            	}
         }
         void ZHIJIAOSANJIAOXINGtext(){
        	 if(A==0||a==0||b==0||c==0||alpha==0||beta==0){ Toast.makeText(getActivity(), "数据不够！无法计算！", Toast.LENGTH_SHORT).show();return;}
         	
         	else{
         		A_text=a*b/2 ;  	
         		a_text=2*A/b;
         		b_text=2*A/a ;
         		c_text=a/Math.sin(alpha)  ;  	
         		alpha_text = Math.asin(a/c);
         		beta_text = Math.asin(b/c);
        		if(Math.abs(A_text-A)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;}
        		if(Math.abs(a_text-a)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;}
        		if(Math.abs(b_text-b)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;}
        		if(Math.abs(c_text-c)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;} 
        		if(Math.abs(alpha_text-alpha)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;}
        		if(Math.abs(beta_text-beta)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;} 
        }
        		DecimalFormat df1 = new DecimalFormat("###.###########");   
        		DecimalFormat df2 = new DecimalFormat("###.###########");
        		DecimalFormat df3 = new DecimalFormat("###.###########");
        		DecimalFormat df4 = new DecimalFormat("###.###########");
        		DecimalFormat df5 = new DecimalFormat("###.###########");
        		DecimalFormat df6 = new DecimalFormat("###.###########");
        	
        	 editText1.setText(String.valueOf(df1.format(A)));
        	 editText2.setText(String.valueOf(df2.format(a)));
        	 editText3.setText(String.valueOf(df3.format(b)));
        	 editText4.setText(String.valueOf(df4.format(c)));
        	 editText5.setText(String.valueOf(df5.format(alpha)));
        	 editText6.setText(String.valueOf(df6.format(beta)));
        	
         }
       
     //等腰三角形
         public void DENGYAOSANJIAOXING(){
        	 if(b==0&&A!=0&&h!=0)
         	{
         		
        		 b=2*A/h;
        		 DENGYAOSANJIAOXING();
         	}
      	
         	else if(b==0&&beta!=0&&a!=0){
         		
         		b=2*Math.sin(beta/2)*a;
         		DENGYAOSANJIAOXING();
         		}

         	else if(b==0&&a!=0&&P!=0)
         	{
         	
         		b=P-2*a;
         	
         		DENGYAOSANJIAOXING();
         		}
     	
         	else if(b==0&&h!=0&&a!=0){
         		
         		b=2*Math.sqrt(Math.pow(a, 2)-Math.pow(h, 2));
         		
         		DENGYAOSANJIAOXING();
         	}
         	else if(b==0&&alpha!=0&&a!=0){
         		
         		b=2*Math.cos(alpha)*a;
         		
         		DENGYAOSANJIAOXING();
         	}
			else if(P==0&&a!=0&&b!=0){
		
				P=2*a+b;
         		
				DENGYAOSANJIAOXING();
         	}
			
else if(alpha==0&&beta!=0){
	
	alpha=(Math.PI-beta)/2 ;
         		
	DENGYAOSANJIAOXING();
         	}
else if(alpha==0&&h!=0&&a!=0){
	
	alpha=Math.asin(h/a);
         		
	DENGYAOSANJIAOXING();
         	}
else if(beta==0&&A!=0&&a!=0){
	
	beta=Math.asin(2*A/Math.pow(a, 2));
         		
	DENGYAOSANJIAOXING();
         	}
else if(beta==0&&alpha!=0){
	
	beta=Math.PI-2*alpha;
         		
	DENGYAOSANJIAOXING();
         	}
else if(h==0&&a!=0&&alpha!=0){
	
	h=a*Math.sin(alpha);
         		
	DENGYAOSANJIAOXING();
         	}
else if(h==0&&A!=0&&b!=0){
	
	h=2*A/b ;
         		
	DENGYAOSANJIAOXING();
         	}
else if(h==0&&a!=0&&b!=0){
	
	h=Math.sqrt(Math.pow(a, 2)-Math.pow(b/2, 2));
         		
	DENGYAOSANJIAOXING();
         	}
else if(a==0&&h!=0&&b!=0){
	
	a=Math.sqrt(Math.pow(h, 2)+Math.pow(b/2, 2));
         		
	DENGYAOSANJIAOXING();
         	}
else if(a==0&&h!=0&&A!=0){
	
	a=Math.sqrt(Math.pow(h, 2)+Math.pow(A/h, 2));
         		
	DENGYAOSANJIAOXING();
         	}
        	 
else if(a==0&&A!=0&&beta!=0){
	
	a=Math.sqrt(2*A/Math.sin(beta));
         		
	DENGYAOSANJIAOXING();
         	}
else if(a==0&&b!=0&&alpha!=0){
	
	a=b/(2*Math.cos(alpha));
         		
	DENGYAOSANJIAOXING();
         	}
else if(a==0&&b!=0&&beta!=0){
	
	a=b/(2*Math.sin(beta/2));
         		
	DENGYAOSANJIAOXING();
         	}
else if(a==0&&h!=0&&alpha!=0){
	
	a=h/Math.sin(alpha);
         		
	DENGYAOSANJIAOXING();
         	}
else if(A==0&&b!=0&&h!=0){
	
	A=b*h/2;
         		
	DENGYAOSANJIAOXING();
         	}
else if(A==0&&a!=0&&h!=0){
	
	A=a*h/2;
         		
	DENGYAOSANJIAOXING();
         	}
         }
         void DENGYAOSANJIAOXINGtext(){
        	 if(A==0||P==0||a==0||b==0||h==0||alpha==0||beta==0){ Toast.makeText(getActivity(), "数据不够！无法计算！", Toast.LENGTH_SHORT).show();return;}
          	
          	else{
          		A_text=b*h/2  ;
          		P_text =2*a+b;
          		a_text=Math.sqrt(Math.pow(h, 2)+Math.pow(b/2, 2));
          		b_text=2*A/h ;
          		h_text=a*Math.sin(alpha) ;  	
          		alpha_text = (Math.PI-beta)/2;
          		beta_text = Math.PI-2*alpha;
         		if(Math.abs(A_text-A)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;}
         		if(Math.abs(P_text-P)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;} 
         		if(Math.abs(a_text-a)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;}
         		if(Math.abs(b_text-b)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;}
         		if(Math.abs(h_text-h)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;} 
         		if(Math.abs(alpha_text-alpha)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;}
         		if(Math.abs(beta_text-beta)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;} 
         		
         }
         		DecimalFormat df1 = new DecimalFormat("###.###########");   
         		DecimalFormat df2 = new DecimalFormat("###.###########");
         		DecimalFormat df3 = new DecimalFormat("###.###########");
         		DecimalFormat df4 = new DecimalFormat("###.###########");
         		DecimalFormat df5 = new DecimalFormat("###.###########");
         		DecimalFormat df6 = new DecimalFormat("###.###########");
         		DecimalFormat df7 = new DecimalFormat("###.###########");
         	
         	 editText1.setText(String.valueOf(df1.format(A)));
         	 editText2.setText(String.valueOf(df2.format(P)));
         	 editText3.setText(String.valueOf(df3.format(a)));
         	 editText4.setText(String.valueOf(df4.format(b)));
         	 editText5.setText(String.valueOf(df5.format(h)));
         	 editText6.setText(String.valueOf(df6.format(alpha)));
         	 editText7.setText(String.valueOf(df7.format(beta)));
         	
         }
         
         
         
         //平行四边形
         public void PINGXINGSIBIANXING(){
        	 if(b==0&&A!=0&&h!=0)
         	{
         		
        		 b=A/h;
        		 PINGXINGSIBIANXING();
         	}
      	
         	else if(b==0&&P!=0&&a!=0){
         		
         		b=P/2-a;
         		PINGXINGSIBIANXING();
         		}

         	else if(a==0&&h!=0&&alpha!=0)
         	{
         	
         		a=h/Math.sin(alpha);
         	
         		PINGXINGSIBIANXING();
         		}
     	
         	else if(P==0&&a!=0&&b!=0){
         		

         		 P=2*(a+b);
         		
         		PINGXINGSIBIANXING();
         	}
         	else if(A==0&&b!=0&&h!=0){
         		
         		A=b*h;
         		
         		PINGXINGSIBIANXING();
         	}
			else if(alpha==0&&h!=0&&a!=0){
		
				alpha=Math.asin(h/a);
         		
				PINGXINGSIBIANXING();
         	}
			else if(h==0&&a!=0&&alpha!=0){
	

				 h=a*Math.sin(alpha);
         		
				 PINGXINGSIBIANXING();
         	}
			
         }
         void PINGXINGSIBIANXINGtext(){
        	 if(A==0||P==0||a==0||b==0||h==0||alpha==0||beta==0){ Toast.makeText(getActivity(), "数据不够！无法计算！", Toast.LENGTH_SHORT).show();return;}
           	
           	else{
           		A_text=b*h ;
           		P_text =2*(a+b);
           		a_text=h/Math.sin(alpha);
           		b_text=A/h;
           		h_text=a*Math.sin(alpha) ;  	
           		alpha_text = Math.asin(h/a);
           		
          		if(Math.abs(A_text-A)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;}
          		if(Math.abs(P_text-P)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;} 
          		if(Math.abs(a_text-a)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;}
          		if(Math.abs(b_text-b)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;}
          		if(Math.abs(h_text-h)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;} 
          		if(Math.abs(alpha_text-alpha)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;}
         
          		
          }
          		DecimalFormat df1 = new DecimalFormat("###.###########");   
          		DecimalFormat df2 = new DecimalFormat("###.###########");
          		DecimalFormat df3 = new DecimalFormat("###.###########");
          		DecimalFormat df4 = new DecimalFormat("###.###########");
          		DecimalFormat df5 = new DecimalFormat("###.###########");
          		DecimalFormat df6 = new DecimalFormat("###.###########");
          	
          	
          	 editText1.setText(String.valueOf(df1.format(A)));
          	 editText2.setText(String.valueOf(df2.format(P)));
          	 editText3.setText(String.valueOf(df3.format(a)));
          	 editText4.setText(String.valueOf(df4.format(b)));
          	 editText5.setText(String.valueOf(df5.format(h)));
          	 editText6.setText(String.valueOf(df6.format(alpha)));
          	
         }
         
     //梯形
         public void TIXING(){
        	 if(a==0&&P!=0&&b!=0&&c!=0&&d!=0)
          	{
          		
        		 a=P-b-c-d;
        		 TIXING();
          	}
       	
          	else if(A==0&&a!=0&&b!=0&&c!=0&&d!=0){
          		
          		A=((a+b)/(4*(b-a)))*Math.sqrt((-a+b+c+d)*(a-b+c+d)*(a-b+c-d)*(a-b-c+d));
          		TIXING();
          		}

          	else if(h==0&&A!=0&&a!=0&&b!=0)
          	{
          	
          		h=2*A/(a+b);
          	
          		TIXING();
          		}
      	
          	else if(P==0&&a!=0&&b!=0&&c!=0&&d!=0){
          		

          		P=a+b+c+d;
          		
          		TIXING();
          	}
          	else if(b==0&&P!=0&&a!=0&&c!=0&&d!=0){
          		
          		b=P-a-c-d;
          		
          		TIXING();
          	}
 			else if(c==0&&P!=0&&a!=0&&b!=0&&d!=0){
 		
 				c=P-a-b-d;
          		
 				TIXING();
          	}
 			else if(d==0&&P!=0&&a!=0&&b!=0&&c!=0){
 	

 				d=P-a-b-c;
          		
 				TIXING();
          	}
 			
         }
         void TIXINGtext(){
         	 if(A==0||P==0||a==0||b==0||c==0||d==0){ Toast.makeText(getActivity(), "数据不够！无法计算！", Toast.LENGTH_SHORT).show();return;}
            	
            	else{
            		A_text=((a+b)/(4*(b-a)))*Math.sqrt((-a+b+c+d)*(a-b+c+d)*(a-b+c-d)*(a-b-c+d)) ;
            		P_text =a+b+c+d;
            		a_text=P-b-c-d;
            		b_text=P-a-c-d;
            		c_text=P-a-b-d ;  	
            		d_text = P-a-b-c;
            		
           		if(Math.abs(A_text-A)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;}
           		if(Math.abs(P_text-P)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;} 
           		if(Math.abs(a_text-a)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;}
           		if(Math.abs(b_text-b)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;}
           		if(Math.abs(c_text-c)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;} 
           		if(Math.abs(d_text-d)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;}
          
           		
           }
           		DecimalFormat df1 = new DecimalFormat("###.###########");   
           		DecimalFormat df2 = new DecimalFormat("###.###########");
           		DecimalFormat df3 = new DecimalFormat("###.###########");
           		DecimalFormat df4 = new DecimalFormat("###.###########");
           		DecimalFormat df5 = new DecimalFormat("###.###########");
           		DecimalFormat df6 = new DecimalFormat("###.###########");
           	
           	
           	 editText1.setText(String.valueOf(df1.format(A)));
           	 editText2.setText(String.valueOf(df2.format(P)));
           	 editText3.setText(String.valueOf(df3.format(a)));
           	 editText4.setText(String.valueOf(df4.format(b)));
           	 editText5.setText(String.valueOf(df5.format(c)));
           	 editText6.setText(String.valueOf(df6.format(d)));
           	
         }
      //椎体
         public void ZHUITI(){
        	 if(r==0&&A!=0&&h!=0)
           	{
           		
        		 r=A/(Math.sqrt(Math.PI)*Math.sqrt(2*A+Math.PI*Math.pow(h, 2)));
        		 ZHUITI();
           	}
        	
           	else if(r==0&&d!=0){
           		
           		r=d/2;
           		ZHUITI();
           		}

           	else if(r==0&&V!=0&&h!=0)
           	{
           	
           		r=Math.sqrt(3*V/(Math.PI*h));
           	
           		ZHUITI();
           		}
       	
           	else if(d==0&&r!=0){
           		

           		d=2*r;
           		
           		ZHUITI();
           	}
           	else if(V==0&&r!=0&&h!=0){
           		
           		V=Math.PI*Math.pow(r, 2)*h/3;
           		
           		ZHUITI();
           	}
  			else if(h==0&&V!=0&&r!=0){
  		
  				h=3*V/(Math.PI*Math.pow(r, 2));
           		
  				ZHUITI();
           	}
  			else if(A==0&&r!=0&&h!=0){
  	

  				A=Math.PI*r*(r+Math.sqrt(Math.pow(r, 2)+Math.pow(h, 2)));
           		
  				ZHUITI();
           	}
         }
         void ZHUITItext(){
        	 if(A==0||V==0||r==0||d==0||h==0){ Toast.makeText(getActivity(), "数据不够！无法计算！", Toast.LENGTH_SHORT).show();return;}
         	
         	else{
         		A_text=Math.PI*r*(r+Math.sqrt(Math.pow(r, 2)+Math.pow(h, 2))) ;
         		V_text =Math.PI*Math.pow(r, 2)*h/3;
         		r_text=d/2 ;
         		d_text=2*r;
         		h_text=3*V/(Math.PI*Math.pow(r, 2)) ;  	
         		
         		
        		if(Math.abs(A_text-A)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;}
        		if(Math.abs(V_text-V)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;} 
        		if(Math.abs(r_text-r)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;}
        		if(Math.abs(d_text-d)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;}
        		if(Math.abs(h_text-h)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;} 
        		
       
        		
        }
        		DecimalFormat df1 = new DecimalFormat("###.###########");   
        		DecimalFormat df2 = new DecimalFormat("###.###########");
        		DecimalFormat df3 = new DecimalFormat("###.###########");
        		DecimalFormat df4 = new DecimalFormat("###.###########");
        		DecimalFormat df5 = new DecimalFormat("###.###########");
        	
        	
        	
        	 editText1.setText(String.valueOf(df1.format(A)));
        	 editText2.setText(String.valueOf(df2.format(V)));
        	 editText3.setText(String.valueOf(df3.format(r)));
        	 editText4.setText(String.valueOf(df4.format(d)));
        	 editText5.setText(String.valueOf(df5.format(h)));
        	
        	
         }
         //椭球
         public void TUOQIU(){
        	 if(A==0&&a!=0&&b!=0&&c!=0)
            	{
            		
        		 A=4*Math.PI*Math.pow((Math.pow(a, 1.6075)*Math.pow(b, 1.6075)+Math.pow(a, 1.6075)*Math.pow(c, 1.6075)+Math.pow(b, 1.6075)*Math.pow(c, 1.6075))/3, 1/1.6075);
        		 TUOQIU();
            	}
         	
            	else if(c==0&&A!=0&&a!=0&&b!=0){
            		
            		c=(3*Math.pow(A/(4*Math.PI), 1.6075)-Math.pow(a, 1.6075)*Math.pow(b, 1.6075))/(Math.pow(a, 1.6075)+Math.pow(b, 1.6075));
            		TUOQIU();
            		}

            	else if(c==0&&V!=0&&a!=0&&b!=0)
            	{
            	
            		c=3*V/(4*Math.PI*a*b);
            	
            		TUOQIU();
            		}
        	
            	else if(V==0&&a!=0&&b!=0&&c!=0){
            		

            		 V=4*Math.PI*a*b*c/3;
            		
            		 TUOQIU();
            	}
            	else if(b==0&&A!=0&&a!=0&&c!=0){
            		
            		b=(3*Math.pow(A/(4*Math.PI), 1.6075)-Math.pow(a, 1.6075)*Math.pow(c, 1.6075))/(Math.pow(a, 1.6075)+Math.pow(c, 1.6075));
            		
            		TUOQIU();
            	}
   			else if(b==0&&V!=0&&a!=0&&c!=0){
   		
   				b=3*V/(4*Math.PI*a*c);
            		
   				TUOQIU();
            	}
   			else if(a==0&&A!=0&&b!=0&&c!=0){
   	

   				a=(3*Math.pow(A/(4*Math.PI), 1.6075)-Math.pow(b, 1.6075)*Math.pow(c, 1.6075))/(Math.pow(b, 1.6075)+Math.pow(c, 1.6075));
            		
   				TUOQIU();
            	}
   			else if(a==0&&V!=0&&b!=0&&c!=0){
   			   	

   			 a=3*V/(4*Math.PI*b*c);
            		
   				TUOQIU();
            	}
         }
         void TUOQIUtext(){
        	 if(A==0||V==0||a==0||b==0||c==0){ Toast.makeText(getActivity(), "数据不够！无法计算！", Toast.LENGTH_SHORT).show();return;}
          	
          	else{
          		A_text=4*Math.PI*Math.pow((Math.pow(a, 1.6075)*Math.pow(b, 1.6075)+Math.pow(a, 1.6075)*Math.pow(c, 1.6075)+Math.pow(b, 1.6075)*Math.pow(c, 1.6075))/3, 1/1.6075);
          		V_text =4*Math.PI*a*b*c/3;
          		a_text=3*V/(4*Math.PI*b*c);
          		b_text=3*V/(4*Math.PI*a*c);
          		c_text=3*V/(4*Math.PI*a*b);
          		
          		
         		if(Math.abs(A_text-A)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;}
         		if(Math.abs(V_text-V)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;} 
         		if(Math.abs(a_text-a)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;}
         		if(Math.abs(b_text-b)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;}
         		if(Math.abs(c_text-c)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;} 
         		
        
         		
         }
         		DecimalFormat df1 = new DecimalFormat("###.###########");   
         		DecimalFormat df2 = new DecimalFormat("###.###########");
         		DecimalFormat df3 = new DecimalFormat("###.###########");
         		DecimalFormat df4 = new DecimalFormat("###.###########");
         		DecimalFormat df5 = new DecimalFormat("###.###########");
         	
         	
         	
         	 editText1.setText(String.valueOf(df1.format(A)));
         	 editText2.setText(String.valueOf(df2.format(V)));
         	 editText3.setText(String.valueOf(df3.format(a)));
         	 editText4.setText(String.valueOf(df4.format(b)));
         	 editText5.setText(String.valueOf(df5.format(c)));
         	
         	
         }
         
         //柱体
         public void ZHUTI(){
        	 if(A==0&&B!=0&&N!=0&&a!=0&&h!=0)
         	{
         		
        		 A=2*B+N*a*h;
        		 ZHUTI();
         	}
      	
         	else if(h==0&&A!=0&&N!=0&&a!=0){
         		
         		h=(A-(N*Math.pow(a, 2)*Math.cos(Math.PI/N)/Math.sin(Math.PI/N))/2)/(N*a);
         		ZHUTI();
         		}

         	else if(h==0&&V!=0&&B!=0)
         	{
         	
         		 h=V/B;
         	
         		ZHUTI();
         		}
         	else if(B==0&&N!=0&&a!=0)
         	{
         	
         		B=N*Math.pow(a, 2)*Math.cos(Math.PI/N)/(4*Math.sin(Math.PI/N));
         	
         		ZHUTI();
         		}
         	else if(V==0&&B!=0&&h!=0){
         		

         		V=B*h;
         		
         		ZHUTI();
         	}
         	else if(a==0&&A!=0&&N!=0&&h!=0){
         		
         		a=(Math.sqrt(2*N*A*Math.cos(Math.PI/N)/Math.sin(Math.PI/N)+Math.pow(h, 2)*Math.pow(N, 2))-h*N)/(N*Math.cos(Math.PI/N)/Math.sin(Math.PI/N));    
         		
         		ZHUTI();
         	}
			else if(a==0&&B!=0&&N!=0&&c!=0){
		
				 a=Math.sqrt(4*B/(N*Math.cos(Math.PI/N)/Math.sin(Math.PI/N)));
         		
				 ZHUTI();
         	}
			else if(a==0&&V!=0&&N!=0&&h!=0){
	

				a=Math.sqrt(4*V/(N*h*Math.cos(Math.PI/N)/Math.sin(Math.PI/N)));
         		
				ZHUTI();
         	}
			
         }
         void ZHUTItext(){
        	 if(A==0||B==0||V==0||N==0||a==0||h==0){ Toast.makeText(getActivity(), "数据不够！无法计算！", Toast.LENGTH_SHORT).show();return;}
           	
           	else{
           		A_text=2*B+N*a*h;
           		B_text =N*Math.pow(a, 2)*Math.cos(Math.PI/N)/(4*Math.sin(Math.PI/N));
           		V_text=B*h;
           	//	N_text=3*V/(4*Math.PI*a*c);
           		a_text=Math.sqrt(4*V/(N*h*Math.cos(Math.PI/N)/Math.sin(Math.PI/N)));
           		h_text=V/B;
           		
          		if(Math.abs(A_text-A)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;}
          		if(Math.abs(B_text-B)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;} 
          		if(Math.abs(V_text-V)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;}
          		if(Math.abs(a_text-a)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;}
          		if(Math.abs(h_text-h)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;} 
          		
         
          		
          }
          		DecimalFormat df1 = new DecimalFormat("###.###########");   
          		DecimalFormat df2 = new DecimalFormat("###.###########");
          		DecimalFormat df3 = new DecimalFormat("###.###########");
          		DecimalFormat df4 = new DecimalFormat("###.###########");
          		DecimalFormat df5 = new DecimalFormat("###.###########");
          		DecimalFormat df6 = new DecimalFormat("###.###########");
          	
          	
          	 editText1.setText(String.valueOf(df1.format(A)));
          	 editText2.setText(String.valueOf(df2.format(B)));
          	 editText3.setText(String.valueOf(df3.format(V)));
          	 editText4.setText(String.valueOf(df4.format(N)));
          	 editText5.setText(String.valueOf(df5.format(a)));
          	editText6.setText(String.valueOf(df5.format(h)));
          	
         }
  //球
         public void QIU(){
        	 if(r==0&&A!=0)
          	{
          		
        		 r=Math.sqrt(A/(4*Math.PI)); 
        				 QIU();
          	}
       	
          	else if(r==0&&V!=0){
          		
          		r=Math.pow(3*V/(4*Math.PI), 0.333333333333);
          		QIU();
          		}

          	else if(r==0&&d!=0)
          	{
          	
          		r=d/2;
          	
          		QIU();
          		}
          	else if(d==0&&r!=0)
          	{
          	
          		d=2*r;
          	
          		QIU();
          		}
          	else if(V==0&&r!=0){
          		

          		V=4*Math.PI*Math.pow(r, 3)/3;
          		
          		QIU();
          	}
          	else if(A==0&&r!=0){
          		
          		A=4*Math.PI*Math.pow(r, 2);
          		
          		QIU();
          	}
 			
         }
         void QIUtext(){
         	 if(A==0||V==0||r==0||d==0){ Toast.makeText(getActivity(), "数据不够！无法计算！", Toast.LENGTH_SHORT).show();return;}
            	
            	else{
            		A_text=4*Math.PI*Math.pow(r, 2);
            		V_text =4*Math.PI*Math.pow(r, 3)/3;
            		r_text=d/2;
            	
            		d_text=2*r;
            		
           		if(Math.abs(A_text-A)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;}
           		if(Math.abs(V_text-V)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;} 
           		if(Math.abs(r_text-r)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;}
           		if(Math.abs(d_text-d)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;}
           		
           		
          
           		
           }
           		DecimalFormat df1 = new DecimalFormat("###.###########");   
           		DecimalFormat df2 = new DecimalFormat("###.###########");
           		DecimalFormat df3 = new DecimalFormat("###.###########");
           		DecimalFormat df4 = new DecimalFormat("###.###########");
           	
           	
           	
           	 editText1.setText(String.valueOf(df1.format(A)));
           	 editText2.setText(String.valueOf(df2.format(V)));
           	 editText3.setText(String.valueOf(df3.format(r)));
           	 editText4.setText(String.valueOf(df4.format(d)));
          
           	
         }
         
         //四面体
         public void SIMIANTI(){
        	 if(a==0&&A!=0)
           	{
           		
        		 a=Math.sqrt(A/1.7320508075);
        		 SIMIANTI();
           	}
        	
           	else if(a==0&&V!=0){
           		
           		a=Math.pow(V/0.117851130197, 0.333333333333);
           		
           		SIMIANTI();
           		}

           	else if(V==0&&a!=0)
           	{
           	
           		V=0.117851130197*Math.pow(a, 3);
           	
           		SIMIANTI();
           		}
           	else if(A==0&&a!=0)
           	{
           	
           		A=1.7320508075*Math.pow(a, 2);
           	
           		SIMIANTI();
           		}
           
  			
         }
         void SIMIANTItext(){
        	 if(A==0||V==0||a==0){ Toast.makeText(getActivity(), "数据不够！无法计算！", Toast.LENGTH_SHORT).show();return;}
         	
         	else{
         		A_text=1.7320508075*Math.pow(a, 2);
         		V_text =0.117851130197*Math.pow(a, 3);
         		a_text=Math.sqrt(A/1.7320508075);
         		
         	
         		
        		if(Math.abs(A_text-A)>0.01){ Toast.makeText(getActivity(), "有矛盾！1", Toast.LENGTH_SHORT).show();return;}
        		if(Math.abs(V_text-V)>0.01){ Toast.makeText(getActivity(), "有矛盾！2", Toast.LENGTH_SHORT).show();return;} 
        		if(Math.abs(a_text-a)>0.01){ Toast.makeText(getActivity(), "有矛盾！3", Toast.LENGTH_SHORT).show();return;}
        		
        		
        		
       
        		
        }
        		DecimalFormat df1 = new DecimalFormat("###.###########");   
        		DecimalFormat df2 = new DecimalFormat("###.###########");
        		DecimalFormat df3 = new DecimalFormat("###.###########");
        	
        	
        	
        	
        	 editText1.setText(String.valueOf(df1.format(A)));
        	 editText2.setText(String.valueOf(df2.format(V)));
        	 editText3.setText(String.valueOf(df3.format(a)));
        
       
         }
         
        //圆柱
         public void YUANZHU(){
        	 if(A==0&&r!=0&&h!=0)
          	{
          		
        		 A=2*Math.PI*r*(h+r);
        		 YUANZHU();
          	}
       	
          	else if(d==0&&r!=0){
          		
          		d=2*r;
          		YUANZHU();
          		}

          	else if(h==0&&A!=0&&r!=0)
          	{
          	
          		h=A/(2*Math.PI*r)-r;
          	
          		YUANZHU();
          		}
          	else if(h==0&&V!=0&&r!=0)
          	{
          	
          		 h=V/(Math.PI*Math.pow(r, 2));
          	
          		YUANZHU();
          		}
          	else if(V==0&&r!=0&&h!=0){
          		

          		V=Math.PI*Math.pow(r, 2)*h;
          		
          		YUANZHU();
          	}
          	else if(r==0&&d!=0){
          		
          		r=d/2;
          		
          		YUANZHU();
          	}
 			else if(r==0&&A!=0&&h!=0){
 		
 				r=(Math.sqrt(Math.PI)*Math.sqrt(2*A+Math.PI*Math.pow(h, 2))-Math.PI*h)/(2*Math.PI);
          		
 				YUANZHU();
          	}
 			else if(r==0&&V!=0&&h!=0){
 	

 				r=Math.sqrt(V/(Math.PI*h));
          		
 				YUANZHU();
          	}
 			
         }
         void YUANZHUtext(){
          	 if(A==0||V==0||r==0||d==0||h==0){ Toast.makeText(getActivity(), "数据不够！无法计算！", Toast.LENGTH_SHORT).show();return;}
            	
            	else{
            		A_text=2*Math.PI*r*(h+r);
            		V_text =Math.PI*Math.pow(r, 2)*h;
            		r_text=d/2;
            	
            		d_text=2*r;
            		h_text=A/(2*Math.PI*r)-r;
            		
           		if(Math.abs(A_text-A)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;}
           		if(Math.abs(V_text-V)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;} 
           		if(Math.abs(r_text-r)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;}
           		if(Math.abs(d_text-d)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;}
           		if(Math.abs(h_text-h)>0.01){ Toast.makeText(getActivity(), "有矛盾！", Toast.LENGTH_SHORT).show();return;} 
           		
          
           		
           }
           		DecimalFormat df1 = new DecimalFormat("###.###########");   
           		DecimalFormat df2 = new DecimalFormat("###.###########");
           		DecimalFormat df3 = new DecimalFormat("###.###########");
           		DecimalFormat df4 = new DecimalFormat("###.###########");
           		DecimalFormat df5 = new DecimalFormat("###.###########");
           	
           	
           	
           	 editText1.setText(String.valueOf(df1.format(A)));
           	 editText2.setText(String.valueOf(df2.format(V)));
           	 editText3.setText(String.valueOf(df3.format(r)));
           	 editText4.setText(String.valueOf(df4.format(d)));
           	 editText5.setText(String.valueOf(df5.format(h)));
           
           	
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

			@Override
			public boolean onLongClick(View arg0) {
				if(editText1.hasFocus()){
	        		editText1.setText("");
	        		index_1=0;
	    			
	    		}else if(editText2.hasFocus()){
	    			editText2.setText("");
	        		index_2=0;
	    		}
	    		else if(editText3.hasFocus()){
	    			editText3.setText("");
	        		index_3=0;
	    		}
	    		else if(editText4.hasFocus()){
	    			editText4.setText("");
	        		index_4=0;
	    		}
	    		else if(editText5.hasFocus()){
	    			editText5.setText("");
	        		index_5=0;
	    		}
	    		else if(editText6.hasFocus()){
	    			editText6.setText("");
	        		index_6=0;
	    		}
	    		else if(editText7.hasFocus()){
	    			editText7.setText("");
	        		index_7=0;
	    		}
	    		else if(editText8.hasFocus()){
	    			editText8.setText("");
	        		index_8=0;
	    		}
				return false;
			}
}
