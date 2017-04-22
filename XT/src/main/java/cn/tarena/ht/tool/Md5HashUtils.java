package cn.tarena.ht.tool;

import org.apache.shiro.crypto.hash.Md5Hash;

public class Md5HashUtils {
	public static String Encrypt(String password){
		return new Md5Hash(password,"admin",3).toString();
	}
}
