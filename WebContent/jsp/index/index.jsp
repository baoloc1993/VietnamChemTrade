


<%@ include file = "../setting.jsp" %>



    <body>
        <div class="container">

            <!---to wrap around all body content--->
            <div class="row">
                <!----center content--->
                <div class="col-md-12 centerRow">

                    <!---add the header and navbar---->
                    <%@include file="../header_nav.jsp"%>
                     <jsp:include page="searchbar.jsp"/><br>

                    <div class='container-fluid' style="margin-top: -33px;">
                        <div class="row" style="margin-top:10px">                        

                            <!-----slider--------->
                            <div class="col-sm-8" style="padding-right: 5px; margin-bottom: 10px; padding-left: 0px;">
                            	<%@ include file = "Imageslider.jsp" %>
							</div>
                            <!-------left bar ----->
                            <div class="col-sm-4" >
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
                                                Blog Content goes here
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