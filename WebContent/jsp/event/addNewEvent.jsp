<%-- 
    Document   : addNewEvent
    Created on : 2015-5-20, 12:32:00
    Author     : Fla
--%>
<%@ include file = "../setting.jsp" %>

 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <link href="css/tabstyle.css" rel="stylesheet">

 
 <script type="text/javascript"
	src = "js/validEventForm.js"
>
 </script>


    <body>
        <div class="container" style="padding-right:27px; padding-left:5px">

            <!---to wrap around all body content--->
            <div class="row-fluid">
                <!----center content--->
                <div class="span12">
                    <!---add the header and navbar and search bar---->
                    <%@include file="../header_nav2.jsp"%>
                    <br>
                    <div class="span12 row-fluid">
                    <!-- EVENT PANEL LEFT SIDEBAR -->
                        <div class="span3">
                            <%@include file = "listEvent.jsp"%>
                              
                        </div>
                        <!-- END EVENT PANEL LEFT SIDEBAR -->
                        <!-- ADD NEW EVENT -->
                        <div class="span9">
                            <div class="eventPanel" style="display: block;">
                                <div style="background-color:#0f6aa3">
                                    <img class="img-responsive" src="./images/create-event-banner.jpg" width="100%" height="100%">
                                    <h3 style="text-align:center;">Submit an Event</h3>    
                                </div>
                                 <form method = "post"  id  ="addNewEvent" name = "addNewEvent"  action = "addnewevent" onsubmit=" return validForm()">	
                                    <table class = "span12">
                                        
                                        <tbody>
                                            <tr class="span12" style="margin-left:5px;">
                                                <td style="text-align: left;font-family: Oxygen-Bold,Roboto-regular,Arial">
                                                    <p style=" color: #74559F; letter-spacing:1px; font-weight: bold; text-transform: capitalize;  font-size: 120%;"> contact details</p><br>
                                                </td>
                                            </tr>
                                           
                                            <!--  Salutation, First Name, Middle Name, Last Name -->
                                            
                                            <tr class="span12" style="margin-left:5px;">
                                                <td class="subheader row-fluid span6">
                                                	
	                                                <div class = "span4"> 

		                                                 <select id="salutation" style = "width:100%;" name = "salutation">
															   
															   <c:forEach items = "${salutationList}" var ="salutation"> 
															   
															   		<option value ="${salutation.value}" label="${salutation.title}" />
															   </c:forEach>
															   
														</select>
													</div>
													<div class = "span8">
														
														<input  maxlength = "250" title = "First Name"  class = "intext"    style = "width:100%;"  placeholder="First Name*" name="firstName" id="firstName"/>
													</div>		
												</td>
													
                                                <td class="subheader span6">
                                                	
													<input maxlength = "250" title = "Middle Name" class = "intext span6" placeholder="Middle Name" name="middleName" id="middleName" />
                                                    <!-- <input maxlength="200" title="Middle Name" placeholder="Middle Name" type="text"  style="margin-right:1.5%" class="intext" name="middleNm" id="middleNm"/>-->									
													
                                                    <input maxlength = "250" title = "Last Name" class = "intext span6" placeholder ="Last Name*" name="lastName" id="lastName"/>									
                                                </td>    
                                            </tr>
                                            <!--  Country Code, Area Code, Phone Email -->
                                            
                                            <tr class="span12" style="margin-left:5px;">
                                                <td class="subheader span6">
                                                	
                                                	<select id="areaCode" class = "span4" name = countryCode>
														   <option value="NONE" label="CountryCode" />
														   
														   <c:forEach items = "${codes}" var = "code">
														   		<option value ="${code.callingCode}" label = "${code.callingCode}" />
														   </c:forEach>
														   
													</select>	
												
                                                    <input maxlength="10" placeholder = "Area Code" title="Area Code" onkeyup="value = value.replace(/[^\d]/g, '')"   class="intext span4" id="areaCode" name = "areaCode"/>									
                                                    <input maxlength="15" placeholder ="Phone" title="Phone" onkeyup="value = value.replace(/[^\d]/g, '')" class="intext span4" id="phone" name = "phone"/>									                                                                                           
                                                </td>                                        
                                                <td class="subheader span6">
                                                    <input placeholder = "Email ID*" maxlength="300" title="Email id" class="intext" style = "width: 100%;" id="email" name = "email"/>						
                                                </td>    
                                            </tr>
                                           
                                            <tr class="span12" style="margin-left:5px;">
                                                <td style="text-align: left;font-family: Oxygen-Bold;">
                                                    <br>
                                                    <p style=" color: #74559F; letter-spacing:1px; font-weight: bold; width: 120%; text-transform: capitalize;  font-size: 120%;font-family: Oxygen-Bold,Roboto-regular,Arial">
                                                        Event Details</p> <br>
                                                </td>
                                            </tr>
                                             <!-- Event Name, Event Date -->
                                             
                                            <tr class="span12" style="margin-left:5px;">
                                                <td class="subheader span6"> 
                                                    <input placeholder = "Event Name*" maxlength="100" title="Event Name" style="width: 100%;" class="intext" id="title"  name = "title"/>		
                                                </td>
                                                <td class="subheader span6">
                                                    <%@include file="timeChoose.jsp"%>
                                                </td>
                                            </tr>
                                            <!-- Event Location - Online link of the event -->
                                            
                                           <tr class="span12" style="margin-left:5px;">
                                                <td class="subheader span6"> 
                                                    <input maxlength="1500" title="Event Location*" class="intext" id="location" name ="location" placeholder = "Location*"/>									
                                                </td>  
                                                <td class="subheader span6"> 
                                                    <input title="Event Link" class="intext" id="link" name= "link" placeholder ="Event Link*"/>	
                                                </td>                             
                                            </tr>
                                            <!--  EVENT DESCRPTION -->
                                        
                                            <tr class="span12" style="margin-left:5px;">
                                                <td class="subheader span12">
                                                    <textarea placeholder = "Event Description*" rows="10" title="Event Description"  class="intext" id="description" name = "description" ></textarea>									  
                                                </td>                             
                                            </tr>
                                            <tr class="span12" style="margin-left:5px;">

                                                <td class="subheader" style="width:15%">
                                                    <img alt="code..." name="randImage" id="randImage" src="capcha/image.jsp" width="100%" height="100%"/>
                                                </td>
                                                <td class="subheader" style="font-size: 100%; word-break: break-all; color: red; width: 7%;">
                                                    <a href="javascript:loadimage();"><img src="../../images/body/refresh.png"/>
                                                    </a></td> 

                                                <td class="subheader">
                                                    <input maxlength="6" style="width: 92%;
                                                           color: #000000;
                                                           font-style:italic;
                                                           font-size: 100%;
                                                           font-family: Verdana, Arial, Helvetica, sans-serif;
                                                           padding: 0.2% 0.5% 0.2% 1%;
                                                           border-radius: 4px 4px 4px 4px;
                                                           border: 1px solid #CCCCCC;
                                                           line-height: 17px;
                                                           padding: 5px 5px;
                                                           position: relative;
                                                           width: 45%"
                                                           id="verifyCode" title="verifyCode" name = "verifyCode"/>	
                                                </td> 

                                            </tr>

                                            <tr class="span12" style="margin-left:5px;">
                                                <td colspan="2" class="subheader" style="width: 80%; font-size: 90%; word-break: break-all; color: red;text-align:justify;word-wrap:break-word">
                                                    *Please send us your Event photo to webmaster@chemtradeasia.com, to display the photo near your event details<br />
                                                </td>    
                                            </tr>

                                            <tr class="span12" style="margin-left:5px;">
                                                <td colspan="2" class="subheader">
                                                	 <input value="Submit" name="submit" type="submit" class="event-reset">
                                                    <input value="Reset" name="submit" type="reset" class="event-reset">                                
                                                </td>  
                                            </tr> 


                                        </tbody>
                                    </table>
                                <!-- </form>-->
                               	</form>
                               	
                               	
                                <!--  END ADD NEW EVENT -->
                            </div>
                        </div>
                    </div>

                    <!-- Footer Codes -->
                    <%@include file="../footer.jsp"%>
                </div>
            </div>

        </div>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.js"></script>


    </body>



</body>
</html>
