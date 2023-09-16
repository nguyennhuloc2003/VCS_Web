<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/includes/header.jsp" %>
<%--<jsp:useBean id="role" class="String" scope="session" />
<jsp:setProperty name="role" property="*" />--%>

<section class="ftco-section">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6 text-center mb-5">
                <h2 class="heading-section">Login</h2>
            </div>
        </div>
        <div class="row justify-content-center">
            <div class="col-md-12 col-lg-10">
                <div class="wrap d-md-flex">
                    <div class="img" style="background-image: url(images/login.jpg);">
                    </div>
                    <div class="login-wrap p-4 p-md-5">
                        <div class="d-flex">
                            <div class="w-100">
                                <h3 class="mb-4">Login</h3>
                            </div>
                        </div>
                        <form action="LoginServlet" method="POST" class="signin-form">
                            <div class="form-group mb-3">
                                <label class="label" for="name">Username</label>
                                <input type="text" class="form-control" placeholder="Username" name="username-login" value="${cookie[account].value}" required>
                            </div>
                            <div class="form-group mb-3">
                                <label class="label" for="password">Password</label>
                                <input type="password" class="form-control" placeholder="Password" name="password-login" value="${cookie[password].value}" required>
                            </div>
                            <div class="form-group mb-4">
                                <label class="label" for="role">Role</label>
                                <select class="form-control" name="role-login" required>
                                    <option value="Customer">Customer</option>
                                    <option value="Staff">Staff</option>
                                    <option value="Manager">Manager</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <button type="submit" class="form-control btn btn-primary rounded submit px-3">Sign In</button>
                            </div>
                            <div class="form-group d-md-flex">
                                <div class="w-50 text-left">
                                    <label class="checkbox-wrap checkbox-primary mb-0">Remember Me
                                        <input type="checkbox" name="remember" value="on" checked>
                                        <span class="checkmark"></span>
                                    </label>
                                </div>
                                <div class="w-50 text-md-right">
                                    <a href="#">Forgot Password</a>
                                </div>
                            </div>
                        </form>
                        <p class="text-center">Don't have account? <a href="signup.jsp">Sign Up</a></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<%@ include file="/includes/footer.jsp" %>