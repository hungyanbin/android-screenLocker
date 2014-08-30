package com.yanbin.screenlocker;

import java.util.Stack;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

public class screenLocker {
	public static Stack<String> taskStack = new Stack<String>();
	private final static String TAG = screenLocker.class.getSimpleName();
	private static boolean isLocked = false;
	private static String TaskName;
	private static Activity currentTask;

	public static void regist(Activity registTask)
	{
		currentTask = registTask;
		TaskName = registTask.getClass().getSimpleName();
		
		if(taskStack.size() == 0)
			doWithEmptyStack();
		else 
			doWithNonEmptyStack();
		
		Log.i(TAG, toStaticString());
	}
	 

	private static void doWithEmptyStack()
	{
		taskStack.push(TaskName);
	}
	
	private static void doWithNonEmptyStack()
	{
		if(isResumeFromSameTask())
			startLockScreen();
		else
			resumeFromDifferentTask();
	}
	
	private static boolean isResumeFromSameTask()
	{
		if(TaskName.equals(taskStack.peek()))
			return true;
		else
			return false;
	}
	
	
	private static void startLockScreen()
	{
		if(!isLocked)
		{
			Intent intent = new Intent(currentTask,LockScreenActivity.class);
			currentTask.startActivity(intent);
			Log.i(TAG, "lock screen");
			isLocked = true;
		}
		else
			isLocked = false;
	}
	
	private static void resumeFromDifferentTask()
	{
		if(isStartAnotherActivity())
			taskStack.push(TaskName);
		else
			taskStack.pop();
	}
	
	private static boolean isStartAnotherActivity()
	{
		 if(taskStack.size() == 1)
			 return true;
		 else
		 {
			if(isBackFromTopActivity())
				return false;
			else				
				return true;
		 }
	}
	
	private static boolean isBackFromTopActivity()
	{
		String topTask = taskStack.pop();
		if(taskStack.peek().equals(TaskName))
		{
			taskStack.push(topTask);
			return true;
		}
		else
		{
			taskStack.push(topTask); 
			return false;
		}
	}
	
	
	public static String toStaticString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("class stack:").append(taskStack);
		
		return builder.toString();
	}
}
