package com.cleanchina.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.cleanchina.R;
import com.cleanchina.app.CCActivity;

public class TitleBar extends FrameLayout implements
		android.view.View.OnClickListener {

	private TextView titleTv;
	private View backBtn;
	private ImageView leftBtn;
	private ImageView rightBtn;
	private ImageView rightBtn2;

	public TitleBar(Context context) {
		this(context, null);
	}

	public TitleBar(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		titleTv = (TextView) findViewById(R.id.title);
		backBtn = findViewById(R.id.title_back_btn);
		leftBtn = (ImageView) findViewById(R.id.title_left_btn);
		rightBtn = (ImageView) findViewById(R.id.title_right_btn);
		rightBtn2 = (ImageView) findViewById(R.id.title_right_btn2);
		backBtn.setOnClickListener(this);
	}

	public void setTitle(String title) {
		titleTv.setText(title);
	}

	public void setLeftButton(int resId, OnClickListener listener) {
		leftBtn.setImageResource(resId);
		leftBtn.setOnClickListener(listener);
		enableBackButton(false);
	}

	public void setRightButton(int resId, OnClickListener listener) {
		if (resId == 0) {
			rightBtn.setVisibility(View.GONE);
		} else {
			rightBtn.setVisibility(View.VISIBLE);
			rightBtn.setImageResource(resId);
			rightBtn.setOnClickListener(listener);
		}
	}

	public void setRight2Button(int resId, OnClickListener listener) {
		if (resId == 0) {
			rightBtn2.setVisibility(View.GONE);
		} else {
			rightBtn2.setVisibility(View.VISIBLE);
			rightBtn2.setImageResource(resId);
			rightBtn2.setOnClickListener(listener);
		}
	}

	public void enableBackButton(boolean enable) {
		if (enable) {
			backBtn.setVisibility(View.VISIBLE);
			leftBtn.setVisibility(View.GONE);
		} else {
			backBtn.setVisibility(View.GONE);
			leftBtn.setVisibility(View.VISIBLE);
		}
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.title_back_btn) {
			if (getContext() instanceof CCActivity) {
				((CCActivity) getContext()).finish();
			}
		}
	}
}
