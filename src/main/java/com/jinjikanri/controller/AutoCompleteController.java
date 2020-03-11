package com.jinjikanri.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.jinjikanri.entity.JIN0002StaffEntity;
import com.jinjikanri.service.StaffService;

/**
 * コントローラを自動補完する
 * @author caichunyu
 */
@RestController
@RequestMapping(value = "/autoComplete")
public class AutoCompleteController {
	@Autowired
	private StaffService staffService;
	
	/**
	 * 要員の基本情報の集合を調べ,JSONという文字列を返す
	 * @param q 入力ボックスから入力するパラメータ
	 * @return JSON串
	 */
	@RequestMapping(value = "/staffAutoComplete")
	public String staffAutoComplete(String q) {
		List<JIN0002StaffEntity> selectJIN0002StaffEntitysByName = this.staffService.selectJIN0002StaffEntitysByName(q);
		return JSONObject.toJSONString(selectJIN0002StaffEntitysByName);
	}
}
