<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file = "../setting.jsp" %>
<title>Sản Phẩm | Chemtradeasia |

Tradeasia International Pte Ltd - Việt Nam</title> 
<meta name = "keyword" content = "Hóa chất hàng đầu Việt Nam, Sản

phẩm bán chạy nhất Việt Nam, hóa

chất Việt Nam, hóa chất cho nông

nghiệp, hóa chất cho dệt may, hóa

chất cho tẩy rửa, hóa chất với chất

lượng tốt nhất, hóa chất với giá cả tốt

nhất, mua hóa chất với giá cạnh tranh

hơn">

<meta name = "description" content  = "Chemtradeasia: Điểm dừng chân cho

sự lựa chọn của quí khách với sự đa

dạng về hóa chất công nghiệp và hóa

chất chuyên dụng từ các nhà cung cấp

đáng tin cậy với chất lượng tốt nhất và

mức giá tốt nhất trên thị trường."/>
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
        <div class="container">

            <!---to wrap around all body content--->
            <div class="row">
                <!----center content--->
                <div class="col-md-10 col-md-offset-1 centerRow">

                    <!---add the header and navbar and search bar---->
                    <%@include file="../header_nav.jsp"%>
					<%@include file="../index/searchbar.jsp"%>
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
                        	<!-- Product Category -->
                            <div class="col-md-3">
                            
                            	
                                        <div style="color:white; background-color:#143D55; font-size:1.5em;"><center>Các loại sản phẩm</center></div>
                                    
                                    <c:forEach items = "${categories}" var = "category">

                                    
                                               
											 <div style="cursor:pointer;padding-left:1%;background-color: #337ab7;font-size: 1em;color: white;border-bottom: solid;border-width: 1px;" href="javascript:{}" onclick="window.location.href = 'category?cat=${category.id}'">
                                            
                                                ${category.name}
												
											</div>

                                   </c:forEach>
                            </div>
                            

                        
						<!-- Search by Alphabet -->
	                        
	                            <div class="col-md-9 subheader">
	                                Tìm kiếm theo chữ cái:
	                                <div style="font-size:14px;">
	                                    <a href="product?letter=a">A</a>
	                                    <a href="product?letter=b">B</a>
	                                    <a href="product?letter=c">C</a>
	                                    <a href="product?letter=d">D</a>
	                                    <a href="product?letter=e">E</a>
	                                    <a href="product?letter=f">F</a>
	                                    <a href="product?letter=g">G</a>
	                                    <a href="product?letter=h">H</a>
	                                    <a href="product?letter=i">I</a>
	                                    <a href="product?letter=j">J</a>
	                                    <a href="product?letter=k">K</a>
	                                    <a href="product?letter=l">L</a>
	                                    <a href="product?letter=m">M</a>
	                                    <a href="product?letter=n">N</a>
	                                    <a href="product?letter=o">O</a>
	                                    <a href="product?letter=p">P</a>
	                                    <a href="product?letter=q">Q</a>
	                                    <a href="product?letter=r">R</a>
	                                    <a href="product?letter=s">S</a>
	                                    <a href="product?letter=t">T</a>
	                                    <a href="product?letter=u">U</a>
	                                    <a href="product?letter=v">V</a>
	                                    <a href="product?letter=w">W</a>
	                                    <a href="product?letter=x">X</a>
	                                    <a href="product?letter=y">Y</a>
	                                    <a href="product?letter=z">Z</a>
	                                </div>
	                            
	                        
                        
                        
                        
								<!-- Start of all Products -->
								<c:forEach items = "${products}" var = "product">
									<hr>
									<%@include file  = "display_product_template.jsp" %>
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


    </body>
</html>
