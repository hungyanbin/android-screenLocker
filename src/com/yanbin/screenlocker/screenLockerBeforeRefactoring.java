package com.example.screenlocker;

import java.util.Stack;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

public class screenLocker {
	public static Stack<String> taskStack = new Stack<String>();
	private final static String TAG = screenLocker.class.getSimpleName();
	private static boolean isLocked = false;

	public static void regist(Activity registActivity)
	{
		String ActivityName = registActivity.getClass().getSimpleName();
		if(taskStack.size() == 0)
			taskStack.push(ActivityName);
		else if(taskStack.size() == 1)
		{
			if(ActivityName.equals(taskStack.peek()))
				startLockScreen(registActivity);
			else
			{
				taskStack.push(ActivityName);
				Log.i(TAG, "enter another activity");
			}
		}
		else
		{
			if(ActivityName.equals(taskStack.peek()))
				startLockScreen(registActivity);
			else
			{
				String topClass = taskStack.pop();
				if(!taskStack.peek().equals(ActivityName))
				{
					taskStack.push(topClass);
					taskStack.push(ActivityName);
					Log.i(TAG, "enter another activity");
				}
				else
				{
					Log.i(TAG, "exit another activity");
				}
			}
		}
		Log.i(TAG, toStaticString());
	}
	 

	
	private static void startLockScreen(Activity orignal)
	{
		if(!isLocked)
		{
			Intent intent = new Intent(orignal,LockScreenActivity.class);
			orignal.startActivity(intent);
			Log.i(TAG, "lock screen");
			isLocked = true;
		}
		else
			isLocked = false;
	}
	
	
	public static String toStaticString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("class stack:").append(taskStack);
		
		return builder.toString();
	}
}