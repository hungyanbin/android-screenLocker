package com.yanbin.ui;

import com.example.screenlocker.R;
import com.yanbin.screenlocker.screenLocker;

import android.app.Activity;
import android.os.Bundle;

public class anotherActivity1 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.another_acivity1);
	}

	@Override
	public void onResume()
	{
		super.onResume();
		screenLocker.regist(this);
	}
}
