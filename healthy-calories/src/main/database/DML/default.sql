insert into foods (uuid, name, calories_number, proteins_number, carbohydrates_number, fats_number, food_type)
values ('7bba333d-0744-4718-8ee4-d20694e461b2', 'Curd', 120, 15, 3, 18, 0),
       ('b6f424fa-eff3-45ce-b7ee-af729dd0b032', 'Almond', 576, 20, 13, 50, 2);

insert into foods (name, calories_number, proteins_number, carbohydrates_number, fats_number, food_type)
values ('Buckwheat', 330, 13, 57, 3, 2),
       ('Pumpkin puree soup', 50, 1, 5, 3, 1),
       ('Lentil', 295, 24, 46, 1, 2),
       ('Yogurt', 57,  4, 6, 1, 0),
       ('Apple juice', 46, 1, 10, 1),
       ('Chocolate', 539, 6, 48, 35);


insert into users (uuid, name, surname, date, height, weight, food_type, email, password)
values ('ff2c6f13-0b83-48e6-83ae-c9d9cb371975', 'Eldar', 'Bilalov', '20.02.2004', 183, 78, 0, '1@1', 123),
       ('cc0701f2-38e0-4a01-8cbb-625416e3c8c2', 'Admin', 'Admin', '07.07.1777', 250, 120, 2, '2@2', 123);

insert into eaten_foods (user_id, food_id, weight)
values ('ff2c6f13-0b83-48e6-83ae-c9d9cb371975', '7bba333d-0744-4718-8ee4-d20694e461b2', 100),
       ('cc0701f2-38e0-4a01-8cbb-625416e3c8c2', 'b6f424fa-eff3-45ce-b7ee-af729dd0b032', 200);
