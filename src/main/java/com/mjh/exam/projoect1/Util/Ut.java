package com.mjh.exam.projoect1.Util;

public class Ut {

	public static String f(String format, Object ...args) {
		
		return String.format(format, args);
	}
	
	public static String jsHistoryBack(String msg) {
		if(msg == null) {
			msg = "";
		}
		
		String Script = "<script>"
				+ "const msg = '%s'.trim();"
				+ "if(msg.length > 0){alert(msg);}"
				+ "history.back();"
				+ "</script>";

		
		return Ut.f(Script,msg);
	}

	public static String jsHistoryReplace(String msg,String uri) {
		if(msg == null) {
			msg = "";
		}
		
		if(uri == null) {
			uri = "";
		}
		
		String Script = "<script>"
				+ "const msg = '%s'.trim();"
				+ "if(msg.length > 0){alert(msg);}"
				+ "location.replace('%s');"
				+ "</script>";

		
		return Ut.f(Script,msg,uri);
	}


}
