

<link href="css/footer.css" rel="stylesheet">


<!-----footer---->
<div class="container-fluid" style=" margin-top: 10px; color:white;">

    <div class="row">

        <div class="col-md-12" style="padding:5px;background-color: #143D55">

            <div class="row">
                <!----support---->
                <div class="col-md-3" style="margin-bottom:15px;">
                    <div style="font-family: Oxygen-Bold; font-size :1.5em;margin-bottom:15px;width: 100%">
                        Support and Other Links
                    </div>
                    <div style="font-family: Verdana; font-size: 1em" class="fLinks">
                        <a href="usefulTools">Useful Tools</a> | <a href="sitemap">Sitemap</a> | <a href="feedback">Feedback</a>
                    </div>
                </div>

                <!-----subscribe---->
                <div class="col-md-5">

                    <div style="font-family: Oxygen-Bold;  font-size :1.5em;margin-bottom:10px;width: 100%">
                        Subscribe to Our Newsletter
                    </div>

                    <div class="row" style="padding-left:5px">
						<!--  START FORM -->
		                
		                    <div class="row">
		                        <div class="col-xs-10 col-md-6" style="margin-top:3%">
		                            <input type="text" class="form-control" name="name" id="newsname" placeholder="Name" title="Name" required>
		
		                        </div>
		                        <div class="col-xs-10 col-md-6" style="margin-top:3%"> 
		                        	<input type="email" class="form-control" placeholder="Email" name="email" id="newsemailid" title="email" required> 
		                        </div>
		                    </div>
		
		                    <div class="row">
		                        <div class="col-xs-10 col-md-12">
		                            <font size="1" color="#FAFFC2"></font>
		                        </div>
		                    </div>
		
		                    <div class="row">
		                        <div class="col-xs-10 col-md-12">
		                            <div style="float:right;">
		                                <button style="background-color: #7E9234" class="btn btn-info btnStyle" onclick = "submitSubscribeForm()">Subscribe</button>
		                            </div>
		                        </div>
		                    </div>
		                <!--  END FORM -->
                    </div>

                </div>

                <!-----logo--->
                <div class="col-md-4" style="margin-top: 5px">

                    <img src="images/foot-logo.png" alt="footer-logo" style="width:100%;max-width: 400px">

                </div>

            </div>



        </div>

        <div class="col-md-12">
            <div class="refulgence" style="cursor: pointer;font-size :1.1em ">
             
                <a data-toggle="modal" data-target="#policyModal"><font color="white">Privacy Policy </font></a>
                <!-- Modal for policy -->
                <div class="modal fade" id="policyModal" role="dialog">
                    <div class="modal-dialog">
                        <!-- Modal content-->
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h3 class="modal-title">Privacy Policy</h3>
                            </div>
                            <div class="modal-body">
                                <p><%@include file="privacyPage.jsp" %></p>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            </div>
                        </div>

                    </div>
                </div>

                |  

                <a data-toggle="modal" data-target="#privacyModal"><font color="white"> Terms and Conditions</font></a><br />
                <!-- Modal for Privacy -->
                <div class="modal fade" id="privacyModal" role="dialog">
                    <div class="modal-dialog">
                        <!-- Modal content-->
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h3 class="modal-title">Terms and Conditions</h3>
                            </div>
                            <div class="modal-body">
                                <p><%@include file="privacyPage.jsp" %></p>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            </div>
                        </div>

                    </div>
                </div>
                 

            </div>
        </div>
    </div>

</div>
<script>

	   function submitSubscribeForm(){
		   //alert("a");
           var name = document.getElementById('newsname').value.trim();
           var email = document.getElementById('newsemailid').value.trim();
           //alert(name);
           //var phone = document.getElementById('phone' + id).value.trim();
           //var rec = document.getElementById('requirement' + id).value.trim();
           //var files = document.getElementsByName('files[]');
           //var files = Object.keys(downloadIds).filter(function (id) {
               //return downloadIds[id];
           //});
           
           var atpos = email.indexOf("@");
           var dotpos = email.lastIndexOf(".");
           //var flag = 0;
           //var filescount = 40;
           if (name == "") {
               alert('Enter Your Name for Enquiry!');
               document.getElementById('newsemailid').focus();
               return false;
           }
           if (email == "") {
               alert('Enter Your Mail Id for Enquiry!');
               document.getElementById('newsemailid').focus();
               return false;
           }
           var email_pattrn = /^[0-9a-zA-Z_.-]+\@[0-9a-zA-Z_.-]+\.[0-9a-zA-Z_.-]+$/;
           if (email == "") {
               alert('Enter Your Email Address'); 
    
               document.getElementById('newsemailid').focus();
               return;
           }
           else if (!email_pattrn.test(email)) {
               alert('Please Enter Valid Email Address');
               document.getElementById('newsemailid').focus();
    
               return;
           }
           var data = {
                   name: name,
                   email: email,
                  // files: files.join(","),
                   
           };
           //alert(data.files);
           $.ajax({
               type: "POST",
               url: "subscribe",
               data: data,
               success: function () {
            	  // alert("Please check your email inbox to reconfirm your enquiry. ");
                   location.reload();
               },
               error: function(xhr, status, error) {
            	   if (status == 410){
            		   alert("You have subscribed before");
            	   }else{
            		   alert("Oops something is worng ");
            	   }
           	    
              },
               
           });
           //return false;
           //alert("Thank you for showing interest in our products ");

       }
   
</script>