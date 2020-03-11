package com.jinjikanri.service;

import java.util.List;
import java.util.Map;

import com.jinjikanri.entity.HKN0001ORGEntity;


public interface HKN0001Service {
	public Map<String, Object> getOrganization( HKN0001ORGEntity orga, Integer offset,Integer limit);
	HKN0001ORGEntity deleteOrganizationCd(Integer organizationCd);
	HKN0001ORGEntity selectUserById(Integer organizationCd);
	int updateorganizationCd(HKN0001ORGEntity orga);
	int insertorganizationCd(HKN0001ORGEntity orga);
	int insert1organizationCd(HKN0001ORGEntity orga);
	int update1organizationCd(HKN0001ORGEntity orga);
	public int delDate(Integer dateId);
}
