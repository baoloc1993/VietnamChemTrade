<%-- 
    Document   : products-category
    Created on : June 8, 2015, 11:24:12 AM
    Author     : Qianpin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Chemtradeasia | Your Trusted Partner for Chemicals</title>
        <link rel="shortcut icon" href="icon/favicon.ico" type="icon/x-icon">
        <link rel="SHORTCUT ICON" href="icon/favicon.ico">
        <link rel="icon" href="images/favicon.ico" type="image/x-icon">

        <!-- Bootstrap -->
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <link href="css/fonts.css" rel="stylesheet">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

        <style>
            .pdf {
                cursor:pointer;
            }
        </style>

    </head>

    <body>
        <div class="container">
            <!---to wrap around all body content--->
            <div class="row">
                <!----center content--->
                <div class="col-md-10 col-md-offset-1 centerRow">

                    <!---add the header and navbar---->
                    <%@include file="../header_nav.jsp"%>
                    <jsp:include page="../index/searchbar.jsp"/>

                    <div class="container-fluid" style="margin-bottom:10px">
                        <!-- Products Banner-->
                        <div class="row">
                            <div class="col-md-12" style="margin-top:10px;">
                                <a href="products-top.jsp" onclick="<%session.setAttribute("letter-chosen", null);%>">
                                    <img class="img-responsive" src="images/products/products-top-banner.jpg" alt="products-banner">
                                </a>
                            </div>
                        </div>

                        <!--Shortcut Product Buttons-->
                        <div class="row" style="margin-top:10px">

                            <div class="col-xs-2 col-md-6">

                            </div>
                            <div class="col-xs-5 col-md-3">
                                <!-- The Products buttons -->
                                <a href="products-category.jsp"><img style="min-width:100px" class="img-responsive" src="images/products/products-category.png" alt="products category" width="180"/></a>
                            </div>
                            <div class="col-xs-5 col-md-3">
                                <a href="products.jsp"><img style="min-width:100px" class="img-responsive" src="images/products/products-all.png" alt="all products" width="180"/></a>
                            </div>
                        </div>

                        <!--CONTENT-->

                        <!--Pagination CODES-->
                        <%
                            String uri2 = request.getRequestURI();
                            String pageName2 = uri2.substring(uri2.lastIndexOf("/") + 1);

                            int pageSize = 10; //limit how many products per page
                            int pageCount;
                            int showPage;

                            ProductDAO dao = new ProductDAO();
                            HomeDAO homeDAO = new HomeDAO();
                            ArrayList<Product> list = homeDAO.getProducts();
                            int recordCount = list.size();
                            pageCount = (recordCount % pageSize == 0) ? (recordCount / pageSize) : (recordCount / pageSize + 1); //calculate how many pages in total, depending on number of products
                            String integer = request.getParameter("showPage");
                            if (integer == null) {
                                integer = "1";
                            }
                            try {
                                showPage = Integer.parseInt(integer);
                            } catch (NumberFormatException e) {
                                showPage = 1; //if products are empty
                            }
                            if (showPage <= 1) {
                                showPage = 1;
                            }
                            if (showPage >= pageCount) {
                                showPage = pageCount;
                            }
                            int position = (showPage - 1) * pageSize + 1; //position is the position of the starting product being displayed
