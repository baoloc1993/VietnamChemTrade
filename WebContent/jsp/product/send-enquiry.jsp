<%-- 
    Document   : index
    Created on : May 21, 2015, 11:24:12 AM
    Author     : Qianpin
--%>
<%@ include file = "../setting.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
        

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
       
       var i = 1;//starts from 1 because the default one being displayed currently is already 0

       function addField() {
           if (i <= 10) {
               i++;
               var div = document.createElement('div');

               div.innerHTML = '<div class="col-xs-12 col-sm-4 enquiry-form" style="margin-bottom:10px;">\n\<input required class="form-control" placeholder="Product Name*" maxlength="500" title="Product Name*" name="product_name' + i + '" id="product_name' + i + '" type="text" /></div> \n\<div class="col-xs-12 col-sm-2" style="margin-bottom:10px;">\n\<select class="form-control" id="quantity' + i + '" name="quantity' + i + '">\n\<c:forEach begin = "1" end = "10" var = "i"><option value="${i}">${i}</option></c:forEach></select></div>\n\<div class="col-xs-12 col-sm-4" style="margin-bottom:10px"><select class="form-control" id="measurement' + i + '" name="measurement' + i + '">\n\<option value="Kilograms">Kilograms</option><option value="Tonnes">Tonnes</option><option value="Litre">Litre</option></select></div>\n\<a href="#remove" style="color: #428bca; float: right; margin-top: 0%; margin-right: -2%" onclick="removeField(this)">x</a>';


               document.getElementById('TextBoxesGroup').appendChild(div);
               document.getElementById('product_name' + i).focus();
               productName.push("");
				productQty.push("");
				productUnit.push("");
           }
       }

       function removeField(div) {
           document.getElementById('TextBoxesGroup').removeChild(div.parentNode);
           productName.length--;
			productQty.length--;
			productUnit.length--;
           i--;
       }
   </script>
    
        <link href="css/send-enquiry.css" rel="stylesheet">

    <body>
        <div class="container">
            <!---to wrap around all body content--->
            <div class="row">
                <!----center content--->
                <div class="col-md-10 col-md-offset-1 centerRow">

                    <!---add the header and navbar---->
                    <%@include file="../header_nav.jsp"%>


                    <!--FORM-->
                        <!-- Form Header-->
                        <div class="row" style="margin-left:0px; margin-right: 0px">                            
                            <div class="col-md-12" >
                                <div class="enquiry_header">Enquiry Form</div>
                            </div>
                            <div class="col-md-5">
                                <h6 style="color:red">* Denotes Required Field</h6>
                            </div>
                        </div>

                        <!--Form content-->  
                        <div class="row" style="margin-left:1%; margin-right: 2%;">
                            <div class="col-md-12 col-md-offset-1">
                                <div class="col-md-10">

                                    <!-- Form information -->

                                    <!--Your Details-->
                                    <div class="row">
                                        <div class="line" style="margin-top: 20px;"></div>

                                        <!--Salutation, Firstname, Lastname-->
                                        <div class="col-md-12" style="padding-left: 4%;">
                                            <label>Your Details</label>
                                            <!--Salutation-->
                                            <div class="form-group enquiry-form">
                                                <select title="Salutation" class="form-control" id="salutation" name="salutation">
                                                    <option value="Mr">Mr</option>
                                                    <option value="Mrs">Mrs</option>
                                                    <option value="Ms">Ms</option>
                                                    <option value="Dr">Dr</option>
                                                    <option value="Prof">Prof</option>
                                                </select>
                                            </div>
                                            <div class="form-group enquiry-form">
                                                <input required maxlength="150" placeholder="First Name*" title="First Name*" class="form-control" id="first_name" name="first_name" type="text" />																				  											
                                            </div>
                                            <div class="form-group enquiry-form">
                                                <input maxlength="150" placeholder="Middle Name" title="Middle Name*" class="form-control" id="middle_name" name="middle_name" type="text" />
                                            </div>
                                            <div class="form-group enquiry-form">
                                                <input required maxlength="150" placeholder="Last Name*" title="Last Name*" class="form-control" id="last_name" name="last_name" type="text" />																				  											
                                            </div>
                                        </div>
                                    </div>
                                    <!--Product Details-->
                                    <div class="row">
                                        <div class="line" style="margin-top: 20px;"></div>

                                        <!--Product Name, Quantity, Add button-->
                                        <div class="col-md-12" style="padding-left: 4%;">
                                            <label>Product Details</label>
                                            <br><br>
                                            <div class="row">
                                                <div class="col-md-4">
                                                    <label>Product*</label>
                                                </div>
                                                <div class="col-md-8">
                                                    <label>Quantity*</label>
                                                </div>
                                            </div>

                                            <div id='TextBoxesGroup'>
                                                <div class="row" >

                                                    <div class="col-sm-12" style="padding-left:0px">
                                                        <div class="col-xs-12 col-sm-4 enquiry-form" style="margin-bottom:10px">
                                                            <input required class="form-control" placeholder="Product Name*" maxlength="500" title="Product Name*" name="product_name0" id="product_name0" type="text" />
                                                        </div>
                                                        <div class="col-xs-12 col-sm-2" style="margin-bottom:10px">
                                                            <select class="form-control" id="quantity0" name="quantity0">
                                                            <c:forEach begin = "1" end = "10" var = "i">
                                                                
                                                                <option value="${i}">${i}</option>
                                                             </c:forEach>
                                                                </select>
                                                                
                                                        </div>
                                                        <div class="col-xs-12 col-sm-4" style="margin-bottom:10px">
                                                            <select class="form-control" id="measurement0" name="measurement0">
                                                                <option value="Kilograms">Kilograms</option>
                                                                <option value="Tonnes">Tonnes</option>
                                                                <option value="Litre">Litre</option>
                                                            </select>
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
                                    </div>

                                    <!--Contact Details-->
                                    <div class="row">
                                        <div class="line" style="margin-top: 20px;"></div>

                                        <!--Email, Country, Country Code, Phone Number-->
                                        <div class="col-md-12" style="padding-left: 4%;">
                                            <label>Contact Details</label>

                                            <div class="form-group enquiry-form">
                                                <input required maxlength="150" placeholder="Email*" title="Email" class="form-control" id="email" name="email" type="email" />																				  											
                                            </div>
                                            <div class="form-group enquiry-form">
                                                <select class="form-control" id="country" name ="companyCountry" onChange="print_state('state', this.selectedIndex);
                                                        showcode(this.value);" title="Select Country">
                                                    <option selected="selected">Select Country</option>
                                                </select>
                                                <script type="text/javascript">print_country("country");</script>
                                            </div>
                                            <div class="form-group enquiry-form">
                                                <input required maxlength="150" placeholder="Country Code*" title="Country Code" class="form-control" id="country_code" name="country_code" type="text" />																				  											
                                            </div>
                                            <div class="form-group enquiry-form">
                                                <input required maxlength="150" placeholder="Phone Number*" title="Phone Number" class="form-control" id="phone_number" name="phone_number" type="text" />																				  											
                                            </div>
                                        </div>
                                    </div>

                                    <!--Company Details-->
                                    <div class="row">
                                        <div class="line" style="margin-top: 20px;"></div>

                                        <!--Company name, Company address, Destination Port, Destination Country, Comments-->
                                        <div class="col-md-12" style="padding-left: 4%;">
                                            <label>Company Details</label>

                                            <div class="form-group enquiry-form">
                                                <input required maxlength="150" placeholder="Company Name*" title="Company Name" class="form-control" id="company_name" name="company_name" type="text" />																				  											
                                            </div>
                                            <div class="form-group enquiry-form">
                                                <input maxlength="150" placeholder="Company Address" title="Company Address" class="form-control" id="company_address" name="company_address" type="text" />																				  											
                                            </div>
                                            <div class="form-group enquiry-form">
                                                <input maxlength="150" placeholder="Destination Port" title="Destination Port" class="form-control" id="destination_port" name="destination_port" type="text" />																				  											
                                            </div>

                                            <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
                                            <script type="text/javascript" src="jquery.charactercounter.js"></script>
                                            <div class="form-group enquiry-form">
                                                <textarea id="comments" rows="5" cols="80" maxlength="500" placeholder="Comments/Notes (Max 500 characters)" title="Comments/Notes" class="form-control" name="comments"></textarea>
                                                <div id="characterLeft"></div>
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
                                        </div>
                                    </div>
                                    <!--Verification-->
                                    <div class="row">
                                        <div class="line" style="margin-top: 20px;"></div>

                                         <%@ include file = "../verification_code.jsp" %>
		                                
                                    
                                   
                                                <input type="submit" class="btn btn-info" style="width:100px;" onclick = "submitEnquiry()" value="Submit">
                                                <input type="reset" class="btn btn-danger" onclick = "reset()" style="width:100px;margin-right:5px">
                                            
                                        

                                    </div>
                                </div>
                            </div>
                        </div>
                    
                    <br>
                    <!-- Footer Codes -->
                    <%@include file="../footer.jsp"%>
                </div>
            </div>
        </div>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="js/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.js"></script>
        <script src="js/tradeasia.js"></script>
        <script src="js/sendEnquiry.js"></script>

       
    </body>
</html>