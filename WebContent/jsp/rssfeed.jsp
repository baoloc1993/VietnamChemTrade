<%@ include file = "setting.jsp" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="css/screen.css" rel="stylesheet">
<body>
<div class = "container" >
	<!--  HEADER -->
	<div class = "col-md-10 col-md-offset-1 centerRow">
		<%@ include file="header_nav.jsp"%>
	
	<!--  END HEADER -->
	
	<div>
       <table>
                 <tr>
                      <td colspan="3">

                         <table>
 
                            <tr><td colspan="4" style="padding-left:15px;">
                                 <h3 style="color: #1a5292; font-size: 2.0em"><b>RSS Feeds</b></h3>
                            </tr>
 
                            <tr><td colspan="4" >
                                               </td>
                            </tr>

                            <tr>
                                 <td>
                                    <div id="accordion">
										<c:forEach items = "${wrappers }" var = "wrapper">
											<h3><b>${wrapper.category }</b></h3>
											<div>
                                            	<table>
													<tr style="display:none;"><th></th></tr>
                                                    <tr>
                                                    	<c:forEach items = "${wrapper.rssFeeds}" var = "rssFeed">
                                                    		<td>
                                                    			<img src="images/feed-icon.gif" width="12" height="12" alt="feed">&nbsp;&nbsp;
                                                                <span onclick="showRSS('${rssFeed.link}');" style="cursor:pointer;">
                                                                	<span style="font-color:#666666;">${rssFeed.name }</span>
                                                                 </span>
                                                             </td>
                                                        </c:forEach>
                                                  	</tr>
                                                 </table>
                                            </div>   
										</c:forEach>
                                  	</div>
                             	</td> 
                             </tr>
                         </table>
                   </td>
             </tr>
             <tr>
                   <td>
                         
                         <div id="rssOutput">
                               
                         </div>
                   <td>
             </tr>
    </table>
<script>


function showRSS(str) {
  //alert(str);
  window.location = (str);
  document.getElementById("rssOutput").innerHTML = "";
  
  if (str.length==0) {
    document.getElementById("rssOutput").innerHTML="";
    return;
  }
  if (window.XMLHttpRequest) {
    // code for IE7+, Firefox, Chrome, Opera, Safari
    xmlhttp=new XMLHttpRequest();
  } else {  // code for IE6, IE5
    xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
  xmlhttp.onreadystatechange=function() {
    if (xmlhttp.readyState==4 && xmlhttp.status==200) {
      alert(xmlhttp.responseText);
      
      document.getElementById("rssOutput").innerHTML=xmlhttp.responseText;
    }
  }
 // alert(str+'12');
  xmlhttp.open("post",encodeURI(str),true);
  xmlhttp.send();
}
</script>


	
	
	<div  id= "footer" class= "span12" style = "padding-right:1%;">
				<%@ include file="footer.jsp"%>	
	</div>
</div>
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