package cn.tarena.ht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tarena.ht.pojo.Dept;

public interface DeptMapper {
	//查询全部部门列表数据
	public List<Dept> findAll();
	
	//@Param注解
	public void updateState(@Param("deptId")String[] deptId,@Param("state")int state);

	public void deleteDept(@Param("deptId")String[] deptId);

	public List<Dept> findAllPId();

	public void saveDept(Dept dept);

	public Dept findOne(String deptId);

	public List<Dept> findPId(String deptId);

	public void updateDept(Dept dept);

	
}
