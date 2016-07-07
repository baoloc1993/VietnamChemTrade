
			//var error = document.getElementById("errorCaptcha")[0].innerHTML;
			
			
			var 		companyName= document.getElementsByName("companyName")[0];
		
			var 		callCode= document.getElementsByName("countryCode")[0];
			var 		areaCode= document.getElementsByName("areaCode")[0];
			
			var 		description= document.getElementsByName("description")[0];
			
			var 		link= document.getElementsByName("link")[0];
			var 		contactSalution= document.getElementsByName("salutation")[0];

			var 		contactLocation= document.getElementsByName("location")[0];
			var 		contactMobile= document.getElementsByName("phone")[0];
		
			var 		contactFName= document.getElementsByName("firstNm")[0];
			var 		contactMName= document.getElementsByName("middleNm")[0];
			var 		contactLName= document.getElementsByName("lastNm")[0];
			var 		contactEmail= document.getElementsByName("email")[0];
			var 		title= document.getElementsByName("title")[0];
			var 		date= document.getElementsByName("date")[0];
			
			companyName.defaultValue = ""; 
	 		
	 		
	 		callCode.defaultValue = ""; 
	 		areaCode.defaultValue = ""; 
	 		
	 		description.defaultValue = ""; 
	 		link.defaultValue = ""; 
	 		 
	 		contactFName.defaultValue = "";
	 		contactLocation.defaultValue = ""; 
	 		contactMobile.defaultValue = "";
	 		
	 		contactFName.defaultValue = ""; 
	 		contactMName.defaultValue = ""; 
	 		contactLName.defaultValue = ""; 
	 		contactEmail.defaultValue = ""; 
	 		title.defaultValut = "";
			
function reset(){
	deliveryTerm.value = ""; 
			 		
			 		companyName.value = ""; 
			 		address.value = ""; 
			 		
			 		callCode.value = ""; 
			 		areaCode.value = ""; 
			 		
			 		description.value = ""; 
			 		link.value = ""; 
			 		 
			 		contactFName.value = "";
			 		contactLocation.value = ""; 
			 		contactMobile.value = "";
			 		contactMessengerType.value = "";
			 		contactFName.value = ""; 
			 		contactMName.value = ""; 
			 		contactLName.value = ""; 
			 		contactEmail.value = ""; 
			 		title.value = "";
			 		
}
					
			 		
			 		
function addEvent(){
	var verifyCode =   document.getElementsByName("verifyCode")[0].value;

	var vCode = document.getElementsByName("vCode")[0].value;
			if (verifyCode != vCode){
				alert("Sai mã xác nhận");
				return false;
			}
			
			if (companyName == null || companyName.value == ""){
				alert("Bạn cần điền đủ thông tin");
				companyName.focus();
				return false;
			}
			
			if (callCode == null || callCode.value == ""){
				alert("Bạn cần điền đủ thông tin");
				callCode.focus();
				return false;
			}
			
			if (contactFName == null || contactFName.value == ""){
				alert("Bạn cần điền đủ thông tin");
				contactFName.focus();
				return false;
			}
			
			if (contactLocation == null ||contactLocation.value == ""){
				alert("Bạn cần điền đủ thông tin");
				contactLocation.focus();
				return false;
			}
			
			if (title == null ||title.value == ""){
				alert("Bạn cần điền đủ thông tin");
				title.focus();
				return false;
			}
			if (date == null ||date.value == ""){
				alert("Bạn cần điền đủ thông tin");
				date.focus();
				return false;
			}
			
			if (description == null ||description.value == ""){
				alert("Bạn cần điền đủ thông tin");
				description.focus();
				return false;
			}
			
			//alert(contactMobile.value);
			if (contactMobile == null || contactMobile.value == "" ||isNaN(contactMobile.value) ){
				alert("Điện thoại không hợp lệ");
				contactMobile.focus();
				return false;
			}
			
			if (contactEmail == null || contactEmail.value == "" || (contactEmail.value).indexOf("@") == -1){
				alert("Email không hợp lệ");
				contactEmail.focus();
				return false;
			}
			
			if (verifyCode == null || verifyCode.value == "" ){
				alert("Bạn cần điền đủ thông tin");
				companyName.focus();
				return false;
			}

			var data = {
					
					companyName: companyName.value,
					
					callCode: callCode.value,
					areaCode: areaCode.value,
					
					companyPhone: description.value,
					
					
					contactSalution: contactSalution.value,
					contactLocation: contactLocation.value,
					contactMobile: contactMobile.value,
					
					contactFName: contactFName.value,
					contactMName: contactMName.value,
					contactLName: contactLName.value,
					contactEmail: contactEmail.value,
					title : title.value,
					link: link.value,
					description: description.value,
					//verifyCode: verifyCode.value,
					date: date.value,
					//vCode: vCode.value,
					
			}
			  $.ajax({
	                 type: "POST",
	                 url: "addEvent",
	                 data: data,
	                 success: function () {
	              	   alert("Cảm ơn bạn");
	                     location.reload();
	                 },
	                 error: function(xhr, textStatus, errorThrown){
	                	
		                alert(Có lỗi xảy ra. Xin thử lại lần sau);

	                	 
	                  }
	             });
			return true;
			//var deliveryCountry = document.getElementsByName("deliveryCountry");
			
}
		
