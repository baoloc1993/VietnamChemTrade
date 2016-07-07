
			//var error = document.getElementById("errorCaptcha")[0].innerHTML;
			
			var deliveryCountry= document.getElementsByName("deliveryCountry")[0];
			
			var 		deliveryTerm= document.getElementsByName("deliveryTerm")[0];
			var 		deliveryDate= document.getElementsByName("deliveryDate")[0];
			var 		port= document.getElementsByName("port")[0];
			var 		paymentTerm= document.getElementsByName("paymentTerm")[0];
			var 		companyName= document.getElementsByName("companyName")[0];
			var 		address= document.getElementsByName("address")[0];
			var 		city= document.getElementsByName("city")[0];
			var 		callCode= document.getElementsByName("callCode")[0];
			var 		areaCode= document.getElementsByName("areaCode")[0];
			var 		CompanyWeb= document.getElementsByName("CompanyWeb")[0];
			var 		companyType= document.getElementsByName("companyType")[0];
			var 		companyCountry= document.getElementsByName("companyCountry")[0];
			var 		companyState= document.getElementsByName("companyState")[0];
			var 		companyZip= document.getElementsByName("companyZip")[0];
			var 		companyPhone= document.getElementsByName("companyPhone")[0];
			
			var 		companyFax= document.getElementsByName("companyFax")[0];
			var 		contactSalution= document.getElementsByName("contactSalution")[0];
			
			var 		contactCallCode= document.getElementsByName("contactCallCode")[0];
			var 		contactMobile= document.getElementsByName("contactMobile")[0];
			var 		contactMessengerType= document.getElementsByName("contactMessengerType")[0];
			var 		contactFName= document.getElementsByName("contactFName")[0];
			var 		contactMName= document.getElementsByName("contactMName")[0];
			var 		contactLName= document.getElementsByName("contactLName")[0];
			var 		contactEmail= document.getElementsByName("contactEmail")[0];
			var 		contactMessengerID= document.getElementsByName("contactMessengerID")[0];
			var 		comments= document.getElementsByName("comments")[0];
			var 		p_IDs= document.getElementsByName("p_ID");
			var 		expecteds = document.getElementsByName("expected");
			var 		expectedQtys = document.getElementsByName("expectedQty");
			var p_ID = [];
			var expected = [];
			var expectedQty = [];
			
			deliveryTerm.defaultValue = ""; 
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
	 		contactMessengerID.defaultValue = "";
	 		comments.defaultValue = ""; 
	 		
	 		for (i  = 0; i < expecteds.length;i++){
			expecteds[i].value == "";
				
		}
		for (i  = 0; i < expectedQtys.length;i++){
			
			expectedQtys[i].value == "";
				
			
		}
			function reset(){
				deliveryTerm.value = ""; 
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
						 		contactMessengerID.value = "";
						 		comments.value = ""; 
			}
function submitOrder(){
	var verifyCode =   document.getElementsByName("verifyCode")[0].value;
	var vCode = document.getElementsByName("vCode")[0].value;

			if (p_IDs.length ==0){
				alert("Empty Cart");
				return false;
			
			}
			if (expecteds !=null || expectedQtys != null){
				
			    
				for (i  = 0; i < expecteds.length;i++){
					expected.push(expecteds[i].value);
					if (expecteds[i].value == ""){
						alert("Bạn cần điền đủ thông tin");
						expecteds[i].focus();
						return false;
					}
				}
				for (i  = 0; i < expectedQtys.length;i++){
					expectedQty.push(expectedQtys[i].value);
					if (expectedQtys[i].value == ""){
						alert("Bạn cần điền đủ thông tin");
						expectedQtys[i].focus();
						return false;
					}
				}
				for (i  = 0; i < p_IDs.length;i++){
					p_ID.push(p_IDs[i].value);
					
				}
			}else{
				alert("Giỏ hàng rỗng");
			}

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
			
			if (contactCallCode == null ||contactCallCode.value == ""){
				alert("Bạn cần điền đủ thông tin");
				contactCallCode.focus();
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
					deliveryCountry: deliveryCountry.value,
					deliveryTerm: deliveryTerm.value,
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
					contactMessengerID: contactMessengerID.value,
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
	              	   alert("Cảm ơn bạn. Xin kiểm tra email.");
	                     location.reload();
	                 },
	                 error: function(xhr, textStatus, errorThrown){
	                	
		                alert("Có lỗi xảy ra. Xin thử lại lần sau");

	                	 
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
                     alert("Có lỗi xảy ra. Xin thử lại lần sau");
                  }
             });
		}
