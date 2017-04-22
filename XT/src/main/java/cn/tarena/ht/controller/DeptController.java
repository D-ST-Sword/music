package cn.tarena.ht.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.tarena.ht.pojo.Dept;
import cn.tarena.ht.service.DeptService;

@Controller
@RequestMapping("/sysadmin/dept/")
public class DeptController {

	@Autowired
	private DeptService deptService;
	
	//查询部门信息
	@RequestMapping("list")
	public String findAll(Model model){
		List<Dept> list = deptService.findAll();
		
		model.addAttribute("deptList", list);
		
		return "sysadmin/dept/jDeptList";	
	}
	
	//部门状态的修改
	@RequestMapping("stop")
	public String toStop(@RequestParam("deptId")String[] deptId){
		int state = 0;
		deptService.updateState(deptId,state);
		
		//重定向至部门列表页面
		return "redirect:/sysadmin/dept/list";		
	}
	
	//部门状态的修改
	@RequestMapping("start")
	public String toStart(String[] deptId){
		int state = 1;
		deptService.updateState(deptId, state);
		
		//重定向至部门列表页面
		return "redirect:/sysadmin/dept/list";
	}
	
	//部门的删除
	@RequestMapping("delete")
	public String todelete(String[] deptId){
		deptService.deleteDept(deptId);
		
		//重定向至部门列表页面
		return "redirect:/sysadmin/dept/list";
	}
	
	//部门的添加1
	@RequestMapping("tocreate")
	public String tocreate(Model model){
		List<Dept> Pdept = deptService.findAllPId();
		model.addAttribute("Pdept", Pdept);
		
		
		return "sysadmin/dept/jDeptCreate";
	}
	
	//部门的添加2save
	@RequestMapping("save")
	public String tosave(Dept dept){
		deptService.saveDept(dept);
		return "redirect:/sysadmin/dept/list";
	}
	
	//查看部门
	@RequestMapping("toview")
	public String toview(String deptId,Model model){
		Dept deptInfo = deptService.findOne(deptId);
		model.addAttribute("deptInfo", deptInfo);
		
		return "sysadmin/dept/jDeptInfo";
		
	}
	
	//更新部门
	@RequestMapping("toupdate")
	public String toupdateJSP(String deptId,Model model){
		//获取该id对应的部门信息
		Dept deptInfo = deptService.findOne(deptId);
		model.addAttribute("deptInfo", deptInfo);
		//获取除该id之外的所有部门对象
		List<Dept> Pdept = deptService.findPId(deptId);
		model.addAttribute("Pdept", Pdept);
		return "sysadmin/dept/jDeptUpdate";
	}
	
	//更新部门2
	@RequestMapping("update")
	public String toupdate(Dept dept){
		deptService.updateDept(dept);
		
		return "redirect:/sysadmin/dept/list";
	}
}
