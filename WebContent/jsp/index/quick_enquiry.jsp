<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src='https://www.google.com/recaptcha/api.js'></script> 
   <script type="text/javascript">
       function loadimage() {
    	   var text = "";
    	    var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    	    for( var i=0; i < 6; i++ )
    	        text += possible.charAt(Math.floor(Math.random() * possible.length));
    	  // String rand = Math.random();
           document.getElementById("randImage").src = "image?vCode=" + text;
           document.getElementById("vCode").value = text;
       }
   </script>
<div class="col-xs-12 col-md-6" style= "background-color: #800000; padding-bottom:1%;">
	<div id="contform" class="form-pdd"  >
         <div style="margin-bottom: 15px;border-bottom: #FFF dotted thin;font-size: 18px;color:white;font-family: Oxygen-Bold">Yêu cầu báo giá</div>

         <div class="row" >
             <div class="col-md-6" style="margin-bottom:5px">
                 <input type="text" name="name" id = "name" placeholder="Tên" class="form-control" required>
             </div>
             <div class="col-md-6" style="margin-bottom:5px">
                 <input type="text" name="product" placeholder="Sản phẩm" class="form-control" id="product">
             </div>
         </div>

         <div class="row" >
             <div class="col-md-6" style="margin-bottom:5px">
                 <select name="countryCode" class="form-control" id="countryCode">
                     <option value>Mã nước</option>
                     <c:forEach items="${countryCodes}" var="country">
							<option value= "${country.country}"/>${country.country}-${country.cCode }</option>
						</c:forEach>
                 </select>
             </div>
             <div class="col-md-6" style="margin-bottom:5px">
                 <input type="number" placeholder="Thông tin liên lạc" id = "contact" name="contact" class="form-control" required>
             </div>
         </div>

         <div class="row" >

             <div class="col-md-12" style="margin-bottom:5px">
                 <textarea id = "comments" name="comments" rows="5" class="form-control" placeholder="Góp ý" required></textarea>
             </div>

         </div>
         

         <div class="row" >
             <div class="col-md-6" style="margin-bottom:5px">
                 <input type="email" id = "email" placeholder="Email" name="email" class="form-control" required>
             </div>
             <div class="col-md-6" >

                 <button type="submit" class="btn btn1 btn-info" onclick = "submitEnquiry()">Xác nhận</button>
                 <button type="reset" class="btn btn1 btn-danger">Làm lại</button>

             </div>
         </div>

         <!---Verification Code------>
           
          <div class="row">
               <div class="col-md-6"><input required="" maxlength="6" class="form-control" style="/* width:50% */" placeholder="Nhập mã bảo vệ" id="verifyCode" title="verifyCode" name="verifyCode" type="text"></div>
               <div class="col-md-4"><img alt="code..." name="randImage" id="randImage" src="image?vCode=${vCode }" style="width: 100%;"></div>
               <a href="javascript:loadimage();"><img src="images/body/refresh.png" alt="refresh"></a>
               <div id="errorForm"></div>
                <input type="hidden" value="${vCode }" id="vCode" name="vCode">
                <div style="color:red" id="errorCaptcha"></div>

          </div>

         

     </div>
 </div>
 
 
          
 <script>
	function reset(){
		document.getElementById("name").value = "";
		document.getElementById("product").value = "";
		document.getElementById("email").value = "";
		document.getElementById("comments").value = "";
		document.getElementById("contact").value = "";
		document.getElementById("countryCode").value = "";
	}
	function submitEnquiry() {
		var verifyCode =   document.getElementsByName("verifyCode")[0].value;
		var vCode = document.getElementsByName("vCode")[0].value;
		
		if (verifyCode != vCode){
			alert("error captcha");
			return false;
		}
		
		var per_name = document.getElementById("name").value;
		var chemical = document.getElementById("product").value;
		var email = document.getElementById("email").value;
		var message = document.getElementById("comments").value;
		var contact = document.getElementById("contact").value;
		var ccode = document.getElementById("countryCode").value;

		if ((per_name == "") || (chemical == "") || (email == "") || (message == "") || (contact == "")|| (ccode == "")){
			 alert("Please fill all the fields");
		     return false;
		}
		var data = {
				name: per_name,
				product: chemical,
				email : email,
				comments: message,
				contact : contact,
				countryCode : ccode,
		}
		  $.ajax({
                 type: "POST",
                 url: "enquiry",
                 data: data,
                 success: function () {
              	   alert("Please check your email inbox to reconfirm your enquiry.");
                     location.reload();
                 },
                 error: function(xhr, textStatus, errorThrown){
                	
	                alert("Cannot create Enquiry");

                	 
                  }
             });
		
		return true;

	}
	</script>