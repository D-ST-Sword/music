package cn.tarena.ht.service;

import java.util.List;

import cn.tarena.ht.pojo.Module;

public interface ModuleService {
	public List<Module> findAll();

	public void updateState(int state, String[] moduleIds);

	public void deleteModules(String[] moduleId);

	public Module findOne(String moduleId);
	
	public void saveModule(Module module);

	public void updateModule(Module module);
}
