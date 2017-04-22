package cn.tarena.ht.service;

import java.util.List;

import cn.tarena.ht.pojo.Role;

public interface RoleService {
	public List<Role> findAll();

	public void saveRole(Role role);

	public Role findOne(String roleId);

	public void updateRole(Role role);

	public List<String> findRoleList(String userId);

	public void deleteRoles(String[] roleIds);

	public List<String> findModuleIds(String roleId);

	public void saveModuleRole(String roleId, String[] moduleIds);
}
