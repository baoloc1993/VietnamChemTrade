<%@ include file = "../setting.jsp" %> 

<link href="css/screen.css" rel="stylesheet">
<body>
<div class = "container-fluid" style = "padding-right:27px; padding-left:5px; background-color: white;">
	<!--  HEADER -->
	<div class = "span12">
		<%@ include file="../header_nav.jsp"%>
	</div>
	<!--  END HEADER -->
	
	<div class = "span12" style = " margin-bottom:10px;">
	    ${message }
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