<%@page contentType="text/html" pageEncoding="UTF-8"%>

<style>


    .other-pdt-drop {
        padding-left: 0px;
        border: none;
        padding-bottom: 1px;
        font-family: Oxygen-Regular, Verdana, Geneva, sans-serif;
        font-size: 11px;
        width:100%;
    }

    .nav-tabs > li {
        margin-bottom: -2px;
    }

    .nav-tabs > li > a {
        line-height: 14px;
    }

    .resize {
        padding-left: 4px;
    }
    @media (max-width: 1200px) {

        .cartImg {
            height: 22px;
        }
        #menu-nav .icon {
            display: none;
        }
        #menu-nav {
            font-size:13px;
        }

        .resize {
            padding-left: 0px;
        }
    }

    .topLink {
        padding-left: 0px;
    }    

    .cartCntnt {
        font-size: 11px;

    }

    .cartLink:hover {
        color: #0088cc;
    }

    .navbar-collapse {
        padding-left: 0px;
        padding-right:0px;
    }

    .container-fluid {
        padding-left: 1%;
        padding-right:1%;
    }

    .nav > li > a:hover, .nav > li > a:focus {
        background-color: transparent;
    }

    .navbar-default .navbar-collapse, .navbar-default .navbar-form {

        background-color: white;
    }
</style>
<%@ include file="cart.jsp"%>
<!---header row--->
<div class="row" style="padding-top: 9px;">

    <!---logo header---->
    <div class="col-sm-6 col-md-5" >
        <a href="index">  <img src="images/logofront.png" class="img-responsive" alt="Responsive image"></a>
    </div>

    <!-----links/social media header----->
    <div class="col-md-7 "> 
        <div class="linkheader">

            <ul class="topLink">
            	<li><a href="en">English</a></li>
                <li>|</li>
                <li><a href="blog">Blog</a></li>
                <li>|</li>
                <li>  
                    <a href="javascript: void(0)" data-toggle="popover" data-trigger="focus" id="popoverExampleTwo" style="cursor: pointer"><img class="cartImg" src="images/topcart.ico"> Giỏ hàng</a>
                </li>
                <li>|</li>
                <li><select title="Other Websites" onchange="if (this.value)
                            window.open(this.options[this.selectedIndex].value, '_blank')"  class="other-pdt-drop" name="other_website" id="other_website">
                        <option value="">Liên kết khác</option>
                        <option value="http://detergent-chemicals.net">Hóa Chất Ngành Tẩy Rửa</option>
                        <option value="http://paint-chemicals.com">Hóa Chất Ngành Sơn</option>
                        <option value="http://food-chemicals.com/">Hóa Chất Ngành Thực Phẩm</option>
                        <option value="http://textile-chemicals.net">Hóa Chất Ngành Dệt May</option>
                        <option value="http://paper-chemicals.biz">Hóa Chất Ngành Giấy</option>
                        <option value="http://inorganic-chemicals.com">Hóa Chất Vô Cơ</option>
                        <option value="http://pine-chemicals.com">Hóa Chất Chiết Xuất Từ Cây Thông</option>
                        <option value="http://palm-chemicals.com/">Hóa Chất Chiết Xuất Từ Cây Cọ</option>
                        <option value="http://phosphorouschemicals.com/">Hóa Chất Từ Photpho</option>
                    </select></li>


            </ul>

        </div>
    </div>
    <div class="col-xs-12 col-sm-5 col-sm-offset-1 col-md-4 col-md-offset-1" style="margin-top:10px;"> 
        <div class="social-link" style="  margin-left: 40px;">
            <ul>
                <li class="social-pdd-lft"><a href="https://www.facebook.com/pages/Tradeasia-International-Pte-Ltd-Vietnam/370572373138130" target="_blank" class="facebook" title="Facebook"><span style="display:none">Link8</span></a></li>
                <li class="social-pdd-lft"><a href="https://twitter.com/vietnam_int" target="_blank" class="twitter" title="Twitter"><span style="display:none">Link9</span></a></li>
                <li class="social-pdd-lft"><a href="https://www.linkedin.com/company/tradeasia-international-pte-ltd" target="_blank" class="in" title="LinkedIn"><span style="display:none">Link10</span></a></li>
                <li class="social-pdd-lft"><a href="https://www.pinterest.com/tradeasiaintern/" target="_blank" class="pinterest" title="Pinterest"><span style="display:none">Link11</span></a></li>
                <li class="social-pdd-lft"><a href="http://www.slideshare.net/chemtradeasia" target="_blank" class="slideshare" title="SlideShare"><span style="display:none">Link12</span></a></li> 
                <li class="social-pdd-lft"><a href="https://www.youtube.com/channel/UCuGjtXwMXnl4Yz4dfHgHdYw" target="_blank" class="youtube" title="YouTube"><span style="display:none">Link11</span></a></li>
                <li class="social-pdd-lft"><a href="rssfeed" class="rss" title="RSS"><span style="display:none">Link12</span></a></li>
                <li class="social-pdd-lft"><a href="#" onclick="window.print()" class="print" title="Print this Page"><span style="display:none">Link13</span></a></li> 
            </ul>
        </div>
    </div>

    <!----closing header row tag----> 
</div>



<!----nav bar---->
<div class="row">
    <div class="col-md-12" style="  margin-top: 19px; ">
        <nav class="navbar navbar-default" style="border: none;">
            <div class="container-fluid" style="padding:0px">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header" style="background-color: white;">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span> 
                    </button>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <div id="menu-nav" class="resize">
                        <ul class="nav navbg nav-tabs nav-justified" style="overflow:hidden; margin-bottom: 10px">
                            <li><a class="home" href="index"><span class="icon"></span>Trang chủ</a></li>
                            <li><a class="about" href="about-us"><span class="icon"></span>Giới thiệu</a></li>
                            <li><a class="productmenu" href="product"><span class="icon"></span>Sản phẩm</a></li>
                            <li><a class="events" href="blog"><span class="icon"></span>Blog</a></li>
                            <li><a class="gallery" href="gallery"><span class="icon"></span>Thư viện</a></li>
                            <li><a class="faq" href="faq"><span class="icon"></span>Hỏi đáp</a></li>
                            <li><a class="contact" href="contact-us"><span class="icon"></span>Liên hệ</a></li>
                        </ul>
                    </div>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav> 
    </div>
</div>


