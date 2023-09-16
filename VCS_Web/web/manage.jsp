<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/includes/headerManage.jsp" %>
<%--<jsp:useBean id="listSchedule" class="java.util.ArrayList" scope="session" />--%>
<section id="table">
    <form action="search" method="POST" style="margin-bottom: 55px;">
        <div class="limiter-search">
            <div id="search-area">
                <div class="col-2-search" id="search-header">
                    <h3 class="col-2-search-item">Search for more</h3>
                    <img class="col-2-search-item" id="search-logo" src="images/search.png" alt="">
                </div>

                <div class="col-2-search" id="criteria-area">
                    <label class="col-2-search-item" for="criteria-selector">Criteria</label>
                    <select class="col-2-search-item" name="criteria-selector">
                        <option value="Staff ID">Staff ID</option>
                        <option value="User ID">User ID</option>
                        <option value="Location">Location</option>
                        <option value="Vaccine Name">Vaccine Name</option>
                        <option value="Time">Time</option>
                        <option value="All">All</option>
                    </select>
                </div>
                <div class="col-2-search" id="content-search-area">
                    <label class="col-2-search-item"  for="search-input">Detail</label>
                    <input class="col-2-search-item"  name="search-input" type="text" >
                </div>

            </div>
        </div>
        <div class="form-group input-div search-btn" style="text-align: center; margin-top: 80px;">
            <input type="submit" class="rounded submit px-5" value="Search" style="
                   background-color: #e3b04b !important;
                   border: 1px solid #e3b04b !important;
                   color: #fff !important;">
        </div>
    </form>

    <form action="signupVCSs" method="POST">
        <div class="limiter search-table">
            <div class="container-table100 height65">
                <div class="wrap-table100 wrap-6col">
                    <div class="table">
                        <div class="row-table header">
                            <div class="cell">
                                Schedule ID
                            </div>
                            <div class="cell">
                                Location
                            </div>
                            <div class="cell">
                                Vaccine
                            </div>
                            <div class="cell">
                                User
                            </div>
                            <div class="cell">
                                Staff
                            </div>
                            <div class="cell">
                                Time
                            </div>
                        </div>
                        <c:forEach items="${list}" var="s">
                            <div class="row-table" onclick="detailInfo('${s.scheduleID}')">
                                <div class="cell" data-title="Duration">
                                    ${s.scheduleID}
                                </div>
                                <div class="cell" data-title="Location">
                                    ${s.site.place.location}
                                </div>
                                <div class="cell " data-title="Vaccine">
                                    ${s.site.vaccine.type.typeName}
                                </div>
                                <div class="cell " data-title="User">
                                    ${s.user.name}
                                </div>
                                <div class="cell " data-title="User">
                                    ${s.staff.name}
                                </div>
                                <div class="cell " data-title="Time">
                                    ${s.timeString}
                                </div> 
                            </div>
                        </c:forEach>
                    </div>
                </div>

            </div>
        </div>
    </form> 
</section>
<!--    </body>
</html>-->
<%@ include file="/includes/footer.jsp" %>
