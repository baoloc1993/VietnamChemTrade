<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-sm-9" style="padding-right: 5px; margin-bottom: 10px; padding-left: 0px;">


     <div id="myCarousel" class="carousel slide" data-ride="carousel" data-interval="3000">
         <!-- Indicators -->
         <ol class="carousel-indicators">
             <c:forEach items = "${wrapperBanners }" var = "banner">
            	 	<li data-target="#myCarousel" data-slide-to="${banner.count }" class="${banner.active }"></li>
			</c:forEach>
         </ol>

         <!-- Wrapper for slides -->
         <div class="carousel-inner" role="listbox">
			<c:forEach items = "${wrapperBanners }" var = "banner">
             
             <div class="item ${banner.active}">
                 <img style="width:100%" src="images/images_new/${banner.banner.filePath}" alt="${banner.banner.name }">
                 <div class="container">
                     <div class="carousel-caption">
                         <p><a class="btn btn-lg ${banner.btnColor}" target="_blank" href="${banner.btnLink}">${banner.btnName}</a>
                         </p>
                     </div>
                 </div>
             </div>
			</c:forEach>
             

         </div>

         <!-- Left and right controls -->
         <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
             <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
             <span class="sr-only">Previous</span>
         </a>
         <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
             <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
             <span class="sr-only">Next</span>
         </a>
     </div>


 </div>