<%-- 
    Document   : searchbar
    Created on : May 20, 2015, 10:33:08 AM
    Author     : Qianpin
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
    .advance-search-btn {
    	background-color: #7E9234;
        height: 29px;
        margin-bottom:10px;
        border: 1px #327f75 solid;
        text-align: center;
        font-family: Oxygen-Bold, Verdana, Geneva, sans-serif;
        font-size: 80%;
        color: #ffffff;
    }
</style>
<script type="text/javascript">
    hs.graphicsDir = 'http://highslide.com/highslide/graphics/';
    hs.outlineType = 'rounded-white';
    hs.wrapperClassName = 'draggable-header';
</script>


<!--Search Bar Codes--->
<!-- Search Field-->
<div class="container-fluid" >
    <div class="row" style="margin-top: -42px;">

        <div class="col-md-12 col-xs-12" style="  padding-left: 2px; padding-right: 1px;" >
            <br>
            <form name="form1" id="form1" method="get" action="search">

                <%@ include file="autocomplete.jsp"%>
            </form>
            
            <!-- Advanced Search Button -->                   
            <input type="button" class="advance-search-btn col-md-2 col-xs-5" value="Advanced Search" onclick="return hs.htmlExpand(this)" title="Advanced Search">                
            <div class="highslide-maincontent" style="display:none; background-color:white;">
                <form name="frm_adv" id="frm_adv" action="search" method="get">
                    <table style="text-align:left; width:100%;">

                        <tr>
                            <td style="text-align:center; width:80;" colspan="3"><strong style="color:#E90000;">Advanced Search</strong></td>
                        </tr>
                        <tr style="height:10px;"><td>&nbsp;</td></tr>
                        <tr>
                            <td style="width:25px;">&nbsp;</td>
                            <td style="text-align:left; width:115px;" class="pop_txt" >Product Name</td>
                            <td><input type="text" name="pname" id="pname" class="textarea" title="Product Name"/></td>
                        </tr>

                        <tr style="height:5px;"><td></td></tr>
                        <tr>
                            <td style="width:10px;">&nbsp;</td>
                            <td style="text-align:left;" class="pop_txt">CAS No.</td>
                            <td><input type="text" name="casname" id="casname" class="textarea" title="CAS No."/></td>
                        </tr>
                        <tr style="height:2px;"><td></td></tr>
                        <tr>
                            <td style="width:10px;">&nbsp;</td>
                            <td style="text-align:left;" class="pop_txt">HS Code</td>
                            <td><input type="text" name="hscode" id="hscode" class="textarea" title="HS Code"/></td>
                        </tr>
                        <tr style="height:5px;"><td></td></tr>
                        <tr>
                            <td style="width:10px;">&nbsp;</td>
                            <td style="text-align:left;" class="pop_txt">Origin</td>
                            <td>
                                <select title="Origin" style="width:135px;" class="textarea" name="adv_cntry" id="adv_cntry">
                                    <option value="">Select</option>
                                    <c:forEach items = "${countryCodes }" var = "countryCode">
                                    	<option value="${countryCode.country}">${countryCode.country}</option>
                                    </c:forEach>
                                    
                                </select>
                            </td>
                        </tr>
                        <tr style="height:5px;"><td></td></tr>
                        <tr>
                            <td style="width:5px;">&nbsp;</td>
                            <td><img src="images/reset_adv.png" style="cursor:pointer;" onClick="document.frm_adv.reset();" onKeypress="document.frm_adv.reset();" tabindex="1" alt="reset" height="34" width="114" /></td>
                            <td  style="text-align:center;">
                                <input type="image" src="images/search_adv.png" name="advsubmit" id="advsubmit" alt="advsubmit" onClick="document.frm_adv.submit();"/>
                            </td>

                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>
</div>