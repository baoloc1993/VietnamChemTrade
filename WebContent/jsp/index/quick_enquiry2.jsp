<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="net.tanesha.recaptcha.ReCaptcha" %>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory" %>
<script src='https://www.google.com/recaptcha/api.js'></script> 
${enquiryError }
<div class="col-xs-12 col-md-6" style="padding:2%; background-color: #336688"">
	<div id="enquiry" class="enquiry-head" style="font-size:15px;">QUICK ENQUIRY</div>
	<form id="contform" class="form-pdd"  onsubmit  = "return submitEnquiry()" action = "enquiry" method = "get" autocomplete="on" novalidate="true">
		  	
		<div class="disp row-fluid">
			<!--  LEFT COLUMN -->
			<div class="frm-lft span7">	
				<!--  ROW 1 -->
				<div class="span12">
					<input style = "margin-right: 1%; margin-bottom: 1%" required="" id="per_name" name = "per_name" class="flt-lft span6" type="text"  value="" placeholder="Name" title="Name">
					<span class="ui-helper-hidden-accessible1" role="status" aria-live="polite"></span>
					<span role="status" aria-live="polite" class="ui-helper-hidden-accessible"></span>
					<input style="margin-left:0%" required="" name = "chemical" id="chemical" class=" span6 flt-lft txtbox-mgn ui-autocomplete-input" type="text"  value="" placeholder="Product" autocomplete="off" title="Product">
				</div>
				<!-- ROW 2 -->
				<div class="span12" style = "margin-left:0%; margin-bottom:1%;">
	                <select  style = "margin-right:1%"required onchange="goto_pg(this.value)" class=" span6 flt-lft txt-box" title="Country-Code" name = "ccode"id="ccode" >
						<option value="">Country-Code</option>
						<c:forEach items="${countryCodes}" var="country">
									<option value= "${country.country}"/>${country.country}</option>
						</c:forEach>
					</select>
					<input style = "margin-left:0%;"	 required="" id="emailidq" name = "email" class="span6 flt-lft" type="text"  value="" placeholder="Email Address" title="Email Address" alt="input2">
				</div>
				<!-- ROW 3 -->
				<div class="span12" style="margin-left:0%;">
					<textarea style="margin-right: 1%;"   required="" name = "contact" id="contact" class="span6 flt-lft " type="text"  value="" placeholder="Contact" title="contact"></textarea>
					<textarea style="margin-left:0%;" required="" name = "message" id="message" class="span6 flt-lft"  value="" placeholder="Comments" title="Comments" ></textarea>
				</div>
				<div class="span12" style="margin-left:0%;">
					<input class="span5 submit-btn"  type = "submit" value="Submit" title="Submit" alt="Submit3" style="vertical-align:top; margin-left: 0%; margin-top:1%;">
				<input  class="span5 reset-btn" type = "reset" value="Reset" title="Reset" style="vertical-align:top; margin-left:1%; margin-top:1%">
				</div>
				
			</div>
			<!--  RIGHT COLUMN -->
			<div class ="span5">
				<div class = "span12">
				 <%
          			ReCaptcha c = ReCaptchaFactory.newReCaptcha("6LcodwgTAAAAAEMXp4gPqAkFuhWIGD89ZhARSl3d", "6LcodwgTAAAAAPVnzcwlz0t7ZJ99b-XC0NiBRw_q", false);
          			out.print(c.createRecaptchaHtml(null, null));
        		 %>
        		 </div>
				
				
				
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
		//	 alert("Please fill all the fields");
		//     return false;
		}
		return true;

	}
	</script>