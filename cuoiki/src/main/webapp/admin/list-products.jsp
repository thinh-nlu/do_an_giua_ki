<%@ page import="model.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.ProductDAO" %>
<%@ page import="database.DBConnect" %>
<%@ page import="model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored = "false" %>
<%
    String spageid = request.getParameter("page");
    int pageid = (spageid != null && !spageid.isEmpty()) ? Integer.parseInt(spageid) : 1;
    int totalPerPage =16;
    int activePage = pageid;
    int previousPage = pageid-1;
    int nextPage = pageid+1;
    if(pageid==1){}
    else{
        pageid=pageid-1;
        pageid=pageid* totalPerPage +1;
    }
    ProductDAO dao = new ProductDAO(DBConnect.getConnection());
    List<Product> list = dao.getRecords(pageid, totalPerPage);
    List<Product> allList = dao.getAllProduct();
    double totalProducts = allList.size();
    int totalPage = (int) Math.ceil(totalProducts /totalPerPage);
    User user = (User) session.getAttribute("success");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>NongLamXanh</title>
    <link rel="stylesheet" href="../asset/bootstrap-icons-1.11.1/bootstrap-icons.css">
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

    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body class="">
<!-- Start Main Top -->
<div class="main-top">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                <div class="our-link">
                    <ul>
                        <li><a href="../tien_ich/my-account.jsp"><i class="fa fa-user s_color"></i> Tài khoản của tôi</a></li>
                        <li><a href="../contact-us.jsp"><i class="fas fa-headset"></i> Liên hệ </a></li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                <div class="login-register">
                    <ul>
                        <% if (user != null) { %>
                        <% if (user.getIsAdmin().equals("1")) { %>
                        <li><a href="../tien_ich/my-account.jsp">Xin chào <%=user.getName()%></a></li>
                        <li><a href="${pageContext.request.contextPath}/logout">Đăng Xuất</a></li>
                        <%} else {%>
                        <li><p>Xin chào <%= user.getName() %></p></li>
                        <li><a href="../admin/admin.jsp">Trang Quản Lí</a></li>
                        <li><a href="${pageContext.request.contextPath}/logout">Đăng Xuất</a></li>
                        <%}%>
                        <% } else { %>
                        <li><a href="../account/registration.jsp">Đăng Kí</a></li>
                        <li><a href="../account/login.jsp">Đăng Nhập</a></li>
                        <% } %>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- End Main Top -->
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
                <a class="navbar-brand " href="../index.jsp"><img src="../images/logo1.png" class="logo " style="width: 200px;height: 108px" alt="" ></a>
            </div>
            <!-- End Header Navigation -->

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="navbar-menu">
                <ul class="nav navbar-nav ml-auto" data-in="fadeInDown" data-out="fadeOutUp">
                    <li class="nav-item active"><a class="nav-link" href="../index.jsp">Trang Chủ</a></li>
                    <li class="nav-item"><a class="nav-link" href="../about.jsp">Giới Thiệu</a></li>
                    <li class="dropdown">
                        <a href="#" class="nav-link dropdown-toggle arrow" data-toggle="dropdown">Tiện Ích</a>
                        <ul class="dropdown-menu">
                            <li><a href="../tien_ich/cart.jsp">Giỏ Hàng</a></li>
                            <li><a href="../tien_ich/checkout.jsp">Thanh Toán</a></li>
                            <li><a href="../tien_ich/my-account.jsp">Tài Khoản</a></li>
                        </ul>
                    </li>
                    <li class="nav-item"><a class="nav-link" href="../gallery.jsp">Cửa Hàng</a></li>
                    <li class="nav-item"><a class="nav-link" href="../contact-us.jsp">Liên Hệ</a></li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->

            <!-- Start Atribute Navigation -->
            <div class="attr-nav">
                <ul>
                    <li class="search"><a href="#"><i class="fa fa-search"></i></a></li>
                    <li class="side-menu">
                        <a href="#">
                            <i class="fa fa-shopping-bag"></i>
                            <span class="badge">0</span>
                            <p>Giỏ Hàng</p>
                        </a>
                    </li>
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
                        <a href="#" class="photo"><img src="images/img-pro-01.jpg" class="cart-thumb" alt="" /></a>
                        <h6><a href="#">Delica omtantur </a></h6>
                        <p>1x - <span class="price">$80.00</span></p>
                    </li>
                    <li>
                        <a href="#" class="photo"><img src="images/img-pro-02.jpg" class="cart-thumb" alt="" /></a>
                        <h6><a href="#">Omnes ocurreret</a></h6>
                        <p>1x - <span class="price">$60.00</span></p>
                    </li>
                    <li>
                        <a href="#" class="photo"><img src="images/img-pro-03.jpg" class="cart-thumb" alt="" /></a>
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
<h3 class="text-center text-dark pb-3 display-4 font-weight-normal" >Tất cả sản phẩm</h3>
<c:if test="${not empty successUpdate}">
    <p class="text-center text-success">${successUpdate}</p>
    <c:remove var="successUpdate" scope="session"/>
</c:if>
<c:if test="${not empty failedUpdate}">
    <p class="text-center text-danger">${failedUpdate}</p>
    <c:remove var="failedUpdate" scope="session"/>
</c:if>
<div class="px-lg-5 pt-xl-5">
<h3 class="text-center text-dark pt-xl-3 display-4 font-weight-normal" >Tất cả sản phẩm</h3>

<div class="px-lg-5 pt-xl-1">
    <table class="table table-striped text-center ">
        <thead class="bg-dark">
        <tr class="text-light">
            <th>ID</th>
            <th>Tên sản phẩm </th>
            <th>Hình ảnh sản phẩm </th>
            <th>Giá</th>
            <th>Đơn giá</th>
            <th>Chỉnh sửa</th>
            <th>Xóa</th>
        </tr>
        </thead>
        <tbody class="bg-light text-dark">
        <%
            for (Product p: list) {
                if (p!=null) {
        %>
        <tr class='text-center text-dark font-weight-normal  '>
            <td><%=p.getId()%></td>
            <td><%=p.getTitle()%></td>
            <td><img width="50" height="50" class='cart_img' src='../DataWeb/<%=p.getImage()%>'></td>

            <td><%=p.getPrice()%></td>
            <td><%=p.getPrice()+"/"+p.getUnitPrice()+p.getUnit()%></td>
            <td><a href="edit_products.jsp?id=<%=p.getId()%>" class='text-dark'><i class=" bi bi-pencil-square"> </i></a></td>
            <td><a href="../delete?id=<%=p.getId()%>" class='text-dark'><i class="bi bi-trash"></i></a></td>
        <%
            }
            }
        %>
        </tr>

  </tbody>
    </table>
    <nav aria-label="...">
        <ul class="pagination pb-5 justify-content-center">
            <li class="page-item  <%= (activePage==1)?"disabled":"enable"%>">
                <a class="page-link" href="list-products.jsp?page=<%= previousPage %>" aria-label="Previous">
                    <i class="bi-arrow-left"></i>
                </a>
            </li>
            <% for (int i = 1; i <= totalPage; i++) { %>
            <li class="page-item <%= (i == activePage) ? "active" : "" %>">
                <a class="page-link" href="list-products.jsp?page=<%= i %>"><%= i %></a>
            </li>
            <% } %>
            <li class="page-item <%= (activePage==totalPage)?"disabled":"enable"%>">
                <a class="page-link" href="list-products.jsp?page=<%= nextPage %>" aria-label="Next">
                    <i class="bi-arrow-right"></i>
                </a>
            </li>
        </ul>

    </nav>
</div>

</body>
</html>