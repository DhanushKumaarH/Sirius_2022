<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
    <title>Document</title>
    <link href="https://fonts.googleapis.com/css2?family=Jost:wght@500&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="../css/signup.css">
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"
                    integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
                    crossorigin="anonymous">
    </script>
    <style>
        body
        {
            display: flex;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
            font-family: 'Jost', sans-serif;
            background: linear-gradient(to bottom, #726abf, #6e66b9, #595995);
        }

        .main
        {
            width: 500px;
            height: 600px;
            overflow: hidden;
            border-radius: 10px;
            box-shadow: 0px 0px 10px #000;
        }

        .wrapper
        {
            width:100%;
            height:100%;
        }

        label{
            color: #fff;
            font-size: 2.3em;
            justify-content: center;
            display: flex;
            margin: 40px;
            font-weight: bold;
        }

        .error
        {
            display: flex;
            justify-content: center;
            font-size: 20px;
            color: darkgray;
        }

        input,select
        {
            width: 60%;
            height: 20px;
            background: #e0dede;
            display: flex;
            margin: 25px auto;
            padding: 10px;
            border: none;
            outline: none;
            border-radius: 5px;
        }
        select
        {
            height:40px;
            width:65%;
        }
        button{
            width: 65%;
            height: 40px;
            margin: 10px auto;
            display: block;
            color: #fff;
            background: #573b8a;
            font-size: 1em;
            font-weight: bold;
            margin-top: 20px;
            outline: none;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <div class="main">
        <div class="wrapper">
            <form action="login" method="post">
                <label aria-hidden="true">Login</label>
                <h2 class="error">${errorMsg}</h2>
                <input type="text" name="uname" placeholder="User name" required>
                <input type="password" name="upass" placeholder="password"required>
                <select name="role" id="role">
                    <option> -- SELECT ROLE -- </option>
                    <option value="admin">Admin</option>
                    <option value="user">User</option>
                </select>
                <button type="submit">Login</button>
                <button id="redirect">Sign Up</button>
            </form>
        </div>
    </div>

</body>
<script type="text/javascript">
    $('#redirect').click(function(){
           window.location.href="/register"
    });
</script>
</html>