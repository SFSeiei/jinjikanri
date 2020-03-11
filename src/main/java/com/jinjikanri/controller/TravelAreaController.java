package com.jinjikanri.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jinjikanri.common.util.ErrorMessage;
import com.jinjikanri.common.util.StaticData;
import com.jinjikanri.common.util.Tools;
import com.jinjikanri.common.util.TravelAreaCheck;
import com.jinjikanri.entity.HKN0003TravelAreaEntity;
import com.jinjikanri.entity.HKN0004AreaEntity;
import com.jinjikanri.service.HKN0003TravelAreaService;
import com.jinjikanri.service.HKN0004AreaService;

/**
 * “出張地域の管理 ”の控制器
 *@author 刁家豪 2019/12/17
 */
@Controller
@RequestMapping(value="/travelArea")
public class TravelAreaController {

	@Autowired 
	HKN0003TravelAreaService hkn0003TravelAreaServiceImpl;
	@Autowired
	HKN0004AreaService hkn0004AreaServiceImpl;
	
	private HKN0003TravelAreaEntity tra = new HKN0003TravelAreaEntity();
	
	/**
	   * 省市区によるhkn0003travelarea表のデータ
	 * @param travelArea HKN0003TravelAreamEntityオブジェクト
	 * @param pageIndex 現在のページ
	 * @param model Modelオブジェクト
	 * @return travelArea/travelAreaSearch 出張地域検索画面
	 */
	@RequestMapping("/getTravelArea")
	public String  getTravelArea(HKN0003TravelAreaEntity travelArea, Integer pageIndex, Model model) throws Exception{
		Map<String, Object> result;
		//  0エラーが発生していません			
		if (pageIndex == null) {
			pageIndex = 1;
		}
		
		if(tra != null) {
			result=hkn0003TravelAreaServiceImpl.getTravelArea(tra, pageIndex, StaticData.TRAVELAREA_PAGE_LIMIT);
			model.addAttribute("travelArea", tra);
			tra=null;
		} else {
			//	0出張地域情報の取得（改ページ）		
			result=hkn0003TravelAreaServiceImpl.getTravelArea(travelArea, pageIndex, StaticData.TRAVELAREA_PAGE_LIMIT);
			model.addAttribute("travelArea", travelArea);
		}
		if(result.get("isTrue").equals(false) && !result.get("isTrue").equals("")) {
			throw new Exception("系统错误");	
		}
		//	0情報総数	
		model.addAttribute("total", result.get("total"));
		//	0総ページ数		
		model.addAttribute("pages", result.get("pages"));
		//	0出張地域情報		
		model.addAttribute("travelAreaList", result.get("travelAreaList"));
		return "travelArea/travelAreaSearch";	
	}
	
	/**
	   * 指定IDのデータを削除します
	 * @param travelAreaIdArray 出張地域IDアレイ
	 * @param updateTimeArray レコード更新実年月日時分秒アレイ
	 * @return message JSONメッセージ
	 */
	@RequestMapping("/deleteTravelAreaById")
	@ResponseBody
	public String deleteTravelAreaById(Integer[] travelAreaIdArray, Timestamp[] updateTimeArray) {
		String message = hkn0003TravelAreaServiceImpl.deleteTravelAreaById(travelAreaIdArray, updateTimeArray);
		return message;
	}
	
	/**
	 * hkn0003travelarea表にデータを追加します
	 * @param travelArea HKN0003TravelAreaEntityオブジェクト
	 * @param model Modelオブジェクト
	 * @return message JSONメッセージ
	 */
	@RequestMapping("/addTravelArea")
	@ResponseBody
	public String addTravelArea(HKN0003TravelAreaEntity travelArea, Model model) throws Exception {
		String message = null;
		//  0エラーフラグ
		boolean isTrue = TravelAreaCheck.singleCheck(travelArea);
		if (!isTrue) {
			//	0システム異常
			throw new Exception("系统错误");		
		} else {	
			//	0レコード作成実年月日時分秒を設定する。		
			travelArea.setRecSaksZituYmdHms(Tools.getSysDate());
			//	0レコード更新実年月日時分秒を設定する		
			travelArea.setRecKosnZituYmdHms(Tools.getSysDate());
			//	0補助金を設定する		
			travelArea.setTravelMoney(Tools.transStringToBigDecimal(travelArea.getTravelMoneyStr()));
			//	0出張地域情報の数を増やす		
			int insertLine = hkn0003TravelAreaServiceImpl.addTravelArea(travelArea);
			if(insertLine == 1) {
				//	0増加成功			
				message = "insertSucess";
			} else {
				//	0増加失敗			
				message = "insertFail";
			}
		}
		return message;
	}
		
