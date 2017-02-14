package changshu;







import blur.FastBlur;
import com.example.calculatorjykal.R;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager.LayoutParams;

import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.LinearLayout;
import android.widget.TextView;

@SuppressLint("NewApi")
public class Changshu extends Dialog implements OnDateChangedListener{
	Bitmap bmp1 =null;

	LinearLayout dt;
private final DatePicker mDatePicker;
private final OnDateSetListener mCallBack;
private View view;


/**
* The callback used to indicate the user is done filling in the date.
*/
public interface OnDateSetListener {
void onDateSet(DatePicker view, int year, int monthOfYear,
int dayOfMonth,String e,Bitmap bmp);
}

public Changshu(Context context, OnDateSetListener callBack,
int year, int monthOfYear, int dayOfMonth,String e,Bitmap bmp) {
this(context, 0, callBack, year, monthOfYear, dayOfMonth,e,bmp);
}

public Changshu(Context context, int theme,
OnDateSetListener callBack, int year, int monthOfYear,
int dayOfMonth,String e, Bitmap bmp) {
super(context, theme);


mCallBack = callBack;


Context themeContext = getContext();
//將設置alertdialog的settitle和setButton方法注释掉，因为下面要使用setContentView（View view）方法
//代替原有的setView（View view）方法，区别是替换的范围不同。替换后就不需要设置alertdialog的title和button了。
// setButton(BUTTON_POSITIVE,
// themeContext.getText(R.string.date_time_set), this);
// setButton(BUTTON_NEGATIVE, themeContext.getText(R.string.cancel),
// (OnClickListener) null);
// setIcon(0);
// setTitle(R.string.date_picker_dialog_title);


LayoutInflater inflater = (LayoutInflater) themeContext
.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//注意，其实datepickerdialog就是把系统提供的日期选择器DatePicker包装一下而已，所以只需要实现自己需要的布局样式
//然后把DatePicker嵌套进去就可以了。
view = inflater.inflate(R.layout.changshu, null);
dt = (LinearLayout)view.findViewById(R.id.changs);
//监听屏幕动静
bmp1 = bmp;
/*dt.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
    @Override
    public boolean onPreDraw() {
    	dt.getViewTreeObserver().removeOnPreDrawListener(this);
    	dt.buildDrawingCache();
    	
       // bmp1 = dt.getDrawingCache();
       // if(bmp1==null){}
      // else
       // blur(bmp1, dt);
        return true;
    }
});
*/

//view.setBackgroundColor(Color.WHITE);
// setView(view);
	



mDatePicker = (DatePicker) view.findViewById(R.id.datePi);
mDatePicker.init(year, monthOfYear, dayOfMonth, this);

//实现自己的标题和ok按钮
//setTitle("选择日期:");
setButton();
}
//模糊
/*private void blur(Bitmap bkg, View view) {
    //  long startMs = System.currentTimeMillis();
      float scaleFactor = 5;
      float radius = 10;
      if (downScale.isChecked()) {
          scaleFactor = 8;
          radius = 2;
      }
    //  dt.getLeft()
     
      DisplayMetrics dm = new DisplayMetrics();
      getWindow().getWindowManager().getDefaultDisplay().getMetrics(dm);
      int a = 	(dm.widthPixels-view.getMeasuredWidth())/2;//宽度height = dm.heightPixels ;
      int b = 	(dm.heightPixels-view.getMeasuredHeight())/2-dm.heightPixels/34;
     
      Bitmap overlay = Bitmap.createBitmap((int) (view.getMeasuredWidth()/scaleFactor),
              (int) (view.getMeasuredHeight()/scaleFactor), Bitmap.Config.ARGB_8888);
      Canvas canvas = new Canvas(overlay);
      canvas.translate(-a/scaleFactor, -b/scaleFactor);
      canvas.scale(1 / scaleFactor, 1 / scaleFactor);
      Paint paint = new Paint();
      paint.setFlags(Paint.FILTER_BITMAP_FLAG);
      canvas.drawBitmap(bkg, 0, 0, paint);

      FastBlur FastBlur = null ;
	overlay = FastBlur.doBlur(overlay, (int)radius, true);
      //view.setBackground(new BitmapDrawable(getContext().getResources(), overlay));
      view.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), overlay));
     // statusText.setText(System.currentTimeMillis() - startMs + "ms");
  }*/
public void myShow() {
//自己实现show方法，主要是为了把setContentView方法放到show方法后面，否则会报错。
show();
setContentView(view);
}

private void setTitle(String title) {
//获取自己定义的title布局并赋值。
//((TextView) view.findViewById(R.id.date_picker_title)).setText(title);
}


private void setButton() {
//获取自己定义的响应按钮并设置监听，直接调用构造时传进来的CallBack接口（为了省劲，没有自己写接口，直接用之前本类定义好的）同时关闭对话框。
view.findViewById(R.id.but1).setOnClickListener(
new View.OnClickListener() {
@Override
public void onClick(View v) {
if (mCallBack != null) {
	Bitmap bmp =null;
mDatePicker.clearFocus();
mCallBack.onDateSet(mDatePicker,
mDatePicker.getYear(),
mDatePicker.getMonth(),
mDatePicker.getDayOfMonth(),"C",bmp);//299792458.4
}
dismiss();
}
});
view.findViewById(R.id.but2).setOnClickListener(
new View.OnClickListener() {
@Override
public void onClick(View v) {
if (mCallBack != null) {
	Bitmap bmp =null;
mDatePicker.clearFocus();
mCallBack.onDateSet(mDatePicker,
mDatePicker.getYear(),
mDatePicker.getMonth(),
mDatePicker.getDayOfMonth(),"G",bmp);//0.00000000006674
}
dismiss();
}
});
view.findViewById(R.id.but3).setOnClickListener(
new View.OnClickListener() {
@Override
public void onClick(View v) {
if (mCallBack != null) {
	Bitmap bmp =null;
mDatePicker.clearFocus();
mCallBack.onDateSet(mDatePicker,
mDatePicker.getYear(),
mDatePicker.getMonth(),
mDatePicker.getDayOfMonth(),"h",bmp);//0
}
dismiss();
}
});
view.findViewById(R.id.but4).setOnClickListener(
new View.OnClickListener() {
@Override
public void onClick(View v) {
if (mCallBack != null) {
	Bitmap bmp =null;
mDatePicker.clearFocus();
mCallBack.onDateSet(mDatePicker,
mDatePicker.getYear(),
mDatePicker.getMonth(),
mDatePicker.getDayOfMonth(),"N",bmp);//602214179000000000000000
}
dismiss();
}
});
view.findViewById(R.id.but5).setOnClickListener(
new View.OnClickListener() {
@Override
public void onClick(View v) {
if (mCallBack != null) {
	Bitmap bmp =null;
mDatePicker.clearFocus();
mCallBack.onDateSet(mDatePicker,
mDatePicker.getYear(),
mDatePicker.getMonth(),
mDatePicker.getDayOfMonth(),"E",bmp);//0
}
dismiss();
}
});
view.findViewById(R.id.but6).setOnClickListener(
new View.OnClickListener() {
@Override
public void onClick(View v) {
if (mCallBack != null) {
	Bitmap bmp =null;
mDatePicker.clearFocus();
mCallBack.onDateSet(mDatePicker,
mDatePicker.getYear(),
mDatePicker.getMonth(),
mDatePicker.getDayOfMonth(),"φ",bmp);//0.618033988749895
}
dismiss();
}
});


}


public void onDateChanged(DatePicker view, int year, int month, int day) {
mDatePicker.init(year, month, day, null);
}


/**
* Gets the {@link DatePicker} contained in this dialog.
* 
* @return The calendar view.
*/
}