package cn.tarena.ht.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.RoleMapper;
import cn.tarena.ht.pojo.Role;
import cn.tarena.ht.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public List<Role> findAll() {		
		return roleMapper.findAll();
	}

	@Override
	public void saveRole(Role role) {
		role.setRoleId(UUID.randomUUID().toString());
		
		role.setCreateTime(new Date());
		
		roleMapper.saveRole(role);
		
	}

	@Override
	public Role findOne(String roleId) {
		
		return roleMapper.findOne(roleId);
	}

	@Override
	public void updateRole(Role role) {
		roleMapper.updateRole(role);
		
	}

	@Override
	public List<String> findRoleList(String userId) {
		
		return roleMapper.findRoleList(userId);
	}

	@Override
	public void deleteRoles(String[] roleIds) {
		roleMapper.deleteRoles(roleIds);
		
	}

	@Override
	public List<String> findModuleIds(String roleId) {
		return roleMapper.findModuleIds(roleId);
	}

	@Override
	public void saveModuleRole(String roleId, String[] moduleIds) {
		roleMapper.deleteModuleByRoleId(roleId);
		
		for(String moduleId:moduleIds){
			roleMapper.saveModuleRole(roleId,moduleId);
			
		}
		
	}
	
	

}
