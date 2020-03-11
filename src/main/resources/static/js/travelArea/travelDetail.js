function closeWin() {
	location.href="/travelArea/getTravelArea";
}
/**
 * 要求を送信する 出張地域情報の修正
 * @returns　なし
 */			
function toUpdateTravelArea() {
	$.ajax({
		type : "POST",
		url : "updateTravelAreaById",
		data : $('#frm').serialize(),
		success : function(message) {
			switch (message) {
				case "updateSucess" :
					alertMessage("更新に成功しました、戻りますか？", "2", 6);
					break;
				case "updateFail" :
					alertFailMessage("更新に失敗しました!", 5);
					break;
				case "errors":
					location.href = "/errorException";
					break;
				case message :
					$("#ERR_TOP").text(message);
					alertMessage("「はい」を押して戻る", "2", 0);
					break;
				default:
					break;
			}	
		},
		error : function() {
			systemErr();
		}
	});
}
/**
 * 要求を送信する 出張地域情報の追加
 * @returns なし
 */		
function toAddTravelArea(){
	$.ajax({
		type : "POST",
		url : "addTravelArea",
		data : $('#frm').serialize(),
		success : function(message) {
			switch (message) {
				case "insertSucess" :
					alertMessage("増加に成功しました、戻りますか？", "2", 6);
					break;
				case "insertFail" :
					alertFailMessage("増加に失敗しました!", 5);
					break;
				case "errors":
					location.href = "/errorException";
					break;
				default:
					break;
			}	
		},
		error : function() {
			systemErr();
		}
	});
}
/**
 * エラーメッセージを空にします
 * @returns なし
 */		
function clearErrorMsg() {
	$(".error").text("");
}
/**
 * ヒントボックス
 * @param title メッセージ
 * @param flag フラッグ どのような操作を実行するかを確認します。
 * @param iconItem　アイコン
 * @returns　なし
 */
function alertMessage(title, flag, iconItem) {
	parent.layer.alert (title, {
		skin : 'layui-layer-molv',
		time : 10000,
	 	icon : iconItem,
		btn : ['はい','いいえ'],
		yes : function () {
			action(flag);
		},
		btn2 : function() {
			layer.msg("キャンセル成功！");
		}
	});
}
/**
 * 削除/追加失敗 メッセージを表示
 * @param title メッセージ
 * @param iconItem アイコン
 * @returns なし
 */
function alertFailMessage(title,iconItem) {
	parent.layer.alert (title, {
		skin : 'layui-layer-molv',
		time : 10000,
	 	icon : iconItem,
	 	btn : ['はい']
	});
}
/**
 * どのような操作を実行するかを確認します
 * @param flag フラッグ
 * @returns　なし
 */
function action(flag) {
	switch (flag) {
		case "0" :
			toAddTravelArea();
			break;
		case "1" :
			toUpdateTravelArea();
			break;
		case "2" :
			closeWin();
			break;
		default :
			break;
	}	
}
/**
 * システムエラー
 * @returns　なし
 */
function systemErr() {
	parent.layer.alert("システムエラー、管理者を連絡してください ", {
		skin : 'layui-layer-molv',
		icon : 5
	});
}

$().ready(function() {
	//  0フォームを送信
	$("#frm").validate({
		submitHandler: function() {
			if ($("#travelAreaId").val() == null || $("#travelAreaId").val() =='') {
				alertMessage("データを追加しますか?", "0", 0);
			} else {
				alertMessage("変更を確定しますか?", "1", 0);
			}	
		},
		// 0画面入力項目チェック規
		rules: {
			// 0出張地域省単項目チェック
			provinceName: {	
				// 0出張地域省単項目必須チェック
				required: true
			},
			// 0出張地域市単項目チェック
			cityName: {
				// 0出張地域市単項目必須チェック
				required: true
			},
			// 0出張地域区/县単項目チェッ
			countryName: {
				// 0出張地域区/县単項目必須チェック
				required: true
			},
			// 0補助金単項目チェック
			travelMoneyStr: {
				// 0補助金単項目必須チェック
				required: true,
				// 0補助金単項目属性チェック
				checkTravelMoneyProperty: true,
				// 0補助金単項目範囲チェック 
				range: [0,9999999999.99]
			}
		},
		// 0画面入力項目単項目チェックエラーメッセージ
		messages: {
			provinceName: {
				// 0出張地域省単項目必須チェックでエラーが発生した場合、エラーメッセージ
				required: "出張地域省を入力してください" 
			},
			cityName: {
				// 0出張地域市単項目必須チェックでエラーが発生した場合、エラーメッセージ
				required: "出張地域市を入力してください" 
			},
			countryName: {
				// 0出張地域区/县単項目必須チェックでエラーが発生した場合、エラーメッセージ 
				required: "出張地域区/县を入力してください"
			},
			travelMoneyStr: {
				// 0補助金単項目必須チェックでエラーが発生した場合、エラーメッセージ 
				required: "補助金を入力してください" ,
				// 0補助金単項目範囲チェック 、エラーメッセージ 
				range: "補助金は0～9999999999.99の指定範囲内で入力してください"
			}
		},
		// 0設定エラーメッセージは画面項目の後に表示されます 
		errorPlacement: function(error, element) {
			error.appendTo(element.parent().parent());
		}
	});
	// 0補助金単項目属性チェック 
	$.validator.addMethod("checkTravelMoneyProperty",function(value,element,params) {
		// 0非負の数値正規表現
		var reg = /(^[1-9](\d+)?(\.\d+)?$)|(^0$)|(^\d\.\d+$)/;
		return this.optional(element)||(reg.test(value));
	},"補助金の値が非負半角数字ではありません");
}); 		

/**
 * Selectコンポーネントを隠す	
 * @returns なし
 */
$(function() {
	$(document).click(function(event) {
		var id = event.target.id;
		if(id != 'provinceArea' || id != 'cityArea' || id != 'countryArea') {
			$('#provinceArea').hide(); 
			$('#cityArea').hide();
			$('#countryArea').hide();
		}
   });
});
		
/**
 * 前のページに戻ります
 * @returns なし
 */
function closeWin() {
	/*history.go(-1);*/
	location.href="/travelArea/getTravelArea";
}