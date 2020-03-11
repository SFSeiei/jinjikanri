/**
 * 0検索にフォームを送信
 * @returns なし
 */
function toSubmit() {
	var isTrue = true;
	var errorMessage;
	var provinceName = $("#provinceName").val();
	var cityName = $("#cityName").val();
	var countryName = $("#countryName").val();	
	//  0出張地域省項目相関チェック
	if (provinceName == "") {
		if (cityName != "" || countryName != "") {
			errorMessage = "出張地域省が未入力の場合、出張地域市/出張地域区/县は入力できません";
			isTrue=false;
		}
	}
	//  0出張地域市項目相関チェック
	if (provinceName != "" && cityName == "") {
		if (countryName != "") {
			errorMessage = "出張地域市が未入力の場合、出張地域区/县は入力できません";
			isTrue=false;
		}
	}
	if(isTrue) {
		// 0フォームの送信		
		$("#frm").submit();
	} else {
		//	0エラーメッセージを表示
		$("#ERR_TOP").text(errorMessage);
	}	
}
/**
 * 0削除前の確認 
 * @returns	なし
 */
function isDelete() {
	var travelAreaIds = [];
	var checkboxes = $("input[name='checkboxChild']");
	var updateTimes = [];
	//	0選択したチェックボックスによって、出張地域情報IDと情報修正時間を獲得します
	for(var i = 0; i < checkboxes.length; i++) {
		var element = checkboxes[i];
		if(element.checked == true) {
			travelAreaIds.push(element.className);
			updateTimes.push($("input."+element.className+"[type='hidden']").val());
		}
	}
		
	if(travelAreaIds.length != 0) {
		//	0選択されたチェックボックスがあります	削除前の確認
		parent.layer.alert("削除しますか？", {
			//	0ヒントボックスのスタイル設定
			skin : 'layui-layer-molv',
			//	0ヒントボックス表示時間設定
			time : 10000,
			//	0メッセージボックス情報前ICONの設定
		 	icon : 0,
		 	//	0ヒントボックスボタンの設定
			btn : ['はい','いいえ'],
			yes : function() {
				//	0確認ボタンを押します
				sendDeleteRequest(travelAreaIds,updateTimes);
			},
			btn2 : function() {
				//	0キャンセルボタンを押します
				toSubmit();
			}
		});
	} else {
		//	0チェックボックスが選択されていません
		alertMessage("削除するアイテムがありません !", 0);
	}	
}
/**
 * 0削除操作を実行
 * @param travelAreaIds	出張地域情報ID
 * @param updateTimes	情報修正時間
 * @returns	なし
 */
function sendDeleteRequest(travelAreaIds,updateTimes) {
	$.ajax({
        type:'POST',
        url:"deleteTravelAreaById",
        traditional:true,
        data:{"travelAreaIdArray":travelAreaIds,"updateTimeArray":updateTimes},
        //	0送信成功
        success:function(message){
        	switch (message) {
				case "deleteSucess" :
					//	0削除に成功しました
					alertMessage("削除に成功しました!", 6);
					break;
				case "deleteFail" :
					//	0削除に失敗しました
					alertMessage("削除に失敗しました!", 5);
					break;
				case message:
					$("#ERR_TOP").text(message);
					alertMessage("「はい」を押して更新します！", 0);
					break;
				default:
					break;
        	}    	
        },
        //	0送信失敗
        error:  function(error) {
        	alertMessage("システムエラー、管理者を連絡してください ", 5); 
		}
    });
}	
/**
 * ヒントボックスに関する設定
 * @param title メッセージ
 * @param iconItem	メッセージボックス情報前ICON
 * @returns なし
 */
function alertMessage(title, iconItem) {
	parent.layer.alert(title, {
		skin : 'layui-layer-molv',
		time : 10000,
	 	icon : iconItem,
		btn : ['はい'],
		yes : function() {
			toSubmit();
		}
	});
}
/**
 * 0要求を送信する 
 * @returns なし
 */
function toTravelDetail(){
	location.href="/travelArea/toTravelDetail?"+$('#frm').serialize()+'';
}	
/**
 * 0要求を送信する	IDによって指定された出張地域情報を削除します
 * @param id	出張地域情報ID
 * @returns	なし
 */
function detail(id) {
	$.ajax({
        type:'GET',
        url:"isTravelAreaExist?travelAreaId="+id+"&"+$('#frm').serialize()+'',
        traditional:true,
        //	0送信成功
        success:function(message){
        	if(message == 'NOT NULL') {
        		location.href="/travelArea/getTravelAreaById?travelAreaId="+id;
        	} else {
        		$("#ERR_TOP").text(message);
        		alertMessage("「はい」を押して更新します！", 0);
        	}  	
        },
        //	0送信失敗
        error:  function(error) {
        	alertMessage("システムエラー、管理者を連絡してください ", 5); 
		}
    });
}
/**
 * エラーメッセージと入力框空にします
 * @returns なし
 */		
function clearText() {
	$(".error").text("");
	$(".input-text").val("");
}
	
function getParameter(name) { 
	var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); 
	var r = window.location.search.substr(1).match(reg); 
	if (r!=null) return unescape(r[2]); return null;
}
/**
 * init 改ページ
 * @returns	なし
 */
$(function(){
	var totalPage = $("#pages").val();
	var totalRecords = $("#total").val();
	var pageNo = getParameter('pageIndex');
	if(!pageNo){
		pageNo = 1;
	}
 	var provinceName = $("#provinceName").val(); 
 	var cityName = $("#cityName").val(); 
 	var countryName = $("#countryName").val(); 
	kkpager.generPageHtml({
		pno : pageNo,
		total : totalPage,
		totalRecords : totalRecords,
		hrefFormer : 'getTravelArea',
		hrefLatter : '?'+$('#frm').serialize()+'',
		getLink : function(n){
			return this.hrefFormer + this.hrefLatter + "&pageIndex="+n;
		}
	});
	//	selectの隠し
	$(document).click(function(event) {
		var id = event.target.id;
		if(id != 'checkbox_all' || id != 'provinceArea' || id != 'cityArea' || id != 'countryArea') {
			$('#provinceArea').hide(); 
			$('#cityArea').hide();
			$('#countryArea').hide();
		}
   });
});
