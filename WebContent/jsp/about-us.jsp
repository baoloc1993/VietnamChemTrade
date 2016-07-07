<%-- 
    Document   : about
    Created on : 2015-5-18, 10:18:24
    Author     : Fla
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file = "setting.jsp" %>
<title>Giới thiệu về Tradeasia | Chemtradeasia |

Tradeasia International Pte Ltd - Việt Nam</title> 
<meta name = "keyword" content = "Thị trường B2B Việt Nam, công ty kinh doanh

hóa chất tại Việt Nam, nhà sản xuất, nhà cung

cấp, hóa chất tẩy rửa, hóa chất dệt may, nhà

cung cấp hóa chất ở Việt Nam, nhà cung cấp

hóa chất Việt Nam">

<meta name = "description" content  = "Chemtradeasia- Công ty thương mại hoá chất

của Việt Nam chuyên nhập khẩu và xuất khẩu

hóa chất. Cung cấp nền tảng B2B cho nhà cung

cấp, nhà kinh doanh,nhà sản xuất, nhà xuất khẩu

và nhập khẩu."/>
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
        <div class="container" ">

            <!---to wrap around all body content--->
            <div class="row">
                <!----center content--->
                <div class="col-md-10 col-md-offset-1">

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
                                                        <li id="tabHeader_1" class="tabActiveHeader" style="font-size:12px;" onclick="disappear2();">GIỚI THIỆU DOANH NGHIỆP</li>
                                                        <li id="tabHeader_2" style="font-size:12px;" onclick="disappear1();">VÌ SAO NÊN CHỌN TRADEASIA?</li>
                                                    </ul>

                                                    <div id="tabs1">
                                                    </div>
                                                    <div id="tabscontent">
                                                        <div class="tabpage" id="tabpage_1">
                                                            <h2 style="display:none;">GIỚI THIỆU DOANH NGHIỆP</h2>
                                                            <br/>
                                                            <p style="font-family:Verdana;font-size:12px;line-height:25px; text-align:justify; "><strong>Tradeasia International Pte. Ltd </strong>,được thành lập năm 2002, bởi ông Manoj Singhania. Văn phòng đầu tiên của công ty được thành lập ở Singapore, sau đó thành lập thêm nhiều văn phòng khác trên thế giới. Tradeasia mở rộng đến các quốc gia khác ở Châu Á và phát triển với mục tiêu trở thành tập đoàn buôn bán hóa chất hàng đầu chuyên cung cấp các dịch vụ sản phẩm hóa chất uy tín với chất lượng tốt nhất đến khách hàng. 
                                                            </p> 
                                                            <br />
                                                            <b style="font-family:Verdana;font-size:12px;line-height:25px">Sứ mệnh</b>
                                                            <p style="font-size:12px;font-family:Verdana;text-align:justify;line-height:25px">“Cung cấp các dịch vụ sản phẩm hóa chất và giải pháp tốt nhất cho khách hàng”.</p>
                                                            <br />
                                                            <b style="font-size:12px;font-family:Verdana;line-height:25px">Giá trị cốt lõi</b>
                                                            <p style="font-size:12px;font-family:Verdana;text-align:justify;line-height:25px">Liêm chính, Trung thực, Dịch vụ Chất lượng và Tôn trọng từng cá nhân.</p>
                                                            <br />
                                                            <p style="font-size:12px;font-family:Verdana;text-align:justify;line-height:25px">
                                                                Đáp ứng mọi nhu cầu và mong đợi của khách hàng, cung cấp cho khách hàng những dịch vụ mua bán chuyên nghiệp với chất lượng quản lí tốt và đúng thời hạn. Đồng thời, chúng tôi cũng có sự liên kết chặt chẽ và hiệu quả với những thị trường mới nổi.

Tradeasia cung cấp những dịch vụ mua bán, lập kế hoạch vận chuyển, những dịch vụ hậu cần, dịch vụ quản lí cung ứng dây chuyền, thủ tục nhập và xuất hàng, chứng từ xuất khẩu, dịch vụ ngân hàng và bảo hiểm, dịch vụ tư vấn kĩ thuật và sản phẩm.
</p>
                                                            <br />
                                                        </div>
                                                        <div class="tabpage" id="tabpage_2"  style="display:none">
                                                            <!-- <h2>Why Choose Us</h2>-->
                                                            <br />
                                                            <p style="font-size: 12px;font-family:Verdana; line-height:25px;text-align:justify"><strong>Tradeasia International Pte. Ltd </strong>,, được thành lập năm 2002, là một trong những công ty mua bán hóa chất hàng đầu Châu Á chuyên cung cấp các dịch vụ xuất và nhập khẩu tích hợp cho khách hàng trên toàn thế giới thông qua hệ thống phân phối trải rộng. Cùng với sự đa dạng trong sản phẩm hóa chất chuyên dụng và hóa chất công nghiệp có chất lượng tốt nhất, chúng tôi đã và đang cung cấp các dịch vụ hiệu quả như quản lí dây chuyền cung ứng, hậu cần, tư vấn, vân vân cho tất cả khách hàng và các ngành công nghiệp hóa học. Chúng tôi rất tự hào tuyên bố rằng các mối quan hệ bền vững giữa Tradeasia và khách hàng cũng như đối tác được xây dụng trên sự tin tưởng bền vững vào các dịch vụ mà chúng tôi cung cấp làm cho Tradeasia trở thành công ty thương mại độc đáo và duy nhất so với các công ty khác. Những lý do tạo nên sự khác biệt của TradeAsia:
                                                            </p> 
                                                            <br/>
                                                            <b style="font-size:12px;font-family:Verdana;line-height:25px"> Mô hình mạng lưới toàn cầu</b>
                                                            <p style="font-size:12px;font-family:Verdana;text-align:justify;line-height:25px">“Cố gắng hết sức để đạt được mục đích.” Đối với chúng tôi, khách hàng là tài sản quý giá nhất. Vì vậy trong bất kì giao dịch kinh doanh nào, chúng tôi luôn đặt khách hàng lên ưu tiên hàng đầu. Với mục tiêu phấn đấu thay đổi mạng lưới cung ứng toàn cầu thành thị trường toàn cầu, chúng tôi luôn cố gắng cung cấp các dịch vụ đáng tin cậy, minh bạch và hiệu quả.
