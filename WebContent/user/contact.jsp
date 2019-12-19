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
                            <a class="breadcrumb-item" href="user/home.jsp">主页</a>
                            <span class="breadcrumb-item active">联系我们</span>
                        </nav>
                    </div>
                </div> <!-- end of row -->
            </div> <!-- end of container -->
        </div>
        <!-- End of Breadcrumbs -->

        <!-- Start of Main Content Wrapper -->
        <main id="content" class="main-content-wrapper page-about">
            
            <!-- Start of Contact Section -->
            <section class="contact-section">
                <div class="container">
                    <div class="row">
                        <div class="col-12 col-sm-12 col-md-6 col-lg-6">
                            <div id="map_location" class="map-location">
                                <div id="map">
                                    <div id="gmap-wrap">
                                        <div id="gmap">
                                        </div>
                                    </div>
                                </div> <!-- end of #map -->
                            </div> <!-- end of #map_location -->
                        </div>
                        <div class="col-12 col-sm-12 col-md-6 col-lg-6">
                            <div class="contact-form-wrapper">
                                <div class="section-title left-aligned with-border">
                                    <h2>与我们取得联系</h2>
                                </div>
                                <form id="contact-form" action="sendemail.php" method="post">
                                    <div class="form-row mb-2">
                                        <div class="form-group col-12 col-sm-12 col-md-6">
                                            <input type="text" name="name" class="form-control" id="com-name" placeholder="你的名字*" required>
                                        </div>
                                        <div class="form-group col-12 col-sm-12 col-md-6">
                                            <input type="email" name="email" class="form-control" id="com-email" placeholder="你的邮箱*" required>
                                        </div>
                                    </div>
                                    <div class="form-row mb-2">
                                        <div class="form-group col-12 col-sm-12 col-md-12">
                                            <input type="text" name="subject" class="form-control" id="subject" placeholder="标题">
                                        </div>
                                    </div>
                                    <div class="form-row mb-2">
                                        <div class="form-group col-12 col-sm-12 col-md-12">
                                            <textarea id="comment" placeholder="内容" name="message" class="form-control" required></textarea>
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="col-12 col-sm-12 col-md-12">
                                            <button name="" type="submit" class="btn btn-secondary">发送邮件</button>
                                        </div>
                                    </div>
                                </form>
                            </div> <!-- end of contact-form-wrapper -->
                        </div>
                    </div> <!-- end of row -->
                </div> <!-- end of container -->
            </section>
            <!-- End of Contact Section -->

            <!-- Start of Team Section -->
            <section class="team-section pt-full pb-half bgc-offset">
                <div class="container">
                    <div class="row">
                        <div class="col-12 col-sm-12 col-md-6 col-lg-4">
                            <div class="info-box">
                                <div class="info-icon">
                                    <i class="ion ion-md-locate"></i>
                                </div>
                                <div class="info-content">
                                    <h4>我们的地址</h4>
                                    <p>萍乡学院</p>
                                    <p>江西萍乡</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-12 col-sm-12 col-md-6 col-lg-4">
                            <div class="info-box">
                                <div class="info-icon">
                                    <i class="ion ion-ios-call"></i>
                                </div>
                                <div class="info-content">
                                    <h4>打电话给我们</h4>
                                    <p>Mobile: <a href="#">(+1) 800 555 888</a></p>
                                    <p>Fax: (+1) 800 666 999</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-12 col-sm-12 col-md-12 col-lg-4">
                            <div class="info-box">
                                <div class="info-icon">
                                    <i class="ion ion-md-mail-open"></i>
                                </div>
                                <div class="info-content">
                                    <h4>发邮件给我们</h4>
                                    <p><a href="#">support24/7@example.com</a></p>
                                    <p><a href="#">contact@example.com</a></p>
                                </div>
                            </div>
                        </div>
                    </div> <!-- end of row -->
                </div> <!-- end of container -->
            </section>
            <!-- End of Team Section -->

            <!-- Start of Client Section -->
            <div class="client-section mb-full">
                <div class="container">
                    <div class="row">
                        <div class="col-12 col-sm-12 col-md-12">
                            <div class="client-carousel">

                                <!-- Slides -->
                                <div class="swiper-wrapper">
                                    <div class="item-brand swiper-slide">
                                        <img src="assets/images/brand/client-logo-1.jpg" alt="Client Logo">
                                    </div>
                                    <div class="item-brand swiper-slide">
                                        <img src="assets/images/brand/client-logo-2.jpg" alt="Client Logo">
                                    </div>
                                    <div class="item-brand swiper-slide">
                                        <img src="assets/images/brand/client-logo-3.jpg" alt="Client Logo">
                                    </div>
                                    <div class="item-brand swiper-slide">
                                        <img src="assets/images/brand/client-logo-4.jpg" alt="Client Logo">
                                    </div>
                                    <div class="item-brand swiper-slide">
                                        <img src="assets/images/brand/client-logo-5.jpg" alt="Client Logo">
                                    </div>
                                    <div class="item-brand swiper-slide">
                                        <img src="assets/images/brand/client-logo-6.jpg" alt="Client Logo">
                                    </div>
                                    <div class="item-brand swiper-slide">
                                        <img src="assets/images/brand/client-logo-7.jpg" alt="Client Logo">
                                    </div>
                                    <div class="item-brand swiper-slide">
                                        <img src="assets/images/brand/client-logo-8.jpg" alt="Client Logo">
                                    </div>
                                </div>
                            </div> <!-- end of client-carousel -->
                        </div> <!-- end of col -->
                    </div> <!-- end of row -->
                </div> <!-- end of container -->
            </div>
            <!-- End of Client Section -->

          
        </main>
        <!-- End of Main Content Wrapper -->

           <!-- Start of Footer -->
      <%@include file="../include/footer.jsp"%>
        <!-- End of Footer -->
