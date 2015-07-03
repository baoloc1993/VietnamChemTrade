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
        <div class="container">

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


    </body>
</html>
