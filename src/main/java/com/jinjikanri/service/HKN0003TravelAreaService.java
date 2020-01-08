package com.jinjikanri.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;


import com.jinjikanri.entity.HKN0003TravelAreaEntity;

public interface HKN0003TravelAreaService {
	public Map<String, Object> getTravelArea(HKN0003TravelAreaEntity travelArea,Integer offset,Integer limit);
	public HKN0003TravelAreaEntity getTravelAreaById(Integer travelAreaId);
	public List<HKN0003TravelAreaEntity> selectTravelAreas(List<Integer> travelAreaIdList);
	public HKN0003TravelAreaEntity getTravelAreaByIdAndUpdateTime(Integer travelAreaId,Timestamp recKosnZituYmdHms);
	public String deleteTravelAreaById(Integer[] travelAreaIdArray, Timestamp[] updateTimeArray);
	public String updateTravelAreaById(HKN0003TravelAreaEntity travelArea);
	public int addTravelArea(HKN0003TravelAreaEntity travelArea);
}
