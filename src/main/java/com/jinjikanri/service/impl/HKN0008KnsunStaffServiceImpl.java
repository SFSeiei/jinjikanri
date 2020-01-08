package com.jinjikanri.service.impl;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jinjikanri.common.constant.ItemConstant;
import com.jinjikanri.entity.HKN0008KnsunStaffEntity;
import com.jinjikanri.mapper.HKN0008KnsunStaffMapper;
import com.jinjikanri.service.HKN0008KnsunStaffService;

@Service
public class HKN0008KnsunStaffServiceImpl implements HKN0008KnsunStaffService {
	@Autowired
	private HKN0008KnsunStaffMapper hkn0008KnsunStaffMapper;
	/**
	 * クエリの方法
	 */
	@Override
	public Map<String, Object> selectKnsunStaffs(HKN0008KnsunStaffEntity hkn0008KnsunStaffEntity, int offset) {
		Map<String, Object> result = new HashMap<String, Object>();
		RowBounds rowBounds = new RowBounds(offset, ItemConstant.PAGE_LIMIT);
		Page<Object> page = PageHelper.startPage(offset, ItemConstant.PAGE_LIMIT);
		List<HKN0008KnsunStaffEntity> hkn0008KnsunStaffEntities = this.hkn0008KnsunStaffMapper.hkn0008KnsunStaffEntities(hkn0008KnsunStaffEntity, rowBounds);
		long total = page.getTotal();
		int pages = page.getPages();
		result.put("hkn0008KnsunStaffEntities", hkn0008KnsunStaffEntities);
		result.put("total", total);
		result.put("pages", pages);
		return result;
	}
	/**
	 * IDにより健診日情報を取得する
	 */
	@Override
	public HKN0008KnsunStaffEntity getKnsunStaffById(Integer knsunStaffId) {
		return hkn0008KnsunStaffMapper.getKnsunStaffById(knsunStaffId);
	}
	/**
	 * 削除の方法
	 */
	@Override
	public int deleteKnsunStaffById(Integer id) {
		return hkn0008KnsunStaffMapper.deleteKnsunStaffById(id);
	}
	/**
	 * 変更の方法
	 */
	@Override
	public int updateknsunStaffById(HKN0008KnsunStaffEntity knsunStaff) {
		List<HKN0008KnsunStaffEntity> knsuntaffEntities = this.hkn0008KnsunStaffMapper.dataValid(knsunStaff);
		if (knsuntaffEntities.size() > 0) {
			return 2;
		}
		return hkn0008KnsunStaffMapper.updateknsunStaffById(knsunStaff);
	}
	/**
	 *  排他
	 */
	@Override
	public HKN0008KnsunStaffEntity getKnsunStaffByIdAndUpdateTime(Integer knsunStaffId, Timestamp recKosnZituYmdHms) {
		return hkn0008KnsunStaffMapper.getKnsunStaffByIdAndUpdateTime(knsunStaffId, recKosnZituYmdHms);
	}
	/**
	 * 新規追加の方法
	 */
	@Override
	public int insertKnsunStaff(HKN0008KnsunStaffEntity knsunStaff) {
		List<HKN0008KnsunStaffEntity> knsuntaffEntities = this.hkn0008KnsunStaffMapper.dataValid(knsunStaff);
		if (knsuntaffEntities.size() > 0) {
			return 2;
		}
		return hkn0008KnsunStaffMapper.insertKnsunStaff(knsunStaff);
	}

}
