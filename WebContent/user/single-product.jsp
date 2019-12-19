<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

          <!-- Start of Header -->
 <%@include file="../include/head.jsp"%>
        <!-- End of Header -->
        



        <div class="fixed-header-space"></div> <!-- empty placeholder div for Fixed Menu bar height-->

        <!-- Start of Breadcrumbs -->
        <div class="breadcrumb-section">
            <div class="container">
                <div class="row">
                    <div class="col-12 col-sm-12 col-md-12">
                        <nav class="breadcrumb">
                         <a class="breadcrumb-item" href="user/home.jsp">主页</a>
                            <a class="breadcrumb-item" href="Common/Product/list">所有商品</a>
                            <span class="breadcrumb-item active">商品详情</span>
                        </nav>
                    </div>
                </div> <!-- end of row -->
            </div> <!-- end of container -->
        </div>
        <!-- End of Breadcrumbs -->

        <!-- Start of Main Content Wrapper -->
        <div id="content" class="main-content-wrapper">
            
            <!-- Start of Main Product Wrapper -->
            <div class="main-product-wrapper">
                <div class="container">
                    <div class="row">
                        <div class="col-12 col-sm-12 col-md-12 col-lg-12">
                            <main id="primary" class="site-main">
                                <div class="single-product-wrapper">
                                    <div class="row">
                                        <div class="col-12 col-sm-12 col-md-6 col-lg-6">
                                            <div class="product-gallery">
                                                <div class="gallery-with-thumbs">
                                                    <div class="product-full-image main-slider image-popup">

                                                        <!-- Slides -->
                                                        <div class="swiper-wrapper">
                                                            <figure class="swiper-slide">
                                                                <a href="${product.productImgs[0].imgurl}" data-size="800x800">
                                                                    <img src="${product.productImgs[0].imgurl}" alt="Product Image">
                                                                    <div class="image-overlay"><i class="pe-7s-expand1"></i></div>
                                                                </a>
                                                                <figcaption class="visually-hidden">
                                                                    <span>商品图片</span>
                                                                </figcaption>
                                                            </figure>
                                                            <figure class="swiper-slide">
                                                                <a href="${product.productImgs[1].imgurl}" data-size="800x800">
                                                                    <img src="${product.productImgs[1].imgurl}" alt="Product Image">
                                                                    <div class="image-overlay"><i class="pe-7s-expand1"></i></div>
                                                                </a>
                                                                <figcaption class="visually-hidden">
                                                                    <span>Product Image</span>
                                                                </figcaption>
                                                            </figure>
                                                            
                                                        </div>
                                                    </div> <!-- end of product-full-image -->

                                                    <div class="product-thumb-image pos-r">
                                                        <div class="nav-slider">

                                                            <!-- Slides -->
                                                            <div class="swiper-wrapper">
                                                                <div class="swiper-slide">
                                                                    <img src="${product.productImgs[0].imgurl}" alt="Product Thumbnail Image">
                                                                </div>
                                                                <div class="swiper-slide">
                                                                    <img src="${product.productImgs[1].imgurl}" alt="Product Thumbnail Image">
                                                                </div>
                                                            </div>

                                                            <!-- Navigation -->
                                                            <div class="swiper-arrow next"><i class="fa fa-angle-right"></i></div>
                                                            <div class="swiper-arrow prev"><i class="fa fa-angle-left"></i></div>
                                                        </div> <!-- end of nav-slider -->
                                                    </div> <!-- end of product-thumb-image -->
                                                </div> <!-- end of gallery-with-thumbs -->
                                            </div> <!-- end of product-gallery -->
                                        </div>
                                        <div class="col-12 col-md-6 col-lg-6">
                                            <div class="product-details">
                                                <h3 class="product-name">${product.pname}</h3>
                                                <div class="product-ratings d-flex">
                                                    <ul class="rating d-flex mr-4">
                                                       <c:forEach var="x" begin="1" end="${product.pstarlevel}" step="1">
                                                           <li><i class="fa fa-star"></i></li>
                                                              </c:forEach>                                                                                      
                                                       <c:forEach var="x" begin="1" end="${5-product.pstarlevel}" step="1">
                                                        <li><i class="fa fa-star-o"></i></li>
                                                        </c:forEach>      
                                                    </ul>
                                                      <c:set var="sum" value="0"></c:set>
                                                    <c:forEach items="${comments}" var="comment" varStatus="st"><c:set var="sum" value="${sum+1}"></c:set></c:forEach>
                                                    <ul class="comments-advices list-inline d-flex">
                                                        <li class="list-inline-item mr-3"><a href="javascript:void(0)">${sum} 评论</a></li>
                                                         <li class="list-inline-item"></li>
                                                    </ul>
                                                </div>
                                                <div class="product-price">
                                                    <p class="d-flex align-items-center">
                                                        <span class="price-old">${product.poldprice}</span>
                                                        <span class="price-new">${product.pnewprice}</span>
                                                        <span class="price-discount">${product.plabel}</span>
                                                    </p>
                                                </div>
                                                <div class="product-meta">
                                                    <ul class="list-unstyled">
                                                        
                                                        <li>种类: <span>${product.ptype}</span></li>
                                                       
                                                    </ul>
                                                </div>
                                                <div class="product-description">
                                                    <p>${product.pinfo}</p>
                                                </div>
                                                <div class="product-actions">
                                                    <h3>可用选项</h3>
                                                    
                                                    <div class="product-stock">
                                                       <label>数量</label>
                                                      
                                                        <ul class="d-flex flex-wrap align-items-center" id="single-cart">
                                                            <li class="box-quantity">
                                                                    
                                                                   <input class="quantity" id="single-quantity" type="number" min="1" value="1">                                                                
                                                            </li>
                                                            <li>
                                                                <button type="button"id="bsingle-cart" class="default-btn" pid="${product.pid}">加入购物车</button>
                                                            </li>
                                                        </ul>

                                                    </div>
                                                    <div class="wishlist-compare">
                                                       
                                                        
                                                    </div>
                                                </div>

                                                <div class="social-sharing d-flex align-items-center mt-half">
                                                    <span>Share</span>
                                                    <ul class="list-inline">
                                                        <li class="list-inline-item"><a href="#" class="bg-facebook" data-toggle="tooltip" data-position="top" data-original-title="Facebook" target="_blank"><i class="fa fa-facebook"></i><span>Share</span></a></li>
                                                        <li class="list-inline-item"><a href="#" class="bg-twitter" data-toggle="tooltip" data-position="top" data-original-title="Twitter" target="_blank"><i class="fa fa-twitter"></i><span>Tweet</span></a></li>
                                                        <li class="list-inline-item"><a href="#" class="bg-gplus" data-toggle="tooltip" data-position="top" data-original-title="Google Plus" target="_blank"><i class="fa fa-google-plus"></i><span>Google+</span></a></li>
                                                        <li class="list-inline-item"><a href="#" class="bg-pinterest" data-toggle="tooltip" data-position="top" data-original-title="Pinterest" target="_blank"><i class="fa fa-pinterest"></i><span>Pinterest</span></a></li>
                                                    </ul>
                                                </div>
                                            </div> <!-- end of product-details -->
                                        </div>
                                    </div> <!-- end of row -->

                                    <div class="row">
                                        <div class="col-12 col-sm-12 col-md-12">
                                            <div class="product-info mt-full">
                                                 <ul class="nav nav-pills justify-content-center" id="pills-tab" role="tablist">
                                                    <li class="nav-item mr-4">
                                                        <a class="nav-link active" id="nav_desctiption" data-toggle="pill" href="#tab_description" role="tab" aria-controls="tab_description" aria-selected="true">描述</a>
                                                    </li>
                                                    <li class="nav-item">
                                                        <a class="nav-link" id="nav_review" data-toggle="pill" href="#tab_review" role="tab" aria-controls="tab_review" aria-selected="false">评论</a>
                                                    </li>
                                                </ul>
                                                <div class="tab-content">
                                                    <div class="tab-pane fade show active" id="tab_description" role="tabpanel" aria-labelledby="nav_desctiption">
                                                        <p>${product.pinfo}</p>
                                                    </div>
                                                    <div class="tab-pane fade" id="tab_review" role="tabpanel" aria-labelledby="nav_review">
                                                        <div class="product-review">
                                                            <div class="customer-review">
                                                                <table class="table table-striped table-bordered">
                                                                    <tbody>
                                                                  
                                                                    <c:forEach items="${comments}" var="comment" varStatus="st">
                                                                    
                                                                        <tr>
                                                                            <td><strong>${comment.name}</strong></td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td colspan="2">
                                                                                <p>${comment.content}</p>                                                                                
                                                                            </td>
                                                                        </tr>
                                                                        
                                                                        </c:forEach>
                                                                    </tbody>
                                                                </table>
                                                              
                                                            </div> <!-- end of customer-review -->
                                                            <form action="User/Comment/add" class="review-form">
                                                                <h2>写评论</h2>
                                                                
                                                                <div class="form-group row">
                                                                    <div class="col">
                                                                        <label class="col-form-label"><span class="text-danger">*</span> 你的评论</label>
                                                                        <input name="pid" type="hidden" value="${product.pid}"/>
                                                                        <textarea name="content" id="commentcontent" class="form-control" required></textarea>
                                                                        
                                                                    </div>
                                                                </div>
                                                               
                                                                <div class="buttons d-flex justify-content-end">
                                                                    <button class="default-btn" type="submit" id="commentadd">提交</button>
                                                                </div>
                                                            </form> <!-- end of review-form -->
                                                        </div> <!-- end of product-review -->
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div> <!-- end of row -->
                                </div> <!-- end of single-product-wrapper -->
                            </main> <!-- end of #primary -->
                        </div>
                    </div> <!-- end of row -->
                </div> <!-- end of container -->
            </div>
            <!-- End of Main Product Wrapper -->          
           
        </div>
        <!-- End of Main Content Wrapper -->


   <!-- Start of Footer -->
      <%@include file="../include/footer.jsp"%>
        <!-- End of Footer -->
        <script >
        $("#bsingle-cart").click(function(){
        	cartadd($(this).attr("pid"),$("#single-quantity").val());
        })

</script>
       