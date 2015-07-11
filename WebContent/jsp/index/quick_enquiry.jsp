<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="net.tanesha.recaptcha.ReCaptcha" %>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory" %>
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
<div class="col-xs-12 col-md-6" style= "background-color: #7E9234; padding-bottom:1%;">
	<div id="contform" class="form-pdd"  >
         <div style="margin-bottom: 15px;border-bottom: #FFF dotted thin;font-size: 18px;color:white;font-family: Oxygen-Bold">Quick Enquiry</div>

         <div class="row" >
             <div class="col-md-6" style="margin-bottom:5px">
                 <input type="text" name="name" placeholder="Name" class="form-control" required>
             </div>
             <div class="col-md-6" style="margin-bottom:5px">
                 <input type="text" name="product" placeholder="Product" class="form-control" id="product">
             </div>
         </div>

         <div class="row" >
             <div class="col-md-6" style="margin-bottom:5px">
                 <select name="countryCode" class="form-control" id="countryCode">
                     <option value>Country-Code</option>
                     <c:forEach items="${countryCodes}" var="country">
							<option value= "${country.country}"/>${country.country}-${country.cCode }</option>
						</c:forEach>
                 </select>
             </div>
             <div class="col-md-6" style="margin-bottom:5px">
                 <input type="number" placeholder="contact" name="contact" class="form-control" required>
             </div>
         </div>

         <div class="row" >

             <div class="col-md-12" style="margin-bottom:5px">
                 <textarea name="comments" rows="5" class="form-control" placeholder="Comments" required></textarea>
             </div>

         </div>
         

         <div class="row" >
             <div class="col-md-6" style="margin-bottom:5px">
                 <input type="email" placeholder="Email" name="email" class="form-control" required>
             </div>
             <div class="col-md-6" >

                 <button type="submit" class="btn btn1 btn-info" onclick = "submitEnquiry()">Submit</button>
                 <button type="reset" class="btn btn1 btn-danger">Reset</button>

             </div>
         </div>

         <!---Verification Code------>
           
          <div class="row">
               <div class="col-md-6"><input required="" maxlength="6" class="form-control" style="/* width:50% */" placeholder="Enter Code" id="verifyCode" title="verifyCode" name="verifyCode" type="text"></div>
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
		document.getElementById("per_name").value = "";
		document.getElementById("chemical").value = "";
		document.getElementById("emailidq").value = "";
		document.getElementById("message").value = "";
		document.getElementById("contact").value = "";
		document.getElementById("ccode").value = "";
	}
	function submitEnquiry() {
		var verifyCode =   document.getElementsByName("verifyCode")[0].value;
		var vCode = document.getElementsByName("vCode")[0].value;
		
		if (verifyCode != vCode){
			alert("error captcha");
			return false;
		}
		
		var per_name = document.getElementById("per_name").value;
		var chemical = document.getElementById("chemical").value;
		var email = document.getElementById("emailidq").value;
		var message = document.getElementById("message").value;
		var contact = document.getElementById("contact").value;
		var ccode = document.getElementById("ccode").value;

		if ((per_name == "") || (chemical == "") || (email == "") || (message == "") || (contact == "")|| (ccode == "")){
			 alert("Please fill all the fields");
		     return false;
		}
		var data = {
				per_name: per_name,
				chemical: chemical,
				email : email,
				message: message,
				contact : contact,
				ccode : ccode,
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