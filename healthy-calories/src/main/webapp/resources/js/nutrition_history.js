document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('selectDate').addEventListener('change', async function (event) {
        let selectedDate = event.target.value;
        console.log('Выбрана дата:', selectedDate);
        let encodedDate = encodeURIComponent(selectedDate);
        let url = `http://localhost:8080/nutrition_history/get?day=${encodedDate}`
        console.log(url)
        let backend = await fetch(url).then(response => {
            return response.json();
        })
        console.log(backend)
        document.getElementById('dishContainer').innerHTML = '';
        totalWeight = 0;
        totalCalories = 0;
        totalProteins = 0;
        totalCarbohydrates = 0;
        totalFats = 0;

        backend.forEach(function (card) {
            totalWeight += card.weight;
            totalCalories += card.caloriesNumber;
            totalProteins += card.proteinsNumber;
            totalCarbohydrates += card.carbohydratesNumber;
            totalFats += card.fatsNumber;
        });

        const dishCard = document.createElement('div');
        dishCard.classList.add('dish-card');

        const dishInfo = document.createElement('div');
        dishInfo.classList.add('dish-info');

        const dishTitle = document.createElement('div');
        dishTitle.classList.add('dish-total-title');
        dishTitle.classList.add('dish-title');
        dishTitle.textContent = 'Total';

        const dishOptions = document.createElement('div');
        dishOptions.classList.add('dish-options');

        const dishWeight = document.createElement('div');
        dishWeight.classList.add('dish-option');
        dishWeight.textContent = 'Weight: ' + totalWeight;

        const dishCalories = document.createElement('div');
        dishCalories.classList.add('dish-option');
        dishCalories.textContent = 'Calories: ' + totalCalories;

        const dishProteins = document.createElement('div');
        dishProteins.classList.add('dish-option');
        dishProteins.textContent = 'Proteins: ' + totalProteins;

        const dishCarbohydrates = document.createElement('div');
        dishCarbohydrates.classList.add('dish-option');
        dishCarbohydrates.textContent = 'Carbohydrates: ' + totalCarbohydrates;

        const dishFats = document.createElement('div');
        dishFats.classList.add('dish-option');
        dishFats.textContent = 'Fats: ' + totalFats;

        // Собираем структуру карточки
        dishInfo.appendChild(dishTitle);

        dishOptions.appendChild(dishWeight)
        dishOptions.appendChild(dishCalories);
        dishOptions.appendChild(dishProteins);
        dishOptions.appendChild(dishCarbohydrates);
        dishOptions.appendChild(dishFats);

        dishInfo.appendChild(dishOptions)
        dishCard.appendChild(dishInfo);

        document.getElementById('dishContainer').appendChild(dishCard);

        backend.forEach(function (card) {

            const dishCard = document.createElement('div');
            dishCard.classList.add('dish-card');

            const dishImage = document.createElement('img');
            dishImage.classList.add('dish-image');
            dishImage.src = `/resources/img/${card.foodName}.jpg`;
                dishImage.alt = 'Dish Image';

            const dishInfo = document.createElement('div');
            dishInfo.classList.add('dish-info');

            const dishTitle = document.createElement('div');
            dishTitle.classList.add('dish-title');
            dishTitle.textContent = card.foodName;

            const dishOptions = document.createElement('div');
            dishOptions.classList.add('dish-options');

            const dishWeight = document.createElement('div');
            dishWeight.classList.add('dish-option');
            dishWeight.textContent = 'Weight: ' + card.weight;

            const dishCalories = document.createElement('div');
            dishCalories.classList.add('dish-option');
            dishCalories.textContent = 'Calories: ' + card.caloriesNumber;

            const dishProteins = document.createElement('div');
            dishProteins.classList.add('dish-option');
            dishProteins.textContent = 'Proteins: ' + card.proteinsNumber;

            const dishCarbohydrates = document.createElement('div');
            dishCarbohydrates.classList.add('dish-option');
            dishCarbohydrates.textContent = 'Carbohydrates: ' + card.carbohydratesNumber;

            const dishFats = document.createElement('div');
            dishFats.classList.add('dish-option');
            dishFats.textContent = 'Fats: ' + card.fatsNumber;

            // Собираем структуру карточки
            dishInfo.appendChild(dishTitle);

            dishOptions.appendChild(dishWeight)
            dishOptions.appendChild(dishCalories);
            dishOptions.appendChild(dishProteins);
            dishOptions.appendChild(dishCarbohydrates);
            dishOptions.appendChild(dishFats);

            dishInfo.appendChild(dishOptions)

            dishCard.appendChild(dishImage);
            dishCard.appendChild(dishInfo);

            // Добавляем карточку в контейнер
            document.getElementById('dishContainer').appendChild(dishCard);
        });
    });
});

