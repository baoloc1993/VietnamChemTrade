<%@ include file = "../setting.jsp" %> 


<body>
<div class = "container-fluid" style = " padding-left:5%x; background-color: white;">
	<!--  HEADER -->
	<div class = "span12">
		<%@ include file="../header_nav.jsp"%>
	</div>
	<!--  END HEADER -->
	<!--  SEARCH BAR -->
	<div class = "span12" style = " margin-bottom:10px;">
			<%@ include file="search.jsp"%>
	</div>
	<!--  END SEARCH BAR -->
	<!-- THIRD PART -->
	<div class = "span12" id = "third_part">
		<div class = "row-fluid" style = "">
		<!--/.nav-collapse -->
	         <!--  SLIDER -->
			    <div class="span9">
					<%@ include file="Imageslider.jsp"%>
				</div>
			<!--  END SLIDER -->

		
			<!-- CATEGORY PRODUCT -->
	
				<div class = "span3" style = "margin-left:1%;" >
					<%@ include file="productCategory.jsp"%>
				</div>

			<!--  END CATRGORY PRODUCT -->
	
		</div>
	</div>
	<!--  END THIRD PART -->
	<!--  FOURTH PART (TOP PRODUCT)-->
	<div class= "span12" style = "padding-right:1%; ">
		<%@ include file="topProduct2.jsp"%>
	</div>
	<!--  END  FOURTH PART-->
	<!--  FIFTH PART -->
	<div class= "span12" style = "padding-right:1%;">
				<%@ include file="fifth_part.jsp"%>
	</div>
	<!--  END FIFTH PART -->
	<!--  SIXTH  PART-->
	<div id= "sixth_part" class= "span12" style = "padding-right:1%;">
		<div class = "row-fluid">
			<!--  OTHER WEBSITE -->
			<div id= "other_website" class= "span3" >
					<%@ include file="other_website.jsp"%>
			</div>
			<div id= "quick_enquiry" class= "span9" >
					<%@ include file="quick_enquiry.jsp"%>
			</div>
		</div>
	</div>
	<!--  END SIXTH PART -->
	<!--  SEVENT PART -->
	<div id = "latest_event" class= "span12" style = "padding-right:1%;">
				<%@ include file="latest_event.jsp"%>	
	</div>
	<div  id= "footer" class= "span12" style = "padding-right:1%;">
				<%@ include file="../footer.jsp"%>	
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
</html>