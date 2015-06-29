<%-- 
    Document   : searchbar
    Created on : May 20, 2015, 10:33:08 AM
    Author     : Qianpin
--%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>

//Function To Display Popup
function show_advanced_search() {
	document.getElementById('advanced').style.display = "block";
}


function hide_advanced_search() {
	document.getElementById('advanced').style.display = "none";
}
</script>
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
    }
    .advance-search-btn {
        background: url('images/advance-search-bg.jpg') repeat-x;
        height: 29px;
        border: 1px #245089 solid;
        text-align: center;
        font-family: Oxygen-Bold, Verdana, Geneva, sans-serif;
        font-size: 90%;
        color: #ffffff;
    }

    .search-icon {
        background: #fff url('images/search-icon.png') no-repeat 98% center;
    }
    
    @media (max-width: 2000px) {
        #shrink .word {
            display: none;
        }
    }
</style>

	
<!--Search Bar Codes--->
<!-- Search Field-->
<div class="container-fluid">
    <div class="row-fluid">

        <div class="span12" >
        	<div class="highslide-container" style="padding: 0px; display:none; border: none; margin: 0px; position: absolute; left: 0px; top: 0px; width: 100%; z-index: 1001; direction: ltr;" id = "advanced">
        		<div class="highslide-viewport highslide-viewport-size" style="padding: 0px; border: none; margin: 0px; visibility: hidden; display: none;"></div>
        		<table cellspacing="0" style="padding: 0px; border: none; margin: 0px; visibility: visible; position: absolute; border-collapse: collapse; width: 780px; z-index: 1010; left: 501px; top: 64px;">
        			<tbody style="padding: 0px; border: none; margin: 0px;">
        				<tr style="padding: 0px; border: none; margin: 0px; height: auto;">
        					<td style="padding: 0px; border: none; margin: 0px; line-height: 0; font-size: 0px; height: 20px; width: 20px; background: url(http://highslide.com/highslide/graphics/outlines/rounded-white.png) 0px 0px;"></td>
        					<td style="padding: 0px; border: none; margin: 0px; line-height: 0; font-size: 0px; height: 20px; width: 20px; background: url(http://highslide.com/highslide/graphics/outlines/rounded-white.png) 0px -40px;"></td>
        					<td style="padding: 0px; border: none; margin: 0px; line-height: 0; font-size: 0px; height: 20px; width: 20px; background: url(http://highslide.com/highslide/graphics/outlines/rounded-white.png) -20px 0px;"></td>
        				</tr>
        				<tr style="padding: 0px; border: none; margin: 0px; height: auto;">
        					<td style="padding: 0px; border: none; margin: 0px; line-height: 0; font-size: 0px; height: 20px; width: 20px; background: url(http://highslide.com/highslide/graphics/outlines/rounded-white.png) 0px -80px;"></td>
        					<td class="rounded-white highslide-outline" style="padding: 0px; border: none; margin: 0px; position: relative; width: 740px; height: 265px;"></td>
        					<td style="padding: 0px; border: none; margin: 0px; line-height: 0; font-size: 0px; height: 20px; width: 20px; background: url(http://highslide.com/highslide/graphics/outlines/rounded-white.png) -20px -80px;"></td>
        				</tr>
        				<tr style="padding: 0px; border: none; margin: 0px; height: auto;">
        					<td style="padding: 0px; border: none; margin: 0px; line-height: 0; font-size: 0px; height: 20px; width: 20px; background: url(http://highslide.com/highslide/graphics/outlines/rounded-white.png) 0px -20px;"></td>
        					<td style="padding: 0px; border: none; margin: 0px; line-height: 0; font-size: 0px; height: 20px; width: 20px; background: url(http://highslide.com/highslide/graphics/outlines/rounded-white.png) 0px -60px;"></td>
        					<td style="padding: 0px; border: none; margin: 0px; line-height: 0; font-size: 0px; height: 20px; width: 20px; background: url(http://highslide.com/highslide/graphics/outlines/rounded-white.png) -20px -20px;"></td>
        				</tr>
        			</tbody>
        		</table>
        		<div id="highslide-wrapper-0" class="highslide-wrapper draggable-header" style="padding: 0px; border: none; margin: 0px; visibility: visible; position: absolute; z-index: 1011; left: 511px; top: 74px; width: 760px; height: 285px;">
        			<div class="highslide-html" style="position: relative; z-index: 3; height: 285px; overflow: hidden; width: 760px; left: 0px; top: 0px; visibility: visible; cursor: default;">
        				<div style="padding: 0px; border: none; margin: 0px; position: relative; width: 760px; left: 0px; top: 0px;">
        					<div class="highslide-html-content" style="position: relative; display: block; direction: ltr; border: none; width: auto; height: auto; visibility: visible;">
        						<div class="highslide-header">
        							<ul>
        								<li class="highslide-previous"><a href="#" title="Previous (arrow left)" onclick="return hs.previous(this)"><span>Previous</span></a></li>
        								<li class="highslide-next"><a href="#" title="Next (arrow right)" onclick="return hs.next(this)"><span>Next</span></a></li>
        								<li class="highslide-move"><a href="#" title="Move" onclick="return false"><span>Move</span></a></li>
        								<li class="highslide-close"><a title="Close (esc)" onclick="hide_advanced_search()">X<span>Close</span></a></li>
        							</ul>
        						</div>
	        					<div style="padding: 0px; border: none; margin: 0px; overflow: auto; width: 749px; height: 259px; position: relative;">
	        						<div class="highslide-body">
	        							<div class="highslide-maincontent" id="hsId0" style="display: block;">
											<!-- Advanced Search Form Start -->
	
							               <form name="frm_adv" id="frm_adv" action="index.php?r=TblProduct" method="post">
							                     <table style="text-align:left; width:100%;">
							                     	<tbody>
								                       <tr>
								                           <td style="text-align:center; width:80;" colspan="3"><strong style="color:#E90000;">Advanced Search</strong></td>
								                       </tr>
							                       <tr style="height:10;"><td>&nbsp;</td></tr>
							                       <tr>
							                           <td style="width:25;">&nbsp;</td>
							                           <td style="text-align:left; width:115;" class="pop_txt">Product Name</td>
							                           <td><input type="text" name="pname" id="pname" class="textarea" title="Product Name"></td>
							                       </tr>
							                       
							                       <tr style="height:5;"><td></td></tr>
							                       <tr>
							                           <td style="width:10;">&nbsp;</td>
							                           <td style="text-align:left;" class="pop_txt">CAS No.</td>
							                           <td><input type="text" name="casname" id="casname" class="textarea" title="CAS No."></td>
							                       </tr>
							                       <tr style="height:2;"><td></td></tr>
							                       <tr>
							                           <td style="width:10;">&nbsp;</td>
							                           <td style="text-align:left;" class="pop_txt">HS Code</td>
							                           <td><input type="text" name="hscode" id="hscode" class="textarea" title="HS Code"></td>
							                       </tr>
							                       <tr style="height:5;"><td></td></tr>
							                       <tr>
							                           <td style="width:10;">&nbsp;</td>
							                           <td style="text-align:left;" class="pop_txt">Origin</td>
							                           <td>
							                               <select title="Origin" style="width:135px;" class="textarea" name="adv_cntry" id="adv_cntry">
																<option value="">Select</option>
																<c:forEach items="${countryCodes}" var="country">
																	<option value= "${country.cCode}"/>${country.country}</option>
																</c:forEach>
																
							
															</select>
							                           </td>
							                       </tr>
							                       <tr style="height:5;"><td></td></tr>
							                       <tr>
							                           <td style="width:5;">&nbsp;</td>
							                           <td><img src="images/reset_adv.png" style="cursor:pointer;" onclick="document.frm_adv.reset();" onkeypress="document.frm_adv.reset();" tabindex="1" alt="reset" height="34" width="114"></td>
							                           <td style="text-align:center;">
							                               <input type="image" src="images/search_adv.png" name="advsubmit" id="advsubmit" alt="advsubmit">
							                           </td>
							                               
							                       </tr>
							                   </tbody></table>
							               </form>
	                    
	                        <!-- Advanced Search Form End -->
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
	        <br>
	        <!--Search input-->
	        <form name="form1" id="form1" method="post" action="search">
	            <span role="status" aria-live="polite" class="ui-helper-hidden-accessible word"/>
	
	            <input type="text" class="search-field ui-autocomplete-input search-icon span10" placeholder="Search by Name,CAS No,HS code,Origin" name="keyword" id="keyword" title="keyword" autocomplete="off">
	            <input type="button" class="advance-search-btn span2" value="Advanced Search" onclick="show_advanced_search()" title="Advanced Search">                
	        </form>
	        <br>
		</div>
    </div>
</div>



