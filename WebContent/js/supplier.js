
			//var error = document.getElementById("errorCaptcha")[0].innerHTML;
			
			var 		deliveryDate= document.getElementsByName("deliveryDate")[0];
			var 		port= document.getElementsByName("port")[0];
			var 		paymentTerm= document.getElementsByName("paymentTerm")[0];
			var 		companyName= document.getElementsByName("TblDetSupplier[comapny_name]")[0];
			var 		address= document.getElementsByName("TblDetSupplier[address]")[0];
			var 		city= document.getElementsByName("TblDetSupplier[city]")[0];
			var 		callCode= document.getElementsByName("TblDetSupplier[country_code]")[0];
			var 		areaCode= document.getElementsByName("TblDetSupplier[area_code]")[0];
			var 		CompanyWeb= document.getElementsByName("TblDetSupplier[website]")[0];
			var 		companyType= document.getElementsByName("TblDetSupplier[company_type]")[0];
			var 		companyCountry= document.getElementsByName("companyCountry")[0];
			var 		companyState= document.getElementsByName("TblDetSupplier[state]")[0];
			var 		companyZip= document.getElementsByName("TblDetSupplier[zip]")[0];
			var 		companyPhone= document.getElementsByName("TblDetSupplier[cmpny_contact_no]")[0];
			var 		establishYear= document.getElementsByName("TblDetSupplier[establish_year]")[0];
			var 		companyFax= document.getElementsByName("TblDetSupplier[fax]")[0];
			var 		contactSalution= document.getElementsByName("TblDetSupplier[salutation]")[0];
			
			var 		contactCallCode= document.getElementsByName("TblDetSupplier[country_code_mob]")[0];
			var 		contactMobile= document.getElementsByName("TblDetSupplier[mobile]")[0];
			var 		contactMessengerType= document.getElementsByName("TblDetSupplier[messenger_type]")[0];
			var 		contactFName= document.getElementsByName("TblDetSupplier[first_name]")[0];
			var 		contactMName= document.getElementsByName("TblDetSupplier[middle_name]")[0];
			var 		contactLName= document.getElementsByName("TblDetSupplier[last_name]")[0];
			var 		contactEmail= document.getElementsByName("TblDetSupplier[emailid]")[0];
			var 		designation= document.getElementsByName("TblDetSupplier[designation]")[0];
			var 		messengerId= document.getElementsByName("TblDetSupplier[messenger_id]")[0];

			
			var 		productName= document.getElementsByName("product_name");
			var 		productPrice= document.getElementsByName("price");
			var 		expecteds = document.getElementsByName("expected");
			var 		expectedQtys = document.getElementsByName("expectedQty");
			var p_ID = [];
			var expected = [];
			var expectedQty = [];
			
			messengerId.defaultValue = ""; 
	 		deliveryDate.defaultValue = ""; 
	 		port.defaultValue = ""; 
	 		paymentTerm.defaultValue = ""; 
	 		companyName.defaultValue = ""; 
	 		address.defaultValue = ""; 
	 		city.defaultValue = ""; 
	 		callCode.defaultValue = ""; 
	 		areaCode.defaultValue = ""; 
	 		CompanyWeb.defaultValue = ""; 
	 		companyType.defaultValue = ""; 
	 		companyCountry.defaultValue = ""; 
	 		companyState.defaultValue = ""; 
	 		companyZip.defaultValue = ""; 
	 		companyPhone.defaultValue = ""; 
	 		companyFax.defaultValue = ""; 
	 		 
	 		contactFName.defaultValue = "";
	 		contactCallCode.defaultValue = ""; 
	 		contactMobile.defaultValue = "";
	 		contactMessengerType.defaultValue = "";
	 		contactFName.defaultValue = ""; 
	 		contactMName.defaultValue = ""; 
	 		contactLName.defaultValue = ""; 
	 		contactEmail.defaultValue = ""; 
	 		designation.defaultValue = "";
	 		comments.defaultValue = ""; 
	 		
	 		for (i  = 0; i < expecteds.length;i++){
			expecteds[i].value == "";
				
		}
		for (i  = 0; i < expectedQtys.length;i++){
			
			expectedQtys[i].value == "";
				
			
		}
			function reset(){
				messengerId.value = ""; 
						 		deliveryDate.value = ""; 
						 		port.value = ""; 
						 		paymentTerm.value = ""; 
						 		companyName.value = ""; 
						 		address.value = ""; 
						 		city.value = ""; 
						 		callCode.value = ""; 
						 		areaCode.value = ""; 
						 		CompanyWeb.value = ""; 
						 		companyType.value = ""; 
						 		companyCountry.value = ""; 
						 		companyState.value = ""; 
						 		companyZip.value = ""; 
						 		companyPhone.value = ""; 
						 		companyFax.value = ""; 
						 		 
						 		contactFName.value = "";
						 		contactCallCode.value = ""; 
						 		contactMobile.value = "";
						 		contactMessengerType.value = "";
						 		contactFName.value = ""; 
						 		contactMName.value = ""; 
						 		contactLName.value = ""; 
						 		contactEmail.value = ""; 
						 		designation.value = "";
						 		comments.value = ""; 
			}
