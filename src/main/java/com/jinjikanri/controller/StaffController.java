package com.jinjikanri.controller;

import java.sql.Timestamp;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jinjikanri.common.util.ErrorMessage;
import com.jinjikanri.common.util.StaffCheck;
import com.jinjikanri.common.util.Tools;
import com.jinjikanri.entity.JIN0002StaffEntity;
import com.jinjikanri.service.StaffService;

/**
 * 人員基本情報の設定コントローラ
 * @author 陳俊霖 2019/12/27
 */
@Controller
@RequestMapping("/staff")
public class StaffController {

	@Autowired
	private StaffService staffService;

	/**
	 * 人員基本情報全部検索改ページ表示
	 * @param staffEntity 人員基本情報
	 * @param pageIndex ページ番号
	 * @param model モデル
	 * @return staff/list 検索一覧画面
	 */
	@RequestMapping(value = "/selectStaffs")
	public String selectStaffs(
			JIN0002StaffEntity staffEntity, Integer pageIndex, Model model) {
		if (pageIndex == null) {
			pageIndex = 1;
		}
		Map<String, Object> result =
				staffService.selectStaffs(staffEntity, pageIndex);
		model.addAttribute("total", result.get("total"));
		model.addAttribute("pages", result.get("pages"));
		model.addAttribute("staffList", result.get("staffList"));
		model.addAttribute("staffEntity", staffEntity);
		return "staff/list";
		
	}

	/**
	 * 人員基本情報詳細ディスプレイ
	 * @param staffCd 従業員コード
	 * @param model モデル
	 * @return staff/update 追加/変更画面
	 */
	@RequestMapping("/loginstaff")
	public String loginstaff(Integer staffCd, Model model) {
		JIN0002StaffEntity staffEntity =
				new JIN0002StaffEntity();
		// 变更の場合、人員基本情報ディスプレイ
		if (staffCd != null) {
			staffEntity = staffService.selectstaff(staffCd);
		}
		model.addAttribute("staffEntity", staffEntity);
		return "staff/update";
	}

	/**
	 * 人員基本情報詳細ディスプレイ
	 * @param staffCd 従業員コード
	 * @param model モデル
	 * @return staff/update 追加/変更画面
	 */
	@RequestMapping("/isStaffExist")
	@ResponseBody
	public String isStaffExist(Integer staffCd, Model model) {
		JIN0002StaffEntity staffEntity =
				new JIN0002StaffEntity();
		// 变更の場合、人員基本情報ディスプレイ
		staffEntity = staffService.selectstaff(staffCd);
		if (staffEntity != null) {
			model.addAttribute("staffEntity", staffEntity);
			return "true";
		} else {
			String err = String.valueOf(staffCd) + ErrorMessage.ERR0021("該人員基本情報");
			return err;
		}
	}

	/**
	 * 人員基本情報追加または变更の実行
	 * @param staffEntity 人員基本情報
	 * @param model モデル
	 * @return staff/list 検索一覧画面
	 * @throws Exception 
	 */
	@RequestMapping("/toUpdateStaff")
	@ResponseBody
	public String insertStaff(JIN0002StaffEntity staffEntity, Model model) throws Exception {
			//  エラーフラグ
			boolean isTrue = StaffCheck.doTanKoumokuCheck(staffEntity);
			String koumokuSoukanCheck = StaffCheck.doKoumokuSoukanCheck(staffEntity);
			Integer staffCd = staffEntity.getStaffCd();
			if(!isTrue) {
				//	システム異常
				throw new Exception("系统错误");
			} else {
				if (koumokuSoukanCheck == "true") {
					// 变更の場合、対応の人員基本情報更新
					if (staffCd != null) {
						if (staffService.selectstaff(staffCd) != null) {
							Timestamp timestamp = Tools.transStringToTimestamp(staffEntity.getKosnzituymdhms());
							if (staffService.selectstafftime(staffCd, timestamp)) {
								staffEntity.setReckosnzituymdhms(Tools.getSysDate());
								staffService.updatestaff(staffEntity);
							} else {
								// 更新排他エラー
								return ErrorMessage.ERR0048();
							}
						} else {
							//更新されたデータは存在しませんエラー
							return ErrorMessage.ERR0021("該人員基本情報");
						}
					// 追加の場合、人員基本情報追加
					} else {
						if (staffService.selectstaffid(
								staffEntity.getIdNumber()) != null) {
							return ErrorMessage.ERR0020("該人員基本情報");
						}
						staffEntity.setRecsakszituymdhms(Tools.getSysDate());
						staffEntity.setReckosnzituymdhms(Tools.getSysDate());
						staffService.insertStaff(staffEntity);
					}
					staffEntity = new JIN0002StaffEntity();
					this.selectStaffs(staffEntity, 1, model);
					return "true";
				} else {
					return koumokuSoukanCheck;
				}
				
			}
	}

	/**
	 * 人員基本情報削除の実行
	 * @param staffCd 従業員コード
	 * @param model モデル
	 * @return staff/list 検索一覧画面
	 */
	@RequestMapping("/deletestaff")
	@ResponseBody
	public String delstaff(
			@RequestParam("staffCd") Integer staffCd,
			String reckosnzituymdhms,
			Model model) {
		JIN0002StaffEntity staffEntity = new JIN0002StaffEntity();
		// 人員基本情報取得（抹消）
		if (staffService.selectstaff(staffCd) != null) {
			staffService.delectstaff(staffCd);
			this.selectStaffs(staffEntity, 1, model);
			return "true";
		} else {
			String err = String.valueOf(staffCd) + ErrorMessage.ERR0021("該人員基本情報");
			return err;
		}
	}
}
