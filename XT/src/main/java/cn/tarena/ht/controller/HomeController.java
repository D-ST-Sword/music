package cn.tarena.ht.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tarena.ht.pojo.User;
import cn.tarena.ht.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	//转向欢迎页面
	@RequestMapping("/home")
	public String home(){
		return "/home/fmain";
	}
	
	//转向tilte标题栏页面
	@RequestMapping("/title")
	public String title(HttpSession session,Model model){
		User user = (User) session.getAttribute("user");
		model.addAttribute("user", user);
		
		return "/home/title";
	}
	
//	//转向home的左侧页面
//	@RequestMapping("/homeLeft")
//	public String homeLeft(){
//		return "/home/left";
//	}
//	
//	//转向home的操作页面
//	@RequestMapping("/homeMain")
//	public String homeMain(){
//		return "/home/main";
//	}
	
	//分析
	
	
	@RequestMapping("/{module}/Left")
	public String toLeft(@PathVariable(value = "module") String module){
		return "/"+module+"/left";
	}
	
	@RequestMapping("/{module}/Main")
	public String toMain(@PathVariable String module){
		return "/"+module+"/main";
	}
	
	
}
