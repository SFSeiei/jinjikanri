package com.jinjikanri.service;

import java.util.List;
import java.util.Map;

import com.jinjikanri.entity.SYST01UserEntity;

public interface UserService {
	Map<String, Object> selectUsers(SYST01UserEntity user, int offset);

	SYST01UserEntity selectUserByUsrCd(Integer usrCd);

	SYST01UserEntity selectUserByUsrId(String usrId);

	/**
	 * 保存用户
	 */
	boolean saveUser(SYST01UserEntity user, List<Integer> charCdList) throws Exception;

	/**
	 * 修改用户
	 */
	boolean updateUser(SYST01UserEntity user, List<Integer> charCdList);

	/**
	 * 修改密码
	 * 
	 * @param usrCd       用户Code
	 * @param password    原密码
	 * @param newPassword 新密码
	 */
	boolean updateUserPassword(Integer usrCd, String password, String newPassword);

	boolean deleteUserBatch(Integer[] usrCds);
}
