package com.jinjikanri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jinjikanri.common.util.ErrorMessage;
import com.jinjikanri.common.util.Tools;
import com.jinjikanri.entity.HKN0010ZyuyntsEntity;
import com.jinjikanri.service.ZyuyService;

/**
 * 剰余日数と出勤時刻情報の設定コントローラ
 * @author 史林林 2019/12/27
 */
@Controller
@RequestMapping(value="/zyuy")
public class ZyuyController {

	@Autowired
	private ZyuyService zyuyService;
	
	/**
	 * 剰余日数と出勤時刻情報検索表示
	 * @param zyuy 剰余日数と出勤時刻情報
	 * @param model モデル
	 * @return zyuy/zyuytran パラメータの設定（一覧）画面
	 */
	@RequestMapping(value="/getZyuyById")
	public String getZyuyById(Integer sttCd, Model model) {
		HKN0010ZyuyntsEntity zyuy = zyuyService.getZyuyById(sttCd);
		if (zyuy == null) {
			model.addAttribute("errMsg", "該当データがありません");
			zyuy = new HKN0010ZyuyntsEntity();
			model.addAttribute("zyuy",zyuy);
			return "zyuy/zyuytran";
		} else {
			model.addAttribute("zyuy", zyuy);
			return "zyuy/zyuytran";
		}
	}
	
	/**
	 * 剰余日数と出勤時刻情報変更表示
	 * @param zyuy 剰余日数と出勤時刻情報
	 * @param model モデル
	 * @return zyuy/zyuyhenkou パラメータの設定（変更）画面
	 */
	@RequestMapping(value="/getZyuysById")
	public String getZyuysById(Integer sttCd, Model model) {
		HKN0010ZyuyntsEntity zyuy = zyuyService.getZyuyById(sttCd);
		if (zyuy == null) {
			model.addAttribute("errMsg", "該当データがありません");
			zyuy = new HKN0010ZyuyntsEntity();
			model.addAttribute("zyuy",zyuy);
			return "zyuy/zyuytran";
		} else {
			model.addAttribute("zyuy", zyuy);
			return "zyuy/zyuyhenkou";
		}
	}
	
	/**
	 * 剰余日数と出勤時刻情報全部検索改ページ表示
	 * @param zyuy 剰余日数と出勤時刻情報
	 * @param model モデル
	 * @return zyuy/zyuytran パラメータの設定（一覧）画面
	 * @throws Exception 
	 */
	@RequestMapping(value="/updateZyuyById")
	@ResponseBody
	public String updateZyuyById(HKN0010ZyuyntsEntity zyuy, Model model) throws Exception {
		//  エラーフラグ
		boolean isTrue = Check(zyuy);
		Integer sttCd = zyuy.getSttCd();
		if (!isTrue) {
			// システム異常
			throw new Exception("系统错误");
		} else {
				if (zyuyService.getZyuyById(sttCd) != null) {
					if (zyuyService.selectDB(sttCd, zyuy.getRecKosnZituYmdHms())) {
						zyuy.setRecKosnZituYmdHms(Tools.getSysDate());
						zyuy.setSttCd(1);
						zyuyService.updateZyuyById(zyuy);
						model.addAttribute("zyuy", zyuy);
					} else {
						// 更新排他エラー
						return ErrorMessage.ERR0048();
					}
				} else {
					//更新されたデータは存在しませんエラー
					return ErrorMessage.ERR0029();
				}
			return "zyuy/zyuytran";
		}
		
	}

