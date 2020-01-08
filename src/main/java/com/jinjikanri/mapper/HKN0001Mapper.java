package com.jinjikanri.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.jinjikanri.entity.HKN0001ORGEntity;


@Mapper
public interface HKN0001Mapper {
	List<HKN0001ORGEntity> getOrganization(HKN0001ORGEntity orga, RowBounds rowBounds);
	HKN0001ORGEntity deleteOrgazization(@Param("organizationCd")Integer organizationCd);
	HKN0001ORGEntity selectUserById(@Param("organizationCd") Integer organizationCd);
	int updateorganizationCd(HKN0001ORGEntity orga);
	int insertganizationCd(HKN0001ORGEntity orga);
	int insert1ganizationCd(HKN0001ORGEntity orga);
	int update1organizationCd(HKN0001ORGEntity orga);
}
