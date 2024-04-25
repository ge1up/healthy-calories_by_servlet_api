document.addEventListener('DOMContentLoaded', async function () {
    let url = "http://localhost:8080/foods/get"
    console.log(url)
    let backend = await fetch(url).then(response => {
        return response.json();
    })
    console.log(backend)
    const liOptions = document.getElementsByClassName('options')[0];
    backend.forEach(function (food) {
        let elem = document.createElement('li')
        elem.textContent = food.name;
        liOptions.appendChild(elem);
    })

    const selectBox = document.querySelector('.select-box')
    const selectOption = document.querySelector('.select-option')
    let dishValue = document.querySelector('#dishValue')
    const optionSearch = document.querySelector('#optionSearch')
    const options = document.querySelector('.options')
    const optionsList = document.querySelectorAll('.options li')

    selectOption.addEventListener('click', function () {
        selectBox.classList.toggle('active');
    });

    optionsList.forEach(function (optionsListSingle) {
        optionsListSingle.addEventListener('click', function () {
            text = this.textContent;
            dishValue.value = text;
            optionSearch.value = '';
            li = options.getElementsByTagName('li')
            for (i = 0; i < li.length; i++) {
                li[i].style.display = ''
            }
            selectBox.classList.remove('active');
        })
    });

    optionSearch.addEventListener('keyup', function () {
        var filter, li, i, textValue;
        filter = optionSearch.value.toUpperCase();
        li = options.getElementsByTagName('li')
        for (i = 0; i < li.length; i++) {
            liCount = li[i];
            textValue = liCount.textContent || liCount.innerText;
            if(textValue.toUpperCase().indexOf(filter) > -1) {
                li[i].style.display = ''
            } else {
                li[i].style.display = 'none';
            }
        }
    })

    const addButton = document.getElementsByClassName('add-dish-button')[0]
    let weightParam = document.getElementById('weight-input')

    addButton.addEventListener('click', async function () {

        if (dishValue.value == '') {
            console.log("nooooooooo")
            //обработка ошибки
            return;
        }
        weightParam.value = parseInt(weightParam.value)
        if (weightParam.value > 0 && weightParam.value < 1000
            && !isNaN(weightParam.value) && !weightParam.value.includes('.')) {

            url = "http://localhost:8080/nutrition_history"

            let data = {
                foodName: dishValue.value,
                weight: weightParam.value
            }

            const fetchOptions = {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                    // Дополнительные заголовки, если необходимо
                },
                body: JSON.stringify(data) // Преобразование данных в JSON
            };
            console.log(data)

            await fetch(url, fetchOptions);

            await getHistory();

        } else {
            console.log("no2no2no2")
            // обработка ошибки
        }

    });

    async function getHistory() {
        url = "http://localhost:8080/nutrition_history/get?day=0"
        console.log(url)
        backend = await fetch(url).then(response => {
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
    }

    getHistory();

});