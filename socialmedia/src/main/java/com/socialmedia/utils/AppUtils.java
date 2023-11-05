package com.socialmedia.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Pattern;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.multipart.MultipartFile;

public class AppUtils {
	
	public static String getRandomUUID() {
		UUID uuid=UUID.randomUUID();
		return uuid.toString();
	}
	public static boolean decodeOassword(String rawPassword, String hashedPasword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(rawPassword,hashedPasword);
    }
	
	 public static String encodePassword(String password) {
		 BCryptPasswordEncoder brcypt=new BCryptPasswordEncoder();
		 return brcypt.encode(password);
	 }
	  public static  String formatDate(Date date) {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        return dateFormat.format(date);
	    }

		public static boolean validateRegex(String regex, String value) {
			if (value == null || value.isEmpty()) {
				return false;
			}
			Pattern pat = Pattern.compile(regex);

			return pat.matcher(value).matches();
		}
		
		public static String fileToBase64(File file ) throws IOException {
			FileInputStream fileInputStream=new FileInputStream(file);
			byte [] imageBytes=new byte[(int)file.length()];
			fileInputStream.read(imageBytes);
			fileInputStream.close();
			String base64=Base64.getEncoder().encodeToString(imageBytes);					
			return base64;
		}
		public static String MutiPartToBase64(MultipartFile file ) throws IOException {
			byte [] imageBytes=file.getBytes();
			String base64=Base64.getEncoder().encodeToString(imageBytes);					
			return base64;
		}
	
}
