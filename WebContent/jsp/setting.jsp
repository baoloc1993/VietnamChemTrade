<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 
 
<!DOCTYPE html>
<html lang="en">
	
    <head>
    	<base href="${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}/" />
    	
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
        <link href="css/home.css" rel="stylesheet">

        <script type="text/javascript" src="http://highslide.com/highslide/highslide-full.js"></script>
        <script type="text/javascript" src="js/highslide/highslide-with-html.js"></script>
        <script type="text/javascript" src="js/highslide/highslide-with-html1.js"></script>
        <!-- blueprint js framework -->
        <script type="text/javascript" src="js/ajaxtabs/ajaxtabs.js"></script>
                <script type="text/javascript" src="js/countries3.js"></script>
        

        <!-- vediogallarytabs-->
        <link rel="stylesheet" type="text/css" href="js/ajaxtabs/ajaxtabs.css"/>
        <link rel="stylesheet" type="text/css" href="js/highslide/highslide.css" />
        <script type="text/javascript">
            hs.graphicsDir = 'http://highslide.com/highslide/graphics/';
            hs.outlineType = 'rounded-white';
            hs.wrapperClassName = 'draggable-header';
        </script>
        <script type="text/javascript">
            function submitDownloadForm(id, element)
            {
                var name = document.getElementById('name' + id).value.trim();
                var email = document.getElementById('email_id' + id).value.trim();
                var phone = document.getElementById('phone' + id).value.trim();
                var rec = document.getElementById('requirement' + id).value.trim();
                var atpos = email.indexOf("@");
                var dotpos = email.lastIndexOf(".");
                if (name === "") {
                    alert('Enter Your Name for Enquiry!');
                    document.getElementById('name' + id).focus();
                    hs.close(element);
                    return false;
                }
                if (email == "") {
                    alert('Enter Your Mail Id for Enquiry!');
                    document.getElementById('email_id' + id).focus();
                    hs.close(element);
                    return false;
                }
                if (atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= email.length) {
                    alert("Not a valid e-mail address");
                    hs.close(element);
                    return false;
                }
                var form = document.createElement("form");
                form.setAttribute("type", "hidden");
                form.setAttribute("name", "download");
                form.setAttribute("id", "download");
                form.setAttribute("method", "post");
                form.setAttribute("action", "download-single");
                var input = document.createElement("input");
                input2.setAttribute("type", "hidden");
                input2.setAttribute("name", "id");
                input2.setAttribute("value", id);
                var input2 = document.createElement("input");
                input2.setAttribute("type", "hidden");
                input2.setAttribute("name", "name");
                input2.setAttribute("value", name);
                var input3 = document.createElement("input");
                input3.setAttribute("type", "hidden");
                input3.setAttribute("name", "email");
                input3.setAttribute("value", email);
                var input4 = document.createElement("input");
                input4.setAttribute("type", "hidden");
                input4.setAttribute("name", "phone");
                input4.setAttribute("value", phone);
                var input5 = document.createElement("input");
                input5.setAttribute("type", "hidden");
                input5.setAttribute("name", "rec");
                input5.setAttribute("value", rec);
                document.getElementById("download").appendChild(input);
                document.getElementById("download").appendChild(input2);
                document.getElementById("download").appendChild(input3);
                document.getElementById("download").appendChild(input4);
                document.getElementById("download").appendChild(input5);
                document.getElementById("download").submit();

            }

            
            function enquiry_submit_validate(id, element) {
                var frm = document.getElementById('frm' + id);
                var name = document.getElementById('name' + id).value.trim();
                var email_id = document.getElementById('email_id' + id).value.trim();
                var atpos = email_id.indexOf("@");
                var dotpos = email_id.lastIndexOf(".");
                if (name == "") {
                    alert('Enter Your Name for Enquiry!');
                    document.getElementById('name' + id).focus();
                    return false;
                }

                if (email_id == "") {
                    alert('Enter Your Mail Id for Enquiry!');
                    document.getElementById('email_id' + id).focus();
                    return false;
                }
                if (atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= email_id.length) {
                    alert("Not a valid e-mail address");
                    return false;
                }
                hs.close(element);
                return true;
            }


        </script>

        

    </head>