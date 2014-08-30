package com.yanbin.ui;

import java.util.Locale;

import com.example.screenlocker.R;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class SectionsPagerAdapter extends FragmentPagerAdapter {

	private Context mContext;
	public SectionsPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {
		
		Fragment newFragment;
		switch(position)
		{
		case 0:
			newFragment = new FragmentPage1();
			break;
		case 1:
			newFragment = new FragmentPage2();
			break;
		default:
			newFragment = new FragmentPage3();
			break;
		}
		return newFragment;
	}

	@Override
	public int getCount() {
		// Show 3 total pages.
		return 3;
	}
	
	public void setContext(Context context)
	{
		mContext = context;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		Locale l = Locale.getDefault();
		switch (position) {
		case 0:
			return mContext.getString(R.string.title_section1).toUpperCase(l);
		case 1:
			return mContext.getString(R.string.title_section2).toUpperCase(l);
		case 2:
			return mContext.getString(R.string.title_section3).toUpperCase(l);
		}
		return null;
	}
}

