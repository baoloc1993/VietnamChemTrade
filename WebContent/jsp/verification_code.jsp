<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <script type="text/javascript">
       function loadimage() {
    	   var text = "";
    	    var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    	    for( var i=0; i < 6; i++ )
    	        text += possible.charAt(Math.floor(Math.random() * possible.length));
    	  // String rand = Math.random();
           document.getElementById("randImage").src = "image?vCode=" + text;
           document.getElementById("vCode").value = text;
       }
       </script>
<!---Verification Code------>
   <div class="row">
      <div class="col-md-12">
          <div class="line" style="margin-top: 20px;"></div>
          <center>
              <img alt="code..." name="randImage" id="randImage" src="image?vCode=${vCode }" width="110" height="80"/>
              <a href="javascript:loadimage();"><img src="images/body/refresh.png" alt="refresh"/></a>
              <input required maxlength="6" class="form-control" style="width:50%" placeholder="Nhập mã xác nhận" id="verifyCode" title="Mã xác nhận" name="verifyCode" type="text" />
              <div id = "errorForm"></div>
               <input type = "hidden"  value ="${vCode }" id="vCode" name="vCode" type="text" />
               <div style  = "color:red"id = "errorCaptcha"></div>
               
              
          </center>
          
      </div>
  </div> 
    
    <!--Verification ENDS-->