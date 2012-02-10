/*
$(function(){
	var url = "http://jqueryui.com/demos/autocomplete/search.php";
	var cache = {}, lastXhr;
	$("#topSearch").autocomplete({
		minLength: 2,
		source: function( request, response ) {
			var term = request.term;
			if( term in cache ) {
				response( cache[term] );
				return;
			}
			
			lastXhr = $.getJSON( url, request, function( data, status, xhr ) {
				cache[term] = data;
				if ( xhr === lastXhr ) {
					response( data );
				}
			});
		}
	});
});
*/

// These data are only for developing
$(function(){
	var testData = [
		"test1", "test2", "test3",
		"中文1", "中文2", "中文3"
	]
	$("#topSearch").autocomplete({
		source: testData
	});
});