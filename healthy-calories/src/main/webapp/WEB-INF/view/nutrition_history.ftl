<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add a Dish Page</title>
    <link rel="stylesheet" href="/resources/css/nutrition_history.css">
    <script src="/resources/js/nutrition_history.js"></script>
</head>
<body>
<#include "menu.ftl">
<div class="container">
    <form>
        <label for="selectDate">Choose a date you want</label>
        <select id="selectDate" name="selectDate">
            <option disabled selected value>Choose a day</option>
            <!-- Варианты выбора с использованием JavaScript -->
        </select>
    </form>

    <script>
        // Получаем текущую дату
        var currentDate = new Date();

        // Заполняем список последними 7 днями
        for (var i = 0; i < 7; i++) {
            var optionDate = new Date(currentDate);
            optionDate.setDate(currentDate.getDate() - i);

            var option = document.createElement('option');
            option.value = i; // Преобразуем дату в строку формата YYYY-MM-DD
            option.text = optionDate.toLocaleDateString('en-US', { month: 'long', day: 'numeric' });
            //option.text = optionDate.toLocaleDateString('en-US', { weekday: 'long', year: 'numeric', month: 'long', day: 'numeric' });

            document.getElementById('selectDate').appendChild(option);
        }
        cards = null
    </script>

    <div id="dishContainer"></div>

<#--    <div class="dish-card">
        <img class="dish-image" src="your-image-url.jpg" alt="Dish Image">
        <div class="dish-info">
            <div class="dish-title">${card.name}</div>
            <div class="dish-calories">${card.caloriesNumber}</div>
        </div>
    </div>
-->



</div>
</div>
</body>
</html>
