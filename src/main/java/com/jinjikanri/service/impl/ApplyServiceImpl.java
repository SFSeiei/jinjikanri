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
import com.jinjikanri.entity.JIN0003QbbgEntity;
import com.jinjikanri.mapper.ApplyMapper;
import com.jinjikanri.service.ApplyService;

@Service
public class ApplyServiceImpl implements ApplyService {
	@Autowired
	private ApplyMapper applyMapper;
	
	/*データの追加*/
	@Override
	public int addApplyInfor(JIN0003QbbgEntity apply) {
		return applyMapper.addApplyInfor(apply);
	}
	
	/*申請データの検索*/
	@Override
	public Map<String, Object> getApplyList(JIN0003QbbgEntity apply,int offset) {
		Map<String, Object> result = new HashMap<String, Object>();
		RowBounds rowBounds = new RowBounds(offset, ItemConstant.PAGE_LIMIT);
		Page<Object> page = PageHelper.startPage(offset, ItemConstant.PAGE_LIMIT);
		List<JIN0003QbbgEntity> applyList = this.applyMapper.getApplyList(apply, rowBounds);
		long total = page.getTotal();
		int pages = page.getPages();
		result.put("applyList", applyList);
		result.put("total", total);
		result.put("pages", pages);
		return result;
	}
	
	/*履歴データの検索*/
	@Override
	public Map<String, Object> getApplyHistory(JIN0003QbbgEntity apply,int offset) {
		Map<String, Object> result = new HashMap<String, Object>();
		RowBounds rowBounds = new RowBounds(offset, ItemConstant.PAGE_LIMIT);
		Page<Object> page = PageHelper.startPage(offset, ItemConstant.PAGE_LIMIT);
		List<JIN0003QbbgEntity> applyHistory = this.applyMapper.getApplyHistory(apply, rowBounds);
		long total = page.getTotal();
		int pages = page.getPages();
		result.put("applyHistory", applyHistory);
		result.put("total", total);
		result.put("pages", pages);
		return result;
	}
	
	/*指定IDデータの削除*/
	@Override
	public int delDate(Integer dateId) {
		return applyMapper.delDate(dateId);
	}
	
	/*指定IDデータの更新*/
	@Override
	public int updateApply(JIN0003QbbgEntity apply) {
		return applyMapper.updateApply(apply);
	}
	
	/*指定IDデータの検索*/
	@Override
	public JIN0003QbbgEntity selApplyById(Integer dateId) {
		return applyMapper.selApplyById(dateId);
	}
	
	/*指定IDと更新日時データの削除*/
	@Override
	public JIN0003QbbgEntity getDataByIdTime(Integer dateId,Timestamp recKosnZituYmdHms) {
		return applyMapper.getDataByIdTime(dateId, recKosnZituYmdHms);
	}
}
