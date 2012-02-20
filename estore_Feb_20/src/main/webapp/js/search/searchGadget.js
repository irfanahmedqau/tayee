$(document).ready(function() {
	Array.prototype.append = function(val) {
		var array = this;
		array.push(val);
		return array;
	};
	var forbidenWords = [];
	forbidenWords.append("这里输入搜索文本");
	forbidenWords.append("");
	function isSearchAble(keyWord) {
		if ($.inArray(keyWord, forbidenWords) < 0) {
			return true;
		}
		return false;
	}
	$(document).keydown(function() {
		if (event.keyCode == 13) {
			if (isSearchAble($("#topSearch").val())) {
				$("#topForm").submit();
			}
		}
	});
	$("#topForm").submit(function() {
		return isSearchAble($("#topSearch").val());
	});
	
	// For pagination jump control
	$(".gotPage a").click(function() {
		var input = $(this).next();
		if (input.val() >= 1 && input.val() <= input.attr("pages")) {
			$(this).attr("href", $(this).attr("url") + input.val());
		} else {
			$(this).attr("href", "javascript:void(0)");
		}
	});
});