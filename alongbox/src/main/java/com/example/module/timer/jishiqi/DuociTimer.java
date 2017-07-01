package com.example.module.timer.jishiqi;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.main.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class DuociTimer extends Activity {
	private long mlCount = 0;
	private TextView tvTime, hours, textwujici;
	private Button btnStartPause, duocijicubutton;
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
	ListView duocijishilist;
	int cishu = 1;
	String time[] = new String[1000];
	boolean okclear = false;

	@SuppressLint("HandlerLeak")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		init();

	}

	private void init() {
		setContentView(R.layout.duocijishi);
		tvTime = (TextView) findViewById(R.id.duocitvTime);
		hours = (TextView) findViewById(R.id.duocihours);
		textwujici = (TextView) findViewById(R.id.textwujici);
		duocijishilist = (ListView) findViewById(R.id.duocijishilist);
		btnStartPause = (Button) findViewById(R.id.duocistartbutton);
		duocijicubutton = (Button) findViewById(R.id.duocijicubutton);
		min_progress = (ImageView) this.findViewById(R.id.duocimin_progress);
		min_progress_hand = (ImageView) this
				.findViewById(R.id.duocimin_progress_hand);
		second_progress_hand = (ImageView) this
				.findViewById(R.id.duocisecond_progress_hand);
		second_progress = (ImageView) this
				.findViewById(R.id.duocisecond_progress);
		hour_progress_hand = (ImageView) this
				.findViewById(R.id.duocihour_progress_hand);
		hour_progress = (ImageView) this.findViewById(R.id.duocihour_progress);
		hoursoflinear = (LinearLayout) this
				.findViewById(R.id.duocihoursoflinear);
		duocijishilist.setAdapter(null);
		tvTime.setText("00:00.0");
		com.example.module.timer.jishiqi.SaveRun.setisjishi(false);
		handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				switch (msg.what) {
				case 1:
					mlCount++;
					int totalSec = 0;
					int yushu = 0;
					totalSec = (int) (mlCount / 10);
					yushu = (int) (mlCount % 10);
					int min = (totalSec / 60);
					if (min >= 60) {
						hoursoflinear.setVisibility(View.VISIBLE);
						hours.setText(String.valueOf(min / 60));
						min = min % 60;
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
		btnStartPause.setOnClickListener(startPauseListener);

	}

	@Override
	protected void onStart() {
		star();
		super.onStart();
	}

	private void star() {
		duocijicubutton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {

				if (okclear) {
					predegree = 0;
					secondpredegree = 0;
					hourpredegree = 0;
					second_progress_hand.setVisibility(View.GONE);
					min_progress.setVisibility(View.GONE);
					hour_progress.setVisibility(View.GONE);
					mlCount = 0;
					textwujici.setVisibility(View.VISIBLE);
					cishu = 1;
					init();
					star();
					com.example.module.timer.jishiqi.SaveRun.setisjishi(false);
				} else {
					
					if (cishu > 1000) {
						Toast.makeText(getApplicationContext(), "计数次数已经达上线！",
								Toast.LENGTH_SHORT).show();
					} else {
						if (timer == null) {
							Toast.makeText(getApplicationContext(), "未启动计时器",
									Toast.LENGTH_SHORT).show();
						} else {
							textwujici.setVisibility(View.GONE);
							setlistview();
						}
					}
				}
			}
		});

	}

	protected void setlistview() {

		if ((int) (mlCount) / 600 >= 60) {
			time[cishu - 1] = ((int) (mlCount) / 600) % 60
					+ tvTime.getText().toString();
		} else {
			time[cishu - 1] = tvTime.getText().toString();
		}
		ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < cishu; i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("jishicishu", String.valueOf(1 + i));
			map.put("jicitime", time[i]);
			listItem.add(map);
		}
		SimpleAdapter listItemAdapter = new SimpleAdapter(this, listItem,
				R.layout.list_item, new String[] { "jishicishu", "jicitime" },
				new int[] { R.id.jishicishu, R.id.jicitime });
		duocijishilist.setAdapter(listItemAdapter);
		duocijishilist.setSelection(cishu);
		cishu++;
	}

	View.OnClickListener startPauseListener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			if (null == timer) {
				if (null == task) {
					com.example.module.timer.jishiqi.SaveRun.setisjishi(true);
					btnStartPause.setText("暂停");
					duocijicubutton.setText("计次");
					okclear = false;
					min_progress.setVisibility(View.VISIBLE);
					second_progress.setVisibility(View.VISIBLE);
					hour_progress.setVisibility(View.VISIBLE);
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
			} else {
				try {
					com.example.module.timer.jishiqi.SaveRun.setisjishi(false);
					okclear = true;
					btnStartPause.setText("继续");
					duocijicubutton.setText("重置");
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
	};
}