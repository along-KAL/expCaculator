package com.example.module.matrix;

import android.app.Fragment;
import android.content.ClipboardManager;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.Toast;

import com.example.main.R;
import com.example.weight.AlertDialog;

import java.lang.reflect.Method;
import java.text.DecimalFormat;

import Jama.Matrix;

public class Juzhen extends Fragment implements OnClickListener,OnLongClickListener {
	int index_JZA=0;
	int index_JZB=0;//光标
	EditText JU_A;
	EditText JU_B;
	Button JSbt_A;
	Button JSbt_B;
	Button JSbt_AB;
	int sign_A=0;
	int sign_B=0;
	int sign_AB=0;
	AlertDialog JZdilog;
	RelativeLayout rl;
	LayoutParams param;
	//屏幕高
	int pm_G;
	int pm_K;
	
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		//获得屏幕大小
		DisplayMetrics dm = new DisplayMetrics();
		this.getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
		pm_K = dm.widthPixels;//宽度
		pm_G = dm.heightPixels ;//高度
        View rootView = inflater.inflate(R.layout.fragment_juzhen, container, false);
       JU_A = (EditText)rootView.findViewById(R.id.editText_A);
       JU_B = (EditText)rootView.findViewById(R.id.editText_B);
       JSbt_A = (Button)rootView.findViewById(R.id.JZbutton_A);
       JSbt_B = (Button)rootView.findViewById(R.id.JZbutton_B);
       JSbt_AB = (Button)rootView.findViewById(R.id.JZbutton_AB);
       //设置大小
       LinearLayout jz_ll1 = (LinearLayout)rootView.findViewById(R.id.jz_ll1);
       LinearLayout jz_ll2 = (LinearLayout)rootView.findViewById(R.id.jz_ll2);
       LinearLayout jz_ll3 = (LinearLayout)rootView.findViewById(R.id.jz_ll3);
       TableLayout jz_tl = (TableLayout)rootView.findViewById(R.id.jz_tl);
       Spinner jz_spA = (Spinner)rootView.findViewById(R.id.spinnerA);
       Spinner jz_spB = (Spinner)rootView.findViewById(R.id.spinnerB);
       Spinner jz_spAB = (Spinner)rootView.findViewById(R.id.spinnerAB);
       //button
       Button guangbiaoL_JZ = (Button)rootView.findViewById(R.id.guangbiaoL_JZ);
       Button guangbiaoR_JZ = (Button)rootView.findViewById(R.id.guangbiaoR_JZ);
       Button douhao_JZ = (Button)rootView.findViewById(R.id.douhao_JZ);
       Button dian_JZ = (Button)rootView.findViewById(R.id.dian_JZ);
       Button huiche_JZ = (Button)rootView.findViewById(R.id.huiche_JZ);
       Button qingchu_JZ = (Button)rootView.findViewById(R.id.qingchu_JZ);
       Button lin_JZ = (Button)rootView.findViewById(R.id.lin_JZ);
       Button yi_JZ = (Button)rootView.findViewById(R.id.yi_JZ);
       Button er_JZ = (Button)rootView.findViewById(R.id.er_JZ);
       Button san_JZ = (Button)rootView.findViewById(R.id.san_JZ);
       Button si_JZ = (Button)rootView.findViewById(R.id.si_JZ);
       Button wu_JZ = (Button)rootView.findViewById(R.id.wu_JZ);
       Button liu_JZ = (Button)rootView.findViewById(R.id.liu_JZ);
       Button qi_JZ = (Button)rootView.findViewById(R.id.qi_JZ);
       Button ba_JZ = (Button)rootView.findViewById(R.id.ba_JZ);
       Button jiu_JZ = (Button)rootView.findViewById(R.id.jiu_JZ);
       Button fuhao_JZ = (Button)rootView.findViewById(R.id.fuhao_JZ);
       