function submitOrder(){
	var verifyCode =   document.getElementsByName("verifyCode")[0].value;
	var vCode = document.getElementsByName("vCode")[0].value;

			if (productName.length ==0){
				alert("Empty Cart");
				return false;
			
			}
			if (expecteds !=null || expectedQtys != null){
				
			    
				for (i  = 0; i < expecteds.length;i++){
					expected.push(expecteds[i].value);
					if (expecteds[i].value == ""){
						alert("Please fill this field");
						expecteds[i].focus();
						return false;
					}
				}
				for (i  = 0; i < expectedQtys.length;i++){
					expectedQty.push(expectedQtys[i].value);
					if (expectedQtys[i].value == ""){
						alert("Please fill this field");
						expectedQtys[i].focus();
						return false;
					}
				}
				for (i  = 0; i < productName.length;i++){
					p_ID.push(productName[i].value);
					
				}
			}else{
				alert("Empty Cart");
			}

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
			
			if (contactCallCode == null ||contactCallCode.value == ""){
				alert("Please fill this field");
				contactCallCode.focus();
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
					deliveryCountry: establishYear.value,
					deliveryTerm: messengerId.value,
					deliveryDate: deliveryDate.value,
					port: port.value,
					paymentTerm: paymentTerm.value,
					companyName: companyName.value,
					address: address.value,
					city: city.value,
					callCode: callCode.value,
					areaCode: areaCode.value,
					CompanyWeb: CompanyWeb.value,
					companyType: companyType.value,
					companyCountry: companyCountry.value,
					companyState: companyState.value,
					companyZip: companyZip.value,
					companyPhone: companyPhone.value,
					companyPhone: companyPhone.value,
					companyFax: companyFax.value,
					contactSalution: contactSalution.value,
					contactCallCode: contactCallCode.value,
					contactMobile: contactMobile.value,
					contactMessengerType: contactMessengerType.value,
					contactFName: contactFName.value,
					contactMName: contactMName.value,
					contactLName: contactLName.value,
					contactEmail: contactEmail.value,
					contactMessengerID: designation.value,
					comments: comments.value,
					verifyCode: verifyCode.value,
					vCode: vCode.value,
					p_ID: p_ID,
					expected : expected,
					expectedQty : expectedQty,
			}
			  $.ajax({
	                 type: "POST",
	                 url: "createOrder",
	                 data: data,
	                 success: function () {
	              	   alert("Please check your email");
	                     location.reload();
	                 },
	                 error: function(xhr, textStatus, errorThrown){
	                	
		                alert(xhr.responseText);

	                	 
	                  }
	             });
			return true;
			//var deliveryCountry = document.getElementsByName("deliveryCountry");
			
}
		function removeCart(id){
			 var data = {
                     id: id,
                                          
             };
             
		        $.ajax({
                 type: "POST",
                 url: "removeCart",
                 data: data,
                 success: function () {
              	   //alert("Removed");
                     location.reload();
                 },
                 error: function(xhr, textStatus, errorThrown){
                     alert("There are some errors. Cannot removed now");
                  }
             });
		}
