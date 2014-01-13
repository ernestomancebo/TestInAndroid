package com.ernesto.testinandroid.adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

public class ListasActualizaScroll extends ListView {

	private OnScrollListener onScrollListener = null;

	public ListasActualizaScroll(Context context) {
		super(context);
	}

	public ListasActualizaScroll(Context context, AttributeSet attrs,
			int defStyle) {
		super(context, attrs, defStyle);
	}

	public ListasActualizaScroll(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public void setOnScrollListener(OnScrollListener onScrollListener) {
		this.onScrollListener = onScrollListener;
	}
}
