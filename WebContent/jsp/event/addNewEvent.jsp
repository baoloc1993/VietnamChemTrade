<%@include file = "../setting.jsp" %>
 <link href="css/add-new-event.css" rel="stylesheet">
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
    <body>
        <div class="container">
            <!---to wrap around all body content--->
            <div class="row">
                <!--center content-->
                <div class="col-md-10 col-md-offset-1  centerRow">

                    <!--add the header and navbar and search bar-->
                    <%@include file="../header_nav.jsp"%>
                  

                    <!--- CountryDAO to retrieve data from tbl_countries and loop in the drop down list --->
                   
                    <div class="row">
                        <div class="col-md-12">
                            <div class="col-xs-12 col-md-12">
                                <div style="background-color:#0f6aa3;width:96%">
                                    <center><img class="img-responsive" src="images/create-event-banner.jpg"></center>
                                    <h3 style="text-align:center; color: #ffffff;">Submit an Event</h3> 
                                </div>

                                <div class="success">
                                    <center><b>*Please send us your Event photo to webmaster@chemtradeasia.com, to display the photo near your event details</b></center>
                                </div> 

                                <div id="event_form" method="post" role="form" action="addEvent" class="event-form">

                                    <!--Contact Details-->
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="line" style="margin-top: 20px;"></div>
                                            <!--First Column: Salutation, Firstname, Middlename, Lastname-->
                                            <div class="col-md-6" style="padding-right: 4%;">
                                                <div class="row">
                                                    <div class="col-md-12" >
                                                        <label>Contact Details</label>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <select required class="form-control" name="salutation" id="salutation">
                                                        <option value="0">Salutation*</option>
                                                        <option value="1">Mr</option>
                                                        <option value="2">Mrs</option>
                                                        <option value="3">Ms</option>
                                                        <option value="4">Dr</option>
                                                        <option value="5">Prof</option>
                                                    </select> 
                                                </div>

                                                <div class="form-group" id="firstNm">

                                                    <input required maxlength="250" title="First Name" value="${firstName }" type="text" class="form-control" name="firstNm"/>
                                                    
                                                </div>

                                                <div class="form-group">
                                                    <input maxlength="200" title="Middle Name" placeholder="Middle Name" type="text" class="form-control" name="middleNm"  id="middleNm"/>
                                                </div>

                                                <div class="form-group">
                                                    <input required maxlength="250" title="Last Name" placeholder="Last Name*" type="text" class="form-control" name="lastNm" id="lastNm" /> 
                                                </div>
                                            </div>

                                            <!--Second Column: Countrycode, Areacode, Phone, Email-->
                                            <div class="col-md-6" style="padding-right: 4%;" >
                                                <!--Give an imaginary Title for alignment-->
                                                <label><font color="white">n</font></label>
                                                <div class="form-group">
                                                    <input required maxlength="250" title="Country Code" placeholder="Country Code*" type="text" class="form-control" name="countryCode" id="countryCode" /> 
                                                </div>

                                                <div class="form-group">
                                                    <input required maxlength="250" title="Area Code" placeholder="Area Code*" type="text" class="form-control" name="areaCode" id="areaCode" /> 
                                                </div>

                                                <div class="form-group">
                                                    <input required maxlength="250" title="Phone" placeholder="Phone Number*" type="text" class="form-control" name="phone" id="phone" /> 
                                                </div>

                                                <div class="form-group">
                                                    <input required maxlength="250" title="Email" placeholder="Email*" type="email" class="form-control" name="email" id="email" /> 
                                                </div>
                                            </div>                                                
                                        </div>
                                    </div>

                                    <!--Event Details-->
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="line" style="margin-top: 20px;"></div>

                                            <div class="col-md-12" style="padding-right: 4%;">
                                                <div class="form-group">
                                                    <label>Event Details</label>
                                                    <input type="text" placeholder="Company Name*" class="form-control" name="companyName" required>
                                                </div>

                                                <div class="form-group">
                                                    <input required maxlength="100" placeholder="Event Name*" title="Event Name" class="form-control" name="title" id="title" type="text" /> 
                                                </div>

                                                <div class="form-group"><!--Event Date-->
                                                    <%@include file="timeChoose.jsp"%>
                                                </div>

                                                <div class="form-group">
                                                    <input required maxlength="1500" placeholder="Event Location*" title="Event Location" class="form-control" name="location" id="location" type="text" /> 
                                                </div>

                                                <div class="form-group">
                                                    <input placeholder="Online Link of the Event" title="Event Link" class="form-control" name="link" id="link" type="text" />
                                                </div>

                                                <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
                                                <script type="text/javascript" src="jquery.charactercounter.js"></script>

                                                <div class="form-group">
                                                    <textarea required maxlength="1000" rows="10" placeholder="Event Description* (Max 1000 characters)" title="Event Description" class="form-control" name="description" id="description"></textarea> 
                                                    <div id="characterLeft"></div>
                                                </div>

                                                <script>
            $('#characterLeft').text('1000 characters left');
            $('#description').keyup(function () {
                var max = 1000;
                var len = $(this).val().length;
                if (len >= max) {
                    $('#characterLeft').text(' You have reached the limit');
                } else {
                    var ch = max - len;
                    $('#characterLeft').text(ch + ' characters left');
                }
            });
                                                </script>
                                            </div>
                                        </div>

                                         <!---Verification Code------>
		                                 <div class="row">
		                                    <div class="col-md-12">
		                                        <div class="line" style="margin-top: 20px;"></div>
		                                        <center>
		                                            <img alt="code..." name="randImage" id="randImage" src="image?vCode=${vCode }" width="110" height="80"/>
		                                            <a href="javascript:loadimage();"><img src="images/body/refresh.png" alt="refresh"/></a>
		                                            <input required maxlength="6" class="form-control" style="width:50%" placeholder="Enter Code" id="verifyCode" title="verifyCode" name="verifyCode" type="text" />
		                                            <div id = "errorForm"></div>
		                                             <input type = "hidden"  value ="${vCode }" id="vCode" name="vCode" type="text" />
		                                             <div style  = "color:red"id = "errorCaptcha"></div>
		                                             
		                                            
		                                        </center>
		                                        
		                                    </div>
		                                </div>  
                                        <!----button------>
                                        <div class="row" style="margin-top:20px">                                    
                                            <div class="col-md-12"> <center>
                                                    <div class="form-group">
                                                        <button type="submit" onclick  = "addEvent()" class="btn btn-info btnC">Submit</button>
                                                        <button type="reset" onclick  = "reset" class="btn btn-danger">Reset</button>
                                                    </div>
                                                </center>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!--Footer Codes-->
                                <%@include file="../footer.jsp"%>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="js/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->      
        <script src="js/bootstrap-datepicker.js"></script>
        <script type="text/javascript">
            // When the document is ready
            $(document).ready(function () {

                $('#targetDate').datepicker({
                    format: "yyyy-mm-dd"
                });

            });
        </script>
        <!--tradeasia's scripts --> 
        <script src="js/tradeasia.js"></script>
        <script src="js/addEvent.js"></script>
    </body>
</html>