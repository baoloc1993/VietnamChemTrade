<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file = "../setting.jsp" %>
<link href="css/blog.css" rel="stylesheet">



    <body>
        
        <div class="container">
            <!---to wrap around all body content--->
            <div class="row">
                <!----center content--->
                <div class="col-md-12 centerRow">
                   
                    <!---add the header and navbar---->
                    <%@include file = "../header_nav.jsp" %>
                    <c:forEach items  = "${commentWrappers }" var = "commentWrapper">
                    <div class="comment" >
                        <table style="width:100%">
                           
                            <tr><td>
                                    <div class="comment-date">
                                    ${commentWrapper.comment.fname }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${commentWrapper.comment.datetime }
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    
                                    <c:forEach items = "${commentWrapper.replies }" var = "reply">
                                    <div class="quote" style="margin-left:3%">
                                        <div class="comment-reply-to">
                                            ${reply.comment } &nbsp;&nbsp;&nbsp;&nbsp;${reply.datetime }
                                        </div>
                                        <br>
                                        <div class="quote1">${reply.comment }</div>
                                        <div class="quote2"></div>
                                    </div>
                                    </c:forEach>
                                 
                                </td>
                            </tr>
                            <tr><td>
                                    <div class="comment-body"><p>${commentWrapper.comment.comment }</p></div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <button class="comment-reply-to button" style="margin-left: 3%;text-align:left" onclick="return hs.htmlExpand(this)" onkeypress="return hs.htmlExpand(this)">Reply to <em>${commentWrapper.comment.fname }</em></button>
                                    <div class="highslide-maincontent">
                                        <!--Start Form--> 
                                        <form name="commentform${commentWrapper.comment.id }" id="commentform" action="comment-sumbit" method="post">

                                            <input type="hidden" name="pgnme" value="${commentWrapper.comment.id }">
                                            <table style="width:100%; taxt-align:left;">
                                                <tr style="display:none;"><th></th></tr>
                                                <tbody><tr><td>
                                                            <table>
                                                                <tr style=""><th><br></th></tr>
                                                                <tr><td style="color:#333333; color:#333333; font-family:Oxygen-Bold,Verdana, Arial, Helvetica, sans-serif; font-size:14px; margin-bottom:10px; text-align:center;" colspan="2" ></td></tr>
                                                                <tr><td colspan="2"><span style="color:#FF0000;">*</span><span style="font-family:Verdana, Arial, Helvetica, sans-serif;font-size:10px; font-style:italic;"> Fields are Mandatory</span><input name="id" id="id" style="display:none" type="text" value=""></td></tr>
                                                                <tr><td style="color:#333333; font-family:Oxygen-Bold,Verdana, Arial, Helvetica, sans-serif; font-size:12px;">First Name<span style="color:#FF0000">*</span>  :</td><td><input name="fname" id="fname" maxlength="150" style="width: 190px;margin-bottom:3px; margin-top: 5px;" type="text" title="First Name"></td></tr>
                                                                <tr><td style="color:#333333; font-family:Oxygen-Bold, Verdana, Arial, Helvetica, sans-serif; font-size:12px;">Last Name<span style="color:#FF0000">*</span>  :</td><td><input name="lname" id="lname" maxlength="250" style="width: 190px; margin-bottom:3px;" type="text" title="Last Name"></td></tr>
                                                                <tr><td style="color:#333333; font-family:Oxygen-Bold, Verdana, Arial, Helvetica, sans-serif; font-size:12px;">Email</td><td><input id="email" name="email" maxlength="15" style="width: 190px; margin-bottom:3px;" type="text" title="Email"></td></tr>
                                                                <tr><td style="color:#333333; font-family:Oxygen-Bold, Verdana, Arial, Helvetica, sans-serif; font-size:12px;">Website</td><td><input id="website" name="website" maxlength="15" style="width: 190px; margin-bottom:3px;" type="text" title="Website"></td></tr>
                                                                <tr><td style="color:#333333; font-family:Oxygen-Bold,Verdana, Arial, Helvetica, sans-serif; font-size:12px; vertical-align:middle;" >Comment:</td><td>
                                                                        <label for="comment" style="display:none;">comment${commentWrapper.comment.id }}</label>
                                                                        <textarea name="comment" id="comment" maxlength="250" style="width: 190px; margin-bottom:3px;" title="Comment"></textarea></td></tr>
                                                                <tr><td>&nbsp;</td>
                                                                    <td style="vertical-align:top;">
                                                                        <table>
                                                                            <tr style="display:none;"><th></th></tr>
                                                                            <tr><td><input name="submit" id="submit" value="Submit Comment" type="submit"></td></tr></tbody></table>
                                                                    </td></tr></tbody></table>

                                            </td></tr>
                                            </tbody></table>
                                        </form>
                                        <!--End Form-->
                                    </div>
                                </td>
                            </tr>
                            <tr><td>
                                    <%@ include file = "../footer.jsp" %>
                                </td>
                            </tr>
                        </table>
                    </div>
                    </c:forEach>

                </div>
            </div>
        </div>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="js/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.js"></script>
        <script src="js/tradeasia.js"></script>
    </body>
</html>