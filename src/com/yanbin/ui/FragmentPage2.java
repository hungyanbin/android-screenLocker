package com.yanbin.ui;

import com.example.screenlocker.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class FragmentPage2 extends Fragment{

	public FragmentPage2(){
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_page2, container,
				false);
		
		TextView txt_enter = (TextView)rootView.findViewById(R.id.txt_enter);
		txt_enter.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(),anotherActivity1.class);
				startActivity(intent);
			}
			
		});
		return rootView;
	}
			
}
