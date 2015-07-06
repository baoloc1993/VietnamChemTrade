<%-- 
    Document   : index
    Created on : May 21, 2015, 11:24:12 AM
    Author     : Qianpin
--%>


<%@ include file = "../setting.jsp" %>
    <body>
        <div class="container">

            <!---to wrap around all body content--->
            <div class="row">
                <!----center content--->
                <div class="col-md-10 col-md-offset-1 centerRow">

                    <!---add the header and navbar and search bar---->
                    <%@include file="../header_nav.jsp"%>

                    <!-- CountryDAO to retrieve data from tbl_countries and loop in the drop down list -->
                    
                    <!-- Form goes into tbl_quickquote -->
                    <div class="full-enquiry-bg">
                        <div class="full-enquiry-box">
                            <form enctype="text/plain" method="post" name="send-enquiry-form" action="include/validate.jsp">
                                <table style="width:100%;">

                                    <tbody><tr><th>

                                            </th>
                                        </tr>
                                        <tr>
                                            <td style="width:35%;"><span style="font-size: 17pt" class="full-enquiry-head">Enquiry Form</span></td>
                                        </tr>
                                        <tr>
                                            <td colspan="2" class="full-enquiry-txt-title" style="width: 93%; text-align: left">
                                                <p class="enquiry-header"> Step 1: Your Details</p><br>
                                            </td>
                                        </tr>

                                        <tr>
                                            <td class="full-enquiry-header">
                                                Salutation* 
                                            </td>
                                            <td class="full-enquiry-txt">

                                                <select required title="Salutation" class="full-enquiry-field" name="salutation">
                                                    <option value="" selected="selected">Select</option>
                                                    <option value="Mr">Mr</option>
                                                    <option value="Mrs">Mrs</option>
                                                    <option value="Ms">Ms</option>
                                                    <option value="Dr">Dr</option>
                                                    <option value="Prof">Prof</option>
                                                </select>	                        	                    </td>
                                        </tr>  
                                        <tr>
                                            <td class="full-enquiry-header">
                                                First Name*
                                            </td>
                                            <td class="full-enquiry-txt">

                                                <input required maxlength="200" placeholder="First Name" title="First Name" class="full-enquiry-field" name="TblQuickquote[first_name]" id="TblQuickquote_first_name" type="text">	                    		                    </td>
                                        </tr>    
                                        <tr>
                                            <td class="full-enquiry-header">
                                                Last Name*
                                            </td>
                                            <td class="full-enquiry-txt">

                                                <input required maxlength="200" placeholder="Last Name" title="Last Name" class="full-enquiry-field" name="TblQuickquote[last_name]" id="TblQuickquote_last_name" type="text">	                    	    	                            
                                            </td>
                                        </tr> 
                                        <tr>
                                            <td colspan="2" class="full-enquiry-txt-title" style="width: 93%; text-align: left">
                                                <br>
                                                <hr style="width: 99.8%; background-color: #3c3c3c; height: 0.5px; border: 1px solid #3c3c3c">
                                                <br>    
                                                <p class="enquiry-header"> Step 2: Product Details</p><br>
                                            </td>
                                        </tr>

                                        <tr>
                                            <td class="full-enquiry-header">
                                                Product Name* 
                                            </td>
                                            <td class="full-enquiry-txt">

                                                <select required title="product_name" class="full-enquiry-field" name="product_name[]" id="product_nameIDID">
                                                    <option value="" selected="selected">Select</option>
                                                    <c:forEach items = "${products}" var = "product">                          
                                                    	<option value="${product.productName}">${product.productName}</option>
                                                    </c:forEach>
                                                </select>	                        	  
                                            </td>
                                        <tr>
                                            <td class="full-enquiry-header">
                                                Quantity* 
                                            </td>
                                            <td class="full-enquiry-txt">
                                                <select required title="quantity" class="full-enquiry-field" name="quantity[]" id="quantityIDID">
                                                    <option value="" selected="selected">Select</option>                              
                                                    <option value="1">1</option>
                                                    <option value="2">2</option>
                                                    <option value="3">3</option>
                                                    <option value="4">4</option>
                                                    <option value="5">5</option>
                                                    <option value="6">6</option>
                                                    <option value="7">7</option>
                                                    <option value="8">8</option>
                                                    <option value="9">9</option>
                                                    <option value="10">10</option>
                                                </select>	                        	  
                                                <select name="units[]">
                                                    <option value="kilogram">Kilogram</option>
                                                    <option value="tonnes">Tonnes</option>
                                                    <option value="litre">Litre</option>
                                                </select>
                                                <input type="button" id="add_Button" onclick="addField()" value="+">(limit 10)
                                            </td>
                                        </tr>
                                        <tr>
                                            <td colspan="2" class="full-enquiry-txt-title" style="width: 93%; text-align: left">
                                                <br>
                                                <hr style="width: 99.8%; background-color: #3c3c3c; height: 0.5px; border: 1px solid #3c3c3c">
                                                <br>    
                                                <p class="enquiry-header"> Step 3: Contact Details</p><br>
                                            </td>
                                        </tr> 
                                        <tr>
                                            <td class="full-enquiry-header">
                                                Email address*
                                            </td>
                                            <td class="full-enquiry-txt">

                                                <input required maxlength="200" placeholder="Email" title="email id" class="full-enquiry-field" name="TblQuickquote[email_id]" id="TblQuickquote_email_id" type="email">	                        	                    </td>
                                        </tr>
                                        <tr>
                                            <td class="full-enquiry-header">
                                                Country
                                            </td>
                                            <td class="full-enquiry-txt">

                                                <select title="country" style="width: 43.9%; " class="full-enquiry-field" name="TblQuickquote[country]" id="TblQuickquote_country">
                                                    <!-- id TblQuickquote_country is needed for the jQuery -->
                                                    <option value="">Select Country</option>
                                                    <c:forEach items = "${products}" var = "product">                          
                                                    	<option value="${product.countryCode}">${product.countryOrigin}</option>
                                                    </c:forEach>
                                                    
                                                </select>  
                                                <script type="text/javascript">
                                                    /*<![CDATA[*/

                                                    jQuery(function ($tp) {
                                                        jQuery('body').on('change', '#TblQuickquote_country', function () {
                                                            jQuery.ajax({'type': 'post', 'url': '/send-enquiry.jsp', 'cache': false, 'data': jQuery(this).parents("form").serialize(), 'success': function (html) {
                                                                    jQuery("#TblQuickquote_country_code").html(html);
                                                                }});
                                                            return false;
                                                        });
                                                    });
                                                    /*]]>*/
                                                </script>

                                            </td>
                                        </tr>    
                                        <tr>
                                            <td class="full-enquiry-header">
                                                Country Code* 
                                            </td>
                                            <td class="full-enquiry-txt">                                        
                                                <input required type="text" placeholder="Code" name="countryCode[]" title="contactNO" id="contactNOIDID" class="full-enquiry-field">                                                
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="full-enquiry-header">
                                                Phone Number* 
                                            </td>
                                            <td class="full-enquiry-txt">                                        
                                                <input required type="text" placeholder="123456" name="contactNo[]" title="contactNO" id="contactNOIDID" class="full-enquiry-field">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td colspan="2" class="full-enquiry-txt-title" style="width: 93%; text-align: left">
                                                <br>
                                                <hr style="width: 99.8%; background-color: #3c3c3c; height: 0.5px; border: 1px solid #3c3c3c">
                                                <br>    
                                                <p class="enquiry-header"> Step 4: Company Details</p><br>
                                            </td>
                                        </tr>    
                                        <tr>
                                            <td class="full-enquiry-header">
                                                Company name*
                                            </td>
                                            <td class="full-enquiry-txt">

                                                <input required maxlength="200" placeholder="Company Name" title="Company Name" class="full-enquiry-field" name="TblQuickquote[company_name]" id="TblQuickquote_company_name" type="text">	                        	                    </td>
                                        </tr>   
                                        <tr>
                                            <td class="full-enquiry-header">
                                                Company address
                                            </td>
                                            <td class="full-enquiry-txt">
                                                <input maxlength="200" placeholder="Company Address" title="Company Address" class="full-enquiry-field" name="TblQuickquote[company_addr]" id="TblQuickquote_company_addr" type="text">	                    </td>
                                        </tr> 
                                        <tr>
                                            <td class="full-enquiry-header">
                                                Destination port
                                            </td>
                                            <td class="full-enquiry-txt">

                                                <input maxlength="200" placeholder="Destination Port" title="Destination Port" class="full-enquiry-field" name="TblQuickquote[dest_port]" id="TblQuickquote_dest_port" type="text">	                          
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="full-enquiry-header">
                                                Destination country
                                            </td>
                                            <td class="full-enquiry-txt">
                                                <select onchange="goto_pg(this.value)" title="country" style="width: 43.9%; " class="full-enquiry-field" name="dest_country" id="dest_country">             
                                                    <option value="">Select Country</option>
                                                    <c:forEach items = "${products}" var = "product">                          
                                                    	<option value="${product.countryCode}">${product.countryOrigin}</option>
                                                    </c:forEach>
                                                </select>
                                            </td>
                                        </tr>      

                                        <tr>
                                            <td class="full-enquiry-header">
                                                Comments (Max 800 characters)
                                            </td>
                                            <td class="full-enquiry-txt">
                                                <label for="comment" style="display:none;">comment</label>

                                                <textarea maxlength="800" placeholder="Comments" name="TblQuickquote[comment]" id="comment" title="comment" class="full-enquiry-comment"></textarea>
                                            </td>
                                        </tr>
                                        <tr><td style="height:10;"></td></tr>
                                        <tr>
                                            <td colspan="2" style="text-align:center;">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="full-enquiry-header">
                                                Verification Code*
                                            </td>
                                            <td class="full-enquiry-header" width="15%">
                                                <img alt="code..." name="randImage" id="randImage" src="include/image.jsp" style="width: 100%; height: 100%;"/>
                                                <a href="javascript:loadimage();"><img src="images/body/refresh.png"/></a>
                                            </td>       
                                        <tr>
                                            <td class="full-enquiry-header">
                                                <%="     "%><!-- Empty to push the verification code text bar to the next td -->
                                            </td>
                                            <td class="full-enquiry-header">
                                                <input required maxlength="6" style="verify-code" placeholder="Enter Code" title="verifyCode" name="verifyCode" type="text" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td colspan="2" style="text-align:center;">
                                                <input value="Submit" name="submit" type="submit" class="full-enquiry-submit">
                                                <input value="Reset" name="reset" type="reset" class="full-enquiry-submit" style="margin-left: 0%;">
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </form>
                            <!-- To refresh a new verification code-->
                            <script language="javascript">
                                function loadimage() {
                                    document.getElementById("randImage").src = "include/image.jsp?" + Math.random();
                                }
                            </script>
                        </div>
                    </div> 

                    <!-- Footer Codes -->
                    <%@include file="../footer.jsp"%>
                </div>
            </div>
        </div>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.js"></script>


        <script src="js/tradeasia.js"></script>
    </body>
</html>
