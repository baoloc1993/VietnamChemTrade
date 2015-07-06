<%@ page import="net.tanesha.recaptcha.ReCaptcha" %>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory" %>

<%@include file = "../setting.jsp" %>
<script src="js/countries3.js"></script>

   <script type="text/javascript">
       function loadimage() {
           document.getElementById("randImage").src = "../image.jsp?" + Math.random();
       }
   </script>
    <body>
        <div class="container-fluid">

            <!---to wrap around all body content--->
            <div class="row">
                <!----center content--->
                <div class="col-md-10 col-md-offset-1 centerRow">

                    <!---add the header and navbar and search bar---->
                    <%@include file="../header_nav2.jsp"%>
                    <%@include file="../index/search.jsp"%>

                    <form method="post" action="order">

                        <div class="row" style="margin-left:1%; margin-right: 2%">
                            <div class="col-md-12">
                                <div class="order_header">
                                	${orderMessage }
                                	
                                </div>
                            </div>
                        </div>

                        <div class="row cartBox">
                            <div class="col-md-11">
							<!--  Display list of Products -->
							<c:if test = "${cartsSize > 0}">
							<c:forEach var="i" begin="0" end="${cartsSize - 1 }">
							
                                <div class="row rowSpc" >
                                    <div class="col-md-12" >
                                        <div class="row">


	                                        <div class="col-md-4 col-md-offset-1" style="margin-bottom: 15px;">
	                                            <input type="hidden" name="p_ID${i}" value="${carts.get(i).productId}"> 
	                                            Product #${i}:<br><b style="color: #666666">${carts.get(i).productName}</b>
	
	                                            <!--origin, appearance, packaging--->
	
	                                        </div>
                                            <div class="col-md-2" >

                                                <div class="form-group">

                                                    Expected Price: <input class="form-control order-form" id="expected" placeholder="USD/Unit" name="expectedPrice${i}" type="text" required>
                                                </div>

                                            </div>
                                            <div class="col-md-2">

                                                <div class="form-group">

                                                    Unit: <select class="form-control" id="unit" name="unit${i}">
                                                        <option value="MT">MT</option>
                                                        <option value="KG">KG</option>
                                                    </select>    
                                                </div>

                                            </div>
                                            <div class="col-md-2 ">
                                                Quantity: <input id="qty" class="form-control order-form" name="expectedQty${i}" placeholder="Expected" type="text" required>

                                            </div>


                                            <div class="col-md-1">

                                                <div class="removeBtn form-group">
                                                    <br>                                                    
                                                    <a style  = "cursor: pointer" onclick= "removeCart('${carts.get(i).productId }')" style="color:white; text-decoration: none"><div class="btn btn-danger">Remove</div></a></div>

                                            </div>
                                        </div>
                                    </div>

                                </div>
								</c:forEach>
                                </c:if>

                            </div>
                        </div>

                        <div class="row" style="margin-left:1%; margin-right: 2%;">

                            <div class="col-md-10 col-md-offset-1">

                                <!---delivery information------>
                                <div class="row">
                                    <div class="line" style="margin-top: 20px;"></div>

                                    <div class="col-md-6" style="padding-right: 4%;" >
                                        <div class="form-group">
                                            <label>Delivery Information</label>
                                            <select class="form-control" name="deliveryCountry">
                                                <option value="">Select Country</option>
                                                
                                                <c:forEach items = "${countries }" var = "country">
                                                	<option value="${country.country}">${country.country }</option>
												</c:forEach>


                                            </select>
                                        </div>

                                        <div class="form-group">

                                            <select class="form-control" id="team" name="deliveryTerm">
                                                
                                                <option value="">Select Delivery Term</option>
                                               
                                                <c:forEach items = "${deliveries }" var = "delivery">
                                                	<option value="${delivery}">${delivery }</option>
                                                </c:forEach>

                                            </select>
                                        </div>


                                        <div class="form-group">
                                            <input class="form-control" type="text" placeholder="Target Delivery Date" value=""  id="targetDate" name="deliveryDate">
                                        </div>


                                    </div>

                                    <!----second column------>
                                    <div class="col-md-6" style="padding-right: 4%;">
                                        <div class="form-group">
                                            <label><font color="white">n</font></label>
                                            <input type="text" placeholder="Port of Destination" value="" class="form-control" name="port">
                                        </div>

                                        <div class="form-group">

                                            <select class="form-control" name="paymentTerm">
                                                
                                                <option value="">Select Payment Term</option>
                                                
                                                <c:forEach items = "${payments}" var = "payment">
                                                	<option value="${payment }">${payment }></option>
                                                </c:forEach>
                                        	</select>
                                        </div>

                                    </div>
                                </div>

                                <!---company information------>
                                <div class="row">
                                    <div class="line"></div>

                                    <div class="col-md-6" style="padding-right: 4%;">
                                        <div class="form-group order-form">
                                            <label>Company Information</label>
                                            <input type="text" placeholder="Company Name*" class="form-control order-form" value="" name="companyName" required>

                                        </div>

                                        <div class="form-group">
                                            <textarea name="address" placeholder="Address" class="form-control" rows="4" ></textarea>
                                        </div>

                                        <div class="form-group">

                                            <input type="text" placeholder="City" class="form-control" value="" name="city"  >
                                        </div>

                                        <div class="row">
                                            <div class="col-md-5">

                                                <div class="form-group">

	                                               <input required type="text" placeholder="Calling Code*" class="form-control order-form" value="" name="callCode">
                                                        
                                                </div>
                                            </div>
                                            <div class="col-md-7" style="padding-left: 19px;">
                                                <div class="form-group">
                                                    <input type="number" placeholder="Area Code" value="" class="form-control" name="areaCode"  />
                                                </div>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <input type="text" placeholder="Website" class="form-control" value="" name="CompanyWeb"  >
                                        </div>

                                    </div>

                                    <!----second column------>
                                    <div class="col-md-6" style="padding-right: 4%;">

                                        <div class="form-group">
                                            <label><font color="white">s</font></label>
                                            <select class="form-control" name="companyType">
                                                
                                                <option value="">Type of Company</option>
                                                <c:forEach items="${types}" var = "type">
                                                	<option value="${type }">${type }</option>
                                                </c:forEach>
                                            </select>
                                        </div>

                                        <div class="form-group">
                                            <select class="form-control" onChange="print_state('state', this.selectedIndex);" id="country" name ="companyCountry" title="Select Country">
                                                <script type="text/javascript">print_country("country");</script>
                                                
                                                	<option value="">Select Country</option>
                                                
                                                
                                            </select>

                                        </div>

                                        <div class="form-group">

                                            <select class="form-control" title="State" style="height:35px;" name="companyState" id="state">
                                                <option value="" selected="selected" >Select State</option>
                                            </select>

                                        </div>

                                        <div class="form-group">
                                            <input type="number" placeholder="Zip / Postal Code" value="" class="form-control" name="companyZip"  >
                                        </div>


                                        <div class="row">
                                            <div class="col-md-6">

                                                <div class="form-group">
                                                    <input type="number" placeholder="Phone Number" value="" class="form-control" name="companyPhone"  >
                                                </div>
                                            </div>
                                            <div class="col-md-6" style="padding-left: 19px;">
                                                <div class="form-group">
                                                    <input type="number" placeholder="Fax Number" value="" class="form-control" name="companyFax"  >
                                                </div>
                                            </div>
                                        </div>


                                    </div>
                                </div>                                

                                <!---contact information------>
                                <div class="row">
                                    <div class="line"></div>

                                    <div class="col-md-6" style="padding-right: 4%;">

                                        <div class="row"><div class="col-md-12" ><label>Contact Information</label></div></div>

                                        <div class="row">

                                            <div class="col-md-4">
                                                <div class="form-group">                                                    
                                                    <select class="form-control" name="contactSalution">
                                                        <option>Mr</option>
                                                        <option>Mrs</option>
                                                        <option>Ms</option>
                                                        <option>Dr</option>
                                                        <option>Prof</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="col-md-8" style="padding-left: 19px;">
                                                <div class="form-group">
                                                    <input class="form-control order-form" type="text" placeholder="First Name*" value="" name="contactFName" required>
                                                </div>
                                            </div>

                                        </div>


                                        <div class="row">
                                            <div class="col-md-4" >

                                                <div class="form-group">
                                                    
                                             		<input required type="text" placeholder="Calling Code*" class="form-control order-form" value="" name="contactCallCode">
                                                    
                                                </div>
                                            </div>
                                            <div class="col-md-8" style="padding-left: 19px;">
                                                <div class="form-group">
                                                    <input class="form-control order-form" type="number" placeholder="Mobile No.*" value="" name="contactMobile" required>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <select class="form-control" name="contactMessengerType">
                                                <option>Skype</option>
                                                <option>AOL</option>
                                                <option>GTalk</option>
                                            </select>
                                        </div>


                                    </div>

                                    <!----second column------>
                                    <div class="col-md-6" style="padding-right: 4%;">

                                        <div class="row"><div class="col-md-12"><label><font color="white">Contact</font></label></div></div>


                                        <div class="row">

                                            <div class="col-md-6" style="padding-right: 19px;">
                                                <div class="form-group">
                                                    <input class="form-control" value="" type="text" placeholder="Middle Name" name="contactMName">
                                                </div>
                                            </div>
                                            <div class="col-md-6" >
                                                <div class="form-group">
                                                    <input class="form-control order-form" value="" type="text" placeholder="Last Name*" name="contactLName" required>
                                                </div>
                                            </div>

                                        </div>

                                        <div class="form-group">
                                            <input class="form-control order-form" value="" type="email" placeholder="Email ID*" name="contactEmail" required>
                                        </div>

                                        <div class="form-group">
                                            <input class="form-control" type="text" value="" placeholder="Messenger ID" name="contactMessengerID">
                                        </div>

                                    </div>
                                </div>

                                <!---Comment Textarea------>
                                <div class="row">

                                    <div class="line"></div>
                                    <div class="col-md-12" style="padding-right: 4%;">                                        
                                        <div class="form-group">                                           
                                            <textarea name="comments" id="comments" class="form-control" placeholder="Comments/Notes" rows="5">${order.comments }</textarea>
                                        </div>
                                    </div>

                                </div>

                                <!---Verification Code------>
                                <div class="row">

                                    <div class="line"></div>
                                    <div class="col-md-12">    
                                        <center>
                                            <div class="form-group">
                                               <%
          											ReCaptcha c = ReCaptchaFactory.newReCaptcha("6LcodwgTAAAAAEMXp4gPqAkFuhWIGD89ZhARSl3d", "6LcodwgTAAAAAPVnzcwlz0t7ZJ99b-XC0NiBRw_q", false);
          											out.print(c.createRecaptchaHtml(null, null));
        		 								%>
                                            </div>
                                        </center>
                                    </div>
                                </div>

                                <!----button------>
                                <div class="row" style="margin-top:20px">                                    
                                    <div class="col-md-12"> <center>
                                            <div class="form-group">
                                                <button type="submit" class="btn btn-info">Submit</button>
                                                <button type="reset" class="btn btn-danger">Reset</button>
                                            </div>
                                        </center>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </form>

                    <!-- Footer Codes -->
                    <%@ include file ="../footer.jsp"%>
                </div>
            </div>
        </div>

        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
       
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>                 
       
        <script src="js/bootstrap-datepicker.js"></script>
        <script type="text/javascript">
                                                    // When the document is ready
                                                    $(document).ready(function () {

                                                        $('#targetDate').datepicker({
                                                            format: "yyyy-mm-dd"
                                                        });

                                                    });
        </script>
        <!--tradeasia's scripts --> 
        <script src="js/tradeasia.js"></script>      
		<script>
		
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
		</script>
    </body>
</html>
