
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!---header row--->

<div class="row-fluid span12" style="padding-top: 9px;padding-left: 11px">

    <!---logo header---->
    <div class="span8" >
        <a href = "index"><img src="images/logofront.png" class="img-responsive" alt="Responsive image" ></a>
    </div>

    <!-----links/social media header----->
    <div class="span4">      
        <div class="linkheader" style="margin-top: -15px; margin-bottom:40px;">
            <ul>
                <li class="top-menu-pdd-lft"><a href="/index.php?r=TblCareersPosts">Career</a></li>
                <li>|</li>
                <li><a href="javascript:void(0);">Forum</a></li>
                <li>|</li>
                <li><a href="javascript:void(0);">Blog</a></li>
                <li>|</li>
                <li><a href="sitemap">Sitemap</a></li>
            </ul>
        </div>
        <br><br>
        <div class="social-link" style="float:left">
            <ul>
                <li class="social-pdd-lft"><a href="https://www.facebook.com/TradeasiaInternationalGroup" target="_blank" class="facebook" title="Facebook"><span style="display:none">Link8</span></a></li>
                <li class="social-pdd-lft"><a href="https://twitter.com/SreeTradeasia" target="_blank" class="twitter" title="Twitter"><span style="display:none">Link9</span></a></li>
                <li class="social-pdd-lft"><a href="https://www.linkedin.com/company/tradeasia-international-pte-ltd" target="_blank" class="in" title="LinkedIn"><span style="display:none">Link10</span></a></li>
                <li class="social-pdd-lft"><a href="https://www.youtube.com/channel/UCuGjtXwMXnl4Yz4dfHgHdYw" target="_blank" class="youtube" title="YouTube"><span style="display:none">Link11</span></a></li>
                <li class="social-pdd-lft"><a href="index.php?r=TblRssFeeds" class="rss" title="RSS"><span style="display:none">Link12</span></a></li>
                <li class="social-pdd-lft"><a href="#" onclick="window.print()" class="print" title="Print this Page"><span style="display:none">Link13</span></a></li>           
            </ul>
        </div>
    </div>

    <!----closing header row tag---->    
</div>

<!----nav bar---->
<div class="row-fluid span12" style  = "margin-left:0px;">
    <div class="span12" style="margin-top: 19px;margin-bottom:-29px">
        <nav class="navbar navbar-default"  style="border: none;background: transparent;">
            <div class="container-fluid" style="padding:0px">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span> 
                    </button>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" >

                    <div id="menu-nav">
                        <ul class="nav navbg nav-tabs nav-justified" style="overflow:hidden;">
                            <li><a class = "home" href = "index" style=" width: 100%;"><span class="icon"></span>Home</a></li>
                            <li><a class="about" href="about-us" style=" width: 100%;"><span class="icon"></span>About Us</a></li>
                            <li><a class="productmenu" href="product" style=" width: 100%;"><span class="icon"></span>Products</a></li>
                            <li><a class="events" href="event" style=" width: 100%;"><span class="icon"></span>Events</a></li>
                            <li><a class="gallery" href="gallery" style=" width: 100%;"><span class="icon"></span>Gallery</a></li>
                            <li><a class="faq" href="faq" style=" width: 100%;"><span class="icon"></span>FAQs</a></li>
                            <li><a class="contact" href="contact-us?cid=6" style=" width: 100%;"><span class="icon"></span>Contact Us</a></li>
                        </ul>
                    </div>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>        
    </div>
</div>