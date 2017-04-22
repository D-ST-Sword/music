package cn.tarena.ht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tarena.ht.pojo.Module;

public interface ModuleMapper {
	
	public List<Module> findAll();

	public void updateState(@Param("state")int state, @Param("moduleIds")String[] moduleIds);

	public void deleteModules(String[] moduleId);

	public Module findOne(String moduleId);

	public void saveModule(Module module);

	public void updateModule(Module module);
}
