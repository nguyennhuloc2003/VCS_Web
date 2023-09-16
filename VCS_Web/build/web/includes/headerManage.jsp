<%@page contentType="text/html" pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib  uri="WEB-INF/tlds/mytag_library.tld" prefix="mytag" %>
<html>
    <head>
        <!-- basic -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!-- mobile metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="viewport" content="initial-scale=1, maximum-scale=1">
        <!-- site metas -->
        <title>Covido</title>
        <meta name="keywords" content="">
        <meta name="description" content="">
        <meta name="author" content="">
        <!-- bootstrap css -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <!-- style css -->
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/main.css">
        <!-- Responsive-->
        <link rel="stylesheet" href="css/responsive.css">
        <!-- fevicon -->
        <link rel="icon" href="images/fevicon.png" type="image/gif" />
        <!-- Scrollbar Custom CSS -->
        <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
        <link rel="stylesheet" href="css/owl.carousel.min.css"> 
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">
        <link rel="stylesheet" href="https://rawgit.com/LeshikJanz/libraries/master/Bootstrap/baguetteBox.min.css">
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
    </head>
    <% request.setCharacterEncoding("UTF-8"); %>
<% response.setCharacterEncoding("UTF-8"); %>
    <!-- body -->
    <body class="main-layout">
        <!-- loader  -->
        <div class="loader_bg">
            <div class="loader"><img src="images/loading.gif" alt="#"/></div>
        </div>
        <!-- end loader -->
        <!-- top -->
        <!-- header -->
        <header class="header-area">
            <div onclick="openUserInfo()" class="user-icon right" style="cursor: pointer;">
                <a><i class="fa fa-user" aria-hidden="true" style="line-height: 87px;"></i></a>
            </div>
            <div class="right user-info" style="display:none;">
                <ul>
                    <li><h2>Manager</h2></li>
                    <li><div>
                        <p class="user-name">Manager<p>
                        <p class="user-id">#manager</p>
                    </div></li>
                    <li><a href="LogOutServlet">Log out</a></li>
                </ul>
            </div>

            <div class="container">
                <div class="row d_flex">
                    <div class="col-sm-3 logo_sm">
                        <div class="logo">
                            <a href="index.html"></a>
                        </div>
                    </div>
                    <div class="col-lg-10 offset-lg-1 col-md-12 col-sm-9">
                        <div class="navbar-area navbar-staff">
                            <nav class="site-navbar">
                                <ul>
                                    <li><a class="active" href="mainManage.jsp">Home</a></li>
                                    <li><a href="aboutManage.jsp">About</a></li>
                                    <li><a href="mainManage.jsp" class="logo_midle">VCS</a></li>
                                    <li><a href="protectManage.jsp">Protect</a></li>
                                    <li><a href="search">VCS management</a></li>
                                </ul>
                                <button class="nav-toggler">
                                    <span></span>
                                </button>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        <!-- end header -->