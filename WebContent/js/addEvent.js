
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
				alert("error captcha");
				return false;
			}
			
			if (companyName == null || companyName.value == ""){
				alert("Please fill this field");
				companyName.focus();
				return false;
			}
			
			if (callCode == null || callCode.value == ""){
				alert("Please fill this field");
				callCode.focus();
				return false;
			}
			
			if (contactFName == null || contactFName.value == ""){
				alert("Please fill this field");
				contactFName.focus();
				return false;
			}
			
			if (contactLocation == null ||contactLocation.value == ""){
				alert("Please fill this field");
				contactLocation.focus();
				return false;
			}
			
			if (title == null ||title.value == ""){
				alert("Please fill this field");
				title.focus();
				return false;
			}
			if (date == null ||date.value == ""){
				alert("Please fill this field");
				date.focus();
				return false;
			}
			
			if (description == null ||description.value == ""){
				alert("Please fill this field");
				description.focus();
				return false;
			}
			
			//alert(contactMobile.value);
			if (contactMobile == null || contactMobile.value == "" ||isNaN(contactMobile.value) ){
				alert("Incorrect number");
				contactMobile.focus();
				return false;
			}
			
			if (contactEmail == null || contactEmail.value == "" || (contactEmail.value).indexOf("@") == -1){
				alert("Please fill correct Email");
				contactEmail.focus();
				return false;
			}
			
			if (verifyCode == null || verifyCode.value == "" ){
				alert("Please fill this field");
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
	              	   alert("Thank you");
	                     location.reload();
	                 },
	                 error: function(xhr, textStatus, errorThrown){
	                	
		                alert(xhr.responseText);

	                	 
	                  }
	             });
			return true;
			//var deliveryCountry = document.getElementsByName("deliveryCountry");
			
}
		
