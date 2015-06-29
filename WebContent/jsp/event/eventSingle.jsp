<%-- 
    Document   : eventSingle
    Created on : 2015-5-20, 12:32:00
    Author     : Fla
--%>

<%@ include file = "../setting.jsp" %>

 <link href="css/tabstyle.css" rel="stylesheet">
    <body>
        <div class="container" style="padding-right:27px; padding-left:5px">

            <!---to wrap around all body content--->
            <div class="row-fluid span12">
                <!----center content--->
                <div class="span12">
                    <!---add the header and navbar and search bar---->
                    <%@include file="../header_nav.jsp"%>
                    <div class="span12" style = "margin-left:0px;">
                        
                    <!-- EVENT PANEL LEFT SIDEBAR -->
                        <div class="span3" style = "margin-top: 2%;">
                            <%@ include file = "listEvent.jsp" %>
                        
                        </div>
                        <!-- END EVENT PANEL LEFT SIDEBAR -->
                        <div class="span9" >
                            <div class="eventPanel span12" >
                                <table style="line-height:25px;  table-layout: fixed;font-family: Verdana, Arial, Helvetica, sans-serif;font-size: 12px;">
                                    <tr style="display: none;"><th></th></tr>
                                    <tr>
                                        <td style="word-wrap: break-word;" colspan="2"><h3 class="news-title-event">${event.title }</h3></td>
                                    </tr>

                                    <tr>
                                        <td colspan="2">
                                            <img src="${event.img}" width="100" height="100" alt="event3" style="float:left;padding:10px 10px 10px 0px;">

                                            <table style="table-layout: fixed;">
                                                <tr style="display: none;"><th></th></tr>
                                                <tr>
                                                    <td class="event-label">Event Date</td>
                                                    <td class="edetails"> :  ${event.date}
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td class="event-label">Location</td>
                                                    <td class="edetails" style="word-wrap: break-word;"> : ${event.location }
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td class="event-label">Description</td>
                                                    <td>:<br></td>
                                                </tr>
                                                <tr><td colspan='2' style="word-wrap: break-word;">${event.description }<span ><br /><a href="#/${event.link }" target="_blank" class="contentnavi">${event.link }</a></span>
                                                    </td>
                                                </tr>  
                                            </table>
                                    <tr>
                                        <td colspan="2">
                                            <div id="event-view-back">
                                                <a href="event.jsp"><span style="color: white;">Back</span></a>
                                            </div>  
                                        </td>
                                    </tr>  
                                </table>
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
