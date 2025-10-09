<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="/webjars/bootstrap/5.3.3/css/bootstrap.min.css">
    <title>Dashboard</title>
</head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
</head>
<body>

        <div class="container mt-5">
      <div>
        <h1>Cars</h1>
        <table class="table table-striped">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Options</th>
            </tr>
            <c:forEach var="car" items="${cars}">
                <tr>
                    <td>${car.id}</td>
                    <td>${car.name}</td>
                    <td>
                        <form action="/delete-car" method="post">
                            <input type="hidden" id="id" name="id" value="${car.id}">
                            <button type="submit" class="btn btn-danger btn-sm" >Delete</button>
                            <a href="index.jsp?id=${car.id}&name=${car.name}" class="btn btn-info btn-sm">Update</a>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
      </div>

  </div>

  <script src="/webjars/jquery/3.7.1/jquery.min.js"></script>
  <script src="/webjars/bootstrap/5.3.3/js/bootstrap.bundle.min.js"></scr

</body>
</html>