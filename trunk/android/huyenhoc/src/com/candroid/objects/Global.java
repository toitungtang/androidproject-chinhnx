package com.candroid.objects;

import android.graphics.Typeface;

public class Global {
	public static Typeface face;
	public static String name;
	
	
	@Override
	protected void finalize() {
		try {
			face = null;
			super.finalize();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
