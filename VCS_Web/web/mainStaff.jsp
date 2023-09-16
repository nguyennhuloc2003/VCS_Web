<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/includes/headerStaff.jsp" %>

<div>
    <!-- header inner -->
    <div class="section">
        ${user}
    </div>
</div>
<!-- about -->
<div class="about">
    <div class="container_width">
        <div class="row d_flex">
            <div class="col-md-7">
                <div class="titlepage text_align_left">
                    <h2>About Corona Virus </h2>
                    <p>Coronaviruses are a type of virus. There are many different kinds, and some cause disease. A coronavirus identified in 2019, SARS-CoV-2, has caused a pandemic of respiratory illness, called COVID-19.
                    </p>
                    <a class="read_more" href="aboutStaff.jsp">About More</a>
                </div>
            </div>
            <div class="col-md-5">
                <div class="about_img text_align_center">
                    <figure><img src="images/about.png" alt="#"/></figure>
                </div>
            </div>

        </div>
    </div>
</div>
<!-- end about -->
<!-- protect -->
<div class="protect">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="titlepage text_align_center">
                    <h2>How to Protect Yourself</h2>
                    <p>when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using  
                    </p>
                </div>
            </div>
        </div>
    </div>
    <div class="protect_bg">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <!--  Demos -->
                    <div class="owl-carousel owl-theme">
                        <div class="item">
                            <div class="protect_box text_align_center">
                                <div class="desktop">
                                    <i><img src="images/pro1.png" alt="#"/></i>
                                    <h3> Wear Mask</h3>
                                    <span> Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for</span>
                                </div>
                            </div>
                        </div>
                        <div class="item">
                            <div class="protect_box text_align_center">
                                <div class="desktop">
                                    <i><img src="images/pro2.png" alt="#"/></i>
                                    <h3> Wash Your Hands</h3>
                                    <span> Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for</span>
                                </div>
                            </div>
                        </div>
                        <div class="item">
                            <div class="protect_box text_align_center">
                                <div class="desktop">
                                    <i><img src="images/pro3.png" alt="#"/></i>
                                    <h3> Stay at Home</h3>
                                    <span> Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<!-- end protect -->



<%@ include file="/includes/footer.jsp" %>