       JSbt_A.setOnClickListener(this);
       JSbt_B.setOnClickListener(this);
       JSbt_AB.setOnClickListener(this);
       //btn
       guangbiaoL_JZ.setOnClickListener(this);
       guangbiaoR_JZ.setOnClickListener(this);
       douhao_JZ.setOnClickListener(this);
       dian_JZ.setOnClickListener(this);
       huiche_JZ.setOnClickListener(this);
       qingchu_JZ.setOnClickListener(this);
       qingchu_JZ.setOnLongClickListener(this);
       lin_JZ.setOnClickListener(this);
       yi_JZ.setOnClickListener(this);
       er_JZ.setOnClickListener(this);
       san_JZ.setOnClickListener(this);
       si_JZ.setOnClickListener(this);
       wu_JZ.setOnClickListener(this);
       liu_JZ.setOnClickListener(this);
       qi_JZ.setOnClickListener(this);
       ba_JZ.setOnClickListener(this);
       jiu_JZ.setOnClickListener(this);
       fuhao_JZ.setOnClickListener(this);
       //设置控件大小
       ViewGroup.LayoutParams lp_A;
       lp_A=JU_A.getLayoutParams();
       lp_A.height=pm_G/4;        
       JU_A.setLayoutParams(lp_A);
       ViewGroup.LayoutParams lp_B;
       lp_B=JU_B.getLayoutParams();
       lp_B.height=pm_G/4;        
       JU_B.setLayoutParams(lp_B);
       ViewGroup.LayoutParams lp_ll1;
       lp_ll1=jz_ll1.getLayoutParams();
       lp_ll1.height=pm_G/12;        
       jz_ll1.setLayoutParams(lp_ll1);
       ViewGroup.LayoutParams lp_ll2;
       lp_ll2=jz_ll2.getLayoutParams();
       lp_ll2.height=pm_G/12;        
       jz_ll2.setLayoutParams(lp_ll2);
       ViewGroup.LayoutParams lp_ll3;
       lp_ll3=jz_ll3.getLayoutParams();
       lp_ll3.height=pm_G/12;        
       jz_ll3.setLayoutParams(lp_ll3);
       ViewGroup.LayoutParams lp_tl;
       lp_tl=jz_tl.getLayoutParams();
       lp_tl.height=pm_G/4;        
       jz_tl.setLayoutParams(lp_tl);
       ViewGroup.LayoutParams lp_spA;
       lp_spA=jz_spA.getLayoutParams();
       lp_spA.height=pm_G/15;        
       jz_spA.setLayoutParams(lp_spA);
       ViewGroup.LayoutParams lp_spB;
       lp_spB=jz_spB.getLayoutParams();
       lp_spB.height=pm_G/15;        
       jz_spB.setLayoutParams(lp_spB);
       ViewGroup.LayoutParams lp_spAB;
       lp_spAB=jz_spAB.getLayoutParams();
       lp_spAB.height=pm_G/15;        
       jz_spAB.setLayoutParams(lp_spAB);
       ViewGroup.LayoutParams lp_btA;
       lp_btA=JSbt_A.getLayoutParams();
       lp_btA.height=pm_G/15;        
       JSbt_A.setLayoutParams(lp_btA);
       ViewGroup.LayoutParams lp_btB;
       lp_spAB=JSbt_B.getLayoutParams();
       lp_spAB.height=pm_G/15;        
       JSbt_B.setLayoutParams(lp_spAB);
       ViewGroup.LayoutParams lp_btAB;
       lp_spAB=JSbt_AB.getLayoutParams();
       lp_spAB.height=pm_G/15;        
       JSbt_AB.setLayoutParams(lp_spAB);
        JZdilog =  new AlertDialog(Juzhen.this.getActivity()).builder();
      
		JZdilog.setPositiveButton("确定", new OnClickListener() {
			@Override
			public void onClick(View v) {

			}
		}).setNegativeButton("复制", new OnClickListener() {
			@Override
			public void onClick(View v) {
				// 得到剪贴板管理器 
				ClipboardManager cmb = (ClipboardManager) Juzhen.this.getActivity()
				.getSystemService(Juzhen.this.getActivity().CLIPBOARD_SERVICE); 
				cmb.setText(JZdilog.getMsg().trim()); 
			}
		});
       
