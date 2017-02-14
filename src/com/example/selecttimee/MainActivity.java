package com.example.selecttimee;
import java.util.Timer;
import java.util.TimerTask;

import com.example.calculatorjykal.R;
import com.example.jishiqi.SaveRun;
import com.example.jishiqi.SlipButton;
import com.example.slidingmenufragmenttest.fragment.Jishiqi;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	WheelMain wheelMain;
	LinearLayout timepickerlin;
	Button btnselecttime, daojishijicubutton;
	RelativeLayout listjishi;
	private Timer timer = null;
	private TimerTask task = null;
	private Handler handler = null;
	private Message msg = null;
	private ImageView min_progress, min_progress_hand, second_progress_hand,
			second_progress, hour_progress_hand, hour_progress;
	Animation rotateAnimation, secondrotateAnimation, hourrotateAnimation;
	float predegree = 0;
	float secondpredegree = 0;
	float hourpredegree = 0;
	LinearLayout hoursoflinear;
	int mlCount = -1;
	TextView tvTime, hours;
	private SlipButton ringtixing, screenon;
	boolean ring = true; 
	static boolean	screen = true;
	private SoundPool sp;
	private int num;
	@SuppressLint("Wakelock")
	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.main);
		timepickerlin = (LinearLayout) findViewById(R.id.timepickerlin);
		listjishi = (RelativeLayout) findViewById(R.id.daojishirelativ);

		btnselecttime = (Button) findViewById(R.id.daojishistartbutton);
		ringtixing = (SlipButton) findViewById(R.id.ringtixing);
		screenon = (SlipButton) findViewById(R.id.scroonlisht);
		screenon.setChecked(true);
		ringtixing.setChecked(true);

        sp= new SoundPool(10, AudioManager.STREAM_SYSTEM, 5);
        num = sp.load(this, R.raw.in_call_alarm, 1); 
        
        
        
        

        
        
        
		screenon.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if (screen) {
					screenon.setChecked(false);
					screen = false;
				} else {
					screenon.setChecked(true);
					screen = true;
				}
			}
		});
		
		ringtixing.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if (ring) {
					ringtixing.setChecked(false);
					ring = false;
				} else {
					ringtixing.setChecked(true);
					ring = true;
				}
			}
		});
		daojishijicubutton = (Button) findViewById(R.id.daojishijicubutton);

		tvTime = (TextView) findViewById(R.id.daojishitvTime);
		hours = (TextView) findViewById(R.id.daojishihours);

		min_progress = (ImageView) this.findViewById(R.id.daojishimin_progress);
		min_progress_hand = (ImageView) this
				.findViewById(R.id.daojishimin_progress_hand);
		second_progress_hand = (ImageView) this
				.findViewById(R.id.daojishisecond_progress_hand);
		second_progress = (ImageView) this
				.findViewById(R.id.daojishisecond_progress);
		hour_progress_hand = (ImageView) this
				.findViewById(R.id.daojishihour_progress_hand);
		hour_progress = (ImageView) this
				.findViewById(R.id.daojishihour_progress);
		hoursoflinear = (LinearLayout) this
				.findViewById(R.id.daojishihoursoflinear);
		LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
		final View timepickerview = inflater.inflate(R.layout.timepicker, null);
		ScreenInfo screenInfo = new ScreenInfo(MainActivity.this);
		wheelMain = new WheelMain(timepickerview);
		wheelMain.screenheight = screenInfo.getHeight();
		wheelMain.initDateTimePicker(0, 0, 0);
		timepickerlin.addView(timepickerview);
		SaveRun.setisdaojishi(false);
		handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				switch (msg.what) {
				case 1:
					mlCount--;
					if (mlCount <= 0) {
						enddaojishi();
					}
					if (screen) {
                    Jishiqi.seekBar.setProgress(1);
					}else{
						Jishiqi.seekBar.setProgress(2);
					}
					int totalSec = 0;
					int yushu = 0;
					totalSec = (int) (mlCount / 10);
					yushu = (int) (mlCount % 10);
					int min = (totalSec / 60);
					if (min >= 60) {
						hoursoflinear.setVisibility(View.VISIBLE);
						hours.setText(String.valueOf(min / 60));
						min = min % 60;
					}else{
						hoursoflinear.setVisibility(View.GONE);
					}
					int sec = (totalSec % 60);
					try {
						rotateAnimation = new RotateAnimation(predegree,
								(float) (0.6 * mlCount),
								Animation.RELATIVE_TO_SELF, 0.5f,
								Animation.RELATIVE_TO_SELF, 0.5f);
						secondrotateAnimation = new RotateAnimation(
								secondpredegree, (float) (36.0 * mlCount),
								Animation.RELATIVE_TO_SELF, 0.5f,
								Animation.RELATIVE_TO_SELF, 0.5f);
						hourrotateAnimation = new RotateAnimation(
								hourpredegree, (float) (mlCount / 100),
								Animation.RELATIVE_TO_SELF, 0.5f,
								Animation.RELATIVE_TO_SELF, 0.5f);
						rotateAnimation.setDuration(100);
						secondrotateAnimation.setDuration(100);
						rotateAnimation.setFillAfter(true);
						hourrotateAnimation.setDuration(100);
						hourrotateAnimation.setFillAfter(true);
						secondrotateAnimation.setFillAfter(true);
						min_progress_hand.startAnimation(rotateAnimation);
						min_progress.startAnimation(rotateAnimation);
						second_progress_hand
								.startAnimation(secondrotateAnimation);
						second_progress.startAnimation(secondrotateAnimation);

						hour_progress_hand.startAnimation(hourrotateAnimation);
						hour_progress.startAnimation(hourrotateAnimation);

						tvTime.setText(String.format("%1$02d:%2$02d.%3$d", min,
								sec, yushu));
						predegree = (float) (0.6 * mlCount);
						secondpredegree = (float) (36.0 * mlCount);
						hourpredegree = (float) (mlCount / 100);
					} catch (Exception e) {
						tvTime.setText("" + min + ":" + sec + "." + yushu);
						e.printStackTrace();
					}
					break;
				default:
					break;
				}
				super.handleMessage(msg);
			}
		};
	}
	private void enddaojishi() {
		if (ring) {
			sp.play(num, 1, 1, 0,1, 1);  
			// 播放铃声
		}
		try {
			Jishiqi.seekBar.setProgress(2);
			task.cancel();
			task = null;
			timer.cancel();
			timer.purge();
			timer = null;
			handler.removeMessages(msg.what);
			new AlertDialog.Builder(MainActivity.this)
					.setTitle("提示 ")
					.setMessage("倒计时结束")
					.setPositiveButton("确定",
							new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									dialog.cancel();
									listjishi.setVisibility(View.GONE);
									timepickerlin.setVisibility(View.VISIBLE);
									mlCount = -1;
									btnselecttime.setText("开始");
									SaveRun.setisdaojishi(false);
								}
							}).setCancelable(false).create().show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void onStart() {
		daojishijicubutton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				predegree =0;
				secondpredegree =0;
				hourpredegree = 0;
				listjishi.setVisibility(View.GONE);
				timepickerlin.setVisibility(View.VISIBLE);
				mlCount = -1;
				btnselecttime.setText("开始");
				SaveRun.setisdaojishi(false);
				try {
					if (task != null) {
						Jishiqi.seekBar.setProgress(2);
						task.cancel();
						task = null;
						timer.cancel();
						timer.purge();
						timer = null;
						handler.removeMessages(msg.what);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		btnselecttime.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if (null == timer) {
					if (mlCount == -1 || mlCount == 0) {
						mlCount = wheelMain.getwv_year() * 36000
								+ wheelMain.getwv_month() * 600
								+ wheelMain.getwv_day() * 10;
					}
					if (mlCount > 0) {
						SaveRun.setisdaojishi(true);
						btnselecttime.setText("暂停");
						listjishi.setVisibility(View.VISIBLE);
						timepickerlin.setVisibility(View.GONE);
						if (null == task) {
							task = new TimerTask() {
								@Override
								public void run() {
									if (null == msg) {
										msg = new Message();
									} else {
										msg = Message.obtain();
									}
									msg.what = 1;
									handler.sendMessage(msg);
								}
							};
						}
						timer = new Timer(true);
						timer.schedule(task, 100, 100);
					}
				} else {
					try {
						SaveRun.setisdaojishi(false);
						Jishiqi.seekBar.setProgress(2);
						btnselecttime.setText("继续");
						task.cancel();
						task = null;
						timer.cancel();
						timer.purge();
						timer = null;
						handler.removeMessages(msg.what);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
		super.onStart();
	}
}