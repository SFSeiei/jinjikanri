package com.jinjikanri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jinjikanri.common.util.ErrorMessage;
import com.jinjikanri.common.util.Tools;
import com.jinjikanri.entity.HKN0009ZiknEntity;
import com.jinjikanri.service.ZiknService;

/**
 * “税金計算基準の設定”のコントローラ
 *@author 時煜程 2019/12/23
 */
@Controller
@RequestMapping(value="/zeiritu")
public class ZiknController {

	@Autowired
	private ZiknService ziknService;

	/**
	 * 一覧の画面
	 * AND最初のページを返します。
	 * @param model 毛豆	
	 * @return 一覧の画面
	 */
	@RequestMapping(value="/display")
	public String display(Model model) {
		// 1課税所得額から税率取得する。
		HKN0009ZiknEntity zikn = this.ziknService.selectZiknById();
		if (zikn==null) {
			// 1データは存在しません、エラーの画面に戻る。
			return "zeiritu/zeirituError";
		} else {
			// 1データは存在します。
			model.addAttribute("Zikn",zikn);
			return "zeiritu/zeirituDisplay";
		}
	}

	/**
	 * update画面に移動
	 * @param model 毛豆
	 * @return update画面
	 */
	@RequestMapping(value="/update")
	public String update(Model model) {
		// 1課税所得額から税率取得する。
		HKN0009ZiknEntity zikn = this.ziknService.selectZiknById();
		if (zikn==null) {
			// 1データは存在しません、エラーの画面に戻る。
			return "zeiritu/zeirituError";
		} else {
			// 1データは存在します。
			model.addAttribute("Zikn",zikn);
			return "zeiritu/zeirituUpdate";
		}
	}

	/**
	 * データの変更
	 * AND 更新後の戻りページ
	 * @param zikn 「税金計算基準の設定」の整条设定 
	 * @param model 毛豆
	 * @return 初期画面
	 */
	@RequestMapping(value="/confirm")
	@ResponseBody
	public String confirm(@ModelAttribute HKN0009ZiknEntity zikn,Model model) throws Exception {
		zikn.setZiknCd(1);
		if (Check(zikn)) {
			//1後の単一項目と関連check==tureの場合
			HKN0009ZiknEntity ziknDBcheck = this.ziknService.getZiknDBcheck(zikn.getRecKosnZituYmdHms());
			if (ziknDBcheck==null) {
				// 1更新排他エラー
				return ErrorMessage.ERR0048();
			} else {
				// 1DB更新排他チェックを通過する
				// 1更新操作を実行する
				// 1システム時間を追加
				zikn.setRecKosnZituYmdHms(Tools.getSysDate());
				// 1データを追加
				ziknService.updateZiknById(zikn);
				// 1データを视レイヤーに転送します。
				model.addAttribute("Zikn",zikn);
				return "zeiritu/zeirituDisplay";
			}
		} else {
			// 1後の単一項目と関連check==falseの場合
			throw new Exception("系统错误");
		}
	}

	/**
	 * 後の単一項目と関連check
	 * @param zikn 「税金計算基準の設定」の整条设定
	 * @return true 続行
	 * @return false 戻る
	 */
	public boolean Check(HKN0009ZiknEntity zikn) {
		if (zikn.getTukiTinkinTkyu1()!=null&&
				zikn.getTukiTinkinTkyu2() != null &&
				zikn.getTukiTinkinTkyu3() != null &&
				zikn.getTukiTinkinTkyu4() != null &&
				zikn.getTukiTinkinTkyu5() != null &&
				zikn.getTukiTinkinTkyu6() != null &&
				zikn.getTukiTinkinTkyu7() != null &&
				zikn.getTukiTinkinTkyu1() > 0 &&
				zikn.getTukiTinkinTkyu1() < 10000000 &&
				zikn.getTukiTinkinTkyu2() > 0 &&
				zikn.getTukiTinkinTkyu2() < 10000000 &&
				zikn.getTukiTinkinTkyu3() > 0 &&
				zikn.getTukiTinkinTkyu3() < 10000000 &&
				zikn.getTukiTinkinTkyu4() > 0 &&
				zikn.getTukiTinkinTkyu4() < 10000000 &&
				zikn.getTukiTinkinTkyu5() > 0 &&
				zikn.getTukiTinkinTkyu5() < 10000000 &&
				zikn.getTukiTinkinTkyu6() > 0 &&
				zikn.getTukiTinkinTkyu6() < 10000000 &&
				zikn.getTukiTinkinTkyu7() > 0 &&
				zikn.getTukiTinkinTkyu7() < 10000000 &&
				zikn.getTukiTinkinTkyu1() < zikn.getTukiTinkinTkyu2() &&
				zikn.getTukiTinkinTkyu2() < zikn.getTukiTinkinTkyu3() &&
				zikn.getTukiTinkinTkyu3() < zikn.getTukiTinkinTkyu4() &&
				zikn.getTukiTinkinTkyu4() < zikn.getTukiTinkinTkyu5() &&
				zikn.getTukiTinkinTkyu5() < zikn.getTukiTinkinTkyu6() &&
				zikn.getTukiTinkinTkyu6() < zikn.getTukiTinkinTkyu7()
				) {
			return true;
		} else {
			return false;
		}
	}
}
