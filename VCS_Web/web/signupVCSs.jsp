<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/includes/headerStaff.jsp" %>
<jsp:useBean id="listSchedule" class="java.util.ArrayList" scope="session" />
<section id="table">
    <<form action="signupVCSs" method="POST">
        <div class="limiter">
            <div class="container-table100">
                <div class="wrap-table100">
                    <div class="table">
                        <div class="row-table header">
                            <div class="cell">
                                ID
                            </div>
                            <div class="cell">
                                Vaccine
                            </div>
                            <div class="cell">
                                Location
                            </div>
                            <div class="cell">
                                Customer
                            </div>
                            <div class="cell">
                                Vaccination Time
                            </div>
                        </div>

                        <c:forEach items="${listSchedule}" var="s">
                            <div class="row-table">
                                <div class="cell" data-title="ID">
                                    ${s.scheduleID}
                                </div>
                                <div class="cell " data-title="Vaccine">
                                    ${s.site.vaccine.type.typeName}
                                </div>
                                <div class="cell" data-title="Location">
                                    ${s.site.place.location}
                                </div>
                                <div class="cell"  data-title="Customer">
                                    ${s.user.name}
                                </div>
                                <div class="cell"  data-title="Vaccination Time">
                                    <input id="time-input" type="text" style="max-width: 80%;" name="time-input-${s.scheduleID}" />
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>

            </div>
            
            <div id="notic-input">
                <p>* Submit Vaccination Time as format: yyyy-MM-dd HH:mm:ss</p>
            </div>
            
            <div id="input-below-notic" class="form-group input-div" style="text-align: center; margin-top: -100px;">
                <input type="submit" class="rounded submit px-5" value="Sign up" style="
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
