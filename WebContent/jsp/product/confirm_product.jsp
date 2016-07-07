<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file = "../setting.jsp"%>
<body>

<div class = "container">
	<div class = "col-md-10 col-md-offset-1 centerRow">
		<%@ include file = "../header_nav.jsp"%>
		<div class="confirmation-bg">
			<div class="confirmation-box">
				 <table class="tblbord" >
						  
						  ${message }
						 
				</table>
			 </div>
		</div>
		<%@ include file = "../footer.jsp"%>
	</div>
</div>

</body>