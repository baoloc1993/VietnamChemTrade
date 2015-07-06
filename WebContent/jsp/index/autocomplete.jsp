

<%@page import="java.util.*"%>
<%@page import="chemtrade.controller.product.*"%>
<%@page import="chemtrade.entity.*"%>
<%@page import="java.sql.*"%>
<%
	String searchComplete = "";
	ArrayList<Product> products =  new ProductController().getProductListFromDB();
	for (Product product : products){
		searchComplete += product.getProductName() + ",";
	}
    
%>
<meta charset="utf-8">
<title>autocomplete demo</title>

<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<style>
    .search-field {
        background: #ffffff;
          
        height: 30px;
        margin: -1px;
        border: 1px #d3d3d3 solid;
        font-family: Oxygen-Regular,Verdana, Geneva, sans-serif;
        font-size: 95%;
        color: #666666;
        /* padding: 0px 10px; */
        float: left;
        white-space: pre-line;
        margin-bottom: 10px;
    }
     .search-icon {
        background: #fff url('images/search-icon.png') no-repeat 98% center;
    }
    
    .ui-autocomplete { height: 150px; overflow-y: scroll; overflow-x: hidden;font-size: 12px}
</style>


<input  type="text" class="search-field search-icon col-md-10 col-xs-12" placeholder="Search for a chemical by Name, CAS No. HS code, Origin" name="keyword" id="keywordkk" title="keywordkk">

<script>
    $("#keywordkk").autocomplete({
        minChars : 4,
        scroll : true,
        scrollHeight: 220,
        source: [<%=searchComplete%>,"x"]
    });
</script>
