package cn.tarena.ht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.tarena.ht.pojo.Role;

public interface RoleMapper {
	
	/**
	 * 简单的sql语句,则可以使用注解实现RoleMapper.xml文件中对应id的功能
	 * @return
	 */
	@Select(value = "select * from role_p order by order_no")
	public List<Role> findAll();

	public void saveRole(Role role);
	
	/**
	 * 查找指定的Id用户信息
	 * @param roleId
	 * @return
	 */
	@Select("select * from role_p where role_id = #{roleId}")
	public Role findOne(String roleId);

	public void updateRole(Role role);
	
	@Select("select role_id from role_user_p where user_id = #{userId}")
	public List<String> findRoleList(String userId);

	public void deleteRoles(String[] roleIds);
	
	@Select("select module_id from role_module_p where role_id = #{roleId}")
	public List<String> findModuleIds(String roleId);

	@Delete("delete from role_module_p where role_id = #{roleId}")
	public void deleteModuleByRoleId(String roleId);

	@Insert("insert into role_module_p values(#{moduleId},#{roleId}) ")
	public void saveModuleRole(@Param("roleId")String roleId,@Param("moduleId")String moduleId);
}
