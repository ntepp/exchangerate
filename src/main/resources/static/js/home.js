$(document).ready(function() {
	$("#baseAmount").keyup(function() {
		updateTarget();
	});

	$("#baseCurrency").change(function() {
		updateTarget();
	});

	$("#targetCurrency").change(function() {
		updateTarget();
	});
	
});

function updateTarget(){
	/*$(".spinner-border").show();*/
	$.ajax({
		url : '/transaction',
		type : 'post',
		data: JSON.stringify(
            {baseAmount: $("#baseAmount").val(), baseCurrency: $("#baseCurrency").val(), targetCurrency:$("#targetCurrency").val()}
        ),
        contentType: "application/json; charset=utf-8",
        dataType   : "json",
		success : function(data) {
			$("#targetAmount").val(data["targetAmount"]);
			$(".spinner-border").hide();
		}
	});
}