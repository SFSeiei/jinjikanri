package com.jinjikanri.service.impl;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.jinjikanri.common.util.Tools;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jinjikanri.common.constant.ItemConstant;
import com.jinjikanri.entity.HKN0005LicenseEntity;
import com.jinjikanri.mapper.HKN0005LicenseMapper;
import com.jinjikanri.service.HKN0005LicenseService;

@Service
public class HKN0005LicenseServiceImpl implements HKN0005LicenseService {
	@Autowired
	private HKN0005LicenseMapper hkn0005LicenseMapper;

	/* シャトルバスの情報を検索する。 */
	@Override
	public Map<String, Object> selectBus(HKN0005LicenseEntity hkn0005LicenseEntity, int offset) {
		Map<String, Object> result = new HashMap<String, Object>();
		RowBounds rowBounds = new RowBounds(offset, ItemConstant.PAGE_LIMIT);
		Page<Object> page = PageHelper.startPage(offset, ItemConstant.PAGE_LIMIT);
		List<HKN0005LicenseEntity> busList = this.hkn0005LicenseMapper.selectBus(hkn0005LicenseEntity, rowBounds);
		long total = page.getTotal();
		int pages = page.getPages();
		result.put("busList", busList);
		result.put("total", total);
		result.put("pages", pages);
		return result;
	}

	/* バスIDは存在チェック。 */
	@Override
	public HKN0005LicenseEntity selectBusById(Integer busId) {
		/* バスIDは存在チェック、値をControllerのvalidDataに伝える。 */
		HKN0005LicenseEntity selectBusById = this.hkn0005LicenseMapper.selectBusById(busId);
		if (selectBusById == null) {
			/* バスIDは存在しない。 */
			return null;
		}
		/* バスIDは存在する。 */
		return this.hkn0005LicenseMapper.selectBusById(busId);
	}

	/* シャトルバスの情報を追加する。 */
	@Override
	public int busInsert(HKN0005LicenseEntity hkn0005LicenseEntity) {
		/* 更新画面で取得した班次の入力値。 */
		Integer classes = hkn0005LicenseEntity.getClasses();
		/* 更新画面で取得した従業員コードの入力値。 */
		Integer staffCd = hkn0005LicenseEntity.getStaffCd();
		/* 更新画面で取得した車のナンバーの入力値。 */
		String licenseId = hkn0005LicenseEntity.getLicenseId();

		/* selectBusIdから入力値を取得する。 */
		List<HKN0005LicenseEntity> selectBusId = this.hkn0005LicenseMapper.selectBusId(classes, staffCd, licenseId);
		/* シャトルバスの情報は存在チェック、値をControllerのbusInsertに伝える。 */
		if (selectBusId != null && selectBusId.size() > 0) {
			/* シャトルバスの情報は存在し、出力5。 */
			return 5;
		}
		/* バス情報は存在しない。 */
		/* レコード作成実年月日時分秒を自動取得する。 */
		hkn0005LicenseEntity.setRecSaksZituYmdHms(Tools.getSysDate());
		/* レコード更新実年月日時分秒を自動取得。 */
		hkn0005LicenseEntity.setRecKosnZituYmdHms(Tools.getSysDate());
		/* busInsertを返する。 */
		return this.hkn0005LicenseMapper.busInsert(hkn0005LicenseEntity);
	}

	/* シャトルバスの情報を変更する。 */
	@Override
	public int busUpdate(HKN0005LicenseEntity hkn0005LicenseEntity) {
		/* 更新画面で取得したバス号の入力値。 */
		Integer busId = hkn0005LicenseEntity.getBusId();
		/* 更新画面で取得したレコード更新実年月日時分秒の入力値。 */
		Timestamp recKosnZituYmdHms = hkn0005LicenseEntity.getRecKosnZituYmdHms();
		/* 更新画面で取得した班次の入力値。 */
		Integer classes = hkn0005LicenseEntity.getClasses();
		/* 更新画面で取得した従業員コードの入力値。 */
		Integer staffCd = hkn0005LicenseEntity.getStaffCd();
		/* 更新画面で取得した車のナンバーの入力値。 */
		String licenseId = hkn0005LicenseEntity.getLicenseId();

		/* バスIDは存在チェック、値をControllerのbusUpdateに伝える。 */
		HKN0005LicenseEntity selectBusById = this.selectBusById(busId);
		if (selectBusById == null) {
			/* バスIDは存在しない、出力6。 */
			return 6;
		} else {
			/* バスIDは存在し、DBチェック、値をControllerのbusUpdateに伝える。 */
			HKN0005LicenseEntity selectDB = this.hkn0005LicenseMapper.selectDB(busId, recKosnZituYmdHms);
			if (selectDB == null) {
				/* シャトルバスの情報が変更され、出力3。 */
				return 3;
			} else {
				/* バスIDは存在し、シャトルバスの情報が変更さらない、バス情報は存在チェック、値をControllerのbusUpdateに伝える。 */
				List<HKN0005LicenseEntity> selectBusId = this.hkn0005LicenseMapper.selectBusId(classes, staffCd,
						licenseId);
				if (selectBusId != null && selectBusId.size() > 0) {
					/* シャトルバスの情報は存在し、出力5。 */
					return 5;
				} else {
					/* レコード更新実年月日時分秒を自動取得する。 */
					hkn0005LicenseEntity.setRecKosnZituYmdHms(Tools.getSysDate());
					/* busUpdateを返する。 */
					return this.hkn0005LicenseMapper.busUpdate(hkn0005LicenseEntity);
				}
			}
		}
	}

	/* シャトルバスの情報を削除する。 */
	@Override
	public int busDelete(Integer busId, Timestamp recKosnZituYmdHms) {
		HKN0005LicenseEntity selectBusById = this.selectBusById(busId);
		/* バスIDは存在チェック、値をControllerのbusDeleteに伝える。 */
		if (selectBusById == null) {
			/* バスIDは存在しない、出力6。 */
			return 6;
		}
		/* バスIDは存在し、busDeleteを返する。 */
		return this.hkn0005LicenseMapper.busDelete(busId, recKosnZituYmdHms);
	}

	/* DBチェック。 */
	@Override
	public HKN0005LicenseEntity selectDB(Integer busId, Timestamp recKosnZituYmdHms) {
		return this.hkn0005LicenseMapper.selectDB(busId, recKosnZituYmdHms);
	}

	/* シャトルバスの情報は存在チェック。 */
	@Override
	public Map<Integer, String> selectBusId(Integer classes, Integer staffCd, String licenseId) {
		return this.selectBusId(classes, staffCd, licenseId);
	}

}
