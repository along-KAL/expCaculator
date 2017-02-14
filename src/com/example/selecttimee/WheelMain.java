package com.example.selecttimee;

import com.example.calculatorjykal.R;

import android.view.View;

public class WheelMain {

	private View view;
	private WheelView wv_year;
	private WheelView wv_month;
	private WheelView wv_day;
	public int screenheight;
	private boolean hasSelectTime;
	private static int START_YEAR = 0, END_YEAR = 23;

	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}

	public static int getSTART_YEAR() {
		return START_YEAR;
	}

	public static void setSTART_YEAR(int sTART_YEAR) {
		START_YEAR = sTART_YEAR;
	}

	public static int getEND_YEAR() {
		return END_YEAR;
	}

	public static void setEND_YEAR(int eND_YEAR) {
		END_YEAR = eND_YEAR;
	}

	public WheelMain(View view) {
		super();
		this.view = view;
		hasSelectTime = false;
		setView(view);
	}

	public WheelMain(View view, boolean hasSelectTime) {
		super();
		this.view = view;
		this.hasSelectTime = hasSelectTime;
		setView(view);
	}

	public void initDateTimePicker(int year, int month, int day) {
		this.initDateTimePicker(0, 0, 0, day, day);
	}

	public void initDateTimePicker(int year, int month, int day, int h, int m) {

		wv_year = (WheelView) view.findViewById(R.id.year);
		wv_year.setAdapter(new NumericWheelAdapter(00, 23));
		wv_year.setCyclic(true);
		wv_year.setLabel(" ±");
		wv_year.setCurrentItem(0);

		wv_month = (WheelView) view.findViewById(R.id.month);
		wv_month.setAdapter(new NumericWheelAdapter(00, 59));
		wv_month.setCyclic(true);
		wv_month.setLabel("∑÷");
		wv_month.setCurrentItem(0);

		wv_day = (WheelView) view.findViewById(R.id.day);
		wv_day.setAdapter(new NumericWheelAdapter(00, 59));
		wv_day.setCyclic(true);
		wv_day.setLabel("√Î");
		wv_day.setCurrentItem(0);
		int textSize = 0;
		if (hasSelectTime)
			textSize = (screenheight / 100) * 3;
		else
			textSize = (screenheight / 100) * 4;
		wv_day.TEXT_SIZE = textSize;
		wv_month.TEXT_SIZE = textSize;
		wv_year.TEXT_SIZE = textSize;
	}


	public int getwv_year() {
		return wv_year.getCurrentItem();
	}

	public int getwv_month() {
		return wv_month.getCurrentItem();
	}

	public int getwv_day() {
		return wv_day.getCurrentItem();
	}
}
