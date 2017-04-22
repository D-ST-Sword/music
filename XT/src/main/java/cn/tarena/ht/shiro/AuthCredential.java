package cn.tarena.ht.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

import cn.tarena.ht.tool.Md5HashUtils;

//表示密码校验
public class AuthCredential extends  SimpleCredentialsMatcher{
	/**
	 * token代表用户传入的令牌
	 * 自定义realm传入的info对象
	 */
	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		//将用户输入的明文转化为密文
		UsernamePasswordToken loginToken = (UsernamePasswordToken) token;
		char[] password = loginToken.getPassword();
		System.out.println("原始密码:"+loginToken.getPassword());
		//加密之后的password
		String encryptPassword = Md5HashUtils.Encrypt(String.valueOf(password));
		System.out.println("加密后密码:"+encryptPassword);
		loginToken.setPassword(encryptPassword.toCharArray());
		
		//将数据传入安全管理器中
		return super.doCredentialsMatch(token, info);
	}
	
}
