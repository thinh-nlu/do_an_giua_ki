<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html lang="en">
<!-- Basic -->

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <!-- Mobile Metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Site Metas -->
    <title>NongLamXanh</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Site Icons -->
    <link rel="shortcut icon" href="../images/favicon.ico" type="image/x-icon">
    <link rel="apple-touch-icon" href="../images/apple-touch-icon.png">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <!-- Site CSS -->
    <link rel="stylesheet" href="../css/style.css">
    <!-- Responsive CSS -->
    <link rel="stylesheet" href="../css/responsive.css">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="../css/custom.css">
    <link rel="stylesheet" href="../asset/bootstrap-icons-1.11.1/bootstrap-icons.css">

    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
<div id="container_header"></div>
<jsp:include page="../include/header.jsp"/>

<!-- Start Main Top -->
<header class="main-header">
    <!-- Start Navigation -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light navbar-default bootsnav">
        <div class="container">
            <!-- Start Header Navigation -->
            <div class="navbar-header">
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-menu" aria-controls="navbars-rs-food" aria-expanded="false" aria-label="Toggle navigation">
                    <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand" href="../index.jsp"><img src="../images/logo1.png" class="logo" style="width: 200px;height: 108px" alt=""></a>
            </div>
            <!-- End Header Navigation -->

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="navbar-menu">
                <ul class="nav navbar-nav ml-auto" data-in="fadeInDown" data-out="fadeOutUp">
                    <li class="nav-item"><a class="nav-link" href="../index.jsp">Trang Chủ</a></li>
                    <li class="nav-item"><a class="nav-link" href="../about.jsp">Giới Thiệu</a></li>
                    <li class="dropdown active">
                        <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Tiện ích <i class="bi bi-list "></i></a>
                        <ul class="dropdown-menu">
                            <li><a href="cart.jsp">Giỏ Hàng</a></li>
                            <li><a href="checkout.jsp">Thanh Toán</a></li>
                            <li><a href="my-account.html">Tài Khoản</a></li>
                        </ul>
                    </li>
                    <li class="nav-item"><a class="nav-link" href="../gallery.jsp">Cửa Hàng</a></li>
                    <li class="nav-item"><a class="nav-link" href="../contact-us.jsp">Liên hệ </a></li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->

            <!-- Start Atribute Navigation -->
            <div class="attr-nav">
                <ul>
                    <li class="search"><a href="#"><i class="fa fa-search"></i></a></li>
                    <li class="side-menu"><a href="cart.jsp">
                        <i class="fa fa-shopping-bag"></i>
                        <span class="badge">3</span>
                        <p>Giỏ hàng</p>
                    </a></li>
                </ul>
            </div>
            <!-- End Atribute Navigation -->
        </div>
        <!-- Start Side Menu -->
        <div class="side">
            <a href="#" class="close-side"><i class="fa fa-times"></i></a>
            <li class="cart-box">
                <ul class="cart-list">
                    <li>
                        <a href="#" class="photo"><img src="../images/img-pro-01.jpg" class="cart-thumb" alt="" /></a>
                        <h6><a href="#">Delica omtantur </a></h6>
                        <p>1x - <span class="price">$80.00</span></p>
                    </li>
                    <li>
                        <a href="#" class="photo"><img src="../images/img-pro-02.jpg" class="cart-thumb" alt="" /></a>
                        <h6><a href="#">Omnes ocurreret</a></h6>
                        <p>1x - <span class="price">$60.00</span></p>
                    </li>
                    <li>
                        <a href="#" class="photo"><img src="../images/img-pro-03.jpg" class="cart-thumb" alt="" /></a>
                        <h6><a href="#">Agam facilisis</a></h6>
                        <p>1x - <span class="price">$40.00</span></p>
                    </li>
                    <li class="total">
                        <a href="#" class="btn btn-default hvr-hover btn-cart">VIEW CART</a>
                        <span class="float-right"><strong>Total</strong>: $180.00</span>
                    </li>
                </ul>
            </li>
        </div>
        <!-- End Side Menu -->
    </nav>
    <!-- End Navigation -->
