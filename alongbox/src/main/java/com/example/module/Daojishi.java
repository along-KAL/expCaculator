package com.example.module;




import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.format.Time;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.main.R;
import com.example.weight.DatePickerView;
import com.example.weight.Zhoudatepk;

import java.util.Calendar;
import java.util.Date;
@Deprecated
@SuppressLint("NewApi")
public class Daojishi extends Fragment  {
	LinearLayout dt;
	LinearLayout ll;
	private TextView t1 ;
	private TextView t2 ;
	private TextView t3 ;
	private TextView t4 ;
	private TextView t5 ;
	private TextView t6 ;
	private TextView t7 ;
	private TextView t8 ;
	private TextView t9 ;
	private  EditText e1 ;
	private Button b1;
	private Button b2;
	private Button b3;
	private Button b4;
	private Button b5;
	 int xyear = 0;
     int xmonth = 0;
      int xday = 0;
      int xwk =0;
 
      int zyear ;
      int zmonth;
      int zday;
      
      int zyear1 ;
      int zmonth1;
      int zday1;
      
      int zyear2 ;
      int zmonth2;
      int zday2;
      
      int zyear3 ;
      int zmonth3;
      int zday3;
      
      int zdelta;
      int zdelta1;
      int zdelta2;
      int zdelta3;
      String z0 ="";
      String z ="";
      String z1 ="";
      String z2 ="";
      String z3 ="";
      int ziti;
      int year;
      int month;
      int day ;
      Bitmap bmp;
	public Daojishi(){}
	Calendar c=null;
	@Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		
		/*LayoutInflater factorys = LayoutInflater.from(getActivity());
		View e = factorys.inflate(R.layout.date_picker_dialog, null);*/
			
        View rootView = inflater.inflate(R.layout.fragment_daojishi, container, false);
        
        
       
        
        
        
        Time t = new Time();
        t.setToNow();
         year = t.year;
         month = t.month+1;
         day = t.monthDay;
        ll= (LinearLayout)rootView.findViewById(R.id.ll);
         t1 = (TextView)rootView.findViewById(R.id.textView1);
         t2 = (TextView)rootView.findViewById(R.id.textView2);
         t3 = (TextView)rootView.findViewById(R.id.textView3);
         t4 = (TextView)rootView.findViewById(R.id.textView4);
         t5 = (TextView)rootView.findViewById(R.id.textView5);
         t6 = (TextView)rootView.findViewById(R.id.textView6);
         t7= (TextView)rootView.findViewById(R.id.textView7);
         t8 = (TextView)rootView.findViewById(R.id.textView8);
         t9= (TextView)rootView.findViewById(R.id.textView9);
         
         b1 = (Button)rootView.findViewById(R.id.button1);
         b2 = (Button)rootView.findViewById(R.id.button2);
         b3 = (Button)rootView.findViewById(R.id.button3);
         b4 = (Button)rootView.findViewById(R.id.button4);
         b5 = (Button)rootView.findViewById(R.id.button5);
         
         
         Animation animation1 = new AlphaAnimation(0.0F,1.0f);   
         animation1.setDuration(800);
         animation1.setStartOffset(1000);
         
         Animation animation2 = new AlphaAnimation(0.0F,1.0f);   
         animation2.setDuration(800);
         animation2.setStartOffset(900);
         
         Animation animation3 = new AlphaAnimation(0.0F,1.0f);   
         animation3.setDuration(800);
         animation3.setStartOffset(800);
         
         Animation animation4 = new AlphaAnimation(0.0F,1.0f);   
         animation4.setDuration(800);
         animation4.setStartOffset(750);
         
         
         t1.startAnimation(animation1);
         t2.startAnimation(animation1);
         t3.startAnimation(animation2);
         t4.startAnimation(animation2);
         t5.startAnimation(animation3);
         t6.startAnimation(animation3);
         t7.startAnimation(animation3);
         t8.startAnimation(animation4);
         t9.startAnimation(animation4);
        b1.startAnimation(animation4);
         
       //  e1 = (EditText)e.findViewById(R.id.e1);
        // TextView dd = (TextView)e.findViewById(R.id.date_picker_ok);
         
       //dd.setText("hhhahkjahkdj");
         
         Animation animation11 = new TranslateAnimation(-600,0,0,0);   
         animation11.setDuration(600);
         animation11.setStartOffset(300);
         Animation animation22 = new TranslateAnimation(600,0,0,0);   
         animation22.setDuration(600);
         animation22.setStartOffset(300);
         
         Animation animation111 = new TranslateAnimation(-600,0,0,0);   
         animation111.setDuration(600);
        // animation1.setStartOffset(600);
         Animation animation222 = new TranslateAnimation(600,0,0,0);   
         animation222.setDuration(600);
         //animation1.setStartOffset(800);
         b2.startAnimation(animation11);
         b3.startAnimation(animation22);
         
