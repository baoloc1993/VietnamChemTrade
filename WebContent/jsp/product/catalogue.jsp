

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file = "../setting.jsp" %>
<title>Catalogue | Chemtradeasia |

Tradeasia International Pte Ltd - Việt Nam</title> 


        <style>
            h1 {
                color: #317e74;
                font-family: Oxygen-Bold,Roboto-regular,Arial;
                font-size: 26px;
                margin-top: 0px;
            }

            h2 {
                color: #317e74;
                font-family: Oxygen-Bold,Roboto-regular,Arial;
                font-size: 21px;
                margin: 0px;
            }
        </style>

    </head>

    <body>
        <div class="container">

            <!---to wrap around all body content--->
            <div class="row">
                <!----center content--->
                <div class="col-md-10 col-md-offset-1 centerRow">
                    <%@include file="../header_nav.jsp"%>
                    <!---add the header and navbar---->

                    <div class="row">
                        <div class="col-md-12">       
                            <div class="container-fluid">

                                <div class="row">
                                    <div class="col-md-12">
                                        <h1>CATALOGUE : Những sản phẩm hóa học hàng đầu</h1>
                                    </div>
                                </div>
                                <hr>


                                <div class="row">


                                    <div class="col-sm-4 col-md-3" style='margin-bottom:20px'>
                                        <div class="row">

                                            <div class="col-md-12">                                              

                                                <img src="http://cdn2.hubspot.net/hub/492768/hubfs/Product_catalogue.png?t=1437464870561&width=202" alt="CoverPage" style="width: 191px;">



                                            </div>
                                        </div>

                                    </div> 


                                    <div class="col-sm-8 col-md-9">
                                        <div class="row">

                                            <div class="col-md-12" style="margin-bottom:20px">
                                                <h2>Giới thiệu</h2>
                                            </div>

                                            <div class="col-md-12" style="margin-bottom:30px;text-align: justify">
                                                Công ty Tradeasia International Pte Ltd của chúng tôi phân phối nhiều mặt hàng hóa chất được sử dụng trong nhiều ngành công nghiệp từ Dệt May, Chất Tẩy Rửa, Hóa Chất từ Cây Cọ, Cây Thông, Giấy, Sơn, vân vân. Quí Khách hàng có thể tải thông tin chi tiết về các sản phẩm hàng đầu của chúng tôi tại đây bằng cách điền thông tin vào đơn yêu cầu. 

                                            </div>

                                            <div class="col-md-12" style="margin-bottom:20px">
                                                <h2>What's inside?</h2>
                                            </div>


                                            <div class="col-md-12">
                                                <div><span style="font-family: 'trebuchet ms', geneva; ">&nbsp; &nbsp; &nbsp;&nbsp;</span><img src="//cdn2.hubspot.net/hubfs/492768/img-thing.jpg?t=1437464870561" alt="img-thing" width="0" style="width: 0px;"><img src="//cdn2.hubspot.net/hub/492768/hubfs/img-thing.jpg?t=1437464870561&amp;width=23" alt="img-thing" width="23" style="font-size: inherit;">
                                                    <span style="font-family: 'trebuchet ms', geneva; ">Thông số vật lý</span></div>
                                                <div><span style="font-family: 'trebuchet ms', geneva;">&nbsp; &nbsp; &nbsp;&nbsp;<img src="//cdn2.hubspot.net/hub/492768/hubfs/img-thing.jpg?t=1437464870561&amp;width=23" alt="img-thing" width="23">Thông số hóa học</span></div>
                                                <div><span style="font-family: 'trebuchet ms', geneva; ">&nbsp; &nbsp; &nbsp;&nbsp;<img src="//cdn2.hubspot.net/hub/492768/hubfs/img-thing.jpg?t=1437464870561&amp;width=23" alt="img-thing" width="23">Số CAS</span></div>
                                                <div><span style="font-family: 'trebuchet ms', geneva; ">&nbsp; &nbsp; &nbsp;&nbsp;<img src="//cdn2.hubspot.net/hub/492768/hubfs/img-thing.jpg?t=1437464870561&amp;width=23" alt="img-thing" width="23">Ứng dụng trong công nghiệp</span></div>
                                            </div>

                                        </div>

                                    </div> 
                                </div>

                            </div>
                        </div>

                    </div>
                    <hr>

                    <div class='row' style='margin-top:25px'>
                        <div class='col-md-12'>
                            <h2>Điền thông tin để tải về</h2>
                        </div>
                    </div>



                    <div class='row' style="margin-top:30px">
                        <form action="catalogue" method="post" name="form">
                            <div class='col-sm-6'>
                                <div class="form-group">
                                    <label for="fname">Họ:</label>
                                    <input type="text" name="first_name" id="fname" class="form-control" required>
                                </div>


                                <div class="form-group">
                                    <label for="email">Email:</label>
                                    <input type="email" id="email" name="emailid" class="form-control" required>
                                </div>     

                                <div class="form-group">
                                    <label for="country">Quốc gia:</label>
                                    <input type="text" id="country" name="country" class="form-control" >
                                </div>

                                <div class="form-group">
                                    <label for="designation">Loại hình:</label>
                                    <select class="form-control" id="designation" name="designation">
                                        <option value="Trader/Supplier">Trader / Supplier</option>
                                        <option value="Manufacturer">Manufacturer</option>
                                        <option value="Agent">Agent</option>
                                        <option value="Others">Others</option>
                                    </select>
                                </div>


                            </div>




                            <div class="col-sm-6">

                                <div class="form-group">
                                    <label for="lname">Tên:</label>
                                    <input type="text" id="lname" name="last_name" class="form-control" required>
                                </div>             

                                <div class="form-group">
                                    <label for="industry">Công ty:</label>
                                    <input type="text" id="industry" name="industry" class="form-control" >
                                </div>




                                <div class="form-group">
                                    <label for="website">Website:</label>
                                    <input type="text" id="website" name="website" class="form-control" >
                                </div>


                                <div style='margin-top:41px'>
                                    <button type="submit" class="btn btn-info btnC">Tải catalogue</button>

                                </div>

                            </div>
                        </form>

                    </div>

                    <div class='row' style='margin-bottom:30px'>
                        
                        <hr>
                    <div class="col-md-12">
                        <center>
                            <div style="margin-top:20px">

                                <span style="font-family: 'trebuchet ms', geneva; font-size:16px; ">Download the Catalogue and learn about the top selling chemicals in the chemical industry.</span>


                                <div><span style="font-family: 'trebuchet ms', geneva;">&nbsp;</span><span style="font-family: 'trebuchet ms', geneva;">Follow us on:&nbsp;<!--HubSpot Call-to-Action Code --> 
                                        <span class="hs-cta-wrapper" id="hs-cta-wrapper-7f8f5de9-279a-4a1d-a5e1-8e4adc25ec9d"> <span class="hs-cta-node hs-cta-7f8f5de9-279a-4a1d-a5e1-8e4adc25ec9d" id="hs-cta-7f8f5de9-279a-4a1d-a5e1-8e4adc25ec9d" style="visibility: visible;"><a id="cta_button_492768_d1937a25-dbff-43dd-804e-7c7b19244e08" class="cta_button" href="//cta-service-cms2.hubspot.com/ctas/v2/public/cs/c/?cta_guid=d1937a25-dbff-43dd-804e-7c7b19244e08&amp;placement_guid=7f8f5de9-279a-4a1d-a5e1-8e4adc25ec9d&amp;portal_id=492768&amp;redirect_url=APefjpG0G3NDNPijD27mVJwuRti3gKXJE_ZlMZ1gOcHWIPMv-nDvEc-CCmSaI_S923TEmnDJP-z4AkxMaEgl_9FvUm2tdhTeH5LxCSYWRV2lFFAx9Fq0kLywwnjCofLgg2GM9uIX8b0lbw6NbqSqhA_0WLSidcatpBa-d4eyvkfaHEzXUAEJ2J_37kpa_uE_1jx-xeA1ce07BztMsdHGRJs1vTyZC-uudNTFvqvnxrVPrUu8ZzEDLIkRxz5099eaUN4ufhtCejXZ_E8TRKLtewIDca5b5aFQJkp_lk-itdDxlidcxXPEoHo6lWjRGNUcfD6ZSHWFwjRr&amp;hsutk=82bfe4e468e0eb2540325de379014c96&amp;utm_referrer=http%3A%2F%2Finfo.chemtradeasia.com%2Fcomplete-array-of-chemicals-catalog&amp;canon=http%3A%2F%2Finfo.chemtradeasia.com%2Fcomplete-array-of-chemicals-catalog&amp;pageId=2984275402" target="_blank" cta_dest_link="https://www.facebook.com/pages/Tradeasia-International-Pte-Ltd/130893963647220"> <img id="hs-cta-img-7f8f5de9-279a-4a1d-a5e1-8e4adc25ec9d" class="hs-cta-img " style="border-width: 0px; " mce_noresize="1" alt="Facebook" src="http://cdn2.hubspot.net/hub/492768/file-2825569176.png"> </a> </span> <script charset="utf-8" src="//js.hscta.net/cta/current.js"></script> <script type="text/javascript">
                                            hbspt.cta.load(492768, '7f8f5de9-279a-4a1d-a5e1-8e4adc25ec9d');
                                            </script> </span> 
                                        <!-- end HubSpot Call-to-Action Code --> <!--HubSpot Call-to-Action Code --> 
                                        <span class="hs-cta-wrapper" id="hs-cta-wrapper-3f0afefe-aa44-4b24-933a-db7027fa8f9d"> <span class="hs-cta-node hs-cta-3f0afefe-aa44-4b24-933a-db7027fa8f9d" id="hs-cta-3f0afefe-aa44-4b24-933a-db7027fa8f9d" style="visibility: visible;"><a id="cta_button_492768_1fc55b83-fc53-4c12-aa1c-3c50d8264864" class="cta_button" href="//cta-service-cms2.hubspot.com/ctas/v2/public/cs/c/?cta_guid=1fc55b83-fc53-4c12-aa1c-3c50d8264864&amp;placement_guid=3f0afefe-aa44-4b24-933a-db7027fa8f9d&amp;portal_id=492768&amp;redirect_url=APefjpHcRcmcLh4JmUQ2qJJfLBJlOVRxiceQKOFqfaMvPAUeobZZU6cV31tkyCzIYGyN2_Kcczth5_wkkuEKhemYrkaDh9mptMXrUWMnFPjFIFDkyg3yqu3dwdzVgqL4z4z6sZr0jNxMmhJDI4TtLB7N2DzAhS5hv2UTqYGn12pRE0ivVRPrAtDKG-mzVnyo33qE_5wggvWGQjy_6jcHeD58XCxO42uxesDLoMZriIT1zoRzOpoiMyVxy6pXsXSx2kb5G6LHGxi4u7p8qTnit6ZBXlSjxMGdEw&amp;hsutk=82bfe4e468e0eb2540325de379014c96&amp;utm_referrer=http%3A%2F%2Finfo.chemtradeasia.com%2Fcomplete-array-of-chemicals-catalog&amp;canon=http%3A%2F%2Finfo.chemtradeasia.com%2Fcomplete-array-of-chemicals-catalog&amp;pageId=2984275402" cta_dest_link="https://twitter.com/tradeasiagroup"> <img id="hs-cta-img-3f0afefe-aa44-4b24-933a-db7027fa8f9d" class="hs-cta-img " style="border-width: 0px; " mce_noresize="1" alt="Twitter" src="http://cdn2.hubspot.net/hub/492768/file-2835185249.png"> </a> </span> <script charset="utf-8" src="//js.hscta.net/cta/current.js"></script> <script type="text/javascript">
                                            hbspt.cta.load(492768, '3f0afefe-aa44-4b24-933a-db7027fa8f9d');
                                            </script> </span> 
                                        <!-- end HubSpot Call-to-Action Code --> <!--HubSpot Call-to-Action Code --> 
                                        <span class="hs-cta-wrapper" id="hs-cta-wrapper-45d0cd20-5192-4f67-96cf-922db3742c6d"> <span class="hs-cta-node hs-cta-45d0cd20-5192-4f67-96cf-922db3742c6d" id="hs-cta-45d0cd20-5192-4f67-96cf-922db3742c6d" style="visibility: visible;"><a id="cta_button_492768_ed31d8f2-a02b-4ffa-b093-e3836274eb69" class="cta_button" href="//cta-service-cms2.hubspot.com/ctas/v2/public/cs/c/?cta_guid=ed31d8f2-a02b-4ffa-b093-e3836274eb69&amp;placement_guid=45d0cd20-5192-4f67-96cf-922db3742c6d&amp;portal_id=492768&amp;redirect_url=APefjpFoPevuld9IiX2Cm07LJYcKP0neuhdlcuKrqB1BLLoSP4U0qcJaGKEtj5CqclrT5DbTTlsJ9z5cVUjZXq6oXDtziRLxVRA4LelF3o2oKH_BS9JNuHADmzm-HKCGZJgc4-RYRlzubiP_b13dXHCDhNTbM6uhZY69_kDmdYdxRlsXtA9-Nu1pboI4K0fc09G_o0uFtXrQvtVNiWm9m2-FwSpFfNhWisP3vj--5V_skrkKPXzXdQOTJKMTgW8ZbY6KJuEfMU5p-vlF9fBsjzjBmC8LFPCYAo3p1PFq-rzR2hXJtg7KqkyXUznurPFCXkQrfhcP84AG&amp;hsutk=82bfe4e468e0eb2540325de379014c96&amp;utm_referrer=http%3A%2F%2Finfo.chemtradeasia.com%2Fcomplete-array-of-chemicals-catalog&amp;canon=http%3A%2F%2Finfo.chemtradeasia.com%2Fcomplete-array-of-chemicals-catalog&amp;pageId=2984275402" cta_dest_link="https://www.linkedin.com/company/tradeasia-international-pte-ltd"> <img id="hs-cta-img-45d0cd20-5192-4f67-96cf-922db3742c6d" class="hs-cta-img " style="border-width: 0px; " mce_noresize="1" alt="New Call-to-action" src="http://cdn2.hubspot.net/hub/492768/file-2832692507.png"> </a> </span> <script charset="utf-8" src="//js.hscta.net/cta/current.js"></script> <script type="text/javascript">
                                            hbspt.cta.load(492768, '45d0cd20-5192-4f67-96cf-922db3742c6d');
                                            </script> </span> 
                                        <!-- end HubSpot Call-to-Action Code --> <!--HubSpot Call-to-Action Code --> 
                                        <span class="hs-cta-wrapper" id="hs-cta-wrapper-0bc5bcb0-b956-4c66-9859-a7df0c95eea8"> <span class="hs-cta-node hs-cta-0bc5bcb0-b956-4c66-9859-a7df0c95eea8" id="hs-cta-0bc5bcb0-b956-4c66-9859-a7df0c95eea8" style="visibility: visible;"><a id="cta_button_492768_66b39c3b-6da9-4af8-9aa1-8aeb8b901b0b" class="cta_button" href="//cta-service-cms2.hubspot.com/ctas/v2/public/cs/c/?cta_guid=66b39c3b-6da9-4af8-9aa1-8aeb8b901b0b&amp;placement_guid=0bc5bcb0-b956-4c66-9859-a7df0c95eea8&amp;portal_id=492768&amp;redirect_url=APefjpH4iX5kNlhvI42FfvQIdZjVend0Tp5A1LK7J1JubLjCXrK31WRvMVnfnEVR17R55U2gn_xZTZ4y0DUSjxTY6Pa1LTYgSvFlG_vZKc-UmJXpQtZER_RH181eFBEQEJ79hRpcrgIOqWHTJ2gibbmI6LiKbXEwrBxw26PMTGsssL6FsokjieYrhN9G7NTl8Bvj80bK8FqNloD36ZUb1S79pcepJPYzBWNFhGsAuqBUcsDEEha_n1yG7cHKePIi1mzQ2PHqxDCZ7GRjrdyGqRVqT3IDSPJUGw&amp;hsutk=82bfe4e468e0eb2540325de379014c96&amp;utm_referrer=http%3A%2F%2Finfo.chemtradeasia.com%2Fcomplete-array-of-chemicals-catalog&amp;canon=http%3A%2F%2Finfo.chemtradeasia.com%2Fcomplete-array-of-chemicals-catalog&amp;pageId=2984275402" cta_dest_link="https://www.pinterest.com/tradeasiaintern/"> <img id="hs-cta-img-0bc5bcb0-b956-4c66-9859-a7df0c95eea8" class="hs-cta-img " style="border-width: 0px; " mce_noresize="1" alt="tradeasiaInternational" src="http://cdn2.hubspot.net/hubfs/492768/hub_generated/resized/33861488-5f92-4754-91ce-ce824dd9ffa1"> </a> </span> <script charset="utf-8" src="//js.hscta.net/cta/current.js"></script> <script type="text/javascript">
                                            hbspt.cta.load(492768, '0bc5bcb0-b956-4c66-9859-a7df0c95eea8');
                                            </script> </span> 
                                        <!-- end HubSpot Call-to-Action Code --> <!--HubSpot Call-to-Action Code --> 
                                        <span class="hs-cta-wrapper" id="hs-cta-wrapper-4639d301-a7fe-4f58-85bc-b2c1ca324df5"> <span class="hs-cta-node hs-cta-4639d301-a7fe-4f58-85bc-b2c1ca324df5" id="hs-cta-4639d301-a7fe-4f58-85bc-b2c1ca324df5" style="visibility: visible;"><a id="cta_button_492768_22a3ef3e-fac9-4ca5-a021-59b0e3073f68" class="cta_button" href="//cta-service-cms2.hubspot.com/ctas/v2/public/cs/c/?cta_guid=22a3ef3e-fac9-4ca5-a021-59b0e3073f68&amp;placement_guid=4639d301-a7fe-4f58-85bc-b2c1ca324df5&amp;portal_id=492768&amp;redirect_url=APefjpG9iFk9KKjQWM2NySKSFMCAB1R-0-EMd-mrjwK0s81-m514VuESWSS3A7l6yC-MEgC26osYO2gXIvPrnmd80IghiCe7nGAbv5kPZXq6O3OItJ5TdvYeFs2mv6IPoMZpHazqG7O9Io66kAiObNSsvZKpnspOJE01FOi4_izOUl0sdvuEt8REU0ilMmewhBUPCXFxuT_FhqjAD8JMxxvH0VUpRHBrf2skvbGutMVW_GLvWAVwNJu0I4Bb444NfHKaeYOlw8eJQxj6vkmmVaSoUAJ7Kmf5jw&amp;hsutk=82bfe4e468e0eb2540325de379014c96&amp;utm_referrer=http%3A%2F%2Finfo.chemtradeasia.com%2Fcomplete-array-of-chemicals-catalog&amp;canon=http%3A%2F%2Finfo.chemtradeasia.com%2Fcomplete-array-of-chemicals-catalog&amp;pageId=2984275402" cta_dest_link="http://www.slideshare.net/chemtradeasia"> <img id="hs-cta-img-4639d301-a7fe-4f58-85bc-b2c1ca324df5" class="hs-cta-img " style="border-width: 0px; " mce_noresize="1" alt="Chemtradeasia" src="http://cdn2.hubspot.net/hubfs/492768/hub_generated/resized/1bbe414f-446c-4c2a-b2a5-856acd454850"> </a> </span> <script charset="utf-8" src="//js.hscta.net/cta/current.js"></script> <script type="text/javascript">
                                            hbspt.cta.load(492768, '4639d301-a7fe-4f58-85bc-b2c1ca324df5');
                                            </script> </span> 
                                        <!-- end HubSpot Call-to-Action Code --></span></div>
                            </div>
                        </center>
                    </div>
                    </div>
                      <!-- Footer Codes -->
                    <%@include file="../footer.jsp"%>
                </div>
            </div>
        </div>


        <%            if (request.getAttribute("cError") != null) {
        %>

        <script>
            alert("<%=request.getAttribute("cError")%>");
        </script>
        <%

            }

        %>

         <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="js/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.js"></script>
        <script src="js/tradeasia.js"></script>
  </body>
</html>