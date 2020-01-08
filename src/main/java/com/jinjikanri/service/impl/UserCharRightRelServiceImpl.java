package com.jinjikanri.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jinjikanri.entity.SYST06UserCharRightRelEntity;
import com.jinjikanri.mapper.UserCharRightRelMapper;
import com.jinjikanri.service.UserCharRightRelService;

@Service
public class UserCharRightRelServiceImpl implements UserCharRightRelService {

	@Autowired
	private UserCharRightRelMapper userCharRightRelMapper;

	@Override
	public boolean saveOrUpdateUCRel(Integer usrCd, List<Integer> charCdList) {
		SYST06UserCharRightRelEntity searchRel = new SYST06UserCharRightRelEntity();
		searchRel.setUsrCd(usrCd);
		List<SYST06UserCharRightRelEntity> dbRelList = userCharRightRelMapper.selectRelByEntity(searchRel);
		for (SYST06UserCharRightRelEntity oneRel : dbRelList) {
			if (oneRel.getCharCd() != null) {
				if (charCdList.contains(oneRel.getCharCd())) {
					charCdList.remove(oneRel.getCharCd());
				} else {
					userCharRightRelMapper.removeRelByRelCd(oneRel.getUserCharRightCd());
				}
			}
		}
		if (charCdList == null || charCdList.size() == 0) {
			return true;
		}
		// 新增用户与角色关系
		for (Integer charCd : charCdList) {
			SYST06UserCharRightRelEntity userCharRel = new SYST06UserCharRightRelEntity();
			userCharRel.setUsrCd(usrCd);
			userCharRel.setCharCd(charCd);
			userCharRightRelMapper.saveRel(userCharRel);
		}
		return true;
	}

	@Override
	public boolean saveOrUpdateCRRel(Integer charCd, List<Integer> rightCdList) {
		SYST06UserCharRightRelEntity searchRel = new SYST06UserCharRightRelEntity();
		searchRel.setCharCd(charCd);
		List<SYST06UserCharRightRelEntity> dbRelList = userCharRightRelMapper.selectRelByEntity(searchRel);
		for (SYST06UserCharRightRelEntity oneRel : dbRelList) {
			if (oneRel.getRightCd() != null) {
				if (rightCdList.contains(oneRel.getRightCd())) {
					rightCdList.remove(oneRel.getRightCd());
				} else {
					userCharRightRelMapper.removeRelByRelCd(oneRel.getUserCharRightCd());
				}
			}
		}
		if (rightCdList == null || rightCdList.size() == 0) {
			return true;
		}
		// 新增角色与权限关系
		for (Integer rightCd : rightCdList) {
			SYST06UserCharRightRelEntity charRightRel = new SYST06UserCharRightRelEntity();
			charRightRel.setCharCd(charCd);
			charRightRel.setRightCd(rightCd);
			userCharRightRelMapper.saveRel(charRightRel);
		}
		return true;
	}
}
