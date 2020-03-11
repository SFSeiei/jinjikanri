package com.jinjikanri.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.jinjikanri.entity.SYST06CharEntity;

@Mapper
public interface CharMapper {
	List<SYST06CharEntity> selectChars(SYST06CharEntity charEntity, RowBounds rowBounds);

	List<SYST06CharEntity> selectCharListByUsrCd(@Param("usrCd") Integer usrCd);

	boolean saveChar(SYST06CharEntity charEntity);

	boolean updateChar(SYST06CharEntity charEntity);

	boolean deleteCharBatch(@Param("charCds") Integer[] charCds);
}
