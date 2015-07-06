<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
                 	   alert("Added");
                    },
                    error: function(xhr, textStatus, errorThrown){
                    	
                    	alert("This product has been added to cart or some error ocurred");
                    	
                    	
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
        
        function go_to_product_detail(id){
        	//Send request
	        var data = {
                    id: id
                   // files: files.join(","),
                    
            };
            
	        $.ajax({
                type: "GET",
                url: "productDetail",
                data: data,
                success: function () {
                    //location.reload();
                },
                error: function(xhr, textStatus, errorThrown){
                	window.location.href = "index";
                 }
            });
        }
        
        
        $('.carousel').carousel({});

        </script>
<div class="row">
    <div class="col-md-12 title-bg">
        Top Products
    </div>
</div>


<!-----slider-------->
<div id="topproduct" class="carousel slide" style = "margin-bottom: 30px; margin-top:4%; ">
                           
	<div class="carousel-inner">
                    <c:forEach items = "${wrapperTopProducts}" var = "topProduct">
                    <!--/SLIDE 1-->
                   
                    <div class="item ${topProduct.active }">
                        <div class="row">

                            <!--/SLIDE in loop-->
                                <div class="row">
                                
                                   <c:forEach items = "${topProduct.products}" var = "product">
                                    <div class="col-xs-6 col-md-3" style="padding-right: 13px;padding-left: 5px;">
                                        <div class="thumbnail">
                                            <center>     
                								<a href="javascript:{}" onclick="document.getElementById('my_form${product.productId}').submit(); return false;" class="imgLink">
                                                
                                                    <span class="pdd-lft">
                                                        ${product.shortName }
                                                    </span>
                                                    <div style="height:110px;width:130px;" >
                                                        <img src="images/${product.productDir }/${product.thumbImage}>" title="${product.productName}"  style="width:100%; height:100%" alt="${product.productName}" class="img-rounded">
                                                    </div>
                                                </a>
                                                <div class="pdfTxt">
                                                    <div style="display:inline-block">
                                                        <a href="${product.msds}" onclick="return hs.htmlExpand(this)" onkeypress="return hs.htmlExpand(this)" >
                                                            <img style="float:left" src="images/msds.png" width="48" style="padding-right:1px;float:left"> 
                                                        </a> 
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
                                                        <a href="${product.specification}" onclick="return hs.htmlExpand(this)" onkeypress="return hs.htmlExpand(this)">
                                                            <img style="padding-left:1px;float:left" src="images/tds.png" width="50">
                                                        </a>
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
                                                        <div style="clear:both"></div>
                                                    </div>                          
                                                </div> 

                                                <div style="margin-top:10px;display: inline-block;">
                                                    <div class="row" stlye="margin:0px">
                                                       <div class="col-xs-12 col-md-8" style="padding:0px;margin-bottom:6px;">
                                                            <a onclick="return hs.htmlExpand(this)" href="#">
                                                                <img style="float:left" width="20" height="20" src="images/products/mail_pl.png" alt="image5">
                                                            </a>
                                                            <a href="https://www.facebook.com/pages/Tradeasia-International-Pte-Ltd/1560888370861020?fref=nf" title="facebook" target="_blank" class="icon-mgn">
                                                                <img style="float:left" width="20" height="20" src="images/products/facebook_pl.png" alt="image6">
                                                            </a>
                                                            <a href="https://twitter.com/SreeTradeasia" title="twitter" target="_blank" class="icon-mgn">
                                                                <img style="float:left" width="20" height="20" src="images/products/twitter_pl.png" alt="image7">
                                                            </a>
                                                            <a title="Skype" href="javascript:skypeCall();"> <!--skype:1?call-->
                                                                <img style="float:left" width="20" height="20" src="images/products/skype_pl.png" alt="image1">
                                                            </a>                                                                            

                                                        </div>

                                                        <div class="col-xs-12 col-md-4" style="float:left;padding:0px;">
                                                            <center>
                                                                <a style = "cursor:pointer" onclick = "addToCart('${product.productId}')">

                                                                    <div class="add-btn" style="cursor: pointer;">
                                                                        <img class="cart-mgn" width="21" height="18" src="images/cart.png" alt="image10">
                                                                    </div>
                                                                </a>

                                                            </center>
                                                        </div>
                                                    </div>
                                                </div>
                                            </center>
                                        </div>
                                    </div>

									</c:forEach>
                                </div>
                                <!--/row-->
                           
                        </div>
                        <!--/carousel-inner--> 
                                                
                    
                    <!--/myCarousel-->
                                                 <!--/well-->
            </div>
            
            </c:forEach>
	</div>
     <!-- Carousel nav -->
     <a class="carousel-control left" href="#topproduct" data-slide="prev" style = "width:2%;"></a>
     <a class="carousel-control right" href="#topproduct" data-slide="next" style = "width:2%;"></a>
    </div>
                        
