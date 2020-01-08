package com.jinjikanri.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jinjikanri.entity.SYST06CharEntity;
import com.jinjikanri.mapper.CharMapper;
import com.jinjikanri.mapper.RightMapper;
import com.jinjikanri.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	// 每一个Mapper都要加上@Autowired注释，不然会出现空指针异常。
	@Autowired
	private CharMapper charMapper;
	@Autowired
	private RightMapper rightMapper;

	@Override
	public Map<String, Object> selectCharAndRightListByUsrCd(Integer usrCd) {
		Map<String, Object> charAndRightMap = new HashMap<>();
		List<SYST06CharEntity> charList = charMapper.selectCharListByUsrCd(usrCd);
		Map<String, Object> RightListsMap = new HashMap<>();

		for (SYST06CharEntity oneChar : charList) {
			RightListsMap.put("char" + oneChar.getCharCd() + "rights",
					rightMapper.selectRightListByCharCd(oneChar.getCharCd()));
		}
		charAndRightMap.put("char", charList);
		charAndRightMap.put("rights", RightListsMap);
		return charAndRightMap;
	}
}