	/**
	 * hkn0003travelarea表のデータを修正します
	 * @param travelArea HKN0003TravelAreaEntityオブジェクト
	 * @return message JSONメッセージ
	 */
	@RequestMapping("/updateTravelAreaById")
	@ResponseBody
	public String updateTravelAreaById(HKN0003TravelAreaEntity travelArea) throws Exception {
		//  0エラーフラグ
		boolean isTrue = TravelAreaCheck.singleCheck(travelArea);
		if(!isTrue) {
			//	0システム異常
			throw new Exception("系统错误");
		} else {
			String message = hkn0003TravelAreaServiceImpl.updateTravelAreaById(travelArea);
			return message;
		}
	}
	
	/**
	   * 出张地域変更（追加）画面に遷移します
	 * @param model 補助金
	 * @return 出張地域変更（追加）画面
	 */
	@RequestMapping("/toTravelDetail")
	public String toTravelDetail(HKN0003TravelAreaEntity hkn0003TravelAreaEntity, Model model) {
		tra=hkn0003TravelAreaEntity;
		HKN0003TravelAreaEntity travelArea = new HKN0003TravelAreaEntity();
		model.addAttribute("travelArea", travelArea);
		return "travelArea/travelDetail";
	}
	
	/**
	 * 根据ID查询hkn0003travelarea表中的一条数据是否存在
	 * @param travelAreaId	出张地域ID
	 * @return message JSONメッセージ
	 */
	@RequestMapping("/isTravelAreaExist")
	@ResponseBody
	public String isTravelAreaExist(Integer travelAreaId,HKN0003TravelAreaEntity hkn0003TravelAreaEntity) {
		String message = null;
		tra=hkn0003TravelAreaEntity;
		HKN0003TravelAreaEntity travelArea=hkn0003TravelAreaServiceImpl.getTravelAreaById(travelAreaId);
		if(travelArea == null) {
			message = ErrorMessage.ERR0029();	
		} else {
			message = "NOT NULL";
		}
		return message;
	}
	
	/**
	 * 根据ID查询hkn0003travelarea表中的一条数据
	 * @param travelAreaId	出张地域ID
	 * @param model
	 * @return 出張地域変更（追加）画面
	 */
	@RequestMapping("/getTravelAreaById")
	public String getTravelAreaById(Integer travelAreaId,Model model) {
		HKN0003TravelAreaEntity travelArea=hkn0003TravelAreaServiceImpl.getTravelAreaById(travelAreaId);
		Integer provinceId = hkn0004AreaServiceImpl.selectAreaId(travelArea.getProvinceName(), 0);
		Integer cityId = hkn0004AreaServiceImpl.selectAreaId(travelArea.getCityName(), provinceId);
		travelArea.setProvinceId(provinceId);
		travelArea.setCityId(cityId);
		model.addAttribute("travelArea", travelArea);
		return "travelArea/travelDetail";
	}
	
	/**
	 * 省を獲得する
	 * @return 省リスト
	 */
	@RequestMapping("/getProvince")
	@ResponseBody
	public List<HKN0004AreaEntity> getProvince(){
		return hkn0004AreaServiceImpl.getProvince();
	}
	
	/**
	 * 市/区/县を獲得する
	 * @param parentId　父ID
	 * @return 市/区/县リスト
	 */
	@RequestMapping("/getCityOrCountry")
	@ResponseBody
	public List<HKN0004AreaEntity> getCityOrCountry(Integer parentId){
		return hkn0004AreaServiceImpl.getCityOrCountry(parentId);
	} 
}
