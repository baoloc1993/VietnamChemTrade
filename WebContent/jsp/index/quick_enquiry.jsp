<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="net.tanesha.recaptcha.ReCaptcha" %>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory" %>
<script src='https://www.google.com/recaptcha/api.js'></script> 

<div class="col-xs-12 col-md-6" style= "background-color: #7E9234">
	<form id="contform" class="form-pdd"  onsubmit  = "return submitEnquiry()" action = "enquiry" method = "get" autocomplete="on" novalidate="true">
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

                 <button type="submit" class="btn btn1 btn-info">Submit</button>
                 <button type="reset" class="btn btn1 btn-danger">Reset</button>

             </div>
         </div>

         <!-- Verification Codes-->
         <div class="row">
             <div class="col-md-8" style="margin-bottom:20px">                                             
                 <%
          			ReCaptcha c = ReCaptchaFactory.newReCaptcha("6LcodwgTAAAAAEMXp4gPqAkFuhWIGD89ZhARSl3d", "6LcodwgTAAAAAPVnzcwlz0t7ZJ99b-XC0NiBRw_q", false);
          			out.print(c.createRecaptchaHtml(null, null));
        		 %>                                                   

             </div>
            
         </div>  

         

     </form>
 </div>
 
 
          
 <script>
	
	function submitEnquiry() {
		
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
		return true;

	}
	</script>