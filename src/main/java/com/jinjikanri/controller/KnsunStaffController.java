package com.jinjikanri.controller;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jinjikanri.entity.HKN0007KnsunEntity;
import com.jinjikanri.entity.HKN0008KnsunStaffEntity;
import com.jinjikanri.service.HKN0007KnsunService;
import com.jinjikanri.service.HKN0008KnsunStaffService;

/**
 * “人員健診日”の控制器
 *@author 李春菊 2019/12/17
 */
@Controller
@RequestMapping(value = "/knsunStaff")
public class KnsunStaffController {
	@Autowired
	private HKN0008KnsunStaffService knsunStaffService;
	@Autowired
	private HKN0007KnsunService knsunService;

	/**
	 * 列表方法，带分页
	 * 検索方法
	 * 名前と健診日を検索条件として,情報を検索する
	 * @param user
	 * @param pageIndex
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/selectKnsunStaffs")
	public String selectKnsunStaffs(HKN0008KnsunStaffEntity hkn0008KnsunStaffEntity, Integer pageIndex, Model model)
			throws Exception {
		if ("".equals(hkn0008KnsunStaffEntity.getName())) {
			hkn0008KnsunStaffEntity.setName(null);
		} else {
			if (hkn0008KnsunStaffEntity.getName() != null && hkn0008KnsunStaffEntity.getName().length() > 20) {
				throw new Exception("系统错误");
			}
		}
		if (pageIndex == null) {
			pageIndex = 1;
		}
		Map<String, Object> result = this.knsunStaffService.selectKnsunStaffs(hkn0008KnsunStaffEntity, pageIndex);
		model.addAttribute("knsunList", result.get("hkn0008KnsunStaffEntities"));
		model.addAttribute("total", result.get("total"));
		model.addAttribute("pages", result.get("pages"));
		model.addAttribute("hkn0008KnsunStaffEntity", hkn0008KnsunStaffEntity);
		model.addAttribute("hkn0007Knsuns", this.knsunService.hkn0007KnsunEntities());
		return "knsunStaff/HKN0008001";
	}

	/**
	 * 画面をジャンプする際に,データのジャンプが必要かどうか
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/oper")
	public String oper(Integer id, Model model) {
		HKN0008KnsunStaffEntity hkn0008KnsunStaffEntity = new HKN0008KnsunStaffEntity();
		//	Idが存在するか否かにより,ジャンプした画面にデータがあるか否かを決定する
		if (id != null) {
			hkn0008KnsunStaffEntity = knsunStaffService.getKnsunStaffById(id);
		}
		model.addAttribute("hkn0008KnsunStaffEntity", hkn0008KnsunStaffEntity);
		model.addAttribute("hkn0007Knsuns", this.knsunService.hkn0007KnsunEntities());
		return "knsunStaff/HKN0008002";
	}

	/**
	 *  人員健診日の新規追加/変更方法
	 * @param knsunStaff
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/insertKnsunStaff")
	@ResponseBody
	public String insertKnsunStaff(HKN0008KnsunStaffEntity knsunStaff) throws Exception {
		//	ページ上の各項目に対する単項目チェックを含む
		// nameの桁数check
		if (knsunStaff.getName() != null && knsunStaff.getName().length() > 20) {
			throw new Exception("系统错误");
		}
		if (knsunStaff.getName() == null || knsunStaff.getStaffId() == null || knsunStaff.getKnsunYmdId() == null
				|| knsunStaff.getKaiseBi() == null || knsunStaff.getEndBi() == null) {
			throw new Exception("系统错误");
		}
		HKN0007KnsunEntity knsun = knsunService.getKnsunById(knsunStaff.getKnsunYmdId());
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		String start = fmt.format(knsunStaff.getKaiseBi());
		String end = fmt.format(knsunStaff.getEndBi());
		String kStart = fmt.format(knsun.getKnsunYmdStart());
		String kEnd = fmt.format(knsun.getKnsunYmdEnd());
		if (knsunStaff.getKaiseBi() != null && knsunStaff.getEndBi() != null
				&& java.sql.Date.valueOf(start).after(java.sql.Date.valueOf(end))) {
			throw new Exception("系统错误");
		}
		if (knsunStaff.getKaiseBi() != null && knsunStaff.getEndBi() != null
				&& java.sql.Date.valueOf(kStart).after(java.sql.Date.valueOf(start))
				&& java.sql.Date.valueOf(end).after(java.sql.Date.valueOf(kEnd))) {
			throw new Exception("系统错误");
		}
		try {
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			//	Idが空であれば新規追加メソッドを実行する
			if (knsunStaff.getId() == null) {
				knsunStaff.setRecKosnZituYmdHms(timestamp);
				knsunStaff.setRecSaksZituYmdHms(timestamp);
				int str = knsunStaffService.insertKnsunStaff(knsunStaff);
				//	新规追加时页面项目的DBcheck,データベースにすでに存在するデータを追加することはできない
				if (str == 1) {
					return "true";
				} else if (str == 0) {
					return "false";
				} else {
					return "notNull";
				}
			} else {
				//	Idが空でなければ,変更メソッドを実行する。排他
				HKN0008KnsunStaffEntity knsunStaffEntity = this.knsunStaffService.getKnsunStaffByIdAndUpdateTime
						(knsunStaff.getId(), knsunStaff.getRecKosnZituYmdHms());
				if (knsunStaffEntity == null) {
					return "alreadyUpdate";
				}
				knsunStaff.setRecKosnZituYmdHms(timestamp);
				int str = knsunStaffService.updateknsunStaffById(knsunStaff);
				//	変更时页面项目的DBcheck,データベースにすでに存在するデータに変更することはできない 
				if (str == 1) {
					return "true";
				} else if (str == 0) {
					return "false";
				} else {
					return "notNull";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "false";
		}
	}
	/**
	 * 現地時間と健診日終了時間はcheck
	 * @param knsunYmdId
	 * @return
	 */
	@RequestMapping(value = "/operValid")
	@ResponseBody
	public String operValid(Integer id) {
		HKN0008KnsunStaffEntity knsunStaffEntity = this.knsunStaffService.getKnsunStaffById(id);
		//	変更ボタンをクリックするとデータが存在するかどうかを判断する
		if (knsunStaffEntity == null) {
			return "isNull";
		}
		HKN0007KnsunEntity knsun = this.knsunService.getKnsunById(knsunStaffEntity.getKnsunYmdId());
    	Date local = new Date();
    	//	変更ボタンをクリックすると,そのデータの関連データが存在するかどうかを判断する
    	if (knsun == null) {
    		return "connectNull";
    	} else if (local.after(knsun.getKnsunYmdEnd())) {
    		return "notChange";
    	}
		return "true";
	}