</header>
<!-- End Main Top -->

<!-- Start Top Search -->
<div class="top-search">
    <div class="container">
        <div class="input-group">
            <span class="input-group-addon"><i class="fa fa-search"></i></span>
            <input type="text" class="form-control" placeholder="Search">
            <span class="input-group-addon close-search"><i class="fa fa-times"></i></span>
        </div>
    </div>
</div>
<!-- End Top Search -->

<!-- Start All Title Box -->
<div class="all-title-box">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <h2>Tài Khoản</h2>
                <ul class="breadcrumb">
                    <li class="breadcrumb-item"><a href="#">Tiện Ích</a></li>
                    <li class="breadcrumb-item active">Tài Khoản</li>
                </ul>
            </div>
        </div>
    </div>
</div>
<!-- End All Title Box -->

<!-- Start My Account  -->
<div class="my-account-box-main">
    <div class="container">
        <div class="my-account-page">
            <div class="row">
                <div class="col-lg-4 col-md-12">
                    <div class="account-box">
                        <div class="service-box">
                            <div class="service-icon">
                                <a href="list-order.jsp"> <i class="bi bi-person-fill fa-10x "></i> </a>
                            </div>
                            <div class="service-desc">
                                <h4>Danh sách đơn hàng</h4>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-12">
                    <div class="account-box">
                        <div class="service-box">
                            <div class="service-icon">
                                <a data-toggle="collapse" href="#profile"> <i class="bi bi-person-fill fa-10x "></i> </a>
                            </div>
                            <div class="service-desc">
                                <h4>Thay đổi thông tin</h4>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-12">
                    <div class="account-box">
                        <div class="service-box">
                            <div class="service-icon">
                                <a data-toggle="collapse" href="#change_password" ><i class="fa fa-lock"></i> </a>
                            </div>
                            <div class="service-desc">
                                <h4>Thay đổi mật khẩu</h4>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="collapse col align-self-center" id="profile">
                    <div class="container rounded bg-white mt-5">
                        <div class="row">
                            <div class="col-md-4 border-right">
                                <div class="d-flex flex-column align-items-center text-center p-3 py-5"><img class="rounded-circle mt-5" src="https://i.imgur.com/0eg0aG0.jpg" width="90"><span class="font-weight-bold">John Doe</span><span class="text-black-50">john_doe12@bbb.com</span></div>
                            </div>
                            <div class="col-md-8">
                                <div class="p-3 py-5">


                                    <div class="row mt-3">

                                        <div class="col-md-6"><input type="text" class="form-control" placeholder="email" value=""></div>

                                    </div>
                                    <div class="row mt-3">

                                        <div class="col-md-6"><input type="text" class="form-control" placeholder="Số điện thoại" value=""></div>

                                    </div>
                                    <div class="mt-5 text-right"><button class="btn btn-primary profile-button" type="button">Lưu thông tin</button></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="collapse col align-self-center" id="change_password">
                    <div class="container rounded bg-white mt-5">
                        <div class="row">
                            <div class="col-md-4 border-right">
                                <div class="d-flex flex-column align-items-center text-center p-3 py-5"><img class="rounded-circle mt-5" src="https://i.imgur.com/0eg0aG0.jpg" width="90"><span class="font-weight-bold">John Doe</span><span class="text-black-50">john_doe12@bbb.com</span><span>United States</span></div>
                            </div>
                            <div class="col-md-8">
                                <div class="p-3 py-5">

                                    <div class="row mt-2">
                                        <div class="col-md-6"><input type="password" class="form-control" placeholder="Nhập Mật Khẩu Cũ" value=""></div>

                                    </div>
                                    <div class="row mt-3">
                                        <div class="col-md-6"><input type="password" class="form-control" placeholder="Nhập Mật Khẩu Mới" value=""></div>

                                    </div>
                                    <div class="row mt-3">
                                        <div class="col-md-6"><input type="password" class="form-control" placeholder="Xác Nhận Mật Khẩu Mới" value=""></div>

                                    </div>

                                    <div class="mt-5 text-right"><button class="btn btn-primary profile-button" type="button">Lưu thông tin</button></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>



            </div>

        </div>
    </div>
