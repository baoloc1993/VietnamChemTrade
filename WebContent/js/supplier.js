
			//var error = document.getElementById("errorCaptcha")[0].innerHTML;
			var productName = [""];
			var productPrice= [""];
			var productSample= [""];		
			var 		messengerId = document.getElementsByName("TblDetSupplier[messenger_id]")[0];
			var 		deliveryTerm =  document.getElementsByName("TblDetSupplier[delivery_term]")[0];
			var 		deliveryDate= document.getElementsByName("TblDetSupplier[days_to_deliver]")[0];
			var 		port= document.getElementsByName("TblDetSupplier[loading_port]")[0];
			var 		paymentTerm= document.getElementsByName("TblDetSupplier[payment_term]")[0];
			var 		companyName= document.getElementsByName("TblDetSupplier[company_name]")[0];
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
			var 		comments= document.getElementsByName("TblDetSupplier[comments]")[0];


//			
//			var 		productName= document.getElementsByName("product_name");
//			var 		productPrice= document.getElementsByName("price");
//			var 		productSample = 
//			var 		expecteds = document.getElementsByName("expected");
//			var 		expectedQtys = document.getElementsByName("expectedQty");
//			var p_ID = [];
//			var expected = [];
//			var expectedQty = [];
			
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
			
			/**
			 * Function run when click addProduct in form
			 */
			function addProduct(){
				productName.push("");
				productPrice.push("");
				productSample.push("");
			}
			
			function handleProduct(){
				//alert(productName.length);
				var i = 0;
				for (i = 0; i < productName.length;i++){
					var j = i+1;
					productName[i]= document.getElementById('product_name' + j).value;

					productPrice[i] = document.getElementById('price' + j).value;
					//alert(document.getElementById('price' + j));

					if (document.getElementById('sampley' + j).checked == true){
						productSample[i] = "Y";
					}else{
						productSample[i] = "N";
					}
				}
			}
