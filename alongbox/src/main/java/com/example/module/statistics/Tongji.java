package com.example.module.statistics;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.main.R;

import org.apache.commons.math3.stat.descriptive.moment.GeometricMean;
import org.apache.commons.math3.stat.descriptive.moment.Kurtosis;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.SemiVariance;
import org.apache.commons.math3.stat.descriptive.moment.Skewness;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import org.apache.commons.math3.stat.descriptive.moment.Variance;
import org.apache.commons.math3.stat.descriptive.rank.Max;
import org.apache.commons.math3.stat.descriptive.rank.Median;
import org.apache.commons.math3.stat.descriptive.rank.Min;
import org.apache.commons.math3.stat.descriptive.rank.Percentile;
import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.apache.commons.math3.stat.descriptive.summary.Sum;
import org.apache.commons.math3.stat.descriptive.summary.SumOfSquares;

import java.lang.reflect.Method;

public class Tongji extends Fragment implements OnClickListener,OnLongClickListener {
	EditText editText_TJ;
    int index_TJ=0;
    
    TextView textView_Pop1 ;
    TextView textView_Pop2 ;
    TextView textView_Pop3 ;
    TextView textView_Pop4 ;
    TextView textView_Pop5 ;
    TextView textView_Pop6 ;
    TextView textView_Pop7 ;
    TextView textView_Pop8 ;
    TextView textView_Pop9 ;
    TextView textView_Pop10 ;
    TextView textView_Pop11 ;
    TextView textView_Pop12 ;
    TextView textView_Pop13 ;
    TextView textView_Pop14 ;
    Button button_Pop;
    View popupView;
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		//获得屏幕大小
		DisplayMetrics dm = new DisplayMetrics();
		this.getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
		
        View rootView = inflater.inflate(R.layout.fragment_tongji, container, false);
        
        //Textview
         popupView = this.getActivity().getLayoutInflater().inflate(R.layout.tongjipopwindow, null);
         textView_Pop1 = (TextView)popupView.findViewById(R.id.textView_Pop1);
         textView_Pop2 = (TextView)popupView.findViewById(R.id.textView_Pop2);
         textView_Pop3 = (TextView)popupView.findViewById(R.id.textView_Pop3); 
         textView_Pop4 = (TextView)popupView.findViewById(R.id.textView_Pop4);
         textView_Pop5 = (TextView)popupView.findViewById(R.id.textView_Pop5);
         textView_Pop6 = (TextView)popupView.findViewById(R.id.textView_Pop6);
         textView_Pop7 = (TextView)popupView.findViewById(R.id.textView_Pop7);
         textView_Pop8 = (TextView)popupView.findViewById(R.id.textView_Pop8);
         textView_Pop9 = (TextView)popupView.findViewById(R.id.textView_Pop9);
         textView_Pop10 = (TextView)popupView.findViewById(R.id.textView_Pop10);
         textView_Pop11 = (TextView)popupView.findViewById(R.id.textView_Pop11);
         textView_Pop12 = (TextView)popupView.findViewById(R.id.textView_Pop12);
         textView_Pop13 = (TextView)popupView.findViewById(R.id.textView_Pop13);
         textView_Pop14 = (TextView)popupView.findViewById(R.id.textView_Pop14);
          button_Pop = (Button)popupView.findViewById(R.id.button_TJPop);
        
