<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/includes/headerMain.jsp" %>
<jsp:useBean id="listSchedule" class="java.util.ArrayList" scope="session" />
<section id="table">
    <<form action="signupVCS" method="POST">
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
                                Staff
                            </div>
                            <div class="cell">
                                Time
                            </div>
                            <div class="cell">
                                Status
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
                                <div class="cell " data-title="Staff">
                                    ${s.staff.name}
                                </div>
                                <div class="cell " data-title="Time">
                                    ${s.timeString}
                                </div>
                                <div class="cell ${s.status}" data-title="Status">
                                    ${s.status} 
                                </div>
                                <div class="cell"data-title="Delete">
                                    <c:if test="${s.canBeDeletedByUser eq true}">
                                        <a href="confirmDeleteMain.jsp?sid=${s.scheduleID}&sdate=${s.site.dateFromString} to ${s.site.dateToString}&sloca=${s.site.place.location}">Delete</a>
                                    </c:if>
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
