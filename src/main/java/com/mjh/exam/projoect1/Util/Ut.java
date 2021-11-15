package com.mjh.exam.projoect1.Util;

import java.security.MessageDigest;

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

	public static boolean empty(Object obj) {
		if(obj == null) {
			return true;
		}
		
		if(obj instanceof Integer) {
			return ((int)obj) == 0;
		}
		
		if(obj instanceof Long) {
			return ((long)obj) == 0;
		}
		
		if(obj instanceof String == false) {
			return true;
		}
		
		String str = (String)obj;
		
		return str.trim().length()==0;
	}
	
	// 임시비밀번호 생성
	public static String getTempPassword(int length) {
		int index = 0;
		char[] charArr = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f',
				'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < length; i++) {
			index = (int) (charArr.length * Math.random());
			sb.append(charArr[index]);
		}

		return sb.toString();
	}
	
	// 비밀번호 암호화
	public static String sha256(String base) {
		try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();

        } catch (Exception ex) {
            return "";
        }
    }
}
