package com.yanbin.ui;

import com.example.screenlocker.R;
import com.yanbin.screenlocker.screenLocker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class homeActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_acivity);
		
		TextView txt_enter = (TextView)findViewById(R.id.txt_enter);
		txt_enter.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(homeActivity.this,MainActivity.class);
				startActivity(intent);
			}
			
		});
	}
	
	@Override
	public void onResume()
	{
		super.onResume();
		screenLocker.regist(this);
	}

}
