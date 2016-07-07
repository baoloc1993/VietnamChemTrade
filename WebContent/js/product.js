
/**
 * Store function to handle the product
 * 1. Popup form
 * 2. submit form
 * 3. reset form
 * 4. goto product detail
 * 
 */
	        hs.graphicsDir = 'http://highslide.com/highslide/graphics/';
	        hs.outlineType = 'rounded-white';
	        hs.wrapperClassName = 'draggable-header';
	        
        	//Control addToCart request
        	function addToCart(id){
        		
        		var data = {
                        pid :id,
                       // files: files.join(","),
                        
                };
        		
        		$.ajax({
                    type: "POST",
                    url: "addToCart",
                    data: data,
                    success: function () {
                 	   alert("Thêm giỏ hàng thành công");
                    },
                    error: function(xhr, textStatus, errorThrown){
                    	
                    	alert("Bạn đã thêm sản phẩm này vào giỏ hàng. Hoặc có lỗi xảy ra.");
                    	
                    	
                     }
                });
        	}
        	
        	function resetDownload(fileType, id){
        		document.getElementById('name'+fileType+id).value = "";
                document.getElementById('email_id'+fileType+id).value = "";
                document.getElementById('phone'+fileType+id).value = "";
                document.getElementById('requirement'+fileType+id).value = "";
        	}
        	function submitDownloadForm(fileType,id,productName ,element){
        		
        		var name = document.getElementById('name'+fileType+id).value.trim();
                var email_id = document.getElementById('email_id'+fileType+id).value.trim();
                var phone = document.getElementById('phone'+fileType+id).value.trim();
                var requirement = document.getElementById('requirement'+fileType+id).value.trim();
                var atpos = email_id.indexOf("@");
                var dotpos = email_id.lastIndexOf(".");
                if(name == ""){
					alert('Vui lòng nhập tên của bạn');
					document.getElementById('name'+id).focus();
					return false;
		 		}
		
				if(email_id == ""){
					alert('Vui lòng nhập email của bạn');
					document.getElementById('email_id'+id).focus();
					return false;
				}
               	if (atpos< 1 || dotpos<atpos+2 || ((dotpos+2) >= (email_id.length))) {
                        alert("Vui lòng nhập đúng email");
                        return false;
               	}
		        hs.close(element);
		        
		        //Send request
		        var data = {
                        name: name,
                        email: email_id,
                        phone: phone,
                        requirement: requirement,
                        productID: id,
                        productName : productName,
                        fileType: fileType,
                       // files: files.join(","),
                        
                };
                
		        $.ajax({
                    type: "POST",
                    url: "quickContact",
                    data: data,
                    success: function (xhr) {
                    	window.location.href = xhr;
                    },
                    error: function(xhr, textStatus, errorThrown){
                        alert("Có lỗi xảy ra. xin vui lòng thử lại");
                     }
                });
        	}
        	 function go_to_product_detail(id){
             	//Send request
     	        var data = {
                         id: id
                        // files: files.join(","),
                         
                 };
                 
     	        $.ajax({
                     type: "GET",
                     url: "productDetail",
                     data: data,
                     success: function () {
                         //location.reload();
                     },
                     error: function(xhr, textStatus, errorThrown){
                     	window.location.href = "index";
                      }
                 });
             }