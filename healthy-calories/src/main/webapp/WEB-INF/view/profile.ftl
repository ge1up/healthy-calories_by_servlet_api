<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Профиль</title>
    <link rel="stylesheet" href="/resources/css/profile.css">
</head>
<body>

<div class="container">
    <#include "menu.ftl">
    <div class="center-content">
        <div class="profile-container">
            <#--            <div class="title">Профиль</div>-->
            <div id="profile" class="white-container">

                <div class="profile-info">

                    <img style="width: 200px; height: 200px" class="user-avatar" alt="IMAGE"
                         src="/resources/img/user_default.png"/>

                    <div class="user-info-text">
                        <div class="user-info">Name: ${user.name}</div>
                        <div class="user-info">Surname: ${user.surname}</div>
                        <div class="user-info">Date of birth: ${user.date}</div>
                        <div class="user-info">Height: ${user.height}</div>
                        <div class="user-info">Weight: ${user.weight}</div>
                    </div>

                </div>

                <div class="settings-buttons">

                    <button class="change-button">
                        <a style="text-decoration: none; color: white" href="/account-change">Edit a profile</a>
                    </button>

                    <form method="POST" action="/sign-out">
                        <button class="sign-out-button" type="submit">Sign out</button>
                    </form>

                    <form method="POST" action="/account-delete">
                        <button class="delete-button" type="submit">Delete an account</button>
                    </form>

                </div>

            </div>

            <div id="favorite_dish">
                <h1>Favorite Dish</h1>
            </div>

        </div>
    </div>
</div>

</body>
</html>