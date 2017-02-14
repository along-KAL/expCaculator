package com.example.calculatorjykal;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;











import blur.FastBlur;











import com.example.calculatorjykal.R;
import com.example.slidingmenufragmenttest.fragment.Caidananima;
import com.example.slidingmenufragmenttest.fragment.Daojishi;
import com.example.slidingmenufragmenttest.fragment.Fk;
import com.example.slidingmenufragmenttest.fragment.Guanyu;
import com.example.slidingmenufragmenttest.fragment.Jihe;
import com.example.slidingmenufragmenttest.fragment.Jisuanqi;
import com.example.slidingmenufragmenttest.fragment.Juzhen;
import com.example.slidingmenufragmenttest.fragment.MenuFragment;
import com.example.slidingmenufragmenttest.fragment.MenuFragment.SLMenuListOnItemClickListener;
import com.example.slidingmenufragmenttest.fragment.Pf;
import com.example.slidingmenufragmenttest.fragment.Pingfen;
import com.example.slidingmenufragmenttest.fragment.Jinzhizh;
import com.example.slidingmenufragmenttest.fragment.Share;
import com.example.slidingmenufragmenttest.fragment.Tongji;
import com.example.slidingmenufragmenttest.fragment.Yijianfankui;
import com.umeng.analytics.MobclickAgent;
import com.umeng.fb.FeedbackAgent;
import com.umeng.fb.model.Conversation;
import com.umeng.update.UmengUpdateAgent;











