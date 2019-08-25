/**
 * 
 */
angular.module('ex').controller('buildListCtrl', function(){
	console.log("buildList인입");
	$(document).ready(function(){
		location.href = "/buildList";
	});
})
.controller('accountBookCtrl', function(){
	console.log("accountBookCtrl 인입");
	$(document).ready(function(){
		location.href="/accountBook";
	});
})
.controller('barcodeCtrl', function(){
	console.log('barcodeCtrl 인입');
	$(document).ready(function(){
		location.href="/barcodeTest";
	});
})