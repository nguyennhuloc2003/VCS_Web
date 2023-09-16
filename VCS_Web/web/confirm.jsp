<%@page import="model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/includes/headerMain.jsp" %>

<jsp:useBean id="siteID" class="java.lang.String" />
<jsp:setProperty name="siteID" property="*" />
<% 
    VaccineSite vs = ScheduleDB.getSite(siteID); 
%>
<section>
    <h1>Add Student </h1>
    <form action="create" method="POST">
        <LI>Student Name: ${vs.id}
        <LI>Student Gender: ${vs.dateFrom}
        <LI>Student DOB: ${vs.dateTo}
            <hr>    
        <input type="submit" value="Confirm" />
        <input type="button" value="Back" onclick="javascript:history.go(-1);" />
    </form>
</section>
            
<%@ include file="/includes/footer.jsp" %>