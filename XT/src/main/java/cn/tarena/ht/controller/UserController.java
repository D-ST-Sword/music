package cn.tarena.ht.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.tarena.ht.pojo.Dept;
import cn.tarena.ht.pojo.Role;
import cn.tarena.ht.pojo.User;
import cn.tarena.ht.pojo.UserInfo;
import cn.tarena.ht.service.DeptService;
import cn.tarena.ht.service.RoleService;
import cn.tarena.ht.service.UserService;
import cn.tarena.ht.tool.Md5HashUtils;

@Controller
@RequestMapping("/sysadmin/user/")
public class UserController extends BaseController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private DeptService deptService;
	@Autowired
	private RoleService roleService;
	
	
	
	@RequestMapping("list")
	public String findAll(Model model){
		List<User> userList = userService.findAll();
		model.addAttribute("userList", userList);
		return "/sysadmin/user/jUserList";
	}
	
	@RequestMapping("stop")
	public String stop(@RequestParam("userId")String[] userIds){
		int state = 0;
		userService.updateState(userIds,state);
		
		return "redirect:/sysadmin/user/list";
	}
	
	@RequestMapping("start")
	public String start(@RequestParam("userId")String[] userIds){
		int state = 1;
		userService.updateState(userIds,state);
		
		return "redirect:/sysadmin/user/list";
	}
	
	//删除批量用户
	@RequestMapping("delete")
	public String delete(@RequestParam("userId")String[] userIds){
		userService.deleteUsers(userIds);
		
		return "redirect:/sysadmin/user/list";
	}
	
	//新增用户
	@RequestMapping("tocreate")
	public String create(Model model){
		List<Dept> deptList = deptService.findAll();
		List<UserInfo> managerList = userService.findAllManager();
		
		model.addAttribute("deptList",deptList);
		model.addAttribute("managerList", managerList);
		return "/sysadmin/user/jUserCreate";
	}
	//保存用户
	@RequestMapping("save")
	public String save(User user){
		String password = user.getPassword();
		user.setPassword(Md5HashUtils.Encrypt(user.getPassword()));
		userService.saveUser(user);
		return "redirect:/sysadmin/user/list";
	}
	
	//查看用户
	@RequestMapping("toview")
	public String view(String userId,Model model){
		// 查询User对象
		User user = userService.findOne(userId);
		
		model.addAttribute("user", user);
		return "/sysadmin/user/jUserInfo";
	}
	
	//更新用户1
	@RequestMapping("toupdate")
	public String toupdate(String userId,Model model){
		// 查询User对象
		User user = userService.findOne(userId);
		
		//查询所有部门
		List<Dept> deptList = deptService.findAll();
		//查询不含有自身名称的上级领导
		List<UserInfo> managerList = userService.findMananger(userId);
		
		model.addAttribute("user", user);
		model.addAttribute("deptList", deptList);
		model.addAttribute("managerList", managerList);
		
		return "/sysadmin/user/jUserUpdate";
	}
	
	//更新用户2
	@RequestMapping("update")
	public String update(User user){
		userService.updateUser(user);
		
		return "redirect:/sysadmin/user/list";
	}
	
	//跳转至RoleController
	@RequestMapping("toRole")
	public String toRole(String userId,Model model) throws JsonProcessingException{
		//查询所有的角色信息
		List<Role> roleList = roleService.findAll();
		
		//为了实现数据回显根据UserId查询对应Id所指定的角色Id集合
		List<String> userRoleIdList = roleService.findRoleList(userId);
		
		//判断roleId是否一致
		for(Role role:roleList){
			if(userRoleIdList.contains(role.getId())){
				role.setChecked(true);
			}
		}
		
		//将对象转化为JSON格式
		ObjectMapper objectMapper = new ObjectMapper();
		String zTreeJson = objectMapper.writeValueAsString(roleList);
		
		
		model.addAttribute("zTreeJson",zTreeJson);
		model.addAttribute("userId", userId);
		return "/sysadmin/user/toRole";
	}
	
	//接受用户信息的保存
	@RequestMapping("saveUserRole")
	public String saveUserRole(String userId,String[] roleIds){
		
		userService.insertUserRole(userId,roleIds);
		
		return "redirect:/sysadmin/user/list";
		
	}
	
	//新增用户中检查是否有该昵称
	@RequestMapping("check")
	public String check(String username,HttpServletResponse response) throws IOException{
		if(userService.checkUsername(username)){
			response.getWriter().print("<p>'您输入的用户已存在'</p>");
			return "/sysadmin/userjUserCreate";
		}
			return "";
	}
	
}
