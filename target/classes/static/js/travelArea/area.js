/**
 * 省を獲得する
 * @returns なし
 */
function getProvince(){
	$("#cityArea").hide();
	$("#countryArea").hide();
	$("#provinceArea").empty();
	$.ajax({
		type : "POST",
		url : "getProvince",
		success : function(areaArray) {
			if (areaArray != null && areaArray.length > 0) {
				$("#ERR_PROVINCE").text("");
				$("#provinceArea").show();
				for(index in areaArray) {
					$("#provinceArea").append("<option value='" + areaArray[index].areaId + "'>" + areaArray[index].areaName + "</option>");	
				}	
			} else {
				$("#ERR_PROVINCE").text("該当データがありません");
			}
		},
		error : function() {
			parent.layer.alert("システムエラー、管理者を連絡してください ", {
				skin : 'layui-layer-molv'
			});
		}
	});
}
/**
 * 市/区/县を獲得する
 * @param areaSelectId	保存区/县のselectコンポーネントのID
 * @param parentIdName	父IDを保存する空件ID
 * @returns　なし
 */
function getCityOrCountry(areaSelectId,parentIdName){
	var parentId = $("#"+parentIdName).val();
	if(areaSelectId == "cityArea") {
		$("#provinceArea").hide();
		$("#countryArea").hide();
	}
	if(areaSelectId == "countryArea") {
		$("#provinceArea").hide();
		$("#cityArea").hide();		
	}		
	if (parentId != null && parentId != '') {
		sendRequest(areaSelectId,parentId,parentIdName);
	}			
}
/**
 * 要求を送信する
 * @param areaSelectId	保存区/县のselectコンポーネントのID
 * @param parentId	父ID
 * @param parentIdName	父IDを保存する空件ID
 * @returns	なし
 */		
function sendRequest(areaSelectId,parentId,parentIdName) {
	$.ajax({
		type : "POST",
		url : "getCityOrCountry?parentId="+parentId,
		success : function(areaArray) {
			if (areaArray != null && areaArray.length > 0) {
				if(parentIdName == "provinceId") {							
					$("#ERR_CITY").text("");
				} else {
					$("#ERR_COUNTRY").text("");
				}		
				$("#"+areaSelectId).show();
				$("#"+areaSelectId).empty();
				for(index in areaArray){
					$("#"+areaSelectId).append("<option value='" + areaArray[index].areaId + "'>" + areaArray[index].areaName + "</option>");	
				}
			} else {
				if(parentIdName == "provinceId") {							
					$("#ERR_CITY").text("該当データがありません");
				} else {
					$("#ERR_COUNTRY").text("該当データがありません");
				}
			}
		},
		error : function() {
			parent.layer.alert("システムエラー、管理者を連絡してください ", {
				skin : 'layui-layer-molv'
			});
		}
	});
}
/**
 * 出張地域の設定
 * @param areaNameTextId 出張地域入力枠ID
 * @param areaSelectId	保存区/县のselectコンポーネントのID
 * @param areaIdTextId IDを保存する空件ID
 * @returns なし
 */		
function setAreaText(areaNameTextId,areaSelectId,areaIdTextId){
	$("#"+areaNameTextId).val($("#"+ areaSelectId +" option:selected").text());
	$("#"+areaIdTextId).val($("#"+areaSelectId).val());
	$("#"+areaSelectId).css("display","none");
}
/**
 * テキストを空にする
 * @param areaSelectId
 * @param areaId
 * @returns　なし
 */		
function clearChild(areaSelectId,areaId){
	if ($("#"+areaSelectId).val() !=  $("#"+areaId).val()){
		switch (areaSelectId) {
			case "provinceArea" :
				$("#cityName").val("");
				$("#cityId").val("");
				$("#countryName").val("");
				break;
			case "cityArea" :
				$("#countryName").val("");
				break;
			default:
				break;
		}
	}
}