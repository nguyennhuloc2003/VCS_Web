<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/includes/headerStaff.jsp" %>
<jsp:useBean id="listSchedule" class="java.util.ArrayList" scope="session" />
<section id="table">
    <form action="updateTime" method="POST">
        <div class="limiter">
            <div class="container-table100">
                <div class="wrap-table100 wrap-7col">
                    <div class="table">
                        <div class="row-table header">
                            <div class="cell">
                                Duration
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
                                Time
                            </div>
                            <div class="cell">
                                Update
                            </div>
                            <div class="cell">
                                Delete
                            </div>
                        </div>
                        <c:forEach items="${listSchedule}" var="s">
                            <div class="row-table">
                                <div class="cell" data-title="Duration">
                                    ${s.site.dateFromString} to ${s.site.dateToString}
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
                                <div class="cell time-chedule-${s.scheduleID}" data-title="Time">
                                    ${s.timeString}
                                </div>
                                <div class="cell time-input time-input-${s.scheduleID}" data-title="Time">
                                    <input type="text" name="time-input-${s.scheduleID}" />
                                </div>
                                <div class="cell" data-title="Update">
                                    <p id="update-link" onclick="updateTime('${s.scheduleID}')" >Update</p>
                                </div>
                                <div class="cell" data-title="Delete">
                                    <a href="confirmDeleteStaff.jsp?sid=${s.scheduleID}&sdate=${s.site.dateFromString} to ${s.site.dateToString}&sloca=${s.site.place.location}">Delete</a>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>

            </div>

            <div class="form-group input-div-dis-none" style="text-align: center; margin-top: -50px;">
                <input type="submit" class="rounded submit px-5" value="Update" style="
                       background-color: #e3b04b !important;
                       border: 1px solid #e3b04b !important;
                       color: #fff !important;">
            </div>
        </div>
    </form> 
</section>
<!--    </body>
</html>-->
<%@ include file="/includes/footer.jsp" %>
