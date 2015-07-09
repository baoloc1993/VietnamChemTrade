<%-- 
    Document   : about
    Created on : 2015-5-18, 10:18:24
    Author     : Fla
--%>

<%@ include file = "setting.jsp" %>
<link rel="stylesheet" type="text/css" href="css/tabstyle.css">

        <style>
            @media only screen and (max-device-width:350px){
                /* styles for mobile browsers smaller than 480px; (iPhone) */
                .copyright {
                    font-size: 11px;
                }
            }
            .form-control {
                height: 30px;
                padding: 2px 7px;
                font-size: 12px;
            }

        </style>

        <script type="text/javascript">
            function disappear1() {
                document.getElementById('tabpage_1').style.display = "none";
                document.getElementById('tabpage_2').style.display = "";
                document.getElementById('tabHeader_2').setAttribute("class", "tabActiveHeader");
                document.getElementById('tabHeader_1').removeAttribute("class");
            }
            function disappear2() {
                document.getElementById('tabpage_2').style.display = "none";
                document.getElementById('tabpage_1').style.display = "";
                document.getElementById('tabHeader_1').setAttribute("class", "tabActiveHeader");
                document.getElementById('tabHeader_2').removeAttribute("class");
            }
        </script>

    </head>

    <body>
        <div class="container" style="padding-right:27px; padding-left:5px; background-color: white;">

            <!---to wrap around all body content--->
            <div class="row-fluid">
                <!----center content--->
                <div class="span12">

                    <!---add the header and navbar---->
                    <%@include file="header_nav.jsp"%>
                    
                    	<%@include file="index/searchbar.jsp"%>
                    

                    <!-- About us TAB codes -->
                    <br>
                    <table style="text-align:center;width:954;">
                        <tr>
                            <td>
                                <table class="tblbord" style="text-align:center; background-color:#FFFFFF; width:100%;"> 
                                    <tr><th></th></tr>
                                    <tr>
                                        <td>
                                            <div id="tabContainer">
                                                <div id="tabs">
                                                    <ul style = "  margin-left: 3%;">
                                                        <li id="tabHeader_1" class="tabActiveHeader" style="font-size:12px;" onclick="disappear2();">About Us</li>
                                                        <li id="tabHeader_2" style="font-size:12px;" onclick="disappear1();">Why Choose Us</li>
                                                    </ul>

                                                    <div id="tabs1">
                                                    </div>
                                                    <div id="tabscontent">
                                                        <div class="tabpage" id="tabpage_1">
                                                            <h2 style="display:none;">About Us</h2>
                                                            <br/>
                                                            <p style="font-family:Verdana;font-size:12px;line-height:25px; text-align:justify; "><strong>Tradeasia International Pte. Ltd </strong>,established in 2002 and is headquartered at Singapore is a global trading organization providing integrated chemical procurement services with a level of certainty and trust, which makes Tradeasia stands unique. 
                                                            </p> 
                                                            <br />
                                                            <b style="font-family:Verdana;font-size:12px;line-height:25px">Our Mission</b>
                                                            <p style="font-size:12px;font-family:Verdana;text-align:justify;line-height:25px">"To provide our customers best chemical procurement services and solutions".</p>
                                                            <br />
                                                            <b style="font-size:12px;font-family:Verdana;line-height:25px">Our Values</b>
                                                            <p style="font-size:12px;font-family:Verdana;text-align:justify;line-height:25px">Integrity, Honesty, Quality Services and Respect for Individual</p>
                                                            <br />
                                                            <p style="font-size:12px;font-family:Verdana;text-align:justify;line-height:25px">
                                                                We provide excellent connectivity with the emerging markets and firmly believe in timely and perfectly managed procurement services. Tradeasia offers supply chain management service, inbound logistics, outbound logistics, and chemical products consulting. At Tradeasia, our services are always client based and desired for each customer.</p>
                                                            <br />
                                                        </div>
                                                        <div class="tabpage" id="tabpage_2"  style="display:none">
                                                            <!-- <h2>Why Choose Us</h2>-->
                                                            <br />
                                                            <p style="font-size: 12px;font-family:Verdana; line-height:25px;text-align:justify"><strong>Tradeasia International Pte. Ltd </strong>, provides chemical trading services to consumers worldwide through expanding distribution network. We have been providing supply chain services to chemical industry since 2002, that help to make our customers and partners count on us and build a relationship with us for the long term. Reasons that make Tradeasia stands unique from other trading firms are:
                                                            </p> 
                                                            <br/>
                                                            <b style="font-size:12px;font-family:Verdana;line-height:25px"> Global Network Model</b>
                                                            <p style="font-size:12px;font-family:Verdana;text-align:justify;line-height:25px">At Tradeasia, we do business keeping global customers in mind. We have global supplier network which provides us knowledge about global market that helps us to provide our clients trusted, transparent and effective services.</p>
                                                            <br/>
                                                            <b style="font-size:12px;font-family:Verdana;line-height:25px"> Continuous Improvement Model</b>
                                                            <p style="font-size:12px;font-family:Verdana;text-align:justify;line-height:25px">Tradeasia works extensively towards continuous improvement of our product quality and to meet our customers changing requirements. We devote ourselves in broadening the range of products focusing on its technical prospect.</p>
                                                            <br/>
                                                            <b style="font-size:12px;font-family:Verdana;line-height:25px"> Quality Services</b>
                                                            <p style="font-size:12px;font-family:Verdana;text-align:justify;line-height:25px"> Tradeasia believes in quality services, and we mean it. Our foremost priority is to provide high quality chemical trading services, we ensure that our chemical products conform to international quality standards. Our competitive advantages lies in our smooth responsive contract fulfilment process which is innovative, enjoyable and mutually beneficial. </p>
                                                            <br/>
                                                            <b style="font-size:12px;font-family:Verdana;line-height:25px"> Trusted Services</b>
                                                            <p style="text-align:justify;font-family:Verdana;font-size:12px;line-height:25px"> At Tradeasia we strongly believe that to be trusted is a greater compliment than being loved. We have been successful in building trust with our customers over the years, we ensure that all our consignments are delivered to our customers with an ease. </p>
                                                            <br/>
                                                            <b style="font-size:12px;font-family:Verdana;line-height:25px"> Broad Experience</b>
                                                            <p style="text-align:justify;font-family:Verdana;font-size:12px;line-height:25px"> Tradeasia has gained extensive experience in providing high-quality chemical trading services to our clients. Our employees are experienced experts understanding the needs and expectations of our clients. </p>
                                                            <br/>
                                                            <b style="font-size:12px;font-family:Verdana;line-height:25px"> Strong Partnership</b>
                                                            <p style="text-align:justify;font-family:Verdana;font-size:12px;line-height:25px"> Tradeasia, has always given strong focus on building effective, powerfully built and long term partnerships with suppliers, which enable us to deliver a wide variety of products. This attitude give us a leading edge in the global market.</p>
                                                            <br/>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </table><!-- content -->
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
