package cn.tarena.ht.shiro;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.sun.org.apache.xerces.internal.xs.StringList;

import cn.tarena.ht.pojo.Role;
import cn.tarena.ht.pojo.User;
import cn.tarena.ht.service.UserService;

/**
 * 必须继承AuthorizingRealm类
 * @author Tarena
 *
 */
public class AuthRealm extends AuthorizingRealm{
	@Autowired
	private UserService userService;
	
	/**
	 * 权限管理
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
//		List<String> privilegeList = new ArrayList<String>();
//		privilegeList.add("货运管理");
//		privilegeList.add("基础信息");
//		privilegeList.add("系统管理");
		
		
		/**
		 * 1.获取用户信息
		 * 2.根据用户信息查询角色信息,在根据角色信息获取模块信息
		 */
//		1.拿到用户对象
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		List<String> privilegeList = userService.findPrivilegeList(user.getUserId());
		
		
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addStringPermissions(privilegeList);
		
		return info;
	}
	
	/**
	 * 认证管理
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//为shiro安全管理器提供真实的用户信息
		//1.根据用户输入的username查询正确的用户信息
		UsernamePasswordToken loginToken = (UsernamePasswordToken)token;
		String username = loginToken.getUsername();
		
		User user = userService.findUserByUsername(username);
		
		/**
		 * 参数介绍:
		 * 1.pricipal:真实的用户对象
		 * 2.真实密码
		 * 3.当前realm的名称
		 */
		AuthenticationInfo Info = new SimpleAuthenticationInfo(user,user.getPassword(), this.getName())	;	
		return Info;
	}
	
	
}
