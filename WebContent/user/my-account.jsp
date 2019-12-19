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
                            <span class="breadcrumb-item active">我的账户</span>
                        </nav>
                    </div>
                </div> <!-- end of row -->
            </div> <!-- end of container -->
        </div>
        <!-- End of Breadcrumbs -->

        <!-- Start of Main Content Wrapper -->
        <div id="content" class="main-content-wrapper">
            
            <!-- Start of My Account Wrapper -->
            <div class="my-account-wrapper">
                <div class="container">
                    <div class="row">
                        <div class="col-12 col-sm-12 col-md-12 col-lg-12">
                            <main id="primary" class="site-main">
                                <div class="user-dashboard">
                                    <div class="user-info">
                                        <div class="row align-items-center no-gutters">
                                           <div class="col-12 col-sm-12 col-md-6 col-lg-3 col-xl-3">
                                               <div class="single-info">
                                                   <p class="user-name">你好 <span> ${user.name} </span> <br>(不是  ${user.name} ? <a  class="log-out" href="Common/User/logout">注销</a>)</p>
                                               </div>
                                           </div>
                                           <div class="col-12 col-sm-12 col-md-6 col-lg-4 col-xl-3">
                                               <div class="single-info">
                                                   <p>需要帮助吗? 在这里获取客户服务 <a href="user/contact.jsp">admin@example.com</a></p>
                                               </div>
                                           </div>
                                           <div class="col-12 col-sm-12 col-md-6 col-lg-3 col-xl-3">
                                               <div class="single-info">
                                                   <p>邮箱地址 <a href="user/contact.jsp">support@example.com</a></p>
                                               </div>
                                           </div>
                                           <div class="col-12 col-sm-12 col-md-6 col-lg-2 col-xl-3">
                                               <div class="single-info text-lg-center">
                                                   <a class="btn btn-secondary" href="User/Cart/list">查看购物车</a>
                                               </div>
                                           </div>
                                       </div> <!-- end of row -->
                                    </div> <!-- end of user-info -->

                                    <div class="main-dashboard">
                                        <div class="row">
                                            <div class="col-12 col-sm-12 col-md-12 col-lg-2">
                                                <ul class="nav flex-column dashboard-list" role="tablist">
                                                    <li> <a class="nav-link" data-toggle="tab" href="#orders">订单</a></li>                                                   
                                                    <li ><a class="nav-link" href="Common/User/logout">注销</a></li>
                                                </ul> <!-- end of dashboard-list -->
                                            </div>

                                            <div class="col-12 col-sm-12 col-md-12 col-lg-10">
                                                <!-- Tab panes -->
                                                <div class="tab-content dashboard-content">

                                                    <div id="orders" class="tab-pane fade show active">
                                                        <h3>订单</h3>
                                                        <div class="table-responsive">
                                                            <table class="table">
                                                                <thead>
                                                                    <tr>
                                                                        <th>订单</th>
                                                                        <th>日期</th>
                                                                        <th>状态</th>
                                                                        <th>总计</th>
                                                                        <th>操作</th>                
                                                                    </tr>
                                                                </thead>
                                                                <tbody>
                                                                <c:forEach items="${orderlist}" var="order" varStatus="st">
                                                                    <tr>
                                                                        <td>${st.count}</td>
                                                                        <td>${order.time}</td>
                                                                        <td>${order.statusStr}</td>
                                                                        <td>${order.sum}</td>
                                                                        <td><a class="btn btn-secondary" href="${order.actionurl}">${order.action}</a></td>
                                                                    </tr>
                                                                    </c:forEach>
                                                                </tbody>
                                                            </table>
                                                        </div>
                                                    </div> <!-- end of tab-pane -->

                                                  
                                                                                       
                                                </div>
                                            </div>
                                        </div> <!-- end of row -->
                                    </div> <!-- end of main-dashboard -->
                                </div> <!-- end of user-dashboard -->
                            </main> <!-- end of #primary -->
                        </div>
                    </div> <!-- end of row -->
                </div> <!-- end of container -->
            </div>
            <!-- End of My Account Wrapper -->

           
        </div>
        <!-- End of Main Content Wrapper -->
            

           <!-- Start of Footer -->
      <%@include file="../include/footer.jsp"%>
        <!-- End of Footer -->