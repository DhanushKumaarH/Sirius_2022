<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
    <title>Document</title>
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
            width: 600px;
            height: 500px;
            padding: 100px 0;
            overflow: hidden;
            border-radius: 10px;
            box-shadow: 0px 0px 10px #000;
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
        <form action="edititem" method="post">
            <label aria-hidden="true">EDIT ITEM</label>
            <input type="text" name="trackid" placeholder="Trackid" required>
            <input type="text" name="location" placeholder="Location" required>
            <button type="submit">EDIT</button>
            <button id="redirect">BACK</button>
        </form>
    </div>
    <script type="text/javascript">
        $('#redirect').click(function(){
               window.location.href="/admin"
        });
    </script>
</body>
</html>
