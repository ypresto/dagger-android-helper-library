package com.anprosit.android.dagger.service;

import android.annotation.TargetApi;
import android.os.Build;
import android.service.media.MediaBrowserService;

import com.anprosit.android.dagger.DaggerContext;
import com.anprosit.android.dagger.helper.DaggerHelper;

import java.util.List;

import dagger.ObjectGraph;

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public abstract class DaggerMediaBrowserService extends MediaBrowserService implements DaggerContext {
	private DaggerHelper mHelper = new DaggerHelper();

	@Override
	public void onCreate() {
		super.onCreate();
		mHelper.onCreate(this, getModules());
	}

	@Override
	public void onDestroy() {
		mHelper.onDestroy();
		super.onDestroy();
	}

	protected abstract List<Object> getModules();

	public <T> T inject(T obj) {
		return mHelper.inject(obj);
	}

	@Override
	public ObjectGraph getObjectGraph() {
		return mHelper.getObjectGraph();
	}
}
