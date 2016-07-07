<%-- 
    Document   : product-details
    Created on : Jun 18, 2015, 11:38:52 AM
    Author     : Qianpin
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "../setting.jsp" %>
<title> Chemtradeasia - ${product.productName}</title>
 		
 		<script>
 	
 			function displayInfo(){
 				var intro = document.getElementById("FirstTab");
 	 			var desc = document.getElementById("SecondTab");
 	 			var app = document.getElementById("ThirdTab");
 				intro.style.display = "block";
 				desc.style.display = "none";
 				app.style.display = "none";
 			}
 			function displayDesc(){
 				var intro = document.getElementById("FirstTab");
 	 			var desc = document.getElementById("SecondTab");
 	 			var app = document.getElementById("ThirdTab");
 				intro.style.display = "none";
 				desc.style.display = "block";
 				app.style.display = "none";
 			}
 			function displayApp(){
 				var intro = document.getElementById("FirstTab");
 	 			var desc = document.getElementById("SecondTab");
 	 			var app = document.getElementById("ThirdTab");
 				intro.style.display = "none";
 				desc.style.display = "none";
 				app.style.display = "block";
 			}
 		</script>
 		<style>
/*----- Tabs -----*/
.tabs {
    width:100%;
    display:inline-block;
}
 
    /*----- Tab Links -----*/
    /* Clearfix */
    .tab-links:after {
        display:block;
        clear:both;
        content:'';
    }
 
    .tab-links li {
        margin:0px 5px;
        float:left;
        list-style:none;
    }
 
        .tab-links a {
            padding:9px 15px;
            display:inline-block;
            border-radius:3px 3px 0px 0px;
            background:#7FB5DA;
            font-size:16px;
            font-weight:600;
            color:#4c4c4c;
            transition:all linear 0.15s;
        }
 
        .tab-links a:hover {
            background:#a7cce5;
            text-decoration:none;
        }
 
    li.active a, li.active a:hover {
        background:#fff;
        color:#4c4c4c;
    }
 
    /*----- Content of Tabs -----*/
    .tab-content {
        padding:15px;
        border-radius:3px;
        box-shadow:-1px 1px 1px rgba(0,0,0,0.15);
        background:#fff;
    }
 
        .tab {
            display:none;
        }
 
        .tab.active {
            display:block;
        }
        </style>
    <body>
        <div class="container">
            <!---to wrap around all body content--->
            <div class="row">
                <!----center content--->
                <div class="col-md-10 col-md-offset-1  centerRow">

                    <!---add the header and navbar---->
                    <%@include file="../header_nav.jsp"%>
                    <%@include file="../index/searchbar.jsp"%>

                    <!--Retrieve Product ID-->
                 	

                    <!--Tab table begins here-->
                    <br>
                    <a href="product"><img src="images/misc/back.png" alt="back-button"></a>
                    
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
                            <div class = "col-md-9">
			                    <div class="tabs">
			                        <ul class="tab-link">
			                            <li class="active"><a style = "cursor:pointer" onclick = "displayInfo()">Giới thiệu</a></li>
			                            <li class="active"><a style = "cursor:pointer" onclick = "displayDesc()">Mô tả</a></li>
			                            <li class="active"><a style = "cursor:pointer" onclick = "displayApp()">Ứng dụng</a></li>
			                        </ul>
									
			                        <div class="content-area">
			
			                            <div id="FirstTab" class=" tab active" style = "display:block"> 
			                                <%@ include file = "display_product_template.jsp" %>
			                                </div>
			                              <div id="SecondTab" class="tab inactive" style = "display:none">
			
			                                  ${description }
			
			                              </div>
			
			                              <div id="ThirdTab" class="tab inactive" style = "display:none">
			
			                                  ${application }
			                              </div>
			
			                        </div>
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
            <script src="js/tradeasia.js"></script>
            <script src = "js/product.js"> </script>
    </body>
</html>