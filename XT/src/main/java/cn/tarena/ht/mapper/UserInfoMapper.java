package cn.tarena.ht.mapper;

import java.util.List;

import cn.tarena.ht.pojo.UserInfo;

public interface UserInfoMapper {
	
	/**
	 * 删除指定id的数据
	 * @param userInfoIds
	 */
	void deleteUserInfos(String[] userInfoIds);

	List<UserInfo> findAllManager();

	void saveUserInfo(UserInfo userInfo);

	List<UserInfo> findManager(String userId);

	void updateUserInfo(UserInfo userInfo);

}
