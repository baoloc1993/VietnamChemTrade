<%-- 
    Document   : index
    Created on : May 15, 2015, 11:24:12 AM
    Author     : ASUS
--%>

<%@ include file = "../setting.jsp" %>
    <style>
        .sitemap_header {
            color: #0F6EA6;
            font-family: Oxygen-Bold,Roboto-regular,Arial;
            font-size: 210%;
        }

        .tableMap th {
            font-family: Oxygen-Bold,Roboto-regular,Arial;
            text-align: center;
        }
        .tableMap td {
            font-family: Roboto-regular,Arial;
            text-align: center;
        }
        .modal-open {
            padding-right: 0 !important;
        }

        td .modal-body {
            text-align: left;
        }

        .tableMap a {
            cursor: pointer;
        }

    </style>



<body>
    <div class="container" >

        <!---to wrap around all body content--->
        <div class="row">
            <!----center content--->
            <div class="span12" style="background-color: white;">

                <!---add the header and navbar---->
                <%@include file="../header_nav.jsp"%>

                <!---sitemap links--->

                <div class="row">
                    <div class="col-md-12" >
                        <div class="container-fluid" style="margin-top:14px; margin-left:1%;">
                            <div class="sitemap_header" style="padding: 0!important; margin-bottom:20px">Site Map</div>

                            <div class="row">
                                <div class="col-md-12" style="width:95%; margin-left:10px">
                                    <div class="row">
                                        <div class="col-sm-3 headerMap">
                                            <table class="table tableMap">
                                                <tr>
                                                    <th>Our Company</th>

                                                </tr>
                                                <tr>
                                                    <td><a href="index">Home</a><br />
                                                        <a href="about-us">About Us</a><br />
                                                        <a href="event">Events</a><br />
                                                        

                                                        <a data-toggle="modal" data-target="#privacyModal">Privacy</a><br />
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

                                                        <a data-toggle="modal" data-target="#policyModal">Our Policy</a>
                                                        <!-- Modal for policy -->
                                                        <div class="modal fade" id="policyModal" role="dialog">
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

                                                    </td>
                                                </tr>
                                            </table>
                                        </div>
                                        <div class="col-sm-3 headerMap">
                                            <table class="table tableMap">
                                                <tr>
                                                    <th>Contact Us</th>

                                                </tr>
                                                <tr>
                                                    <td>
                                                        <a href="contact_us">Contact Us</a> <br />
                                                  
                                                        <a href="blog">Blog</a> <br />
                                                        <a href="faq">FAQ</a><br />

                                                    </td>
                                                </tr>
                                            </table>
                                        </div>
                                        <div class="col-sm-3 headerMap">
                                            <table class="table tableMap">
                                                <tr>
                                                    <th>Products</th>

                                                </tr>
                                                <tr>
                                                    <td>
                                                        <a href="contact_us">Products</a> <br />
                                                        <a href="usefulTools">Useful Tools</a><br />
                                                        <a href="downloadCenter">Downloads</a>

                                                    </td>
                                                </tr>
                                            </table>
                                        </div><div class="col-sm-3 headerMap">
                                            <table class="table tableMap">
                                                <tr>
                                                    <th>Business</th>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        <a href="supplier">Become A Supplier</a><br />
                                                        <a href="order">Order Now</a><br />
                                                    </td>
                                                </tr>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <%@include file="../footer.jsp"%>
            <!----center white closing div--->
            </div>
        </div>
    </div>
</div>



<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.js"></script>

</body>
</html>
