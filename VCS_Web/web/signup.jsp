<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/includes/header.jsp" %>

<section class="ftco-section">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6 text-center mb-5">
                <h2 class="heading-section">Sign up</h2>
            </div>
        </div>
        <div class="row justify-content-center">
            <div class="col-md-12 col-lg-10">
                <div class="wrap d-md-flex">
                    <div class="img" style="background-image: url(images/login.jpg);">
                    </div>
                    <div class="login-wrap p-4 p-md-5">
                        <div class="">
                            <div class="w-100">
                                <h3 class="mb-4">Sign up</h3>
                            </div>
                            <div class="w-100">
                                <h4 class="mt-4 mb-4" style="color: red;">${inputError}</h3>
                            </div>
                        </div>
                        <form action="SignUpServlet" method="POST" id="sign-up-form">
                            <div class="form-group mb-3">
                                <label class="label" for="">Full name</label>
                                <input type="text" class="form-control" id="name-input" name="name-input" placeholder="Ex: Nguyen Van A" >
                                <span class="message-form"></span>
                            </div>
                            <div class="form-group mb-3">
                                <label class="label" for="">Phone</label>
                                <input type="text" class="form-control" id="phone-input" name="phone-input" placeholder="Ex: 0123456789" >
                                <span class="message-form"></span>
                            </div>
                            <div class="form-group mb-3">
                                <label class="label" for="gender">Gender</label>
                                <select class="form-control" name="gender-input" >
                                    <option value="Male">Male</option>
                                    <option value="Female">Female</option>
                                    <option value="Other">Other</option>
                                </select>
                            </div>
                            <div class="form-group mb-3">
                                <label class="label" for="date">Date of birth</label>
                                <input type="date" class="form-control" id="date-input" name="date-input">
                            </div>   
                            <div class="form-group mb-3">
                                <label class="label" for="">Username</label>
                                <input type="text" class="form-control" id="username-input" name="username-input" placeholder="Username">
                                <span class="message-form"></span> 
                            </div>
                            <div class="form-group mb-3">
                                <label class="label" for="">Password</label>
                                <input type="password" class="form-control" id="pass-input" name="pass-input" placeholder="Password">
                                <span class="message-form"></span>
                            </div>
                            <div class="form-group mb-2">
                                <label class="label" for="">Confirm password</label>
                                <input type="password" class="form-control" id="confirmpass-input" name="confirm-input" placeholder="Confirm password">
                                <span class="message-form"></span>
                            </div>
                            <div class="form-group mb-4">
                                <label class="label" for="role">Role</label>
                                <select class="form-control" name="role-input" >
                                    <option value="Customer">Customer</option>
                                    <option value="Staff">Staff</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <input type="submit" value="Sign up" class="login-btn form-control btn btn-primary rounded submit px-3"/>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<%@ include file="/includes/footer.jsp" %>