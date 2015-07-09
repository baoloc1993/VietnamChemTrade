<%-- 
    Document   : downloadCenter
    Created on : 2015-6-4, 14:43:16
    Author     : Fla
--%>

<%@ include file = "setting.jsp" %>

    <style>
        .text_block {
            border: 1px solid #632D7A;
            border-radius: 4px;
            color: #000000;
            font-family: Verdana, Arial, Helvetica, sans - serif;
            font-size: 12px;
            font-style: italic;
            height: 15px;
            line-height: 17px;
            margin-bottom: 11px;
            margin-right: 10px;
            outline: 0 none;
            padding: 10px 3px;
            position: relative;
            width: 300px;
        }
        .cont_name {
            color: #333333;
            font-family: Verdana,Arial,Helvetica,sans-serif;
            font-size: 13px;
            font-weight: bold;
            padding-left: 10px;
        }

        .cont_addr {
            color: #333333;
            font-family: Verdana,Arial,Helvetica,sans-serif;
            font-size: 11px;
            padding-left: 10px;
        }

        .cont_name {
            color: #333333;
            font-family: Verdana,Arial,Helvetica,sans-serif;
            font-size: 13px;
            font-weight: bold;
            padding-left: 10px;
        }
        .cont_addr {
            color: #333333;
            font-family: Verdana,Arial,Helvetica,sans-serif;
            font-size: 11px;
            padding-left: 10px;
        }

        .contentnavi {
            color: #333;
            cursor: pointer;
            /*float: left;*/
            font-size: 10px;
            line-height: 16px;
            text-align: left;
            text-decoration: underline;
        }
    </style>
	<script src="js/downloadCenter.js"></script>
    

    <body>
        
        <div class="container">
            <!---to wrap around all body content--->
            <div class="row">
                <!----center content--->
                <div class="col-md-12 centerRow">

                    <!---add the header and navbar and search bar---->
                    <%@include file="header_nav.jsp"%>
                    <!---main part--->
                    <div class="row">
                        <div id="page1" class="col-md-12 col-xs-12 col-xd-12">
                            <table style="width:100%;padding-left:10px; margin-top:10px; word-wrap: break-word; table-layout: fixed;">
                                <tr style="display:none;"><th></th></tr>
                                <tr>
                                    <td colspan="3">
                                        <form name="form1" id="form1" method="post" action="downloadCenter.jsp" autocomplete="on">
                                            <label for="pr_name" style="display:none;">pr-name</label><input type="text" style="width:80%;border: 1px solid #1981b7;height:37px" name="pr_name" id="pr_name" value="" placeholder="Product Name" class="text_block">
                                            <input type="submit" value="Search" name="submit" id="submit" style="vertical-align:top; width:65px;border: 1px solid #1981b7; height:37px;" class="text_block"></form>

                                    </td>
                                    <td colspan="2" rowspan="1">
                                        <img src="images/misc/banner_img-download.png" alt="downloads" style="float:right; margin-bottom: 4%;width:60%;">
                                    </td>
                                </tr>
                            </table>
                            <form name="zips" id="zips" action="downloadCenter" method="post" onsubmit="return checkFiles()">
                                <table style="width:100%;padding-left:10px; margin-top:10px; word-wrap: break-word; table-layout: fixed;">
                                    <tr>
                                        <td style="text-align:right; vertical-align:top;" colspan="3">
                                            <h4 style="color:#000000;font-family:Oxygen-Bold;margin-bottom: 0.25em;font-weight: 600;font-size: 1.5em;">Download TDS/MSDS of our products</h4>
                                        </td>
                                        <td colspan="2">
                                            <span style="float:right;font-family:Oxygen-Bold;font-size:14px;margin:0 20px 0 7px;font-weight:600;">Select All</span>
                                            <label for="check1" style="display:none;">check11</label>
                                            <input type="checkbox" name="checkall" id="check1" style="float:right;margin-top:2.5px; " onclick="checkedAll();">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td style="height:5px;"></td>
                                    </tr>

                                    <tr style="background:#1981b7; color:#FFFFFF;">

                                        <th style="font-weight:bold; font-size:12px; padding-left:10px;font-family:Oxygen-Bold, Arial, Helvetica, sans-serif; height:30;"> Name</th>
                                        <th style="font-weight:bold; padding-left: 17px; font-size:12px; font-family:Oxygen-Bold, Arial, Helvetica, sans-serif">Appearance</th>
                                        <th style="font-weight:bold; padding-left:10px; font-size:12px;font-family:Oxygen-Bold, Arial, Helvetica, sans-serif">Origin</th>
                                        <th style="font-weight:bold; padding-left:0px; font-size:12px;font-family:Oxygen-Bold, Arial, Helvetica, sans-serif">TDS</th>
                                        <th style="font-weight:bold; padding-left:0px; font-size:12px;font-family:Oxygen-Bold, Arial, Helvetica, sans-serif">MSDS</th>
                                    </tr>
                                  
                                    <c:forEach items  ="${downloads}" var = "download">
                                    	
	                                    <tr style="${download.background}" ><!--height="30"-->
	                                        <td class="cont_addr" style="padding:10px;">${download.product.productName}</td>
	                                        <td class="cont_addr" style="padding:10px;">${download.product.physicalAppear }</td>
	
	                                        <td class="cont_addr" style="padding:10px;">${download.product.countryOrigin}</td>
	                                        <td style="text-align:center;">
	
	                                            <div style="width: 10px;">
	                                                <label for="${download.label1}" style="display:none;">${download.number}</label>
	                                                <input type="checkbox" name="files" id="${download.label1}" data-select-all="files_tds" style="" value = "" onclick = "markDownload('${download.product.productDir}/${download.product.specification}', this.checked)"/>
	                                            </div>
	                                        </td>
	                                        <td>
	                                            <div style="width: 10px;">
	                                                <label for="${download.label2 }" style="display:none;">check${download.number }</label>
	                                                <input type="checkbox" name="files" id="${download.label2 }" style="" value = "" onclick = "markDownload('${download.product.productDir}/${download.product.msds}', this.checked)"/>
	                                            </div>
	                                        </td>
	                                    </tr>
                                    </c:forEach>
                                    <!-- Start First Table-->
                                    <tr>
                                        <td colspan="5">
                                            <input name="createpdf" value="Download as ZIP" class="zip-btn" type="button" onclick="return hs.htmlExpand(this)" onkeypress="return hs.htmlExpand(this)" style=" margin-left: 27%;">
                                            <div class="highslide-maincontent">
                                                <!--Start Form-->
                                                <table style="width:100%; taxt-align:left;">
                                                    <tr style="display:none;"><th></th></tr>
                                                    <tbody>
                                                    	<tr>
                                                    		<td>
                                                                <table>
                                                                    <tr style="">
	                                                                    <tr><td style="color:#333333; color:#333333; font-family:Oxygen-Bold,Verdana, Arial, Helvetica, sans-serif; font-size:14px; margin-bottom:10px; text-align:center;" colspan="2" >Please fill the form to download TDS/MSDS of our products </td></tr>
	                                                                    <tr><td colspan="2"><span style="color:#FF0000;">*</span><span style="font-family:Verdana, Arial, Helvetica, sans-serif;font-size:10px; font-style:italic;"> Fields are Mandatory</span></td></tr>
	                                                                    <tr><td style="color:#333333; font-family:Oxygen-Bold,Verdana, Arial, Helvetica, sans-serif; font-size:12px;">Name<span style="color:#FF0000">*</span>  :</td><td><input name="name" id="name40001" maxlength="150" style="width: 190px;margin-bottom:3px; margin-top: 5px;" type="text" title="Name"></td></tr>
	                                                                    <tr><td style="color:#333333; font-family:Oxygen-Bold, Verdana, Arial, Helvetica, sans-serif; font-size:12px;">E-Mail<span style="color:#FF0000">*</span>  :</td><td><input name="email_id" id="email_id40001" maxlength="250" style="width: 190px; margin-bottom:3px;" type="text" title="Email"></td></tr>
	                                                                    <tr><td style="color:#333333; font-family:Oxygen-Bold, Verdana, Arial, Helvetica, sans-serif; font-size:12px;">Phone:</td><td><input id="phone40001" name="phone" maxlength="15" style="width: 190px; margin-bottom:3px;" type="text" title="Phone Number"></td></tr>
	                                                                    <tr>
	                                                                    	<td style="color:#333333; font-family:Oxygen-Bold,Verdana, Arial, Helvetica, sans-serif; font-size:12px; vertical-align:middle;" >Requirement :</td>
	                                                                    	<td>
	                                                                            <label for="requirement40001" style="display:none;">requirement40001</label>
	                                                                            <textarea name="requirement" id="requirement40001" maxlength="250" style="width: 190px; margin-bottom:3px;" title="Requirement"></textarea>
                                                                            </td>
                                                                    	</tr>
                                                                    	<tr>
	                                                                        <td style="vertical-align:top;">
	                                                                            <table>
	                                                                            	<tbody>
		                                                                                <tr style="display:none;"></tr>
		                                                                                <tr>
		                                                                                	<td><img src="images/email_reset.png" onclick="resetDownload(40001);" onkeypress="resetDownload(40001);" style="cursor:pointer" alt="reset" height="26" width="88" tabindex="0"></td>
		                                                                                    <td><input name="submit" id="submit40001" value="Submit" src="images/email_submit.png" type="image" onclick="javascript:submitDownloadForm('40001', this);" onkeypress="javascript:submitDownloadForm('40001', this);" alt="input8"></td>
		                                                                        		</tr>
	                                                                        		</tbody>
	                                                                        	</table>
	                                                                        </td>
	                                                               		</tr>
	                                                               	</tbody>
	                                                    		</table>
                                        					</td>
                                        				</tr>
                                    				</tbody>
                                    			</table>

					                                <!--End Form-->
					                        </div>
                        					<input name="reset" value="Reset" class="zip-btn" type="reset">
                        				</td>
                        			</tr>
                        			<tr>
                        			<td style="height:10px;"></td>
                        		</tr>
                        		${paging }
		                        <!-- End of Download TDS/MSDS Products -->
		            		</table>
		            	</form>
                    
	                </div>
	                <div class="col-xd-12 col-md-12 col-xd-12">
                    	<br>
                	</div>
	                <!-- Footer Codes -->
	                <%@include file="footer.jsp"%>
            	</div>
        	</div>
    	</div>
    </div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.js"></script>
    <script src="js/tradeasia.js"></script>

</body>
</html>