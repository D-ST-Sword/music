package cn.tarena.ht.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.tarena.ht.pojo.Module;
import cn.tarena.ht.service.ModuleService;

@Controller
@RequestMapping("/sysadmin/module/")
public class ModuleController {
	
	@Autowired
	private ModuleService moduleService;
	
	@RequestMapping("list")
	public String list(Model model){
		
		List<Module> moduleList = moduleService.findAll();
		
		model.addAttribute("moduleList", moduleList);
		
		return "/sysadmin/module/jModuleList";
	}
	
	@RequestMapping("start")
	//状态启用
	public String toStart(@RequestParam("moduleId") String[] moduleIds){
		int state = 1;
		moduleService.updateState(state,moduleIds);
		
		
		return "redirect:/sysadmin/module/list";
	}
	
	@RequestMapping("stop")
	//状态启用
	public String toStop(@RequestParam("moduleId") String[] moduleIds){
		int state = 0;
		moduleService.updateState(state,moduleIds);
		
		
		return "redirect:/sysadmin/module/list";
	}
	
	@RequestMapping("delete")
	public String toDelete(@RequestParam("moduleId")String[] moduleId){
		
		moduleService.deleteModules(moduleId);
		
		return "redirect:/sysadmin/module/list";
	}
	
	@RequestMapping("toview")
	public String toView (String moduleId,Model model){
		
		//根据id查询数据
		Module module = moduleService.findOne(moduleId);
		
		model.addAttribute("module", module);
		
		return "/sysadmin/module/jModuleInfo";
	}
	
	@RequestMapping("tocreate")
	public String tocreate(Model model){
		//查询获取所有的模块
		List<Module> parentList = moduleService.findAll();
		
		model.addAttribute("parentList", parentList);
		return "sysadmin/module/jModuleCreate";
	}
	
	@RequestMapping("save")
	public String save(Module module){
		moduleService.saveModule(module);
		
		return "redirect:/sysadmin/module/list";
		
	}
	
	@RequestMapping("toupdate")
	public String toUpdate(String moduleId,Model model){
		Module module = moduleService.findOne(moduleId);
		List<Module> parentList = moduleService.findAll();
		model.addAttribute("module", module);
		model.addAttribute("parentList", parentList);
		return "sysadmin/module/jModuleUpdate";
	}
	
	@RequestMapping("update")
	public String update(Module module){
		moduleService.updateModule(module);
		return "redirect:/sysadmin/module/list";
	}
	
}
