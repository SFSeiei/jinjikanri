package com.jinjikanri.service.impl;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jinjikanri.common.util.ErrorMessage;
import com.jinjikanri.common.util.Tools;
import com.jinjikanri.entity.HKN0003TravelAreaEntity;
import com.jinjikanri.mapper.HKN0003TravelAreaMapper;
import com.jinjikanri.service.HKN0003TravelAreaService;
/**
 * “出張地域の管理 ”の業務ロジック
 *@author 刁家豪 2019/12/17
 */
@Service
public class HKN0003TravelAreaServiceImpl implements HKN0003TravelAreaService {
	//	画面入力の出張地域省	
	private static String province;
	//	画面入力の出張地域市
	private static String city;
	//	画面入力の出張地域区/县
	private static String country;
	
	@Autowired
	private HKN0003TravelAreaMapper hkn0003TravelAreaMapper;
	/**
	 * 省市区によるhkn0003travelarea表のデータ
	 * @param travelArea HKN0003TravelAreamEntityオブジェクト
	 * @param offset 現在のページ
	 * @param limit ページあたりのデータ量
	 * @return result Map 出張地域検索画面で使うデータ
	 */
	@Override
	public  Map<String, Object> getTravelArea(HKN0003TravelAreaEntity travelArea,Integer offset,Integer limit) {
		Map<String, Object> result = new HashMap<String, Object>();
		//  0エラーフラグ
		boolean isTrue=true;
		//  0画面入力を取得した出張地域省	
		province=travelArea.getProvinceName();
		//  0画面入力を取得した出張地域市
		city=travelArea.getCityName();
		//  0画面入力を取得した出張地域区/县
		country=travelArea.getCountryName();
		//  0出張地域省項目相関チェック
		if (Tools.isNull(province)) {
			if (!Tools.isNull(city) || !Tools.isNull(country)) {
				result.put("isTrue",false);
				isTrue=false;
			}
		}
		//  0出張地域市項目相関チェック
		if (!Tools.isNull(province) && Tools.isNull(city)) {
			if (!Tools.isNull(country)) {
				result.put("isTrue",false);
				isTrue=false;
			}
		}
		
		if(isTrue) {
			//  0エラーが発生していません
			RowBounds rowBounds = new RowBounds(offset, limit);
			Page<Object> page = PageHelper.startPage(offset, limit);
			List<HKN0003TravelAreaEntity> travelAreaList = hkn0003TravelAreaMapper.getTravelArea(travelArea, rowBounds);
			long total = page.getTotal();
			int pages = page.getPages();
			result.put("travelAreaList", travelAreaList);
			result.put("total", total);
			result.put("pages", pages);
			result.put("isTrue",true);
		}else {
			//  0エラーが発生しました			
			result.put("total", 1);
			result.put("pages", 1);
		}
		return result;
	}
	/**
	 *出張地域IDに基づいて、出張地域情報を取得します
	 * @param travelAreaId 出张地域ID
	 * @return HKN0003TravelAreaEntity
	 */
	@Override
	public HKN0003TravelAreaEntity getTravelAreaById(Integer travelAreaId) {
		return hkn0003TravelAreaMapper.getTravelAreaById(travelAreaId);
	}
	/**
	 * ロット取得出張地域情報
	 * @param travelAreaIdList 出张地域IDリスト
	 * @return HKN0003TravelAreaEntity
	 */
	@Override
	public List<HKN0003TravelAreaEntity> selectTravelAreas(List<Integer> travelAreaIdList) {
		return hkn0003TravelAreaMapper.selectTravelAreas(travelAreaIdList);
	}
	/**
	 * DB排他用
	 * @param travelAreaId 出张地域ID
	 * @param recKosnZituYmdHms レコード更新実年月日時分秒
	 * @return HKN0003TravelAreaEntity
	 */
	@Override
	public HKN0003TravelAreaEntity getTravelAreaByIdAndUpdateTime(Integer travelAreaId, Timestamp recKosnZituYmdHms) {
		return hkn0003TravelAreaMapper.getTravelAreaByIdAndUpdateTime(travelAreaId, recKosnZituYmdHms);
	}
	/**
	   * 指定IDのデータを削除します
	 * @param travelAreaIdArray 出張地域IDアレイ
	 * @param updateTimeArray レコード更新実年月日時分秒アレイ
	 * @return message メッセージ
	 */
	@Override
	public String deleteTravelAreaById(Integer[] travelAreaIdArray, Timestamp[] updateTimeArray) {
		int travelAreaCount = 0;
		String message = null;
		//	0選択した出張地域情報の出張地域IDリスト	
		List<Integer> travelAreaIdList = Arrays.asList(travelAreaIdArray);
		//	0出張地域IDリストのサイズ	
		int travelAreaIdListSize = travelAreaIdList.size();
		//	0選択した出張地域情報の更新時間
		List<Timestamp> updateTimeList =Arrays.asList(updateTimeArray);
		//	0IDによると　出張地域情報を一括検索
		List<HKN0003TravelAreaEntity> travelAreaEntities = hkn0003TravelAreaMapper.selectTravelAreas(travelAreaIdList);
		//	0出張地域情報存在チェック (出張地域情報取得（抹消）チェック)
		if(travelAreaIdListSize == travelAreaEntities.size()) {
			//	0选中的出差地域情报都存在選択された出張地域情報は全部存在します		
			for(int i = 0; i < travelAreaIdListSize; i++) {
				HKN0003TravelAreaEntity travAre=hkn0003TravelAreaMapper.getTravelAreaByIdAndUpdateTime(travelAreaIdList.get(i),updateTimeList.get(i));
				if(travAre != null) {
					//	0データベースに修正されていない出張地域情報の存在数を記録する。				
					travelAreaCount++;
				}	
			}
			//	0選択された出張地域情報は修正されていません  (DB削除排他チェック)	
			if(travelAreaCount == travelAreaIdListSize) {
				int deleteLines = hkn0003TravelAreaMapper.deleteTravelAreaById(travelAreaIdList);
				if (deleteLines == travelAreaIdListSize) {
					//	0削除成功		
					message = "deleteSucess";
				} else {
					//	0削除失敗				
					message = "deleteFail";
				}
			} else {
				//	0選択された出張地域情報が修正されました			
				message = ErrorMessage.ERR0048();
			}
		}else {
			//	0選択された出張地域情報は存在しない場合があります、エラーメッセージ		
			message = ErrorMessage.ERR0029();
		}	
		return message;
	}
	/**
	 * hkn0003travelarea表のデータを修正します
	 * @param travelArea HKN0003TravelAreaEntityオブジェクト
	 * @return message メッセージ
	 */
	@Override
	public String updateTravelAreaById(HKN0003TravelAreaEntity travelArea){
		String message = null;
		//	0画面の出張地域IDを取得する		
		Integer travelAreaId = travelArea.getTravelAreaId();
		//	0画面の更新実年月日時分秒を取得する
		String updateDateStr = travelArea.getRecKosnZituYmdHmsStr();
		Timestamp updateDate = Tools.transStringToTimestamp(updateDateStr);
		//	0更新されたデータを検索
		HKN0003TravelAreaEntity travelAreaEntity=hkn0003TravelAreaMapper.getTravelAreaById(travelAreaId);
		if (travelAreaEntity == null) {
			//	0更新されたデータは存在しませんエラー
			message = ErrorMessage.ERR0029();
		} else {
				//	DB更新排他チェック
				HKN0003TravelAreaEntity travAre=hkn0003TravelAreaMapper.getTravelAreaByIdAndUpdateTime(travelAreaId,updateDate);
				if (travAre == null) {
					//	0更新排他エラー
					message = ErrorMessage.ERR0048();
				} else {
					//	0DB更新操作を実行する
					travelArea.setRecKosnZituYmdHms(Tools.getSysDate());
					travelArea.setTravelMoney(Tools.transStringToBigDecimal(travelArea.getTravelMoneyStr()));
					int updateLines = hkn0003TravelAreaMapper.updateTravelAreaById(travelArea);
					if (updateLines == 1) {
						//	0更新成功						
						message = "updateSucess";
					} else {
						//	0更新失敗						
						message = "updateFail";
					}
				}
		}
		return message;
	}
	/**
	 * hkn0003travelarea表にデータを追加します
	 * @param travelArea HKN0003TravelAreaEntityオブジェクト
	 * @return データの追加数
	 */
	@Override
	public int addTravelArea(HKN0003TravelAreaEntity travelArea) {
		return hkn0003TravelAreaMapper.addTravelArea(travelArea);
	}
}
