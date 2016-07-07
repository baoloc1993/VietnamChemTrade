<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%@ include file = "../setting.jsp" %>
<title>Tradeasia International Pte Ltd - Việt Nam,

kinh doanh các loại hóa chất, Nhập khẩu và

Xuất khẩu Hóa Chất| Nhà Cung Cấp, Nhà

Sản Xuất</title> 
<meta name = "keyword" content = "Công ty thương mại Việt Nam, công ty kinh

doanh hóa chất tại Việt Nam, nhà sản xuất

hóa chất, nhà cung cấp hóa chất, nhà phân

phối hóa chất, nhà cung cấp hóa chất ở Việt

Nam, công ty thương mại trong nước ở Việt

Nam, nhà cung cấp trong nước ở Việt Nam,

hóa chất tẩy rửa tại Việt Nam, hóa chất sử

dụng trong ngành công nghiệp dệt may, hóa

chất sử dụng trong ngành công nghiệp cao

su, nhà cung cấp hóa chất Việt Nam">

<meta name = "description" content  = "Tradeasia International Pte Ltd- Công ty

thương mại hoá chất của Việt Nam chuyên

nhập khẩu và xuất khẩu hóa chất: hóa chất

công nghiệp cơ bản và hóa chất chuyên

dụng"/>

    <body>
        <div class="container">

            <!---to wrap around all body content--->
            <div class="row">
                <!----center content--->
                <div class="col-md-10 col-md-offset-1 centerRow">

                    <!---add the header and navbar---->
                    <%@include file="../header_nav.jsp"%>
                     <jsp:include page="searchbar.jsp"/><br>

                    <div class='container-fluid' style="margin-top: -33px;">
                        <div class="row" style="margin-top:10px">                        

                            <!-----slider--------->
                            <div class="col-sm-9" style="padding-right: 5px; margin-bottom: 10px; padding-left: 0px;">
                            	<%@ include file = "Imageslider.jsp" %>
							</div>
                            <!-------left bar ----->
                            <div class="col-sm-3" >
                            	<%@ include file = "productCategory.jsp" %>
                            </div>
                        </div>
                        <!----top products header---------->            
                        <%@ include file= "topProduct3.jsp" %>

                            <!---LINKS PANEL------>
                            <%@ include file = "link_panel2.jsp" %> 

                            <!-----blog section------>
                            <div class="row" style="  margin-bottom: 0px;">
                                <div class="col-md-12">
                                    <div class="row" style="padding-left:1%; padding-right:1%">  

                                        <div class="col-xs-12 col-md-6 blogBox">
                                            <div class="blogContent">
                                                <%@include file = "blog_slide.jsp" %>
                                            </div>
                                        </div>

                                        <!-----form------->
                                        <%@ include file = "quick_enquiry.jsp" %>

                                    </div>
                                </div>
                            </div>

                            <!-- Footer Codes -->
                            <%@include file="../footer.jsp"%>
                        </div>
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