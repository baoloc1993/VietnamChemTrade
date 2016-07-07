<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ include file = "setting.jsp" %>

        <style>

            .modal-open {
                padding-right: 0 !important;
            }

            .nav > li > a:hover, .nav > li > a:focus {
                background-color: #C3FDB8;
            }

            #imgScale {
                height: 130px;
                width: 130px;
                margin-left: auto;
                margin-right: auto;
            }

            #vdScale {
                height: 150px;
                width: 150px;
                margin-left: auto;
                margin-right: auto;
            }


            .btn-info {
                width: 100px;
                height: 30px;
            }

            .btn {
                line-height: 0.428571;
            }
            img {
                cursor: pointer;
            }

            .noResult {
                text-align: center;
                margin-top: 18px;
                color: black;
            }


            .search-btn {
                background: url('images/search-btn-bg.jpg') repeat;
                border: 1px #659c09 solid;
                text-align: center;
                color: #ffffff;
                border-radius: 0px;
                font-size: 90%;
            }

            .form-group {
                margin-bottom: 6px;
            }

            .clearSearch {
                margin-left:10px;
                text-decoration: underline;
            }


            @media (max-width: 1200px) {

                .clearSearch {
                    margin-top:7px;
                    margin-left:0px;
                }
            }

        </style>




    <body>

        <div class="container" style="padding-right:27px; padding-left:5px">

            <!---to wrap around all body content--->
            <div class="row">
                <!----center content--->
                <div class="col-md-10 col-md-offset-1 centerRow">

                    <!---add the header and navbar and search bar---->
                    <%@include file="header_nav.jsp"%>


                    <!--Start of Gallery tab----->
                    <div class="container-fluid" style="margin-top:20px">

                        <div class="row" style="margin-bottom: 10px"> 

                            <!--Search Form---->
                            <form method="get" action="gallery" >

                                

                                <div class="col-md-5">
                                    <div class="form-group">
                                        <input type="text" class="form-control" value="${searchWord }" name="searchTB" placeholder="Search by chemical name" required>
                                        <div style="margin-top:10px; font-size: 11px;" > <i>Tìm kiếm trong:  
                                                <label class="radio-inline" style="margin-left:5px"> <input type="radio" name="searchType" value="p" checked  = "checked"> Thư viện ảnh</label>
                                                <label class="radio-inline"> <input type="radio" name="searchType" value="v"> Thư viện phim</label>
                                                <label class="radion-iline"><a href="gallery"><div class= "clearSearch">Xóa tìm kiếm</div></a></label>
                                            </i></div>


                                    </div>
                                </div>
								

                                <div class="col-md-2" >
                                    <input type="submit" class="btn btn-info " value="Search">
                                </div>
								<div class="col-md-5"></div>

                            </form>
                        </div>

						<!--  TAB NAME -->
                        <ul class="nav nav-tabs">
                            <li class="active"><a data-toggle="tab" href="#photo" style = "color: rgb(90, 85, 85);" >Thư viện ảnh</a></li>
                            <li><a data-toggle="tab" href="#video" style = "color: rgb(90, 85, 85);">Thư viện phim</a></li>
                        </ul>
						<!-- END TAB NAME -->
                        <!---START OF TAB CONTENT------>
                        <div class="tab-content" style="border: 1px solid #ddd;background-color: white;"">

                            <!--PHOTO TAB---->
                            <div id="photo" class="tab-pane fade in active">

                                <div class="row" style="padding-bottom:20px">,
									<c:forEach items = "${pGallery}" var = "photo">
                                    
	                                    <div class="col-md-3" style="margin-top:15px">
	                                        <img id="imgScale" class="img-responsive" src="${photo.galleryPath}" alt="img">
	                                        <p />
	                                        <b>${photo.galleryName} (${photo.listSize} Pictures)</b>
	                                    </div>
									</c:forEach>
                                    <div class="noResult">${pMessage }</div>

                                </div>
                            </div>

                            <!--VIDEO TAB----->
                            <div id="video" class="tab-pane fade">

                                <div class="row" style="padding-bottom:20px">
                                	<c:forEach items = "${vGallery}" var = "video">
                                    
	                                    <div class="col-md-3" style="margin-top:15px">

	                                        <a data-toggle="modal" data-target="#${video.videoID}">
	                                            <img id="vdScale" class="img-responsive" src="${video.videoThumbnail }" alt="${video.videoName }">
	
	                                        </a>
	                                        <p />
	                                        <b>${video.videoName }</b>
	
	
	                                        <div class="modal fade" id="${video.videoID }" role="dialog">
	                                            <div class="modal-dialog">
	                                                <!-- Modal content-->
	                                                <div class="modal-content">
	
	                                                    <div class="modal-header">
	                                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
	                                                        <h5 class="modal-title" style="text-align: center">${video.videoName }</h5>
	                                                    </div>
	                                                    <div class="modal-body">
	                                                        <div class="embed-responsive embed-responsive-16by9">
	                                                            <iframe class="embed-responsive-item" src="//www.youtube.com/embed/${video.videoLink }?rel=0&autoplay=0" allowfullscreen=""></iframe>
	                                                        </div> <p>
	
	                                                        <h6>Dừng video trước khi thoát</h6>
	
	                                                    </div>
	                                                    <div class="modal-footer">
	                                                        <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
	                                                    </div>
	                                                </div>
	
	                                            </div>
	                                        </div>
	
	
	                                    </div>
									</c:forEach>
                                    <div class="noResult">${vMessage }</div>


                                </div>

                            </div>
                        </div>
                       


                    </div>


                    <!----bootstrap image---->
                    <!----

                    <!-- The Bootstrap Image Gallery lightbox, should be a child element of the document body
                    <div id="blueimp-gallery" class="blueimp-gallery">
                    <!-- The container for the modal slides --
                    <div class="slides"></div>
                    <!-- Controls for the borderless lightbox --
                    <h3 class="title"></h3>
                    <a class="prev">â¹</a>
                    <a class="next">âº</a>
                    <a class="close">Ã</a>
                    <a class="play-pause"></a>
                    <ol class="indicator"></ol>
                    <!-- The modal dialog, which will be used to wrap the lightbox content --
                    <div class="modal fade">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" aria-hidden="true">&times;</button>
                                    <h4 class="modal-title"></h4>
                                </div>
                                <div class="modal-body next"></div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default pull-left prev">
                                        <i class="glyphicon glyphicon-chevron-left"></i>
                                        Previous
                                    </button>
                                    <button type="button" class="btn btn-primary next">
                                        Next
                                        <i class="glyphicon glyphicon-chevron-right"></i>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                
                    <!---images---
                    <div id="links">
                        <a href="images/banana.jpg" title="Banana" data-gallery>
                            <img src="images/thumbnails/banana.jpg" alt="Banana">
                        </a>
                        <a href="images/apple.jpg" title="Apple" data-gallery>
                            <img src="images/thumbnails/apple.jpg" alt="Apple">
                        </a>
                        <a href="images/orange.jpg" title="Orange" data-gallery>
                            <img src="images/thumbnails/orange.jpg" alt="Orange">
                        </a>
                    </div>

                    ---->


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
