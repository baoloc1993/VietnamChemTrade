<%-- 
    Document   : index
    Created on : May 15, 2015, 11:24:12 AM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file = "setting.jsp" %>

<title>Hỏi Đáp | Chemtradeasia | Tradeasia

International Pte Ltd - Việt Nam</title> 
<meta name = "keyword" content = "Tải cùng lúc TDS và MSDS của nhiều

hóa chất khác nhau, báo giá cho

nhiều sản phẩm, đăng kí theo dõi mọi

cập nhật, mua hóa chất trực tuyến,

Tôi có thể thêm các sự kiện từ công ty

của tôi, Làm thế nào để liên hệ đại

diện của tradeasia, địa điểm các văn

phòng">

<meta name = "description" content  = "Chemtradeasia: Câu hỏi thường gặp:

đưa ra những giải đáp tốt nhất cho

các thắc mắc và câu hỏi thường gặp."/>
    <body>
        <div class="container" >

            <!---to wrap around all body content--->
            <div class="row col-md-10 col-md-offset-1 centerRow">
                <!----center content--->
                <div class="span12">

                    <!---add the header and navbar---->
                    <%@include file="header_nav.jsp"%>
                    
                    <!---FAQs Accordion--->                    
                    <div class="row-fluid">
                        <div class="span12" style= "background-color: white;" >
                            <div class="container-fluid" style="margin-top:14px; margin-left:50px;">
                                <div class="faq-mainheader" style="padding: 0!important;">Câu hỏi thường gặp</div>

                                <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                                    <!----panel 1--->
                                    
                                    <!-- Database Calling Codes. Using processFAQ instance to retrieve data -->

 									<c:forEach begin = "0" var = "i" end = "${faqSize-1 }">  
 									                                    
                                                                                        
                                    <div class="panel panel-default">
                                        <div class="panel-heading" role="tab" id="heading${i}" data-toggle="collapse" data-parent="#accordion" href="#collapse${i}" aria-expanded="true" aria-controls="collapse${i}">
                                            <h4 class="panel-title" style = "cusor:pointer" >
                                                
                                               <a style = "cursor:pointer">${faqList.get(i).question }</a>
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
