

<%@include file  = "../setting.jsp" %>
<title> Sự Kiện | Chemtradeasia | Tradeasia

International Pte Ltd - Việt Nam - ${event.title}</title>
<link href="css/eventDetails.css" rel="stylesheet">
    <body>
        <div class="container">

            <!---to wrap around all body content--->
            <div class="row">
                <!----center content--->
                <div class="col-md-10  col-md-offset-1 centerRow">

                    <!---add the header and navbar---->
                    <%@include file="../header_nav.jsp"%>

                    <!-------starting of event details------>
                    <div class="row" style="margin-bottom:30px;margin-top:50px">

                        <div class="col-md-3" style="margin-bottom: 20px">
                            <img src="images/${event.img }" class="img-rounded center-block" style="height: 166px;width: 195px;"  alt="${event.title }"/>           
                        </div>

                        <div class="col-md-8">

                            <table>
                                <tr>
                                    <th colspan="2"><div class="eventTitle">${event.title }</div></th>
                                </tr>

                                <tr>
                                    <td>
                                        <b>Date:</b>
                                    </td>
                                    <td class="info">
                                <u>   ${event.date }></u>
                                </td>
                                </tr> 
                                <tr>
                                    <td>
                                        <b>Location:</b>
                                    </td>
                                    <td class="info">
                                        ${event.location }
                                    </td>
                                </tr> 

                                <tr>
                                    <td>
                                        <b>Description:</b>
                                    </td>
                                    <td class="info">
                                        ${event.description }
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <b>Link:</b>
                                    </td>
                                    <td class="info">
                                       ${event.link }
                                        
                                    </td>
                                </tr>
                            </table>

                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-12">
                            <div class="pull-right">
                                <a href="events.jsp"> <div class="btn btn-primary">Back to Event Page </div></a>
                            </div>
                        </div>
                    </div>

                    <!-- Footer Codes -->
                    <%@include file="../footer.jsp"%>
                </div>
            </div>
        </div>

        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="js/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.js"></script>
        <script src="js/tradeasia.js"></script>
    </body>
</html>