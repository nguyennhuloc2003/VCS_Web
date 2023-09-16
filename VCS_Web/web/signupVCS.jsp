<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/includes/headerMain.jsp" %>
<jsp:useBean id="listSite" class="java.util.ArrayList" scope="session" />
<section id="table">
    <<form action="signupVCS" method="POST">
        <div class="limiter">
            <div class="container-table100">
                <div class="wrap-table100">
                    <div class="table">
                        <div class="row-table header">
                            <div class="cell">
                                Date From
                            </div>
                            <div class="cell">
                                Date To
                            </div>
                            <div class="cell">
                                Location
                            </div>
                            <div class="cell">
                                Vaccine
                            </div>
                            <div class="cell">
                                Select one
                            </div>
                        </div>

                        <c:forEach items="${listSite}" var="s">
                            <div class="row-table">
                                <div class="cell" data-title="Date From">
                                    ${s.dateFromString}
                                </div>
                                <div class="cell" data-title="Date To">
                                    ${s.dateToString}
                                </div>
                                <div class="cell" data-title="Location">
                                    ${s.place.location}
                                </div>
                                <div class="cell " data-title="Vaccine">
                                    ${s.vaccine.type.typeName}
                                </div>
                                <div class="cell"data-title="Select one">
                                    <input type ="radio" name="siteID" value="${s.siteID}" />
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>

            </div>
            <div class="form-group input-div" style="text-align: center; margin-top: -50px;">
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
