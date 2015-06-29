
<%@include file = "../setting.jsp" %>

    <body>
        <div class="container">

            <!---to wrap around all body content--->
            <div class="row">
                <!----center content--->
                <div class="col-md-10 col-md-offset-1 centerRow">

                    <!---add the header and navbar and search bar---->
                    <%@include file="../header_nav.jsp"%>
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
							<c:forEach var="i" begin="0" end="${fn:length(carts)-1}">
							
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
                                                    <a href="removeCart?p_ID=${carts.get(i).productId }" style="color:white; text-decoration: none"><div class="btn btn-danger">Remove</div></a></div>

                                            </div>
                                        </div>
                                    </div>

                                </div>
								</c:forEach>
                                

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
                                                
                                                <option value="${order.deliveryCountry }">${order.deliveryCountry }</option>
                                                <c:forEach items = "${countries }" var = "country">
                                                	<option value="${country.country}">${country.country }</option>
												</c:forEach>


                                            </select>
                                        </div>

                                        <div class="form-group">

                                            <select class="form-control" id="team" name="deliveryTerm">
                                                
                                                <option value="">Select Delivery Term</option>
                                                <option value="${order.deliveryTerm }">${order.deliveryTerm }</option>
                                               
                                                <c:forEach items = "${deliveries }" var = "delivery">
                                                	<option value="${delivery}">${delivery }</option>
                                                </c:forEach>

                                            </select>
                                        </div>


                                        <div class="form-group">
                                            <input class="form-control" type="text" placeholder="Target Delivery Date" value="${order.deliveryDate }"  id="targetDate" name="deliveryDate">
                                        </div>


                                    </div>

                                    <!----second column------>
                                    <div class="col-md-6" style="padding-right: 4%;">
                                        <div class="form-group">
                                            <label><font color="white">n</font></label>
                                            <input type="text" placeholder="Port of Destination" value="${order.port }" class="form-control" name="port">
                                        </div>

                                        <div class="form-group">

                                            <select class="form-control" name="paymentTerm">
                                                
                                                <option value="">Select Payment Term</option>
                                                
                                                <option value="${order.paymentTerm }">${order.paymentTerm }</option>
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
                                            <input type="text" placeholder="Company Name*" class="form-control order-form" value="${order.companyName }" name="companyName" required>

                                        </div>

                                        <div class="form-group">
                                            <textarea name="address" placeholder="Address" class="form-control" rows="4" >${order.address }</textarea>
                                        </div>

                                        <div class="form-group">

                                            <input type="text" placeholder="City" class="form-control" value="${order.city }" name="city"  >
                                        </div>

                                        <div class="row">
                                            <div class="col-md-5">

                                                <div class="form-group">

	                                               <input required type="text" placeholder="Calling Code*" class="form-control order-form" value="" name="callCode">
	                                               <input required type="text" placeholder="Calling Code*" class="form-control order-form" value="${order.callCode }" name="callCode">
                                                        
                                                </div>
                                            </div>
                                            <div class="col-md-7" style="padding-left: 19px;">
                                                <div class="form-group">
                                                    <input type="number" placeholder="Area Code" value="${order.areaCode }" class="form-control" name="areaCode"  />
                                                </div>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <input type="text" placeholder="Website" class="form-control" value="${order.companyWeb }" name="CompanyWeb"  >
                                        </div>

                                    </div>

                                    <!----second column------>
                                    <div class="col-md-6" style="padding-right: 4%;">

                                        <div class="form-group">
                                            <label><font color="white">s</font></label>
                                            <select class="form-control" name="companyType">
                                                
                                                <option value="">Type of Company</option>
                                                <option value="${order.companyType }">${order.companyType }</option>
                                                <c:forEach items="${types}" var = "type">
                                                	<option value="${type }">${type }</option>
                                                </c:forEach>
                                            </select>
                                        </div>

                                        <div class="form-group">
                                            <select class="form-control" onChange="print_state('state', this.selectedIndex);" id="country" name ="companyCountry" title="Select Country">
                                                <script type="text/javascript">print_country("country");</script>
                                                
                                                	<option value="">Select Country</option>
                                                
                                                	<option value="${order.companyCountry }" selected="selected">${order.companyCountry }</option>
                                                
                                            </select>

                                        </div>

                                        <div class="form-group">

                                            <select class="form-control" title="State" style="height:35px;" name="companyState" id="state">
                                                <option value="" selected="selected" >Select State</option>
                                                <option value="${order.companyState}" >${order.companyState}</option>
                                            </select>

                                        </div>

                                        <div class="form-group">
                                            <input type="number" placeholder="Zip / Postal Code" value="${order.companyZip }" class="form-control" name="companyZip"  >
                                        </div>


                                        <div class="row">
                                            <div class="col-md-6">

                                                <div class="form-group">
                                                    <input type="number" placeholder="Phone Number" value="${order.companyPhone }" class="form-control" name="companyPhone"  >
                                                </div>
                                            </div>
                                            <div class="col-md-6" style="padding-left: 19px;">
                                                <div class="form-group">
                                                    <input type="number" placeholder="Fax Number" value="${order.companyFax }" class="form-control" name="companyFax"  >
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
                                                    <input class="form-control order-form" type="text" placeholder="First Name*" value="${order.contactFName }" name="contactFName" required>
                                                </div>
                                            </div>

                                        </div>


                                        <div class="row">
                                            <div class="col-md-4" >

                                                <div class="form-group">
                                                    
                                             		<input required type="text" placeholder="Calling Code*" class="form-control order-form" value="${order.contactCallcode }" name="contactCallCode">
                                                    
                                                </div>
                                            </div>
                                            <div class="col-md-8" style="padding-left: 19px;">
                                                <div class="form-group">
                                                    <input class="form-control order-form" type="number" placeholder="Mobile No.*" value="${order.contactMobile }" name="contactMobile" required>
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
                                                    <input class="form-control" value="${order.contactMName }" type="text" placeholder="Middle Name" name="contactMName">
                                                </div>
                                            </div>
                                            <div class="col-md-6" >
                                                <div class="form-group">
                                                    <input class="form-control order-form" value="${order.contactLName }" type="text" placeholder="Last Name*" name="contactLName" required>
                                                </div>
                                            </div>

                                        </div>

                                        <div class="form-group">
                                            <input class="form-control order-form" value="${order.contactEmail }" type="email" placeholder="Email ID*" name="contactEmail" required>
                                        </div>

                                        <div class="form-group">
                                            <input class="form-control" type="text" value="${order.contactMessengerID }" placeholder="Messenger ID" name="contactMessengerID">
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
                                                <img alt="code..." name="randImage" id="randImage" src="include/image.jsp" width="20%" height="20%" />
                                                <a href="javascript:loadimage();"><img src="images/body/refresh.png"/></a>
                                            </div>
                                            <div class="form-group">
                                                <input class="form-control order-form"   maxlength="6" style="width:50%" placeholder="Verification Code*" id="verifyCode" title="verifyCode" name="verifyCode" type="text" required /> 
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
                    <jsp:include page="../footer.jsp"/>
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

    </body>
</html>
