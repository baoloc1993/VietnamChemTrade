<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>



<div class="span3">
   <div class="eventPanel">
       <table>
           <tbody class="span12">
           <tr class="span12"><td class="eventPanel span12">
                   <table style="margin-left:auto;width:100%;">
                       
                       <tbody><tr style="background-color:#6e4792;width: 100%">
                           <td style="margin-left:20%; width:15%;vertical-align: central"><img src="images/event_icon.png" width="20" height="15" style="padding-left:15%;"></td>
                           <td style="width:75%;"><h3 style="font-family:Verdana;">Events</h3></td>
                       </tr>
                       <tr>
                           <td colspan="2" style="height:2pt;background-color:whitesmoke; text-align:left; vertical-align:top;width:100%">
                       <marquee direction="up">	                                     
                           <ul>
			   				<c:forEach items = "${events}" var = "event">
			 					<li style="list-style-type:none">
			                          <table style="table-layout: fixed;">
			                              <tr><td style="word-wrap: break-word;">
			                                      <img src="${event.img}" alt="evcent" width="50" height="50" style="float:left; padding:0px 5px 0px 5px" >
			                                      <span>${event.date}</span><br> 
			                                      <a target="_top" href="
			                                      	<c:url value="eventSingle.jsp">
														<c:param name="id" value="${event.id}"/>
													</c:url>" 
														style="text-decoration:none; font-size:75%; text-align:justify; font-weight:normal; color:#333333" class="title">
			                                          <span style="font-weight:bold;">${event.title}</span>
			                                      </a>
			                              </td></tr>
			                  		</table>
			                  	</li>
			                  	<li style="list-style-type:none">
			                    	<br><img src="images/event_line.png" width="240" alt="event_line"><br><br>
			                    </li>
							</c:forEach>                                                                                                          
                            </ul>
                        </marquee>   
                </td>
            </tr>
            <tr height="45">
                <td colspan="2"><div id="viewAll"><a href="#"><span style="color:white;width: 100%">View all</span></a></div></td>
            </tr>     
        </tbody></table> 
        </td>
        </tr>
        </tbody>
        </table>
    </div>
      
</div>