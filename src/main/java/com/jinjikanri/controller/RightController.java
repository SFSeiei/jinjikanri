package com.jinjikanri.controller;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jinjikanri.entity.SYST06RightEntity;
import com.jinjikanri.mapper.RightMapper;

/**
 * 系统权限
 *
 * @author zhangxuping
 */
@Controller
@RequestMapping("/sys/right")
public class RightController {
	@Autowired
	private RightMapper rightMapper;

	/**
	 * 權限列表
	 */
	@RequestMapping("/list")
	@ResponseBody
//	@RequiresPermissions("sys:right:list")
	public HashMap<String, List<SYST06RightEntity>> list() {
		List<SYST06RightEntity> rightList = this.rightMapper.selectRights(new SYST06RightEntity(), new RowBounds());
		HashMap<String, List<SYST06RightEntity>> rightListMap = new HashMap<>();
		rightListMap.put("rightList", rightList);
		return rightListMap;
	}

	/**
	 * 根据charCd获取權限列表
	 */
	@RequestMapping("/listbyCharCd")
	@ResponseBody
//	@RequiresPermissions("sys:right:list")
	public HashMap<String, List<SYST06RightEntity>> listByUserCd(Integer charCd) {
		List<SYST06RightEntity> rightList = this.rightMapper.selectRightListByCharCd(charCd);
		HashMap<String, List<SYST06RightEntity>> rightListMap = new HashMap<>();
		rightListMap.put("rightList", rightList);
		return rightListMap;
	}
}