import net.simonvt.menudrawer.MenuDrawer;
import net.simonvt.menudrawer.MenuDrawer.OnDrawerStateChangeListener;
import net.simonvt.menudrawer.MenuDrawer.OnInterceptMoveEventListener;
//import net.simonvt.menudrawer.MenuDrawer.OnblurStateChangeListener;
import net.simonvt.menudrawer.Position;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityGroup;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.UiModeManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.InputType;
import android.util.Log;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class CalculatorActivity extends ActivityGroup implements SLMenuListOnItemClickListener,FragmentActivityListener{
	private EditText  rsText;
	private MenuDrawer m;
    boolean share =false;
    boolean PF = false;
    boolean FK = false;
    //计时器page
    private ArrayList<View> pageViews;
    //友盟反馈
    FeedbackAgent fb;
    
	 Fragment  fragment=null;
	@SuppressLint("NewApi")
	@Override                                         //slidingdraw
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		UmengUpdateAgent.setUpdateOnlyWifi(false);
		UmengUpdateAgent.update(this);//自动更新回调接口: 通过注册UmengUpdateListener，并实现 onUpdateReturned(int statusCode, UpdateResponse updateInfo)，可以获得自动更新的返回状态，并实现自定义操作。其中statusCode参数表示更新返回状态，状态在statusCode中，0表示有更新，1表示无更新，2表示非wifi状态，3表示请求超时。从安全性考虑，我们要求您保证当前应用的包名(Package)和您每次更新上传APK的包名保持一致。需要添加权
		
	 LayoutInflater lf = getLayoutInflater();
		View v = lf.inflate(R.layout.frame_menu, null);
		m  = MenuDrawer.attach(this, MenuDrawer.Type.OVERLAY, Position.RIGHT);
		    m.setTouchMode(MenuDrawer.TOUCH_MODE_BEZEL);
		    m.setDropShadowEnabled(false);
		        m.setContentView(R.layout.calculator);		        
		        m.setMenuView(v);
		        Fragment  fragment=new Jisuanqi();
		        FragmentTransaction  fragmentTransaction = getFragmentManager().beginTransaction();
		       // MenuFragment menuFragment = new MenuFragment();
		        fragmentTransaction.replace(R.id.content,fragment );
		       // fragmentTransaction.replace(R.id.menu1, new MenuFragment());
		        Animation animation = new AlphaAnimation(0,1.0f);   //AlphaAnimation 控制渐变透明的动画效果
		        animation.setDuration(900);
		        m.setAnimation(animation);
		        fragmentTransaction.commit();
		   
		         rsText = (EditText)findViewById(R.id.rsText);
		         
		         //友盟
		         fb  = new FeedbackAgent(CalculatorActivity.this);
		        fb.sync();
		       // Conversation conversation = fb.getDefaultConversation();
		      //  conversation.sync(listener);
		        // com.umeng.fb.util.Log.LOG = true;
		         //setUpUmengFeedback();
		        /*  EditText  rsText = (EditText)findViewById(R.id.rsText);
		        editText.setCustomSelectionActionModeCallback(new ActionMode.Callback() {  
		            
		            @Override  
		            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {  
		                return false;  
		            }  
		              
		            @Override  
		            public void onDestroyActionMode(ActionMode mode) {  
		                  
		            }  
		              
		            @Override  
		            public boolean onCreateActionMode(ActionMode mode, Menu menu) {  
		                return false;  
		            }  
		              
		            @Override  
		            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {  
		                return false;  
		            }  
		        }); 
		          if (android.os.Build.VERSION.SDK_INT <= 10) {
		    		
                    rsText.setInputType(InputType.TYPE_NULL);
            } else {
            	getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
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
		   *//*if(rsText.getText()!=null){
		        SharedPreferences sp = this.getSharedPreferences("Edittext",  
		                MODE_PRIVATE);  
		        // music_progress为XML文件的文件名  
		        rsText.setText(sp.getString("edittext",null));
		        }*/
		       
		         
//		         m.setOnBlurtateChangeListener(new OnblurStateChangeListener() {
		        	
//					@Override
//					public void onblurSate(int oldState, int newState) {
						//System.out.println(888);
//						int a=33;
						//System.out.println(oldState);
						//System.out.println(newState);
						/*Jisuanqi jf = (Jisuanqi)getFragmentManager().findFragmentById(R.layout.fragment_jisuanqi);
						jf.onCreateView(lf, null, null);*/
//						if(oldState==4){
//							if(a==oldState){}
//							else{
//							 a = oldState;
							
//							FragmentTransaction transaction = getFragmentManager().beginTransaction();
					    	 
//					    	transaction.replace(R.id.menu1, new Caidananima());
//					    	transaction.commit();}
							//System.out.println(oldState+newState);
							//System.out.println(newState);
							//写清晰
//						}else if(newState==8){
						
							FragmentTransaction transaction = getFragmentManager().beginTransaction();
					    	transaction.setCustomAnimations(0,  
			                         android.R.animator.fade_out); 
					    	transaction.replace(R.id.menu1, new MenuFragment());  
					    	transaction.commit(); 
							//System.out.println(oldState+newState);
							//System.out.println(newState);
							//写模糊
							/*View rootView = inflater.inflate(R.layout.fragment_jisuanqi, null);
							LayoutInflater lf = getLayoutInflater();
							View v = lf.inflate(R.layout.fragment_jisuanqi, null);
							//System.out.println(v);
							//Bitmap b = GetandSaveCurrentImage(v);
							Bitmap b =takeScreenShot(CalculatorActivity.this);
							System.out.println(b);
							b = FastBlur.doBlur(b, 33, true);
							 l.setBackground(new BitmapDrawable(getResources(), b));
						        setContentView(l);
							 FragmentTransaction  fragmentTransaction = getFragmentManager().beginTransaction();
							//System.out.println(oldState);
							//System.out.println(newState);
							fragmentTransaction.remove( fragment);  
							fragmentTransaction.commit();*/
//						}
//						
//					}
//			});
	}




















