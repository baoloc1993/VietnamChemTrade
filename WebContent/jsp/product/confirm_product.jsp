<%@ include file = "../setting.jsp"%>
<body>
<%@ include file = "../header_nav2.jsp"%>
<div class="confirmation-bg">
       <div class="confirmation-box">
             <table class="tblbord" >
                  <tr style="display:none;"><th></th></tr>
                  ${message }
                  <?php if($data != "false"){ ?>
                  <tr>
                       <td>
                            <img src="images/confirmation-icon.png" style="display: block; margin-left: auto; margin-right: auto">
                            <br>
                            <div class="confirmation-mainheader">Enquiry Confirmation</div>
                            <hr>
                            <div class="confirmation-details">
                                Thank you for submitting your enquiry. Tradeasia will contact you shortly in regards to this enquiry.
                                <br>
                                We really appreciate your time and we look forward to doing business with you.
                                <br>
                            </div>
                            <a href="index.php"><input class="confirmation-btn" value="Back to Home" type="submit"></a>
                        </td>
                  </tr>
                  <?php }else{  ?>
                  <tr>
                       <td>
                            <img src="images/no-confirmation-icon.png" style="display: block; margin-left: auto; margin-right: auto">
                            <br>
                            <div class="confirmation-mainheader">No Record Received.</div>
                            <hr>
                            <div class="confirmation-details">
                                Sorry, No record was received. 
                                <br>Kindly fill in your details for the product you are enquiring on and submit again.
                                <br>Thank you. Tradeasia will contact you shortly in regards to this enquiry once we have received it.
                                <br>
                                We really appreciate your time and we look forward to doing business with you.
                                <br>
                            </div>
                            <a href="index"><input class="confirmation-btn" value="Back" type="button"></a>
                       </td>
                  </tr>
                  <?php } ?>
            </table>
         </div>
	</div>
	<%@ include file = "../footer.jsp"%>

</body>