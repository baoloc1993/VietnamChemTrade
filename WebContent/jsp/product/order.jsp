<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%@include file = "../setting.jsp" %>
<title>Nhận Bảng Báo Giá | Chemtradeasia | Tradeasia International

Pte Ltd</title> 
<meta name = "keyword" content = "Mẫu Đơn Đặt Hàng; Đặt Hàng Sản Phẩm Hóa Chất Trực

Tuyến, mua hóa chất với số lượng lớn, mua hóa chất trực

tuyến, mua hóa chất nông nghiệp trực tuyến,mua hóa chất tẩy

rửa trực tuyến, đặt hàng hóa chất với số lượng lớn; đặt hàng và

mua hàng">

<meta name = "description" content  = "Chemtradeasia: Chỉ với vài thao tác nhấp chuột, khách hàng sẽ

nhận được bảng báo giá và dễ dàng đặt mua các sản phẩm hóa

chất."/>
<script src='https://www.google.com/recaptcha/api.js'></script>

    <body>
        <div class="container">

            <!---to wrap around all body content--->
            <div class="row">
                <!----center content--->
                <div class="col-md-10 col-md-offset-1 centerRow">

                    <!---add the header and navbar and search bar---->
                    <%@include file="../header_nav.jsp"%>
                    <%@include file="../index/searchbar.jsp"%>


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
							<c:if test = "${cartsSize > 0}">
							<c:forEach var="i" begin="0" end="${cartsSize - 1 }">
							
                                <div class="row rowSpc" >
                                    <div class="col-md-12" >
                                        <div class="row">


	                                        <div class="col-md-4 col-md-offset-1" style="margin-bottom: 15px;">
	                                            <input type="hidden" name="p_ID" value="${carts.get(i).productId}"> 
	                                            Sản phẩm #${i}:<br><b style="color: #666666">${carts.get(i).productName}</b>
	
	                                            <!--origin, appearance, packaging--->
	
	                                        </div>
                                            <div class="col-md-2" >

                                                <div class="form-group">

                                                    Giá mong muốn: <input class="form-control order-form" id="expected" placeholder="USD" name="expectedPrice${i}" type="text" required>
                                                    <div id = "errorForm"></div>
                                                </div>
                                                

                                            </div>
                                            <div class="col-md-2">

                                                <div class="form-group">

                                                    Đơn vị: <select class="form-control" id="unit" name="unit">
                                                        <option value="MT">MT</option>
                                                        <option value="KG">KG</option>
                                                    </select>    
                                                </div>

                                            </div>
                                            <div class="col-md-2 ">
                                                Số lượng: <input id="qty" class="form-control order-form" name="expectedQty" placeholder="Số lượng mong muốn" type="text" required>
												<div id = "errorForm"></div>
                                            </div>


                                            <div class="col-md-1">

                                                <div class="removeBtn form-group">
                                                    <br>                                                    
                                                    <a style  = "cursor: pointer" onclick= "removeCart('${carts.get(i).productId }')" style="color:white; text-decoration: none"><div class="btn btn-danger">Xóa khỏi giỏ hàng</div></a></div>

                                            </div>
                                        </div>
                                    </div>

                                </div>
								</c:forEach>
                                </c:if>

                            </div>
                        </div>

                        <div class="row" style="margin-left:1%; margin-right: 2%;">

                            <div class="col-md-10 col-md-offset-1">

                                <!---delivery information------>
                                <div class="row">
                                    <div class="line" style="margin-top: 20px;"></div>

                                    <div class="col-md-6" style="padding-right: 4%;" >
                                        <div class="form-group">
                                            <label>Thông tin vận chuyển</label>
                                            <select class="form-control" name="deliveryCountry">
                                                <option value="">Chọn quốc gia</option>
                                                
                                                <c:forEach items = "${countries }" var = "country">
                                                	<option value="${country.country}">${country.country }</option>
												</c:forEach>


                                            </select>
                                        </div>

                                        <div class="form-group">

                                            <select class="form-control" id="team" name="deliveryTerm">
                                                
                                                <option value="">Chọn phương thức vận chuyển</option>
                                               
                                                <c:forEach items = "${deliveries }" var = "delivery">
                                                	<option value="${delivery}">${delivery }</option>
                                                </c:forEach>

                                            </select>
                                        </div>


                                        <div class="form-group">
                                            <input class="form-control" type="text" placeholder="Ngày chuyển hàng" value=""  id="targetDate" name="deliveryDate">
                                        </div>


                                    </div>

                                    <!----second column------>
                                    <div class="col-md-6" style="padding-right: 4%;">
                                        <div class="form-group">
                                            <label><font color="white">n</font></label>
                                            <input type="text" placeholder="Địa điểm chuyển hàng" value="" class="form-control" name="port">
                                        </div>

                                        <div class="form-group">

                                            <select class="form-control" name="paymentTerm">
                                                
                                                <option value="">Lựa chọn phương thức thanh toán</option>
                                                
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
                                            <label>Thông tin công ty</label>
                                            <input type="text" placeholder="Tên công ty*" class="form-control order-form" value="" name="companyName" required>
											<div id = "errorForm"></div>
                                        </div>
										
                                        <div class="form-group">
                                            <textarea name="address" placeholder="Địa chỉ" class="form-control" rows="4" ></textarea>
                                        </div>

                                        <div class="form-group">

                                            <input type="text" placeholder="Thành phố" class="form-control" value="" name="city"  >
                                        </div>

                                        <div class="row">
                                            <div class="col-md-5">

                                                <div class="form-group">

	                                               <input required type="text" placeholder="Mã quốc gia*" class="form-control order-form" value="" name="callCode">
                                                     <div id = "errorForm"></div>   
                                                </div>
                                                
                                            </div>
                                            <div class="col-md-7" style="padding-left: 19px;">
                                                <div class="form-group">
                                                    <input type="number" placeholder="Mã vùng" value="" class="form-control" name="areaCode"  />
                                                </div>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <input type="text" placeholder="Website" class="form-control" value="" name="CompanyWeb"  >
                                        </div>

                                    </div>

                                    <!----second column------>
                                    <div class="col-md-6" style="padding-right: 4%;">

                                        <div class="form-group">
                                            <label><font color="white">s</font></label>
                                            <select class="form-control" name="companyType">
                                                
                                                <option value="">Loại hình công ty</option>
                                                <c:forEach items="${types}" var = "type">
                                                	<option value="${type }">${type }</option>
                                                </c:forEach>
                                            </select>
                                        </div>

                                        <div class="form-group">
                                            <select class="form-control" onChange="print_state('state', this.selectedIndex);" id="country" name ="companyCountry" title="Select Country">
                                                <script type="text/javascript">print_country("country");</script>
                                                
                                                	<option value="">Chọn Quốc gia</option>
                                                
                                                
                                            </select>

                                        </div>

                                        <div class="form-group">

                                            <select class="form-control" title="State" style="height:35px;" name="companyState" id="state">
                                                <option value="" selected="selected" >Chọn Tỉnh/Thành phố</option>
                                            </select>

                                        </div>

                                        <div class="form-group">
                                            <input type="number" placeholder="Mã bưu điện" value="" class="form-control" name="companyZip"  >
                                        </div>


                                        <div class="row">
                                            <div class="col-md-6">

                                                <div class="form-group">
                                                    <input type="number" placeholder="Điện thoại" value="" class="form-control" name="companyPhone"  >
                                                </div>
                                            </div>
                                            <div class="col-md-6" style="padding-left: 19px;">
                                                <div class="form-group">
                                                    <input type="number" placeholder="Số FAX" value="" class="form-control" name="companyFax"  >
                                                </div>
                                            </div>
                                        </div>


                                    </div>
                                </div>                                

                                <!---contact information------>
                                <div class="row">
                                    <div class="line"></div>

                                    <div class="col-md-6" style="padding-right: 4%;">

                                        <div class="row"><div class="col-md-12" ><label>Thông tin liên lạc</label></div></div>

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
                                                    <input class="form-control order-form" type="text" placeholder="Họ*" value="" name="contactFName"  required>
                                                    <div id = "errorForm"></div>
                                                </div>
                                                
                                            </div>

                                        </div>


                                        <div class="row">
                                            <div class="col-md-4" >

                                                <div class="form-group">
                                                    
                                             		<input required type="text" placeholder="Mã quốc gia*" class="form-control order-form" value="" name="contactCallCode">
                                                    <div id = "errorForm"></div>
                                                </div>
                                                
                                            </div>
                                            <div class="col-md-8" style="padding-left: 19px;">
                                                <div class="form-group">
                                                    <input class="form-control order-form" type="number" placeholder="Điện thoại*" value="" name="contactMobile" required>
                                                    <div id = "errorForm"></div>
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

                                        <div class="row"><div class="col-md-12"><label><font color="white">Liên hệ</font></label></div></div>


                                        <div class="row">

                                            <div class="col-md-6" style="padding-right: 19px;">
                                                <div class="form-group">
                                                    <input class="form-control" value="" type="text" placeholder="Tên đệm" name="contactMName">
                                                </div>
                                            </div>
                                            <div class="col-md-6" >
                                                <div class="form-group">
                                                    <input class="form-control order-form" value="" type="text" placeholder="Tên*" name="contactLName" required>
                                                    <div id = "errorForm"></div>
                                                </div>
                                                
                                            </div>

                                        </div>

                                        <div class="form-group">
                                            <input class="form-control order-form" value="" type="email" placeholder="Email*" name="contactEmail" required>
                                            <div id = "errorForm"></div>
                                        </div>
				
                                        <div class="form-group">
                                            <input class="form-control" type="text" value="" placeholder="Messenger ID" name="contactMessengerID">
                                        </div>

                                    </div>
                                </div>

                                <!---Comment Textarea------>
                                <div class="row">

                                    <div class="line"></div>
                                    <div class="col-md-12" style="padding-right: 4%;">                                        
                                        <div class="form-group">                                           
                                            <textarea name="comments" id="comments" class="form-control" placeholder="Ghi chú/ Lưu ý" rows="5">${order.comments }</textarea>
                                        </div>
                                    </div>

                                </div>

                                <!---Verification Code------>
                                 <div class="row">
                                		<%@ include file = "../verification_code.jsp" %>

                                </div> 

                                <!----button------>
                                <div class="row" style="margin-top:20px">                                    
                                    <div class="col-md-12"> <center>
                                            <div class="form-group">
                                                <button type="submit" class="btn btn-info" onclick  = "submitOrder()">Xác nhận</button>
                                                <button type="reset" class="btn btn-danger" onclick = "reset()">Làm lại</button>
                                            </div>
                                        </center>
                                    </div>
                                </div>

                            </div>
                        </div>
                    

                    <!-- Footer Codes -->
                    <%@ include file ="../footer.jsp"%>
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
		<script src = "js/order.js">
		</script>
    </body>
</html>
