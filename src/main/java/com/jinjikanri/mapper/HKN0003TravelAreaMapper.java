package com.jinjikanri.mapper;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import com.jinjikanri.entity.HKN0003TravelAreaEntity;

@Repository
@Mapper
public interface HKN0003TravelAreaMapper {
	List<HKN0003TravelAreaEntity> getTravelArea(HKN0003TravelAreaEntity travelArea,RowBounds rowBounds);
	HKN0003TravelAreaEntity getTravelAreaById(Integer travelAreaId);
	List<HKN0003TravelAreaEntity> selectTravelAreas(List<Integer> travelAreaIdList);
	HKN0003TravelAreaEntity getTravelAreaByIdAndUpdateTime(Integer travelAreaId,Timestamp recKosnZituYmdHms);
	int deleteTravelAreaById(List<Integer> travelAreaIdList);
	int updateTravelAreaById(HKN0003TravelAreaEntity travelArea);
	int addTravelArea(HKN0003TravelAreaEntity travelArea);
}
