package com.jinjikanri.controller;


import java.util.List;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jinjikanri.common.util.ErrorMessage;
import com.jinjikanri.entity.HKN0001ORGEntity;


import com.jinjikanri.service.impl.HKN0001ServiceImpl;



/**
 * hkn0001org表のデータ
 * @author zhangwenjie
 * @param pageIndex 現在のページ
 * @param model Modelオブジェクト
 * @return "user/list1" 組織検索画面
	 */

@Controller
@RequestMapping(value = "/orga")
public class OrganizationController {
	@Autowired
	HKN0001ServiceImpl hkn0001ServiceImpl;


	@RequestMapping(value = "/getOrganization")
	public String getOrganization(HKN0001ORGEntity orga, Integer pageIndex, Model model) {
		if (pageIndex == null) {
			pageIndex = 1;
		}
		Map<String, Object> result = hkn0001ServiceImpl.getOrganization(orga, pageIndex, 5);
		model.addAttribute("total", result.get("total"));
		model.addAttribute("pages", result.get("pages"));
		model.addAttribute("orgaList", result.get("orgaList"));
		model.addAttribute("orga", orga);
		return "user/list1";
	}
	/**
	 * 指定IDのデータを削除します
	 * @param なし
	 * @return
	 */
	@RequestMapping("/deleteOrganization")
	@ResponseBody
	public String delDate(Integer organizationCd, Timestamp makeTime) {
		 try {
			// 0削除存在チェック
			HKN0001ORGEntity  orga= hkn0001ServiceImpl.selectUserById(organizationCd);
			if(orga == null) {
				return ErrorMessage.ERR0029();
			} else {
				// 0执行削除
				int str = this.hkn0001ServiceImpl.delDate(organizationCd);
				return "true";
			} 
		} catch (Exception e) {
			e.printStackTrace();
		    return "false";
		}
	}
	
	




	/**
	 * 変更画面に遷移します
	 * @param model
	 * @return
	 */
	@RequestMapping("/tooper1")
	public String tooper1(Integer organizationCd,Model model) {
		HKN0001ORGEntity orga=new HKN0001ORGEntity();
		if (organizationCd != null) {
			orga = hkn0001ServiceImpl.selectUserById(organizationCd);
		}
		model.addAttribute("orga", orga);
		return "user/oper2";
	}
	/**
	 * 新規画面に遷移します
	 * @param model
	 * @return
	 */
	@RequestMapping("/tooper2")
	public String tooper2(Integer organizationCd,Model model) {
		HKN0001ORGEntity orga=new HKN0001ORGEntity();
		if (organizationCd != null) {
			orga = hkn0001ServiceImpl.selectUserById(organizationCd);
		}
		model.addAttribute("orga", orga);
		return "user/oper1";
	}
	/**
	 * hkn0001org表のデータを修正します
	 * @param orga
	 * @return
	 */
	@RequestMapping("/updateOrgazization")
	public String updateorganizationCd( HKN0001ORGEntity orga, Model model) {
		Integer organizationCd = orga.getOrganizationCd();
		Timestamp updateDate = orga.getRecKosnZituYmdHms();
		orga.setRecKosnZituYmdHms(new Timestamp(System.currentTimeMillis()));
		int orgaEntity=hkn0001ServiceImpl.updateorganizationCd(orga);
		model.addAttribute("orga", orga);
		return "user/list1";
	}
	/**
	 * hkn0001org表のデータを新規します
	 * @param orga
	 * @return
	 */
	@RequestMapping("/insertOrgazization")

	public String insertorganizationCd( HKN0001ORGEntity orga, Model model) {
		
		
		Integer organizationCd = orga.getOrganizationCd();
		Timestamp updateDate = orga.getRecKosnZituYmdHms();
		 
				
				HKN0001ORGEntity  orga1= hkn0001ServiceImpl.selectUserById(organizationCd);
				if(orga1 != null) {
					 model.addAttribute("updateResult", "ERR0031:組織コードと組織情報Ｔの組織コードの内容が一致していません。");
					return "user/oper1";
				} else {
					
					orga.setRecSaksZituYmdHms(new Timestamp(System.currentTimeMillis()));
					orga.setRecKosnZituYmdHms(new Timestamp(System.currentTimeMillis()));
					int orgaEntity=hkn0001ServiceImpl.insertorganizationCd(orga);
					 model.addAttribute("orga", orga);
						return "user/list1";
				}
		}
	
		
	
	@RequestMapping("/insertOrgazizationmid")
	public String insert1organizationCd(HKN0001ORGEntity orga, Model model) {
		
		orga.setRecSaksZituYmdHms(new Timestamp(System.currentTimeMillis()));
		orga.setRecKosnZituYmdHms(new Timestamp(System.currentTimeMillis()));
		int orgaEntity1=hkn0001ServiceImpl.update1organizationCd(orga);
		int orgaEntity=hkn0001ServiceImpl.insert1organizationCd(orga);
		model.addAttribute("orga", orga);
		return "user/list1";
	}
}
