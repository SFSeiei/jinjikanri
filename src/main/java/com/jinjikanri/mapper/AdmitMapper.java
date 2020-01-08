package com.jinjikanri.mapper;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import com.jinjikanri.entity.JIN0006AdmitEntity;

@Mapper
public interface AdmitMapper {
	List<JIN0006AdmitEntity> selectAdmit(JIN0006AdmitEntity admit, RowBounds rowBounds);
	List<JIN0006AdmitEntity> selectAdmit2(JIN0006AdmitEntity admit, RowBounds rowBounds);
	public Map<String, Object> getAdmitList(JIN0006AdmitEntity admit,int offset);
	JIN0006AdmitEntity selectAdmitById(Integer dateId);
	JIN0006AdmitEntity selectById(Integer dateId);
	JIN0006AdmitEntity getDataByIdTime(Integer dateId,Timestamp recSaksZituYmdHms);
	
	int updateAdmitById(JIN0006AdmitEntity admit);
	
	
}
