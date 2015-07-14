<%@ include file = "setting.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="css/new-supplier.css" rel="stylesheet"> 
        <script src="js/countries3.js"></script>
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
        
    <body>
        <div class="container">
            <!---to wrap around all body content--->
            <div class="row">
                <!----center content--->
                <div class="col-md-12 centerRow">

                    <!---add the header and navbar and search bar---->
                    <%@include file="header_nav.jsp"%>

                    <!-- <form id="tbl-det-supplier-form" name="tbl-det-supplier-form" method="post" action="new-supplier-form">-->

                        <!-- Form Header-->
                        <div class="row" style="margin-left:0px; margin-right: 0px">                            
                            <div class="col-md-12" >
                                <div class="supplier_header">New Supplier Form</div>
                            </div>
                            <div class="col-md-5">
                                <h6>* Denotes Required Field</h6>
                            </div>
                        </div>

                        <!--Form content-->  
                        <div class="row" style="margin-left:1%; margin-right: 2%;">
                            <div class="col-md-12 col-md-offset-1">
                                <div class="col-md-10">

                                    <!-- Form information -->

                                    <!--Your Company Information-->
                                    <div class="row">
                                        <div class="line" style="margin-top: 20px;"></div>

                                        <!-- First Column, CompanyName, Manufacturer, Address, City, Country Code, Area Code-->
                                        <div class="col-md-6" style="padding-left: 4%;">
                                            <label>Your Company Information</label>
                                            <!--Company Name-->
                                            <div class="form-group">
                                                <input required maxlength="150" placeholder="Company Name*" title="Company Name" class="form-control" id="company_name" name="TblDetSupplier[company_name]" type="text" />																				  											
                                            </div>
                                            <!--Manfacturer-->
                                            <div class="form-group">
                                                <select title="Type of Company" class="form-control" id="company_type" name="TblDetSupplier[company_type]">
                                                    <option value="Manufacturer">Manufacturer</option>
                                                    <option value="Distributor">Distributor</option>
                                                    <option value="Service Industry">Service Industry</option>
                                                </select>
                                            </div>
                                            <!--Address-->
                                            <div class="form-group">
                                                <textarea required rows="4" placeholder="Address*" title="Address" class="form-control" id="sup_address" name="TblDetSupplier[address]"></textarea> 
                                            </div>
                                            <!--City-->
                                            <div class="form-group">
                                                <input maxlength="150" placeholder="City" title="City" class="form-control" id="sup_city" name="TblDetSupplier[city]" type="text" >
                                            </div>
                                            <!--Country Code-->
                                            <div class="form-group">
                                                <select class="form-control" title="Country Code"  id="countr_code" name="TblDetSupplier[country_code]">
                                                    <option value="">Country Code</option>
                                                    <c:forEach items = "${countries }" var = "country">
	                                                    
	                                                    <option value="${country.cCode }">${country.country }</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <!--Area Code-->
                                            <div class="form-group">
                                                <input maxlength="10" placeholder="Area Code" title="Area_Code" class="form-control" id="area_code" name="TblDetSupplier[area_code]" type="text" />										
                                            </div>
                                        </div>
                                        <!--First Column ENDS-->

                                        <!--Second Column, YearofEstablishment, Website, Country, State, ZIP, Phone, Fax-->
                                        <div class="col-md-6" style="padding-left: 4%;">
                                            <label><font color="white">s</font></label>
                                            <!--Year of Establishment-->
                                            <div class="form-group">
                                             <select class="form-control" id="establish_year" name ="TblDetSupplier[establish_year]" title="Select Year">
                                                    <option value="1900" selected= "selected">1900</option>
                                                    <c:forEach begin = "1901" end = "2020" var = "i">
                                                    	<option value="${i }" >${i }</option>
                                                    </c:forEach>
                                                </select>
                                                <input maxlength="10" placeholder="Year Of Establishment" title="Establish year" class="form-control" id="establish_year" name="TblDetSupplier[establish_year]" type="text" />																				  											
                                            </div>
                                            <!--Website-->
                                            <div class="form-group">
                                                <input maxlength="150" placeholder="Website" title="Website" class="form-control" id="website" name="TblDetSupplier[website]" type="text" />																						  											
                                            </div>
                                            <!--Country-->
                                            <div class="form-group">
                                                <select class="form-control" id="country" name ="companyCountry" onChange="print_state('state', this.selectedIndex);
                                                        showcode(this.value);" title="Select Country">
                                                    <option selected="selected">Select Country</option>
                                                </select>
                                                <script type="text/javascript">print_country("country");</script>
                                            </div>
                                            <!--State-->
                                            <div class="form-group">
                                                <select title="State" class="form-control" name="TblDetSupplier[state]" id="state">
                                                    <option value="" selected="selected">Select State</option>
                                                </select>
                                            </div>
                                            <!--ZIP-->
                                            <div class="form-group">
                                                <input required maxlength="10" placeholder="Zip / Postal Code*" title="zip" style="" class="form-control" id="sup_zip" name="TblDetSupplier[zip]" type="text" >																						                        
                                            </div>
                                            <!--Phone-->
                                            <div class="form-group">
                                                <input required maxlength="25" placeholder="Phone No*" title="Phone No*" class="form-control" id="sup_phone" name="TblDetSupplier[cmpny_contact_no]" type="text" />																							
                                            </div>
                                            <!--Fax-->
                                            <div class="form-group">
                                                <input maxlength="20" placeholder="Fax" title="Fax" class="form-control" id="sup_fax" name="TblDetSupplier[fax]" type="text" />
                                            </div>
                                        </div>
                                        <!--Second Column ENDS-->
                                    </div>
                                    <!--Your Company Information ENDS-->

                                    <!--Contact Information-->
                                    <div class="row">
                                        <div class="line" style="margin-top: 20px;"></div>

                                        <!-- First Column, CompanyName, Manufacturer, Address, City, Country Code, Area Code-->
                                        <div class="col-md-6" style="padding-left: 4%;">
                                            <label>Contact Information</label>
                                            <!--Salutation-->
                                            <div class="form-group">
                                                <select title="Salutation" class="form-control" id="salutation" name="TblDetSupplier[salutation]">
                                                    <option value="Mr">Mr</option>
                                                    <option value="Mrs">Mrs</option>
                                                    <option value="Ms">Ms</option>
                                                    <option value="Dr">Dr</option>
                                                    <option value="Prof">Prof</option>
                                                </select>
                                            </div>
                                            <!--Firstname-->
                                            <div class="form-group">
                                                <input required maxlength="200" placeholder="First Name*" title="First Name" class="form-control" id="first_name" name="TblDetSupplier[first_name]" type="text" />
                                            </div>
                                            <!--Middlename-->
                                            <div class="form-group">
                                                <input maxlength="200" placeholder="Middle Name" title="Middle Name*" class="form-control" id="middle_name" name="TblDetSupplier[middle_name]" type="text" />
                                            </div>
                                            <!--Lastname-->
                                            <div class="form-group">
                                                <input required maxlength="200" placeholder="Last Name*" title="Last Name*" class="form-control" id="last_name" name="TblDetSupplier[last_name]" type="text" />
                                            </div>
                                            <!--Email-->
                                            <div class="form-group">
                                                <input required maxlength="200" placeholder="Email*" title="Email*" style="" class="form-control " id="emailid" name="TblDetSupplier[emailid]" type="text" />
                                            </div>
                                        </div>
                                        <!--First Column ENDS-->

                                        <!--Second Column, Designation, CountryCode, Mobile, SkypeID, MessengerID-->
                                        <div class="col-md-6" style="padding-left: 4%;">
                                            <label><font color="white">s</font></label>
                                            <!--Designation-->
                                            <div class="form-group">
                                                <input maxlength="200" placeholder="Designation" title="Designation" class="form-control" id="designation" name="TblDetSupplier[designation]" type="text" />
                                            </div>
                                            <!--Country Code-->
                                            <div class="form-group">
                                                <select class="form-control" title="Country Code Mobile" id="country_code_mob" name="TblDetSupplier[country_code_mob]">
                                                    <option value="">Country Code</option>
                                                    <c:forEach items = "${countries }" var = "country">
	                                                    
	                                                    <option value="${country.cCode }">${country.country }</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <!--Mobile No-->
                                            <div class="form-group">
                                                <input required maxlength="10" placeholder="Mobile No*" title="Mobile No*" class="form-control" id="mobile" name="TblDetSupplier[mobile]" type="text" />
                                            </div>
                                            <!--SkypeID-->
                                            <div class="form-group">
                                                <select title="messenger type" class="form-control" id="messenger_type" name="TblDetSupplier[messenger_type]">
                                                    <option value="Skype Id">Skype Id</option>
                                                    <option value="AOL">AOL</option>
                                                    <option value="Gtalk">Gtalk</option>
                                                </select>
                                            </div>
                                            <!--MessengerID-->
                                            <div class="form-group">
                                                <input maxlength="10" placeholder="Messenger Id" title="Messenger Id*" class="form-control" id="messenger_id" name="TblDetSupplier[messenger_id]" type="text" />
                                            </div>
                                        </div>
                                        <!--Second Column ENDS-->
                                    </div>
                                    <!--Contact Information ENDS-->

                                    <!--Product Information-->
                                    <div class="row">
                                        <div class="line" style="margin-top: 20px;"></div>
                                        <div class="col-md-12" style="padding-left: 4%;">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <label>Product Informationn</label>
                                                </div>

                                            </div>
                                            
                                            <div id='TextBoxesGroup'>
                                                <div class="row" >

                                                    <div class="col-xs-12 col-sm-4" style="margin-bottom:10px">

                                                        <input required class="form-control" placeholder="Product Name*" maxlength="500" title="Product Name*" name="product_name1" id="product_name1" type="text" />            										

                                                    </div>
                                                    <div class="col-xs-12 col-sm-3" style="margin-bottom:10px">

                                                        <input name="price1" type="text" class="form-control" id="price1" placeholder="USD/MT" maxlength="500" title="USD/MT" />

                                                    </div>
                                                    <div class="col-xs-6 col-sm-3" style="margin-bottom:10px">

                                                        <center>
                                                            <label class="radio-inline" > <input name="sample1" id="sampley1" type="radio" value="yes" checked="checked" title="yes"> Yes</label>
                                                            <label class="radio-inline" > <input name="sample1" id="samplen1" type="radio" value="no" title="no"/>No </label>
                                                        </center>
                                                    </div>  
                                                    <div class="col-xs-6 col-sm-2">
                                                        <center>
                                                            <img src="images/add-row.jpg" onclick="addField()" onkeypress="addField()" tabindex="2" alt="Image1" height="20" width="20" /><b> (limit 10)</b>
                                                        </center>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <!--Product Information ENDS-->

                                    <!--Other Information-->
                                    <div class="row">
                                        <div class="line" style="margin-top: 20px;"></div>
                                        <div class="col-md-12" style="padding-left: 4%;">
                                            <label>Other Information</label>
                                            <!--Delivery-->
                                            <div class="form-group">
                                                <select title="Delivery Term" class="form-control" id="delivery_term" name="TblDetSupplier[delivery_term]">
                                                    <option value="">Select Delivery Term</option>
                                                    <optgroup label="1">
                                                        <option value="EXW">EXW</option>
                                                        <option value="FCA">FCA</option>
                                                        <option value="FAS">FAS</option>
                                                        <option value="FOB">FOB</option>
                                                        <option value="CPT">CPT</option>
                                                        <option value="CFR">CFR</option>
                                                        <option value="CIF">CIF</option>
                                                        <option value="CIP">CIP</option>
                                                        <option value="DAT">DAT</option>
                                                        <option value="DAP">DAP</option>
                                                    </optgroup>
                                                    <optgroup label="2">
                                                        <option value="DDP">DDP</option>
                                                    </optgroup>
                                                </select>
                                            </div>
                                            <!--Loading Port-->
                                            <div class="form-group">
                                                <input maxlength="150" placeholder="Port of Loading" title="Port of Loading" class="form-control" id="loading_port" name="TblDetSupplier[loading_port]" type="text" />
                                            </div>                                        
                                        </div>
                                        <!--First Column ENDS-->
                                        <!--Second Column, Payment Term, Delivery Days-->
                                        <div class="col-md-6" style="padding-left: 4%;">
                                            <label><font color="white">s</font></label>
                                            <!--Payment Term-->
                                            <div class="form-group">
                                                <select title="Payment Term" class="form-control" id="payment_term" name="TblDetSupplier[payment_term]">
                                                    <option value="">Select Payment Term</option>
                                                    <optgroup label="1">
                                                        <option value="100%T/T ">100%T/T </option>
                                                        <option value="30%T/T +70%D/P">30%T/T +70%D/P</option>
                                                        <option value="L/C 0DS">L/C 0DS</option>
                                                        <option value="L/C 30DS">L/C 30DS</option>
                                                        <option value="L/C 60DS">L/C 60DS</option>
                                                        <option value="L/C 90DS">L/C 90DS</option>
                                                        <option value="D/P 0DS">D/P 0DS</option>
                                                        <option value="D/A 30DS">D/A 30DS</option>
                                                        <option value="D/A 60DS">D/A 60DS</option>
                                                        <option value="D/A 90DS">D/A 90DS</option>
                                                    </optgroup>
                                                    <optgroup label="2">
                                                        <option value="D/A 120D">D/A 120D</option>
                                                    </optgroup>
                                                </select>
                                            </div>
                                            <!--Delivery Days-->
                                            <div class="form-group">
                                                <input maxlength="3" placeholder="In how many days you can deliver" title="In how many days you can deliver" class="form-control" id="sup_date" name="TblDetSupplier[days_to_deliver]" type="text" />
                                            </div>                                        
                                        </div>
                                        <!--Second Column ENDS-->
                                        <!--Merged Column-->
                                        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
                                        <script type="text/javascript" src="jquery.charactercounter.js"></script>
                                        <div class="col-md-12" style="padding-left: 4%;">
                                            <div class="form-group">
                                                <textarea id="comments" rows="5" cols="80" maxlength="500" placeholder="Comments/Notes (Max 500 characters)" title="Comments/Notes" class="form-control" name="TblDetSupplier[comments]"></textarea>
                                                <div id="characterLeft"></div>
                                            </div>
                                        </div>
                                        <script>
                                                                $('#characterLeft').text('500 characters left');
                                                                $('#comments').keyup(function () {
                                                                    var max = 500;
                                                                    var len = $(this).val().length;
                                                                    if (len >= max) {
                                                                        $('#characterLeft').text(' You have reached the limit');
                                                                    } else {
                                                                        var ch = max - len;
                                                                        $('#characterLeft').text(ch + ' characters left');
                                                                    }
                                                                });
                                        </script>
                                        <!--Merged Column ENDS-->
                                    </div>
                                    <!--Other Information ENDS-->

                                    <!--Verification-->
                                    <div class="row">
                                        <!---Verification Code------>
		                                 <div class="row">
		                                    <div class="col-md-12">
		                                        <div class="line" style="margin-top: 20px;"></div>
		                                        <center>
		                                            <img alt="code..." name="randImage" id="randImage" src="image?vCode=${vCode }" width="110" height="80"/>
		                                            <a href="javascript:loadimage();"><img src="images/body/refresh.png" alt="refresh"/></a>
		                                            <input required maxlength="6" class="form-control" style="width:50%" placeholder="Enter Code" id="verifyCode" title="verifyCode" name="verifyCode" type="text" />
		                                            <div id = "errorForm"></div>
		                                             <input type = "hidden"  value ="${vCode }" id="vCode" name="vCode" type="text" />
		                                             <div style  = "color:red"id = "errorCaptcha"></div>
		                                             
		                                            
		                                        </center>
		                                        
		                                    </div>
		                                </div> 
                                    
                                    <!--Verification ENDS-->
								 <!----button------>
	                                <div class="row" style="margin-top:20px">                                    
	                                    <div class="col-md-12"> <center>
	                                            <div class="form-group">
	                                                <button type="submit" class="btn btn-info" onclick  = "submitOrder()">Submit</button>
	                                                <button type="reset" class="btn btn-danger">Reset</button>
	                                            </div>
	                                        </center>
	                                    </div>
	                                </div>
								</div>
                            </div>
                            <!--END OF FORM-->


                        </div><!-- form -->
                      

                    <!-- </form>-->

                    <%@include file="footer.jsp" %>
                </div>
            </div>
        </div>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="js/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.js"></script>
        <script src="js/tradeasia.js"></script>
                <script src="js/supplier.js"></script>
        

    </body>
</html>
