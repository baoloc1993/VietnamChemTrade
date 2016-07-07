<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file = "../setting.jsp" %>

<title>Blog Tradeasia | Chemtradeasia | Tradeasia

International Pte Ltd - Việt Nam</title> 
<meta name = "keyword" content = "blog kinh doanh hóa chất, blog về hóa chất, blog về

hóa chất Việt Nam, dữ liệu về hóa chất dệt may,

hóa chất quan trọng đối với ngành nông nghiệp,

ihóa chất quan trọng đối với ngành dệt may, bản

cáo bạch kinh doanh hóa chất tại Việt Nam trong

tương lai">

<meta name = "description" content  = "Chemtradeasia: cập nhật các thông tin mới nhất về

hoá chất cho khách hàng và đem đến nhiều chủ đề

hấp dẫn về hoá chất lẫn kinh doanh hóa chất."/>
<link href="//static.hsstatic.net/content_shared_assets/static-1.3962/css/public_common.css" rel="stylesheet">
<script src="//platform.linkedin.com/in.js" type="text/javascript">
    lang: en_US
</script>
<script src="https://platform.linkedin.com/js/secureAnonymousFramework?v=0.0.2000-RC8.49177-1428&amp;lang=en_US"></script>
<link href="//cdn2.hubspot.net/hub/-1/hub_generated/style_manager/1431123893544/hubspot_default/shared/responsive/layout.min.css" rel="stylesheet">
<link href="//cdn2.hubspot.net/hub/492768/hub_generated/style_manager/1424665659890/custom/styles/default/hs_default_custom_style.min.css" rel="stylesheet">
<meta name="twitter:site" content="@SreeTradeasia">
<link rel="next" href="http://blog.chemtradeasia.com/page/2">
<link rel="canonical" href="http://blog.chemtradeasia.com">
<link href="css/blog.css" rel="stylesheet">
<body class="blog   hs-blog-id-2534177909 hs-blog-listing" style="">
	<div class = "container">
	<div class = "row">
		<div class = "col-md-10 col-offset-1 centerRow">
			<%@ include file = "../header_nav.jsp" %>
			<div class="body-container-wrapper">
    			<div class="body-container container-fluid">
        			<div class="row-fluid-wrapper row-depth-1 row-number-1 ">
        				<div class="row ">
            				<div class="col-md-12 widget-span widget-type-cell page-center content-wrapper" style="" data-widget-type="cell" data-x="0" data-w="12">

                				<div class="row-fluid-wrapper row-depth-1 row-number-2 ">
                					<div class="row">
                    					<div class="col-md-12 widget-span widget-type-raw_jinja hs-blog-header" style="" data-widget-type="raw_jinja" data-x="0" data-w="12">
											<h1>Tradeasia International Pte Ltd </h1></div><!--end widget-span -->

                						</div><!--end row-->
                					</div><!--end row-wrapper -->
                					<div class="row-fluid-wrapper row-depth-1 row-number-3 ">
                						<div class="row ">
                   							 <div class="col-md-8 widget-span widget-type-cell blog-content" style="" data-widget-type="cell" data-x="0" data-w="8">

                        						<div class="row-fluid-wrapper row-depth-2 row-number-1 ">
                        							<div class="row-fluid ">
                            							<div class="span12 widget-span widget-type-blog_content " style="" data-widget-type="blog_content" data-x="0" data-w="12">
															<div class="blog-section">
    															<div class="blog-listing-wrapper cell-wrapper">
        
        															<div class="post-listing">
            
																	<c:forEach items = "${blogs}" var = "blog">
                														<div class="post-item">
                    
													                        <div class="post-header">
													                            <h2><a href="${blog.link}">${blog.title}</a></h2>
																				
													                            <div id="hubspot-author_data" class="hubspot-editable" data-hubspot-form-id="author_data" data-hubspot-name="Blog Author">
													                                Posted by
													                                
													                                    <a class="author-link" >${blog.author}</a> on ${blog.date}
																						
													                            </div>
													                            
													                        </div>
													                        <div class="post-body clearfix">
													                            <!--post summary-->
													                            
																				<div class="hs-featured-image-wrapper">
																					<a href="${blog.link}" title="${blog.title }" class="hs-featured-image-link">
																						<img src="${blog.image }" class="hs-featured-image">
																					</a>
																				</div>
													                            
																					
																			</div>
																		
																			<a class="more-link" href="http://blog.chemtradeasia.com/the-chemicals-in-food">See more</a>
																					
																			<div class="custom_listing_comments">
						
																				${blog.numComments} Comments <a href="blog-comment?id=${blog.id }">Click here to read/write comments</a>
																			</div>
		
																		</div>
																	</c:forEach>
																	</div>

        
																	<div class="pagination">
																		
																			${paging }
																		
																	</div>
        
        
																</div>
															</div>
														</div>

													</div><!--end row-->
												</div><!--end row-wrapper -->
												<div class="row-fluid-wrapper row-depth-2 row-number-2 ">
													<div class="row-fluid ">
														<div class="span12 widget-span widget-type-blog_comments " style="" data-widget-type="blog_comments" data-x="0" data-w="12">
															<div class="cell-wrapper layout-widget-wrapper">
																<span id="hs_cos_wrapper_blog_comments" class="hs_cos_wrapper hs_cos_wrapper_widget hs_cos_wrapper_type_blog_comments" style="" data-hs-cos-general-type="widget" data-hs-cos-type="blog_comments"></span>
															</div><!--end layout-widget-wrapper -->
														</div><!--end widget-span -->
													</div><!--end row-->
												</div><!--end row-wrapper -->
											</div><!--end widget-span -->
											<div class="col-md-4 widget-span widget-type-cell blog-sidebar" style="" data-widget-type="cell" data-x="8" data-w="4">
												
												<div class="row-fluid-wrapper row-depth-2 row-number-4 ">
													<div class="row-fluid ">
														<div class="span12 widget-span widget-type-post_listing " style="" data-widget-type="post_listing" data-x="0" data-w="12">
															<div class="cell-wrapper layout-widget-wrapper">
																<span id="hs_cos_wrapper_top_posts" class="hs_cos_wrapper hs_cos_wrapper_widget hs_cos_wrapper_type_post_listing" style="" data-hs-cos-general-type="widget" data-hs-cos-type="post_listing">
																	<div class="block">
																		<h3>Recent Posts</h3>
																		<div class="widget-module">
																			<ul>
																				<!--Recent blog-->
																			</ul>
																
																		</div>
																	</div>
																</span>
															</div><!--end layout-widget-wrapper -->
														</div><!--end widget-span -->
													</div><!--end row-->
												</div><!--end row-wrapper -->
												
											</div><!--end widget-span -->
										</div><!--end row-->
									</div><!--end row-wrapper -->
								</div><!--end widget-span -->
							</div><!--end row-->
						</div><!--end row-wrapper -->

					</div><!--end body -->
				</div><!--end body wrapper -->

				<%@ include file = "../footer.jsp"%>


    
				<script type="text/javascript" src="//static.hsstatic.net/content_shared_assets/static-1.3962/js/public_common.js"></script>

				<!-- Start of Async HubSpot Analytics Code -->
				<script type="text/javascript">
				var _hsq = _hsq || [];
				_hsq.push(["setContentType", "listing-page"]);
				_hsq.push(["setCanonicalUrl", "http:\/\/blog.chemtradeasia.com"]);
				_hsq.push(["setPageId", "2534177909"]);
				_hsq.push(["setContentMetadata", {
					"contentPageId": null,
					"legacyPageId": null,
					"contentGroupId": 2534177909,
					"abTestId": null
				}]);
				_hsq.push(["setTargetedDefinitionMeta", {"matchedDefinitionIds":null,"definitionIds":null}]);
				(function(d,s,i,r) {
					if (d.getElementById(i)){return;}
					var n=d.createElement(s),e=d.getElementsByTagName(s)[0];
					n.id=i;n.src='//js.hs-analytics.net/analytics/'+(Math.ceil(new Date()/r)*r)+'/492768.js';
					e.parentNode.insertBefore(n, e);
				})(document,"script","hs-analytics",300000);
				</script>
				<!-- End of Async HubSpot Analytics Code -->


				<script type="text/javascript">
				var hsVars = {
					ticks: 1437703391497,
					page_id: 0,
					content_group_id: 2534177909,
					portal_id: 492768,
					app_hs_base_url: "https://app.hubspot.com"
				}
				</script>





				<div id="fb-root" class=" fb_reset"><div style="position: absolute; top: -10000px; height: 0px; width: 0px;"><div><iframe name="fb_xdm_frame_http" frameborder="0" allowtransparency="true" allowfullscreen="true" scrolling="no" id="fb_xdm_frame_http" aria-hidden="true" title="Facebook Cross Domain Communication Frame" tabindex="-1" src="http://static.ak.facebook.com/connect/xd_arbiter/X9pYjJn4xhW.js?version=41#channel=f3999cac5c&amp;origin=http%3A%2F%2Fblog.chemtradeasia.com" style="border: none;"></iframe><iframe name="fb_xdm_frame_https" frameborder="0" allowtransparency="true" allowfullscreen="true" scrolling="no" id="fb_xdm_frame_https" aria-hidden="true" title="Facebook Cross Domain Communication Frame" tabindex="-1" src="https://s-static.ak.facebook.com/connect/xd_arbiter/X9pYjJn4xhW.js?version=41#channel=f3999cac5c&amp;origin=http%3A%2F%2Fblog.chemtradeasia.com" style="border: none;"></iframe></div></div><div style="position: absolute; top: -10000px; height: 0px; width: 0px;"><div></div></div></div>
				 <script>(function(d, s, id) {
				  var js, fjs = d.getElementsByTagName(s)[0];
				  if (d.getElementById(id)) return;
				  js = d.createElement(s); js.id = id;
				  js.src = "//connect.facebook.net/en_US/all.js#xfbml=1&status=0";
				  fjs.parentNode.insertBefore(js, fjs);
				}(document, 'script', 'facebook-jssdk'));</script>
				<script type="text/javascript">
				  window.___gcfg = {
					lang: 'en-US',
					parsetags: 'onload'
				  };
				  (function() {
					var po = document.createElement('script'); po.type = 'text/javascript'; po.async = true;
					po.src = 'https://apis.google.com/js/platform.js';
					var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(po, s);
				  })();
				</script>
				<script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0];if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src="https://platform.twitter.com/widgets.js";fjs.parentNode.insertBefore(js,fjs);}}(document,"script","twitter-wjs");</script>
			</div>
		</div>
		</div>
	</body>
 </html>