<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    <div class="pagination-area">
                                                <div class="row align-items-center">
                                                    <div class="col-lg-6 col-md-6">
                                                        <ul class="pagination" id="pagination">
                                                         <li id="doubleright" class="page-item"><a href="Common/Product/list?type=${page.type}&start=0" class="page-link">|<i class="fa fa-angle-double-left"></i></a></li>
                                                            <li  id="left" class="page-item <c:if test='${!page.isHasPreviouse()}'>disabled</c:if>"><a href="Common/Product/list?type=${page.type}&start=${page.start-page.count}" class="page-link"><i class="fa fa-angle-left"></i></a></li>                                                               
                                                            <li <c:if test="${!page.isHasPreviouse()}">style="display:none"</c:if> id="page" class="page-item"><a href="Common/Product/list?type=${page.type}&start=${page.start-page.count}" class="page-link">${page.getPageIndex()-1}</a></li>
                                                            <li id="page" class="page-item"><a href="Common/Product/list?type=${page.type}&start=${page.start}" class="page-link"><strong>${page.getPageIndex()}</strong></a></li>
                                                            <li <c:if test="${!page.isHasNext()}">style="display:none"</c:if> id="page" class="page-item"><a href="Common/Product/list?type=${page.type}&start=${page.start+page.count}" class="page-link">${page.getPageIndex()+1}</a></li>
                                                            <li  id="right" class="page-item <c:if test='${!page.isHasNext()}'>disabled</c:if>"><a href="Common/Product/list?type=${page.type}&start=${page.start+page.count}" class="page-link"><i class="fa fa-angle-right"></i></a></li>
                                                            <li id="doubleright" class="page-item"><a href="Common/Product/list?type=${page.type}&start=${page.getLast()}" class="page-link"><i class="fa fa-angle-double-right"></i>|</a></li>
                                                        </ul>
                                                    </div>
                                                    <div class="col-lg-6 col-md-6">
                                                        <!-- <div class="page-amount d-flex">
                                                            <p>Showing 10 to 18 of 27 (3 Pages)</p>
                                                        </div> -->
                                                    </div>
                                                </div>
                                            </div> <!-- end of pagination-area -->