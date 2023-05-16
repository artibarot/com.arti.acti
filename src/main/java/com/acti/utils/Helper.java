package com.acti.utils;

import com.acti.base.DriverScript;

/*
 * Helper class
 */
public class Helper extends DriverScript 
{
	// This method is used to support the wait whenever needed
	public static void sleep()
	{
		try
		{
			Thread.sleep(3000);
		}
		
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
	}
	

}
