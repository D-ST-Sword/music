package cn.tarena.ht.tool;

import org.apache.shiro.crypto.hash.Md5Hash;

public class MD5Hash {
	public static void main(String[] args) {
		String password = "123456";
		
		/*
		 * 1.明文
		 * 2.盐
		 * 3.hash次数
		 */
		Md5Hash md5Hash = new Md5Hash(password, "admin",3);
		System.out.println(md5Hash);
		
	}
}
