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

                                <a href="products-top.jsp"><img style="min-width:100px" class="img-responsive" src="images/products/products-top.png" alt="top products" width="180"/></a>

                            </div>
                            <div class="col-xs-5 col-md-3">

                                <a href="products-category.jsp"><img style="min-width:100px" class="img-responsive" src="images/products/products-category.png" alt="products category" width="180"/></a>

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
	                                        <b><a href="products.jsp">${product.productName }</a></b>
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
	
	                            <div class="col-xs-5 col-md-3">
	                                <div class="row">
	                                    <!--------MSDS--------->
	                                    <div class="col-xs-4">
	                                        <center><b>MSDS</b><br>
	                                        	<a style  = "cursor:pointer" onclick="return hs.htmlExpand(this)" title="TDS" class=" ">
	                                        
	                                            	<img src="images/products/pdf_pl.png" class="img-rounded" width="30" alt="msds">
	                                            </a>
	                                            
	                                        </center>
	                                        <div class="highslide-maincontent">
									      		<table style="width:100%; text-align:left;">
													<tbody>
														<tr>
															<td>
																<!-- Mail Form Start -->
																<form name="frm${product.productId }" id="frm${product.productId}" target="_blank" method="post" action="index.php?r=TblProduct/SendMail" onsubmit="return enquiry_submit_validate('${product.productId}', this);">
																	<input type = "text" name = "spam" value = "" style = "display: none">
																	<input name="subject" id="subject${product.productId }" value="E-Mail Enquiry" type="hidden">
																	<table>
																	    <tbody>
																	    	<tr>
																	    		<td style="color:#333333; font-family:Oxygen-bold, Verdana, Arial, Helvetica, sans-serif; font-size:14px; text-align:center;" colspan="2">Enquiry on ${product.productName }</td>
																	    	</tr>
									                                        <tr>
									                                            <td colspan="2"><span style="color:#FF0000;">*</span><span style="font-family:Verdana, Arial, Helvetica, sans-serif;font-size:10px;font-style:italic;"> Fields are Mandatory</span></td>
									                                        </tr>
									                                        <tr>
									                                            <td style="color:#333333; font-family:Oxygen-Bold, Verdana, Arial, Helvetica, sans-serif; font-size:12px; ">Name<span style="color:#FF0000">*</span>  :</td>
									                                            <td>
									                                            	<input name="name" id="name${product.productId}" onkeyup="textand_space(this.value,'name${product.productId}');" maxlength="150" style="width:190px; margin-bottom:3px; margin-top:5px;" type="text" title="Name"></td>
									                                        </tr>
									                                        <tr>
									                                            <td style="color:#333333; font-family:Oxygen-Bold, Verdana, Arial, Helvetica, sans-serif; font-size:12px;">E-Mail<span style="color:#FF0000">*</span>  :</td>
									                                            <td><input name="email_id" id="email_id${product.productId }" maxlength="250" style="width: 190px; margin-bottom:3px;" type="text" title="Email_id"></td></tr>
									                                        <tr>
									                                            <td style="color:#333333; font-family:Oxygen-bold,Verdana, Arial, Helvetica, sans-serif; font-size:12px;">Phone:</td>
									                                            <td><input id="phone${product.productId }" name="phone" maxlength="150" style="width: 190px; margin-bottom:3px;" onkeyup="number_space_plus(this.value,'phone${product.productId }')" type="text" title="Phone Number"></td>
									                                        </tr>
									                                        <tr>
									                                            <td style="color:#333333; font-family:Oxygen-Bold,Verdana, Arial, Helvetica, sans-serif; font-size:12px; vertical-align:middle;" >Requirement :</td>
									                                         	<td>
																					<label for="requirement${product.productId }" style="display:none;">requirement${product.productId }</label>
																					<textarea name="requirement" id="requirement${product.productId }" maxlength="350" style="width:190px; margin-bottom:3px;" title="Requirement"></textarea>
																				</td>
									                          				</tr>
									         								<tr>
									                                        	<td>&nbsp;</td>
									                                            <td style="vertical-align:top;">
									                                            	<table>
																						<tbody>
																							<tr>
																								<td>
																									<img src="images/email_reset.png" onclick="document.frm${product.productId }.reset();document.getElementById('name${product.productId }').focus();" onkeypress="document.frm${product.productId }.reset();document.getElementById('name${product.productId }').focus();" style="cursor:pointer" alt="reset" height="26" width="88" tabindex="0">
																								</td>
																								<td>
																									<input name="submit" id="submit${product.productId }" value="Submit" src="images/email_submit.png" type="image" alt="submit" title="submit">
																								</td>
																							</tr>
																						</tbody>
																					</table>
	                                                                          </td>
	                                                                      </tr>
	                                                                  </tbody>
	                                                        		</table>
																<!-- Mail Form End -->
	                                                             </form>
	                                                         </td>
	                                                     </tr>
	                                                 </tbody>
	                                			</table>
                                        	</div>
	                                    </div>
	                                    <!--------TDS--------->
	                                    <div class="col-xs-4">
	                                        <center><b>TDS</b><br>
	                                        	<a style  = "cursor:pointer" onclick="return hs.htmlExpand(this)" title="TDS" class=" ">
	                                            	<img src="images/products/pdf_pl.png" class="img-rounded" width="30" alt="tds">
	                                            </a>
	                                        </center>
	                                         <div class="highslide-maincontent">
									      		<table style="width:100%; text-align:left;">
													<tbody>
														<tr>
															<td>
																<!-- Mail Form Start -->
																<form name="frm${product.productId }" id="frm${product.productId}" target="_blank" method="post" action="index.php?r=TblProduct/SendMail" onsubmit="return enquiry_submit_validate('${product.productId}', this);">
																	<input type = "text" name = "spam" value = "" style = "display: none">
																	<input name="subject" id="subject${product.productId }" value="E-Mail Enquiry" type="hidden">
																	<table>
																	    <tbody>
																	    	<tr>
																	    		<td style="color:#333333; font-family:Oxygen-bold, Verdana, Arial, Helvetica, sans-serif; font-size:14px; text-align:center;" colspan="2">Enquiry on ${product.productName }</td>
																	    	</tr>
									                                        <tr>
									                                            <td colspan="2"><span style="color:#FF0000;">*</span><span style="font-family:Verdana, Arial, Helvetica, sans-serif;font-size:10px;font-style:italic;"> Fields are Mandatory</span></td>
									                                        </tr>
									                                        <tr>
									                                            <td style="color:#333333; font-family:Oxygen-Bold, Verdana, Arial, Helvetica, sans-serif; font-size:12px; ">Name<span style="color:#FF0000">*</span>  :</td>
									                                            <td>
									                                            	<input name="name" id="name${product.productId}" onkeyup="textand_space(this.value,'name${product.productId}');" maxlength="150" style="width:190px; margin-bottom:3px; margin-top:5px;" type="text" title="Name"></td>
									                                        </tr>
									                                        <tr>
									                                            <td style="color:#333333; font-family:Oxygen-Bold, Verdana, Arial, Helvetica, sans-serif; font-size:12px;">E-Mail<span style="color:#FF0000">*</span>  :</td>
									                                            <td><input name="email_id" id="email_id${product.productId }" maxlength="250" style="width: 190px; margin-bottom:3px;" type="text" title="Email_id"></td></tr>
									                                        <tr>
									                                            <td style="color:#333333; font-family:Oxygen-bold,Verdana, Arial, Helvetica, sans-serif; font-size:12px;">Phone:</td>
									                                            <td><input id="phone${product.productId }" name="phone" maxlength="150" style="width: 190px; margin-bottom:3px;" onkeyup="number_space_plus(this.value,'phone${product.productId }')" type="text" title="Phone Number"></td>
									                                        </tr>
									                                        <tr>
									                                            <td style="color:#333333; font-family:Oxygen-Bold,Verdana, Arial, Helvetica, sans-serif; font-size:12px; vertical-align:middle;" >Requirement :</td>
									                                         	<td>
																					<label for="requirement${product.productId }" style="display:none;">requirement${product.productId }</label>
																					<textarea name="requirement" id="requirement${product.productId }" maxlength="350" style="width:190px; margin-bottom:3px;" title="Requirement"></textarea>
																				</td>
									                          				</tr>
									         								<tr>
									                                        	<td>&nbsp;</td>
									                                            <td style="vertical-align:top;">
									                                            	<table>
																						<tbody>
																							<tr>
																								<td>
																									<img src="images/email_reset.png" onclick="document.frm${product.productId }.reset();document.getElementById('name${product.productId }').focus();" onkeypress="document.frm${product.productId }.reset();document.getElementById('name${product.productId }').focus();" style="cursor:pointer" alt="reset" height="26" width="88" tabindex="0">
																								</td>
																								<td>
																									<input name="submit" id="submit${product.productId }" value="Submit" src="images/email_submit.png" type="image" alt="submit" title="submit">
																								</td>
																							</tr>
																						</tbody>
																					</table>
	                                                                          </td>
	                                                                      </tr>
	                                                                  </tbody>
	                                                        		</table>
																<!-- Mail Form End -->
	                                                             </form>
	                                                         </td>
	                                                     </tr>
	                                                 </tbody>
	                                				</table>
                                           		</div>
				     					</div>
	
	                                    <!----MAIL----->
	                                    <div class="col-xs-4" >
	                                        <a style  = "cursor:pointer" onclick="return hs.htmlExpand(this)" title="Email" class=" ">
												<img src="images/products/mail_pl.png" width="20" height="20" alt="email icon">
											</a>
											<div class="highslide-maincontent">
									      		<table style="width:100%; text-align:left;">
													<tbody>
														<tr>
															<td>
																<!-- Mail Form Start -->
																<form name="frm${product.productId }" id="frm${product.productId}" target="_blank" method="post" action="index.php?r=TblProduct/SendMail" onsubmit="return enquiry_submit_validate('${product.productId}', this);">
																	<input type = "text" name = "spam" value = "" style = "display: none">
																	<input name="subject" id="subject${product.productId }" value="E-Mail Enquiry" type="hidden">
																	<table>
																	    <tbody>
																	    	<tr>
																	    		<td style="color:#333333; font-family:Oxygen-bold, Verdana, Arial, Helvetica, sans-serif; font-size:14px; text-align:center;" colspan="2">Enquiry on ${product.productName }</td>
																	    	</tr>
									                                        <tr>
									                                            <td colspan="2"><span style="color:#FF0000;">*</span><span style="font-family:Verdana, Arial, Helvetica, sans-serif;font-size:10px;font-style:italic;"> Fields are Mandatory</span></td>
									                                        </tr>
									                                        <tr>
									                                            <td style="color:#333333; font-family:Oxygen-Bold, Verdana, Arial, Helvetica, sans-serif; font-size:12px; ">Name<span style="color:#FF0000">*</span>  :</td>
									                                            <td>
									                                            	<input name="name" id="name${product.productId}" onkeyup="textand_space(this.value,'name${product.productId}');" maxlength="150" style="width:190px; margin-bottom:3px; margin-top:5px;" type="text" title="Name"></td>
									                                        </tr>
									                                        <tr>
									                                            <td style="color:#333333; font-family:Oxygen-Bold, Verdana, Arial, Helvetica, sans-serif; font-size:12px;">E-Mail<span style="color:#FF0000">*</span>  :</td>
									                                            <td><input name="email_id" id="email_id${product.productId }" maxlength="250" style="width: 190px; margin-bottom:3px;" type="text" title="Email_id"></td></tr>
									                                        <tr>
									                                            <td style="color:#333333; font-family:Oxygen-bold,Verdana, Arial, Helvetica, sans-serif; font-size:12px;">Phone:</td>
									                                            <td><input id="phone${product.productId }" name="phone" maxlength="150" style="width: 190px; margin-bottom:3px;" onkeyup="number_space_plus(this.value,'phone${product.productId }')" type="text" title="Phone Number"></td>
									                                        </tr>
									                                        <tr>
									                                            <td style="color:#333333; font-family:Oxygen-Bold,Verdana, Arial, Helvetica, sans-serif; font-size:12px; vertical-align:middle;" >Requirement :</td>
									                                         	<td>
																					<label for="requirement${product.productId }" style="display:none;">requirement${product.productId }</label>
																					<textarea name="requirement" id="requirement${product.productId }" maxlength="350" style="width:190px; margin-bottom:3px;" title="Requirement"></textarea>
																				</td>
									                          				</tr>
									         								<tr>
									                                        	<td>&nbsp;</td>
									                                            <td style="vertical-align:top;">
									                                            	<table>
																						<tbody>
																							<tr>
																								<td>
																									<img src="images/email_reset.png" onclick="document.frm${product.productId }.reset();document.getElementById('name${product.productId }').focus();" onkeypress="document.frm${product.productId }.reset();document.getElementById('name${product.productId }').focus();" style="cursor:pointer" alt="reset" height="26" width="88" tabindex="0">
																								</td>
																								<td>
																									<input name="submit" id="submit${product.productId }" value="Submit" src="images/email_submit.png" type="image" alt="submit" title="submit">
																								</td>
																							</tr>
																						</tbody>
																					</table>
	                                                                          </td>
	                                                                      </tr>
	                                                                  </tbody>
	                                                        		</table>
																<!-- Mail Form End -->
	                                                             </form>
	                                                         </td>
	                                                     </tr>
	                                                 </tbody>
	                                				</table>
                                           		</div>
																												
										</div>
			                            <!-----add to cart button----->
			                            <div class="col-xs-12 col-md-2">
			                                <a style = "cursor: pointer" onclick = "addToCart(${product.productId})"><img src="images/products/add-to-cart.png">
			                                </a>
			
			                            </div>
		                        	</div>
		                 		</div>
		                 	</div>
	                     </c:forEach>
	                     
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
                 	  // alert("Please check your email inbox to reconfirm your enquiry. ");
                        location.reload();
                    },
                    error: function(xhr, textStatus, errorThrown){
                        alert('Cannot add to cart. Please try again');
                     }
                });
        	}
        
        </script>

    </body>
</html>
