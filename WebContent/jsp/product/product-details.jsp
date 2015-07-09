<%-- 
    Document   : product-details
    Created on : Jun 18, 2015, 11:38:52 AM
    Author     : Qianpin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "../setting.jsp" %>
 		<script src = "js/products.js"> </script>
 		<script>
 	
 			function displayInfo(){
 				var intro = document.getElementById("FirstTab");
 	 			var desc = document.getElementById("SecondTab");
 	 			var app = document.getElementById("ThirdTab");
 				intro.style.display = "block";
 				desc.style.display = "none";
 				app.style.display = "none";
 			}
 			function displayDesc(){
 				var intro = document.getElementById("FirstTab");
 	 			var desc = document.getElementById("SecondTab");
 	 			var app = document.getElementById("ThirdTab");
 				intro.style.display = "none";
 				desc.style.display = "block";
 				app.style.display = "none";
 			}
 			function displayApp(){
 				var intro = document.getElementById("FirstTab");
 	 			var desc = document.getElementById("SecondTab");
 	 			var app = document.getElementById("ThirdTab");
 				intro.style.display = "none";
 				desc.style.display = "none";
 				app.style.display = "block";
 			}
 		</script>
 		<style>
/*----- Tabs -----*/
.tabs {
    width:100%;
    display:inline-block;
}
 
    /*----- Tab Links -----*/
    /* Clearfix */
    .tab-links:after {
        display:block;
        clear:both;
        content:'';
    }
 
    .tab-links li {
        margin:0px 5px;
        float:left;
        list-style:none;
    }
 
        .tab-links a {
            padding:9px 15px;
            display:inline-block;
            border-radius:3px 3px 0px 0px;
            background:#7FB5DA;
            font-size:16px;
            font-weight:600;
            color:#4c4c4c;
            transition:all linear 0.15s;
        }
 
        .tab-links a:hover {
            background:#a7cce5;
            text-decoration:none;
        }
 
    li.active a, li.active a:hover {
        background:#fff;
        color:#4c4c4c;
    }
 
    /*----- Content of Tabs -----*/
    .tab-content {
        padding:15px;
        border-radius:3px;
        box-shadow:-1px 1px 1px rgba(0,0,0,0.15);
        background:#fff;
    }
 
        .tab {
            display:none;
        }
 
        .tab.active {
            display:block;
        }
        </style>
    <body>
        <div class="container">
            <!---to wrap around all body content--->
            <div class="row">
                <!----center content--->
                <div class="col-md-10 col-md-offset-1 centerRow">

                    <!---add the header and navbar---->
                    <%@include file="../header_nav.jsp"%>
                    <%@include file="../index/searchbar.jsp"%>

                    <!--Retrieve Product ID-->
                 

                    <!--Tab table begins here-->
                    <br>
                    <a href="product"><img src="images/misc/back.png" alt="back-button"></a>
                    
                    <div class="tabs">
                        <ul class="tab-link">
                            <li class="active"><a style = "cursor:pointer" onclick = "displayInfo()">Introduction</a></li>
                            <li class="active"><a style = "cursor:pointer" onclick = "displayDesc()">Description</a></li>
                            <li class="active"><a style = "cursor:pointer" onclick = "displayApp()">Application</a></li>
                        </ul>

                        <div class="content-area">

                            <div id="FirstTab" class=" tab active" style = "display:block"> 
                                <div class="row">
                                    <div class="col-md-12 col-xs-12">
                                        <div class="col-md-2 col-xs-12">
                                            <img src="images/${product.productDir }/${product.thumbImage}" style="max-width: 130px;min-width: 81px;width:100%;height:100%;" class="img-rounded" width="100" height="100" alt="${product.productName }">
                                        </div>
                                        <div class="col-md-6 col-xs-12">
                                            <div class="resizeInfo"> 
                                                <table >
                                                    <tr>
                                                        <td><b>Name:</b></td>
                                                        <td> ${product.productName }</td>
                                                    </tr>
                                                    <tr>
                                                        <td><b>Origin:</b></td>
                                                        <td> ${product.countryOrigin }</td>
                                                    </tr>
                                                    <tr>
                                                        <td><b>Appearance: </b></td>
                                                        <td> ${product.physicalAppear }</td>
                                                    </tr>
                                                    <tr>
                                                        <td><b>CAS No.:</b></td>
                                                        <td> ${product.casNumber }</td>
                                                    </tr>
                                                    <tr>
                                                        <td><b>Formula:</b></td>
                                                        <td> ${product.chemicalFormula }</td>
                                                    </tr>
                                                    <tr>
                                                        <td><b>H.S. Code</b></td>
                                                        <td> ${product.hsCode }</td>
                                                    </tr>
                                                    <tr>
                                                        <td><b>Common Names:  </b></td>
                                                        <td> ${product.commonNames }</td>
                                                    </tr>
                                                    <tr>
                                                        <td><b>IUPAC Name:</b></td>
                                                        <td> ${product.iupacName}</td>
                                                    </tr>
                                                    <tr>
                                                        <td><b>Packaging:</b></td>
                                                        <td>${product.packingDetail }</td>
                                                    </tr>
                                                </table>
                                            </div>
                                        </div>

                                        <div class="col-md-4 col-xs-12">
                                            <!--------MSDS--------->
                                            <div class="col-md-3 col-xs-3">
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
                                            <div class="col-md-3 col-xs-3">
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
                                            <div class="col-md-3 col-xs-3">
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
                                            <!--END OF MAIL--> 

                                            <!--add to cart-->
                                            <div class="col-md-3 col-xs-3" style="  margin-top: -15px;"><br>
                                                <a href="addTocart?pid=${product.productId }">
                                                    <img src="images/products/add-to-cart.png" style="height:50px" alt="cart">
                                                </a>
                                            </div>



                                        </div>
                                    </div>
                                </div>
                                </div>
                              <div id="SecondTab" class="tab inactive" style = "display:none">

                                  ${description }

                              </div>

                              <div id="ThirdTab" class="tab inactive" style = "display:none">

                                  ${application }
                              </div>

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