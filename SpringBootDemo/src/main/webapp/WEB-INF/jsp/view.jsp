<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <title>User Dashboard</title>
    <style>
        *{
            padding: 0;
            margin: 0;
            box-sizing: border-box;
        }
        .main-wrapper{
            width: 100%;
            height: 100vh;
        }
        header{
            color: #fff;
            display: flex;
            align-items: center;
            flex-direction: row;
            justify-content:space-between;
            background-color: #726abf;
            padding: 1%;
        }
        h1{
            color: #fff;
            text-align: center;
            margin-left: 6%;
        }
        .menu-bar{
            display: flex;
            flex-direction: row;
            margin-right: 6%;
        }
        .profile{
            margin-right: 15px;
            /* height: 40px; */
            width: 70px;
            display: flex;
            align-items: center;
            justify-content: center;
            font-size: 24px;
            background-color: #000;
            border-radius: 50%;
        }

        .logout-button{
            padding: 10%;
            background-color: #573b8a;
            border: none;
            border-radius: 25%;
        }
        .menu-item{
            text-decoration: none;
            color: #fff;

        }
        .content-area{
            width: 90%;
            height: 85%;
            margin: 2% auto;
            display: flex;
            flex-direction: row;
            justify-content:space-between;
        }
        .image-area{
            width: 45%;

        }
        .content-image{
            width: 100%;
            height: 100%;
            border-radius: 3%;
        }
        .details-area{
            width: 50%;
        }
        .form-section{
            display: flex;
            flex-direction: column;
            justify-content: center;

        }
        .trackId-entry{
            height: 50px;
            width: 550px;
            margin: 6% auto;
            font-size: 24px;
        }
        .track-button{
            width: 150px;
            padding: 2%;
            border: none;
            border-radius: 5%;
            margin: 0 auto;
            color: #fff;
            background-color: #000;
            border: none;
        }
        .details{
            height: 65%;
            width: 80%;
            margin: 5% auto;
            display: flex;
            flex-direction: column;
            justify-content: center;
            border-radius: 5%;
            background-color: #726abf;
        }
        .details-items{
            margin: 2% auto;
            font-size: 24px;
            color:#fff;
        }
    </style>
</head>
<body>

    <div class="main-wrapper">
        <header>
            <h1 >Tracker</h1>
            <div class="menu-bar">
                <div class="profile">
                    ${User_Name}
                </div>
                <button class="logout-button">
                    <a class = "menu-item" href="<c:url value='/logout' />">LOGOUT</a>
                </button>
            </div>
        </header>
        <div class="content-area">
            <div class="image-area">
                <img class="content-image" src="https://images.pexels.com/photos/1051077/pexels-photo-1051077.jpeg" alt="imagesection">
            </div>
            <div class="details-area">
                <form class="form-section" action="trackitem" method="post">
                    <input type="text" name="trackid" class="trackId-entry" required>
                    <input class = "track-button" type="submit" value="Track..">
                </form>
                <div class="details">
                    <h3 class="details-items">${itemName}</h3>
                    <h3 class="details-items">${source}</h3>
                    <h3 class="details-items">${location}</h3>
                    <h3 class="details-items">${destination}</h3>
                    <h3 class="details-items">${orderDate}</h3>
                    <h3 class="details-items">${estimatedDate}</h3>
                    <h3 class="details-items">${error}</h3>
                </div>
            </div>
        </div>

    </div>


</body>
</html>