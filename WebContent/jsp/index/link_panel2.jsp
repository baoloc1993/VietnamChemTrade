<script>
    function go_widget(id) {
        
    	alert(id);
    	url= "usefulTools?id=" +id;
    	window.location = url;
        
        return false;
    }
</script>

<div class="row" style="padding-left: 1%;padding-right:1%;">

    <!-------WIDGETS-------->
    <div class="col-sm-12 col-md-3" style="margin-bottom:5px">
        <div class="row" >

            <div class="space">

                <div class="col-md-12 box1" style="padding-left:0px; padding-right: 0px;">
                    <div class="widget" style="background:#143D55">Useful Tools<br>& Widgets</div>
                </div>
                <div class="col-md-12 box1" style="padding-left:0px; padding-right: 0px;">
                    <div style="padding-left: 5px">      
                        <ul style="  list-style: none; margin: 0px; padding: 0px;">
							<c:forEach items = "${widgets}" var = "widget">
							
	                            <li style=" min-height: 36px; border-bottom:dotted thin #ffffff;">
	
	                                <a class="paint-table" style  = "cursor:pointer" onclick = "go_widget('${widget.id}')" target="_blank" title="${widget.name }">
	                                   ${widget.shortname }</a>
	                            </li>
	                        </c:forEach>

                            <li style=" min-height: 30px; text-align: center;">
                                <a href="usefulTools" style="color:white;text-decoration: none">[View All]</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>

        </div>

    </div>
    <!-------Assc and Resrc-------->
    <div class="col-sm-12 col-md-3" style="margin-bottom:5px" >
        <div class="row" >

            <div class="space">

                <div class="col-md-12 box2" style="padding-left:0px; padding-right: 0px;">
                    <div class="widget" style="background:#7E9234">Association<br>& Resources</div>
                </div>
                <div class="col-md-12 box2" style="padding-left:0px; padding-right: 0px;">
                    <div style="padding-left: 5px">      
                        <ul style="  list-style: none; margin: 0px; padding: 0px;">

                           <c:forEach items = "${assoRes }" var = "asr">
	                            <li style=" min-height: 36px; border-bottom:dotted thin #ffffff;"><div class="assc">
	                                    <a class="association-table" href="${asr.link }" target="_blank" title="${asr.name }">
	                                       ${asr.shortname} </a></div>
	                            </li>
							</c:forEach>
                            

                            <li style=" min-height: 30px; text-align: center;">
                                <a href="usefulTools" style="color:white;text-decoration: none">[View All]</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>

        </div>

    </div>
    <!-------Events-------->
    <div class="col-sm-12 col-md-3" style="margin-bottom:5px">
        <div class="row" >

            <div class="space">

                <div class="col-md-12 box1" style="padding-left:0px; padding-right: 0px;">
                    <div class="widget" style="background:#143D55">Event<br>Center</div>
                </div>
                <div class="col-md-12 box1" style="padding-left:0px; padding-right: 0px;">
                    <div style="padding-left: 5px">      
                        <ul style="  list-style: none; margin: 0px; padding: 0px;">
							<c:forEach items = "${latestEvents}" var = "event">
	                            <li style=" min-height: 36px; border-bottom:dotted thin #ffffff;">
	                                <div class="assc">
	                                     <form id="my_formE${event.id}" action="event-details" method="get">
	                						<input type="hidden" name="id" value="${event.id }">
	            						</form>        
	            					<a href="${link }" class="association-table" target="_blank" title="${event.title }">
	                                   
	                                        ${event.shortName }</a></div>
	                            </li>

                        	</c:forEach>
                            <li style=" min-height: 30px; text-align: center;">
                                <a href="event" style="color:white;text-decoration: none">[Read More]</a>
                            </li>

                        </ul>
                    </div>
                </div>
            </div>

        </div>

    </div>
    <!-------Mobile Apps-------->
    <div class="col-sm-12 col-md-3" style="margin-bottom:5px">
        <div class="row" >

            <div class="col-md-12 box2" style="padding-left:0px; padding-right: 0px;">
                <div class="widget" style="background:#7E9234">Tradeasia<br>Mobile App</div>
            </div>
            <div class="col-md-12 box2" style="padding-left:0px; padding-right: 0px;">
                <div style="padding-left: 5px">      
                    <div class="row">
                        <div class="col-xs-6 col-md-12" style="padding-bottom:10px">

                            <br>
                            <br>
                            <br>
                            <div style="text-align:center;">
                                <a href="https://play.google.com/store/search?q=ChemTradeAsia&amp;hl=en" target="_blank" style="color: #FFF;">
                                    <img src="images/misc/Google_Play.png" class="img-rounded" width="120" height="40" alt="image_google"></a>
                                <!--<div class="downloads-description"><a href="https://play.google.com/store/search?q=ChemTradeAsia&hl=en" alt="Download Our apple app" target="_blank" style="color: #FFF;">Download Our Android App</a>
                                </div>-->
                            </div>
                        </div>
                        <br>
                        <br>
                        <br>

                        <div class="col-xs-6 col-md-12">
                            <div style="text-align:center;">
                                <a href="https://itunes.apple.com/us/app/chemtradeasia/id935598068?mt=8" target="_blank" style="color: #FFF;">
                                    <img src="images/misc/apple-store.png" class="img-rounded" width="120" height="40" alt="image2"></a>
                                <!--<div class="downloads-description"><a href="https://play.google.com/store/search?q=ChemTradeAsia&hl=en" alt="Download Our apple app" target="_blank" style="color: #FFF;">Download Our Android App</a>
                                </div>-->
                            </div>
                            <br>
                            <br>
                            <br>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div> 