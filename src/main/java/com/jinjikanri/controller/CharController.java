package com.jinjikanri.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jinjikanri.entity.SYST01UserEntity;
import com.jinjikanri.entity.SYST06CharEntity;
import com.jinjikanri.entity.SYST06RightEntity;
import com.jinjikanri.mapper.CharMapper;
import com.jinjikanri.mapper.RightMapper;
import com.jinjikanri.service.CharService;

/**
 * 角色管理
 *
 * @author zhangxuping
 */
@Controller
@RequestMapping("/sys/char")
public class CharController {
	@Autowired
	private CharMapper charMapper;

	@Autowired
	private RightMapper rightMapper;

	@Autowired
	private CharService charService;

	/**
	 * 列表方法，带分页
	 * 
	 * @param           char
	 * @param pageIndex
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/selectChars")
//	@RequiresPermissions("sys:char:select")
	public String selectChars(SYST06CharEntity charEntity, Integer pageIndex, Model model) {
		if(charEntity.getCharMei()=="") {
			charEntity.setCharMei(null);
		}
		if(charEntity.getCharDhiskrpsn()=="") {
			charEntity.setCharDhiskrpsn(null);
		}
		if (pageIndex == null) {
			pageIndex = 1;
		}
		Map<String, Object> result = this.charService.selectChars(charEntity, pageIndex);
		List<SYST01UserEntity> charList = (List<SYST01UserEntity>) result.get("charList");
		model.addAttribute("total", result.get("total"));
		model.addAttribute("pages", result.get("pages"));
		model.addAttribute("charList", charList);
		model.addAttribute("char", charEntity);
		return "char/list";
	}

	@RequestMapping(value = "/oper")
//	@RequiresPermissions("sys:char:add")
	public String oper(Integer charCd, Model model) {
		SYST06CharEntity charEntity = new SYST06CharEntity();
		List<SYST06RightEntity> charRightList = new ArrayList<SYST06RightEntity>();
		if (charCd != null) {
			RowBounds rowBounds = new RowBounds();
			charEntity.setCharCd(charCd);
			for (SYST06CharEntity oneChar : this.charMapper.selectChars(charEntity, rowBounds)) {
				charEntity = oneChar;
			}
			charRightList = this.rightMapper.selectRightListByCharCd(charCd);
		}
		model.addAttribute("char", charEntity);
		List<Integer> rightCdList = new ArrayList<Integer>();
		for (SYST06RightEntity oneCharRight : charRightList) {
			rightCdList.add(oneCharRight.getRightCd());
		}
		model.addAttribute("rightCdList", rightCdList);
		return "char/oper";
	}

	@RequestMapping(value = "/detail")
//	@RequiresPermissions("sys:char:select")
	public String detail(Integer charCd, Model model) {
		SYST06CharEntity charEntity = new SYST06CharEntity();
		RowBounds rowBounds = new RowBounds();
		for (SYST06CharEntity oneChar : this.charMapper.selectChars(charEntity, rowBounds)) {
			charEntity = oneChar;
		}
		List<SYST06RightEntity> rightList = this.rightMapper.selectRightListByCharCd(charCd);
		model.addAttribute("char", charEntity);
		model.addAttribute("rightList", rightList);
		return "char/detail";
	}

	/**
	 * 保存角色
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
//	@RequiresPermissions("sys:user:save")
	public String save(String rightCdList, SYST06CharEntity charEntity, Model model) {
		List<Integer> rightCdLists = new ArrayList<>();
		if (!rightCdList.isEmpty() && rightCdList != "" && rightCdList != null) {
			for (String rightCd : rightCdList.split(",")) {
				rightCdLists.add(Integer.valueOf(rightCd));
			}
		}
		this.charService.saveChar(charEntity, rightCdLists);
		model.addAttribute("char", charEntity);
		return "char/oper";
	}

	/**
	 * 修改角色
	 */
	@RequestMapping("/update")
//	@RequiresPermissions("sys:char:update")
	public String update(String rightCdList, SYST06CharEntity charEntity, Model model) {
		List<Integer> rightCdLists = new ArrayList<>();
		if (!rightCdList.isEmpty() && rightCdList != "" && rightCdList != null) {
			for (String rightCd : rightCdList.split(",")) {
				rightCdLists.add(Integer.valueOf(rightCd));
			}
		}
		this.charService.updateChar(charEntity, rightCdLists);
		model.addAttribute("char", charEntity);
		return "char/oper";
	}

	/**
	 * 删除角色
	 */
	@RequestMapping("/delete")
//	@RequiresPermissions("sys:char:delete")
	public String delete(Integer[] charCds, Model model) {
		this.charService.deleteCharBatch(charCds);
		SYST06CharEntity nullChar = new SYST06CharEntity();
		return this.selectChars(nullChar, 1, model);
	}

	/**
	 * 角色列表
	 */
	@RequestMapping("/list")
	@ResponseBody
//	@RequiresPermissions("sys:char:list")
	public HashMap<String, List<SYST06CharEntity>> list() {
		List<SYST06CharEntity> charList = charMapper.selectChars(new SYST06CharEntity(), new RowBounds());
		HashMap<String, List<SYST06CharEntity>> charListMap = new HashMap<>();
		charListMap.put("charList", charList);
		return charListMap;
	}

	/**
	 * 根据UsrCd获取角色列表
	 */
	@RequestMapping("/listbyUsrCd")
	@ResponseBody
//	@RequiresPermissions("sys:char:list")
	public HashMap<String, List<SYST06CharEntity>> listByUserCd(Integer usrCd) {
		List<SYST06CharEntity> charList = charMapper.selectCharListByUsrCd(usrCd);
		HashMap<String, List<SYST06CharEntity>> charListMap = new HashMap<>();
		charListMap.put("charList", charList);
		return charListMap;
	}
}
