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
                            <a class="breadcrumb-item" href="index.html">Home</a>
                            <span class="breadcrumb-item active">404</span>
                        </nav>
                    </div>
                </div> <!-- end of row -->
            </div> <!-- end of container -->
        </div>
        <!-- End of Breadcrumbs -->

        <!-- Start of Main Content Wrapper -->
        <main id="content" class="main-content-wrapper">
            
            <!-- Start of Error 404 Section -->
            <section class="error-section">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="error-wrapper text-center">
                                <div class="error-text">
                                    <h1>404</h1>
                                    <h2>页面找不到了</h2>                                   
                                </div>
                                <div class="search-error">
                                    <form id="search-form" class="input-group" action="#">
                                        <input type="search" class="form-control" placeholder="Search.....">
                                        <button type="submit"><i class="fa fa-search"></i></button>
                                    </form>
                                </div>
                                <div class="error-button mt-half">
                                    <a href="admin/login.html" class="btn btn-secondary">返回登录页面</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div> <!-- end of container -->
            </section>
            <!-- End of Error 404 Section -->

            <!-- Start of Newsletter Section -->
            <section class="newsletter-section vpadding bgc-offset">
                <div class="container">
                    <div class="row align-items-center">
                        <div class="col-12 col-sm-12 col-md-12 col-lg-7">
                            <div class="newsletter-title d-lg-flex justify-content-lg-start">
                                <h6>Subscribe to our Newsletter</h6>
                                <h3>Subscribe to our newsletter and know first about all the promotions and discounts. Be always trendy.</h3>
                            </div>
                        </div>
                        <div class="col-12 col-sm-12 col-md-12 col-lg-5">
                            <div class="newsletter-form-wrapper">
                                <form action="index.html" method="post">
                                    <input type="email" name="email" placeholder="Enter you email address here..." value="" required> 
                                    <input type="submit" class="default-btn" name="contact" value="Subscribe">
                                </form>
                            </div>
                        </div>
                    </div> <!-- end of row -->
                </div> <!-- end of container -->
            </section>
            <!-- End of Newsletter Section -->
        </main>
        <!-- End of Main Content Wrapper -->

        <!-- Start of Footer -->
        <footer id="colophon">

            <!-- Footer Widgets Area -->
            <div class="footer-widgets-area">
                <div class="container">
                    <div class="footer-inner">
                        <div class="row">
                            <div class="col-12 col-sm-12 col-md-6 col-lg-3">
                                <aside class="widget-container">
                                    <h4 class="widgettitle">Contact Info</h4>
                                    <div class="widget-content">
                                        <p>We are a team of designers and developers that create high quality Magento, Prestashop, Opencart.</p>
                                        <div class="footer-contact">
                                            <p class="footer-address">The Barn, Ullenhall, Henley in Arden B578 5CC, England</p>
                                            <p class="footer-phone"><a href="#">+1 123 456 7890</a></p>
                                            <p class="footer-email"><a href="#">support@example.com</a></p>
                                        </div>
                                    </div> <!-- end of widget-content -->
                                </aside> <!-- end of widget-container -->
                            </div>

                            <div class="col-12 col-sm-12 col-md-6 col-lg-3">
                                <aside class="widget-container">
                                    <h4 class="widgettitle">Recent Posts</h4>
                                    <div class="widget-content">
                                        <div class="recent-posts-widget">

                                            <!-- Slides -->
                                            <div class="swiper-wrapper">
                                                <div class="swiper-slide">
                                                    <div class="posts-single media">
                                                        <div class="post-thumbnail mr-4 mr-lg-3 mr-xl-4">
                                                            <a href="#">
                                                                <img src="assets/images/blog/blog-thumb-1.jpg" alt="Blog Image">
                                                                <div class="overlay"></div>
                                                            </a>
                                                        </div>
                                                        <div class="post-content media-body">
                                                            <div class="post-title">
                                                                <h5><a href="">Aypi non habent claritatem insitam</a></h5>
                                                            </div>
                                                            <div class="post-date">09 Aug</div>
                                                        </div>
                                                    </div> <!-- end of posts-single -->

                                                    <div class="posts-single media">
                                                        <div class="post-thumbnail mr-4 mr-lg-3 mr-xl-4">
                                                            <a href="#">
                                                                <img src="assets/images/blog/blog-thumb-2.jpg" alt="Blog Image">
                                                                <div class="overlay"></div>
                                                            </a>
                                                        </div>
                                                        <div class="post-content media-body">
                                                            <div class="post-title">
                                                                <h5><a href="">Bypi non habent claritatem insitam</a></h5>
                                                            </div>
                                                            <div class="post-date">09 Aug</div>
                                                        </div>
                                                    </div> <!-- end of posts-single -->
                                                </div>

                                                <div class="swiper-slide">
                                                    <div class="posts-single media">
                                                        <div class="post-thumbnail mr-4 mr-lg-3 mr-xl-4">
                                                            <a href="#">
                                                                <img src="assets/images/blog/blog-thumb-3.jpg" alt="Blog Image">
                                                                <div class="overlay"></div>
                                                            </a>
                                                        </div>
                                                        <div class="post-content media-body">
                                                            <div class="post-title">
                                                                <h5><a href="">Cabent claritatem insitam</a></h5>
                                                            </div>
                                                            <div class="post-date">21 Nov</div>
                                                        </div>
                                                    </div> <!-- end of posts-single -->

                                                    <div class="posts-single media">
                                                        <div class="post-thumbnail mr-4 mr-lg-3 mr-xl-4">
                                                            <a href="#">
                                                                <img src="assets/images/blog/blog-thumb-4.jpg" alt="Blog Image">
                                                                <div class="overlay"></div>
                                                            </a>
                                                        </div>
                                                        <div class="post-content media-body">
                                                            <div class="post-title">
                                                                <h5><a href="">Cypi non habent claritatem insitam</a></h5>
                                                            </div>
                                                            <div class="post-date">09 Aug</div>
                                                        </div>
                                                    </div> <!-- end of posts-single -->
                                                </div>
                                            </div>
                                        </div> <!-- end of recent-posts-widget -->
                                    </div> <!-- end of widget-content -->
                                </aside> <!-- end of widget-container -->
                            </div>

                            <div class="col-12 col-sm-12 col-md-6 col-lg-2">
                                <aside class="widget-container">
                                    <h4 class="widgettitle">Information</h4>
                                    <div class="widget-content">
                                        <div class="widgetized-menu">
                                            <ul class="list-unstyled">
                                                <li><a href="#">About Us</a></li>
                                                <li><a href="#">Delivery Information</a></li>
                                                <li><a href="#">Privacy Policy</a></li>
                                                <li><a href="#">Terms &amp; Conditions</a></li>
                                                <li><a href="#">Brands</a></li>
                                                <li><a href="#">Gift Certificates</a></li>
                                            </ul>
                                        </div>
                                    </div> <!-- end of widget-content -->
                                </aside> <!-- end of widget-container -->
                            </div>

                            <div class="col-12 col-sm-12 col-md-6 col-lg-4">
                                <aside class="widget-container">
                                    <h4 class="widgettitle">Popular Tags</h4>
                                    <div class="widget-content">
                                        <div class="tags-widget">
                                            <ul>
                                                <li><a href="#">headphones</a></li>
                                                <li><a href="#">mobile</a></li>
                                                <li><a href="#">gamepad</a></li>
                                                <li><a href="#">cameras</a></li>
                                                <li><a href="#">drone</a></li>
                                                <li><a href="#">tvs</a></li>
                                                <li><a href="#">smartwatch</a></li>
                                            </ul>
                                        </div>
                                    </div> <!-- end of widget-content -->
                                </aside> <!-- end of widget-container -->
                            </div>
                        </div> <!-- end of row -->
                    </div> <!-- end of footer-inner -->
                </div> <!-- end of container -->
            </div> <!-- end of footer-widgets-area -->

            <!-- Footer Description -->
            <div class="footer-description">
                <div class="container">
                    <div class="row">
                        <div class="col-12 col-sm-12 col-md-12">
                            <h2>Online Shopping at Ororus.</h2>
                            <p>Our extensive and affordable range features the very latest electronics and gadgets including smart phones, tablets, smart watches, action cams, tv boxes, televisions, drones, 3d printers, car dvr, along with the latest cool toys like scooters, gaming accessories, doll houses, pretend play and high quality lifestyle products comprising vacuum cleaners, air purifier, kitchen tools, ceiling lights, flashlight, oil painting, etc.</p>
                        </div>
                    </div> <!-- endo of row -->
                </div> <!-- end of container -->
            </div> <!-- end of footer-description -->

            <!-- Footer Copyright -->
            <div class="footer-copyright">
                <div class="container">
                    <div class="row align-items-center">
                        <div class="col-12 col-sm-12 col-md-12 col-lg-6">
                            <p class="copyright-text">Copyright (c) 2018 <a href="http://www.htmlsucai.com/" rel="nofollow">Ororus Themes</a>. All Right Reserved.</p>
                        </div>
                        <div class="col-12 col-sm-12 col-md-12 col-lg-6">
                            <div class="footer-payment">
                                <ul>
                                    <li><a href="#"><img src="assets/images/icons/payment-1.jpg" alt="Payment Icons"></a></li>
                                    <li><a href="#"><img src="assets/images/icons/payment-2.jpg" alt="Payment Icons"></a></li>
                                    <li><a href="#"><img src="assets/images/icons/payment-3.jpg" alt="Payment Icons"></a></li>
                                    <li><a href="#"><img src="assets/images/icons/payment-4.jpg" alt="Payment Icons"></a></li>
                                    <li><a href="#"><img src="assets/images/icons/payment-5.jpg" alt="Payment Icons"></a></li>
                                    <li><a href="#"><img src="assets/images/icons/payment-6.jpg" alt="Payment Icons"></a></li>
                                </ul>
                            </div>
                        </div>
                    </div> <!-- end of row -->
                </div> <!-- end of container -->
            </div> <!-- end of footer-copyright -->
        </footer>
        <!-- End of Footer -->

        <!-- Start of Scroll to Top -->
        <div id="to_top">
            <i class="ion ion-ios-arrow-forward"></i>
            <i class="ion ion-ios-arrow-forward"></i>
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
                    <button class="pswp__button pswp__button--fs" title="Toggle fullscreen"></button>
                    <button class="pswp__button pswp__button--zoom" title="Zoom in/out"></button>
                    <div class="pswp__preloader">
                        <div class="pswp__preloader__icn">
                            <div class="pswp__preloader__cut">
                                <div class="pswp__preloader__donut"></div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="pswp__share-modal pswp__share-modal--hidden pswp__single-tap">
                    <div class="pswp__share-tooltip"></div>
                </div>
                <button class="pswp__button pswp__button--arrow--left" title="Previous (arrow left)">
                </button>
                <button class="pswp__button pswp__button--arrow--right" title="Next (arrow right)">
                </button>
                <div class="pswp__caption">
                    <div class="pswp__caption__center"></div>
                </div>
            </div>
        </div>
    </div>
    <!-- End of Photoswipe -->


    <!-- JS
    ============================================ -->

    <!-- jQuery JS -->
    <script src="assets/js/jquery.1.12.4.min.js"></script>

    <!-- Popper JS -->
    <script src="assets/js/popper.min.js"></script>

    <!-- Bootstrap JS -->
    <script src="assets/js/bootstrap.min.js"></script>

    <!-- Plugins JS -->
    <script src="assets/js/plugins.js"></script>

    <!-- Main JS -->
    <script src="assets/js/main.js"></script>

</body>
</html>
