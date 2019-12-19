<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<footer id="colophon">

	<!-- Footer Description -->
	<div class="footer-description">
		<div class="container">
			<div class="row">
				<div class="col-12 col-sm-12 col-md-12">
					<h2>在Ororus网上购物</h2>
					<p>我们的产品范围广泛且价格合理，包括最新的电子产品和小配件，包括智能手机、平板电脑、智能手表、行动摄像头、电视盒、电视、无人机、3D打印机、汽车DVR，以及最新的酷炫玩具，如滑板车、游戏配件、玩具屋、假装游戏和高质量的生活方式产品，包括真空吸尘器。净水器、空气净化器、厨房工具、吊灯、手电筒、油漆等。</p>
				</div>
			</div>
			<!-- endo of row -->
		</div>
		<!-- end of container -->
	</div>
	<!-- end of footer-description -->

	<!-- Footer Copyright -->
	<div class="footer-copyright">
		<div class="container">
			<div class="row align-items-center">
				<div class="col-12 col-sm-12 col-md-12 col-lg-6">
					<p class="copyright-text">
						Copyright (c) 2018 <a href="http://www.bootstrapmbhtmlsucai.com/"
							rel="nofollow">Ororus Themes</a>. All Right Reserved.
					</p>
				</div>
				
			</div>
			<!-- end of row -->
		</div>
		<!-- end of container -->
	</div>
	<!-- end of footer-copyright -->
</footer>

<!-- Start of Scroll to Top -->
<div id="to_top">
	<i class="ion ion-ios-arrow-forward"></i> <i
		class="ion ion-ios-arrow-forward"></i>
</div>
<!-- End of Scroll to Top -->
</div>
<!-- End of Whole Site Wrapper -->

<!-- Initializing Photoswipe -->
<div class="pswp" tabindex="-1" role="dialog" aria-hidden="true">
	<div class="pswp__bg"></div>
	<div class="pswp__scroll-wrap">
		<div class="pswp__container">
			<div class="pswp__item"></div>
			<div class="pswp__item"></div>
			<div class="pswp__item"></div>
		</div>
		<div class="pswp__ui pswp__ui--hidden">
			<div class="pswp__top-bar">
				<div class="pswp__counter"></div>
				<button class="pswp__button pswp__button--close" title="Close (Esc)"></button>
				<button class="pswp__button pswp__button--share" title="Share"></button>
				<button class="pswp__button pswp__button--fs"
					title="Toggle fullscreen"></button>
				<button class="pswp__button pswp__button--zoom" title="Zoom in/out"></button>
				<div class="pswp__preloader">
					<div class="pswp__preloader__icn">
						<div class="pswp__preloader__cut">
							<div class="pswp__preloader__donut"></div>
						</div>
					</div>
				</div>
			</div>
			<div
				class="pswp__share-modal pswp__share-modal--hidden pswp__single-tap">
				<div class="pswp__share-tooltip"></div>
			</div>
			<button class="pswp__button pswp__button--arrow--left"
				title="Previous (arrow left)"></button>
			<button class="pswp__button pswp__button--arrow--right"
				title="Next (arrow right)"></button>
			<div class="pswp__caption">
				<div class="pswp__caption__center"></div>
			</div>
		</div>
	</div>
</div>
<!-- End of Photoswipe -->


<!-- JS
    ============================================ -->

<!-- Popper JS -->
<script src="assets/js/popper.min.js"></script>

<!-- Bootstrap JS -->
<script src="assets/js/bootstrap.min.js"></script>

<!-- Plugins JS -->
<script src="assets/js/plugins.js"></script>

<!-- Main JS -->
<script src="assets/js/main.js"></script>
<script src="assets/js/jquery.lazyload.min.js"></script>
 <script  src="assets/js/toastr.js"></script>
 <script  src="assets/js/index.js"></script>
<c:if test="${info ne null}">
<script>
toastr.info("${info}","提示",{timeOut: 1500});
</script>
</c:if>
<c:if test="${success ne null}">
<script>
toastr.success("${success}","成功",{timeOut: 1000});
</script>
</c:if>
<c:if test="${warning ne null}">
<script>
toastr.warning("${warning}","警告",{timeOut: 1500});
</script>
</c:if>
<c:if test="${error ne null}">
<script>
toastr.error("${error}","错误",{timeOut: 1500});
</script>
</c:if>
<c:if test="${user ne null}">
<script>
cartlist();
</script>
</c:if>
</body>
</html>