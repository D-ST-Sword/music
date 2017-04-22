package cn.tarena.ht.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysql.jdbc.StringUtils;

import cn.tarena.ht.pojo.User;
import cn.tarena.ht.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 直接跳转至登录界面
	 * @return
	 */
	@RequestMapping("toLogin")
	public String toLogin(HttpSession session,Model model){
		if(session.getAttribute("userId")!=null){
			System.out.println("账号id为:"+session.getAttribute("userId"));
			return "redirect:/home.action";
		}
		return "/sysadmin/login/login";
	}
	
	@RequestMapping("login")
	public String login(String username,String password,Model model){
		String errorInfo = null;
		if(StringUtils.isNullOrEmpty(username) || StringUtils.isNullOrEmpty(password)){
			errorInfo= "用户名或密码不能为空";
			model.addAttribute("errorInfo", errorInfo);
			return "/sysadmin/login/login";
		}
		/**
		 * 1.将用户名和密码封装到tKen中,
		 * 2.将准备好的toKen(令牌),通过subject进行提交
		 * 3.处理提交后的结果,进行正确的专项
		 */
		UsernamePasswordToken token = new UsernamePasswordToken(username,password);
		//生成subject用户
		Subject subject = SecurityUtils.getSubject();
		
		/*
		 * 进行登录,用户名和密码正确.
		 * 如果登录不正确,则会抛出异常
		 */
		try {
			subject.login(token);
			//获取存在于subject中的真实的用户对象
			User user = (User) subject.getPrincipal();
			//subject中可以直接获取session
			subject.getSession().setAttribute("user", user);
			return "redirect:/home.action";
		} catch (AuthenticationException e) {
			//表示用户名或密码不正确
			e.printStackTrace();
			model.addAttribute("errorInfo", "用户名或密码不正确");
			return "/sysadmin/login/login";
		}
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session){
		session.removeAttribute("userId");
		
		return "/sysadmin/login/login";
	}
	
}
