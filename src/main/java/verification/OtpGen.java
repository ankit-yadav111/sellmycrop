package verification;

import java.security.SecureRandom;

public class OtpGen {
	public String gen() {
	StringBuilder otp=new StringBuilder();
	SecureRandom s= new SecureRandom();
	
	for(int i=0;i<6;i++) {
		int num =s.nextInt(9);
		otp.append(num);
	}
	
	return otp.toString();
}}