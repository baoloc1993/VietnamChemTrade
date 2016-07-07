<%-- 
    Document   : event
    Created on : 2015-5-26, 9:57:12
    Author     : Fla
    Fix 		: Ngo Le Bao Loc
--%>
<%@ include file = "../setting.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<title>Sự Kiện | Chemtradeasia | Tradeasia

International Pte Ltd - Việt Nam</title> 
<meta name = "keyword" content = "Nhà phân phối hóa chất, Triển lãm thương

mại ở Việt Nam, Hội Nghị Quốc Tế ở Việt

Nam, Nhà cung cấp hóa chất cơ bản ở Việt

Nam, Sự Kiện Thương Mại Hóa Chất Việt

Nam, Sự Kiện Kinh Doanh Hóa Chất Việt

Nam, Sự Kiện Thương Mại Việt Nam, sự

kiện về nông nghiệp, sự kiện về hóa chất">

<meta name = "description" content  = "Chemtradeasia: Cập nhật các sự kiện kinh

doanh hóa chất mới nhất trên toàn thế giới."/>
  <script type="text/javascript">
       function loadimage() {
    	   var text = "";
    	    var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    	    for( var i=0; i < 6; i++ )
    	        text += possible.charAt(Math.floor(Math.random() * possible.length));
    	  // String rand = Math.random();
           document.getElementById("randImage").src = "image?vCode=" + text;
           document.getElementById("vCode").value = text;
       }
   </script>
    <body>
    	<div class="container" style="padding-right:27px; padding-left:5px; background-color: white;">

            <!---to wrap around all body content--->
            <div class="col-md-10 col-md-offset-1  centerRow">
                <!----center content--->
                <div class="col-md-12">

                    <!---add the header and navbar and search bar---->
                    <%@include file="../header_nav.jsp"%>
                    <!--main part for event--->
                    <div class="col-md-12">
                           <!--  Find Event according to Date -->
                            <div class = "col-md-8">
	                            <form method="get"  action = "event" >
	                                <div class="findevent-title span2" style="font-size:110%; ">Tìm kiếm sự kiện: </div>
	                                	<!--  SELECT DATE -->
	                                <div>
		                                <select title="Date"  class="event-box"  style="font-size: 13px; font-weight: bold; width: 45%; padding: 0.8% 0.5% 0.8% 1%; border-radius: 5px; color: rgb(0, 0, 0); " name="date" id="date" onchange = "this.form.submit()">
		                                    <option value="">Chọn ngày</<option>
		                                    <option value="-">Tất cả<option>
		                                    <!--  LIST OPTION -->
		                                    <c:forEach items="${dates}" var="date">
												<option value= "${date}">${date}</option>
											</c:forEach>
											
											<!--  END LOOP -->
			                        	</select>
	                            	</div>
	                            </form>
	                    	</div>
	                    	<div id="tabs" class = "col-md-4">
                        	<!--  ADD NEW EVENT BUTTON -->
                            	<a href="addEvent" class="submit_events" target="_blank"><img src="images/submit-an-event.png" alt="event submit" style="float: right; "/></a>
                            </div>	
							
							<div id="yw0" class="list-view">
                        	<!--  min (position + 2, recordCount) -->
                            <div style="text-align:right;"><br><br>Hiển thị ${wrapper.position + 1}-
                            	<c:if test = "${wrapper.position + 2 >= wrapper.recordCount}">  
                            		${wrapper.recordCount }
                            	</c:if>
                            	<c:if test = "${wrapper.position + 2 < wrapper.recordCount}">  
                            		${wrapper.position + 2 + 1 }
                            	</c:if> trong ${wrapper.recordCount} sự kiện.</div>
                            <!--  END IF -->
                        </div>
                        </div>
                        
					</div>
				</div>
                <div class="items col-md-12">
                 <!--  DISPLAY A LIST OF EVENT  LOOP -->
                 	<c:if test = "${wrapper.pageSize > 0 }">
                	<c:forEach var = "event" items = "${wrapper.results }" begin = "${wrapper.position}" end = "${wrapper.pageSize + wrapper.position - 1 }">
                	
                     <div style="width: 100%;">
                     	
                         <div style="width: 100%; height: 12%;">
                         	
                             <h4 style="color: #FFF; font-size: 100%; text-align: left; padding: 1% 2%; background-image: linear-gradient(#0A7BBF, #0865A0); border-radius: 5px; font-family: Oxygen-Bold,Roboto-regular;">${event.date}</h4>
                         </div>
                         <table style="table-layout: fixed;"> 
                             <tr style="display: none;"><th></th></tr>
                             <tr>
                                 <td style="width: 20%;">
                                     <img src="${event.img}" alt="News Image" style="height:120px; width:120px;"/> 
                                 </td>
                                 <td style=" word-wrap: break-word; height: 50%">
                                 	
                                     <a href = "
                                     	<c:url value="single_event">
                                     		<c:param name="id" value="${event.id}"/>
                                     	</c:url>"
                                     	style="vertical-align: top; color: #000000; text-decoration: none; font-size: 1.5em">
                                     	<b><br>${event.title}</b><br>
                                     </a>
                                     <table style="table-layout: fixed; width: 85%">
                                         <tbody>
                                             <tr style="display:none;"><th></th></tr>
                                             <tr><td style="width: 15%;"><b style="color: #c8102a;"><br>Date:</b></td><td><br> ${event.date}</td></tr>
                                             <tr><td style="width: 15%;"><b style="color: #c8102a;"><br>Location:</b></td><td style="word-wrap: break-word;"><br> ${event.location}</td></tr>
                                             <tr><td style="width: 15%;"><b style="color: #c8102a;"><br>Event Link:</b></td><td style="word-wrap: break-word;"><br>${event.link}</td></tr>
                                             <tr><td style="width: 15%;">
                                             		<b style="color: #c8102a;"><br>Description:</b>
                                             	</td>
                                             	<td style="word-wrap: break-word;"><br>${event.description}
                                             		<a href = "<c:url value="eventSingle.jsp">
                                     						<c:param name="id" value="${event.id}"/>
                                     					</c:url>" style="color: #c8102a;">[Xem thêm...]
                                     				</a>
                                                 </td></tr>
                                         </tbody>
                                     </table>
                                     <br>
                                 </td>
                             </tr>
                         </table>
                         <table style="width:100%;"> 
                             <tr><th></th></tr>
                             <tr>
                                 <th style="line-height: 5px; border-bottom: #000000 1px dotted;"></th>
                             </tr>
                         </table>
                     </div>
               		</c:forEach>
               		</c:if>
                    <!--  END LOOP -->
                </div>
                <br>
                <br>
                <div class="pagerClass">
                    <ul class="col-xd-12 col-md-12 pager centerRow">
                        <li>Go to page:</li>
                        <!--  IF CURRENT PAGE IS PAGE 1, DO NOT DISPLAY PREV BUTTON -->
                        <c:if test = "${wrapper.showPage  > 1 }">
                        	<li class="page" style="border-radius:0;">
                        		<a href = "<c:url value="event">
                                 		<c:param name="showPage" value="${wrapper.showPage - 1}"/>
                                 		<c:param name="date" value="${wrapper.showPage - 1}"/>
                                </c:url>"> < Previous</a></li>
                        </c:if>
                        <!--  END IF -->
                        <!--  FOR LOOP -->
                        <c:forEach var = "i" begin = "1" end = "${wrapper.pageCount}">
                        	<!--  BOLD THE SELECTED PAGE -->
                        	<c:if test = "${wrapper.showPage == i }">
                       			 <li class="page selected" style="border-radius:0;">
                       			 	<a href = "<c:url value="event">
                                    		<c:param name="page" value="${i}"/>
                                    </c:url>">${i}
                                 </a>
                               </li> 		
                        	</c:if>
                        	<c:if test = "${wrapper.showPage != i }">
                       			 <li class="page" style="border-radius:0;">
                       			 	<a href = "<c:url value="event">
                                    		<c:param name="page" value="${i}"/>
                                 </c:url>">${i}
                                 </a>
                              </li> 		
                        	</c:if>
                        </c:forEach>
                        <!--  END FOR LOOP -->
                        
                        <!-- IF CURRENT PAGE IS LAST PAGE, DO NOT DISPLAY THE NEXT BUTTON -->
                        <c:if test = "${wrapper.showPage  >1 }">
                        	<li class="page" style="border-radius:0;">
                        	<a href = "<c:url value="event">
                     	    		<c:param name="page" value="${wrapper.showPage + 1}"/>
                            </c:url>">Next >
                         </a>
                        	</li>
                        </c:if>
                       

                    </ul>
                </div>
			
	            <div class= "col-md-12"  >
					<%@ include file="../footer.jsp"%>	
				</div>
			</div>
         
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.js"></script>
    </body>
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
    
</html>
