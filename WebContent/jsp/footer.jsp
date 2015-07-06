

<style>

    .footerSect {
        background-color: #7E9234; margin-top:20px;
        padding: 10px;
    }
    .footer-head {
        font-family: Oxygen-Bold,Verdana,Geneva,sans-serif;
        font-size: 16px;
        color: #ffffff;
        border-bottom: 1px #7ba830 dotted;
        padding-bottom: 6px;
    }

    .ftr-links {
    	padding-left: 0px;
        
    }


    .ftr-links li {
        list-style: none;
        background: url('images/bullet.jpg') no-repeat left;
        color: white;
    }

    .ftr-links li a {
        font-family: Oxygen-Bold,Verdana,Geneva,sans-serif;
        font-size: 13px;
        color: white;
        line-height: 28px;
        padding-left: 10px;
    }

    .news-txt {
        font-family: Oxygen-Bold,Verdana,Geneva,sans-serif;
        font-size: 13px;
        font-weight: normal;
        color: white;
        padding-top: 6px;
    }

    .btnStyle {
        height: 22px;
        margin-top: 5px;
        line-height: 12px;
        font-size: 13px;
        background-color: lightseagreen;
    }

    .flt-lft {
        float: left;
    }

    .copyright {
        font-family: Oxygen-Bold,Verdana,Geneva,sans-serif;
        font-size: 12px;
        color: #ffffff;
        font-weight: normal;
        float: right;
        position: absolute;
        margin-top: 62px;
        margin-left: 70px;
        max-width: 100%;
    }

    .foot-logo-mgn {
        margin-top: 9%;
    }

    .refulgence {
        font-family: Oxygen-Bold,Verdana,Geneva,sans-serif;
        font-size: 13px;
        color: white;
        text-decoration: none;
        float: right;
    }

    @media only screen and (max-device-width:350px){
        /* styles for mobile browsers smaller than 480px; (iPhone) */
        .copyright {
            font-size: 10px;
        }
    }


    .form-control {
        height: 30px;
        padding: 2px 7px;
        font-size: 12px;
    }
    
    
</style>
<!-----footer---->
<div class="container-fluid">
    <div class="row footerSect">
        <div class="col-md-2">
            <div class="footer-link">
                <div class="footer-head">Support</div>
                <ul class="ftr-links">

                    <li><a href="javascript:void(0);">Blog</a><!--<a href="/blog/forums/" target="_blank">Forum</a>--></li>
                    <li><a href="feedback.jsp">Feedback</a><!--<a href="http://chemlibra.tradeasia.us/blog/" target="_blank">Blog</a>--></li>
                    <li><a href="sitemap.jsp">Sitemap</a></li>
                    <li><a href="downloadCenter.jsp">Download Center</a></li>
                </ul>
            </div>
        </div>

        <div class="col-md-5">
			<!--  SUBCRIBE -->
            <div >
                <div class="footer-head">Subscribe For Newsletter</div>
                <div class="news-txt">Sign up now and start receiving our newsletter.</div>
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
                                <button style="height:30px" class="btn btn-info btnStyle" onclick = "submitSubscribeForm()">Subscribe</button>
                            </div>
                        </div>
                    </div>
                <!--  END FORM -->

            </div>
            <!--  END SUBCRIBE -->
        </div>

        <div class="col-md-5">
            <div class="footer-logo">	
                <div class="flt-lft">
                    <div class="copyright">©Copyright 2014 Chemtradeasia  |  All Rights Reserved. <br> </div>
                    <img src="images/foot-logo.jpg" class="img-responsive foot-logo-mgn" alt="image1" width="118" height="129"></div>              
            </div>
        </div>
        <div class="row">
            <div class="col-xs-12 col-md-12">
                <div class="refulgence" style="cursor: pointer">

                    <a data-toggle="modal" data-target="#policyModalF"><font color="gold">Privacy Policy </font></a>
                    <!-- Modal for policy -->
                    <div class="modal fade" id="policyModalF" role="dialog">
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

                    <a data-toggle="modal" data-target="#privacyModalF"><font color="gold"> Terms and Conditions</font></a><br />
                    <!-- Modal for Privacy -->
                    <div class="modal fade" id="privacyModalF" role="dialog">
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