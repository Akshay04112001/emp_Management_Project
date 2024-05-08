<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
        crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
    <link rel="stylesheet" href="cs.css">
    <style>
    body {
        background-color: chocolate; 
    }
    header, footer {
        background-color: brown; 
        padding: 10px; 
    }
    .container-img {
        width: 100px;
        height: 70px;
    }
    .container-img img {
        width: 120%;
        height: 70px;
    }
    </style>
</head>
<body>

<header>
    <div class="container-img">
        <img src="Com.png" alt="Italian Trulli" align="left">
    </div>
</header>

<form action="N" method="post">
    <div class="header"></div>
    <div class="container">
        <div class="form" align="center">
            <h1>Login</h1>
            <hr>
            <div class="form-check1" align="center">
                <input class="form-check1-input" type="radio" name="exampleRadios" id="exampleRadios1" value="option1">
                <label class="form-check1-label" for="exampleRadios1"> Admin Login </label>
                <br><br>
            </div>
            <div class="form-check2" align="center">
                <input class="form-check2-input" type="radio" name="exampleRadios" id="exampleRadios2" value="option2">
                <label class="form-check2-label" for="exampleRadios2"> Trainer Login </label>
            </div>
            <br>
            <div class="form-check3" align="center">
                <input class="form-check3-input" type="radio" name="exampleRadios" id="exampleRadios3" value="option3">
                <label class="form-check3-label" for="exampleRadios3"> Trainee Login </label>
            </div>
            <br><br>
            <input class="btn btn-primary" type="submit" value="Submit">
        </div>
    </div>
</form>
 
<footer>
    <p>@CopyrightByAkshay2024</p>
    <p><%= new java.util.Date() %></p>
</footer>
</body>
</html>