
<%@page import="dao.OrderDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.Country"%>
<%@page import="dao.CountryDAO"%>
<%

    CountryDAO country = new CountryDAO();
    OrderDAO order = new OrderDAO();
    country.databaseRetrieval();
    ArrayList<Country> countryList = country.getTable();
    ArrayList<String> companyTypes = order.getCompanyTypes();
    ArrayList<String> deliveryTerms = order.getDeliveryTerms();
    ArrayList<String> paymentTerms = order.getPaymentTerms();

    String dC = "";
    String dT = "";
    String dD = "";
    String p = "";
    String pT = "";
    String cN = "";
    String add = "";
    String ct = "";
    String cC = "";
    String aC = "";
    String cW = "";
    String cT = "";
    String cCty = "";
    String cS = "";
    String cZ = "";
    String cP = "";
    String cF = "";
    String cFN = "";
    String cCC = "";
    String cM = "";
    String cMN = "";
    String cLN = "";
    String cE = "";
    String cMID = "";
    String com = "";

    dC = (String) request.getAttribute("deliveryCountry");
    if (dC == null) {
        dC = "";
    }
    dT = (String) request.getAttribute("deliveryTerm");
    if (dT == null) {
        dT = "";
    }
    dD = (String) request.getAttribute("deliveryDate");
    if (dD == null) {
        dD = "";
    }
    p = (String) request.getAttribute("port");
    if (p == null) {
        p = "";
    }
    pT = (String) request.getAttribute("paymentTerm");
    if (pT == null) {
        pT = "";
    }
    cN = (String) request.getAttribute("companyName");
    if (cN == null) {
        cN = "";
    }
    add = (String) request.getAttribute("address");
    if (add == null) {
        add = "";
    }
    ct = (String) request.getAttribute("city");
    if (ct == null) {
        ct = "";
    }
    cC = (String) request.getAttribute("callCode");
    if (cC == null) {
        cC = "";
    }
    aC = (String) request.getAttribute("areaCode");
    if (aC == null) {
        aC = "";
    }
    cW = (String) request.getAttribute("CompanyWeb");
    if (cW == null) {
        cW = "";
    }
    cT = (String) request.getAttribute("companyType");
    if (cT == null) {
        cT = "";
    }
    cCty = (String) request.getAttribute("companyCountry");
    if (cCty == null) {
        cCty = "";
    }
    cS = (String) request.getAttribute("companyState");
    if (cS == null) {
        cS = "";
    }
    cZ = (String) request.getAttribute("companyZip");
    if (cZ == null) {
        cZ = "";
    }
    cP = (String) request.getAttribute("companyPhone");
    if (cP == null) {
        cP = "";
    }
    cF = (String) request.getAttribute("companyFax");
    if (cF == null) {
        cF = "";
    }

    cFN = (String) request.getAttribute("contactFName");
    if (cFN == null) {
        cFN = "";
    }
    cCC = (String) request.getAttribute("contactCallCode");
    if (cCC == null) {
        cCC = "";
    }
    cM = (String) request.getAttribute("contactMobile");
    if (cM == null) {
        cM = "";
    }

    cMN = (String) request.getAttribute("contactMName");
    if (cMN == null) {
        cMN = "";
    }
    cLN = (String) request.getAttribute("contactLName");
    if (cLN == null) {
        cLN = "";
    }
    cE = (String) request.getAttribute("contactEmail");
    if (cE == null) {
        cE = "";
    }
    cMID = (String) request.getAttribute("contactMessengerID");
    if (cMID == null) {
        cMID = "";
    }
    com = (String) request.getAttribute("comments");
    if (com == null) {
        com = "";
    }

