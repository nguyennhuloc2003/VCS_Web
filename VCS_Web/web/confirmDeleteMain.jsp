<%@page import="model.ScheduleDB"%>
<%@page import="model.Schedule"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/includes/headerMain.jsp" %>

<section class="ftco-section">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6 text-center mb-5">
                <h2 class="heading-section">Confirm</h2>
            </div>
        </div>
        <form action="deleteSchedule?sid=${param.sid}" method="POST">
            <div class="row justify-content-center">
                <div class="col-md-12 col-lg-10">
                    <div class="wrap d-md-flex">
                        <div class="img" style="background-image: url(images/login.jpg);">
                        </div>
                        <div class="login-wrap p-4 p-md-5"  style="height: 300px; position: relative;" >
                            <div class="vertical-center w-100" style=" left: 0;">
                                <div class="text-left p-4">
                                    <h3 class="mt-4" >Delete vaccine schedule?</h3>
                                    <h6 class="mt-5" >${param.sdate}</h6>
                                    <h6 class="mt-2" >${param.sloca}</h6>
                                    <div class="form-group">
                                        <button type="submit" class="form-control btn btn-primary rounded submit px-3 mt-4">Delete</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</section>

<%@ include file="/includes/footer.jsp" %>
