package cn.tarena.ht.service.impl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.DeptMapper;
import cn.tarena.ht.pojo.Dept;
import cn.tarena.ht.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	private DeptMapper mapper;
	
	@Override
	public List<Dept> findAll() {
		
		return mapper.findAll();
	}

	@Override
	public void updateState(String deptId[], int state) {
		mapper.updateState(deptId,state);
	}

	@Override
	public void deleteDept(String[] deptId) {
		mapper.deleteDept(deptId);
		
	}

	@Override
	public List<Dept> findAllPId() {
		return mapper.findAllPId();
	}

	@Override
	public void saveDept(Dept dept) {
		Date createTime = new Date();
		dept.setCreateTime(createTime);
		mapper.saveDept(dept);
	}

	@Override
	public Dept findOne(String deptId) {
		return mapper.findOne(deptId);
	}

	@Override
	public List<Dept> findPId(String deptId) {
		
		return mapper.findPId(deptId);
	}

	@Override
	public void updateDept(Dept dept) {
		Date updateTime = new Date();
		dept.setUpdateTime(updateTime);
		mapper.updateDept(dept);
		
	}


	
	
}
