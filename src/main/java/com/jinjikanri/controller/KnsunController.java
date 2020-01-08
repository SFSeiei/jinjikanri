package com.jinjikanri.controller;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jinjikanri.entity.HKN0007KnsunEntity;
import com.jinjikanri.entity.HKN0008KnsunStaffEntity;
import com.jinjikanri.service.HKN0007KnsunService;

@Controller
@RequestMapping(value = "/knsun")
public class KnsunController {
	@Autowired
	private HKN0007KnsunService knsunService;
	
	/**
	 * 健診日の新規追加/変更方法
	 * 
	 * @param knsun
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/insertKnsun")
	@ResponseBody
	public String insertKnsun(HKN0007KnsunEntity knsun) throws Exception {
		// ページ上の各項目に対する単項目チェックを含む
		if (knsun.getKnsunYmdStart() == null) {
			throw new Exception("系统错误");
		}
		if (knsun.getKnsunYmdEnd() == null) {
			throw new Exception("系统错误");
		}
		// 日付フォーマット変換
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		String start = fmt.format(knsun.getKnsunYmdStart());
		String end = fmt.format(knsun.getKnsunYmdEnd());
		if (knsun.getKnsunYmdStart() != null && knsun.getKnsunYmdEnd() != null
				&& java.sql.Date.valueOf(start).after(java.sql.Date.valueOf(end))) {
			throw new Exception("系统错误");
		}
		try {
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			// KnsunYmdIdが空であれば新規追加メソッドを実行する
			if (knsun.getKnsunYmdId() == null) {
				knsun.setRecKosnZituYmdHms(timestamp);
				knsun.setRecSaksZituYmdHms(timestamp);
				int str = knsunService.insertKnsun(knsun);
				// 新规追加时页面项目的DBcheck,データベースにすでに存在するデータを追加することはできない
				if (str == 1) {
					return "true";
				} else if (str == 0) {
					return "false";
				} else {
					return "notNull";
				}
			} else {
				// KnsunYmdIdが空でなければ,変更メソッドを実行する。排他
				HKN0007KnsunEntity knsunEntity = this.knsunService.getKnsunByIdAndUpdateTime(knsun.getKnsunYmdId(), knsun.getRecKosnZituYmdHms());
				if (knsunEntity == null) {
					return "alreadyUpdate";
				}
				knsun.setRecKosnZituYmdHms(timestamp);
				int str = knsunService.updateKnsunById(knsun);
				// 変更时页面项目的DBcheck,データベースにすでに存在するデータを追加することはできない
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
			return "error";
		}
	}
	/**
	 * 現地時間と健診日終了時間はcheck
	 * @param knsunYmdId
	 * @return
	 */
	@RequestMapping(value = "/operValid")
	@ResponseBody
	public String operValid(Integer knsunYmdId) {
		HKN0007KnsunEntity knsun = this.knsunService.getKnsunById(knsunYmdId);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	Date local = new Date();
    	//	変更ボタンをクリックするとデータが存在するかどうかを判断する
    	if (knsun == null) {
    		return "isNull";
    	} else if (local.after(knsun.getKnsunYmdEnd())) {
    		return "notChange";
    	}
		return "true";
	}

	/**
	 * 画面をジャンプする際に,データのジャンプが必要かどうか
	 * 
	 * @param knsunYmdId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/oper")
	public String oper(Integer knsunYmdId, Model model) {
		HKN0007KnsunEntity hkn0007KnsunEntity = new HKN0007KnsunEntity();
		// knsunYmdIdが存在するか否かにより,ジャンプした画面にデータがあるか否かを決定する
		if (knsunYmdId != null) {
			hkn0007KnsunEntity = knsunService.getKnsunById(knsunYmdId);
		}
		model.addAttribute("hkn0007KnsunEntity", hkn0007KnsunEntity);
		return "knsun/HKN0007001";
	}

	/**
	 * 健診日開始と健診日終了のチェックを受付で行う
	 * 
	 * @param knsunYmdStart
	 * @param knsunYmdEnd
	 * @return
	 */
	@RequestMapping(value = "/validDate", method = RequestMethod.POST)
	@ResponseBody
	public String validDate(String knsunYmdStart, String knsunYmdEnd) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			if (sdf.parse(knsunYmdStart).after(sdf.parse(knsunYmdEnd))) {
				return "false";
			}
			return "true";
		} catch (Exception e) {
			e.printStackTrace();
			return "false";
		}
	}

	/**
	 * 健診日の削除方法
	 * 
	 * @param knsunYmdId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteKnsun")
	@ResponseBody
	public String deleteKnsun(Integer knsunYmdId) throws Exception {
		try {
			//	削除时页面项目的DBcheck
			//	存在しなければそのデータが削除されたことを示す
			HKN0007KnsunEntity knsunEntity = this.knsunService.getKnsunById(knsunYmdId);
			if (knsunEntity == null) {
				return "isNull";
			}
			//	現地時間と健診日終了時間はcheck
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date local = new Date();
			if (local.after(knsunEntity.getKnsunYmdEnd())) {
				return "notDelete";
			}
			// knsunYmdIdを判定条件とし,IDが存在すればそのデータを削除し,
			int str = this.knsunService.deleteKnsun(knsunYmdId);
			return "true";
		} catch (Exception e) {
			e.printStackTrace();
			return "false";
		}
	}
}
