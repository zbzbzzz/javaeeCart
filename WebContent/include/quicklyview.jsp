<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Quick View Content Start以下为弹出的商品框的内容 -->
        <div class="product-quick-view">
            <div class="container">
                <!-- Start of Modal -->
                <div class="modal fade" id="product_quick_view">
                    <div class="modal-dialog modal-lg modal-dialog-centered">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                            </div> <!-- end of modal-header -->

                            <div class="modal-body">
                                <div class="row">
                                    <div class="col-12 col-md-6 col-lg-6">
                                        <div class="product-gallery">
                                            <div class="gallery-with-thumbs">
                                                <div class="product-full-image main-slider image-popup">

                                                    <!-- Slides -->
                                                   <div class="swiper-wrapper">
                                   
                                                        <figure class="swiper-slide">
                                                            <a href="assets/images/products/single/product-6.jpg" data-size="800x800">
                                                                <img src="assets/images/products/single/product-6.jpg" alt="Product Image">
                                                                <div class="image-overlay"><i class="pe-7s-expand1"></i></div>
                                                            </a>
                                                            <figcaption class="visually-hidden">
                                                                <span>Product Image</span>
                                                            </figcaption>
                                                        </figure>
                                                    </div>
                                                </div> 

                                                <div class="product-thumb-image pos-r">
                                                    <div class="nav-slider">
                                                        <!-- Slides -->
                                                        <div class="swiper-wrapper">
      
                                                            <div class="swiper-slide">
                                                                <img src="assets/images/products/single/product-thumb-6.jpg" alt="Product Thumbnail Image">
                                                            </div> 
                                                        </div>

                                                        <!-- Navigation -->
                                                        <div class="swiper-arrow next"><i class="fa fa-angle-right"></i></div>
                                                        <div class="swiper-arrow prev"><i class="fa fa-angle-left"></i></div>
                                                    </div>
                                                </div> <!-- end of product-thumb-image -->
                                            </div> <!-- end of gallery-with-thumbs -->
                                        </div> <!-- end of product-gallery -->
                                    </div>
                                    <div class="col-12 col-md-6 col-lg-6">
                                        <div class="product-details">
                                            <h3 class="product-name" pid="">商品名</h3>
                                            <div class="product-ratings">
                                                <ul class="rating d-flex">
                                                    
                                                </ul>
                                            </div>
                                            <div class="product-price">
                                                <p class="d-flex align-items-center">
                                                    <span class="price-old"></span>
                                                    <span class="price-new"></span>
                                                    <span class="price-discount"></span>
                                                </p>
                                            </div>
                                            <div class="product-description">
                                                <p>商品简介</p>
                                            </div>
                                            <div class="product-actions">
                                                <h3>可用选项</h3>
                                                <div class="product-stock">
                                                   <label>数量</label>
                                                    <ul class="d-flex flex-wrap align-items-center">
                                                        <li class="box-quantity">                                                           
                                                                <input class="quantity" type="number" min="1" value="1">                                          
                                                        </li>
                                                        <li>
                                                            <button type="button" class="default-btn" id="quicklytocart">加入购物车</button>
                                                        </li>
                                                       
                                                    </ul>
                                                </div>
                                                
                                            </div>
                                        </div> <!-- end of product-details -->
                                    </div>
                                </div> <!-- end of row -->
                            </div> <!-- end of modal-body -->

                            <div class="modal-footer justify-content-start">
                                <div class="social-sharing d-flex align-items-center">
                                    <span>分享</span>
                                    <ul class="list-inline">
                                        <li class="list-inline-item"><a href="#" class="bg-facebook" data-toggle="tooltip" data-position="top" data-original-title="Facebook" target="_blank"><i class="fa fa-facebook"></i><span>Share</span></a></li>
                                        <li class="list-inline-item"><a href="#" class="bg-twitter" data-toggle="tooltip" data-position="top" data-original-title="Twitter" target="_blank"><i class="fa fa-twitter"></i><span>Tweet</span></a></li>
                                        <li class="list-inline-item"><a href="#" class="bg-gplus" data-toggle="tooltip" data-position="top" data-original-title="Google Plus" target="_blank"><i class="fa fa-google-plus"></i><span>Google+</span></a></li>
                                        <li class="list-inline-item"><a href="#" class="bg-pinterest" data-toggle="tooltip" data-position="top" data-original-title="Pinterest" target="_blank"><i class="fa fa-pinterest"></i><span>Pinterest</span></a></li>
                                    </ul>
                                </div>
                            </div> <!-- end of modal-footer -->
                        </div> <!-- end of modal-content -->
                    </div> <!-- end of modal-dialog -->
                </div> <!-- end of modal -->
            </div> <!-- end of container -->
        </div>
        <!-- Quick View Content End -->
        <script>
        var result;
        $.ajax({
        	                     url: "Common/Product/ajaxlist?type=${page.type}&start=${page.start}",
        	                    type: "get",   
        	                    dataType: "json",       	                   
        	                  success: function (data) {
        	                       result =data;
        	                        console.log("商品数据加载成功：quciklyview加载成功");        	                        
        	                     }
        	               });

        $('#product_quick_view').on('show.bs.modal', function (event) {
        	 var index = $(event.relatedTarget).data('whatever');
        	 var modal = $(this);
      
          modal.find('.product-name').text(result[index].pname);
          modal.find('.product-name').attr("pid",result[index].pid);
          modal.find('.price-old').text("$"+result[index].poldprice);
          modal.find('.price-new').text("$"+result[index].pnewprice);
          modal.find('.price-discount').text(result[index].plabel);
       modal.find('.product-description').html("<p>商品简介</p>"+result[index].pinfo);
       modal.find('#quicklytocart').unbind();
       modal.find('#quicklytocart').click(
    		   function(){
    			   cartadd(result[index].pid,modal.find('.quantity').val());
    			   modal.find('.close').click();
    		   }
       );
       
       var starhtml=""; 
       var fullimghtml="";
       var imghtml="";
       
      for(var i=0;i<parseInt(result[index].pstarlevel);i++)
    	   starhtml+="<li><i class='"+"fa fa-star"+"'></i></li>"
    	for(var i=0;i<5-parseInt(result[index].pstarlevel);i++)
    		starhtml+=" <li><i class='"+"fa fa-star-o"+"'></i></li>";
          
          for(var i in result[index].productImgs)
        	  fullimghtml+="<figure class='"+"swiper-slide"+"'>"
									  +            "<a href='"+result[index].productImgs[i].imgurl+"' data-size='"+"800x800"+"'>"
									  +            "<img src='"+result[index].productImgs[i].imgurl+"' alt='"+"Product Image"+"'>"
									  +             "<div class='"+"image-overlay"+"'><i class='"+"pe-7s-expand1"+"'></i></div>"
									  +        "</a>"
									  +        "<figcaption class='"+"visually-hidden"+"'>"
									  +           "<span>Product Image</span>"
									  +        "</figcaption>"
									  +    "</figure>";
				
			  for(var i in result[index].productImgs)
				 imghtml+= "<div class='swiper-slide' style='width: 133px; margin-right: 15px;' >"
						              +   "<img src='"+result[index].productImgs[i].imgurl+"' alt='"+"Product Thumbnail Image"+"'>"
						              +   "</div>";  
				 
	         modal.find('.rating').html(starhtml);
	         modal.find('.product-full-image>.swiper-wrapper').html(fullimghtml);
	         modal.find('.nav-slider>.swiper-wrapper').html(imghtml); 
                   
          console.log(result[index].productImgs[0].imgurl);
         

        	
        	
        });
      
        </script>