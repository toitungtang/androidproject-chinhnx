package com.krazevina.objects;

import java.util.Locale;
import java.util.TimeZone;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.util.Log;

public class Global 
{
	
	/**
	 * VI,EN,KO</br>
	 * not VN and KR
	 */
	public static String lang;
	public static int notify;
	public static int vibrate;
	public static Match match;
	public static int timeZone;
	public static String appId = "53202";
	public static String apiKey = "1337935329105815363";
	
	public static void getLang(Activity c){
		timeZone = TimeZone.getDefault().getOffset(System.currentTimeMillis());
		timeZone = timeZone/(1000*60*60);
		Log.e("Timezone", ""+timeZone);
		SharedPreferences sp = c.getSharedPreferences("lang", Context.MODE_WORLD_WRITEABLE);
		lang = sp.getString("lang", "");
		if(lang.length()<=0){
			if(Locale.getDefault().getDisplayLanguage().equals("Vietnamese"))lang = "VI";
			else if(Locale.getDefault().getDisplayLanguage().equals("Korean"))lang = "KO";
			else lang = "EN";
			Editor e = sp.edit();
			e.putString("lang", lang);
			e.commit();
		}
		Configuration config = c.getBaseContext().getResources().getConfiguration();
		Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        config.locale = locale;
        c.getBaseContext().getResources().updateConfiguration(config, c.getBaseContext().getResources().getDisplayMetrics());
	}
	/**
	 * @param lang
	 * lang = 1: en </br>
	 * lang = 2: vi </br>
	 * lang = 3: ko
	 */
	public static void setLang(Activity c,int lang){
		SharedPreferences sp = c.getSharedPreferences("lang", Context.MODE_WORLD_WRITEABLE);
		Editor e = sp.edit();
		String slang;
		if(lang==2){
			slang = "VI";
			Global.lang = "VI";
			e.putString("lang", "VI");
			e.commit();
		}else if(lang==1){
			slang = "EN";
			Global.lang = "EN";
			e.putString("lang", "EN");
			e.commit();
		}else {
			slang = "KO";
			Global.lang = "KO";
			e.putString("lang", "KO");
			e.commit();
		}
		Configuration config = c.getBaseContext().getResources().getConfiguration();
		Locale locale = new Locale(slang);
        Locale.setDefault(locale);
        config.locale = locale;
        c.getBaseContext().getResources().updateConfiguration(config, c.getBaseContext().getResources().getDisplayMetrics());
	}
}
