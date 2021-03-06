package com.cleanchina.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;

import com.cleanchina.R;
import com.cleanchina.widget.TitleBar;
import com.dennytech.common.app.CLActivity;

public class CCActivity extends CLActivity {

	private TitleBar titleBar;

	/**
	 * custom title type
	 * 
	 * @return
	 */
	protected int customTitleType() {
		return Window.FEATURE_CUSTOM_TITLE;
	}

	@Override
	public void setContentView(int layoutResID) {
		requestWindowFeature(customTitleType());
		super.setContentView(layoutResID);
		if (customTitleType() == Window.FEATURE_CUSTOM_TITLE) {
			initCustomTitle();
		}
	}

	@Override
	public void setContentView(View view) {
		requestWindowFeature(customTitleType());
		super.setContentView(view);
		if (customTitleType() == Window.FEATURE_CUSTOM_TITLE) {
			initCustomTitle();
		}
	}

	@Override
	public void setContentView(View view, ViewGroup.LayoutParams params) {
		requestWindowFeature(customTitleType());
		super.setContentView(view, params);
		if (customTitleType() == Window.FEATURE_CUSTOM_TITLE) {
			initCustomTitle();
		}
	}

	protected void initCustomTitle() {
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,
				R.layout.custom_title);
		titleBar = (TitleBar) findViewById(R.id.titlebar);
		enableBackButton(true);
	}

	@Override
	public void setTitle(CharSequence title) {
		super.setTitle(title);
		if (titleBar == null) {
			return;
		}
		titleBar.setTitle(title.toString());
	}

	public void setLeftButton(int resId, OnClickListener listener) {
		if (titleBar == null) {
			return;
		}
		titleBar.setLeftButton(resId, listener);
	}

	public void setRightButton(int resId, OnClickListener listener) {
		if (titleBar == null) {
			return;
		}
		titleBar.setRightButton(resId, listener);
	}

	public void setRight2Button(int resId, OnClickListener listener) {
		if (titleBar == null) {
			return;
		}
		titleBar.setRight2Button(resId, listener);
	}

	public void enableBackButton(boolean enable) {
		if (titleBar == null) {
			return;
		}
		titleBar.enableBackButton(enable);
	}

	private SharedPreferences sharePref;

	public SharedPreferences preferences() {
		if (sharePref == null) {
			sharePref = getSharedPreferences(getPackageName(),
					Context.MODE_PRIVATE);
		}
		return sharePref;
	}

}