//实现按两次推出

	private long mExitTime;

	@Override
	 public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
                if ((System.currentTimeMillis() - mExitTime) > 2000) {
                        Object mHelperUtils;
                        Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                        mExitTime = System.currentTimeMillis();

                } else {
                        finish();
                }
                return true;
        }
        return super.onKeyDown(keyCode, event);
}
	
	
	public void onResume() {
		super.onResume();
		MobclickAgent.onResume(this);
		}
		public void onPause() {
		super.onPause();
		MobclickAgent.onPause(this);
		}
	//获取屏幕Bitmap
	/*private static Bitmap takeScreenShot(Activity activity){
		View view =activity.getWindow().getDecorView();
		view.setDrawingCacheEnabled(true);
		view.buildDrawingCache();
		Bitmap bitmap = view.getDrawingCache();
		Rect rect = new Rect();
		activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
		int statusBarHeight = rect.top;
		System.out.println(statusBarHeight);
		
		int width = activity.getWindowManager().getDefaultDisplay().getWidth();
		int height = activity.getWindowManager().getDefaultDisplay().getHeight();
		
		Bitmap bitmap2 = Bitmap.createBitmap(bitmap,0,statusBarHeight, width, height - statusBarHeight);
		view.destroyDrawingCache();
		return bitmap2;
	}
    private Bitmap GetandSaveCurrentImage(View v)  
    {  
      
    	//将布局转换为View类型对象
    	  View view = v;
    			  //getLayoutInflater().inflate(id, null);
    	  //打开图像缓存
    	  view.setDrawingCacheEnabled(true);
    	  //必须调用measure和layout方法才能成功保存可视组件的截图到png图像文件
    	  //测量View大小
    	  view.measure(MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED),
    	    MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
    	  //发送位置和尺寸到View及其所有的子View
    	  
    	  view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    	
    	   //获得可视组件的截图
    	   Bitmap bitmap = view.getDrawingCache();
    	   //System.out.println(view);
        return bitmap;}*/
	/*@Override  
    public void onDestroy() {  
		super.onDestroy();
		SharedPreferences sp = this.getSharedPreferences("Edittext",  
                MODE_PRIVATE);  
        sp.edit().putString("edittext", rsText.getText().toString()).commit();
		
	}*/
		int Jisuanqi= 0;
		int Jinzhizh= 0;
		int Daojishi= 0;
		//int Pingfen= 0;
		int Guanyu= 0;
		int Jishiqi =0;
		int Juzhen =0;
		int Tongji = 0;
		int Jihe = 0;
	//	int Yijianfankui= 0;
	@SuppressLint("NewApi")
	@Override
	
	public void selectItem(int position, String title) {
		// update the main content by replacing fragments  
		
	    
	    switch (position) {  
	    case 0:  
	        fragment = new Jisuanqi(); 
	        Jisuanqi = Jisuanqi+1;
	         Jinzhizh= 0;
			 Daojishi= 0;
			  Jishiqi =0;
			 Guanyu= 0;
			 Juzhen =0;
			 Tongji = 0;
			 Jihe = 0;
	        break;  
	    case 1:  
	   	 fragment = new Juzhen();  
    	 Juzhen = Juzhen+1;
    	 	Guanyu=0;
	        Jinzhizh= 0;
	        Jisuanqi= 0;
	    	 Daojishi= 0;
	    	 Jishiqi =0;
	    	 Tongji = 0;
			 Jihe = 0;
			 break;  
	    case 2:  
	    	 fragment = new Jihe();  
		        Jihe = Jihe+1;
		        Jinzhizh= 0;
		        Jisuanqi= 0;
		    	 Daojishi= 0;
		    	 Jishiqi =0;
		    	 Juzhen =0;
		    	 Tongji = 0;
				 
	    	
	        break;  
	    case 3:  
	    	 fragment = new Tongji();  
		        Tongji = Tongji+1;
		        Jinzhizh= 0;
		        Jisuanqi= 0;
		    	 Daojishi= 0;
		    	 Jishiqi =0;
		    	 Juzhen =0;
				 Jihe = 0;	    
	    
	    	

	        break;  
	    case 4: 
	    	fragment = new Jinzhizh();
	    	Jinzhizh = Jinzhizh+1;
	    	 Jisuanqi= 0;
	    	 Daojishi= 0;
	    	  Jishiqi =0;
			 Guanyu= 0;
			 Juzhen =0;
			 Tongji = 0;
			 Jihe = 0;
	    	
	
	        break;  
	    case 5: 
	    	fragment = new Daojishi(); 
	    	Daojishi = Daojishi+1;
	    	 Jinzhizh= 0;
	    	 Jisuanqi= 0;
	    	 Jishiqi =0;
			 Guanyu= 0;
			 Juzhen =0;
			 Tongji = 0;
			 Jihe = 0;
	   	
	    	
	        break;  
	    case 6:  
	    	 fragment = new com.example.slidingmenufragmenttest.fragment.Jishiqi();  
	    	 Jishiqi = Jishiqi+1;
		        Jinzhizh= 0;
		        Jisuanqi= 0;
		        Guanyu= 0;
		    	 Daojishi= 0;
		    	 Juzhen =0;
		    	 Tongji = 0;
				 Jihe = 0;
	    	
	        break;  
	    case 7:  
	    	 fragment = new Share(); 
		     //   Pingfen = Pingfen+1;
		        Jinzhizh= 0;
		        Jisuanqi= 0;
		    	 Daojishi= 0;
				 Guanyu= 0;
				 Jishiqi =0;
		        share=true;
		        Juzhen =0;
		        Tongji = 0;
				 Jihe = 0;
	    	 
	    
	    	
	        break;  
	    case 8:  
	    	fragment = new Pf(); 
	 	    PF = true;
	 	        Jinzhizh= 0;
	 	        Jisuanqi= 0;
	 	    	 Daojishi= 0;
	 	    	 Jishiqi =0;
	 	    	 Guanyu= 0;
	 	    	 Tongji = 0;
				 Jihe = 0;
	    
	        break;  
	    case 9:  
	    	Juzhen =0;
	    	 fragment = new Fk(); 
		      FK = true;
		        Jinzhizh= 0;
		        Jisuanqi= 0;
		    	 Daojishi= 0;
		    	 Jishiqi =0;
		    	 Guanyu= 0;
		    	 Juzhen =0;
		    	 Tongji = 0;
				 Jihe = 0;
	    	
	    	
	        break;  
	    case 10:  

	    	 fragment = new Guanyu();  
		        Guanyu = Guanyu+1;
		        Jinzhizh= 0;
		        Jisuanqi= 0;
		    	 Daojishi= 0;
		    	 Jishiqi =0;
		    	 Juzhen =0;
		    	 Tongji = 0;
				 Jihe = 0;			 
	        break;  
	    default:  
	        break;  
	    }
	    
	    if (fragment != null) {  
	    	m.closeMenu();
	    	
	    	final Fragment fragment1 = fragment;
	    	 
	    	m.setOnDrawerStateChangeListener(new OnDrawerStateChangeListener() {
	    		
				@Override
				public void onDrawerStateChange(int oldState, int newState) {
					
					
					if( share==true){share();
					share=false;}
					else if(PF==true){
						pingFen();
						PF=false;
					}else if(FK == true){
						FK=false;
						
						fb.startFeedbackActivity();
					
					}
					else if( Jinzhizh== 1||
			        Jisuanqi==1||
			    	 Daojishi== 1||  
			    	 Guanyu== 1||Jishiqi==1||Juzhen==1||
			    	Jihe == 1||Tongji==1){
			    	FragmentTransaction transaction = getFragmentManager().beginTransaction();
//	    	transaction.setCustomAnimations(0,  
//	                         android.R.animator.fade_out); 
	    	
			    	transaction.replace(R.id.content, fragment1);  
			    	
			    	transaction.commit();
			    		
			    	
				}
					}
			
				@Override
				public void onDrawerSlide(float openRatio, int offsetPixels) {
					// TODO Auto-generated method stub
				//	System.out.println("哈哈");
				}
			});
	    	
	    	
	    	
	    	
	        // update selected item and title, then close the drawer  
	        setTitle(title);
	        
	    } else {  
	        // error in creating fragment  
	        Log.e("MainActivity", "Error in creating fragment");  
	    }  
	    	
	    
	} 
	public   void pingFen(){
		
		 Uri uri = Uri.parse("market://details?id="+"com.example.calculatorjykal"); 
    	Intent intent = new Intent(Intent.ACTION_VIEW,uri);  
    	intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);  
    	this.startActivity(intent);  
		
	}
	static String path;
	//分享
	public  void share(){
		// System.out.println("heheheh");
		
		 new Thread(new Runnable(){

             @Override
             public void run() {
            	 //是截图完整
            	 synchronized (this) { //把wait代码放在synchronized块中，锁线程自己
            		    try {
							this.wait(40);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} //锁一定的时间，要不然没有notify就一直wait了
            		}

            //调用截图函数并保存sd卡
            	 CalculatorActivity.savePic(CalculatorActivity.takeScreenShot(CalculatorActivity.this),Environment.getExternalStorageDirectory()+"/mnt/sdcard/"+"screenShot.png");
				 path = Environment.getExternalStorageDirectory()+"/mnt/sdcard/"+"screenShot.png";
				 //System.out.println(path+".........................................");
            	//System.out.println(path+"555");
                 Intent intent = new Intent(Intent.ACTION_SEND);  
                 intent.setType("image/*");  
                // intent.setType("text/plain");
                 intent.putExtra(Intent.EXTRA_SUBJECT, "分享");     
                 intent.putExtra(Intent.EXTRA_TITLE, "分享"); 
                 intent.putExtra(Intent.EXTRA_TEXT, "一个不错的计算器！分享一下！");
                 intent.putExtra(Intent.EXTRA_STREAM,Uri.parse("file:///"+path));
               //  Log.i("debug", "/data/data/" + acty.getApplicationInfo().packageName+ "/share.png");
                // System.out.println("file:////data/data/" + AppActivity.getContext().getApplicationInfo().packageName+ "/screenShot.png");
                 intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);     
                 
                 CalculatorActivity.this.startActivity(Intent.createChooser(intent, "分享")); 
             }
             
         }).start();
	}
	//截图
	private static Bitmap takeScreenShot(Activity activity) {
        // View是你需要截图的View
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap b1 = view.getDrawingCache();
        // 获取状态栏高度
        Rect frame = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        int statusBarHeight = frame.top;
        Log.i("TAG", "" + statusBarHeight);
        // 获取屏幕长和高
        int width = activity.getWindowManager().getDefaultDisplay().getWidth();
        int height = activity.getWindowManager().getDefaultDisplay()
                .getHeight();
        // 去掉标题栏
        // Bitmap b = Bitmap.createBitmap(b1, 0, 25, 320, 455);
        Bitmap b = Bitmap.createBitmap(b1, 0, statusBarHeight, width, height
                - statusBarHeight);
        view.destroyDrawingCache();
        return b;
    }
    // 截图保存到sdcard
    private static void savePic(Bitmap b, String strFileName) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(strFileName);
            if (null != fos) {
                b.compress(Bitmap.CompressFormat.PNG, 90, fos);
                fos.flush();
                fos.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
       // return Environment.getExternalStorageDirectory()+"/mnt/sdcard/"+"screenShot.png" ;
    }
