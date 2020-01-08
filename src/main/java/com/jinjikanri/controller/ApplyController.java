package com.jinjikanri.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.resource.ResourceUrlEncodingFilter;

import com.jinjikanri.common.util.ErrorMessage;
import com.jinjikanri.common.util.Tools;
import com.jinjikanri.entity.JIN0003QbbgEntity;
import com.jinjikanri.service.ApplyService;

@Controller
public class ApplyController {
	@Autowired 
	ApplyService applyService;
	
	/**
	 * 申請画面に入る
	 * @param apply JIN0003QbbgEntityオブジェクト
	 * @param model Modelオブジェクト
	 * @return "apply/applyadd" 申請画面
	 */
	@RequestMapping("/applyAdd")
	public String applyLogin(JIN0003QbbgEntity apply,Model model) {
		model.addAttribute("apply", apply);
		model.addAttribute("flag", "2");
		
		return "apply/applyadd";
	}
	

	/**
	 * 追加または更新の実行
	 * @param apply JIN0003QbbgEntityオブジェクト
	 * @param model Modelオブジェクト
	 * @return
	 */
	@RequestMapping("/addApplyInfor")
	@ResponseBody
	public String addApplyInfor(JIN0003QbbgEntity apply,Model model) throws Exception {
		// 0変更者名前単項目必須チェック
		if (apply.getChangerName() == "" || apply.getChangerName() == null ) {
			throw new Exception("系统错误");
		}
		// 0変更内容単項目必須チェック
		if (apply.getChangeContent() == "" || apply.getChangeContent() == null ) {
			throw new Exception("系统错误");
		}
		// 0変更前単項目必須チェック
		if (apply.getChangeBefore() == "" || apply.getChangeBefore() == null ) {
			throw new Exception("系统错误");
		}
		// 0変更後単項目必須チェック
		if (apply.getChangeAfter() == "" || apply.getChangeAfter() == null ) {
			throw new Exception("系统错误");
		}
		// 0申請者名前単項目必須チェック
		if (apply.getApplicantName() == "" || apply.getApplicantName()== null ) {
			throw new Exception("系统错误");
		}
		// 0承認者名前単項目必須チェック
		if (apply.getConfirmName() == "" || apply.getConfirmName() == null ) {
			throw new Exception("系统错误");
		}
		
		// 0変更内容単項目桁数チェック
		if ("".equals(apply.getChangeContent())) {
			apply.setChangeContent(null);
		} else {
			if (apply.getChangeContent() != null && apply.getChangeContent().length() > 20) {
				throw new Exception("系统错误");
			}
		}
		// 0変更前単項目桁数チェック
		if ("".equals(apply.getChangeBefore())) {
			apply.setChangeBefore(null);
		} else {
			if (apply.getChangeBefore() != null && apply.getChangeBefore().length() > 120) {
				throw new Exception("系统错误");
			}
		}
		// 0変更後単項目桁数チェック
		if ("".equals(apply.getChangeAfter())) {
			apply.setChangeAfter(null);
		} else {
			if (apply.getChangeAfter() != null && apply.getChangeAfter().length() > 120) {
				throw new Exception("系统错误");
			}
		}
		
		// 0相関チェック　
		if(apply.getChangeAfter().equals(apply.getChangeBefore())) {
			throw new Exception("系统错误");
		}
		
		// 0根据id是否存在判断执行追加还是更新
		if (apply.getDateId() == null) {
			// 0执行追加
			apply.setApplicantState(0);
			apply.setConfirmState(0);
			apply.setRecSaksZituYmdHms(Tools.getSysDate());
			apply.setRecKosnZituYmdHms(Tools.getSysDate());
			applyService.addApplyInfor(apply);
			model.addAttribute("flag", "0");
			model.addAttribute("apply", apply);
			return "true";
			
		} else {
			// 0更新存在チェック
			JIN0003QbbgEntity  jin0003QbbgEntity= applyService.selApplyById(apply.getDateId());
			if(jin0003QbbgEntity == null) {
				return ErrorMessage.ERR0029();
			} else {
				// 0排他チェック
				JIN0003QbbgEntity  qbbgEntity= applyService.getDataByIdTime(apply.getDateId(), apply.getRecKosnZituYmdHms());
				if(qbbgEntity == null) {
					return ErrorMessage.ERR0048();
				} else {
					// 0执行更新
					apply.setApplicantState(1);
					apply.setConfirmState(0);
					apply.setRecKosnZituYmdHms(Tools.getSysDate());
					applyService.updateApply(apply);
					model.addAttribute("flag", "0");
					model.addAttribute("apply", apply);
					return "true";
				}
			}			
		}
	}
	
