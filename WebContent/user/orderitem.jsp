<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
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
                            <a class="breadcrumb-item" href="home.jsp">主页</a>
                            <span class="breadcrumb-item active">购物清单</span>
                        </nav>
                    </div>
                </div> <!-- end of row -->
            </div> <!-- end of container -->
        </div>
        <!-- End of Breadcrumbs -->

        <!-- Start of Main Content Wrapper -->
        <div id="content" class="main-content-wrapper">
            
            <!-- Start of Shopping Cart Wrapper -->
            <div class="shopping-cart-wrapper">
                <div class="container">
                    <div class="row">
                        <div class="col-12 col-sm-12 col-md-12 col-lg-12">
                            <main id="primary" class="site-main">
                                <div class="shopping-cart">
                                    <div class="row">
                                        <div class="col-12 col-sm-12 col-md-12 col-lg-12">
                                            <div class="section-title left-aligned with-border">
                                                <h2>购物清单</h2>
                                            </div>

                                            <form action="#">
                                                <div class="table-responsive">
                                                    <table class="table table-bordered">
                                                        <thead>
                                                            <tr>
                                                                <td>图片</td>
                                                                <td>商品名</td>
                                                                <td>详细信息</td>
                                                                <td>数量</td>
                                                                <td>单价</td>
                                                                <td>总计</td>
                                                            </tr>
                                                        </thead>
                                                        <tbody id="maincart">
                                                         <c:set var="sum" value="0"></c:set>
                                                         <c:forEach items="${CartProduct}" var="c" varStatus="st">
                                                            <tr pid="${c.pid}" class="item">
                                                                <td>
                                                                    <a href="Common/Product/get?pid=${c.pid}"><img src="${c.productImgs[0].imgurl}" alt="Cart Product Image" title="Cas Meque Metus" class="img-thumbnail"></a>
                                                                </td>
                                                                <td>
                                                                    <a href="Common/Product/get?pid=${c.pid}">${c.pname}</a>
                                                                </td>
                                                                <td> <span>Delivery Date: 2018-04-22</span>
                                                                    <span>Color: Blue</span>
                                                                    <span>Reward Points: 300</span></td>
                                                                <td>
                                                                    
                                                                           <span>${c.number}</span>
                                                             
                                                                </td>
                                                                <td>$${c.pnewprice}</td>
                                                                <td>$${c.pnewprice}</td>
                                                            </tr>
                                                            <c:set var="sum" value="${sum+c.pnewprice*c.number}"></c:set>
                                                                   </c:forEach>

                                                        
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </form>

                                            <div class="cart-amount-wrapper">
                                                <div class="row">
                                                    <div class="col-12 col-sm-12 col-md-4 offset-md-8">
                                                        <table class="table table-bordered">
                                                            <tbody>
                                                                <tr>
                                                                    <td><strong>商品总价:</strong></td>
                                                                    <td class="psum"> $${sum}</td>
                                                                </tr>
                                                                <tr>
                                                                    <td><strong>订单总价:</strong></td>
                                                                    <td><span class="primary-color osum" >$${sum}</span></td>
                                                                </tr>
                                                            </tbody>
                                                        </table>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="cart-button-wrapper d-flex justify-content-between mt-4">
                                                <a href="user/home.jsp" class="btn btn-secondary">继续购物</a>
                                                <a href="${buttonUrl}" class="btn btn-secondary align-self-end">${button}</a>
                                            </div>
                                        </div>
                                    </div>
                                </div> <!-- end of shopping-cart -->
                            </main> <!-- end of #primary -->
                        </div>
                    </div> <!-- end of row -->
                </div> <!-- end of container -->
            </div>
            <!-- End of Shopping Cart Wrapper -->

         
        </div>
        <!-- End of Main Content Wrapper -->

       <!-- Start of Footer -->
      <%@include file="../include/footer.jsp"%>
        <!-- End of Footer -->
        <script type="text/javascript">
$("#maincart").on("click",".remove",function(){
	removeCartItem($(this).parents("tr").attr("pid"));
	var sum=$("#psum").text();
	sum=sum.substring(1,sum.length);
	sum=parseInt(sum)-$(this).parents("td").find("input").val()*$(this).attr("price");
	console.log(sum);
	$(".psum").html("$"+sum);
	$(".osum").html("$"+sum);
	$(this).parents("tr").fadeOut("slow");
});
$("#maincart").on("click",".update",function(){
	var sum=0;
	updateCartItem($(this).parents("tr").attr("pid"),$(this).parents("td").find("input").val());
	$(".item").each(function(){
		sum=sum+$(this).find("input").val()*$(this).find(".update").attr("price");
	})
	$(".psum").html("$"+sum);
	$(".osum").html("$"+sum);
});
</script>
