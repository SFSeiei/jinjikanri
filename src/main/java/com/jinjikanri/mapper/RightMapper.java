package com.jinjikanri.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.jinjikanri.entity.SYST06RightEntity;

@Mapper
public interface RightMapper {
	List<SYST06RightEntity> selectRights(SYST06RightEntity rightEntity, RowBounds rowBounds);

	List<SYST06RightEntity> selectRightListByCharCd(Integer charCd);

	boolean saveRight(SYST06RightEntity rightEntity);

	boolean updateRight(SYST06RightEntity rightEntity);

	boolean deleteRightBatch(@Param("rightCds") Integer[] rightCds);
}
