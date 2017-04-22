package cn.tarena.ht.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.ModuleMapper;
import cn.tarena.ht.pojo.Module;
import cn.tarena.ht.service.ModuleService;

@Service
public class ModuleServiceImpl implements ModuleService {
	
	@Autowired
	private ModuleMapper moduleMapper;
	
	
	@Override
	public List<Module> findAll() {
		return moduleMapper.findAll();
	}




	@Override
	public void updateState(int state, String[] moduleIds) {
		moduleMapper.updateState(state,moduleIds);
		
	}




	@Override
	public void deleteModules(String[] moduleId) {
		moduleMapper.deleteModules(moduleId);
		
	}




	@Override
	public Module findOne(String moduleId) {
		return moduleMapper.findOne(moduleId);
	}




	@Override
	public void saveModule(Module module) {
		module.setModuleId(UUID.randomUUID().toString());
		module.setCreateTime(new Date());
		module.setState(1);
		moduleMapper.saveModule(module);
		
	}




	@Override
	public void updateModule(Module module) {
		module.setUpdateTime(new Date());
		moduleMapper.updateModule(module);
		
	}

}
