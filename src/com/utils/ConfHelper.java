package com.utils;

import java.util.ResourceBundle;

public class ConfHelper {
	private static ResourceBundle rb = ResourceBundle.getBundle("conf");
	
	public static String getString(String key)
	{
		return rb.getString(key);
	}
}
