package com.jinjikanri.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jinjikanri.entity.HKN0005LicenseEntity;
import com.jinjikanri.service.HKN0005LicenseService;


/**
 * 
 * @author 田柳　2020/01/08
 *
 */
@Controller
@RequestMapping(value = "/HKN0005LicenseEntity")
public class HKN0005LicenseController {
	@Autowired
	private HKN0005LicenseService hkn0005LicenseService;

	/**
	 * 
	 * @param hkn0005LicenseEntity
	 * @param pageIndex
	 * @param model
	 * @return 検索画面に検索ぼたんを押し、検索条件に応じてシャトルバスの情報ベースを問い合わせる。
	 * 
	 */
	@RequestMapping(value = "/selectBus")
	public String selectBus(HKN0005LicenseEntity hkn0005LicenseEntity, Integer pageIndex, Model model)
			throws Exception {
		/**
		 * 
		 * 車のナンバーの桁数は判断する。
		 * 車のナンバーの桁数が8桁以上、系统错误画面を表示する。
		 * 
		 */
		if (hkn0005LicenseEntity.getLicenseId() != null && hkn0005LicenseEntity.getLicenseId().length() > 8) {
			throw new Exception("系统错误");
		}
		
		/**
		 * 
		 * 運転手の名前の桁数は判断する。
		 * 運転手の名前の桁数が20桁以上、系统错误画面を表示する。
		 * 
		 */
		if (hkn0005LicenseEntity.getName() != null && hkn0005LicenseEntity.getName().length() > 20) {
			throw new Exception("系统错误");
		}
		
		/**
		 * 
		 * 連絡先の桁数は判断する。
		 * 連絡先の桁数が50桁以上、系统错误画面を表示する。
		 * 
		 */
		if (hkn0005LicenseEntity.getDestination() != null && hkn0005LicenseEntity.getDestination().length() > 50) {
			throw new Exception("系统错误");
		}
		
		
		/**
		 * 列表方法，带分页
		 */
		if (pageIndex == null) {
			pageIndex = 1;
		}

		Map<String, Object> result = this.hkn0005LicenseService.selectBus(hkn0005LicenseEntity, pageIndex);
		List<HKN0005LicenseEntity> busList = (List<HKN0005LicenseEntity>) result.get("busList");
		model.addAttribute("total", result.get("total"));
		model.addAttribute("pages", result.get("pages"));
		model.addAttribute("busList", busList);
		model.addAttribute("bus", hkn0005LicenseEntity);
		return "bus/busSearch";

	}

	/**
	 * 
	 * @param hkn0005LicenseEntity
	 * @param model
	 * @return 検索画面に詳細ボタンを押し、詳細画面に遷移する。
	 */
	@RequestMapping(value = "/busAdd")
	public String busAdd(HKN0005LicenseEntity hkn0005LicenseEntity, Model model) {
		model.addAttribute(hkn0005LicenseEntity);
		return "bus/busUpdate";
	}

