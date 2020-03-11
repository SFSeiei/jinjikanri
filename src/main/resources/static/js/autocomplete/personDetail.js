function parseAuto(data) {
	var rows = [];
	for(var i = 0; i < data.length; i++){      
		rows[rows.length] = {
			data: data[i],
			value: data[i].name,
			result: data[i].idNumber
		};
	}      

	return rows;
};

function formatItem(row, i, max) {
	if (row.identity != 0 && row.identity != null && row.identity != "") {
		return  row.staffCd+"_"+row.name+"（"+row.idNumber+"）";
	} else {
		return  row.staffCd+"_"+row.name+"（"+row.idNumber+"）";
	}
};


function bindAutoComplete(inputID,callback){
	var autoOpt = {
			minChars: 1,
			max: 500,
			width: 250,
			selectFirst: false,
			matchSubset: false,
			matchContains: true,
			dataType: 'json',
			highlight: null,
			parse: parseAuto,
			formatItem: formatItem
		};
	$(inputID).autocomplete("/autoComplete/staffAutoComplete", autoOpt).result(function(event, data, formatted) {
		if(data && callback && jQuery.isFunction(callback))
			callback(data);
	});
}