</p>
                                                            <br/>
                                                            <b style="font-size:12px;font-family:Verdana;line-height:25px"> Mô hình phát triển không ngừng</b>
                                                            <p style="font-size:12px;font-family:Verdana;text-align:justify;line-height:25px">Ở Tradeasia, nguồn cảm hứng của chúng tôi bắt đầu từ câu nói “không ngừng học hỏi” và tương tự chúng tôi cũng cố gắng cải thiện chất lượng sản phẩm hóa chất và dịch vụ. Ngoài ra, chúng tôi luôn không ngừng cố gắng đáp ứng những yêu cầu đa dạng từ phía khách hàng bằng việc đa dạng hóa sản phẩm và làm đúng qui trình kĩ thuật khi giao dịch buôn bán với khách hàng.</p>
                                                            <br/>
                                                            <b style="font-size:12px;font-family:Verdana;line-height:25px"> Chất lượng dịch vụ</b>
                                                            <p style="font-size:12px;font-family:Verdana;text-align:justify;line-height:25px"> Ở TradeAsia, chúng tôi mong muốn khách hàng được hưởng chất lượng dịch vụ tốt nhất. Vì vậy chúng tôi luôn coi đó là ưu tiên hàng đầu trong việc cung cấp dịch vụ mua bán hóa chất chất lượng cao và các sản phẩm hóa chất phải đảm bảo tiêu chuẩn quốc tế cho khách hàng. Vận hành qui trình kí kết hợp đồng để có lợi cho cả hai bên là phương châm vàng của chúng tôi. </p>
                                                            <br/>
                                                            <b style="font-size:12px;font-family:Verdana;line-height:25px"> Dịch vụ đáng tin cậy</b>
                                                            <p style="text-align:justify;font-family:Verdana;font-size:12px;line-height:25px"> Ở Tradeasia, chúng tôi tin rằng “thành Rome không thể được xây dựng hoàn tất trong một ngày, và tương tự như thế “Niềm tin” được xây dựng và tích lũy theo thời gian.” Qua nhiều năm, bằng cách đảm bảo tất cả hàng hóa đều đến được tay khách hàng đúng thời hạn và yên tâm về mặt chất lượng và với phương châm làm việc 3D: Determination (quyết đoán), dedication (tận tâm) và discipline (kỷ luật), chúng tôi đã xây dựng thành công các mối quan hệ bền vững với khách hàng. </p>
                                                            <br/>
                                                            <b style="font-size:12px;font-family:Verdana;line-height:25px"> Kinh nghiêm lâu năm</b>
                                                            <p style="text-align:justify;font-family:Verdana;font-size:12px;line-height:25px"> Qua nhiều năm làm việc tận tâm, đầy nhiệt huyết và không bao giờ xem nhẹ chất lượng dịch vụ, Tradeasia đã và đang tích lũy nhiều kinh nghiệm trong việc cung cấp các dịch vụ buôn bán hóa chất chất lượng tốt nhất cho tất cả các đối tác. Hơn thế nữa, với đội ngũ nhân viên đầy nhiệt huyết và chuyên nghiệp, Tradeasia luôn luôn đáp ứng tốt các nhu cầu và mong đợi của khách hàng. </p>
                                                            <br/>
                                                            <b style="font-size:12px;font-family:Verdana;line-height:25px"> Xây dựng quan hệ đối tác bền vững</b>
                                                            <p style="text-align:justify;font-family:Verdana;font-size:12px;line-height:25px"> Tradeasia chú trọng trong việc phát triển hiệu quả lợi ích song phương bền lâu trong các mối quan hệ kinh doanh với các nhà cung ứng. Bằng việc cung cấp thời gian tiến độ hiệu quả, chia sẻ thông tin và duy trì giao tiếp thông tin minh bạch với khách hàng, đã giúp cho chúng tôi nhập khẩu và xuất khẩu thành công nhiều loại mặt hàng, cũng như đưa chúng tôi tới gần hơn với khách hàng toàn cầu.</p>
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
