<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        .form-container {
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            width: 300px;
        }

        .form-container label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
        }

        .form-container input {
            width: 100%;
            padding: 8px;
            margin-bottom: 16px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .form-container button {
            background-color: #4caf50;
            color: #fff;
            padding: 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            width: 100%;
        }

        #type_of_food {
            width: 150px;
            padding: 8px;
            margin-bottom: 16px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-family: Arial, sans-serif;
        }
    </style>
</head>
<body>

<div class="form-container">

    <h2>Registration Form</h2>

    <form method="post">

        <label for="name">Name</label>
        <input type="text" id="name" name="name" required>

        <label for="surname">Surname</label>
        <input type="text" id="surname" name="surname" required>

        <label for="date">Date of birth</label>
        <input type="date" id="date" name="date" required>

        <label for="height">Height</label>
        <input type="number" id="height" name="height" required>

        <label for="weight">Weight</label>
        <input type="number" id="weight" name="weight" required>

        <label for="type_of_food">Type of food</label>
        <select id="type_of_food" name="food_type">
            <option value="0">Vegetarian</option>
            <option value="1">Vegan</option>
            <option value="2">Raw food eater</option>
        </select>

        <label for="email">Email</label>
        <input type="email" id="email" name="email" required>

        <label for="password">Password</label>
        <input type="password" id="password" name="password" required>

        <button type="submit">Edit</button>

    </form>

</div>

</body>

</html>
