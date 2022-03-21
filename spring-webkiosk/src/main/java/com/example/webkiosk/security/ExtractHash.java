package com.example.webkiosk.security;

import java.security.MessageDigest;

public class ExtractHash {
	public String ExtractSHA256(String password) {
		String sha256 = "";
		try {

			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(password.getBytes("UTF-8"));
			StringBuffer hexString = new StringBuffer();

			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}

			sha256 = hexString.toString();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return sha256;
	}
}
