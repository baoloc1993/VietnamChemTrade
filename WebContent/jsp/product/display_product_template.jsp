 <%@page contentType="text/html" pageEncoding="UTF-8"%>
 <script src="js/product.js"></script>
        
       						 <div class="row">
	                            <div class="col-sm-7 col-md-7">
	
	                                <div class="row" style="margin-bottom:10px">
	                                    <!--------Product Image--------->
	                                    <div class="col-xs-4 col-md-4">
	                                        <img src="images/${product.productDir }/${product.thumbImage}" style="max-width: 130px;min-width: 81px;width:100%;height:100%;" class="img-rounded" width="100" height="100" alt="${product.productName}">
	
	                                    </div>
	                                    <!------Product Description--------->
	                                    <div class="col-xs-8 col-md-8">
	                                        <a style="color: #08146c;" href="products.jsp"><span style="display: none;">Link1</span></a>
	                                        <b><a href = "productDetail?id=${product.productId}">${product.productName }</a></b>
	                                        <div class="resizeInfo"> 
	                                            <table >
	                                                <tr>
	                                                    <td><b>Nguồn gốc:</b></td>
	                                                    <td> ${product.countryOrigin }</td>
	                                                </tr>
	                                                <tr>
	                                                    <td><b>Hình dạng: </b></td>
	                                                    <td> ${product.physicalAppear}</td>
	                                                </tr>
	                                                <tr>
	                                                    <td><b>Số CAS:</b></td>
	                                                    <td> ${product.casNumber }</td>
	                                                </tr>
	                                                <tr>
	                                                    <td><b>Công thức:</b></td>
	                                                    <td>${product.chemicalFormula}</td>
	                                                </tr>
	                                            </table>
	
	                                        </div>
	                                    </div>
	                                </div>
	                            </div>
	
	                            <div class="col-xs-5">
                                <div class="row">
                                    <!--------MSDS--------->
                                    <div class="col-xs-3">
                                        <center><b>MSDS</b><br>
                                            <img style ="cursor:pointer;" src="images/products/pdf_pl.png" class="img-rounded pdf" onclick="return hs.htmlExpand(this)" onkeypress="return hs.htmlExpand(this)" width="30" alt="msds">

                                            <div class="highslide-maincontent">
                                                <!--Start MSDS Form--> 
                                                

                                                    <input type="hidden" name="pgnme" value="${pageName}">
                                                    <table style="width:100%; taxt-align:left;">
                                                        <tr style="display:none;"><th></th></tr>
                                                        <tbody><tr><td>
                                                                    <table>
                                                                        <tr style=""><th><br></th></tr>
                                                                        <tr><td style="color:#333333; color:#333333; font-family:Oxygen-Bold,Verdana, Arial, Helvetica, sans-serif; font-size:14px; margin-bottom:10px; text-align:center;" colspan="2" >Bạn cần điền đơn để down TDS/MSDS của sản phẩm </td></tr>
                                                                        <tr><td colspan="2"><span style="color:#FF0000;">*</span><span style="font-family:Verdana, Arial, Helvetica, sans-serif;font-size:10px; font-style:italic;"> Bạn cần điền dủ thông tin</span><input name="id" id="idA${product.productId}" style="display:none" type="text" value="A${product.productId}"></td></tr>
                                                                        <tr><td style="color:#333333; font-family:Oxygen-Bold,Verdana, Arial, Helvetica, sans-serif; font-size:12px;">Name<span style="color:#FF0000">*</span>  :</td><td><input name="name" id="nameA${product.productId}" maxlength="150" style="width: 190px;margin-bottom:3px; margin-top: 5px;" type="text" title="Tên"></td></tr>
                                                                        <tr><td style="color:#333333; font-family:Oxygen-Bold, Verdana, Arial, Helvetica, sans-serif; font-size:12px;">E-Mail<span style="color:#FF0000">*</span>  :</td><td><input name="email_id" id="email_idA${product.productId}" maxlength="250" style="width: 190px; margin-bottom:3px;" type="text" title="Email"></td></tr>
                                                                        <tr><td style="color:#333333; font-family:Oxygen-Bold, Verdana, Arial, Helvetica, sans-serif; font-size:12px;">Điện thoại:</td><td><input id="phoneA${product.productId}" name="phone" maxlength="15" style="width: 190px; margin-bottom:3px;" type="text" title="Phone Number"></td></tr>
                                                                        <tr><td style="color:#333333; font-family:Oxygen-Bold,Verdana, Arial, Helvetica, sans-serif; font-size:12px; vertical-align:middle;" >Yêu cầu :</td><td>
                                                                                <label for="requirementA${product.productId}" style="display:none;">requirementA${product.productId}</label>
                                                                                <textarea name="requirement" id="requirementA${product.productId}" maxlength="250" style="width: 190px; margin-bottom:3px;" title="Yêu cầu"></textarea></td></tr>
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
                                            <img style ="cursor:pointer;" src="images/products/pdf_pl.png" class="img-rounded pdf" onclick="return hs.htmlExpand(this)" onkeypress="return hs.htmlExpand(this)" width="30" alt="tds">

                                            <div class="highslide-maincontent">

                                                <!--Start TDS Form-->
                                                
                                                    <input type="hidden" name="pgnme" value="${pageName}">
                                                    <table style="width:100%; taxt-align:left;">
                                                        <tr style="display:none;"><th></th></tr>
                                                        <tbody><tr><td>
                                                                    <table>
                                                                        <tr style=""><th><br></th></tr>
                                                                        <tr><td style="color:#333333; color:#333333; font-family:Oxygen-Bold,Verdana, Arial, Helvetica, sans-serif; font-size:14px; margin-bottom:10px; text-align:center;" colspan="2" >Bạn cần điền đơn để down TDS/MSDS của sản phẩm </td></tr>
                                                                        <tr><td colspan="2"><span style="color:#FF0000;">*</span><span style="font-family:Verdana, Arial, Helvetica, sans-serif;font-size:10px; font-style:italic;"> Bạn cần điền dủ thông tin</span><input name="id" id="idB${product.productId}" style="display:none" type="text" value="B${product.productId}"></td></tr>
                                                                        <tr><td style="color:#333333; font-family:Oxygen-Bold,Verdana, Arial, Helvetica, sans-serif; font-size:12px;">Tên<span style="color:#FF0000">*</span>  :</td><td><input name="name" id="nameB${product.productId}" maxlength="150" style="width: 190px;margin-bottom:3px; margin-top: 5px;" type="text" title="Tên"></td></tr>
                                                                        <tr><td style="color:#333333; font-family:Oxygen-Bold, Verdana, Arial, Helvetica, sans-serif; font-size:12px;">E-Mail<span style="color:#FF0000">*</span>  :</td><td><input name="email_id" id="email_idB${product.productId}" maxlength="250" style="width: 190px; margin-bottom:3px;" type="text" title="Email"></td></tr>
                                                                        <tr><td style="color:#333333; font-family:Oxygen-Bold, Verdana, Arial, Helvetica, sans-serif; font-size:12px;">Điện thoại:</td><td><input id="phoneB${product.productId}" name="phone" maxlength="15" style="width: 190px; margin-bottom:3px;" type="text" title="Điện thoại"></td></tr>
                                                                        <tr><td style="color:#333333; font-family:Oxygen-Bold,Verdana, Arial, Helvetica, sans-serif; font-size:12px; vertical-align:middle;" >Yêu cầu :</td><td>
                                                                                <label for="requirementB${product.productId}" style="display:none;">requirementB${product.productId}</label>
                                                                                <textarea name="requirement" id="requirementB${product.productId}" maxlength="250" style="width: 190px; margin-bottom:3px;" title="Yêu cầu"></textarea></td></tr>
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
                                            <img style ="cursor:pointer;" src="images/products/mail_pl.png" class="img-rounded pdf" onclick="return hs.htmlExpand(this)" onkeypress="return hs.htmlExpand(this)" width="30" alt="tds">

                                            <div class="highslide-maincontent">

                                                <!--Start MAIL Form-->
                                                
                                                    <input type="hidden" name="pgnme" value="${pageName}">
                                                    <table style="width:100%; taxt-align:left;">
                                                        <tr style="display:none;"><th></th></tr>
                                                        <tbody><tr><td>
                                                                    <table>
                                                                        <tr style=""><th><br></th></tr>
                                                                        <tr><td style="color:#333333; color:#333333; font-family:Oxygen-Bold,Verdana, Arial, Helvetica, sans-serif; font-size:14px; margin-bottom:10px; text-align:center;" colspan="2" >Bạn cần điền đơn nếu muốn gửi yêu cầu về sản phẩm. </td></tr>
                                                                        <tr><td colspan="2"><span style="color:#FF0000;">*</span><span style="font-family:Verdana, Arial, Helvetica, sans-serif;font-size:10px; font-style:italic;"> Bạn cần điền dủ thông tin</span><input name="id" id="idC${product.productId}" style="display:none" type="text" value="C${product.productId}"></td></tr>
                                                                        <tr><td style="color:#333333; font-family:Oxygen-Bold,Verdana, Arial, Helvetica, sans-serif; font-size:12px;">Tên<span style="color:#FF0000">*</span>  :</td><td><input name="name" id="nameC${product.productId}" maxlength="150" style="width: 190px;margin-bottom:3px; margin-top: 5px;" type="text" title="Tên"></td></tr>
                                                                        <tr><td style="color:#333333; font-family:Oxygen-Bold, Verdana, Arial, Helvetica, sans-serif; font-size:12px;">E-Mail<span style="color:#FF0000">*</span>  :</td><td><input name="email_id" id="email_idC${product.productId}" maxlength="250" style="width: 190px; margin-bottom:3px;" type="text" title="Email"></td></tr>
                                                                        <tr><td style="color:#333333; font-family:Oxygen-Bold, Verdana, Arial, Helvetica, sans-serif; font-size:12px;">Điện thoại:</td><td><input id="phoneC${product.productId}" name="phone" maxlength="15" style="width: 190px; margin-bottom:3px;" type="text" title="Điện thoại"></td></tr>
                                                                        <tr><td style="color:#333333; font-family:Oxygen-Bold,Verdana, Arial, Helvetica, sans-serif; font-size:12px; vertical-align:middle;" >Yêu cầu :</td><td>
                                                                                <label for="requirementC${product.productId}" style="display:none;">requirementB${product.productId}</label>
                                                                                <textarea name="requirement" id="requirementB${product.productId}" maxlength="250" style="width: 190px; margin-bottom:3px;" title="Yêu cầu"></textarea></td></tr>
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
			                                <a style = "cursor: pointer" onclick = "addToCart(${product.productId})"><img src="images/products/add-to-cart.png" style = "width: 100%;">
			                                </a>
			
			                            </div>
		                        	</div>
		                 		</div>
		                 	</div>
