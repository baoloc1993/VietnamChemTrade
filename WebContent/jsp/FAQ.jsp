<%-- 
    Document   : index
    Created on : May 15, 2015, 11:24:12 AM
    Author     : ASUS
--%>


<%@ include file = "setting.jsp" %>
    <body>
        <div class="container" style="padding-right:27px; padding-left:5px; background-color: white;">

            <!---to wrap around all body content--->
            <div class="row-fluid">
                <!----center content--->
                <div class="span12">

                    <!---add the header and navbar---->
                    <%@include file="header_nav.jsp"%>
                    
                    <!---FAQs Accordion--->                    
                    <div class="row-fluid">
                        <div class="span12" style= "background-color: white;" >
                            <div class="container-fluid" style="margin-top:14px; margin-left:50px;">
                                <div class="faq-mainheader" style="padding: 0!important;">Frequently Asked Questions</div>
                                <p><span class="faq-subheader" style="margin: 0 !important; padding: 0!important;">Quickly find out if we’ve already addressed your query.</span></p>            

                                <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                                    <!----panel 1--->
                                    
                                    <!-- Database Calling Codes. Using processFAQ instance to retrieve data -->

 									<c:forEach begin = "0" var = "i" end = "${faqSize-1 }">  
 									                                    
                                                                                        
                                    <div class="panel panel-default">
                                        <div class="panel-heading" role="tab" id="heading${i}" data-toggle="collapse" data-parent="#accordion" href="#collapse${i}" aria-expanded="true" aria-controls="collapse${i}">
                                            <h4 class="panel-title" >
                                                <span class="ui-accordion-header-icon ui-icon ui-icon-triangle-1-e"></span>
                                                ${faqList.get(i).question }
                                            </h4>
                                        </div>
                                        <div id="collapse${i}" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading${i}">
                                            <div class="panel-body">
                                                ${faqList.get(i).answer}
                                            </div>
                                        </div>
                                    </div>
                                    </c:forEach> 
                                    <p> 
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
