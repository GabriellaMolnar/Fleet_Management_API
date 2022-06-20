INSERT INTO Driver (tribe_number, name, birth_date, mother_name) VALUES (111111, 'Kis Jenő', DATE '2000-12-17', 'Nagy Piroska');
INSERT INTO Driver (tribe_number, name, birth_date, mother_name) VALUES (222222, 'Kovács István', DATE '1980-03-25' ,'Lapos Julianna');

INSERT INTO Depot (address, depot_name) VALUES ('Kiskunfélegyháza Fő utca 2. ', 'Our main depot');

INSERT INTO  Car (registration_number, brand, model, color, engine_number, passenger_car, driver_tribe_number, depot_id) VALUES ( 'ABC-345', 'HONDA', 'Civic', 'blue', 'asdfghj', true, 111111, 1);
INSERT INTO  Car (registration_number, brand, model, color, engine_number, passenger_car, driver_tribe_number, depot_id) VALUES ( 'PUS-111', 'VOLKSWAGEN', 'Passat', 'white', 'thisisenginenumber', true, 111111, 1);
INSERT INTO  Car (registration_number, brand, model, color, engine_number, passenger_car, driver_tribe_number, depot_id) VALUES ( 'RIT-123', 'AUDI', 'A3', 'yellow', '654678', true, NULL, 1);
INSERT INTO  Car (registration_number, brand, model, color, engine_number, passenger_car, driver_tribe_number, depot_id) VALUES ( 'SQL-999', 'DODGE', 'Journey', 'black', '78946dfs746s', false, NULL, 1);

INSERT INTO car_value (car_id, entry_date, gross_value, planned_end_of_life, price_end_of_life) VALUES (1, DATE '2020-06-01', 20000000, DATE '2024-06-01', 4000000);
INSERT INTO car_value (car_id, entry_date, gross_value, planned_end_of_life, price_end_of_life) VALUES (2, DATE '2020-01-01', 15000000, DATE '2024-01-01', 3000000);

