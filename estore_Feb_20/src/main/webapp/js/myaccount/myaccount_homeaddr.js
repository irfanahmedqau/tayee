
//Function.prototype.binding = function() {
//
//	if (arguments.length < 2 && typeof arguments[0] == "undefined")
//		return this;
//
//	var __method = this, args = jQuery.makeArray(arguments), object = args
//			.shift();
//
//	return function() {
//
//		return __method.apply(object, args.concat(jQuery.makeArray(arguments)));
//
//	};
//
//};
function modify(id){	

	$.ajax({
		type: "post",
		url: "getModifyHomeAddr",
		dataType: "json",
		data: {"id":id},
		success:function(response){
			
			$("#form_hidden").show();
			$("#country").empty();
			$("#country").append("<option>please select</option>");
			$("#country").append("<option selected value='"+response.country.id+"'>"+response.country.regionName+"</option>");
			$("#province").empty();
			$("#province").append("<option>please select</option>");
			$("#province").append("<option selected value='"+response.province.id+"'>"+response.province.regionName+"</option>");
			$("#province").show();
			$("#city").empty();
			$("#city").append("<option>please select</option>");
			$("#city").append("<option selected value='"+response.city.id+"'>"+response.city.regionName+"</option>");
			$("#city").show();
			$("#district").empty();
			$("#district").append("<option>please select</option>");
			$("#district").append("<option selected value='"+response.district.id+"'>"+response.district.regionName+"</option>");
			$("district").show();
			$("#detailAddress").val(response.detailAddress);
			$("#zipCode").val(response.zipCode);
			$("#mobilePhone").val(response.mobilePhone);
			$("#contact").val(response.contact);
			$("#homeaddr_id").val(response.id);
		},
	});
	$("#homeaddr_form").attr("action","modifyHomeAddress");

};



function new_homeaddress(){
	$("#homeaddr_form").attr("action","addHomeAddress");
	$("#detailAddress").val("");
	$("#zipCode").val("");
	$("#mobilePhone").val("");
	$("#contact").val("");
	$("#homeaddr_id").val("");
	$("#form_hidden").show();
//	$("#province").attr("disabled","disabled");
//	$("#city").attr("disabled","disabled");
//	$("#district").attr("disabled","disabled");
	$("#country").empty().append("<option>please select</option>");
	$("#province").empty().append("<option>please select</option>");
	$("#city").empty().append("<option>please select</option>");
	$("#district").empty().append("<option>please select</option>");
};


function cancle(){
	$("#form_hidden").hide();
};

//jQuery("#selectId").append("<option value='val'>"+text+"</option>");
//<form:option value="" path='country.id'></form:option>
function getAllCountries(){

	var maxIndex=$("#country option:last").attr("index");
	if(maxIndex>0) return;
	$.ajax({
		type:"post",
		url:"getCountries",
		data: {},
		dataType: "json",
		success: function(response){
			$.each(response,function(i,item){
				$("#country").append("<option value='"+item.id+"'>"+item.regionName+"</option>");
			});
		},
	});
}
////<form:option value="" path='country.id'></form:option>	
function selectedCountry(){
	$("#province").empty().append("<option>please select</option>");
	$("#city").empty().append("<option>please select</option>");
	$("#district").empty().append("<option>please select</option>");
	var id = $("#country").val();
	$.ajax({
		type: "post",
		url: "getProvinces",
		dataType: "json",
		data:{"id":id},
		success:function(response){
//			$("#province").removeAttr('disabled'); 
			$.each(response,function(i,item){
				$("#province").append("<option  value='"+item.id+"'>"+item.regionName+"</option>");
			});
			
		}
	});
};
////<form:option value="" path='country.id'></form:option>	
function selectedProvice(){
	$("#city").empty().append("<option>please select</option>");
	$("#district").empty().append("<option>please select</option>");
	var id = $("#province").val();
	$.ajax({
		type:"post",
		url:"getCities",
		dataType:"json",
		data:{"id":id},
		success:function(response){
//			$("#city").removeAttr('disabled'); 
			$.each(response,function(i,item){
				$("#city").append("<option  value='"+item.id+"'>"+item.regionName+"</option>");
			});
			$("#city").show();
		}
	});
};
function selectedCity(){
	$("#district").empty().append("<option>please select</option>");

	var id = $("#city").val();

	$.ajax({
		type:"post",
		url:"getDistricts",
		dataType:"json",
		data:{"id":id},
		success:function(response){
//			$("#district").removeAttr('disabled'); 
			$.each(response,function(i,item){
				$("#district").append("<option  value='"+item.id+"'>"+item.regionName+"</option>");
			});
			$("#district").show();
		},
	});
};

function selectedDistrict(){
	var district = $("#district").find('option:selected').text();
	if(district == "please select"){
		district="";
	}
	var region = $("#country").find('option:selected').text()
	+$("#province").find('option:selected').text()+$("#city").find('option:selected').text()
	+district;
	$("#detailAddress").val(region);
}

function checkRegion(){
	
	if($("#country").val()=="" || $("#province").val()=="" || $("#city").val()=="" || $("#district").val()==""){
		$("#region_error").html("配送区域不能为空");
		return false;
	}
	return true;
}

function checkHomeAddress(){
	
	if($("#detailAddress").val()==""){
		$("#detailAddress_error").html("详细地址不能为空");
		return false; 
	}
	$("#detailAddress_error").html("");
	return true;

}
function checkZipCode(){

	reg=/^\d+$/;
	if($("#zipCode").val()==""){
		$("#zipCode_error").html("邮政编码不能为空");
		return false;
		
	}
	if(!reg.test($("#zipCode").val())){
		$("#zipCode_error").html("格式错误");
		return false;
	}
	
	$("#zipCode_error").html("");
	return true;
}
function checkContact(){
	if($("#contact").val()==""){
		$("#contact_error").html("联系人不能为空");
		return false;
	}
	$("#contact_error").html("");
	return true;
}

function checkPhone(){
	if($("#linePhone").val()=="" && $("#mobilePhone").val()==""){
		return false;
	}
	return true;
}

function checkform(){
	if(checkRegion()&&checkHomeAddress()&&checkZipCode()&&checkContact()&&checkPhone()){
		$("#homeaddr_form").submit();
	}
	return false;
	
}














