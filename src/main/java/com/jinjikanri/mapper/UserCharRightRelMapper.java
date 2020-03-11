package com.jinjikanri.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jinjikanri.entity.SYST06UserCharRightRelEntity;

@Mapper
public interface UserCharRightRelMapper {
	List<SYST06UserCharRightRelEntity> selectRelByEntity(SYST06UserCharRightRelEntity rel);

	boolean saveRel(SYST06UserCharRightRelEntity Rel);

	boolean removeRelByRelCd(@Param("relCd") Integer relCd);

	boolean removeRelByUsrCd(@Param("usrCd") Integer usrCd);

	boolean removeRelByCharCd(@Param("charCd") Integer charCd);

	boolean removeRelByRightCd(@Param("rightCd") Integer rightCd);
}
