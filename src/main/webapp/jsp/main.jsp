<%--
  Created by IntelliJ IDEA.
  User: panda
  Date: 21.1.18
  Time: 21.40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>SppLab2</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <link href="css/dopstyle.css" rel="stylesheet">
    <script src="js/main.js"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<c:if test="${ (empty userList) && (empty errorUserListIsEmpty) }">
    <script language="JavaScript" type="text/javascript">
        location = "spp?command=show_users"
    </script>
</c:if>
<c:import url="header.jsp"/>
<div class="container">
    <div class="row">

        <div class="col-md-offset-1 col-md-10 col-sm-12  col-xs-12 main">
            <h2>SppLab2</h2>
            <br>
            <c:if test="${not empty errorUserListIsEmpty}">
                <div class="alert-danger alert"><c:out value="${errorUserListIsEmpty}"/></div>

            </c:if>
            <c:if test="${not empty userList}">
                <div class="table-responsive">
                    <table class="table table-hover table-style">
                        <thead>
                        <tr>
                            <th>Login</th>
                            <th>Email</th>
                            <th>First name</th>
                            <th>Last name</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${userList}" var="user" varStatus="status">

                            <tr>
                                <td><c:out value="${ user.login }"/></td>
                                <td><c:out value="${user.email}"/></td>
                                <td><c:out value="${ user.firstName }"/></td>
                                <td><c:out value="${ user.lastName }"/></td>

                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:if>
        </div>
    </div>
</div>
<c:import url="footer.jsp"/>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>


