<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="highslide-maincontent" style=" display: none;  position: absolute; z-index: 10; background-color: white;padding-left: 10px;padding-bottom: 10px;padding-right: 10px;padding-top: 10px; border-style:solid; border-width:1px;" id = "register" >
	<table style="width:100%; text-align:left;">
		<tbody>
			<tr>
				<td>
					<form name="frm108214" id="frm108214" method="post" action="index.php?r=TblProduct/SendMail" target="_blank" onsubmit="return enquiry_submit_validate(108214);">	
						<input name="p3" type="hidden" value="chemtradeasia">
						<input name="rizky" style="display:none;" type="text">												
						<input type="hidden" name="tomail" id="tomail108214" value="1">
						<input type="hidden" name="prod_name" id="prod_name108214" value="<c:out value = "${product.productName}"/>">
						<input type="hidden" name="prod_id" id="prod_id108214" value="1082">
						<input type="hidden" name="subject" id="subject108214" value="E-Mail Enquiry">
						<input type="hidden" name="to_link" id="to_link108214" value="${root}/<c:out value = "${product.msds}"/>">
							<div id="msg108214" style="font-size: 9px; color: green; min-height: 12px;"></div>
							<div style="float: right;">
								<p>
									<span style="font-family:Verdana, Arial, Helvetica, sans-serif; font-size:15px; font-style:italic; cursor: pointer;" onclick="hide_popup()">x</span>
								</p>
							</div>
							<table>
								<tbody>
									<tr>
										<td colspan="2">
											<span style="color:#FF0000;">*</span>
																	<span style="font-family:Verdana, Arial, Helvetica, sans-serif; font-size:10px; font-style:italic;"> Required Fields are Mandatory</span>
										</td>
									</tr>
									<tr>
										<td style="color:#333333; font-family:Verdana, Arial, Helvetica, sans-serif; font-size:11px;">Name<span style="color:#FF0000">*</span>  :</td>
									    	<td style="padding:1px;">
									        	<input type="text" style="width: 190px;margin-bottom:3px" name="name" id="name108214" onkeyup="textand_space(this.value,'name108214');" maxlength="150" title="name">
									        </td>
									</tr>
									<tr><td style="color:#333333; font-family:Verdana, Arial, Helvetica, sans-serif; font-size:11px;">E-Mail<span style="color:#FF0000">*</span>  :</td>
									    <td style="padding:1px;">
									        <input type="text" style="width: 190px;margin-bottom:3px" name="email_id" id="email_id108214" title="email_id"></td>
									</tr>
									<tr><td style="color:#333333; font-family:Verdana, Arial, Helvetica, sans-serif; font-size:11px;">Phone:</td>
									    <td style="padding:1px;">
									        <input type="text" style="width: 190px;margin-bottom:3px" id="phone108214" name="phone" onkeyup="number_space_plus(this.value,'phone108214')" title="phone"></td>
									</tr>
									<tr><td style="color:#333333; font-family:Verdana, Arial, Helvetica, sans-serif; font-size:11px; vertical-align:middle;">Requirement :</td>
									    <td style="padding:1px;">
									        <textarea name="requirement" id="requirement108214" title="requirement" style="width: 190px;margin-bottom:3px"></textarea></td>
									</tr>
									<tr><td style="padding-left:95px;" colspan="2"> <img src="../images/email_reset.png" style="cursor:pointer; vertical-align: middle;" height="26" width="88" onclick="document.frm108214.reset();document.getElementById('name108214').focus();" onkeypress="document.frm108214.reset();document.getElementById('name108214').focus();" tabindex="108214" alt="Email Reset2">&nbsp;<input type="image" src="../images/email_submit.png" name="submit" id="submit108214" value="Submit" alt="Submit2"></td></tr>
								</tbody>
							</table>
						</form>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<!--  END POP UP -->
<div class="title-bg span12 row-fluid" style="font-size:15px; margin-bottom:1%; margin-left:0px;">
	<div class  ="span10"> Top Products </div>
	
</div>	

<!--  POP UP REGISTER -->
	
