<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>

<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>

<script>
    function go_widget(id) {
        
    	alert(id);
    	url= "usefulTools?id=" +id;
    	window.location = url;
        
        return false;
    }
</script>
<div class = "row-fluid">

<!--  USEFUL TOOL AND WIDGET -->
<div id = "widget" class ="span3 box1">

		<div class="widget-head"><a style = "color:white;">Useful Tools & Widgets</a></div>
			<c:forEach items = "${widgets}" var = "widget">
		        <div class="paint-table" style = "margin-left:0px;">
						<img src="images/point.png" class="view-all-txt" width="6" height="9" alt="image25">      
		        		<a  title="${widget.name }" onclick = "go_widget(${widget.id})" style = "cursor:pointer;">${widget.shortname }</a>
		        </div>
	        </c:forEach>
	        	<div class="paint-table" style="margin-left:0px;">
						
		        </div>
        
           
		
		</div>
	<!--  ASSOCIATION AND RESOURCE -->
	<div id = "resource" class ="box2 span3">
		<div class="widget-head-association">Association & Resources</div>
		<c:forEach items = "${assoRes }" var = "asr">
		
			<div class="paint-table" style = "margin-left:0px;">
					<img src="images/point.png" class="view-all-txt" width="6" height="9" alt="image25">      
	        		<a href="${asr.link }"  title="${asr.name }">
	                      ${asr.shortname} </a>
	        </div>
         </c:forEach>
        
        <div class="paint-table" style = "margin-left:0px;">      
        		<a href="usefulTools" target="_blank" title="Read More">
                      Read More >></a>
        </div>
        
	</div>
	
	<!--  DOWNLOAD CENTER	 -->		              
	<div id = "download_center" class ="box1 span3" >
		
			<div class="widget-head-download">Download Center</div>
			
			<div class="paint-table" style = "margin-left:0px;">
				<img src="images/point.png" class="view-all-txt" width="6" height="9" alt="image25">      
			      
        		<a href="" target="_blank" title="Crude Palm Oil (Indonesia Origin)">
                      Crude Palm Oil (Indonesia...</a>
        </div>
        <div class="paint-table" style = "margin-left:0px;">
				<img src="images/point.png" class="view-all-txt" width="6" height="9" alt="image25">      
              
        		<a href="" target="_blank" title="Sodium Hydrosulphite 88% (China Origin)">
                      Sodium Hydrosulphite 88%...</a>
        </div>
        <div class="paint-table" style = "margin-left:0px;">
				<img src="images/point.png" class="view-all-txt" width="6" height="9" alt="image25">      
              
        		<a href="" target="_blank" title="Galactose ( China Origin )">
                      Galactose ( China Origin )</a>
        </div>
        <div class="paint-table" style = "margin-left:0px;">      
        		<a href="" target="_blank" title="Read More">
                      Read More...</a>
        </div>
        <br><br><br>
       
	</div>
	
	<!--  TRADE ASIA MOBILE APP -->
	<div id = "mobile_app" class ="box2 span3">
		
        <div class="widget-head-app">Tradeasia Mobile App</div>
        <div class="phone-bg" style="text-align:center;">
        	<a href="https://play.google.com/store/search?q=ChemTradeAsia&amp;hl=en" alt="Google_Play" target="_blank" style="color: #FFF;"><img src="images/Google_Play_3new.png"  alt="image_google"></a>

        </div>
        
        <div class="phone-bg" style="margin-top: 7px; text-align:center;">
        	<a href="https://itunes.apple.com/us/app/chemtradeasia/id935598068?mt=8" alt="apple-store" target="_blank" style="color: #FFF;"><img src="images/apple-store.jpg"  alt="image2"></a>

    	</div>
    	<br>
	</div>

</div>