function submitOrder(){
	var verifyCode =   document.getElementsByName("verifyCode")[0].value;
	var vCode = document.getElementsByName("vCode")[0].value;

			var k = 0;
			for (k=1;k<= productName.length;k++){
				if (document.getElementById('product_name' + k).value == ""){
					alert("Bạn cần điền đủ thông tin");
					document.getElementById('product_name' + k).focus();
					return;
				}
				
				if (document.getElementById('price' + k).value == "" || isNaN(document.getElementById('price' + k).value)){
					alert("Must be a number");
					document.getElementById('price' + k).focus();
					return;

				}
				
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
			
			if (address == null || address.value == ""){
				alert("Bạn cần điền đủ thông tin");
				address.focus();
				return false;
			}
			if (companyZip == null || companyZip.value == ""){
				alert("Bạn cần điền đủ thông tin");
				companyZip.focus();
				return false;
			}
			if (companyPhone == null || companyPhone.value == "" ||isNaN(companyPhone.value)){
				alert("Bạn cần điền đủ thông tin");
				companyPhone.focus();
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
			
			if (contactLName == null || contactLName.value == ""){
				alert("Bạn cần điền đủ thông tin");
				contactLName.focus();
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
			var count;
			for (count = 0 ; i < productName.length;i++){
				if (productName[i].value == ""){
					alert("Bạn cần điền đủ thông tin");
					productName[i].focus();
					return;
				}
				if (productPrice[i].value == ""){
					alert("Bạn cần điền đủ thông tin");
					productPrice[i].forcus();
					return;
				}
			}
			
			if (verifyCode == null || verifyCode.value == "" ){
				alert("Bạn cần điền đủ thông tin");
				companyName.focus();
				return false;
			}
			handleProduct();
			var data = {
					deliveryTerm: deliveryTerm.value,
					deliveryDate : deliveryDate.value,
					port : port.value,
					paymentTerm : paymentTerm.value,
					companyName : companyName.value,
					address :address.value,
					city : city.value,
					callCode : callCode.value,
					areaCode : areaCode.value,
					CompanyWeb : CompanyWeb.value,
					companyType : companyType.value,
					companyCountry : companyCountry.value,
					companyState : companyState.value,
					companyZip : companyZip.value,
					companyPhone : companyPhone.value,
					establishYear : establishYear.value,
					companyFax : companyFax.value,
					contactSalution : contactSalution.value,
			
					contactCallCode : contactCallCode.value,
					contactMobile : contactMobile.value,
					contactMessengerType : contactMessengerType.value,
					contactFName : contactFName.value,
					contactMName : contactMName.value,
					contactLName : contactLName.value,
					contactEmail : contactEmail.value,
					designation : designation.value,
					messengerId : messengerId.value,
					comments: comments.value,
					
					productName : productName.join(","),
					productPrice: productPrice.join(","),
					productSample: productSample.join(","),
					

				
			}
			  $.ajax({
	                 type: "POST",
	                 url: "supplier",
	                 data: data,
	                 success: function () {
	              	   alert("Cảm ơn bạn. Xin kiểm tra email");
	                     location.reload();
	                 },
	                 error: function(xhr, textStatus, errorThrown){
	                	
		                alert("Có lỗi xảy ra. Xin thử lại lần sau");
	                	// alert(xhr.responseText);
	                	 
	                  }
	             });
			return true;
			//var deliveryCountry = document.getElementsByName("deliveryCountry");
			
}
		
		
		 var i = 1;

		 function addField() {
		 	//alert(productName.length);
             if (i <= 10) {
                 i++;
                 var div = document.createElement('div');
                 div.innerHTML = '<div class="col-sm-12" style="padding-left:0px">\n\
    <div class="col-xs-12 col-sm-4" style="margin-bottom:10px;padding-left:0px;"><input required type="text" name="product_name' + i + '" class="form-control" id="product_name' + i + '" placeholder="Product Name*" maxlength="500" title="Product Name*" /> </div> \n\
<div class="col-xs-12 col-sm-3" style="padding-right:4px;margin-bottom:10px"><input name="price' + i + '" type="text" class="form-control" id="price' + i + '" placeholder="USD/MT" maxlength="500" title="USD/MT"/></div>\n\
            <label class="radio-inline" > <input name="sample' + i + '" id="sampley' + i + '" type="radio" value="yes" checked="checked" />Yes</label>\n\
<label class="radio-inline" ><input name="sample' + i + '" id="samplen' + i + '" type="radio" value="no" />No</label>\n\
     </div><a  style="color: #428bca; float: right; margin-top: 0%; margin-right: -2%" onclick="removeField(this)">x</a>\n\
</div>';
                 document.getElementById('TextBoxesGroup').appendChild(div);
                 document.getElementById('product_name' + i).focus();
                 productName.push("");
 				productPrice.push("");
 				productSample.push("");
 				
             }
         }

         function removeField(div) {
             document.getElementById('TextBoxesGroup').removeChild(div.parentNode);
             productName.length--;
             productPrice.length--;
             productSample.length--;
             i--;
         }
         
         function GetXmlHttpObject() {
             var xmlhttp;
             if (window.XMLHttpRequest)
             {// code for IE7+, Firefox, Chrome, Opera, Safari
                 xmlhttp = new XMLHttpRequest();
             }
             else
             {// code for IE6, IE5
                 xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
             }
             return xmlHttp;
         }
//         function showcode(str) {
//
//             xmlHttp = GetXmlHttpObject();
//             if (xmlHttp == null) {
//                 alert("you browser don't support the ajax");
//                 return;
//
//             }
//             var url = "jsp/countr_codeResponse.jsp";
//             url = url + "?country=" + str;
//             url = url + "&sid =" + Math.random();
//             xmlHttp.onreadystatechange = stateChanged;
//             xmlHttp.open("GET", url, true);
//             xmlHttp.send(null);
//         }
         function stateChanged()
         {

             if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
             {
                 document.getElementById("countr_code").innerHTML = xmlhttp.responseText;
             }

         }
