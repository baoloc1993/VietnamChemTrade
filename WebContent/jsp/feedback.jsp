

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file = "setting.jsp" %>
 <style>
            .feedback_header {
                color: #397c72;
                font-family: Oxygen-Bold,Roboto-regular,Arial;
                font-size: 210%;
            }
            .btn {
                width: 100px;
            }
            
        </style>
    <body>
        <div class="container">

            <!---to wrap around all body content--->
            <div class="row">
                <!----center content--->
                <div class="col-md-12  centerRow">

                    <!---add the header and navbar and search bar---->
                    <%@include file="header_nav.jsp"%>

                    <div class="container-fluid" style="margin-top:14px; margin-left:1%;">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="feedback_header" style="padding: 0!important; margin-bottom:20px">Feedback Form</div>
                            </div>                            
                        </div>

                        <!-- <form role="form" action="processFeedback" method="post">-->
                            <div class="form-group">
                                <label for="name">Họ và tên*:</label>
                                <input type="text" class="form-control" name="fullname" id="name" required>
                            </div>
                            <div class="form-group">
                                <label for="email">Email*:</label>
                                <input type="email" class="form-control" id="email" name="email" required>
                            </div>
                            <div class="form-group">
                                <label for="comments">Phản hồi*:</label>
                                <textarea name="comments" id="comments" class="form-control" rows="5" required=""></textarea>
                            </div>
                            <div class="form-group">
                                <label for="ratings">Đánh giá:</label> <p>
                                    <label class="radio-inline"><input id="ratings" type="radio" value="1" name="ratings" checked>Rất kém</label>
                                    <label class="radio-inline"><input id="ratings" type="radio" value="2" name="ratings">Kém</label>
                                    <label class="radio-inline"><input id="ratings" type="radio" value="3" name="ratings">Bình thường</label>
                                    <label class="radio-inline"><input id="ratings" type="radio" value="4" name="ratings">Tốt</label>
                                    <label class="radio-inline"><input id="ratings" type="radio" value="5" name="ratings">Rất tốt</label>
                            </div>

                            <div style="margin-top:30px;">
                                <button type="submit" class="btn btn-info btnC" onclick = "submitFeedback()">Xác nhận</button>
                                <button type="reset" class="btn btn-danger" onclick = "reset()" style="margin-left:1%">Làm lại</button>
                            </div>
                        <!-- </form>-->

                    </div>
                        <br>
                    <!-- Footer Codes -->
                   <%@include file="footer.jsp"%>
                </div>
            </div>
        </div>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="js/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.js"></script>
        <script src="js/tradeasia.js"></script>
        <script>
        	var name = document.getElementById("name");
	        var email  = document.getElementById("email");
			var comments  = document.getElementById("comments");
			var rating  = document.getElementById("ratings");
			name.defaultValue = "";
			email.defaultValue = "";
			comments.defaultValue = "";
			rating.defaultValue = 1;
			function reset(){
				name.value  = "";
				email.value = "";
				comments.value = "";
				rating.value = 1;
			}
	        function submitFeedback(){
	        	if (email == null || email.value == "" || (email.value).indexOf("@") == -1){
					alert("Please fill correct Email");
					email.focus();
					return false;
				}
	        	
	        	if (name == null || name.value == ""){
					alert("Please fill this field");
					name.focus();
					return false;
				}
	        	
	        	if (comments == null || comments.value == ""){
					alert("Please fill this field");
					comments.focus();
					return false;
				}
	        	
	        	
	        	var data = {
						name : name.value,
	        			email : email.value,
	        			comments : comments.value,
	        			rating : rating.value,
				}
				  $.ajax({
		                 type: "POST",
		                 url: "feedback",
		                 data: data,
		                 success: function () {
		              	   alert("Thank you for feedback");
		                     location.reload();
		                 },
		                 error: function(xhr, textStatus, errorThrown){
		                	
			                alert("Error! Please try again later");

		                	 
		                  }
		             });
	        	
	        }
        </script>
    </body>
</html>
