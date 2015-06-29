<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>

<div class="latest-events-bg">
	<div class="news-head" style="font-size:15px;">LATEST EVENTS</div>
 

	<div id="slideshow2" class="carousel slide">             
	         <!-- Carousel items -->
	         <div class="carousel-inner">
	         	<c:forEach items = "${latestEvents}" var = "event">
	         		<c:if test="${event.active > 0}">
		             	<div class="item span12 active" style = "margin-left:0px;">
		            </c:if>
		            <c:if test="${event.active == 0}">
		             	<div class="item span12" style = "margin-left:0px;">
		            </c:if> 
		             	<div>
		                 	<img class = "span2" src="${event.link }">
		                 </div>
		               	<div class = "span8" style = "color:white;">
		                 	<p>${event.title}</p>
		                 	<p>${event.description }</p>
		                 	
		                 	<p> See more...</p>
		                 </div>
		             </div>
		         </c:forEach>

	             <!-- Carousel nav -->
	             <a class="carousel-control left" href="#slideshow2" data-slide="prev" style = "width:2%"></a>
	             <a class="carousel-control right" href="#slideshow2" data-slide="next" style = "width:2%"></a>
	             
	         </div>
	</div>
</div>