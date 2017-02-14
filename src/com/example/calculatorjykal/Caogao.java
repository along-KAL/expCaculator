package com.example.calculatorjykal;

import java.lang.reflect.Method;



import com.example.calculatorjykal.R;
import com.example.slidingmenufragmenttest.fragment.Jisuanqi;
import com.umeng.analytics.MobclickAgent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class Caogao extends Activity {
	private EditText edittext;
	private Button button1;
	//HomeFragment h = new HomeFragment();
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.caogao);
		button1= (Button)findViewById(R.id.button1);
		
		edittext = (EditText)findViewById(R.id.EditText);
		Bundle b = getIntent().getExtras();
		String s = b.getString("name");
		edittext.setText(s);
		if (android.os.Build.VERSION.SDK_INT <= 10) {  
            edittext.setInputType(InputType.TYPE_NULL);  
        } else {  
            getWindow().setSoftInputMode(  
                    WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);  
            try {  
                Class<EditText> cls = EditText.class;  
                Method setShowSoftInputOnFocus;  
                setShowSoftInputOnFocus = cls.getMethod("setShowSoftInputOnFocus",  
                        boolean.class);  
                setShowSoftInputOnFocus.setAccessible(true);  
                setShowSoftInputOnFocus.invoke(edittext, false);  
            } catch (Exception e) {  
                e.printStackTrace();  
            }}

		button1.setOnClickListener(new OnClickListener() {
//			long firstTime = 0;
//			long secondTime;
			@Override
			public void onClick(View v) {
//				secondTime = System.currentTimeMillis();
//				if(secondTime-firstTime>200){
//					firstTime = secondTime;
//					return ;
//				}else{
				Intent i = new Intent();
				i.putExtra("s", edittext.getText().toString());
				setResult(RESULT_OK, i);
				finish();}
			//}
		});
	
	}
	public void onResume() {
		super.onResume();
		MobclickAgent.onResume(this);
		}
		public void onPause() {
		super.onPause();
		MobclickAgent.onPause(this);
		}
}
