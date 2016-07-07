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

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        <style>
            .text-info {
                color: rgb(26, 82, 146);
                font-family: Oxygen-Bold,Roboto-regular,Arial;
                font-size: 150%;
                margin-top: 20px;
            }

            .btn1 {

                background-color: #467b77;;
                border-color: #467b77;;

            }
        </style>

	<%@page contentType="text/html" pageEncoding="UTF-8"%>
    </head>

    <body>
        <div class="container">
            <!---to wrap around all body content--->
            <div class="row">
                <!----center content--->
                <div class="col-md-10 col-md-offset-1 centerRow">

                    <!---add the header and navbar---->
                    <%@include file="../header_nav.jsp"%>
						${message }

                    <br>
                    <!-- Footer Codes -->
                    <%@include file="../footer.jsp"%>
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