</div>
<!-- End My Account -->

<!-- Start Instagram Feed  -->
<div class="instagram-box">
    <div class="main-instagram owl-carousel owl-theme">
        <div class="item">
            <div class="ins-inner-box">
                <img src="../images/instagram-img-01.jpg" alt="" />
                <div class="hov-in">
                    <a href="#"><i class="fab fa-instagram"></i></a>
                </div>
            </div>
        </div>
        <div class="item">
            <div class="ins-inner-box">
                <img src="../images/instagram-img-02.jpg" alt="" />
                <div class="hov-in">
                    <a href="#"><i class="fab fa-instagram"></i></a>
                </div>
            </div>
        </div>
        <div class="item">
            <div class="ins-inner-box">
                <img src="../images/instagram-img-03.jpg" alt="" />
                <div class="hov-in">
                    <a href="#"><i class="fab fa-instagram"></i></a>
                </div>
            </div>
        </div>
        <div class="item">
            <div class="ins-inner-box">
                <img src="../images/instagram-img-04.jpg" alt="" />
                <div class="hov-in">
                    <a href="#"><i class="fab fa-instagram"></i></a>
                </div>
            </div>
        </div>
        <div class="item">
            <div class="ins-inner-box">
                <img src="../images/instagram-img-05.jpg" alt="" />
                <div class="hov-in">
                    <a href="#"><i class="fab fa-instagram"></i></a>
                </div>
            </div>
        </div>
        <div class="item">
            <div class="ins-inner-box">
                <img src="../images/instagram-img-06.jpg" alt="" />
                <div class="hov-in">
                    <a href="#"><i class="fab fa-instagram"></i></a>
                </div>
            </div>
        </div>
        <div class="item">
            <div class="ins-inner-box">
                <img src="../images/instagram-img-07.jpg" alt="" />
                <div class="hov-in">
                    <a href="#"><i class="fab fa-instagram"></i></a>
                </div>
            </div>
        </div>
        <div class="item">
            <div class="ins-inner-box">
                <img src="../images/instagram-img-08.jpg" alt="" />
                <div class="hov-in">
                    <a href="#"><i class="fab fa-instagram"></i></a>
                </div>
            </div>
        </div>
        <div class="item">
            <div class="ins-inner-box">
                <img src="../images/instagram-img-09.jpg" alt="" />
                <div class="hov-in">
                    <a href="#"><i class="fab fa-instagram"></i></a>
                </div>
            </div>
        </div>
        <div class="item">
            <div class="ins-inner-box">
                <img src="../images/instagram-img-05.jpg" alt="" />
                <div class="hov-in">
                    <a href="#"><i class="fab fa-instagram"></i></a>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- End Instagram Feed  -->


<!-- Start Footer  -->
<footer>
    <div id="container_footer"></div>
    <script>
        fetch("../include/footer.html")
            .then(response => response.text())
            .then(data => {
                document.getElementById("container_footer").innerHTML = data;
            });
    </script>
</footer>
<!-- End Footer  -->
<!-- End copyright  -->

<a href="#" id="back-to-top" title="Back to top" style="display: none;"><i class="bi-arrow-up-short"></i></a>

<!-- ALL JS FILES -->
<script src="../js/jquery-3.2.1.min.js"></script>
<script src="../js/popper.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<!-- ALL PLUGINS -->
<script src="../js/jquery.superslides.min.js"></script>
<script src="../js/bootstrap-select.js"></script>
<script src="../js/inewsticker.js"></script>
<script src="js/bootsnav.js."></script>
<script src="../js/images-loded.min.js"></script>
<script src="../js/isotope.min.js"></script>
<script src="../js/owl.carousel.min.js"></script>
<script src="../js/baguetteBox.min.js"></script>
<script src="../js/form-validator.min.js"></script>
<script src="../js/contact-form-script.js"></script>
<script src="../js/custom.js"></script>
</body>

</html>