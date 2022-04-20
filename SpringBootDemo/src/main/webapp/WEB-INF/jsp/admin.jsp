<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <title>Admin Dashboard</title>
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
            i{
                color: #000;
            }
            .menu-item{
                text-decoration: none;
                color: #fff;

            }
            .options-area{
                height: 70px;
                display: flex;
                align-items: center;
                justify-content:flex-end;
            }
            .options-tag{
                margin-right: 5%;
            }
            .option-items{
                text-decoration: none;
                color: #000;
                margin-left: 5px;
            }
            .contents-table{
                width: 80%;
                height: 80vh;
                margin: 1% auto;
                border: solid 2px black;
                /* justify-content: space-evenly; */

            }
            .table-heading-row{
                /* width: 100%; */
                /* display: flex; */
                padding: 10px;
                height:50px;
                background-color: grey;
                font-weight: bold;
                /* justify-content: space-evenly; */
                /* justify-content:space-between; */

            }
            table
            {
                width:100%;
                background-color: #dedcef;
            }
            td
            {
                margin: 0 2%;
                height: 20px;
                text-align: center;
            }
            .table-data
            {
                height:50px;
                margin:auto;
            }
    </style>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" />
</head>
<body>
    <div class="main-wrapper">
        <header>
            <h1 >Tracker</h1>
            <div class="menu-bar">
                <div class="profile">
                    A
                </div>
                <button class="logout-button">
                    <a class = "menu-item" href="<c:url value='/logout' />">LOGOUT</a>
                </button>
                <!-- <h3><a class = "menu-items" href="<c:url value='/additem' />">ADD NEW ITEM</a></h3>
                <h3><a class = "menu-items" href="<c:url value='/edititem' />">EDIT ITEM</a></h3> -->
                <!-- <h3><a class = "menu-items" href="<c:url value='/logout' />">LOGOUT</a></h3> -->
            </div>
        </header>
        <div class="options-area">
            <i class="fa-solid fa-plus options-tag" > <a class = "option-items" href="<c:url value='/additem' />">ADD ITEM</a></i>
            <i class="fa-solid fa-pen-to-square options-tag"><a class = "option-items" href="<c:url value='/edititem' />">EDIT ITEM</a></i>
        </div>
        <div class="contents-table">
            <table>
                <tr class="table-heading-row">
                    <td class="table-heading">USERNAME</td>
                    <td class="table-heading">TRACKING ID</td>
                    <td class="table-heading">NAME</td>
                    <td class="table-heading">SOURCE</td>
                    <td class="table-heading">DESTINATION</td>
                    <td class="table-heading">LOCATION</td>
                    <td class="table-heading">ORDER DATE</td>
                    <td class="table-heading">ESTIMATED DATE</td>
                </tr>
                <c:forEach items="${itemlist}" var="item">
                    <tr>
                        <td class="table-data"><c:out value="${item.userName}"/></td>
                        <td class="table-data"><c:out value="${item.tracking_id}"/></td>
                        <td class="table-data"><c:out value="${item.name}"/></td>
                        <td class="table-data"><c:out value="${item.source}"/></td>
                        <td class="table-data"><c:out value="${item.destination}"/></td>
                        <td class="table-data"><c:out value="${item.location}"/></td>
                        <td class="table-data"><c:out value="${item.orderDate}"/></td>
                        <td class="table-data"><c:out value="${item.estimatedDate}"/></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>