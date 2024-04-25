create extension if not exists "uuid-ossp";

create table users
(
    uuid      uuid primary key default uuid_generate_v4(),
    name      varchar(30),
    surname   varchar(30),
    date      date check ( date < current_date ),
    height    smallint check ( height < 260 ),
    weight    smallint check ( weight < 500 ),
    food_type smallint check ( food_type between 0 and 2),
    email     varchar(255),
    password  varchar(96)
);

create table foods
(
    uuid                 uuid primary key default uuid_generate_v4(),
    name                 varchar(50) unique,
    calories_number      smallint check ( calories_number between 10 and 1000),
    proteins_number      smallint check ( proteins_number between 1 and 50),
    carbohydrates_number smallint check ( carbohydrates_number between 1 and 80),
    fats_number          smallint check ( fats_number between 1 and 95 and
                                          (fats_number + foods.carbohydrates_number + foods.proteins_number) < 100 ),
    food_type            smallint check ( food_type between 0 and 2)
);

create table eaten_foods
(
    uuid         uuid primary key default uuid_generate_v4(),
    user_id      uuid references users (uuid),
    food_id      uuid references foods (uuid),
    weight       smallint check ( weight between 1 and 999),
    created_date date             default current_date
)