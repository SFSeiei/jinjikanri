package com.jinjikanri.service;

import java.sql.Timestamp;
import java.util.Map;

import com.jinjikanri.entity.JIN0006AdmitEntity;

public interface AdmitService {
	Map<String, Object> selectAdmit(JIN0006AdmitEntity admit, int offset);
	Map<String, Object> selectAdmit2(JIN0006AdmitEntity admit, int offset);

	JIN0006AdmitEntity selectAdmitById(Integer dateId);
	JIN0006AdmitEntity selectById(Integer dateId);

	public int updateAdmitById(JIN0006AdmitEntity admit);
	public JIN0006AdmitEntity getDataByIdTime(Integer dateId,Timestamp recSaksZituYmdHms);

}
