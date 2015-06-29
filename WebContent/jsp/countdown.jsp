<%-- 
    Document   : index
    /* global reportID */

Created on : May 15, 2015, 11:24:12 AM
    Author     : Qianpin
--%>

<%@ include file = "setting.jsp" %>

    <body>

        <div class="container" style="padding-right:27px; padding-left:5px">
            <!---to wrap around all body content--->
            <div class="row">
                <!----center content--->
                <div class="col-md-10 col-md-offset-1 centerRow">

                    <!---add the header and navbar---->
                    <%@include file="header_nav.jsp"%>

                    <!-- Database Calling Codes. Using processContactUs instance to retrieve data -->
                    <%
                        ContactUsDAO contactUs = new ContactUsDAO();
                        contactUs.databaseRetrieval();
                        ArrayList<Contact> list = contactUs.getTable();

                        CountryDAO cdao = new CountryDAO();
                        cdao.databaseRetrieval();
                        ArrayList<Country> clist = cdao.getTable();
                    %>

                    <!---insert codes below this line eg. search bar, etc--->  
                    <!-- 1. Image First -->
                    <div class="row">
                        <div class="col-md-12">
                            <img class="contact-us-image" src="images/contact/contact-us-banner.jpg" alt="contact-us-banner">

                            <!-- 2. Country Filter -->
                            <!-- Edit here to put your country as first displayed country -->
                            <div class="contact-width">
                                <form>
                                    <select class="contact-box" name="contact-box" title="Contact Box" id="countryID">
                                        <option value="0">Country</option>
                                        <option value="4">
                                            India-Mumbai </option>
                                        <option value="0">
                                            Singapore </option>
                                        <option value="1">
                                            Indonesia </option>
                                        <option value="2">
                                            China </option>
                                        <option value="3">
                                            Dubai </option>
                                        <option value="5">
                                            India Kolkata </option>
                                        <option value="6">
                                            Vietnam </option>
                                    </select>
                                </form>
                            </div>

                            <!-- onchange Codes -->
                            <script type="text/javascript">
                                //use the var to retrieve the value of option selected
                                var cID = document.getElementById("countryID");
                                document.getElementById("countryID").onchange = function () {
                                    goto_pg();
                                };
                                //post the countryID in the url
                                function goto_pg() {
                                    location.href = "contact-us.jsp?qp=" + cID.options[cID.selectedIndex].value;
                                }
                            </script>
                            <%
                                //retrieve the option countryID in the URL via getParameter. getParameter returns a String
                                String qp = request.getParameter("qp");
                                int number;

                                //Default Country is India-Mumbai. where value=0
                                if (qp == null) {
                                    number = 4;
                                } else {
                                    number = Integer.parseInt(qp);
                                }

                                String id = "";
                                String label = "";
                                String name = "";
                                String address = "";
                                String province = "";
                                String zip_code = "";
                                String country = "";
                                String tel = "";
                                String fax = "";
                                String email = "";
                                String business_days = "";
                                String business_hours = "";
                                String google_map = "";

                                Contact c = null;
                                if (list.size() == 0) {
                                    //do nothing catch if 0
                                } else {
                                    c = list.get(number);

                                    id = c.id;
                                    label = c.label;
                                    name = c.name;
                                    address = c.address;
                                    province = c.province;
                                    zip_code = c.zip_code;
                                    country = c.country;
                                    tel = c.tel;
                                    fax = c.fax;
                                    email = c.email;
                                    business_days = c.business_days;
                                    business_hours = c.business_hours;
                                    google_map = c.google_map;
                                }
                            %>                                

                            <!-- 3. Google Search MAP -->
                            <div class="tab-container">
                                <span class="tab">
                                    <img src="images/contact/<%=label%>.png" height="13" width="16" alt="<%=label%>"><%=label%>
                                </span>
                                <div class="tab-page" id="page1">
                                    <table width="100%" height="100%">
                                        <tbody><tr height="8"></tr>
                                            <tr width="100%" height="100%">
                                                <!-- Description and Form -->
                                                <td class="holder2" style="padding-left:1%;" valign="top">
                                                    <p class="contact_info">
                                                        <b><%=name%></b><br>
                                                        <%=address%>,
                                                        <br>
                                                        <%=province%> <%=zip_code%> <br>
                                                        <%=country%><br>
                                                        Tel : <%=tel%><br>
                                                        Fax : <%=fax%><br>
                                                        E-mail : <%=email%><br>
                                                        Business Days : <%=business_days%> <br>
                                                        Business hours : <%=business_hours%><br>
                                                    </p>
                                                    <!-- The Skype/email/linked in etc icons -->
                                                    <table width="100%">
                                                        <tbody><tr>  
                                                                <th>
                                                                    <script type="text/javascript" src="http://www.skypeassets.com/i/scom/js/skype-uri.js"></script>
                                                                    <a onclick="Skype.tryAnalyzeSkypeUri('call', '0');" href="skype:trade.asia?call"><img src="images/contact/skype-contactus.png" style="width: 8%; vertical-align: bottom;" alt="skype" width="68" height="26"></a>
                                                                    <a href="send-enquiry.jsp" title="Send Enquiry"><img src="images/contact/enquiry-contactus.png" alt="Get Quote Icon" style="width: 8%; vertical-align: bottom;" width="68" height="26"></a>
                                                                    <a href="https://www.facebook.com/TradeasiaInternationalGroup" target="_blank" title="Connect with us through Facebook"><img src="images/contact/fb-contactus.png" style="width: 8%; vertical-align: bottom;" alt="facebook" width="68" height="26"></a>
                                                                    <a href="https://twitter.com/SreeTradeasia" target="_blank" title="Connect with us through Twitter"><img src="images/contact/twitter-contactus.png" alt="twitter" style="width: 8%; vertical-align: bottom;" width="68" height="26"></a>
                                                                    <a href="https://www.linkedin.com/company/tradeasia-international-pte-ltd" target="_blank" title="Linked In with Us!"><img src="images/contact/linkedin-contactus.png" style="width: 8%; vertical-align: bottom;" alt="linkedin" width="68" height="26"></a>
                                                                    <a class="accessible" href="javascript:void(0);"><span style="display:none;">skip content</span></a>  

                                                                </th>
                                                            </tr>
                                                        </tbody></table>  
                                                    <br><br>
                                                    <!-- For skype call -->
                                                    <script type="text/javascript">
                                                        function skypeCall() {
                                                            Skype.ui({
                                                                "name": "call",
                                                                "participants": ["trade.asia"]
                                                            })
                                                        }
                                                    </script>
                                                    <!-- Message of Contact Us Form Submission-->
                                                    <%
                                                        String msg = (String) session.getAttribute("databaseMessage");
                                                        if (msg == null) {
                                                            msg = "";
                                                        }
                                                    %>
                                                    <div class="success"><center><b><%=msg%></b></center></div>
                                                </td>
                                                <!-- Description and Form ends -->

                                                <!-- Google Map Area -->
                                                <td class="holder1" id="holder" width="60%" height="80%">
                                                    <!-- Don't care the red warnings, it works -->
                                                    <iframe class="google-map" width="100%" height="95%" frameborder="0%" scrolling="no" marginheight="0%" marginwidth="0%" 
                                                            src="<%=google_map%>">                                                                 
                                                    </iframe><br><small><a href="<%=google_map%>" 
                                                                           target="_blank" class="contentnavi">View Larger Map</a></small>
                                                </td>
                                                <!-- Google Map Area Ends -->
                                            </tr>
                                        </tbody>
                                    </table>

                                    <!-- Contact Us Form -->
                                    <form class="contact-form form-horizontal" method="post" action="contact-us-form">
                                        <!-- Form Header-->
                                        <div class="row" style="margin-left:1%; margin-right: 2%">
                                            <div class="col-md-5" >
                                                <div class="contact-header">Contact Us Form</div>
                                            </div>
                                        </div>

                                        <div class="row required-notification" style="margin-left:4%;">
                                            <div class="col-md-5">
                                                * Denotes Required Field
                                            </div>
                                        </div>
                                        <!-- Form header ends-->
                                        <div class="row" style="margin-left:1%; margin-right: 2%;">
                                            <div class="col-md-10">

                                                <!-- Form information -->
                                                <div class="row">
                                                    <div class="line" style="margin-left: 2%;"></div>
                                                    
                                                    <!-- First Column, Firstname, Lastname, Email-->
                                                    <div class="col-md-6" style="padding-left: 4%;">
                                                        
                                                        <div class="form-group">
                                                            <input required type="text" name="firstname" class="form-control" placeholder="First Name*"/>
                                                        </div>
                                                        
                                                        <div class="form-group">
                                                            <input required type="text" name="lastname" class="form-control" placeholder="Last Name*"/>
                                                        </div>

                                                        <div class="form-group">
                                                            <input required type="email" name="email" class="form-control" placeholder="Email*"/>
                                                        </div>
                                                    </div>
                                                    <!-- First Column Ends -->

                                                    <!-- Second Column, Your Title,Country, State-->
                                                    <div class="col-md-6" style="padding-left: 4%;">

                                                        <div class="form-group">
                                                            <select required class="contact-form form-control" name="description">
                                                                <option value="">Your Title*</option>
                                                                <option value="Trader / Supplier">Trader / Supplier</option>
                                                                <option value="Manufacturer">Manufacturer</option>
                                                                <option value="Agent">Agent</option>
                                                                <option value="Others">Others</option>
                                                            </select>
                                                        </div>

                                                        <div class="form-group">
                                                            <select required class="contact-form form-control" name="country">
                                                                <option value="">Country*</option>
                                                                <%
                                                                    for (int i = 0; i < clist.size(); i++) {
                                                                        Country cc = clist.get(i);
                                                                %>
                                                                <option value="<%=cc.country%>"><%=cc.country%></option>
                                                                <%}%>
                                                            </select>
                                                        </div>

                                                        <div class="form-group">
                                                            <input required type="text" name="state" class="form-control" placeholder="State*"/>
                                                        </div>
                                                    </div>
                                                    <!-- Second Column Ends -->

                                                    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
                                                    <script type="text/javascript" src="jquery.charactercounter.js"></script>

                                                    <!--Message Box Individual Column-->
                                                    <div class="col-md-12" style="padding-left: 4%;">
                                                        <div class="form-group">
                                                            <textarea id="textarea" name="message" maxlength="800" class="form-control" rows="5" placeholder="Message: (Max 800 characters)"></textarea>
                                                            <div id="characterLeft"></div>
                                                        </div>
                                                    </div>

                                                    <script>
                                                        $('#characterLeft').text('800 characters left');
                                                        $('#textarea').keyup(function () {
                                                            var max = 800;
                                                            var len = $(this).val().length;
                                                            if (len >= max) {
                                                                $('#characterLeft').text(' You have reached the limit');
                                                            } else {
                                                                var ch = max - len;
                                                                $('#characterLeft').text(ch + ' characters left');
                                                            }
                                                        });
                                                    </script>
                                                    <!-- Message Box Column Ends-->

                                                    <!--Submit Button-->
                                                    <div class="col-md-12" style="padding-left: 4%;">
                                                        <div class="form-group">
                                                            <button class="btn btn-info" type="submit">Submit</button>
                                                        </div>
                                                    </div>
                                                    <!--Submit Button Ends-->
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!----center white closing div--->

            <!-- Footer Codes -->
            <%@include file="footer.jsp"%>
        </div>
    </div>
</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.js"></script>

<!--zopim online form -->
<script type="text/javascript">
                                                        window.$zopim || (function (d, s) {
                                                            var z = $zopim = function (c) {
                                                                z._.push(c)
                                                            }, $ = z.s =
                                                                    d.createElement(s), e = d.getElementsByTagName(s)[0];
                                                            z.set = function (o) {
                                                                z.set.
                                                                        _.push(o)
                                                            };
                                                            z._ = [];
                                                            z.set._ = [];
                                                            $.async = !0;
                                                            $.setAttribute('charset', 'utf-8');
                                                            $.src = '//v2.zopim.com/?1kUgCWtYUhiYkCh3M3I7o4tqy892pDcX';
                                                            z.t = +new Date;
                                                            $.
                                                                    type = 'text/javascript';
                                                            e.parentNode.insertBefore($, e)
                                                        })(document, 'script');
</script>

</body>
</html>