<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

   <%@include file = "setting.jsp"%>
    <body>
        <div class="container-fluid" style="padding-right: 5%; background-color: white;">

           
                <!----center content--->
                

                    <!---add the header and navbar and search bar---->
                                 
				<div class="row-fluid">
					<%@include file="header_nav.jsp"%> 
                    <!----wolfram----->
                    <div class="container-fluid span" >
                        <div class="row-fluid" style="margin-top:15px;">
                            <div class="span3 ">

                                <h3 style="color: #1a5292;"><b>Useful Widgets</b></h3>
                            </div>
                        </div>

                        <div class="row-fluid" >
                            <div class="span12">

                                <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
									<c:forEach items = "${widgets}" var = "widget">

	                                    <div class="panel panel-default">
	                                        <div class="panel-heading" role="tab" id="heading${widget.id }" data-toggle="collapse" data-parent="#accordion" href="#collapse${widget.id}" aria-expanded="true" aria-controls="collapse${widget.id}">
	                                            <h3 class="panel-title">
	                                                ${widget.name}
	                                            </h3>
	                                        </div>
	                                        
	                                        <div id="collapse${widget.id}" 
	                                        		 <c:if test = "${widget.id != id }">
	                                        		 	class = "panel-collapse collapse"
	                                        		 </c:if>
	                                        		 <c:if test = "${widget.id == id }">
	                                        		 	class = "panel-collapse collapse in"
	                                        		 </c:if>
	                                        		 role="tabpanel" aria-labelledby="heading${widget.id }">
	                                            <div class="panel-body">
	                                                ${widget.code }
	                                            </div>
	                                        </div>
	                                    </div>

                                    </c:forEach>
                                   

                                </div>
                            </div>

                        </div>

                        <div class="row-fluid span12" >

                            <div class="span5">   
                                <div style="margin-bottom:14px">
                                    <h3>Association</h3>
                                </div>

								<c:forEach items = "${associations}" var = "association">
	                                <a class="linkStyle" target="_blank" href="${association.code }">
	                                    <div class="span12 tBody">
	                                        ${association.name}
	                                    </div>
	                                </a>
								</c:forEach>


                            </div>

                            <div class="span5 offset1" >

                                <div style="margin-bottom:14px">
                                    <h3>Resources</h3></div>


                     			<c:forEach items = "${resources}" var = "resource">
	                                <a class="linkStyle" target="_blank" href="${resource.code}">
	                                    <div class="span12 tBody">
	                                        ${resource.name }
	                                    </div>
	                                </a>
								</c:forEach>


                            </div>

                        </div>

                        <!-- Footer Codes -->
                        
                    </div>
					
                </div>
                <%@include file="footer.jsp"%>
            </div>
            
        
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.js"></script>

       
        <script src="js/tradeasia.js"></script>

    </body>