<div id="topproduct" class="carousel slide" style = "margin-bottom: 30px; margin-top:4%; ">
                           
	<div class="carousel-inner">
	                     	
		<!-- Carousel items 
		Each Carousel will have 6 product items-->    
		<!-- LOOP wrapperTopProduct -->
        
                
		<c:forEach items = "${wrapperTopProducts}" var = "topProduct">
           	
	  		<div class="item ${topProduct.active }">    
	  		${product.productName}            

	        	<table style = "margin-left:2%;">
	               <tbody>
	               	  	<tr>        			
           			<!-- Product item -->
           			<!-- LOOP topProduct (6 times) -->
	                         			
			                <c:forEach items = "${topProduct.products}" var = "product">
								<td>
									<div class="product-slide-bg" style = "margin-right:15px;" >						
										<span class="pdd-lft">
											<a target="_top" href="" title= "<c:out value = "${product.productName}"/>"> <c:out value = "${product.productName}"/></a>
										</span>
										<div class="pdt-img-bg">
							  				<img style = "cursor: pointer;"onclick = go_to_product('${product.productId}') src="${root}/${product.productImage}" class="scroll-content-item ui-widget-header" height="111" width="150" alt="image31">
							  			</div>
							  			<div>
											
											<a class="add-btn" target="_top" href="index.php?r=TblProduct/addToQuote&amp;id=1082">
											<img class="cart-mgn" width="21px" height="18px" src="../images/cart.jpg" alt="image10">
											ADD
											</a>
										</div>
										
							  			<div   class ="span2 row-fluid" style = "margin-left: -1%;">
											<div class="flt-lft" style="float:left;">
											
											<!--  MSDS -->
												<div style="float:left;">
													<a style = "cursor: pointer;" onclick= "show_popup()" oncontextmenu="return false;" title="${product.msds }"  >
														<img class="pdf" width="20" height="20" src="../images/products/pdf_pl.png" alt="image8">
													</a>
													<a href="http://www.adobe.com/in/products/reader.html" class="myclass107" style="display:none;">Download reader</a>
													<p class="pdf-txt" style="text-align:center;">MSDS</p>
													
												</div>
												<!--  TDS -->
												<div style="float:left;">
													<a onclick="show_popup()" oncontextmenu="return false;" href="/../images/prd-64-19-7-1074578920/AceticAcidSouthKorea.pdf" title="${product.specification }">
														<img class="pdf" width="20" height="20" src="../images/products/pdf_pl.png" alt="image9">
													</a>
													<a href="http://www.adobe.com/in/products/reader.html" class="myclass107" style="display:none;">Download reader</a>
													<p class="pdf-txt" style="text-align:center;">TDS</p>
													
												</div>
											</div>
											
											<!--  EMAIL -->
											<div class="flt-lft mgn-lft" style="margin-top: -2px;   margin-left: 2%; ">
												<div style="float:left;">
													<a class="icon-mgn" onclick="show_popup()" href="#">
														<img width="20" height="20" src="../images/products/mail_pl.png" alt="image5">
													</a>
													
												</div>
												          	
												<a href="https://www.facebook.com/TradeasiaInternationalPte.Ltd" title="facebook" target="_blank" class="icon-mgn">
													<img width="20" height="20" src="${root}/images/products/facebook_pl.png" alt="image6">
												</a>														
												<a href="https://twitter.com/SreeTradeasia" title="twitter" target="_blank" class="icon-mgn">
													<img width="20" height="20" src="${root}/images/products/twitter_pl.png" alt="image7">
												</a>								
												<a class="icon-mgn" title="Skype" href="javascript:skypeCall();"> <!--skype:1?call-->
													<img width="20" height="20" src="${root}/images/products/skype_pl.png" alt="image1">
												</a>
											</div>
											
										</div>
									</div> 
								</td> 
							</c:forEach>
							<!--  END LOOP topProduct -->
							<!-- END PRODUCT ITEM -->			 
						</tr>
					</tbody>  		                              
	        	</table>
			</div>
		</c:forEach>
	          	<!--  END LOOP wrapperTopProduct -->
	          		<!-- END CASOUREL ITEM -->
	</div>
     <!-- Carousel nav -->
     <a class="carousel-control left" href="#topproduct" data-slide="prev" style = "width:2%;"></a>
     <a class="carousel-control right" href="#topproduct" data-slide="next" style = "width:2%;"></a>
     </div>

                        
