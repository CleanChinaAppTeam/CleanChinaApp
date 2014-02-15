package com.cleanchina.meeting.view;

import uk.co.senab.photoview.PhotoView;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.util.AttributeSet;

public class CompanyMapView extends PhotoView {
	
	private int mapWidth;
	private int mapHeight;
	
	public int getMapWidth() {
		return mapWidth;
	}

	public int getMapHeight() {
		return mapHeight;
	}
	
	public int getPosXInView(int xInMap) {
		final RectF displayRect = getDisplayRect();
		return (int) (displayRect.left + displayRect.width() * xInMap / mapWidth);
	}
	
	public int getPosYInView(int yInMap) {
		final RectF displayRect = getDisplayRect();
		return (int) (displayRect.top + displayRect.height() * yInMap / mapHeight);
	}
	
	public CompanyMapView(Context context) {
		this(context, null);
	}

	public CompanyMapView(Context context, AttributeSet attr) {
		super(context, attr);
	}

	@Override
	public void setImageBitmap(Bitmap bmp) {
		mapWidth = bmp.getWidth();
		mapHeight = bmp.getHeight();
		super.setImageBitmap(bmp);
	}

}