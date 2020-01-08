package com.jinjikanri.service;

import java.util.Map;

import com.jinjikanri.entity.SYST06RightEntity;

public interface RightService {
	Map<String, Object> selectRights(SYST06RightEntity rightEntity, int offset);

	boolean saveRight(SYST06RightEntity rightEntity);

	boolean updateRight(SYST06RightEntity rightEntity);

	boolean deleteRightBatch(Integer[] rightCds);

}
