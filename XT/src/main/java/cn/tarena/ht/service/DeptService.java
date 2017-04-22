package cn.tarena.ht.service;

import java.util.List;

import cn.tarena.ht.pojo.Dept;

public interface DeptService {
	public List<Dept> findAll();

	public void updateState(String[] deptId, int state);


	public void deleteDept(String[] deptId);

	public List<Dept> findAllPId();

	public void saveDept(Dept dept);

	public Dept findOne(String deptId);

	public List<Dept> findPId(String deptId);

	public void updateDept(Dept dept);
	
}
