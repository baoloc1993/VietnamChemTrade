
<!-- Popover 2 hidden content -->
<div id="cartContent" style="display: none">

    <div class="row cartCntnt" style="border-bottom: #DEDEDE solid thin; margin-bottom: 10px">
        <div class="col-xs-9 col-md-9">${cartMessage }</div>

    </div>
    <!---start of cart list---->
    <div class="row cartCntnt">

	<c:forEach items = "${carts}" var = "cart">
        <div class="col-xs-9 col-md-9">
            <div class="row">
                <div class="col-md-12">
                    <a href="productDetail?id=${cart.productId}">${cart.productName }</a>
                    	<p>Appearance: ${cart.physicalAppear}
                    
                </div>

            </div>
        </div>
        <div class="col-xs-3 col-md-3" style="text-align: center">
            <div class="removeBtn form-group">
                <br>                                                    
                <a href="removeCart?pid=${cart.productId}" style="color:#46cfbb;font-size: 9px;">Remove</a>

            </div>
        </div>
	</c:forEach>


    </div>                
</div>
<!-- Popover 2 hidden title -->
<div id="cartTitle" style="display: none">
    <center><a class="cartLink" href="order" style="cursor: pointer"><u>VIEW CART</u> </a>| <a class="cartLink" href="order" style="cursor: pointer"><u>CHECKOUT</u></a></center>
</div> 