/*	private void showShare() {
        ShareSDK.initSDK(this);
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();
        
        // 分享时Notification的图标和文字
        oks.setNotification(R.drawable.ic_launcher1, getString(R.string.app_name));
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用 
        oks.setTitle(getString(R.string.share));
        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
       // oks.setTitleUrl("http://sharesdk.cn");
        // text是分享文本，所有平台都需要这个字段
        oks.setText("推荐一款应用！简约计算器，有倒计日的计算器，界面简洁漂亮，很人性化哦！");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
       // oks.setImagePath("http://image.baidu.com/detail/newindex?col=%E6%90%9E%E7%AC%91&tag=%E7%99%BE%E6%80%9D%E4%B8%8D%E5%BE%97%E5%A7%90&pn=12&pid=11740947825&aid=11740947825&user_id=10086&setid=-1&sort=0&newsPn=&fr=&from=1");
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
        // comment是我对这条分享的评论，仅在人人
        oks.setComment("good"); 
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");

        // 启动分享GUI
        oks.show(this);
   }*/
//计时器page
public ArrayList<View> getViewPage(){
	
	pageViews = new ArrayList<View>();

	View view02 = getLocalActivityManager().startActivity("activity02",
			new Intent(this, com.example.jishiqi.DuociTimer.class))
			.getDecorView();
	View view03 = getLocalActivityManager().startActivity("activity03",
			new Intent(this, com.example.selecttimee.MainActivity.class))
			.getDecorView();
	pageViews.add(view02);
	pageViews.add(view03);
	
	return pageViews;
}
}


