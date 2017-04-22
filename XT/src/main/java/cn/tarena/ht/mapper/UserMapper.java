package cn.tarena.ht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.tarena.ht.pojo.User;

public interface UserMapper {
	
	public List<User> findAll();

	public void updateState(@Param("userIds")String[] userIds,@Param("state")int state);
	
	/**
	 * 删除指定id的用户表
	 * @param userIds
	 */
	public void deleteUsers(String[] userIds);

	public void saveUser(User user);
	public User findOne(String userId);
	
	
	@Insert("insert into role_user_p values ( #{roleId},#{userId} )")
	public void saveUserRole(@Param("userId")String userId, @Param("roleId")String roleId);

	public void updateUser(User user);
	
	@Delete("delete from role_user_p where user_id = #{userId}")
	public void deleteUserRole(String userId);
	
	@Select("select * from user_p where username = #{username} and password = #{password}")
	public User checku_p(@Param("username")String username,@Param("password")String password);
	@Select("select * from user_p where username = #{username}")
	public User checkUsername(String username);
	
	public User findUserByUsername(String username);

	public List<String> findPrivilegeList(String userId);


}
