
			//var error = document.getElementById("errorCaptcha")[0].innerHTML;
			var 		productName = [""];
			var			productQty= [""];
			var 		productUnit= [""];
			var 		port= document.getElementsByName("destination_port")[0];
			var 		companyName= document.getElementsByName("company_name")[0];
			var 		address= document.getElementsByName("company_address")[0];
			var 		comments= document.getElementsByName("comments")[0];
			var 		companyCountry= document.getElementsByName("companyCountry")[0];
			
			var 		contactSalution= document.getElementsByName("salutation")[0];
			var 		contactCallCode= document.getElementsByName("country_code")[0];
			var 		contactMobile= document.getElementsByName("phone_number")[0];
		
			var 		contactFName= document.getElementsByName("first_name")[0];
			var 		contactMName= document.getElementsByName("middle_name")[0];
			var 		contactLName= document.getElementsByName("last_name")[0];
			var 		contactEmail= document.getElementsByName("email")[0];
			
			
			var 		p_IDs= document.getElementsByName("p_ID");
			var 		expecteds = document.getElementsByName("expected");
			var 		expectedQtys = document.getElementsByName("expectedQty");
			var p_ID = [];
			var expected = [];
			var expectedQty = [];
			
			
	 		port.defaultValue = ""; 
	 		companyName.defaultValue = ""; 
	 		address.defaultValue = ""; 
	 	
	 		companyCountry.defaultValue = "";
	 		contactFName.defaultValue = "";
	 		contactCallCode.defaultValue = ""; 
	 		contactMobile.defaultValue = "";
	 		
	 		contactFName.defaultValue = ""; 
	 		contactMName.defaultValue = ""; 
	 		contactLName.defaultValue = ""; 
	 		contactEmail.defaultValue = ""; 
	 		
	 		comments.defaultValue = ""; 
	 		
	 		for (i  = 0; i < expecteds.length;i++){
			expecteds[i].value == "";
				
		}

	 		function handleProduct(){
				//alert(productName.length);
				var i = 0;
				for (i = 0; i < productName.length;i++){
					var j = i;
					productName[i]= document.getElementById('product_name' + j).value;

					productQty[i] = document.getElementById('quantity' + j).value;
					productUnit[i] = document.getElementById('measurement' + j).value;
					//alert(document.getElementById('price' + j));

				}
			}
function reset(){
				
						 		port.value = ""; 
						 		companyName.value = ""; 
						 		address.value = ""; 
						 		contactFName.value = "";
						 		contactCallCode.value = ""; 
						 		contactMobile.value = "";
						 		contactFName.value = ""; 
						 		contactMName.value = ""; 
						 		contactLName.value = ""; 
						 		contactEmail.value = ""; 
						 		compnayCountry.value = "";
						 		comments.value = ""; 
			}
function submitEnquiry(){
	var verifyCode =   document.getElementsByName("verifyCode")[0].value;
	var vCode = document.getElementsByName("vCode")[0].value;

	
			var k = 0;
			for (k=0;k< productName.length;k++){
				if (document.getElementById('product_name' + k).value == ""){
					alert("Bạn cần điền đủ thông tin");
					document.getElementById('product_name' + k).focus();
					return;
				}
				
				
				
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
			handleProduct();
			var data = {
					
					port: port.value,
					companyCountry : companyCountry.value,
					companyName: companyName.value,
					address: address.value,
					
					contactSalution: contactSalution.value,
					contactCallCode: contactCallCode.value,
					contactMobile: contactMobile.value,
					
					contactFName: contactFName.value,
					contactMName: contactMName.value,
					contactLName: contactLName.value,
					contactEmail: contactEmail.value,
					
					comments: comments.value,
					
					
					productName : productName.join(","),
					productQty: productQty.join(","),
					productUnit: productUnit.join(","),
			}
			  $.ajax({
	                 type: "POST",
	                 url: "sendEnquiry",
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