	/**
	 * 受付開始日と終了日と健診開始日と健診終了日の相関チェックを行う
	 * @param kaiseBi
	 * @param endBi
	 * @return
	 */
	@RequestMapping(value = "/validDate", method = RequestMethod.POST)
	@ResponseBody
	public String validDate(Integer knsunYmdId, String kaiseBi, String endBi) {
		HKN0007KnsunEntity knsun = knsunService.getKnsunById(knsunYmdId);
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			if (sdf.parse(kaiseBi).after(sdf.parse(endBi)) || 
					sdf.parse(endBi).after(knsun.getKnsunYmdEnd()) ||
					knsun.getKnsunYmdStart().after(sdf.parse(kaiseBi))) {
				return "false";
			}
			return "true";
		} catch (Exception e) {
			e.printStackTrace();
			return "false";
		}
	}

	/**
	 *  人員健診日の削除方法
	 * @param knsunYmdId
	 * @return
	 */
	@RequestMapping("/deleteKnsunStaffById")
	@ResponseBody
	public String deleteKnsunStaffById(Integer id) {
		try {
			//	idを判定条件とし,IDが存在すればそのデータを削除し,
			//	存在しなければそのデータが削除されたことを示す
			//	削除时页面项目的DBcheck
			HKN0008KnsunStaffEntity knsunStaffEntity = this.knsunStaffService.getKnsunStaffById(id);
			if (knsunStaffEntity == null) {
				return "isNull";
			}
			//	現地時間と健診日終了時間はcheck
			HKN0007KnsunEntity knsun = this.knsunService.getKnsunById(knsunStaffEntity.getKnsunYmdId());
	    	Date local = new Date();
	    	if(local.after(knsun.getKnsunYmdEnd())) {
	    		return "notDelete";
	    	}
			int str = this.knsunStaffService.deleteKnsunStaffById(id);
			return "true";
		} catch (Exception e) {
			e.printStackTrace();
			return "false";
		}
	}
}