	/**
	 * jin0003qbbg表のデータの取得
	 * @param apply JIN0003QbbgEntityオブジェクト
	 * @param pageIndex 現在のページ
	 * @param model Modelオブジェクト
	 * @return "apply/applist" 人員情報変更申請一覧画面
	 */
	@RequestMapping("/getApplyList")
	public String getApplyList(JIN0003QbbgEntity apply, Integer pageIndex, Model model) {
		
		if (pageIndex == null) {
			pageIndex = 1;
		}
		Map<String, Object> result = this.applyService.getApplyList(apply, pageIndex);
		List<JIN0003QbbgEntity> applyList = (List<JIN0003QbbgEntity>) result.get("applyList");
		model.addAttribute("total", result.get("total"));
		model.addAttribute("pages", result.get("pages"));
		model.addAttribute("applyList", applyList);
		model.addAttribute("apply", apply);
		return "apply/applist";
	}
	
	/**
	 * jin0003qbbg表のデータの取得（履歴）
	 * @param apply JIN0003QbbgEntityオブジェクト
	 * @param pageIndex 現在のページ
	 * @param model Modelオブジェクト
	 * @return "apply/apphistory" 申請履歴一覧画面
	 */
	@RequestMapping("/getApplyHistory")
	public String getApplyHistory(JIN0003QbbgEntity apply, Integer pageIndex, Model model) {
		
		if (pageIndex == null) {
			pageIndex = 1;
		}
		Map<String, Object> result = this.applyService.getApplyHistory(apply, pageIndex);
		List<JIN0003QbbgEntity> applyHistory = (List<JIN0003QbbgEntity>) result.get("applyHistory");
		model.addAttribute("total", result.get("total"));
		model.addAttribute("pages", result.get("pages"));
		model.addAttribute("applyHistory", applyHistory);
		model.addAttribute("apply", apply);
		
		return "apply/apphistory";
	}
	
	/**
	 * 指定IDのデータ是否存在（編集）
	 * @param apply JIN0003QbbgEntityオブジェクト
	 * @param model Modelオブジェクト
	 * @return　"apply/applyadd"　人員情報変更申請画面
	 */
	@RequestMapping("/selApplyById")
	@ResponseBody
	public String selApplyById(Integer dateId,Model model) {
		
		try {
			JIN0003QbbgEntity apply = applyService.selApplyById(dateId);
			if(apply == null) {
				return "isNull";
			} else {
				model.addAttribute("apply", apply);
				model.addAttribute("flag", "0");
				return "true";
			}
		} catch (Exception e) {
			e.printStackTrace();
		    return "false";
		}
	}
	
	/**
	 * 指定IDのデータ取得（編集）
	 * @param apply JIN0003QbbgEntityオブジェクト
	 * @param model Modelオブジェクト
	 * @return　"apply/applyadd"　人員情報変更申請画面
	 */
	@RequestMapping("/seldataById")
	public String seldataById(Integer dateId,Model model) {
		JIN0003QbbgEntity apply = applyService.selApplyById(dateId);
		model.addAttribute("apply", apply);
		model.addAttribute("flag", "0");
		return "apply/applyadd";
	}
	
	/**
	 * 指定IDのデータの取得（明細）
	 * @param apply JIN0003QbbgEntityオブジェクト
	 * @param model Modelオブジェクト
	 * @return　"apply/applyadd"　人員情報変更申請画面
	 */
	@RequestMapping("/selById")
	public String selById(Integer dateId,Model model) {
		JIN0003QbbgEntity apply = applyService.selApplyById(dateId);
		model.addAttribute("apply", apply);
		model.addAttribute("flag", "1");
		return "apply/applyadd";
	}
	
	
	/**
	 * 指定IDのデータを削除します
	 * @param dateId 出張地域IDアレイ
	 * @param makeTime レコード更新実年月日時分秒アレイ
	 * @return 
	 */
	@RequestMapping("/delDate")
	@ResponseBody
	public String delDate(Integer dateId, Timestamp makeTime) {
		 try {
			// 0削除存在チェック
			JIN0003QbbgEntity  jin0003QbbgEntity= applyService.selApplyById(dateId);
			if(jin0003QbbgEntity == null) {
				return ErrorMessage.ERR0029();
			} else {
				// 0执行削除
				int str = this.applyService.delDate(dateId);
				return "true";
			} 
		} catch (Exception e) {
			e.printStackTrace();
		    return "false";
		}
	}
	
	
}



