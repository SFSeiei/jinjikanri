package com.jinjikanri.service.impl;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jinjikanri.common.constant.ItemConstant;
import com.jinjikanri.entity.JIN0002StaffEntity;
import com.jinjikanri.mapper.StaffMapper;
import com.jinjikanri.service.StaffService;

/**
 * 
 * @author 陳俊霖
 */
@Service
public class StaffServiceImpl implements StaffService {

	@Autowired
	private StaffMapper staffMapper;

	/**
	 * 人員基本情報取得。
	 * @param staffCd 従業員コード
     */
	@Override
	public JIN0002StaffEntity selectstaff(Integer staffCd) {
		return staffMapper.selectstaff(staffCd);
	}

	/**
	 * 人員基本情報排他クエリーする。
	 * @param staffCd 従業員コード
	 * @param reckosnzituymdhms レコード更新実年月日時分秒
	 */
	@Override
	public boolean selectstafftime(
			@RequestParam("staffCd") Integer staffCd,
			@RequestParam("Timestamp") Timestamp reckosnzituymdhms) {
		JIN0002StaffEntity staffEntity =
				staffMapper.selectstafftime(staffCd, reckosnzituymdhms);
		if (staffEntity != null) {
			return true;
		}
		return false;
	}

	/**
	 * 人員基本情報削除する。
	 * @param staffCd 従業員コード
     */
	@Override
	public int delectstaff(Integer staffCd) {
		return staffMapper.delestaff(staffCd);
	}

	/**
	 * 人員基本情報追加する。
	 * @param staffEntity 人員基本情報
     */
	@Override
	public int insertStaff(
			JIN0002StaffEntity staffEntity) {
		return staffMapper.insertStaff(staffEntity);
	}

	/**
	 * 人員基本情報变更する。
	 * @param staffEntity 人員基本情報
     */
	@Override
	public int updatestaff(
			@RequestParam("staffEntity") JIN0002StaffEntity staffEntity) {
		staffMapper.updatestaff(staffEntity);
		return 0;
	}

	/**
	 * 人員基本情報取得改ページ表示。
	 * @param staffEntity 人員基本情報
	 * @param offset
	 */
	@Override
	public Map<String, Object> selectStaffs(
			JIN0002StaffEntity staffEntity, Integer offset) {
		Map<String, Object> result =
				new HashMap<String, Object>();
		RowBounds rowBounds = new RowBounds(offset, ItemConstant.PAGE_LIMIT);
		Page<Object> page = PageHelper.startPage(offset, ItemConstant.PAGE_LIMIT);
		List<JIN0002StaffEntity> staffList =
				this.staffMapper.selectStaffs(staffEntity, rowBounds);
		long total = page.getTotal();
		int pages = page.getPages();
		result.put("staffList", staffList);
		result.put("total", total);
		result.put("pages", pages);
		return result;
	}

	/**
	 * 問合せ者の基本情報を自動的に補完する
	 * @author caichunyu
	 */
	@Override
	public List<JIN0002StaffEntity> selectJIN0002StaffEntitysByName(String name) {
		return this.staffMapper.selectJIN0002StaffEntitysByName(name);
	}

	/**
	 * 人員基本情報取得。
	 * @param idNumber 証件番号
	 * @return 人員基本情報
     */
	@Override
	public JIN0002StaffEntity selectstaffid(String idNumber) {
		return staffMapper.selectstaffid(idNumber);
	}

}
