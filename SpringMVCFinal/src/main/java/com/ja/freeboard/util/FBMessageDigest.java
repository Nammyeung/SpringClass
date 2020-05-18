package com.ja.freeboard.util;

import java.security.MessageDigest;

public class FBMessageDigest {
	
	public static String digest(String value) {
		String hashCode = null;
		
		//비밀번호 해싱....
		try {
			
			StringBuilder sb = new StringBuilder();
			
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-1"); 
			
			messageDigest.reset();
			messageDigest.update((value+"@!FB").getBytes());
			
			byte[] chars = messageDigest.digest();
			
			for(int i = 0 ; i < chars.length ; i++) {
				String tmp = Integer.toHexString(chars[i] & 0xff);
				if(tmp.length() == 1) {
					sb.append("0");
				}
				sb.append(tmp);
			}

			hashCode = sb.toString();
			
		}catch(Exception e) {
			e.printStackTrace();
		}		
		
		return hashCode;
	}
}
