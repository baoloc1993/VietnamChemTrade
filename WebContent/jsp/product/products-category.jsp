<%-- 
    Document   : products-category
    Created on : June 8, 2015, 11:24:12 AM
    Author     : Qianpin
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file = "../setting.jsp"%>
        
       

        <style>
            .cat-header {
                color: rgb(26, 82, 146);
                font-family: Oxygen-Bold,Roboto-regular,Arial;
                font-size: 150%;
                margin-top: 20px;
            }

            .cat-subheader {
                color: #151515;
                font-family: Roboto-regular,Arial;
                font-size: 90%;
                margin-bottom: 1.2%;
                margin-top: 1.2%;
            }
        </style>


    <body>

        <div class="container">
            <!---to wrap around all body content--->
            <div class="row">
                <!----center content--->
                <div class="col-md-10 cold-md-offset-1 centerRow">

                    <!---add the header and navbar and search bar---->
                    <%@include file="../header_nav.jsp"%>
                    <%@ include file ="../index/searchbar.jsp" %>

                    <div class="container-fluid">
                        <!-- Products Banner-->
                        <div class="row">
                            <div class="col-md-12" style="margin-top:10px;">
                                <img class="img-responsive" src="images/products/products-category-banner.jpg" alt="products-banner" style = "width:100%">
                            </div>
                        </div>

                       

                        <!-- Categories start-->
                        <div class="row col-md-12">
	                        <!-- Product Category -->
	                            <div class="col-md-3">
	                            
	                            	
	                                        <div style="color:white; background-color:#143D55; font-size:1.5em;"><center>Các loại sản phẩm</center></div>
	                                    
	                                    <c:forEach items = "${categories}" var = "category">
	
	                                    
	                                               
												 <div style="cursor:pointer;padding-left:1%;background-color: #337ab7;font-size: 1em;color: white;border-bottom: solid;border-width: 1px;" href="javascript:{}" onclick="window.location.href = 'category?cat=${category.id}'">
	                                            
	                                                ${category.name}
													
												</div>
	
	                                   </c:forEach>
	                            </div>
                            <div class="col-md-9">
                                <c:forEach items = "${categoryWrappers}" var = "categoryWrapper">
                                	
                                	<div class="cat-subheader">${categoryWrapper.subheader }</div>
 
	                                <!---displaying result information----->                       
	                                <div class="row" style="margin-bottom: 15px">
	                                    <div class="col-md-3 subheader">
	                                    	${categoryWrapper.subheader1 }
	                                        
	                                    </div>
	                                </div>
	                              <!--  product Result -->
								<hr>
	                      <!-- Start of all Products -->
								<c:forEach items = "${categoryWrapper.products}" var = "product">
			                        <%@include file = "display_product_template.jsp"%>
			                        
			                     </c:forEach>
                               
                                <!--Pagination Display-->
                                <div class="row">

                                    <div class="col-md-12" >
                                        <center>
                                            <div class="pagerClass">
                                                <ul id="yw1" class="pagination">
                                                    ${categoryWrapper.paging }
                                                </ul>
                                            </div> 
                                        </center>
                                    </div>
                                </div> 
                            
                            </div>
                        </div>
                    </div>
					</c:forEach>
                    <!-- Footer Codes -->
                    <%@include file="../footer.jsp"%>
                </div>
            </div>
        </div>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.js"></script>

        <!--zopim online form -->
        <script type="text/javascript">
           window.$zopim || (function (d, s) {
               var z = $zopim = function (c) {
                   z._.push(c)
               }, $ = z.s =
                       d.createElement(s), e = d.getElementsByTagName(s)[0];
               z.set = function (o) {
                   z.set.
                           _.push(o)
               };
               z._ = [];
               z.set._ = [];
               $.async = !0;
               $.setAttribute('charset', 'utf-8');
               $.src = '//v2.zopim.com/?1kUgCWtYUhiYkCh3M3I7o4tqy892pDcX';
               z.t = +new Date;
               $.
                       type = 'text/javascript';
               e.parentNode.insertBefore($, e)
           })(document, 'script');
        </script>
        
                <script type="text/javascript">
       		 //POP UP
	        hs.graphicsDir = 'http://highslide.com/highslide/graphics/';
	        hs.outlineType = 'rounded-white';
	        hs.wrapperClassName = 'draggable-header';
	        
        	//Control addToCart request
        	function addToCart(id){
        		
        		var data = {
                        pid :id,
                       // files: files.join(","),
                };
        		
        		$.ajax({
                    type: "POST",
                    url: "addToCart",
                    data: data,
                    success: function () {
                 	   alert("Please check your email inbox to reconfirm your enquiry. ");
                        location.reload();
                    },
                    error: function(xhr, textStatus, errorThrown){
                        alert(xhr.ge);
                     }
                });
        	}
        	
        	function resetDownload(fileType, id){
        		document.getElementById('name'+fileType+id).value = "";
                document.getElementById('email_id'+fileType+id).value = "";
                document.getElementById('phone'+fileType+id).value = "";
                document.getElementById('requirement'+fileType+id).value = "";
        	}
        	function submitDownloadForm(fileType,id,productName ,element){
        		
        		var name = document.getElementById('name'+fileType+id).value.trim();
                var email_id = document.getElementById('email_id'+fileType+id).value.trim();
                var phone = document.getElementById('phone'+fileType+id).value.trim();
                var requirement = document.getElementById('requirement'+fileType+id).value.trim();
                var atpos = email_id.indexOf("@");
                var dotpos = email_id.lastIndexOf(".");
                if(name == ""){
					alert('Enter Your Name for Enquiry!');
					document.getElementById('name'+id).focus();
					return false;
		 		}
		
				if(email_id == ""){
					alert('Enter Your Mail Id for Enquiry!');
					document.getElementById('email_id'+id).focus();
					return false;
				}
               	if (atpos< 1 || dotpos<atpos+2 || ((dotpos+2) >= (email_id.length))) {
                        alert("Not a valid e-mail address");
                        return false;
               	}
		        hs.close(element);
		        
		        //Send request
		        var data = {
                        name: name,
                        email: email_id,
                        phone: phone,
                        requirement: requirement,
                        productID: id,
                        productName : productName,
                        fileType: fileType,
                       // files: files.join(","),
                        
                };
                
		        $.ajax({
                    type: "POST",
                    url: "quickContact",
                    data: data,
                    success: function () {
                 	   alert("Please check your email inbox to reconfirm your enquiry. ");
                        //location.reload();
                    },
                    error: function(xhr, textStatus, errorThrown){
                        alert("There are some errors. Cannot make the enqiry now!");
                     }
                });
        	}
        
        
        </script>

    </body>
</html>
