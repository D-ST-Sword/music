package cn.tarena.ht.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.tarena.ht.pojo.Module;
import cn.tarena.ht.pojo.Role;
import cn.tarena.ht.service.ModuleService;
import cn.tarena.ht.service.RoleService;

@Controller
@RequestMapping("/sysadmin/role/")
public class RoleController {
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private ModuleService moduleService;
	
	@RequestMapping("list")
	public String findAll(Model model){
		List<Role> roleList = roleService.findAll();
		model.addAttribute("roleList", roleList);
		return "/sysadmin/role/jRoleList";
	}
	
	@RequestMapping("tocreate")
	public String tocreate(){
		return "/sysadmin/role/jRoleCreate";
		
	}
	
	@RequestMapping("save")	
	public String save(Role role){
		roleService.saveRole(role);
		return "redirect:/sysadmin/role/list";
		
	}
	
	@RequestMapping("toview")
	public String toview(String roleId,Model model){
		Role role = roleService.findOne(roleId);
		model.addAttribute("role", role);
		return "/sysadmin/role/jRoleInfo";
	}
	
	@RequestMapping("toupdate")
	public String toupdate(String roleId,Model model){
		Role role = roleService.findOne(roleId);
		model.addAttribute("role", role);
		return "/sysadmin/role/jRoleUpdate";
	}
	
	@RequestMapping("update")
	public String update(Role role){
		roleService.updateRole(role);
		
		return "redirect:/sysadmin/role/list";
	}
	
	@RequestMapping("delete")
	public String delete(@RequestParam("roleId")String[] roleIds){
		
		roleService.deleteRoles(roleIds);
		
		return "redirect:/sysadmin/role/list";
	}
	
	
	@RequestMapping("toModule")
	public String toModule(String roleId,Model model) throws JsonProcessingException{
		/**
		 * 跳转到角色页面
		 */
		List<Module> moduleList = moduleService.findAll();
		List<String> moduleIdList = roleService.findModuleIds(roleId);
		for(Module module:moduleList){
			if(moduleIdList.contains(module.getModuleId())){
				module.setChecked(true);
			}
		}
		ObjectMapper mapper = new ObjectMapper();
		String zTreeJson = mapper.writeValueAsString(moduleList);
		
		model.addAttribute("moduleList", moduleList);
		model.addAttribute("zTreeJson", zTreeJson);
		model.addAttribute("roleId", roleId);
		return "/sysadmin/role/toModule";
	}
	
	@RequestMapping("saveModuleRole")
	public String saveModuleRole(String roleId,@RequestParam("moduleIds")String[] moduleIds){
		roleService.saveModuleRole(roleId,moduleIds);		
		return "redirect:/sysadmin/role/list";
		
	}
}
