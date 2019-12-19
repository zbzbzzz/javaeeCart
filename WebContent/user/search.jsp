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
                            <span class="breadcrumb-item active">所有商品</span>
                        </nav>
                    </div>
                </div> <!-- end of row -->
            </div> <!-- end of container -->
        </div>
        <!-- End of Breadcrumbs -->

        <!-- Start of Main Content Wrapper -->
        <div id="content" class="main-content-wrapper">
            
            <!-- Start of Shop Products Wrapper -->
            <div class="shop-products-wrapper">
                <div class="container">
                    <div class="row">
                        <div class="col-12 col-sm-12 col-md-12">
                            <main id="primary" class="site-main">
                                <div class="shop-wrapper">
                                   <div class="row">
                                        <div class="col-12 col-sm-12 col-md-12">
                                            <div class="shop-toolbar">
                                                <div class="toolbar-inner">
                                                    <div class="product-view-mode">
                                                        <ul role="tablist" class="nav shop-item-filter-list">
                                                            <li role="presentation" class="active"><a href="#grid" aria-controls="grid" role="tab" data-toggle="tab" class="active show" aria-selected="true"><i class="ion-md-grid"></i></a></li>
                                                            <li role="presentation"><a href="#list" aria-controls="list" role="tab" data-toggle="tab"><i class="ion-md-list"></i></a></li>
                                                        </ul>
                                                    </div>
                                              
                                                </div>
                                                
                                            </div>
                                        </div>
                                    </div> <!-- end of row -->

                                    <div class="row">
                                        <div class="col-12 col-sm-12 col-md-12">
                                            <div class="shop-products-wrapper">
                                                <div class="tab-content">
                                                    <div id="grid" class="tab-pane fade active show" role="tabpanel">
                                                        <div class="row" id="plist">
                                                        
                                                        <c:forEach items="${products}" var="product" varStatus="st">
                                                            <div class="product-layout product-grid col-6 col-sm-6 col-md-4 col-lg-3">
                                                                <div class="product-thumb">
                                                                    <div class="product-inner">
                                                                        <div class="product-image">
                                                                            <div class="label-product label-new">${product.plabel}</div>
                                                                            <a href="Common/Product/get?pid=${product.pid}">
                                                                            
                                                                                <img src="${product.productImgs[0].imgurl}" alt="Proin Lectus Ipsum" class="hover-image">
                                                                                <img src="${product.productImgs[1].imgurl}" alt="Proin Lectus Ipsum" title="Proin Lectus Ipsum">
                                                                            
                                                                            </a>
                                                                            <div class="action-links">
                                                                                <a class="action-btn btn-cart" href="javascript:void(0)" title="加入购物车" pid="${product.pid}"><i class="pe-7s-cart"></i></a>
                                                                                                                                                                
                                                                                    <a class="action-btn btn-quickview" data-toggle="modal" data-target="#product_quick_view" href="#" title="快速查看" data-whatever="${st.index}"><i class="pe-7s-search"></i></a>
                                                                            </div>
                                                                        </div> <!-- end of product-image -->

                                                                        <div class="product-caption">
                                                                            <div class="product-ratings">
                                                                                <div class="rating-box">
                                                                                    <ul class="rating d-flex">
                                                                                    <c:forEach var="x" begin="1" end="${product.pstarlevel}" step="1">
                                                                                        <li><i class="fa fa-star"></i></li>
                                                                                        </c:forEach>                                                                                      
                                                                                          <c:forEach var="x" begin="1" end="${5-product.pstarlevel}" step="1">
                                                                                        <li><i class="fa fa-star-o"></i></li>
                                                                                        </c:forEach>
                                                                                    </ul>
                                                                                </div>
                                                                            </div>
                                                                            <h4 class="product-name"><a href="product/${product.pid}">${product.pname}</a></h4>
                                                                            <p class="product-price">
                                                                                <span class="price-old">$${product.poldprice}</span>
                                                                                <span class="price-new">$${product.pnewprice}</span>
                                                                            </p>
                                                                        </div><!-- end of product-caption -->
                                                                    </div><!-- end of product-inner -->
                                                                </div><!-- end of product-thumb -->
                                                            </div> <!-- end of product-layout -->
														</c:forEach>
														
                                                        </div>
                                                    </div>
                                                    <div id="list" class="tab-pane fade" role="tabpanel">
                                                        <div class="row">                        
                                                            <div class="col-12 col-sm-12 col-md-12">
                                                               <c:forEach items="${products}" var="product" varStatus="st">
                                                                <div class="product-layout product-list">
                                                                    <div class="product-thumb">
                                                                        <div class="product-inner media align-items-center">
                                                                            <div class="product-image mb-4 mb-md-0 mr-md-4 mr-xl-5">
                                                                                <div class="label-product label-new">${product.plabel}</div>
                                                                                <a href="Common/Product/get?pid=${product.pid}">
                                                                                    <img src="${product.productImgs[0].imgurl}" alt="Proin Lectus Ipsum" class="hover-image">
                                                                                    <img src="${product.productImgs[1].imgurl}" alt="Proin Lectus Ipsum" title="Proin Lectus Ipsum">
                                                                                </a>
                                                                                <div class="action-links">
                                                                                    <a class="action-btn btn-cart" href="javascript:void(0)" title="加入购物车" pid="${product.pid}"><i class="pe-7s-cart"></i></a>
                                                                                   
                                                                                    <a class="action-btn btn-quickview" data-toggle="modal" data-target="#product_quick_view" href="#" title="快速查看" data-whatever="${st.index}"><i class="pe-7s-search"></i></a>
                                                                                </div>
                                                                            </div> <!-- end of product-image -->

                                                                            <div class="product-caption media-body">
                                                                                <div class="product-ratings">
                                                                                    <div class="rating-box">
                                                                                        <ul class="rating d-flex justify-content-md-start">
                                                                                         <c:forEach var="x" begin="1" end="${product.pstarlevel}" step="1">
                                                                                        <li><i class="fa fa-star"></i></li>
                                                                                        </c:forEach>                                                                                      
                                                                                          <c:forEach var="x" begin="1" end="${5-product.pstarlevel}" step="1">
                                                                                        <li><i class="fa fa-star-o"></i></li>
                                                                                        </c:forEach>      
                                                                                        </ul>
                                                                                    </div>
                                                                                </div>
                                                                                <h4 class="product-name" pid="${product.pid}"><a href="product/${product.pid}">${product.pname}</a></h4>
                                                                                <p class="product-price">
                                                                                    <span class="price-old">$${product.poldprice}</span>
                                                                                    <span class="price-new">$${product.pnewprice}</span>
                                                                                </p>
                                                                                <p class="product-des">${product.pinfo}</p>
                                                                            </div><!-- end of product-caption -->
                                                                        </div><!-- end of product-inner -->
                                                                    </div><!-- end of product-thumb -->
                                                                </div> <!-- end of product-layout -->
			                                                  </c:forEach>
                                                                
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div> <!-- end of shop-products-wrapper -->

                                           <%@include file="../include/searchpagination.jsp"%>
                                        </div>
                                    </div> <!-- end of row -->
                                </div> <!-- end of shop-wrapper -->
                            </main> <!-- end of #primary -->
                        </div>
                    </div> <!-- end of row -->
                </div> <!-- end of container -->
            </div>
            <!-- End of Shop Products Wrapper -->
           
        </div>
        <!-- End of Main Content Wrapper -->
       

        <%@include file="../include/quicklyview.jsp"%>
<script type="text/javascript">
$(function(){
	console.log($.trim($("#plist").html())=="");
	if($.trim($("#plist").html())=="")
		$("#plist").html("<h1>暂无此类型商品</h1>");
	
})
$("#plist").on("click",".btn-cart",function(){
	
	cartadd($(this).attr("pid"),1);
    console.log($(this).attr("pid"));
 
  });
$("#list").on("click",".btn-cart",function(){
	cartadd($(this).attr("pid"),1);
  });

</script>
             <!-- Start of Footer -->
      <%@include file="../include/footer.jsp"%>
        <!-- End of Footer -->
   
