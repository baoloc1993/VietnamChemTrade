<%-- 
    Document   : product-details
    Created on : Jun 18, 2015, 11:38:52 AM
    Author     : Qianpin
--%>

<%@include file = "../setting.jsp" %>

    <body>
        <div class="container">
            <!---to wrap around all body content--->
            <div class="row">
                <!----center content--->
                <div class="col-md-10 col-md-offset-1 centerRow">

                    <!---add the header and navbar---->
                    <%@include file="../header_nav.jsp"%>
                    <jsp:include page="../index/search.jsp"/>

                    
					
                    <!--Tab table begins here-->
                    <br>
                    <a href="product"><img src="images/misc/back.png" alt="back-button"></a>
                    <br>
                    
                    <ul class="nav nav-tabs" id="myTab">
						  <li class="active"><a style = "cursor:pointer; color:black" onclick="go_inline_link('#introduction')" data-toggle="tab">Introduction</a></li>
						  <li><a style = "cursor:pointer; color:black" onclick="go_inline_link('#description')" data-toggle="tab">Description</a></li>
						  <li><a style = "cursor:pointer; color:black"  onclick="go_inline_link('#application')" data-toggle="tab">Application</a></li>
					</ul>
                    <div id='content' class="tab-content">
				      <div class="tab-pane active" id="introduction">
				        	<%@ include file = "display_product_template.jsp" %>
				      </div>
				      <div class="tab-pane" id="description">
				        ${description }
				      </div>
				      <div class="tab-pane" id="application">
				          ${application }
				      </div>
				      
				    </div>  
                    
                    <!----center white closing div--->

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
        <script>
        function go_inline_link(link){
        	var url = window.location.href + link;
        	window.location = url;
        }
        </script>
    </body>
</html>