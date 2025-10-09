<html>
<head>
    <link rel="stylesheet" href="/webjars/bootstrap/5.3.3/css/bootstrap.min.css">
</head>
<body>

 <div class="container mt-5">

    <h2>Create Car</h2>

    <form action="/create-car" method="post">

        <div class="mb-3" >
            <label class="form-label">Name</label>
            <input class="form-control" type="text" name="car-name" id="car-name" value="${param.name}">
            <input type="hidden" id="id" name="id" value="${param.id}">
        </div>

         <div class="mb-3" >
            <label class="form-label">Color</label>
            <input class="form-control" type="text" name="color" id="color" value="${param.name}">
        </div>


        <button type="submit" class="btn btn-primary" >Save</button>

    </form>



</div>

<script src="/webjars/jquery/3.7.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/5.3.3/js/bootstrap.bundle.min.js"></scr

</body>
</html>