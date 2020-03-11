package com.jinjikanri.service;

import java.util.List;
import java.util.Map;

import com.jinjikanri.entity.SYST06CharEntity;

public interface CharService {
	Map<String, Object> selectChars(SYST06CharEntity charEntity, int offset);

	boolean saveChar(SYST06CharEntity charEntity, List<Integer> rightCdList);

	String updateChar(String updateTime, SYST06CharEntity charEntity, List<Integer> rightCdList);

	boolean deleteCharBatch(Integer[] charCds);
}
