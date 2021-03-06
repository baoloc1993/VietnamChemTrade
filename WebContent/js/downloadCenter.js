        
$(function () {
                $("#accordion #yw0 .items").accordion({
                    active: false,
                    collapsible: true,
                    heightStyle: "content"
                })
            });

var downloadIds = {};
hs.graphicsDir = 'http://highslide.com/highslide/graphics/';
hs.outlineType = 'rounded-white';
hs.wrapperClassName = 'draggable-header';


            //checked = false;
            function checkedAll(checked) {
                var aa = document.getElementById('zips');
                
                for (var i = 0; i < aa.elements.length; i++)
                {
                    aa.elements[i].checked = checked;
                }
            }

            /**
             * record which checkbox is checked
             * @param id
             * @param element
             * @returns {Boolean}
             */
            
            function markDownload(id, checked2) {
                        if (downloadIds === undefined){
                                    downloadIds = {};
                        }
            	//alert(downloadIds);
                downloadIds[id] = checked2;
            }
            /**
             * Submit form
             * @param id
             * @param element
             * @returns {Boolean}
             */
            function submitDownloadForm(id, element)
            {
                var name = document.getElementById('name' + id).value.trim();
                var email = document.getElementById('email_id' + id).value.trim();
                var phone = document.getElementById('phone' + id).value.trim();
                var rec = document.getElementById('requirement' + id).value.trim();
                //var files = document.getElementsByName('files[]');
                if (downloadIds === undefined){
                    alert ("Vui lòng chọn ít nhất 1 tệp");
                    return false;
                }
                var files = Object.keys(downloadIds).filter(function (id) {
                    return downloadIds[id];
                });
                
                var atpos = email.indexOf("@");
                var dotpos = email.lastIndexOf(".");
                //var flag = 0;
                var filescount = 40;
                if (name == "") {
                    alert('Vui lòng nhập tên của bạn');
                    document.getElementById('name' + id).focus();
                    return false;
                }
                if (email == "") {
                    alert('Vui lòng nhập đúng email');
                    document.getElementById('email_id' + id).focus();
                    return false;
                }
                if (atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= email.length) {
                    alert("Vui lòng nhập đúng email");
                    return false;
                }

                if (files.length === 0) {
                    alert("Vui lòng chọn ít nhất 1 tệp");
                    return;
                }

                
//                
                var data = {
                        name: name,
                        email: email,
                        files: files.join(","),
                        
                };
                //alert(data.files);
                $.ajax({
                    type: "POST",
                    url: "downloadCenter",
                    data: data,
                    success: function (xhr) {
                    	alert("Cám ơn bạn đã quan tâm đến sản phẩm của chúng tôi.");
                    	resetDownload(id,element);
                    	window.location.href = xhr;                    
                    },
                    
                }).fail(function(){
                	alert("Có lỗi xảy ra. xin vui lòng thử lại "); 
                	return false;
                });
                //return false;
                //alert("Thank you for showing interest in our products ");

            }

            function resetDownload(id,element)
            {
                document.getElementById('name' + id).value = "";
                document.getElementById('email_id' + id).value = "";
                document.getElementById('phone' + id).value = "";
                document.getElementById('requirement' + id).value = "";
                document.getElementById('name' + id).focus();
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
