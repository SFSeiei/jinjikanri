package com.jinjikanri.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.jinjikanri.entity.SYST01UserEntity;

@Mapper
public interface UserMapper {
	List<SYST01UserEntity> selectUsers(SYST01UserEntity user, RowBounds rowBounds);

	SYST01UserEntity selectUserByUsrCd(@Param("usrCd") Integer usrCd);

	SYST01UserEntity selectUserByUsrId(@Param("usrId") String usrId);

	boolean updateUser(SYST01UserEntity user);

	boolean saveUser(SYST01UserEntity user);
	
	boolean deleteUserBatch(@Param("usrCds") Integer[] usrCds);
}