	/**
	 * パラメータチェックステージ。<BR>
	 * 変更照会のパラメータチェックを順次実行する。<BR>
	 * @param zyuy 剰余日数と出勤時刻情報
	 * @return boolean
	 */
	public boolean Check(HKN0010ZyuyntsEntity zyuy) throws Exception {
		boolean isTrue = true;
		// 誕生日前倒し日数正整数チェック
		if (zyuy.getTnzybZynts() != null && !Tools.isInteger(String.valueOf(zyuy.getTnzybZynts()))) {
			isTrue = false;
		}
		// 誕生日前倒し日数範囲チェック
		if (zyuy.getTnzybZynts() != null && !Tools.rangeCheck(zyuy.getTnzybZynts(), 0, 999)) {
			isTrue = false;
		}
		// 身分証期限前倒し日数正整数チェック
		if (zyuy.getMbnsyuZynts() != null && !Tools.isInteger(String.valueOf(zyuy.getMbnsyuZynts()))) {
			isTrue = false;
		}
		// 身分証期限前倒し日数範囲チェック
		if (zyuy.getMbnsyuZynts() != null && !Tools.rangeCheck(zyuy.getMbnsyuZynts(), 0, 999)) {
			isTrue = false;
		}
		// 健診日前倒し日数正整数チェック
		if (zyuy.getKnsunZynts() != null && !Tools.isInteger(String.valueOf(zyuy.getKnsunZynts()))) {
			isTrue = false;
		}
		// 健診日前倒し日数範囲チェック
		if (zyuy.getKnsunZynts() != null && !Tools.rangeCheck(zyuy.getKnsunZynts(), 0, 999)) {
			isTrue = false;
		}
		// 昼間出勤開始時刻正整数チェック
		if (zyuy.getHrmkuKisi() != null && !Tools.isInteger(String.valueOf(zyuy.getHrmkuKisi()))) {
			isTrue = false;
		}
		// 昼間出勤開始時刻範囲チェック
		if (zyuy.getHrmkuKisi() != null && !Tools.rangeCheck(zyuy.getHrmkuKisi(), 0, 12)) {
			isTrue = false;
		}
		// 昼間出勤終了時刻正整数チェック
		if (zyuy.getHrmkuSyryu() != null && !Tools.isInteger(String.valueOf(zyuy.getHrmkuSyryu()))) {
			isTrue = false;
		}
		// 昼間出勤終了時刻範囲チェック
		if (zyuy.getHrmkuSyryu() != null && !Tools.rangeCheck(zyuy.getHrmkuSyryu(), 13, 24)) {
			isTrue = false;
		}
		// 夜間出勤開始時刻正整数チェック
		if (zyuy.getYknkuKisi() != null && !Tools.isInteger(String.valueOf(zyuy.getYknkuKisi()))) {
			isTrue = false;
		}
		// 夜間出勤開始時刻範囲チェック
		if (zyuy.getYknkuKisi() != null && !Tools.rangeCheck(zyuy.getYknkuKisi(), 13, 24)) {
			isTrue = false;
		}
		// 夜間出勤終了時刻正整数チェック
		if (zyuy.getYknkuSyryu() != null && !Tools.isInteger(String.valueOf(zyuy.getYknkuSyryu()))) {
			isTrue = false;
		}
		// 夜間出勤終了時刻範囲チェック
		if (zyuy.getYknkuSyryu() != null && !Tools.rangeCheck(zyuy.getYknkuSyryu(), 0, 12)) {
			isTrue = false;
		}
		// 昼間出勤開始時刻＜昼間出勤終了時刻チェック
		if ((zyuy.getHrmkuKisi() != null && zyuy.getHrmkuSyryu() != null) &&
				(zyuy.getHrmkuKisi() >= zyuy.getHrmkuSyryu())) {
			isTrue = false;
		}
		// 夜間出勤終了時刻＜夜間出勤開始時刻チェック
		if ((zyuy.getYknkuKisi() != null && zyuy.getYknkuSyryu() != null) &&
				(zyuy.getYknkuKisi() <= zyuy.getYknkuSyryu())) {
			isTrue = false;
		}
		// 昼間出勤終了時刻＜=夜間出勤開始時刻チェック
		if ((zyuy.getHrmkuSyryu() != null && zyuy.getYknkuKisi() != null) &&
				(zyuy.getHrmkuSyryu() > zyuy.getYknkuKisi())) {
			isTrue = false;
		}
		// 夜間出勤終了時刻 <= 昼間出勤開始時刻チェック
		if ((zyuy.getYknkuSyryu() != null && zyuy.getHrmkuKisi() != null) &&
				(zyuy.getYknkuSyryu() > zyuy.getHrmkuKisi())) {
			isTrue = false;
		}
		// 昼間出勤開始時刻と昼間出勤終了時刻入力チェック
		if (!((zyuy.getHrmkuKisi() == null && zyuy.getHrmkuSyryu() == null)
				|| (zyuy.getHrmkuKisi() != null && zyuy.getHrmkuSyryu() != null))) {
			isTrue = false;
		}
		// 夜間出勤開始時刻と夜間出勤終了時刻入力チェック
		if (!((zyuy.getYknkuKisi() == null && zyuy.getYknkuSyryu() == null)
				|| (zyuy.getYknkuKisi() != null && zyuy.getYknkuSyryu() != null))) {
			isTrue = false;
		}
		return isTrue;
	}

}