         b4.startAnimation(animation111);
         b5.startAnimation(animation222);
         Thread newThread; //����һ�����߳�
         newThread = new Thread(new Runnable() {
             @Override
                     public void run() {
                     try {
						Thread.sleep(2500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                   
                    // ll.getViewTreeObserver().removeOnPreDrawListener(this);
         	    	ll.buildDrawingCache();
         	    	
         	         bmp = ll.getDrawingCache();
        
                     }
                 });
             newThread.start(); 
         
         DisplayMetrics metric = new DisplayMetrics();
         getActivity().getWindowManager().getDefaultDisplay().getMetrics(metric);
         int densityDpi = metric.densityDpi;  
       
        if(densityDpi<=350){ziti=35;}
        else if(densityDpi>350){ziti = 70;}
         //System.out.println(e1.getText().toString());
         b1.setOnClickListener(
                 new OnClickListener(){
            @Override
            public void onClick(View v){ 
            	
            	//final EditText text = new EditText(getActivity());
            //	DatePickerDialog dialog=null;
            	//dialog.setView(text);
            	
            	 c=Calendar.getInstance();//��ȡ���ڶ���
            	 Zhoudatepk datePickerView = new Zhoudatepk(getActivity(),R.style.CustomDialog,
             			new Zhoudatepk.OnDateSetListener() {
             			@Override
             			public void onDateSet(DatePicker view, int yearz,
             			int monthOfYearz, int dayOfMonthz,String e, Bitmap bmp1) { 
    	
    	    	 xyear=yearz;     
  	           xmonth = monthOfYearz+1;
  	           xday  = dayOfMonthz;
  	         
  	         Calendar cal=Calendar.getInstance(); 
  	         cal.setTime(new Date(year,month,day+2));
  	         
  	         int wk = cal.get(Calendar.WEEK_OF_YEAR);
  	      
  	          
  	         Calendar cal1=Calendar.getInstance();	
  	         cal1.setTime(new Date(xyear,xmonth,xday+2));
  	         int  wk1 = cal1.get(Calendar.WEEK_OF_YEAR);
   
	           xwk = wk-wk1+1;
	          
	           if(xwk<1){
	        	  
	        	   b1.setText("��ѡ��ѧ��һ�������ڣ�");
//	        	   int i = (xwk+"").length();
//	        	   SpannableString ss = new SpannableString( "�����õ����ڵ����ڻ���"+xwk+"�ܣ�");
//	        	   
//	        	   ss.setSpan(new ForegroundColorSpan(Color.parseColor("#33FFFF")), 11, 11+i,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//	               ss.setSpan(new AbsoluteSizeSpan(30), 11, 11+i,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//	               ss.setSpan(new StyleSpan(Typeface.ITALIC), 1, 11+i,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//	               b1.setText(ss);
	        	   }
	           else if(xwk>23)
	        	   b1.setText("���ѧ��̫���ˣ�?");
	           else{
	        	   int i = (xwk+"").length();
	        	   SpannableString ss = new SpannableString("�����Ǳ�ѧ�ڵ�"+xwk+"�ܣ�");
        	   
	        	   ss.setSpan(new ForegroundColorSpan(Color.parseColor("#33FFFF")), 7, 7+i,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
	               ss.setSpan(new AbsoluteSizeSpan(ziti), 7, 7+i,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
	               ss.setSpan(new StyleSpan(Typeface.ITALIC), 1, 7+i,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
	               b1.setText(ss);
  	       // b1.setText("�����Ǳ�ѧ�ڵ�"+xwk+"�ܣ�"); 
  	        
	           }
  	      
  	       
    	     }           
    	           },
    	           xyear,     //�������?
    	           xmonth-1,     //�����·�
    	           xday     //��������    
    	           ,z0,bmp );
    	        
//    	         WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
//             	dialog.getWindow().setAttributes(lp);  
//             	//lp.height=(int)(566);
//             	dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
    	          
            	
            	 datePickerView.myShow();
             //�򿪵�ѡ�б�Ի���?    
            }           
                 }
               );
        //������Ļ����
        /* ll.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
        	    @Override
        	    public boolean onPreDraw() {
        	    	ll.getViewTreeObserver().removeOnPreDrawListener(this);
        	    	ll.buildDrawingCache();
        	    	
        	         bmp = ll.getDrawingCache();
        	       System.out.println(bmp);
        	        return true;
        	    }
        	});*/
         
         
         t7.setOnClickListener(
                 new OnClickListener(){
            @Override
            public void onClick(View v){
            	
            //	e1.setText(z);
            	c=Calendar.getInstance();
            	DatePickerView datePickerView = new DatePickerView(getActivity(),R.style.CustomDialog,
            			new DatePickerView.OnDateSetListener() {
            			@Override
            			public void onDateSet(DatePicker view, int yearz,
            			int monthOfYearz, int dayOfMonthz,String e, Bitmap bmp1) {
            				
            		    	
            		    	
            		         
            				
            				 zyear =yearz;
            		          zmonth=monthOfYearz+1;
            		          zday=dayOfMonthz;	
            				 zdelta = intervalDay(year, month, day, zyear, zmonth, zday);
            				b3.setText(""+zdelta);
            				
            				z = e;
            				
            				
            				
            				//System.out.println(e1.getText().toString());
            				//z = e1.getText().toString();
            				//System.out.println(z);
            			
            			t7.setText(z);	
            			//System.out.println(bmp);
            			}
            			
            			}, zyear, zmonth-1, zday,z,bmp);
            	
            	/*View   	view = inflater.inflate(R.layout.date_picker_dialog, null);
            	dt = (LinearLayout)view.findViewById(R.id.datepicker);
            		
            	*/
            	
            	/*WindowManager m = getActivity().getWindowManager();  
            	 Display d = m.getDefaultDisplay(); // ��ȡ��Ļ������  
            	 WindowManager.LayoutParams p = datePickerView.getWindow().getAttributes(); // ��ȡ�Ի���ǰ�Ĳ���ֵ  
            	  p.height = (int) (d.getHeight() * 0.8); // �߶�����Ϊ��Ļ��0.5  
            	 p.width = (int) (d.getWidth() * 0.8);*/
            			datePickerView.myShow();
            			
            			
            	
            }           
                 }
               );
        
        t6.setOnClickListener(
                 new OnClickListener(){
            @Override
            public void onClick(View v){ 
            	c=Calendar.getInstance();
            	DatePickerView datePickerView = new DatePickerView(getActivity(),R.style.CustomDialog,
            			new DatePickerView.OnDateSetListener() {
            			@Override
            			public void onDateSet(DatePicker view, int yearz,
            			int monthOfYearz, int dayOfMonthz,String e, Bitmap bmp1) {
            				 zyear1 =yearz;
            		          zmonth1=monthOfYearz+1;
            		          zday1=dayOfMonthz;	
            				 zdelta1 = intervalDay(year, month, day, zyear1, zmonth1, zday1);
            				b2.setText(""+zdelta1);
            				//System.out.println(z1);
            				//e1.setText(z1);
            				//z1 = e1.getText().toString();
            				z1=e;
            				t6.setText(z1);
            			
            			}
            			}, zyear1, zmonth1-1, zday1,z1,bmp);
            			datePickerView.myShow();
            	
            }           
                 }
               );
         t8.setOnClickListener(
                 new OnClickListener(){
            @Override
            public void onClick(View v){ 
            	c=Calendar.getInstance();
            	DatePickerView datePickerView = new DatePickerView(getActivity(),R.style.CustomDialog,
            			new DatePickerView.OnDateSetListener() {
            			@Override
            			public void onDateSet(DatePicker view, int yearz,
            			int monthOfYearz, int dayOfMonthz,String e, Bitmap bmp1) {
            				 zyear2 =yearz;
            		          zmonth2=monthOfYearz+1;
            		          zday2=dayOfMonthz;	
            				 zdelta2 = intervalDay(year, month, day, zyear2, zmonth2, zday2);
            				b4.setText(""+zdelta2);
            				//System.out.println(z1);
            				//e1.setText(z1);
            				//z1 = e1.getText().toString();
            				z2=e;
            				t8.setText(z2);
            			
            			}
            			}, zyear2, zmonth2-1, zday2,z2,bmp);
            			datePickerView.myShow();
            	
            }           
                 }
               );
         t9.setOnClickListener(
                 new OnClickListener(){
            @Override
            public void onClick(View v){ 
            	c=Calendar.getInstance();
            	DatePickerView datePickerView = new DatePickerView(getActivity(),R.style.CustomDialog,
            			new DatePickerView.OnDateSetListener() {
            			@Override
            			public void onDateSet(DatePicker view, int yearz,
            			int monthOfYearz, int dayOfMonthz,String e, Bitmap bmp1) {
            				 zyear3 =yearz;
            		          zmonth3=monthOfYearz+1;
            		          zday3=dayOfMonthz;	
            				 zdelta3 = intervalDay(year, month, day, zyear3, zmonth3, zday3);
            				b5.setText(""+zdelta3);
            				//System.out.println(z1);
            				//e1.setText(z1);
            				//z1 = e1.getText().toString();
            				z3=e;
            				t9.setText(z3);
            			
            			}
            			}, zyear3, zmonth3-1, zday3,z3,bmp);
            			datePickerView.myShow();
            	
            }           
                 }
               );
        // t7 = (TextView)rootView.findViewById(R.id.textView7);
        //e1 = (EditText)rootView.findViewById(R.id.edittext1);
      //  e2 = (EditText)rootView.findViewById(R.id.edittext2);
      //  e3 = (EditText)rootView.findViewById(R.id.edittext3);
      //  e4 = (EditText)rootView.findViewById(R.id.edittext4);
       
        int[] m = new int[]{0,1,2,2, 3,3,3, 4,4,5,5,5, 6,6, 6, 7,8,9,9,10,10,11,12,12};
        int[] d = new int[]{0,1,14,19,5,8,12,1,5,1,4,10,1,20,21,1,1,8,10,1,2,27,24,25};
        String[] j = new String[]{"a","Ԫ��","���˽�","����","Ԫ��","38��Ů��","ֲ����","���˽�","����","�Ͷ���",
        		"���������?","ĸ�׽�","��ͯ��","����","���׽�","������","������","����","��ʦ��","����","������","�ж���","ƽ��ҹ","ʥ����"};
        String jieri =null ;
        int jyear=0;
        int jmonth=0;
        int jday=0;
        for(int m1=1; m1<=22; m1++){
        	if(month==m[m1]&&month==m[m1+1]){
        		if(day<=d[m1]&&day!=d[m1-1]){
        			jieri =j[m1];
        			jmonth = m[m1];
        			jday = d[m1];
        		
        		}else{
        			jieri= j[m1+1];
        			jmonth = m[m1+1];
        			jday = d[m1+1];
        			
        		}
        	}else if(month==m[m1]&&month!=m[m1+1]){
        		if(day<=d[m1]){
        			jieri =j[m1];
        			jmonth = m[m1];
        			jday = d[m1];
        		
        		}else{
        			jieri =j[m1+1];
        			jmonth = m[m1+1];
        			jday = d[m1+1];
        		
        		}
        	}
        }
        if(jmonth>=1&&jmonth<=7)jyear = 2015;
        else jyear = 2014;
        int deltajieri = intervalDay(year, month, day, jyear, jmonth, jday) ;
        if(deltajieri==0){
        	int i = jieri.length();
     	   SpannableString ss = new SpannableString("������"+jieri+"Ŷ��");
     	   
     	   ss.setSpan(new ForegroundColorSpan(Color.parseColor("#33FFFF")), 3, 3+i,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            ss.setSpan(new AbsoluteSizeSpan(ziti), 3, 3+i,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            ss.setSpan(new StyleSpan(Typeface.ITALIC), 3, 3+i,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            t5.setText(ss);
        	
        	}
        else{ 
        	int k = (deltajieri+"").length();
        	int i = jieri.length();
      	   SpannableString ss = new SpannableString("����"+deltajieri+"��͵���?"+jieri+"����");
      	   
      	   ss.setSpan(new ForegroundColorSpan(Color.parseColor("#33FFFF")), 2, 2+k,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
             ss.setSpan(new AbsoluteSizeSpan(ziti), 2, 2+k,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
             ss.setSpan(new StyleSpan(Typeface.ITALIC), 2, 2+k,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
             
             ss.setSpan(new ForegroundColorSpan(Color.parseColor("#33FFFF")), 6+k, 6+k+i,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
             ss.setSpan(new AbsoluteSizeSpan(ziti), 6+k, 6+k+i,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
             ss.setSpan(new StyleSpan(Typeface.ITALIC), 6+k, 6+k+i,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
             t5.setText(ss);
        	}
        
        int deltaweek = 5-t.weekDay;
        if(deltaweek==0){t1.setText("�����嵽�ˣ���������Զ��");}else
        if(deltaweek==-1||deltaweek==5){
        	t1.setText("˫�������ڵ�������");
        }else{
        	SpannableString ss = new SpannableString( "�������廹��"+deltaweek+"�죡");
     	   
     	   ss.setSpan(new ForegroundColorSpan(Color.parseColor("#33FFFF")), 6, 7,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            ss.setSpan(new AbsoluteSizeSpan(ziti), 6, 7,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            ss.setSpan(new StyleSpan(Typeface.ITALIC),6, 7,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
           
        	t1.setText(ss);}
        
        int aoyun = intervalDay(year, month, day, 2016,8,5);
      
        if(aoyun>=-20&&aoyun<=0){
        	t2.setText("���ڵ��ˣ������˻�ඣ���");
        }else if(aoyun<=-20){
        	t2.setText("���²�����ʾ�½���˵���ʱŶ����?");
        	}else{
        		int i = (aoyun+"").length();
	        	   SpannableString ss = new SpannableString("��������˻ỹ��?"+aoyun+"�죡");
	        	   
	        	   ss.setSpan(new ForegroundColorSpan(Color.parseColor("#33FFFF")), 8, 8+i,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
	               ss.setSpan(new AbsoluteSizeSpan(ziti), 8, 8+i,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
	               ss.setSpan(new StyleSpan(Typeface.ITALIC), 8, 8+i,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
	               t2.setText(ss);
       }
        
        int shijiebei = intervalDay(year, month, day, 2018, 6, 8);
        if(shijiebei>=-32&&shijiebei<=0){
        	t3.setText("���ڵ��ˣ������˻�ඣ���");
        }else if(aoyun<=-33){
        	t3.setText("���²�����ʾ�½���˵���ʱŶ����?");
        	}else{
        		int i = (shijiebei+"").length();
        		SpannableString ss = new SpannableString("����˹���籭����"+shijiebei+"�죡");
	        	   
	        	   ss.setSpan(new ForegroundColorSpan(Color.parseColor("#33FFFF")), 8, 8+i,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
	               ss.setSpan(new AbsoluteSizeSpan(ziti), 8, 8+i,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
	               ss.setSpan(new StyleSpan(Typeface.ITALIC), 8, 8+i,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
	               t3.setText(ss);
      }
        
        int gaokao = intervalDay(year, month, day, 2015, 6, 7);
        if(gaokao>=-2&&gaokao<=0){
        	t4.setText("ͯЬ���߿���,�����ֻ�������");
        }else if(gaokao<=-3){
        	t4.setText("ͯЬ�����²�����ʾ����ĸ߿�����ʱŶ����?");
        	}else{
        		int i = (gaokao+"").length();
        		SpannableString ss = new SpannableString("2015��߿������?"+gaokao+"�죡");
	        	   
	        	   ss.setSpan(new ForegroundColorSpan(Color.parseColor("#33FFFF")), 10, 10+i,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
	               ss.setSpan(new AbsoluteSizeSpan(ziti), 10, 10+i,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
	               ss.setSpan(new StyleSpan(Typeface.ITALIC), 10, 10+i,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
	               t4.setText(ss);
       }
        
       //��ȡ�������� 
        SharedPreferences sp = getActivity().getSharedPreferences("Edittext",  
                getActivity().MODE_PRIVATE);  
        // music_progressΪXML�ļ����ļ���  
        xyear=sp.getInt("xyear",year);
        xmonth=sp.getInt("xmonth",month);
        xday=sp.getInt("xday",day);
        zyear=sp.getInt("zyear", year) ;
         zmonth=sp.getInt("zmonth",month);
         zday=sp.getInt("zday",day);
         zyear1=sp.getInt("zyear1", year) ;
         zmonth1=sp.getInt("zmonth1",month);
         zday1=sp.getInt("zday1",day);
         zyear2=sp.getInt("zyear2", year) ;
         zmonth2=sp.getInt("zmonth2",month);
         zday2=sp.getInt("zday2",day);
         zyear3=sp.getInt("zyear3", year) ;
         zmonth3=sp.getInt("zmonth3",month);
         zday3=sp.getInt("zday3",day);
         zdelta=sp.getInt("zdelta",zdelta);
         zdelta1=sp.getInt("zdelta1",zdelta1);
         zdelta2=sp.getInt("zdelta2",zdelta2);
         zdelta3=sp.getInt("zdelta3",zdelta3);
         
         xwk =sp.getInt("xwk", xwk);
         
         z = sp.getString("z", null);
         z1 =sp.getString("z1", null);
         z2 = sp.getString("z2", null);
         z3 = sp.getString("z3", null);
         
         
       //Ϊ�¼���ʼ��
          t7.setText(z);
          t6.setText(z1);
          t8.setText(z2);
          t9.setText(z3);
          b2.setText(""+zdelta1);
          b3.setText(""+zdelta);
          b4.setText(""+zdelta2);
          b5.setText(""+zdelta3);
          if(xwk<1){
        	  
       	   b1.setText("��ѡ��ѧ��һ�������ڣ�");
       	   }else if(xwk>23)
        	   b1.setText("���ѧ��̫���ˣ�?");
       	else{
          int i = (xwk+"").length();
          
          SpannableString ss = new SpannableString("�����Ǳ�ѧ�ڵ�"+xwk+"�ܣ�");
   	   
   	   ss.setSpan(new ForegroundColorSpan(Color.parseColor("#33FFFF")), 7, 7+i,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
          ss.setSpan(new AbsoluteSizeSpan(ziti), 7, 7+i,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
          ss.setSpan(new StyleSpan(Typeface.ITALIC), 1, 7+i,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
          b1.setText(ss);
        }
        
        return rootView;
        
    }
	
	
	
	//��������
	@Override  
    public void onDestroy() {
		super.onDestroy();
		SharedPreferences sp = getActivity().getSharedPreferences("Edittext",  
        getActivity().MODE_PRIVATE); 
		Editor editor = sp.edit();
		//����
		editor.putInt("xyear",xyear );
		editor.putInt("xmonth",xmonth );
		editor.putInt("xday ",xday );
		//�Զ���
		editor.putInt("zyear",zyear );
		editor.putInt("zmonth",zmonth );
		editor.putInt("zday",zday );
		editor.putInt("zyear1",zyear1 );
		editor.putInt("zmonth1",zmonth1 );
		editor.putInt("zday1",zday1 );
		editor.putInt("zyear2",zyear2 );
		editor.putInt("zmonth2",zmonth2 );
		editor.putInt("zday2",zday2 );
		editor.putInt("zyear3",zyear3 );
		editor.putInt("zmonth3",zmonth3 );
		editor.putInt("zday3",zday3 );
		editor.putInt("zdelta",zdelta );
		editor.putInt("zdelta1",zdelta1 );
		editor.putInt("zdelta2",zdelta2 );
		editor.putInt("zdelta3",zdelta3 );
		editor.putString("z", z);
		editor.putString("z1", z1);
		editor.putString("z2", z2);
		editor.putString("z3", z3);

		editor.putInt("xwk", xwk);
				editor.commit();
		
	}
	
	
	 
	
	
	public static int  intervalDay(int year,int mounth ,int day,int newyear,int newmounth,int newday){
		  int intervalday=0;
		  int yday1=0;
		  int yday2=0;
		  int nmday=0;
		  int mday=0;
		 int m[] = new int[] {31,29,31,30,31,30,31,31,30,31,30,31};
		  if((year%4==0&&year%100!=0)||(year%400==0))
		  {
		       if((newyear%4==0&&newyear%100!=0)||(newyear%400==0)){
		    	   if(newyear-year<0){
		    		   for(int i=1;i<=year-newyear;i++){
		    		   if(((newyear+i)%4==0&&(newyear+i)%100!=0)||((newyear+i)%400==0))
		 			  {
		    			   yday1 = yday1+366;
		 			  }else{
		 				  
		 				  yday2 = yday2+365;
		 			  } 
		    		   
		    	   }
		    	   for(int i=0;i<newmounth-1;i++){
		    		nmday = nmday+m[i];
		    		   
		    		  
		    		 
		    	   }
		    	   for(int i=0;i<mounth-1;i++){
			    		mday = mday+m[i];
		    	   }
		    	   intervalday=-(yday1+yday2+day+mday-nmday-newday);
		    	   }else{
		    	   for(int i=1;i<=newyear-year;i++){
		    		   if(((year+i)%4==0&&(year+i)%100!=0)||((year+i)%400==0))
		 			  {
		    			   yday1 = yday1+366;
		 			  }else{
		 				  
		 				  yday2 = yday2+365;
		 			  } 
		    		   
		    	   }
		    	   for(int i=0;i<newmounth-1;i++){
		    		nmday = nmday+m[i];
		    		   
		    		  
		    		 
		    	   }
		    	   for(int i=0;i<mounth-1;i++){
			    		mday = mday+m[i];
		    	   }
		    	   intervalday=yday1+yday2+nmday+newday-mday-day;
		    	   }
		    	   
		    			   }else{
		    				   if(newyear-year<0){
					    		   for(int i=1;i<=year-newyear;i++){
					    		   if(((newyear+i)%4==0&&(newyear+i)%100!=0)||((newyear+i)%400==0))
					 			  {
					    			   yday1 = yday1+366;
					 			  }else{
					 				  
					 				  yday2 = yday2+365;
					 			  } 
					    		   
					    	   }
					    	   for(int i=0;i<newmounth-1;i++){
					    		nmday = nmday+m[i];
					    		   
					    		  
					    		 
					    	   }
					    	   for(int i=0;i<mounth-1;i++){
						    		mday = mday+m[i];
					    	   }
					    	   intervalday=-(yday1+yday2+day+mday-nmday-newday);/////
					    	   }else{
					    	   for(int i=1;i<=newyear-year;i++){
					    		   if(((year+i)%4==0&&(year+i)%100!=0)||((year+i)%400==0))
					 			  {
					    			   yday1 = yday1+366;
					 			  }else{
					 				  
					 				  yday2 = yday2+365;
					 			  } 
					    		   
					    	   }
					    	   for(int i=0;i<newmounth-1;i++){
					    		nmday = nmday+m[i];
					    		   
					    		  
					    		 
					    	   }
					    	   for(int i=0;i<mounth-1;i++){
						    		mday = mday+m[i];
					    	   }
					    	   intervalday=yday1+yday2+nmday+newday-mday-day;
					    	   }
					    	   
					    			   
		    			   }
		  }else{ 
			  if((newyear%4==0&&newyear%100!=0)||(newyear%400==0)){
	    	   if(newyear-year<0){
	    		   for(int i=1;i<=year-newyear;i++){
	    		   if(((newyear+i)%4==0&&(newyear+i)%100!=0)||((newyear+i)%400==0))
	 			  {
	    			   yday1 = yday1+366;
	 			  }else{
	 				  
	 				  yday2 = yday2+365;
	 			  } 
	    		   
	    	   }
	    	   for(int i=0;i<newmounth-1;i++){
	    		nmday = nmday+m[i];
	    		   
	    		  
	    		 
	    	   }
	    	   for(int i=0;i<mounth-1;i++){
		    		mday = mday+m[i];
	    	   }
	    	   intervalday=-(yday1+yday2+mday+day-nmday-newday);///
	    	   }else{
	    	   for(int i=1;i<=newyear-year;i++){
	    		   if(((year+i)%4==0&&(year+i)%100!=0)||((year+i)%400==0))
	 			  {
	    			   yday1 = yday1+366;
	 			  }else{
	 				  
	 				  yday2 = yday2+365;
	 			  } 
	    		   
	    	   }
	    	   for(int i=0;i<newmounth-1;i++){
	    		nmday = nmday+m[i];
	    		   
	    		  
	    		 
	    	   }
	    	   for(int i=0;i<mounth-1;i++){
		    		mday = mday+m[i];
	    	   }
	    	   intervalday=yday1+yday2+nmday+newday-mday-day;
	    	   }
	    	   
	    			   }else{
	    				   if(newyear-year<0){
				    		   for(int i=1;i<=year-newyear;i++){
				    		   if(((newyear+i)%4==0&&(newyear+i)%100!=0)||((newyear+i)%400==0))
				 			  {
				    			   yday1 = yday1+366;
				 			  }else{
				 				  
				 				  yday2 = yday2+365;
				 			  } 
				    		   
				    	   }
				    	   for(int i=0;i<newmounth-1;i++){
				    		nmday = nmday+m[i];
				    		   
				    		  
				    		 
				    	   }
				    	   for(int i=0;i<mounth-1;i++){
					    		mday = mday+m[i];
				    	   }
				    	   intervalday=-(yday1+yday2+mday+day-nmday-newday);
				    	   }else{
				    	   for(int i=1;i<=newyear-year;i++){
				    		   if(((year+i)%4==0&&(year+i)%100!=0)||((year+i)%400==0))
				 			  {
				    			   yday1 = yday1+366;
				 			  }else{
				 				  
				 				  yday2 = yday2+365;
				 			  } 
				    		   
				    	   }
				    	   for(int i=0;i<newmounth-1;i++){
				    		nmday = nmday+m[i];
				    		   
				    		  
				    		 
				    	   }
				    	   for(int i=0;i<mounth-1;i++){
					    		mday = mday+m[i];
				    	   }
				    	   intervalday=yday1+yday2+nmday+newday-mday-day;
				    	   }
				    	   
				    			   
	    			   }}
		  
			    
		return intervalday;
		
		  }



	/*@Override
	public void onClick(View arg0) {
		Button btn = (Button)arg0;
		if(btn.findViewById(R.id.button1)!=null){
			 c=Calendar.getInstance();//��ȡ���ڶ���
        	 Zhoudatepk datePickerView = new Zhoudatepk(getActivity(),R.style.CustomDialog,
         			new Zhoudatepk.OnDateSetListener() {
         			@Override
         			public void onDateSet(DatePicker view, int yearz,
         			int monthOfYearz, int dayOfMonthz,String e, Bitmap bmp1) { 
	
	    	 xyear=yearz;     
	           xmonth = monthOfYearz+1;
	           xday  = dayOfMonthz;
	         
	         Calendar cal=Calendar.getInstance(); 
	         cal.setTime(new Date(year,month,day+2));
	         
	         int wk = cal.get(Calendar.WEEK_OF_YEAR);
	      
	          
	         Calendar cal1=Calendar.getInstance();	
	         cal1.setTime(new Date(xyear,xmonth,xday+2));
	         int  wk1 = cal1.get(Calendar.WEEK_OF_YEAR);

           xwk = wk-wk1+1;
          
           if(xwk<1){
        	  
        	   b1.setText("��ѡ��ѧ��һ�������ڣ�");
//        	   int i = (xwk+"").length();
//        	   SpannableString ss = new SpannableString( "�����õ����ڵ����ڻ���"+xwk+"�ܣ�");
//        	   
//        	   ss.setSpan(new ForegroundColorSpan(Color.parseColor("#33FFFF")), 11, 11+i,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//               ss.setSpan(new AbsoluteSizeSpan(30), 11, 11+i,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//               ss.setSpan(new StyleSpan(Typeface.ITALIC), 1, 11+i,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//               b1.setText(ss);
        	   }
           else if(xwk>23)
        	   b1.setText("���ѧ��̫���ˣ�?");
           else{
        	   int i = (xwk+"").length();
        	   SpannableString ss = new SpannableString("�����Ǳ�ѧ�ڵ�"+xwk+"�ܣ�");
    	   
        	   ss.setSpan(new ForegroundColorSpan(Color.parseColor("#33FFFF")), 7, 7+i,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
               ss.setSpan(new AbsoluteSizeSpan(ziti), 7, 7+i,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
               ss.setSpan(new StyleSpan(Typeface.ITALIC), 1, 7+i,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
               b1.setText(ss);
	       // b1.setText("�����Ǳ�ѧ�ڵ�"+xwk+"�ܣ�"); 
	        
           }
	      
	       
	     }           
	           },
	           xyear,     //�������?
	           xmonth-1,     //�����·�
	           xday     //��������    
	           ,z0,bmp );
	        
//	         WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
//         	dialog.getWindow().setAttributes(lp);  
//         	//lp.height=(int)(566);
//         	dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
	          
        	
        	 datePickerView.myShow();
         //�򿪵�ѡ�б�Ի���?    
        } 
		
	}*/
	
}

/*DatePickerDialog dialog=null;
//onCreateDialog(0);//��дonClick����
 c=Calendar.getInstance();//��ȡ���ڶ���
 dialog=new DatePickerDialog(   //����DatePickerDialog����
   getActivity(),
   new DatePickerDialog.OnDateSetListener(){ //����OnDateSetListener������
public void onDateSet(DatePicker dp, int year, int month,int dayOfMonth) {  

t6.setText("��ѡ���ˣ�"+year+"��"+month+"��"+dayOfMonth+"��");
}           
   },
   c.get(Calendar.YEAR),     //�������?
   c.get(Calendar.MONTH),     //�����·�
   c.get(Calendar.DAY_OF_MONTH)      //��������    
);


dialog.show();*/
//�򿪵�ѡ�б�Ի���?    


/*
 <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="fill_parent"
    android:layout_height="fill_parent"
    android:id="@+id/ll"
    android:orientation="vertical"
     android:background="#FFF" >

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginLeft="3dp"
        android:layout_weight="3"
        android:orientation="vertical" >

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content" >
            <ImageView
                android:id="@+id/imageView1"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                 
                android:layout_weight="0.765"
                android:src="@drawable/anniu4" />
 <TextView
                android:id="@+id/textView1"
                android:layout_width="fill_parent"
                android:layout_height="wrap_content"
                 android:singleLine="true"
                android:paddingLeft="15dp"
                android:layout_weight="1.13"
                android:textSize="19dp"
                android:layout_marginTop="8dp"
                android:text="TextView" />
        </LinearLayout>
         <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content" >
            <ImageView
                android:id="@+id/imageView2"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                
                android:layout_weight="0.765"
                android:src="@drawable/anniu4" />
            <TextView
                android:id="@+id/textView2"
                android:layout_width="fill_parent"
                android:layout_height="wrap_content"
                android:singleLine="true"
                android:paddingLeft="15dp"
                android:layout_marginTop="8dp"
                android:textSize="19dp"
                android:text="TextView"
                android:layout_weight="1" />
        </LinearLayout>
         <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content" >

            <ImageView
                android:id="@+id/imageView3"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_weight="0.765"
                android:src="@drawable/anniu4" />

            <TextView
                android:id="@+id/textView3"
                android:layout_width="fill_parent"
                android:layout_height="wrap_content"
                android:singleLine="true"
                 android:paddingLeft="15dp"
                android:layout_marginTop="8dp"
                android:textSize="19dp"
                android:text="TextView" 
                android:layout_weight="1"/>
        </LinearLayout>
         <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content" >
            <ImageView
                android:id="@+id/imageView4"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_weight="0.765"
                android:src="@drawable/anniu4" />
            <TextView
                android:id="@+id/textView4"
                android:layout_width="fill_parent"
                android:layout_height="wrap_content"
                android:singleLine="true"
                 android:paddingLeft="15dp"
                android:layout_marginTop="8dp"
                android:textSize="19dp"
                android:text="TextView"
                android:layout_weight="1" />
        </LinearLayout>
         <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content" >
              <ImageView
                android:id="@+id/imageView5"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_weight="0.765"
                android:src="@drawable/anniu4" />
             <TextView
                android:id="@+id/textView5"
                android:layout_width="fill_parent"
                android:layout_height="wrap_content"
                android:singleLine="true"
                 android:paddingLeft="15dp"
                android:layout_marginTop="8dp"
                android:textSize="19dp"
                android:text="TextView"
                android:layout_weight="1" />
        </LinearLayout>
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content" >
         <ImageView
                android:id="@+id/imageView6"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_weight="0.765"
                android:src="@drawable/anniu4" />
             <Button
                android:id="@+id/button1"
                android:layout_width="fill_parent"
                android:layout_height="wrap_content"
                android:background="@drawable/item"
                android:textColor="@color/zhouanniu"
                android:text="Button"
                android:layout_weight="1" />
    </LinearLayout>

        <TextView
            android:id="@+id/textView10"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginTop="15dp"
            android:textStyle="bold"
            android:text="������" />

    </LinearLayout>
    
    


    
    
    
    
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_weight="10"
        android:orientation="horizontal" >

        <LinearLayout
            android:layout_width="fill_parent"
            android:layout_height="match_parent"
             android:layout_weight="1"
            android:orientation="vertical" >

            

            <TextView
                android:id="@+id/textView6"
                android:layout_width="fill_parent"
                android:layout_height="33dp"
                android:paddingLeft="3dp"
                android:textSize="19dp"
                android:textColor="@color/zhouanniu"
                android:background="@drawable/item"
                android:singleLine="true"
             
                android:text="������õ����?" />

            <Button
                android:id="@+id/button2"
                android:layout_width="fill_parent"
                android:layout_height="wrap_content"
               android:background="@drawable/anniu5"
                android:text="Button" />

            <TextView
                android:id="@+id/textView8"
                android:layout_width="fill_parent"
                android:layout_height="33dp"
                android:layout_marginTop="15dp"
                android:paddingLeft="3dp"
                android:textSize="19dp"
                android:textColor="@color/zhouanniu"
                android:background="@drawable/item"
                android:singleLine="true"
             
                android:text="������õ����?"  />

            <Button
                android:id="@+id/button4"
               android:layout_width="fill_parent"
                android:layout_height="wrap_content"
               android:background="@drawable/anniu5"
                android:text="Button" />

        </LinearLayout>

        <LinearLayout
            android:layout_width="fill_parent"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:orientation="vertical" >

            <TextView
                android:id="@+id/textView7"
                android:layout_width="match_parent"
                android:layout_height="33dp"
                android:background="@drawable/item"
                android:paddingLeft="3dp"
                android:singleLine="true"
                android:text="������õ����?"
                android:textColor="@color/zhouanniu"
                android:textSize="19dp" />

            <Button
                android:id="@+id/button3"
                android:layout_width="fill_parent"
                android:layout_height="wrap_content"
              android:background="@drawable/anniu5"
                android:text="Button" />

            <TextView
                android:id="@+id/textView9"
               android:layout_width="fill_parent"
                android:layout_height="33dp"
                android:layout_marginTop="15dp"
                android:paddingLeft="3dp"
                android:textSize="19dp"
                android:textColor="@color/zhouanniu"
                android:background="@drawable/item"
                android:singleLine="true"
             
                android:text="������õ����?"  />

            <Button
                android:id="@+id/button5"
               android:layout_width="fill_parent"
                android:layout_height="wrap_content"
               android:background="@drawable/anniu5"
                android:text="Button"/>

        </LinearLayout>

    </LinearLayout>

</LinearLayout>
*/
