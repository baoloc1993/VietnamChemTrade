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

        <style>
            .products-image{
                max-width:97%; 
                margin-left: 10px;
            }

        </style>
    </head>

    <body>
        <div class="container">

            <!---to wrap around all body content--->
            <div class="row">
                <!----center content--->
                <div class="col-md-10 col-md-offset-1 centerRow">

                    <!---add the header and navbar and search bar---->
                    <%@include file="../header_nav.jsp"%>
                    <br>

                    <!-- Products Banner-->
                    <div class="row">
                        <div class="col-md-12">
                            <img class="products-image" src="images/products/top-products.jpg" alt="products-banner">
                        </div>
                    </div>

                    <!-- The View All and View by Category buttons -->
                    <div style="float: left;">
                        <form action="products.jsp" class="secondary-display">
                            <input type="submit" name="viewall" value="View All Products"/>
                        </form>
                    </div>
                    <div style="float: right;">
                        <form action="products.jsp" class="secondary-display">
                            <input type="submit" name="viewbycategory" value="View by Category"/>
                        </form>
                    </div>
                    <!-- Footer Codes -->
                    <%@include file="../footer.jsp"%>
                </div>
            </div>
        </div>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.js"></script>

      

    </body>
</html>
