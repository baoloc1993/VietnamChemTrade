<%-- 
    Document   : products-category
    Created on : June 8, 2015, 11:24:12 AM
    Author     : Qianpin
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file = "../setting.jsp" %>
<style>
     .pdf {
         cursor:pointer;
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
                    <jsp:include page="../index/searchbar.jsp"/>

                    <div class="container-fluid" style="margin-bottom:10px">
                        <!-- Products Banner-->
                        <div class="row">
                            <div class="col-md-12" style="margin-top:10px;">
                                <a href="topProduct" >
                                    <img class ="img-responsive" src="images/products/products-top-banner.jpg" alt="products-banner">
                                </a>
                            </div>
                        </div>

                        <!--Shortcut Product Buttons-->
                        <div class="row" style="margin-top:10px">

                            <div class="col-xs-2 col-md-6">

                            </div>
                            <div class="col-xs-5 col-md-3">
                                <!-- The Products buttons -->
                                <a href="products-category.jsp"><img style="min-width:100px" class="img-responsive" src="images/products/products-category.png" alt="products category" width="180"/></a>
                            </div>
                            <div class="col-xs-5 col-md-3">
                                <a href="products.jsp"><img style="min-width:100px" class="img-responsive" src="images/products/products-all.png" alt="all products" width="180"/></a>
                            </div>
                        </div>

                        <!--CONTENT-->

                        <!--Pagination CODES-->
                       
                        <!---displaying result information----->                       
                        <div class="row" style="margin-bottom: 15px">
                            <div class="col-md-3 subheader">
                            	${displayMessage }
                            </div>
                        </div>
                        
                        <!--Pagination Codes ENDS-->

						<c:forEach items = "${topProducts }" var = "product">
                        <hr>
                        	<%@ include file = "display_product_template.jsp" %>
                        </c:forEach>
                        <!--Pagination Codes-->
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
                        <!--Pagination Codes ENDS-->

                    </div>

                    <!-- Footer Codes -->
                    <%@include file="../footer.jsp"%>
                </div>
            </div>
        </div>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="js/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.js"></script>
        <script src="js/tradeasia.js"></script>

        
    </body>
</html>