	/**
	 * 
	 * @param hkn0005LicenseEntity
	 * @param model
	 * @return 更新画面に追加ボタンも変更ボタンを押する。 シャトルバスの情報を追加し、シャトルバスの情報を変更する。
	 */
	@RequestMapping(value = "/busInsert")
	@ResponseBody
	public String busInsert(HKN0005LicenseEntity hkn0005LicenseEntity, Model model) throws Exception {
		/**
		 * 
		 * 車のナンバーの入力は判断する。
		 * 車のナンバーが入力しない、系统错误画面を表示する。
		 * 
		 */
		if (hkn0005LicenseEntity.getLicenseId() == "") {
			throw new Exception("系统错误");
		} else {
			/**
			 * 
			 * 車のナンバーの桁数は判断する。
			 * 車のナンバーの桁数が8桁以上、系统错误画面を表示する。
			 * 
			 */
			if (hkn0005LicenseEntity.getLicenseId() != "" && hkn0005LicenseEntity.getLicenseId().length() > 8) {
				throw new Exception("系统错误");
			}
		}
		
		/**
		 * 
		 * 運転手の名前の桁数は判断する。
		 * 運転手の名前の桁数が20桁以上、系统错误画面を表示する。
		 * 
		 */
		if (hkn0005LicenseEntity.getName() != "" && hkn0005LicenseEntity.getName().length() > 20) {
			throw new Exception("系统错误");
		}
		
		/**
		 * 
		 * 従業員コードの入力は判断する。
		 * 従業員コードが入力しない、系统错误画面を表示する。
		 * 
		 */
		if (hkn0005LicenseEntity.getStaffCd() == null) {
			throw new Exception("系统错误");
		}
		
		/**
		 * 
		 * 車種の桁数は判断する。
		 * 車種の桁数が50桁以上、系统错误画面を表示する。
		 * 
		 */
		if (hkn0005LicenseEntity.getVehicleType() != "" && hkn0005LicenseEntity.getVehicleType().length() > 50) {
			throw new Exception("系统错误");
		}
		
		/**
		 * 
		 * 班次の入力は判断する。
		 * 班次が入力しない、系统错误画面を表示する。
		 * 
		 */
		if (hkn0005LicenseEntity.getClasses() == null) {
			throw new Exception("系统错误");
		}
		
		/**
		 * 
		 * シャトルバスの路線の入力は判断する。
		 * シャトルバスの路線が入力しない、系统错误画面を表示する。
		 * 
		 */
		if (hkn0005LicenseEntity.getCourse() == "" || hkn0005LicenseEntity.getCourse() == null) {
			throw new Exception("系统错误");
		}
		
		/**
		 * 
		 * 連絡先の入力は判断する。 
		 * 連絡先が入力しない、系统错误画面を表示する。
		 * 
		 */
		if (hkn0005LicenseEntity.getDestination() == "") {
			throw new Exception("系统错误");
		} else {
			/**
			 * 
			 * 連絡先の桁数は判断する。
			 * 連絡先が50桁以上、系统错误画面を表示する。
			 * 
			 */
			if (hkn0005LicenseEntity.getDestination() != "" && hkn0005LicenseEntity.getDestination().length() > 50) {
				throw new Exception("系统错误");
			}
		}
		
		/**
		 * 
		 * バスIDは存在しない。
		 * シャトルバスの情報を変更は判断する。
		 * 
		 */
		if (hkn0005LicenseEntity.getBusId() != null) {
			int str = this.hkn0005LicenseService.busUpdate(hkn0005LicenseEntity);
			if (str == 6) {
				/**
				 * バスIDは存在しない。
				 * 指定のバス号情報がシャトルバス情報テーブルに存在しません。
				 * 出力del。
				 */
				return "del";
			} else if (str == 3) {
				/**
				 * 指定情報が失効しました、更新してから送信してください。
				 * 出力alter。
				 */
				return "alter";
			} else if (str == 5) {
				/**
				 * バス情報は存在する。
				 * 指定の更新情報がシャトルバス情報テーブルに存在します。
				 *  出力exist。
				 */
				return "exist";
			}
		} else {
			/**
			 * バスIDは存在しない。
			 * シャトルバスの情報を追加は判断する。
			 */
			model.addAttribute("HKN0005LicenseEntity", hkn0005LicenseEntity);
			int str = this.hkn0005LicenseService.busInsert(hkn0005LicenseEntity);
			if (str == 5) {
				/**
				 * バス情報は存在する。
				 * 指定の更新情報がシャトルバス情報テーブルに存在します。
				 *  出力exist。
				 */
				return "exist";
			}
		}
		return "bus/busSearch";
	}

	/**
	 * 
	 * @param busId
	 * @param model
	 * @return バスIDは存在チェック。
	 * 
	 */
	@RequestMapping(value = "/selectBusById")
	public String selectBusById(Integer busId, Model model) {
		HKN0005LicenseEntity hkn0005LicenseEntity = new HKN0005LicenseEntity();
		if (busId != null) {
			/**
			 * バスIDは存在する。
			 * シャトルバス-更新画面にシャトルバスの情報を表示する。
			 */
			hkn0005LicenseEntity = this.hkn0005LicenseService.selectBusById(busId);
		}
		model.addAttribute(hkn0005LicenseEntity);
		return "bus/busUpdate";
	}

	/**
	 * 
	 * @param busId
	 * @return バスIDは存在チェック。
	 */
	@RequestMapping(value = "/validData", method = RequestMethod.POST)
	@ResponseBody
	public String validData(Integer busId) {
		try {
			HKN0005LicenseEntity str = this.hkn0005LicenseService.selectBusById(busId);
			if (str == null) {
				/**
				 * バスIDは存在しない。
				 * 指定のバス号情報がシャトルバス情報テーブルに存在しません。
				 * 出力false。
				 */
				return "false";
			}
			return "true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "errors";
		}
	}

	/**
	 * 
	 * @param busId
	 * @param model
	 * @return シャトルバスの情報の明細。
	 */
	@RequestMapping(value = "/busDetail")
	public String busDetail(Integer busId, Model model) {
		model.addAttribute(this.hkn0005LicenseService.selectBusById(busId));
		return "bus/busDetail";
	}

	/**
	 * 
	 * @param busId
	 * @param recKosnZituYmdHms
	 * @return シャトルバスの情報を削除は判断する。
	 */
	@RequestMapping(value = "/busDelete")
	@ResponseBody
	public String busDelete(Integer busId, Timestamp recKosnZituYmdHms) {
		try {
			int str = this.hkn0005LicenseService.busDelete(busId, recKosnZituYmdHms);
			if (str == 6) {
				/**
				 * バスIDは存在しない。
				 * 指定のバス号情報がシャトルバス情報テーブルに存在しません。
				 * 出力del。
				 */
				return "del";
			}
			return "true";
		} catch (Exception e) {
			e.printStackTrace();
			return "false";
		}
	}

}
