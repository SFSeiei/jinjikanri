package com.jinjikanri.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;


import com.jinjikanri.entity.HKN0003TravelAreaEntity;
/**
 * ビジネスロジックインターフェース
 * @author 刁家豪　2020/01/10
 */
public interface HKN0003TravelAreaService {
	/**
	 * 省市区によるhkn0003travelarea表のデータ
	 * @param travelArea HKN0003TravelAreamEntityオブジェクト
	 * @param offset 現在のページ
	 * @param limit ページあたりのデータ量
	 */
	public Map<String, Object> getTravelArea(HKN0003TravelAreaEntity travelArea,Integer offset,Integer limit);
	/**
	 *出張地域IDに基づいて、出張地域情報を取得します
	 * @param travelAreaId 出张地域ID
	 */
	public HKN0003TravelAreaEntity getTravelAreaById(Integer travelAreaId);
	/**
	 * ロット取得出張地域情報
	 * @param travelAreaIdList 出张地域IDリスト
	 */
	public List<HKN0003TravelAreaEntity> selectTravelAreas(List<Integer> travelAreaIdList);
	/**
	 * DB排他用
	 * @param travelAreaId 出张地域ID
	 * @param recKosnZituYmdHms レコード更新実年月日時分秒
	 */
	public HKN0003TravelAreaEntity getTravelAreaByIdAndUpdateTime(Integer travelAreaId,Timestamp recKosnZituYmdHms);
	/**
	 * 指定IDのデータを削除します
	 * @param travelAreaIdArray 出張地域IDアレイ
	 * @param updateTimeArray レコード更新実年月日時分秒アレイ
	 */
	public String deleteTravelAreaById(Integer[] travelAreaIdArray, Timestamp[] updateTimeArray);
	/**
	 * hkn0003travelarea表のデータを修正します
	 * @param travelArea HKN0003TravelAreaEntityオブジェクト
	 */
	public String updateTravelAreaById(HKN0003TravelAreaEntity travelArea);
	/**
	 * hkn0003travelarea表にデータを追加します
	 * @param travelArea HKN0003TravelAreaEntityオブジェクト
	 */
	public int addTravelArea(HKN0003TravelAreaEntity travelArea);
}