%>
                        <!---displaying result information----->                       
                        <div class="row" style="margin-bottom: 15px">
                            <div class="col-md-3 subheader">
                                Displaying <%=position%>-<%=Math.min(position + 9, recordCount)%> of <%=recordCount%> results
                            </div>
                        </div>
                        <%
                            if (list != null && list.size() != 0) {
                                for (int i = position - 1; i <= position - 1 + pageSize; i++) {
                                    if(i<list.size()){
                                    Product p = list.get(i);

                                    String country = dao.retrieveCountries(p.getCountry_origin());
                                    String packaging = dao.retrievePackaging(p.getPacking_details());

                                    String appearance = "";
                                    if (p.getPhysical_appear() == null || p.getPhysical_appear().isEmpty()) {
                                        appearance = "none";
                                    } else {
                                        appearance = dao.getPhysicalAppearance(Integer.parseInt(p.getPhysical_appear()));

                                    }
                        %>
                        <!--Pagination Codes ENDS-->


                        <hr>
                        <div class="row">
                            <div class="col-sm-7 col-md-6 col-md-offset-1">

                                <div class="row" style="margin-bottom:10px">
                                    <!--------Product Image--------->
                                    <div class="col-xs-4 col-md-4">
                                        <img src="images/<%=p.getProduct_dir()%>/<%=p.getThumb_image()%>" style="max-width: 130px;min-width: 81px;width:100%;height:100%;" class="img-rounded" width="100" height="100" alt="<%=p.getProduct_name()%>">

                                    </div>
                                    <!------Product Description--------->
                                    <div class="col-xs-8 col-md-8">
                                        <a style="color: #336688;" href="products.jsp"><span style="display: none;">Link1</span></a>
                                        <!--
                                        <form id="my_form<%=p.getProduct_id()%>" action="product-details.jsp" method="post">
                                            <input type="hidden" name="id" value="<%=p.getProduct_id()%>">
                                        </form>        
                                        <b><a href="javascript:{}" onclick="document.getElementById('my_form<%=p.getProduct_id()%>').submit();
                return false;">
                                        <%=p.getProduct_name()%></a></b>-->
                                        <a href="product-details.jsp?id=<%=p.getProduct_id()%>"><%=p.getProduct_name()%></a>

                                        <div class="resizeInfo"> 
                                            <table >
                                                <tr>
                                                    <td><b>Origin:</b></td>
                                                    <td> <%=country%></td>
                                                </tr>
                                                <tr>
                                                    <td><b>Appearance: </b></td>
                                                    <td> <%=appearance%></td>
                                                </tr>
                                                <tr>
                                                    <td><b>CAS No.:</b></td>
                                                    <td> <%=p.getCas_number()%></td>
                                                </tr>
                                                <tr>
                                                    <td><b>Formula:</b></td>
                                                    <td> <%=p.getChemical_formula()%></td>
                                                </tr>
                                            </table>

                                            <!----<br>
                                            <b>Packaging</b>
                                            <b>:</b>
                                            <b><%=packaging%></b>--->
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="col-xs-5 col-md-3">
                                <div class="row">
                                    <!--------MSDS--------->
                                    <div class="col-xs-4">
                                        <center><b>MSDS</b><br>
                                            <img src="images/products/pdf_pl.png" class="img-rounded pdf" onclick="return hs.htmlExpand(this)" onkeypress="return hs.htmlExpand(this)" width="30" alt="msds">

                                            <div class="highslide-maincontent">
                                                <!--Start Form--> 
                                                <form name="downloadA<%=p.getProduct_id()%>" id="downloadA<%=p.getProduct_id()%>" action="download-single" method="post" onsubmit="return checkFiles()">

                                                    <input type="hidden" name="pgnme" value="pageName2">
                                                    <table style="width:100%; taxt-align:left;">
                                                        <tr style="display:none;"><th></th></tr>
                                                        <tbody><tr><td>
                                                                    <table>
                                                                        <tr style=""><th><br></th></tr>
                                                                        <tr><td style="color:#333333; color:#333333; font-family:Oxygen-Bold,Verdana, Arial, Helvetica, sans-serif; font-size:14px; margin-bottom:10px; text-align:center;" colspan="2" >Please fill the form to download TDS/MSDS of our products </td></tr>
                                                                        <tr><td colspan="2"><span style="color:#FF0000;">*</span><span style="font-family:Verdana, Arial, Helvetica, sans-serif;font-size:10px; font-style:italic;"> Fields are Mandatory</span><input name="id" id="idA<%=p.getProduct_id()%>" style="display:none" type="text" value="A<%=p.getProduct_id()%>"></td></tr>
                                                                        <tr><td style="color:#333333; font-family:Oxygen-Bold,Verdana, Arial, Helvetica, sans-serif; font-size:12px;">Name<span style="color:#FF0000">*</span>  :</td><td><input name="name" id="nameA<%=p.getProduct_id()%>" maxlength="150" style="width: 190px;margin-bottom:3px; margin-top: 5px;" type="text" title="Name"></td></tr>
                                                                        <tr><td style="color:#333333; font-family:Oxygen-Bold, Verdana, Arial, Helvetica, sans-serif; font-size:12px;">E-Mail<span style="color:#FF0000">*</span>  :</td><td><input name="email_id" id="email_idA<%=p.getProduct_id()%>" maxlength="250" style="width: 190px; margin-bottom:3px;" type="text" title="Email"></td></tr>
                                                                        <tr><td style="color:#333333; font-family:Oxygen-Bold, Verdana, Arial, Helvetica, sans-serif; font-size:12px;">Phone:</td><td><input id="phoneA<%=p.getProduct_id()%>" name="phone" maxlength="15" style="width: 190px; margin-bottom:3px;" type="text" title="Phone Number"></td></tr>
                                                                        <tr><td style="color:#333333; font-family:Oxygen-Bold,Verdana, Arial, Helvetica, sans-serif; font-size:12px; vertical-align:middle;" >Requirement :</td><td>
                                                                                <label for="requirementA<%=p.getProduct_id()%>" style="display:none;">requirementA<%=p.getProduct_id()%></label>
                                                                                <textarea name="requirement" id="requirementA<%=p.getProduct_id()%>" maxlength="250" style="width: 190px; margin-bottom:3px;" title="Requirement"></textarea></td></tr>
                                                                        <tr><td>&nbsp;</td>
                                                                            <td style="vertical-align:top;">
                                                                                <table>
                                                                                    <tr style="display:none;"><th></th></tr>
                                                                                    <tr><td><img src="images/email_reset.png" onclick="resetDownload('A' +<%=p.getProduct_id()%>);" onkeypress="resetDownload('A' +<%=p.getProduct_id()%>);" style="cursor:pointer" alt="reset" height="26" width="88" tabindex="0"></td>
                                                                                        <td><input name="submit" id="submitA<%=p.getProduct_id()%>" value="Submit" src="images/email_submit.png" type="image" onclick="javascript:submitDownloadForm('A' +<%=p.getProduct_id()%>, this);" onkeypress="javascript:submitDownloadForm('A' +<%=p.getProduct_id()%>, this);" alt="input8"></td></tr></tbody></table>
                                                                            </td></tr></tbody></table>

                                                    </td></tr>
                                                    </tbody></table>
                                                </form>
                                                <!--End Form-->
                                            </div> 
                                        </center>
                                    </div>
                                    <!--------TDS--------->
                                    <div class="col-xs-4">
                                        <center><b>TDS</b><br>
                                            <img src="images/products/pdf_pl.png" class="img-rounded pdf" onclick="return hs.htmlExpand(this)" onkeypress="return hs.htmlExpand(this)" width="30" alt="tds">

                                            <div class="highslide-maincontent">

                                                <!--Start Form-->
                                                <form name="downloadB<%=p.getProduct_id()%>" id="downloadB<%=p.getProduct_id()%>" action="download-single" method="post" onsubmit="return checkFiles()">
                                                    <input type="hidden" name="pgnme" value="pageName2">
                                                    <table style="width:100%; taxt-align:left;">
                                                        <tr style="display:none;"><th></th></tr>
                                                        <tbody><tr><td>
                                                                    <table>
                                                                        <tr style=""><th><br></th></tr>
                                                                        <tr><td style="color:#333333; color:#333333; font-family:Oxygen-Bold,Verdana, Arial, Helvetica, sans-serif; font-size:14px; margin-bottom:10px; text-align:center;" colspan="2" >Please fill the form to download TDS/MSDS of our products </td></tr>
                                                                        <tr><td colspan="2"><span style="color:#FF0000;">*</span><span style="font-family:Verdana, Arial, Helvetica, sans-serif;font-size:10px; font-style:italic;"> Fields are Mandatory</span><input name="id" id="idB<%=p.getProduct_id()%>" style="display:none" type="text" value="B<%=p.getProduct_id()%>"></td></tr>
                                                                        <tr><td style="color:#333333; font-family:Oxygen-Bold,Verdana, Arial, Helvetica, sans-serif; font-size:12px;">Name<span style="color:#FF0000">*</span>  :</td><td><input name="name" id="nameB<%=p.getProduct_id()%>" maxlength="150" style="width: 190px;margin-bottom:3px; margin-top: 5px;" type="text" title="Name"></td></tr>
                                                                        <tr><td style="color:#333333; font-family:Oxygen-Bold, Verdana, Arial, Helvetica, sans-serif; font-size:12px;">E-Mail<span style="color:#FF0000">*</span>  :</td><td><input name="email_id" id="email_idB<%=p.getProduct_id()%>" maxlength="250" style="width: 190px; margin-bottom:3px;" type="text" title="Email"></td></tr>
                                                                        <tr><td style="color:#333333; font-family:Oxygen-Bold, Verdana, Arial, Helvetica, sans-serif; font-size:12px;">Phone:</td><td><input id="phoneB<%=p.getProduct_id()%>" name="phone" maxlength="15" style="width: 190px; margin-bottom:3px;" type="text" title="Phone Number"></td></tr>
                                                                        <tr><td style="color:#333333; font-family:Oxygen-Bold,Verdana, Arial, Helvetica, sans-serif; font-size:12px; vertical-align:middle;" >Requirement :</td><td>
                                                                                <label for="requirementB<%=p.getProduct_id()%>" style="display:none;">requirementB<%=p.getProduct_id()%></label>
                                                                                <textarea name="requirement" id="requirementB<%=p.getProduct_id()%>" maxlength="250" style="width: 190px; margin-bottom:3px;" title="Requirement"></textarea></td></tr>
                                                                        <tr><td>&nbsp;</td>
                                                                            <td style="vertical-align:top;">
                                                                                <table>
                                                                                    <tr style="display:none;"><th></th></tr>
                                                                                    <tr><td><img src="images/email_reset.png" onclick="resetDownload('B' +<%=p.getProduct_id()%>);" onkeypress="resetDownload('B' +<%=p.getProduct_id()%>);" style="cursor:pointer" alt="reset" height="26" width="88" tabindex="0"></td>
                                                                                        <td><input name="submit" id="submitB<%=p.getProduct_id()%>" value="Submit" src="images/email_submit.png" type="image" onclick="javascript:submitDownloadForm('B' +<%=p.getProduct_id()%>, this);" onkeypress="javascript:submitDownloadForm('B' +<%=p.getProduct_id()%>, this);" alt="input8"></td></tr></tbody></table>
                                                                            </td></tr></tbody></table>

                                                    </td></tr>
                                                    </tbody></table>
                                                </form>
                                                <!--End Form-->
                                            </div>
                                        </center>
                                    </div>
                                    <!----mail----->
                                    <div class="col-xs-4" style="  margin-top: -9px;">
                                        <center><br>
                                            <img src="images/products/mail_pl.png" title="quick enquiry" class="img-rounded pdf" onclick="return hs.htmlExpand(this)" onkeypress="return hs.htmlExpand(this)" width="40" alt="tds">

                                            <div class="highslide-maincontent">

                                                <!--Start Form-->
                                                <form name="downloadC<%=p.getProduct_id()%>" id="downloadC<%=p.getProduct_id()%>" action="download-single" method="post" onsubmit="return checkFiles()">
                                                    <input type="hidden" name="pgnme" value="pageName2">
                                                    <table style="width:100%; taxt-align:left;">
                                                        <tr style="display:none;"><th></th></tr>
                                                        <tbody><tr><td>
                                                                    <table>
                                                                        <tr style=""><th><br></th></tr>
                                                                        <tr><td style="color:#333333; color:#333333; font-family:Oxygen-Bold,Verdana, Arial, Helvetica, sans-serif; font-size:14px; margin-bottom:10px; text-align:center;" colspan="2" >Please fill in this form for any enquiries on our products. </td></tr>
                                                                        <tr><td colspan="2"><span style="color:#FF0000;">*</span><span style="font-family:Verdana, Arial, Helvetica, sans-serif;font-size:10px; font-style:italic;"> Fields are Mandatory</span><input name="id" id="idC<%=p.getProduct_id()%>" style="display:none" type="text" value="C<%=p.getProduct_id()%>"></td></tr>
                                                                        <tr><td style="color:#333333; font-family:Oxygen-Bold,Verdana, Arial, Helvetica, sans-serif; font-size:12px;">Name<span style="color:#FF0000">*</span>  :</td><td><input name="name" id="nameC<%=p.getProduct_id()%>" maxlength="150" style="width: 190px;margin-bottom:3px; margin-top: 5px;" type="text" title="Name"></td></tr>
                                                                        <tr><td style="color:#333333; font-family:Oxygen-Bold, Verdana, Arial, Helvetica, sans-serif; font-size:12px;">E-Mail<span style="color:#FF0000">*</span>  :</td><td><input name="email_id" id="email_idC<%=p.getProduct_id()%>" maxlength="250" style="width: 190px; margin-bottom:3px;" type="text" title="Email"></td></tr>
                                                                        <tr><td style="color:#333333; font-family:Oxygen-Bold, Verdana, Arial, Helvetica, sans-serif; font-size:12px;">Phone:</td><td><input id="phoneC<%=p.getProduct_id()%>" name="phone" maxlength="15" style="width: 190px; margin-bottom:3px;" type="text" title="Phone Number"></td></tr>
                                                                        <tr><td style="color:#333333; font-family:Oxygen-Bold,Verdana, Arial, Helvetica, sans-serif; font-size:12px; vertical-align:middle;" >Requirement :</td><td>
                                                                                <label for="requirementC<%=p.getProduct_id()%>" style="display:none;">requirementB<%=p.getProduct_id()%></label>
                                                                                <textarea name="requirement" id="requirementB<%=p.getProduct_id()%>" maxlength="250" style="width: 190px; margin-bottom:3px;" title="Requirement"></textarea></td></tr>
                                                                        <tr><td>&nbsp;</td>
                                                                            <td style="vertical-align:top;">
                                                                                <table>
                                                                                    <tr style="display:none;"><th></th></tr>
                                                                                    <tr><td><img src="images/email_reset.png" onclick="resetDownload('C' +<%=p.getProduct_id()%>);" onkeypress="resetDownload('C' +<%=p.getProduct_id()%>);" style="cursor:pointer" alt="reset" height="26" width="88" tabindex="0"></td>
                                                                                        <td><input name="submit" id="submitC<%=p.getProduct_id()%>" value="Submit" src="images/email_submit.png" type="image" onclick="javascript:submitDownloadForm('C' +<%=p.getProduct_id()%>, this);" onkeypress="javascript:submitDownloadForm('C' +<%=p.getProduct_id()%>, this);" alt="input8"></td></tr></tbody></table>
                                                                            </td></tr></tbody></table>
                                                    </td></tr>
                                                    </tbody></table>
                                                </form>
                                                <!--End Form-->
                                            </div>
                                        </center>
                                    </div>
                                    <!--END OF MAIL-->                                   
                                </div>
                            </div>


                            <%
                                boolean exist = false;
                                for (Product prdct : cartList) {
                                    if (prdct.getProduct_id() == p.getProduct_id()) {
                                        exist = true;
                                    }
                                }
                                if (!exist) {
                            %>
                            <!-----add to cart button----->
                            <div class="col-xs-4 col-md-2" style="  margin-top: -15px;"><br>
                                <a href="addTocart?pID=<%=p.getProduct_id()%>&pgName=<%=pageName2%>">
                                    <img src="images/products/add-to-cart.png" title="add to cart" style="height:50px" alt="cart">
                                </a>

                            </div>
                            <%

                                }
                            %>

                        </div>
                        <%
                                }
                            }
                            }
                        %>
                        <!--Pagination Codes-->
                        <div class="row">
                                    <div class="col-md-12" >
                                        <center>
                                            <div class="pagerClass">
                                                <ul id="yw1" class="pagination">
                                                    <% if (showPage > 1) {%><li ><a href="products-top.jsp?showPage=<%=showPage - 1%>">< Previous</a></li>
                                                        <%             }
                                                            if (showPage > 3) {
                                                        %>

                                                    <%
                                                        }
                                                        for (int i = 1; i <= pageCount; i++) {
                                                            if (showPage == i) {
                                                    %>
                                                    <li  class="active"><a href="products-top.jsp?showPage=<%=i%>"><%=i%></a></li>
                                                        <% } else {
                                                            if (i < showPage + 3 && i > showPage - 3) {
                                                        %>
                                                    <li><a href="products-top.jsp?showPage=<%=i%>"><%=i%></a></li>
                                                        <% }
                                                                }
                                                            }
                                                            if (showPage < pageCount) {
                                                        %>

                                                    <li ><a href="products-top.jsp?showPage=<%=showPage + 1%>">Next ></a></li>
                                                        <%
                                                            }
                                                        %>
                                                </ul>
                                            </div> 
                                        </center>
                                    </div>
                                </div> 
                        <!--Pagination Codes ENDS-->

                    </div>

                    <!-- Footer Codes -->
                    <%@include file="include/footer.jsp"%>
                </div>
            </div>
        </div>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="js/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.js"></script>
        <script src="js/tradeasia.js"></script>

        <%             if (request.getAttribute("message") != null) {
        %>
        <script>   alert("<%=request.getAttribute("message")%>");</script>
        <%
            }
        %>
    </body>
</html>