      //Edittext
        editText_TJ = (EditText)rootView.findViewById(R.id.editText_TJ);
        //button
        Button guangbiaoL_TJ = (Button)rootView.findViewById(R.id.guangbiaoL_TJ);
        Button guangbiaoR_TJ = (Button)rootView.findViewById(R.id.guangbiaoR_TJ);
        Button douhao_TJ = (Button)rootView.findViewById(R.id.douhao_TJ); 
        Button dian_TJ = (Button)rootView.findViewById(R.id.dian_TJ);
        Button jisuan_TJ = (Button)rootView.findViewById(R.id.jisuan_TJ);
        Button qingchu_TJ = (Button)rootView.findViewById(R.id.qingchu_TJ);
        Button lin_TJ = (Button)rootView.findViewById(R.id.lin_TJ);
        Button yi_TJ = (Button)rootView.findViewById(R.id.yi_TJ);
        Button er_TJ = (Button)rootView.findViewById(R.id.er_TJ);
        Button san_TJ = (Button)rootView.findViewById(R.id.san_TJ);
        Button si_TJ = (Button)rootView.findViewById(R.id.si_TJ);
        Button wu_TJ = (Button)rootView.findViewById(R.id.wu_TJ);
        Button liu_TJ = (Button)rootView.findViewById(R.id.liu_TJ);
        Button qi_TJ = (Button)rootView.findViewById(R.id.qi_TJ);
        Button ba_TJ = (Button)rootView.findViewById(R.id.ba_TJ);
        Button jiu_TJ = (Button)rootView.findViewById(R.id.jiu_TJ);
        
        
        //btn
        guangbiaoL_TJ.setOnClickListener(this);
        guangbiaoR_TJ.setOnClickListener(this);
        douhao_TJ.setOnClickListener(this);
        dian_TJ.setOnClickListener(this);
        jisuan_TJ.setOnClickListener(this);
        qingchu_TJ.setOnClickListener(this);
        qingchu_TJ.setOnLongClickListener(this);
        lin_TJ.setOnClickListener(this);
        yi_TJ.setOnClickListener(this);
        er_TJ.setOnClickListener(this);
        san_TJ.setOnClickListener(this);
        si_TJ.setOnClickListener(this);
        wu_TJ.setOnClickListener(this);
        liu_TJ.setOnClickListener(this);
        qi_TJ.setOnClickListener(this);
        ba_TJ.setOnClickListener(this);
        jiu_TJ.setOnClickListener(this);
        chujiaodian(editText_TJ);
        //获取保存数据 
        SharedPreferences sp = getActivity().getSharedPreferences("Edittext",  
                getActivity().MODE_PRIVATE);  
        // music_progress为XML文件的文件名  
        editText_TJ.setText(sp.getString("edittextA", null));
    return  rootView;   
	}
	//保存数据
		 public void onDestroy() {
				super.onDestroy();
				SharedPreferences sp = getActivity().getSharedPreferences("Edittext",  
		        getActivity().MODE_PRIVATE); 
				Editor editor = sp.edit();
				//星期
				editor.putString("edittextA", editText_TJ.getText().toString());	
				editor.commit();
				}
	@Override
	public boolean onLongClick(View arg0) {
				
		editText_TJ.setText("");
				index_TJ=0;
		return false;	
	}

	@Override
	public void onClick(View arg0) {
		Editable edit = editText_TJ.getEditableText();//获取EditText的文字
		
		index_TJ = editText_TJ.getSelectionStart();
		
		switch (arg0.getId()) {
		
		case R.id.JZbutton_A:
	case R.id.guangbiaoL_TJ:	
		
			if(index_TJ==0){}
			else
			--index_TJ;

		
		break;
	case R.id.guangbiaoR_TJ:
		
		if(index_TJ==editText_TJ.getText().toString().length()){}else
			++index_TJ;
			
		
		break;
	case R.id.douhao_TJ:
	
			if (index_TJ < 0 || index_TJ >= edit.length() ){
				edit.append("＿");
			}else{
				edit.insert(index_TJ,"＿");//光标所在位置插入文字
			 }
			
		
		++index_TJ;
		
		break;
	case R.id.dian_TJ:
		
		if (index_TJ < 0 || index_TJ >= edit.length() ){
			edit.append(".");
		}else{
			edit.insert(index_TJ,".");//光标所在位置插入文字
		 }
		
	
	++index_TJ;
	
	break;
	case R.id.jisuan_TJ:	
	
		//矩阵字符串
    	String JZA = editText_TJ.getText().toString();
    	//获取矩阵
    	String[] y1 = JZA.split("＿");
    	//String[] y = y1[0].split(",");
    	double[] vals = new double[y1.length];
    	for(int i = 0; i<y1.length;i++)
    	{
    		//String[] y2 = y1[i].split(",");
    		//for(int j = 0;j<y2.length;j++)
    	//	{
    			try{
    				vals[i] = Double.parseDouble( y1[i] );
    				 
    			}
    			catch(Exception e)
    			{
    				Toast.makeText(getActivity(), "请检查格式是否正确！", Toast.LENGTH_SHORT).show();
    				return;
    			}
    		//}
    		
    	}
    	 Min min = new Min(); 
   	  Max max = new Max();
   	 Sum sum = new Sum(); //和
   	 Product product = new Product();//乘积 
   	  Median median = new Median(); // 中位数
   	 Percentile percentile = new Percentile(); // 百分位数 
    	Mean mean = new Mean(); // 算术平均数 
     	  GeometricMean geoMean = new GeometricMean(); //几何平均数
    	 SumOfSquares sumOfSquares = new SumOfSquares(); // 平方和
    	 Variance variance = new Variance();//方差 
    	 SemiVariance semiVariance = new SemiVariance();//半方差
    	 StandardDeviation StandardDeviation =new StandardDeviation();//标准偏差    	
    	  Kurtosis kurtosis = new Kurtosis(); //Kurtosis,峰度 
    	  Skewness skewness = new Skewness(); //Skewness()偏度;
    	  System.out.println(min.evaluate(vals));
    	 System.out.println(String.valueOf(min.evaluate(vals)));
    	 textView_Pop1.setText("fdsas");
    	 textView_Pop1.setText(String.valueOf(min.evaluate(vals)));
    	 textView_Pop2.setText(String.valueOf(max.evaluate(vals)));
    	 textView_Pop3.setText(String.valueOf(sum.evaluate(vals)));
    	 textView_Pop4.setText(String.valueOf(product.evaluate(vals)));
    	 textView_Pop5.setText(String.valueOf(median.evaluate(vals)));
    	 textView_Pop6.setText(String.valueOf(percentile.evaluate(vals)));	 
    	 textView_Pop7.setText(String.valueOf(mean.evaluate(vals)));
    	 textView_Pop8.setText(String.valueOf(geoMean.evaluate(vals)));
    	 textView_Pop9.setText(String.valueOf(sumOfSquares.evaluate(vals)));
    	 textView_Pop10.setText(String.valueOf(variance.evaluate(vals)));
    	 textView_Pop11.setText(String.valueOf(semiVariance.evaluate(vals)));
    	 textView_Pop12.setText(String.valueOf(StandardDeviation.evaluate(vals)));
    	 textView_Pop13.setText(String.valueOf(kurtosis.evaluate(vals)));
    	 textView_Pop14.setText(String.valueOf(skewness.evaluate(vals)));
    	 
 
    	  //popwindows
    	  PopupWindow mPopupWindow;
         
          mPopupWindow = new PopupWindow(popupView, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, true);
          mPopupWindow.setTouchable(true);
          mPopupWindow.setOutsideTouchable(true);
          mPopupWindow.setBackgroundDrawable(new BitmapDrawable(getResources(), (Bitmap) null));
    	  mPopupWindow.showAsDropDown(editText_TJ);
   	
    	 
		break;
	case R.id.qingchu_TJ:	
	
			if(index_TJ==0){
				index_TJ=1;
			}else{
				edit.delete(index_TJ-1, index_TJ);//光标所在位置插入文字
			 }
			
		
		--index_TJ;
	
		break;
	case R.id.lin_TJ:	
		
			if (index_TJ < 0 || index_TJ >= edit.length() ){
				edit.append("0");
			}else{
				edit.insert(index_TJ,"0");//光标所在位置插入文字
			 }
			
	
		++index_TJ;
	
		break;
	case R.id.yi_TJ:
		
			if (index_TJ < 0 || index_TJ >= edit.length() ){
				edit.append("1");
			}else{
				edit.insert(index_TJ,"1");//光标所在位置插入文字
			 }
	
		
		++index_TJ;
		break;
	case R.id.er_TJ:
		
			if (index_TJ < 0 || index_TJ >= edit.length() ){
				edit.append("2");
			}else{
				edit.insert(index_TJ,"2");//光标所在位置插入文字
			 }
			
		
		++index_TJ;
		break;
	case R.id.san_TJ:
	
			if (index_TJ < 0 || index_TJ >= edit.length() ){
				edit.append("3");
			}else{
				edit.insert(index_TJ,"3");//光标所在位置插入文字
			 }
			
		
		++index_TJ;
		break;
	case R.id.si_TJ:	
		
			if (index_TJ < 0 || index_TJ >= edit.length() ){
				edit.append("4");
			}else{
				edit.insert(index_TJ,"4");//光标所在位置插入文字
			 }
			
		
		++index_TJ;
		break;
	case R.id.wu_TJ:
		
			if (index_TJ < 0 || index_TJ >= edit.length() ){
				edit.append("5");
			}else{
				edit.insert(index_TJ,"5");//光标所在位置插入文字
			 }
			
		
		++index_TJ;
		break;
	case R.id.liu_TJ:	
		
			if (index_TJ < 0 || index_TJ >= edit.length() ){
				edit.append("6");
			}else{
				edit.insert(index_TJ,"6");//光标所在位置插入文字
			 }
			
		
		++index_TJ;
		break;
	case R.id.qi_TJ:
		
			if (index_TJ < 0 || index_TJ >= edit.length() ){
				edit.append("7");
			}else{
				edit.insert(index_TJ,"7");//光标所在位置插入文字
			 }
			
		
		++index_TJ;
		break;
	case R.id.ba_TJ:	
		
			if (index_TJ < 0 || index_TJ >= edit.length() ){
				edit.append("8");
			}else{
				edit.insert(index_TJ,"8");//光标所在位置插入文字
			 }
			
	
		++index_TJ;
		break;
	case R.id.jiu_TJ:	
	
			if (index_TJ < 0 || index_TJ >= edit.length() ){
				edit.append("9");
			}else{
				edit.insert(index_TJ,"9");//光标所在位置插入文字
			 }
			
	
		++index_TJ;
		break;
		
}
	if(editText_TJ.hasFocus()){
		editText_TJ.setSelection(index_TJ);
		
	
		
	}
	}
	//除去焦点	
			public void chujiaodian(EditText et){
				et.setImeOptions(EditorInfo.IME_FLAG_NO_EXTRACT_UI);  

			      if (android.os.Build.VERSION.SDK_INT <= 10) {
			  		
			          et.setInputType(InputType.TYPE_NULL);
			  } else {
			  	getActivity().getWindow().setSoftInputMode(LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
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
	}
