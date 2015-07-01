<%@ include file = "../setting.jsp" %>
   <style>

     .resizeInfo {
         font-family: Roboto-Regular;
     }

     @media (max-width: 500px) {

         .resizeInfo {
             font-size: 12px;
         }
     }

     td {
         padding-right:5px;
     }
 </style>

    <body>
        <div class="container-fluid">

            <!---to wrap around all body content--->
            <div class="row">
                <!----center content--->
                <div class="col-md-12 centerRow">

                    <!---add the header and navbar and search bar---->
                    <%@include file="../header_nav.jsp"%>

                    <div class="container-fluid">

                        <!-- Products Banner-->
                        <div class="row">
                            <div class="col-md-12" style="margin-top:10px;">
                                <img style = "width:100%" class="img-responsive" src="images/products/products-all-banner.jpg" alt="products-banner">

                                <!-- For skype call -->
                                <script type="text/javascript">
                                    function skypeCall() {
                                        Skype.ui({
                                            "name": "call",
                                            "participants": ["trade.asia"]
                                        })
                                    }
                                </script>

                            </div>
                        </div>

                        <div class="row" style="margin-top:10px">
                            <div class="col-xs-2 col-md-6"></div>
                            <div class="col-xs-5 col-md-3">
                                <!-- The Products buttons -->

                                <a href="products-top"><img style="min-width:100px" class="img-responsive" src="images/products/products-top.png" alt="top products" width="180"/></a>

                            </div>
                            <div class="col-xs-5 col-md-3">
								
                                <a href="category"><img style="min-width:100px" class="img-responsive" src="images/products/products-category.png" alt="products category" width="180"/></a>

                            </div>

                        </div>

                        <!-- Start of all Products -->
						<c:forEach items = "${products}" var = "product">
	                        <hr>
	                        <div class="row">
	                            <div class="col-sm-7 col-md-7">
	
	                                <div class="row" style="margin-bottom:10px">
	                                    <!--------Product Image--------->
	                                    <div class="col-xs-4 col-md-4">
	                                        <img src="images/products/individual/test.jpg" style="max-width: 130px;min-width: 81px;width:100%;height:100%;" class="img-rounded" width="100" height="100" alt="${product.productName}">
	
	                                    </div>
	                                    <!------Product Description--------->
	                                    <div class="col-xs-8 col-md-8">
	                                        <a style="color: #08146c;" href="products.jsp"><span style="display: none;">Link1</span></a>
	                                        <b><a href="products">${product.productName }</a></b>
	                                        <div class="resizeInfo"> 
	                                            <table >
	                                                <tr>
	                                                    <td><b>Origin:</b></td>
	                                                    <td> ${product.countryOrigin }</td>
	                                                </tr>
	                                                <tr>
	                                                    <td><b>Appearance: </b></td>
	                                                    <td> ${product.physicalAppear}</td>
	                                                </tr>
	                                                <tr>
	                                                    <td><b>CAS No.:</b></td>
	                                                    <td> ${product.casNumber }</td>
	                                                </tr>
	                                                <tr>
	                                                    <td><b>Formula:</b></td>
	                                                    <td>${product.chemicalFormula}</td>
	                                                </tr>
	                                            </table>
	
	                                            <!----<br>
	                                            <b>Packaging</b>
	                                            <b>:</b>
	                                            <b>${product.packingDetail}</b>--->
	                                        </div>
	                                    </div>
	                                </div>
	                            </div>
	
	                            <div class="col-xs-5">
                                <div class="row">
                                    <!--------MSDS--------->
                                    <div class="col-xs-3">
                                        <center><b>MSDS</b><br>
                                            <img src="images/products/pdf_pl.png" class="img-rounded pdf" onclick="return hs.htmlExpand(this)" onkeypress="return hs.htmlExpand(this)" width="30" alt="msds">

                                            <div class="highslide-maincontent">
                                                <!--Start MSDS Form--> 
                                                

                                                    <input type="hidden" name="pgnme" value="${pageName}">
                                                    <table style="width:100%; taxt-align:left;">
                                                        <tr style="display:none;"><th></th></tr>
                                                        <tbody><tr><td>
                                                                    <table>
                                                                        <tr style=""><th><br></th></tr>
                                                                        <tr><td style="color:#333333; color:#333333; font-family:Oxygen-Bold,Verdana, Arial, Helvetica, sans-serif; font-size:14px; margin-bottom:10px; text-align:center;" colspan="2" >Please fill the form to download TDS/MSDS of our products </td></tr>
                                                                        <tr><td colspan="2"><span style="color:#FF0000;">*</span><span style="font-family:Verdana, Arial, Helvetica, sans-serif;font-size:10px; font-style:italic;"> Fields are Mandatory</span><input name="id" id="idA${product.productId}" style="display:none" type="text" value="A${product.productId}"></td></tr>
                                                                        <tr><td style="color:#333333; font-family:Oxygen-Bold,Verdana, Arial, Helvetica, sans-serif; font-size:12px;">Name<span style="color:#FF0000">*</span>  :</td><td><input name="name" id="nameA${product.productId}" maxlength="150" style="width: 190px;margin-bottom:3px; margin-top: 5px;" type="text" title="Name"></td></tr>
                                                                        <tr><td style="color:#333333; font-family:Oxygen-Bold, Verdana, Arial, Helvetica, sans-serif; font-size:12px;">E-Mail<span style="color:#FF0000">*</span>  :</td><td><input name="email_id" id="email_idA${product.productId}" maxlength="250" style="width: 190px; margin-bottom:3px;" type="text" title="Email"></td></tr>
                                                                        <tr><td style="color:#333333; font-family:Oxygen-Bold, Verdana, Arial, Helvetica, sans-serif; font-size:12px;">Phone:</td><td><input id="phoneA${product.productId}" name="phone" maxlength="15" style="width: 190px; margin-bottom:3px;" type="text" title="Phone Number"></td></tr>
                                                                        <tr><td style="color:#333333; font-family:Oxygen-Bold,Verdana, Arial, Helvetica, sans-serif; font-size:12px; vertical-align:middle;" >Requirement :</td><td>
                                                                                <label for="requirementA${product.productId}" style="display:none;">requirementA${product.productId}</label>
                                                                                <textarea name="requirement" id="requirementA${product.productId}" maxlength="250" style="width: 190px; margin-bottom:3px;" title="Requirement"></textarea></td></tr>
                                                                        <tr><td>&nbsp;</td>
                                                                            <td style="vertical-align:top;">
                                                                                <table>
                                                                                    <tr style="display:none;"><th></th></tr>
                                                                                    <tr><td><img src="images/email_reset.png" onclick="resetDownload('A','${product.productId}');" onkeypress="resetDownload('A','${product.productId}');" style="cursor:pointer" alt="reset" height="26" width="88" tabindex="0"></td>
                                                                                        <td><input name="submit" id="submitA${product.productId}" value="Submit" src="images/email_submit.png" type="image" onclick="javascript:submitDownloadForm('A' ,'${product.productId}','${product.productName}', this);" onkeypress="javascript:submitDownloadForm('A' ,'${product.productId}','${product.productName}', this);" alt="input8"></td></tr></tbody></table>
                                                                            </td></tr></tbody></table>

                                                    </td></tr>
                                                    </tbody>
                                                    </table>
                                                <!--End MSDS Form-->
                                            </div> 
                                        </center>
                                    </div>
                                    <!--------TDS--------->
                                    <div class="col-xs-3">
                                        <center><b>TDS</b><br>
                                            <img src="images/products/pdf_pl.png" class="img-rounded pdf" onclick="return hs.htmlExpand(this)" onkeypress="return hs.htmlExpand(this)" width="30" alt="tds">

                                            <div class="highslide-maincontent">

                                                <!--Start TDS Form-->
                                                
                                                    <input type="hidden" name="pgnme" value="${pageName}">
                                                    <table style="width:100%; taxt-align:left;">
                                                        <tr style="display:none;"><th></th></tr>
                                                        <tbody><tr><td>
                                                                    <table>
                                                                        <tr style=""><th><br></th></tr>
                                                                        <tr><td style="color:#333333; color:#333333; font-family:Oxygen-Bold,Verdana, Arial, Helvetica, sans-serif; font-size:14px; margin-bottom:10px; text-align:center;" colspan="2" >Please fill the form to download TDS/MSDS of our products </td></tr>
                                                                        <tr><td colspan="2"><span style="color:#FF0000;">*</span><span style="font-family:Verdana, Arial, Helvetica, sans-serif;font-size:10px; font-style:italic;"> Fields are Mandatory</span><input name="id" id="idB${product.productId}" style="display:none" type="text" value="B${product.productId}"></td></tr>
                                                                        <tr><td style="color:#333333; font-family:Oxygen-Bold,Verdana, Arial, Helvetica, sans-serif; font-size:12px;">Name<span style="color:#FF0000">*</span>  :</td><td><input name="name" id="nameB${product.productId}" maxlength="150" style="width: 190px;margin-bottom:3px; margin-top: 5px;" type="text" title="Name"></td></tr>
                                                                        <tr><td style="color:#333333; font-family:Oxygen-Bold, Verdana, Arial, Helvetica, sans-serif; font-size:12px;">E-Mail<span style="color:#FF0000">*</span>  :</td><td><input name="email_id" id="email_idB${product.productId}" maxlength="250" style="width: 190px; margin-bottom:3px;" type="text" title="Email"></td></tr>
                                                                        <tr><td style="color:#333333; font-family:Oxygen-Bold, Verdana, Arial, Helvetica, sans-serif; font-size:12px;">Phone:</td><td><input id="phoneB${product.productId}" name="phone" maxlength="15" style="width: 190px; margin-bottom:3px;" type="text" title="Phone Number"></td></tr>
                                                                        <tr><td style="color:#333333; font-family:Oxygen-Bold,Verdana, Arial, Helvetica, sans-serif; font-size:12px; vertical-align:middle;" >Requirement :</td><td>
                                                                                <label for="requirementB${product.productId}" style="display:none;">requirementB${product.productId}</label>
                                                                                <textarea name="requirement" id="requirementB${product.productId}" maxlength="250" style="width: 190px; margin-bottom:3px;" title="Requirement"></textarea></td></tr>
                                                                        <tr><td>&nbsp;</td>
                                                                            <td style="vertical-align:top;">
                                                                                <table>
                                                                                    <tr style="display:none;"><th></th></tr>
                                                                                    <tr><td><img src="images/email_reset.png" onclick="resetDownload('B','${product.productId}');" onkeypress="resetDownload('B','${product.productId}');" style="cursor:pointer" alt="reset" height="26" width="88" tabindex="0"></td>
                                                                                        <td><input name="submit" id="submitB${product.productId}" value="Submit" src="images/email_submit.png" type="image" onclick="javascript:submitDownloadForm('B','${product.productId}','${product.productName}', this);" onkeypress="javascript:submitDownloadForm('B' ,'${product.productId}','${product.productName}', this);" alt="input8"></td></tr></tbody></table>
                                                                            </td></tr></tbody></table>

                                                    </td></tr>
                                                    </tbody></table>
                                                
                                                <!--End TDS Form-->
                                            </div>
                                        </center>
                                    </div>

                                    <!----mail----->
                                    <div class="col-xs-3">
                                        <center><br>
                                            <img src="images/products/mail_pl.png" class="img-rounded pdf" onclick="return hs.htmlExpand(this)" onkeypress="return hs.htmlExpand(this)" width="30" alt="tds">

                                            <div class="highslide-maincontent">

                                                <!--Start MAIL Form-->
                                                
                                                    <input type="hidden" name="pgnme" value="${pageName}">
                                                    <table style="width:100%; taxt-align:left;">
                                                        <tr style="display:none;"><th></th></tr>
                                                        <tbody><tr><td>
                                                                    <table>
                                                                        <tr style=""><th><br></th></tr>
                                                                        <tr><td style="color:#333333; color:#333333; font-family:Oxygen-Bold,Verdana, Arial, Helvetica, sans-serif; font-size:14px; margin-bottom:10px; text-align:center;" colspan="2" >Please fill in this form for any enquiries on our products. </td></tr>
                                                                        <tr><td colspan="2"><span style="color:#FF0000;">*</span><span style="font-family:Verdana, Arial, Helvetica, sans-serif;font-size:10px; font-style:italic;"> Fields are Mandatory</span><input name="id" id="idC${product.productId}" style="display:none" type="text" value="C${product.productId}"></td></tr>
                                                                        <tr><td style="color:#333333; font-family:Oxygen-Bold,Verdana, Arial, Helvetica, sans-serif; font-size:12px;">Name<span style="color:#FF0000">*</span>  :</td><td><input name="name" id="nameC${product.productId}" maxlength="150" style="width: 190px;margin-bottom:3px; margin-top: 5px;" type="text" title="Name"></td></tr>
                                                                        <tr><td style="color:#333333; font-family:Oxygen-Bold, Verdana, Arial, Helvetica, sans-serif; font-size:12px;">E-Mail<span style="color:#FF0000">*</span>  :</td><td><input name="email_id" id="email_idC${product.productId}" maxlength="250" style="width: 190px; margin-bottom:3px;" type="text" title="Email"></td></tr>
                                                                        <tr><td style="color:#333333; font-family:Oxygen-Bold, Verdana, Arial, Helvetica, sans-serif; font-size:12px;">Phone:</td><td><input id="phoneC${product.productId}" name="phone" maxlength="15" style="width: 190px; margin-bottom:3px;" type="text" title="Phone Number"></td></tr>
                                                                        <tr><td style="color:#333333; font-family:Oxygen-Bold,Verdana, Arial, Helvetica, sans-serif; font-size:12px; vertical-align:middle;" >Requirement :</td><td>
                                                                                <label for="requirementC${product.productId}" style="display:none;">requirementB${product.productId}</label>
                                                                                <textarea name="requirement" id="requirementB${product.productId}" maxlength="250" style="width: 190px; margin-bottom:3px;" title="Requirement"></textarea></td></tr>
                                                                        <tr><td>&nbsp;</td>
                                                                            <td style="vertical-align:top;">
                                                                                <table>
                                                                                    <tr style="display:none;"><th></th></tr>
                                                                                    <tr><td><img src="images/email_reset.png" onclick="resetDownload('C','${product.productId}');" onkeypress="resetDownload('C','${product.productId}');" style="cursor:pointer" alt="reset" height="26" width="88" tabindex="0"></td>
                                                                                        <td><input name="submit" id="submitC${product.productId}" value="Submit" src="images/email_submit.png" type="image" onclick="javascript:submitDownloadForm('C','${product.productId}','${product.productName}', this);" onkeypress="javascript:submitDownloadForm('C' ,'${product.productId}','${product.productName}', this);" alt="input8"></td></tr></tbody></table>
                                                                            </td></tr></tbody></table>
                                                    </td></tr>
                                                    </tbody></table>
                                               
                                                <!--End MAIL Form-->
                                            </div>
                                        </center>
                                    </div>                                   
                                
                            
			                            <!-----add to cart button----->
			                            <div class="col-xs-3">
			                                <a style = "cursor: pointer" onclick = "addToCart(${product.productId})"><img src="images/products/add-to-cart.png">
			                                </a>
			
			                            </div>
		                        	</div>
		                 		</div>
		                 	</div>
	                     </c:forEach>
	                     
		                     <!-- Pagination -->
	                       
	                        <div class="row">
	
	                            <div class="col-md-12" >
	                                <center>
	                                    <div class="pagerClass">
	                                        <ul id="yw1" class="pagination">
	                                        	${paging }
	                                        </ul>
	                                    </div>
	                                </center>
	                            </div>
	                        </div>

                        
                        <!-- END of ENTIRE PAGINATION-->
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

        <!--tradeasia's scripts --> 
        <script src="js/tradeasia.js"></script>
        <script type="text/javascript">
       		 //POP UP
	        hs.graphicsDir = 'http://highslide.com/highslide/graphics/';
	        hs.outlineType = 'rounded-white';
	        hs.wrapperClassName = 'draggable-header';
	        
        	//Control addToCart request
        	function addToCart(id){
        		
        		var data = {
                        pid :id,
                       // files: files.join(","),
                        
                };
        		
        		$.ajax({
                    type: "POST",
                    url: "addToCart",
                    data: data,
                    success: function () {
                 	   alert("Please check your email inbox to reconfirm your enquiry. ");
                        location.reload();
                    },
                    error: function(xhr, textStatus, errorThrown){
                        alert(xhr.ge);
                     }
                });
        	}
        	
        	function resetDownload(fileType, id){
        		document.getElementById('name'+fileType+id).value = "";
                document.getElementById('email_id'+fileType+id).value = "";
                document.getElementById('phone'+fileType+id).value = "";
                document.getElementById('requirement'+fileType+id).value = "";
        	}
        	function submitDownloadForm(fileType,id,productName ,element){
        		
        		var name = document.getElementById('name'+fileType+id).value.trim();
                var email_id = document.getElementById('email_id'+fileType+id).value.trim();
                var phone = document.getElementById('phone'+fileType+id).value.trim();
                var requirement = document.getElementById('requirement'+fileType+id).value.trim();
                var atpos = email_id.indexOf("@");
                var dotpos = email_id.lastIndexOf(".");
                if(name == ""){
					alert('Enter Your Name for Enquiry!');
					document.getElementById('name'+id).focus();
					return false;
		 		}
		
				if(email_id == ""){
					alert('Enter Your Mail Id for Enquiry!');
					document.getElementById('email_id'+id).focus();
					return false;
				}
               	if (atpos< 1 || dotpos<atpos+2 || ((dotpos+2) >= (email_id.length))) {
                        alert("Not a valid e-mail address");
                        return false;
               	}
		        hs.close(element);
		        
		        //Send request
		        var data = {
                        name: name,
                        email: email_id,
                        phone: phone,
                        requirement: requirement,
                        productID: id,
                        productName : productName,
                        fileType: fileType,
                       // files: files.join(","),
                        
                };
                
		        $.ajax({
                    type: "POST",
                    url: "quickContact",
                    data: data,
                    success: function () {
                 	   alert("Please check your email inbox to reconfirm your enquiry. ");
                        //location.reload();
                    },
                    error: function(xhr, textStatus, errorThrown){
                        alert("There are some errors. Cannot make the enqiry now!");
                     }
                });
        	}
        
        
        </script>

    </body>
</html>
