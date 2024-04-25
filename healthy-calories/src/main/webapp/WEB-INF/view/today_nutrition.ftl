<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add a Dish Page</title>
    <link rel="stylesheet" href="/resources/css/today_nutrition.css">
    <script src="/resources/js/today_nutrition.js"></script>
</head>
<body>

    <#include "menu.ftl">

    <div class="container">

        <div class="dish-select">

            <button class="add-dish-button">+ Add a dish</button>

            <div class="select-box">

                <div class="select-option">
                    <input type="text" id="dishValue" readonly  placeholder="Enter a dish name">
                </div>

                <div class="content">

                    <div class="search">
                        <input type="text" id="optionSearch" placeholder="Search">
                    </div>

                    <ul class="options"></ul>


                </div>

            </div>

            <div class="weight-option">
                <input type="number" id="weight-input" placeholder="Enter the number of grams" min="0" max="999">
            </div>

        </div>

        <div id="dishContainer"></div>

    </div>

</body>
</html>
