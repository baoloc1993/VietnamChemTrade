


<%@ include file = "../setting.jsp" %>
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
                 	   alert("Added");
                    },
                    error: function(xhr, textStatus, errorThrown){
                    	
                    	alert("This product has been added to cart or some error ocurred");
                    	
                    	
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
                            	<%@ include file = "imageslider.jsp" %>
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
                <script>

                                                                                                                                $(document).ready(function () {
                                                                                                                                    $('#top_Carousel').carousel('pause');
                                                                                                                                });



                </script>
                </body>
                </html>