        // 初始化控件
        Spinner  mSpinnerA = (Spinner) rootView.findViewById(R.id.spinnerA);
        // 建立数据源
        String[] mItemsA = getResources().getStringArray(R.array.spinnername);
        // 建立Adapter并且绑定数据源
        ArrayAdapter<String> _AdapterA=new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item, mItemsA);
        //绑定 Adapter到控件
        _AdapterA.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mSpinnerA.setAdapter(_AdapterA);
        
        //监听Spinner
        mSpinnerA.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                    int position, long id) {
            	 String str=parent.getItemAtPosition(position).toString();
                if(str.equals("矩阵行列式")){
                	sign_A = 1;	
                }else
                if(str.equals("矩阵转置")){
                	sign_A = 2;
                            }else
                if(str.equals("矩阵的秩")){
                	sign_A = 3;                       
                               }else
                if(str.equals("矩阵迹")){
                	sign_A = 4;               
                               }else
                if(str.equals("逆矩阵")){
                	sign_A = 5;               	
                              }else
                if(str.equals("特征值组成的矩阵")){
                	sign_A = 6;                                 	
                                  }
                else
                    if(str.equals("特征向量组成的矩阵")){
                    	sign_A = 7;                     	
                                      }else
                if(str.equals("A^2")){
                	sign_A = 8;               	
                                  }else
                if(str.equals("A^3")){
                	sign_A = 9;               	
                                 }
            }
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
        
        });
        //B
        // 初始化控件
        Spinner  mSpinnerB = (Spinner) rootView.findViewById(R.id.spinnerB);
        // 建立数据源
        String[] mItemsB = getResources().getStringArray(R.array.spinnername);
        // 建立Adapter并且绑定数据源
        ArrayAdapter<String> _AdapterB=new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item, mItemsB);
        //绑定 Adapter到控件
        _AdapterB.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mSpinnerB.setAdapter(_AdapterB);
        
        //监听Spinner
        mSpinnerB.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                    int position, long id) {
            	 String str=parent.getItemAtPosition(position).toString();
                if(str.equals("矩阵行列式")){
                	sign_B = 1;	
                }else
                if(str.equals("矩阵转置")){
                	sign_B = 2;
                            }else
                if(str.equals("矩阵的秩")){
                	sign_B = 3;                       
                               }else
                if(str.equals("矩阵迹")){
                	sign_B = 4;               
                               }else
                if(str.equals("逆矩阵")){
                	sign_B = 5;               	
                              }else
                if(str.equals("特征值组成的矩阵")){
                	sign_B = 6;                                 	
                                  }
                else
                    if(str.equals("特征向量组成的矩阵")){
                    	sign_B = 7;                     	
                                      }else
                if(str.equals("A^2")){
                	sign_B = 8;               	
                                  }else
                if(str.equals("A^3")){
                	sign_B = 9;               	
                                 }
            }
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
        
        });
        //AB
        // 初始化控件
        Spinner  mSpinnerAB = (Spinner) rootView.findViewById(R.id.spinnerAB);
        // 建立数据源
        String[] mItemsAB = getResources().getStringArray(R.array.spinnernameAB);
        // 建立Adapter并且绑定数据源
        ArrayAdapter<String> _AdapterAB=new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item, mItemsAB);
        //绑定 Adapter到控件
        _AdapterAB.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mSpinnerAB.setAdapter(_AdapterAB);
        
        //监听Spinner
        mSpinnerAB.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                    int position, long id) {
            	 String str=parent.getItemAtPosition(position).toString();
                if(str.equals("A+B")){
                	sign_AB = 1;	
                }else
                if(str.equals("A-B")){
                	sign_AB = 2;
                            }else
                if(str.equals("B-A")){
                	sign_AB = 3;                       
                               }else
                if(str.equals("A×B")){
                	sign_AB = 4;               
                               }
                if(str.equals("B×A")){
                	sign_AB = 5;               
                               }
            }
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
        
        });
        
        chujiaodian(JU_A);
        chujiaodian(JU_B);
        //获取保存数据 
        SharedPreferences sp = getActivity().getSharedPreferences("Edittext",  
                getActivity().MODE_PRIVATE);  
        // music_progress为XML文件的文件名  
        JU_A.setText(sp.getString("edittextA", null));
        JU_B.setText(sp.getString("edittextB", null));
		return rootView;
        
	
	}
	//保存数据
	 public void onDestroy() {
			super.onDestroy();
			SharedPreferences sp = getActivity().getSharedPreferences("Edittext",  
	        getActivity().MODE_PRIVATE); 
			Editor editor = sp.edit();
			//星期
			editor.putString("edittextA", JU_A.getText().toString());
			editor.putString("edittextB", JU_B.getText().toString());
		
			editor.commit();
			}
	@Override
	public void onClick(View arg0) {
		Editable editA = JU_A.getEditableText();//获取EditText的文字
		Editable editB = JU_B.getEditableText();//获取EditText的文字
		index_JZA = JU_A.getSelectionStart();
		index_JZB = JU_B.getSelectionStart();
		switch (arg0.getId()) {
		
		case R.id.JZbutton_A:
			//矩阵字符串
        	String JZA = JU_A.getText().toString();
        	//获取矩阵
        	String[] y1 = JZA.split("\n");
        	String[] y = y1[0].split("＿");
        	double[][] vals = new double[y1.length][y.length];
        	for(int i = 0; i<y1.length;i++)
        	{
        		String[] y2 = y1[i].split("＿");
        		for(int j = 0;j<y2.length;j++)
        		{
        			try{
        			vals[i][j] = Double.parseDouble( y2[j] );}
        			catch(Exception e)
        			{
        				Toast.makeText(getActivity(), "请检查格式是否正确！", Toast.LENGTH_SHORT).show();
        				return;
        			}
        		}
        		
        	}
        	//转换为矩阵
        	Matrix A = new Matrix(vals);
 if(sign_A == 1){
					//A.det();//矩阵行列式
	 				DecimalFormat df = new DecimalFormat("########.############");  //规格化
	
					JZdilog.setTitle("此矩阵行列式");
					 try{
					 JZdilog.setMsg(String.valueOf(df.format(A.det())));
					 JZdilog.show();}catch(Exception e){
						 Toast.makeText(getActivity(), "无法计算！", Toast.LENGTH_SHORT).show();
					 }
                	
}else if(sign_A == 2){
				 Matrix ZH_A = null;
				 double[][] ZH = null;
				 try{
					 ZH_A=A.transpose();//矩阵转置
					 ZH = new double[ZH_A.getRowDimension()][ZH_A.getColumnDimension()];
					 ZH = ZH_A.getArray();
					 DecimalFormat df = new DecimalFormat("########.############");  //规格化
						String s ="";
					for(int i = 0;i<ZH_A.getRowDimension();i++){
						for(int j = 0;j<ZH_A.getColumnDimension();j++){
							s = s + String.valueOf(df.format(ZH[i][j]))+"＿";
						}
						s = s + "\n";
					}
						JZdilog.setTitle("矩阵转置");
						 JZdilog.setMsg(s);
	               	 JZdilog.show();
				 }catch(Exception e){
					 Toast.makeText(getActivity(), "无法计算！", Toast.LENGTH_SHORT).show();
				 }
                	 
				
			 }
 else if(sign_A ==3){
	 DecimalFormat df = new DecimalFormat("########.############");  //规格化
					JZdilog.setTitle("此矩阵秩");
					try{
					 JZdilog.setMsg(String.valueOf(df.format(A.rank())));}catch(Exception e){
						 Toast.makeText(getActivity(), "无法计算！", Toast.LENGTH_SHORT).show();
					 }
               	 JZdilog.show();
				// A.rank();//矩阵秩
			 }
 else if(sign_A == 4){
				// A.trace();//矩阵迹
	 DecimalFormat df = new DecimalFormat("########.############");  //规格化
				 JZdilog.setTitle("此矩阵迹");
				 try{
				 JZdilog.setMsg(String.valueOf(df.format(A.trace())));}catch(Exception e){
					 Toast.makeText(getActivity(), "无法计算！", Toast.LENGTH_SHORT).show();
				 }
           	 JZdilog.show();
			 }
 else if(sign_A == 5){
	 DecimalFormat df = new DecimalFormat("########.############");  //规格化
				 Matrix JZN_A = null;//矩阵求逆       
				 double[][] ZH = null;
				 try{JZN_A=A.inverse();
				 ZH = new double[JZN_A.getRowDimension()][JZN_A.getColumnDimension()];
				 ZH = JZN_A.getArray();
					String s ="";
					for(int i = 0;i<JZN_A.getRowDimension();i++){
						for(int j = 0;j<JZN_A.getColumnDimension();j++){
							s = s + String.valueOf(df.format(ZH[i][j]))+"＿";
						}
						s = s + "\n";
					}
						JZdilog.setTitle("逆矩阵");
						 JZdilog.setMsg(s);
	            	 JZdilog.show();
				 }catch(Exception e){
					 Toast.makeText(getActivity(), "无法计算！", Toast.LENGTH_SHORT).show();
				 }		
			 }
else if(sign_A == 6){	
					//特征值               
	DecimalFormat df = new DecimalFormat("########.############");  //规格化
                	 Matrix JZN_A = null;   
    				 double[][] ZH = null;
    				 try{JZN_A=A.eig().getD();
    				 ZH = new double[JZN_A.getRowDimension()][JZN_A.getColumnDimension()];
    				 ZH = JZN_A.getArray();   					
 					String s ="";
 				for(int i = 0;i<JZN_A.getRowDimension();i++){
 					for(int j = 0;j<JZN_A.getColumnDimension();j++){
 						s = s + String.valueOf(df.format(ZH[i][j]))+"＿";
 					}
 					s = s + "\n";
 				}
 					JZdilog.setTitle("特征值组成的矩阵");
 					 JZdilog.setMsg(s);
             	 JZdilog.show();
    				 }catch(Exception e){
    					 Toast.makeText(getActivity(), "无法计算！", Toast.LENGTH_SHORT).show();
    				 }
			 }
else if(sign_A == 7){	
					//特征向量		
	DecimalFormat df = new DecimalFormat("########.############");  //规格化
					 Matrix JZN_A = null;   
    				 double[][] ZH = null;
    				 try{JZN_A=A.eig().getV();
    				 ZH = new double[JZN_A.getRowDimension()][JZN_A.getColumnDimension()];
    				 ZH = JZN_A.getArray();
    					
 					String s ="";
 				for(int i = 0;i<JZN_A.getRowDimension();i++){
 					for(int j = 0;j<JZN_A.getColumnDimension();j++){
 						s = s + String.valueOf(df.format(ZH[i][j]))+"＿";
 					}
 					s = s + "\n";
 				}
 					JZdilog.setTitle("特征向量组成的矩阵");
 					 JZdilog.setMsg(s);
             	 JZdilog.show();
    				 }catch(Exception e){
    					 Toast.makeText(getActivity(), "无法计算！", Toast.LENGTH_SHORT).show();
    				 }
			 }
else if(sign_A == 8){
				 //A^2
	DecimalFormat df = new DecimalFormat("########.############");  //规格化
				 Matrix JZN_A = null;
				 double[][] ZH = null;
				 try{JZN_A  = A.times(A);
				 ZH = new double[JZN_A.getRowDimension()][JZN_A.getColumnDimension()];
					ZH = JZN_A.getArray();
					String s ="";
					for(int i = 0;i<JZN_A.getRowDimension();i++){
						for(int j = 0;j<JZN_A.getColumnDimension();j++){
							s = s + String.valueOf(df.format(ZH[i][j]))+"＿";
						}
						s = s + "\n";
					}
						JZdilog.setTitle("A^2");
						 JZdilog.setMsg(s);
	            	 JZdilog.show();
				 }catch(Exception e){
					 Toast.makeText(getActivity(), "无法计算！", Toast.LENGTH_SHORT).show();
				 }		
			 }
else if(sign_A == 9){
				 //A^3
				 //A^2
	DecimalFormat df = new DecimalFormat("########.############");  //规格化
				 Matrix JZN_A = null;
				 double[][] ZH = null;
				 try{JZN_A  = A.times(A.times(A));
				 ZH = new double[JZN_A.getRowDimension()][JZN_A.getColumnDimension()];
					ZH = JZN_A.getArray();
					
					String s ="";
				for(int i = 0;i<JZN_A.getRowDimension();i++){
					for(int j = 0;j<JZN_A.getColumnDimension();j++){
						s = s + String.valueOf(df.format(ZH[i][j]))+"＿";
					}
					s = s + "\n";
				}
					JZdilog.setTitle("A^3");
					 JZdilog.setMsg(s);
            	 JZdilog.show();
				 }catch(Exception e){
					 Toast.makeText(getActivity(), "无法计算！", Toast.LENGTH_SHORT).show();
				 }		
			 }    	
			break;
		case R.id.JZbutton_B:	
			//矩阵字符串
        	String JZB = JU_B.getText().toString();
        	//获取矩阵
        	String[] y1B = JZB.split("\n");
        	String[] yB = y1B[0].split("＿");
        	double[][] valsB = new double[y1B.length][yB.length];
        	for(int i = 0; i<y1B.length;i++)
        	{
        		String[] y2B = y1B[i].split("＿");
        		for(int j = 0;j<y2B.length;j++)
        		{
        			try{
        			valsB[i][j] = Double.parseDouble( y2B[j] );}
        			catch(Exception e)
        			{
        				Toast.makeText(getActivity(), "请检查格式是否正确！", Toast.LENGTH_SHORT).show();
        				return;
        			}
        		}
        		
        	}
        	//转换为矩阵
        	Matrix B = new Matrix(valsB);
 if(sign_B == 1){
					//A.det();//矩阵行列式
	 DecimalFormat df = new DecimalFormat("########.############");  //规格化
					JZdilog.setTitle("此矩阵行列式");
					 try{
					 JZdilog.setMsg(String.valueOf(df.format(B.det())));
					 JZdilog.show();}catch(Exception e){
						 Toast.makeText(getActivity(), "无法计算！", Toast.LENGTH_SHORT).show();
					 }
                	
}else if(sign_B == 2){
	DecimalFormat df = new DecimalFormat("########.############");  //规格化
				 Matrix ZH_A = null;
				 double[][] ZH = null;
				 try{
					 ZH_A=B.transpose();//矩阵转置
					 ZH = new double[ZH_A.getRowDimension()][ZH_A.getColumnDimension()];
					 ZH = ZH_A.getArray();
						
						String s ="";
					for(int i = 0;i<ZH_A.getRowDimension();i++){
						for(int j = 0;j<ZH_A.getColumnDimension();j++){
							s = s + String.valueOf(df.format(ZH[i][j]))+"＿";
						}
						s = s + "\n";
					}
						JZdilog.setTitle("矩阵转置");
						 JZdilog.setMsg(s);
	               	 JZdilog.show();
				 }catch(Exception e){
					 Toast.makeText(getActivity(), "无法计算！", Toast.LENGTH_SHORT).show();
				 }
                	 
				
			 }
 else if(sign_B ==3){
		DecimalFormat df = new DecimalFormat("########.############");  //规格化
					JZdilog.setTitle("此矩阵秩");
					try{
					 JZdilog.setMsg(String.valueOf(df.format(B.rank())));}catch(Exception e){
						 Toast.makeText(getActivity(), "无法计算！", Toast.LENGTH_SHORT).show();
					 }
               	 JZdilog.show();
				// A.rank();//矩阵秩
			 }
 else if(sign_B == 4){
				// A.trace();//矩阵迹
	 DecimalFormat df = new DecimalFormat("########.############");  //规格化
				 JZdilog.setTitle("此矩阵迹");
				 try{
				 JZdilog.setMsg(String.valueOf(df.format(B.trace())));}catch(Exception e){
					 Toast.makeText(getActivity(), "无法计算！", Toast.LENGTH_SHORT).show();
				 }
           	 JZdilog.show();
			 }
 else if(sign_B == 5){
	 DecimalFormat df = new DecimalFormat("########.############");  //规格化
				 Matrix JZN_A = null;//矩阵求逆       
				 double[][] ZH = null;
				 try{JZN_A=B.inverse();
				 ZH = new double[JZN_A.getRowDimension()][JZN_A.getColumnDimension()];
				 ZH = JZN_A.getArray();
					String s ="";
					for(int i = 0;i<JZN_A.getRowDimension();i++){
						for(int j = 0;j<JZN_A.getColumnDimension();j++){
							s = s + String.valueOf(df.format(ZH[i][j]))+"＿";
						}
						s = s + "\n";
					}
						JZdilog.setTitle("逆矩阵");
						 JZdilog.setMsg(s);
	            	 JZdilog.show();
				 }catch(Exception e){
					 Toast.makeText(getActivity(), "无法计算！", Toast.LENGTH_SHORT).show();
				 }		
			 }
else if(sign_B == 6){
					//特征值    
	DecimalFormat df = new DecimalFormat("########.############");  //规格化
                	 Matrix JZN_A = null;   
    				 double[][] ZH = null;
    				 try{JZN_A=B.eig().getD();
    				 ZH = new double[JZN_A.getRowDimension()][JZN_A.getColumnDimension()];
    				 ZH = JZN_A.getArray();   					
 					String s ="";
 				for(int i = 0;i<JZN_A.getRowDimension();i++){
 					for(int j = 0;j<JZN_A.getColumnDimension();j++){
 						s = s + String.valueOf(df.format(ZH[i][j]))+"＿";
 					}
 					s = s + "\n";
 				}
 					JZdilog.setTitle("特征值组成的矩阵");
 					 JZdilog.setMsg(s);
             	 JZdilog.show();
    				 }catch(Exception e){
    					 Toast.makeText(getActivity(), "无法计算！", Toast.LENGTH_SHORT).show();
    				 }
			 }
else if(sign_B == 7){	
					//特征向量	
	DecimalFormat df = new DecimalFormat("########.############");  //规格化
					 Matrix JZN_A = null;   
    				 double[][] ZH = null;
    				 try{JZN_A=B.eig().getV();
    				 ZH = new double[JZN_A.getRowDimension()][JZN_A.getColumnDimension()];
    				 ZH = JZN_A.getArray();
    					
 					String s ="";
 				for(int i = 0;i<JZN_A.getRowDimension();i++){
 					for(int j = 0;j<JZN_A.getColumnDimension();j++){
 						s = s + String.valueOf(df.format(ZH[i][j]))+"＿";
 					}
 					s = s + "\n";
 				}
 					JZdilog.setTitle("特征向量组成的矩阵");
 					 JZdilog.setMsg(s);
             	 JZdilog.show();
    				 }catch(Exception e){
    					 Toast.makeText(getActivity(), "无法计算！", Toast.LENGTH_SHORT).show();
    				 }
			 }
else if(sign_B == 8){
				 //A^2
	DecimalFormat df = new DecimalFormat("########.############");  //规格化
				 Matrix JZN_A = null;
				 double[][] ZH = null;
				 try{JZN_A  = B.times(B);
				 ZH = new double[JZN_A.getRowDimension()][JZN_A.getColumnDimension()];
					ZH = JZN_A.getArray();
					String s ="";
					for(int i = 0;i<JZN_A.getRowDimension();i++){
						for(int j = 0;j<JZN_A.getColumnDimension();j++){
							s = s + String.valueOf(df.format(ZH[i][j]))+"＿";
						}
						s = s + "\n";
					}
						JZdilog.setTitle("A^2");
						 JZdilog.setMsg(s);
	            	 JZdilog.show();
				 }catch(Exception e){
					 Toast.makeText(getActivity(), "无法计算！", Toast.LENGTH_SHORT).show();
				 }		
			 }
else if(sign_B == 9){
				 //A^3
				 //A^2
	DecimalFormat df = new DecimalFormat("########.############");  //规格化
				 Matrix JZN_A = null;
				 double[][] ZH = null;
				 try{JZN_A  = B.times(B.times(B));
				 ZH = new double[JZN_A.getRowDimension()][JZN_A.getColumnDimension()];
					ZH = JZN_A.getArray();
					
					String s ="";
				for(int i = 0;i<JZN_A.getRowDimension();i++){
					for(int j = 0;j<JZN_A.getColumnDimension();j++){
						s = s + String.valueOf(df.format(ZH[i][j]))+"＿";
					}
					s = s + "\n";
				}
					JZdilog.setTitle("A^3");
					 JZdilog.setMsg(s);
            	 JZdilog.show();
				 }catch(Exception e){
					 Toast.makeText(getActivity(), "无法计算！", Toast.LENGTH_SHORT).show();
				 }		
			 }  
		break;
		case R.id.JZbutton_AB:	
			//转换A
			
        	String JZA_AB = JU_A.getText().toString();
        	//获取矩阵
        	String[] y1A_AB = JZA_AB.split("\n");
        	String[] yA_AB = y1A_AB[0].split("＿");
        	double[][] valsA_AB = new double[y1A_AB.length][yA_AB.length];
        	for(int i = 0; i<y1A_AB.length;i++)
        	{
        		String[] y2A_AB = y1A_AB[i].split("＿");
        		for(int j = 0;j<y2A_AB.length;j++)
        		{
        			try{
        				valsA_AB[i][j] = Double.parseDouble( y2A_AB[j] );}
        			catch(Exception e)
        			{
        				Toast.makeText(getActivity(), "请检查格式是否正确！", Toast.LENGTH_SHORT).show();
        				return;
        			}
        		}
        		
        	}
        	//转换为矩阵
        	Matrix A_AB = new Matrix(valsA_AB);
        	
        	//转换B
        	String JZB_AB = JU_B.getText().toString();
        	//获取矩阵
        	String[] y1B_AB = JZB_AB.split("\n");
        	String[] yB_AB = y1B_AB[0].split("＿");
        	double[][] valsB_AB = new double[y1B_AB.length][yB_AB.length];
        	for(int i = 0; i<y1B_AB.length;i++)
        	{
        		String[] y2B_AB = y1B_AB[i].split("＿");
        		for(int j = 0;j<y2B_AB.length;j++)
        		{
        			try{
        				valsB_AB[i][j] = Double.parseDouble( y2B_AB[j] );}
        			catch(Exception e)
        			{
        				Toast.makeText(getActivity(), "请检查格式是否正确！", Toast.LENGTH_SHORT).show();
        			}
        		}
        		
        	}
        	//转换为矩阵
        	Matrix B_AB = new Matrix(valsB_AB);
        	
if(sign_AB == 1){
	DecimalFormat df = new DecimalFormat("########.############");  //规格化
	 Matrix JZN_A = null;
	 double[][] ZH = null;
	 try{JZN_A  = B_AB.plus(A_AB);
	 ZH = new double[JZN_A.getRowDimension()][JZN_A.getColumnDimension()];
		ZH = JZN_A.getArray();
		
		String s ="";
	for(int i = 0;i<JZN_A.getRowDimension();i++){
		for(int j = 0;j<JZN_A.getColumnDimension();j++){
			s = s + String.valueOf(df.format(ZH[i][j]))+"＿";
		}
		s = s + "\n";
	}
		JZdilog.setTitle("A+B");
		 JZdilog.setMsg(s);
	 JZdilog.show();
	 }catch(Exception e){
		 Toast.makeText(getActivity(), "无法计算！", Toast.LENGTH_SHORT).show();
	 }	
				
            	
}else if(sign_AB == 2){
	DecimalFormat df = new DecimalFormat("########.############");  //规格化
	 Matrix JZN_A = null;
	 double[][] ZH = null;
	 try{JZN_A  = A_AB.minus(B_AB);
	 ZH = new double[JZN_A.getRowDimension()][JZN_A.getColumnDimension()];
		ZH = JZN_A.getArray();
		
		String s ="";
	for(int i = 0;i<JZN_A.getRowDimension();i++){
		for(int j = 0;j<JZN_A.getColumnDimension();j++){
			s = s + String.valueOf(df.format(ZH[i][j]))+"＿";
		}
		s = s + "\n";
	}
		JZdilog.setTitle("A-B");
		 JZdilog.setMsg(s);
	 JZdilog.show();
	 }catch(Exception e){
		 Toast.makeText(getActivity(), "无法计算！", Toast.LENGTH_SHORT).show();
	 }	
		 }
else if(sign_AB ==3){
	DecimalFormat df = new DecimalFormat("########.############");  //规格化
	 Matrix JZN_A = null;
	 double[][] ZH = null;
	 try{JZN_A  = B_AB.minus(A_AB);
	 ZH = new double[JZN_A.getRowDimension()][JZN_A.getColumnDimension()];
		ZH = JZN_A.getArray();
		
		String s ="";
	for(int i = 0;i<JZN_A.getRowDimension();i++){
		for(int j = 0;j<JZN_A.getColumnDimension();j++){
			s = s + String.valueOf(df.format(ZH[i][j]))+"＿";
		}
		s = s + "\n";
	}
		JZdilog.setTitle("B-A");
		 JZdilog.setMsg(s);
	 JZdilog.show();
	 }catch(Exception e){
		 Toast.makeText(getActivity(), "无法计算！", Toast.LENGTH_SHORT).show();
	 }	
	 
		 }
else if(sign_AB == 4){
	DecimalFormat df = new DecimalFormat("########.############");  //规格化
	 Matrix JZN_A = null;
	 double[][] ZH = null;
	 try{JZN_A  = A_AB.times(B_AB);
	 ZH = new double[JZN_A.getRowDimension()][JZN_A.getColumnDimension()];
		ZH = JZN_A.getArray();
		
		String s ="";
	for(int i = 0;i<JZN_A.getRowDimension();i++){
		for(int j = 0;j<JZN_A.getColumnDimension();j++){
			s = s + String.valueOf(df.format(ZH[i][j]))+"＿";
		}
		s = s + "\n";
	}
		JZdilog.setTitle("A×B");
		 JZdilog.setMsg(s);
	 JZdilog.show();
	 }catch(Exception e){
		 Toast.makeText(getActivity(), "无法计算！", Toast.LENGTH_SHORT).show();
	 }		
		 }
else if(sign_AB == 5){
	DecimalFormat df = new DecimalFormat("########.############");  //规格化
	 Matrix JZN_A = null;
	 double[][] ZH = null;
	 try{JZN_A  = B_AB.times(A_AB);
	 ZH = new double[JZN_A.getRowDimension()][JZN_A.getColumnDimension()];
		ZH = JZN_A.getArray();
		
		String s ="";
	for(int i = 0;i<JZN_A.getRowDimension();i++){
		for(int j = 0;j<JZN_A.getColumnDimension();j++){
			s = s + String.valueOf(df.format(ZH[i][j]))+"＿";
		}
		s = s + "\n";
	}
		JZdilog.setTitle("B×A");
		 JZdilog.setMsg(s);
	 JZdilog.show();
	 }catch(Exception e){
		 Toast.makeText(getActivity(), "无法计算！", Toast.LENGTH_SHORT).show();
	 }		
		 }
			break;
			//Button
		case R.id.guangbiaoL_JZ:	
			if(JU_A.hasFocus()){
				if(index_JZA==0){}
				else
				--index_JZA;
				
			}else if(JU_B.hasFocus()){
				if(index_JZB==0){}else
				--index_JZB;
			}
			
			break;
		case R.id.guangbiaoR_JZ:	
			if(JU_A.hasFocus()){
			if(index_JZA==JU_A.getText().toString().length()){}else
				++index_JZA;
				
			}else if(JU_B.hasFocus()){
				if(index_JZB==JU_B.getText().toString().length()){}else
				++index_JZB;
			}
			break;
		case R.id.douhao_JZ:
			if(JU_A.hasFocus()){
				if (index_JZA < 0 || index_JZA >= editA.length() ){
					editA.append("＿");
				}else{
					editA.insert(index_JZA,"＿");//光标所在位置插入文字
				 }
				
			}else if(JU_B.hasFocus()){
				if (index_JZB < 0 || index_JZB >= editB.length() ){
					editB.append("＿");
				}else{
					editB.insert(index_JZB,"＿");//光标所在位置插入文字
				 }
			}
			++index_JZA;
			++index_JZB;
			break;
		case R.id.dian_JZ:
			if(JU_A.hasFocus()){
				if (index_JZA < 0 || index_JZA >= editA.length() ){
					editA.append(".");
				}else{
					editA.insert(index_JZA,".");//光标所在位置插入文字
				 }
				
			}else if(JU_B.hasFocus()){
				if (index_JZB < 0 || index_JZB >= editB.length() ){
					editB.append(".");
				}else{
					editB.insert(index_JZB,".");//光标所在位置插入文字
				 }
			}
			++index_JZA;
			++index_JZB;
			break;
		case R.id.huiche_JZ:	
			if(JU_A.hasFocus()){
				if (index_JZA < 0 || index_JZA >= editA.length() ){
					editA.append("\n");
				}else{
					editA.insert(index_JZA,"\n");//光标所在位置插入文字
				 }
				
			}else if(JU_B.hasFocus()){
				if (index_JZB < 0 || index_JZB >= editB.length() ){
					editB.append("\n");
				}else{
					editB.insert(index_JZB,"\n");//光标所在位置插入文字
				 }
			}
			++index_JZA;
			++index_JZB;
			break;
		case R.id.qingchu_JZ:	
			if(JU_A.hasFocus()){
				if(index_JZA==0){
					index_JZA=1;
				}else{
					editA.delete(index_JZA-1, index_JZA);//光标所在位置插入文字
				 }
				
			}else if(JU_B.hasFocus()){
				if(index_JZB==0){
					index_JZB=1;
				}else{
					editB.delete(index_JZB-1, index_JZB);//光标所在位置插入文字
				 }
			}
			
			--index_JZA;
			--index_JZB;
			break;
		case R.id.lin_JZ:	
			if(JU_A.hasFocus()){
				if (index_JZA < 0 || index_JZA >= editA.length() ){
					editA.append("0");
				}else{
					editA.insert(index_JZA,"0");//光标所在位置插入文字
				 }
				
			}else if(JU_B.hasFocus()){
				if (index_JZB < 0 || index_JZB >= editB.length() ){
					editB.append("0");
				}else{
					editB.insert(index_JZB,"0");//光标所在位置插入文字
				 }
			}
			++index_JZA;
			++index_JZB;
			break;
		case R.id.yi_JZ:
			if(JU_A.hasFocus()){
				if (index_JZA < 0 || index_JZA >= editA.length() ){
					editA.append("1");
				}else{
					editA.insert(index_JZA,"1");//光标所在位置插入文字
				 }
				
			}else if(JU_B.hasFocus()){
				if (index_JZB < 0 || index_JZB >= editB.length() ){
					editB.append("1");
				}else{
					editB.insert(index_JZB,"1");//光标所在位置插入文字
				 }
			}
			++index_JZA;
			++index_JZB;
			break;
		case R.id.er_JZ:
			if(JU_A.hasFocus()){
				if (index_JZA < 0 || index_JZA >= editA.length() ){
					editA.append("2");
				}else{
					editA.insert(index_JZA,"2");//光标所在位置插入文字
				 }
				
			}else if(JU_B.hasFocus()){
				if (index_JZB < 0 || index_JZB >= editB.length() ){
					editB.append("2");
				}else{
					editB.insert(index_JZB,"2");//光标所在位置插入文字
				 }
			}
			++index_JZA;
			++index_JZB;
			break;
		case R.id.san_JZ:
			if(JU_A.hasFocus()){
				if (index_JZA < 0 || index_JZA >= editA.length() ){
					editA.append("3");
				}else{
					editA.insert(index_JZA,"3");//光标所在位置插入文字
				 }
				
			}else if(JU_B.hasFocus()){
				if (index_JZB < 0 || index_JZB >= editB.length() ){
					editB.append("3");
				}else{
					editB.insert(index_JZB,"3");//光标所在位置插入文字
				 }
			}
			++index_JZA;
			++index_JZB;
			break;
		case R.id.si_JZ:	
			if(JU_A.hasFocus()){
				if (index_JZA < 0 || index_JZA >= editA.length() ){
					editA.append("4");
				}else{
					editA.insert(index_JZA,"4");//光标所在位置插入文字
				 }
				
			}else if(JU_B.hasFocus()){
				if (index_JZB < 0 || index_JZB >= editB.length() ){
					editB.append("4");
				}else{
					editB.insert(index_JZB,"4");//光标所在位置插入文字
				 }
			}
			++index_JZA;
			++index_JZB;
			break;
		case R.id.wu_JZ:
			if(JU_A.hasFocus()){
				if (index_JZA < 0 || index_JZA >= editA.length() ){
					editA.append("5");
				}else{
					editA.insert(index_JZA,"5");//光标所在位置插入文字
				 }
				
			}else if(JU_B.hasFocus()){
				if (index_JZB < 0 || index_JZB >= editB.length() ){
					editB.append("5");
				}else{
					editB.insert(index_JZB,"5");//光标所在位置插入文字
				 }
			}
			++index_JZA;
			++index_JZB;
			break;
		case R.id.liu_JZ:	
			if(JU_A.hasFocus()){
				if (index_JZA < 0 || index_JZA >= editA.length() ){
					editA.append("6");
				}else{
					editA.insert(index_JZA,"6");//光标所在位置插入文字
				 }
				
			}else if(JU_B.hasFocus()){
				if (index_JZB < 0 || index_JZB >= editB.length() ){
					editB.append("6");
				}else{
					editB.insert(index_JZB,"6");//光标所在位置插入文字
				 }
			}
			++index_JZA;
			++index_JZB;
			break;
		case R.id.qi_JZ:
			if(JU_A.hasFocus()){
				if (index_JZA < 0 || index_JZA >= editA.length() ){
					editA.append("7");
				}else{
					editA.insert(index_JZA,"7");//光标所在位置插入文字
				 }
				
			}else if(JU_B.hasFocus()){
				if (index_JZB < 0 || index_JZB >= editB.length() ){
					editB.append("7");
				}else{
					editB.insert(index_JZB,"7");//光标所在位置插入文字
				 }
			}
			++index_JZA;
			++index_JZB;
			break;
		case R.id.ba_JZ:	
			if(JU_A.hasFocus()){
				if (index_JZA < 0 || index_JZA >= editA.length() ){
					editA.append("8");
				}else{
					editA.insert(index_JZA,"8");//光标所在位置插入文字
				 }
				
			}else if(JU_B.hasFocus()){
				if (index_JZB < 0 || index_JZB >= editB.length() ){
					editB.append("8");
				}else{
					editB.insert(index_JZB,"8");//光标所在位置插入文字
				 }
			}
			++index_JZA;
			++index_JZB;
			break;
		case R.id.jiu_JZ:	
			if(JU_A.hasFocus()){
				if (index_JZA < 0 || index_JZA >= editA.length() ){
					editA.append("9");
				}else{
					editA.insert(index_JZA,"9");//光标所在位置插入文字
				 }
				
			}else if(JU_B.hasFocus()){
				if (index_JZB < 0 || index_JZB >= editB.length() ){
					editB.append("9");
				}else{
					editB.insert(index_JZB,"9");//光标所在位置插入文字
				 }
			}
			++index_JZA;
			++index_JZB;
			break;
		case R.id.fuhao_JZ:	
			if(JU_A.hasFocus()){
				if (index_JZA < 0 || index_JZA >= editA.length() ){
					editA.append("-");
				}else{
					editA.insert(index_JZA,"-");//光标所在位置插入文字
				 }
				
			}else if(JU_B.hasFocus()){
				if (index_JZB < 0 || index_JZB >= editB.length() ){
					editB.append("-");
				}else{
					editB.insert(index_JZB,"-");//光标所在位置插入文字
				 }
			}
			++index_JZA;
			++index_JZB;
			break;
			
	}
		if(JU_A.hasFocus()){
			JU_A.setSelection(index_JZA);
			
		}else if(JU_B.hasFocus()){
			JU_B.setSelection(index_JZB);
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

		@Override
		public boolean onLongClick(View arg0) {
			switch (arg0.getId()) {
			case R.id.qingchu_JZ:
				if(JU_A.hasFocus()){
					JU_A.setText("");
					index_JZA=0;
				}else if(JU_B.hasFocus()){
					JU_B.setText("");
					index_JZB=0;
				}
				break;

			default:
				break;
			}
		
			
			return false;
		}
}