<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/includes/header.jsp" %>

<section class="ftco-section">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6 text-center mb-5">
                <h2 class="heading-section">Notification</h2>
            </div>
        </div>
        <div class="row justify-content-center">
            <div class="col-md-12 col-lg-10">
                <div class="wrap d-md-flex">
                    <div class="img" style="background-image: url(images/login.jpg);">
                    </div>
                    <div class="login-wrap p-4 p-md-5"  style="height: 300px; position: relative;" >
                        <div class="vertical-center w-100" style=" left: 0;">
                            <div class="text-center">
                                <img style="height: 50px;" src="${img}" alt="alt"/>
                                <h3 class="mt-4" >${notic}</h3>
                                <a href="${link}"><h4 class="btn-link">${subLink}</h4></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<%@ include file="/includes/footer.jsp" %>
