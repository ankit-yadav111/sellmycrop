package Mycrop;

import java.util.Base64;
import java.io.UnsupportedEncodingException;

public class Security {
	public static String encode(String value) throws UnsupportedEncodingException {
		Base64.Encoder e= Base64.getEncoder();
		return e.encodeToString(value.getBytes("utf-8"));
	}
	
	public static String decode(String encrypted) throws UnsupportedEncodingException {
		byte[] b=Base64.getDecoder().decode(encrypted);
		
		return new String(b,"utf-8");
	}
}