%>
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
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <link href="css/fonts.css" rel="stylesheet"> 
        <link href="css/datepicker.css" rel="stylesheet"> 
        <link href="css/order.css" rel="stylesheet">
        <script src="js/countries3.js"></script>
        <script type="text/javascript">
            function loadimage() {
                document.getElementById("randImage").src = "include/image.jsp?" + Math.random();
            }
        </script>

    </head>

    <body>
        <div class="container">

            <!---to wrap around all body content--->
            <div class="row">
                <!----center content--->
                <div class="col-md-10 col-md-offset-1 centerRow">

                    <!---add the header and navbar and search bar---->
                    <%@include file="../header_nav.jsp"%>
                    <%@include file="../index/search.jsp"%>

                    <form method="post" action="order">

                        <div class="row" style="margin-left:1%; margin-right: 2%">
                            <div class="col-md-12">
                                <div class="order_header"><%           
                                if (cartList.size() == 0) {
                                    %>
                                    Your cart is currently empty
                                    <%
                                    } else {
                                    %>

                                    You are requesting the following
                                </div>
                            </div>
                        </div>

                        <div class="row cartBox">
                            <div class="col-md-11">


                                <%                                       int num = 0;
                                    for (Product cart : cartList) {
                                        num++;
                                        int productID = cart.getProduct_id();
                                        String productName = cart.getProduct_name();
                                %>
                                <div class="row rowSpc" >
                                    <div class="col-md-12" >
                                        <div class="row">


                                            <div class="col-md-4 col-md-offset-1" style="margin-bottom: 15px;">
                                                <input type="hidden" name="p_ID<%=num%>" value="<%=productID%>"> 
                                                Product #<%=num%>:<br><b style="color: #666666"><%=productName%></b>

                                                <!--origin, appearance, packaging--->

                                            </div>
                                            <div class="col-md-2" >

                                                <div class="form-group">

                                                    Expected Price: <input class="form-control order-form" id="expected" placeholder="USD/Unit" name="expectedPrice<%=num%>" type="text" required>
                                                </div>

                                            </div>
                                            <div class="col-md-2">

                                                <div class="form-group">

                                                    Unit: <select class="form-control" id="unit" name="unit<%=num%>">
                                                        <option value="MT">MT</option>
                                                        <option value="KG">KG</option>
                                                    </select>    

                                                </div>

                                            </div>
                                            <div class="col-md-2 ">
                                                Quantity: <input id="qty" class="form-control order-form" name="expectedQty<%=num%>" placeholder="Expected" type="text" required>

                                            </div>



                                            <div class="col-md-1">

                                                <div class="removeBtn form-group">
                                                    <br>                                                    
                                                    <a href="removeCart?p_ID=<%=productID%>" style="color:white; text-decoration: none"><div class="btn btn-danger">Remove</div></a></div>

                                            </div>
                                        </div>
                                    </div>



                                </div>

                                <%
                                        }
                                    }
                                %>

                            </div>
                        </div>

                        <div class="row" style="margin-left:1%; margin-right: 2%;">

                            <div class="col-md-10 col-md-offset-1">

                                <%                                    if (request.getAttribute("error") != null) {
                                        String msg = (String) request.getAttribute("error");
                                %>

                                <div class="row" style="margin-top: 46px;margin-bottom: -24px;">                                    
                                    <div class="col-md-12"> 
                                        <div class="alert alert-danger">
                                            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                            <strong>Request Failed.</strong> <%=msg%>
                                        </div>
                                    </div>
                                </div>

                                <%
                                } else if (request.getAttribute("success") != null) {
                                %>
                                <div class="row" style="margin-top:15px">                                    
                                    <div class="col-md-12"> 
                                        <div class="alert alert-success">
                                            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                            <strong>Success.</strong> Your request has been received. We will review it shortly.
                                        </div>
                                    </div>
                                </div>
                                <%
                                    }
                                %>


                                <!---delivery information------>
                                <div class="row">
                                    <div class="line" style="margin-top: 20px;"></div>

                                    <div class="col-md-6" style="padding-right: 4%;" >
                                        <div class="form-group">
                                            <label>Delivery Information</label>
                                            <select class="form-control" name="deliveryCountry">
                                                <%
                                                    if (dC.isEmpty()) {
                                                %>
                                                <option value="">Select Country</option>
                                                <%
                                                } else {
                                                %>
                                                <option value="<%=dC%>"><%=dC%></option>
                                                <%
                                                    }
                                                    if (countryList != null && countryList.size() != 0) {
                                                        for (Country c : countryList) {
                                                            String name = c.country;
                                                %>
                                                <option value="<%=name%>"><%=name%></option>
                                                <%

                                                        }
                                                    }
                                                %>


                                            </select>
                                        </div>

                                        <div class="form-group">

                                            <select class="form-control" id="team" name="deliveryTerm">
                                                <%
                                                    if (dT.isEmpty()) {
                                                %>
                                                <option value="">Select Delivery Term</option>
                                                <%
                                                } else {
                                                %>
                                                <option value="<%=dT%>"><%=dT%></option>
                                                <%
                                                    }
                                                    if (deliveryTerms != null && deliveryTerms.size() != 0) {
                                                        for (String name : deliveryTerms) {
                                                %>
                                                <option value="<%=name%>"><%=name%></option>
                                                <%

                                                        }
                                                    }
                                                %>
                                            </select>
                                        </div>


                                        <div class="form-group">
                                            <input class="form-control" type="text" placeholder="Target Delivery Date" value="<%=dD%>"  id="targetDate" name="deliveryDate">
                                        </div>


                                    </div>

                                    <!----second column------>
                                    <div class="col-md-6" style="padding-right: 4%;">
                                        <div class="form-group">
                                            <label><font color="white">n</font></label>
                                            <input type="text" placeholder="Port of Destination" value="<%=p%>" class="form-control" name="port">
                                        </div>

                                        <div class="form-group">

                                            <select class="form-control" name="paymentTerm">
                                                <%
                                                    if (pT.isEmpty()) {
                                                %>
                                                <option value="">Select Payment Term</option>
                                                <%
                                                } else {
                                                %>
                                                <option value="<%=pT%>"><%=pT%></option>
                                                <%
                                                    }
                                                    if (paymentTerms != null && paymentTerms.size() != 0) {
                                                        for (String name : paymentTerms) {
                                                %>
                                                <option value="<%=name%>"><%=name%></option>
                                                <%

                                                        }
                                                    }
                                                %>
                                            </select>
                                        </div>

                                    </div>
                                </div>

                                <!---company information------>
                                <div class="row">
                                    <div class="line"></div>

                                    <div class="col-md-6" style="padding-right: 4%;">
                                        <div class="form-group order-form">
                                            <label>Company Information</label>
                                            <input type="text" placeholder="Company Name*" class="form-control order-form" value="<%=cN%>" name="companyName" required>

                                        </div>

                                        <div class="form-group">
                                            <textarea name="address" placeholder="Address" class="form-control" rows="4" ><%=add%></textarea>
                                        </div>

                                        <div class="form-group">

                                            <input type="text" placeholder="City" class="form-control" value="<%=ct%>" name="city"  >
                                        </div>

                                        <div class="row">
                                            <div class="col-md-5">

                                                <div class="form-group">

                                                   <%
                                                            if (cC.isEmpty()) {
                                                        %>
                                                        <input required type="text" placeholder="Calling Code*" class="form-control order-form" value="" name="callCode">
                                                        <%
                                                        } else {
                                                        %>
                                                        <input required type="text" placeholder="Calling Code*" class="form-control order-form" value="<%=cC%>" name="callCode">
                                                        <%
                                                            }
                                                           
                                                        %>
                                                </div>
                                            </div>
                                            <div class="col-md-7" style="padding-left: 19px;">
                                                <div class="form-group">
                                                    <input type="number" placeholder="Area Code" value="<%=aC%>" class="form-control" name="areaCode"  />
                                                </div>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <input type="text" placeholder="Website" class="form-control" value="<%=cW%>" name="CompanyWeb"  >
                                        </div>

                                    </div>

                                    <!----second column------>
                                    <div class="col-md-6" style="padding-right: 4%;">

                                        <div class="form-group">
                                            <label><font color="white">s</font></label>
                                            <select class="form-control" name="companyType">
                                                <%

                                                    if (cT.isEmpty()) {
                                                %>
                                                <option value="">Type of Company</option>
                                                <%
                                                } else {
                                                %>
                                                <option value="<%=cT%>"><%=cT%></option>
                                                <%
                                                    }
                                                    if (companyTypes != null && companyTypes.size() != 0) {
                                                        for (String name : companyTypes) {
                                                %>
                                                <option value="<%=name%>"><%=name%></option>
                                                <%

                                                        }
                                                    }
                                                %>

                                            </select>
                                        </div>

                                        <div class="form-group">
                                            <select class="form-control" onChange="print_state('state', this.selectedIndex);" id="country" name ="companyCountry" title="Select Country">
                                                <script type="text/javascript">print_country("country");</script>
                                                <%
                                                    if (cCty.isEmpty()) {
                                                %>
                                                <option value="">Select Country</option>
                                                <%
                                                } else {
                                                %>
                                                <option value="<%=cCty%>" selected="selected"><%=cCty%></option>
                                                <%
                                                    }
                                                %>
                                            </select>

                                        </div>

                                        <div class="form-group">

                                            <select class="form-control" title="State" style="height:35px;" name="companyState" id="state">
                                                <option value="" selected="selected" >Select State</option>
                                                <option value="<%=cS%>" ><%=cS%></option>
                                            </select>

                                        </div>

                                        <div class="form-group">
                                            <input type="number" placeholder="Zip / Postal Code" value="<%=cZ%>" class="form-control" name="companyZip"  >
                                        </div>


                                        <div class="row">
                                            <div class="col-md-6">

                                                <div class="form-group">
                                                    <input type="number" placeholder="Phone Number" value="<%=cP%>" class="form-control" name="companyPhone"  >
                                                </div>
                                            </div>
                                            <div class="col-md-6" style="padding-left: 19px;">
                                                <div class="form-group">
                                                    <input type="number" placeholder="Fax Number" value="<%=cF%>" class="form-control" name="companyFax"  >
                                                </div>
                                            </div>
                                        </div>


                                    </div>
                                </div>                                

                                <!---contact information------>
                                <div class="row">
                                    <div class="line"></div>

                                    <div class="col-md-6" style="padding-right: 4%;">

                                        <div class="row"><div class="col-md-12" ><label>Contact Information</label></div></div>

                                        <div class="row">

                                            <div class="col-md-4">
                                                <div class="form-group">                                                    
                                                    <select class="form-control" name="contactSalution">
                                                        <option>Mr</option>
                                                        <option>Mrs</option>
                                                        <option>Ms</option>
                                                        <option>Dr</option>
                                                        <option>Prof</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="col-md-8" style="padding-left: 19px;">
                                                <div class="form-group">
                                                    <input class="form-control order-form" type="text" placeholder="First Name*" value="<%=cFN%>" name="contactFName" required>
                                                </div>
                                            </div>

                                        </div>


                                        <div class="row">
                                            <div class="col-md-4" >

                                                <div class="form-group">
                                                    <%
                                                            if (cC.isEmpty()) {
                                                        %>
                                                        <input required type="text" placeholder="Calling Code*" class="form-control order-form" value="" name="contactCallCode">
                                                        <%
                                                        } else {
                                                        %>
                                                        <input required type="text" placeholder="Calling Code*" class="form-control order-form" value="<%=cC%>" name="contactCallCode">
                                                        <%
                                                            }
                                                           
                                                        %>
                                                </div>
                                            </div>
                                            <div class="col-md-8" style="padding-left: 19px;">
                                                <div class="form-group">
                                                    <input class="form-control order-form" type="number" placeholder="Mobile No.*" value="<%=cM%>" name="contactMobile" required>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <select class="form-control" name="contactMessengerType">
                                                <option>Skype</option>
                                                <option>AOL</option>
                                                <option>GTalk</option>
                                            </select>
                                        </div>


                                    </div>

                                    <!----second column------>
                                    <div class="col-md-6" style="padding-right: 4%;">

                                        <div class="row"><div class="col-md-12"><label><font color="white">Contact</font></label></div></div>


                                        <div class="row">

                                            <div class="col-md-6" style="padding-right: 19px;">
                                                <div class="form-group">
                                                    <input class="form-control" value="<%=cMN%>" type="text" placeholder="Middle Name" name="contactMName">
                                                </div>
                                            </div>
                                            <div class="col-md-6" >
                                                <div class="form-group">
                                                    <input class="form-control order-form" value="<%=cLN%>" type="text" placeholder="Last Name*" name="contactLName" required>
                                                </div>
                                            </div>

                                        </div>

                                        <div class="form-group">
                                            <input class="form-control order-form" value="<%=cE%>" type="email" placeholder="Email ID*" name="contactEmail" required>
                                        </div>

                                        <div class="form-group">
                                            <input class="form-control" type="text" value="<%=cMID%>" placeholder="Messenger ID" name="contactMessengerID">
                                        </div>

                                    </div>
                                </div>

                                <!---Comment Textarea------>
                                <div class="row">

                                    <div class="line"></div>
                                    <div class="col-md-12" style="padding-right: 4%;">                                        
                                        <div class="form-group">                                           
                                            <textarea name="comments" id="comments" class="form-control" placeholder="Comments/Notes" rows="5"><%=com%></textarea>
                                        </div>
                                    </div>

                                </div>

                                <!---Verification Code------>
                                <div class="row">

                                    <div class="line"></div>
                                    <div class="col-md-12">    
                                        <center>
                                            <div class="form-group">
                                                <img alt="code..." name="randImage" id="randImage" src="include/image.jsp" width="20%" height="20%" />
                                                <a href="javascript:loadimage();"><img src="images/body/refresh.png"/></a>
                                            </div>
                                            <div class="form-group">
                                                <input class="form-control order-form"   maxlength="6" style="width:50%" placeholder="Verification Code*" id="verifyCode" title="verifyCode" name="verifyCode" type="text" required /> 
                                            </div>
                                        </center>
                                    </div>
                                </div>

                                <!----button------>
                                <div class="row" style="margin-top:20px">                                    
                                    <div class="col-md-12"> <center>
                                            <div class="form-group">
                                                <button type="submit" class="btn btn-info">Submit</button>
                                                <button type="reset" class="btn btn-danger">Reset</button>
                                            </div>
                                        </center>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </form>

                    <!-- Footer Codes -->
                    <jsp:include page="include/footer.jsp"/>
                </div>
            </div>
        </div>

        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
       
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>                 
       
        <script src="js/bootstrap-datepicker.js"></script>
        <script type="text/javascript">
                                                    // When the document is ready
                                                    $(document).ready(function () {

                                                        $('#targetDate').datepicker({
                                                            format: "yyyy-mm-dd"
                                                        });

                                                    });
        </script>
        <!--tradeasia's scripts --> 
        <script src="js/tradeasia.js"></script>      

    </body>
</html>
