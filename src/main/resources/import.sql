INSERT INTO Driver (tribe_number, name, birth_date, mother_name) VALUES (111111, 'Kis Jenő', DATE '2000-12-17', 'Nagy Piroska');
INSERT INTO Driver (tribe_number, name, birth_date, mother_name) VALUES (222222, 'Kovács István', DATE '1980-03-25' ,'Lapos Julianna');

INSERT INTO  Car (registration_number, brand, model, color, engine_number, passenger_car, driver_tribe_number) VALUES ( 'ABC-345', 'HONDA', 'Civic', 'blue', 'asdfghj', true, 111111);
INSERT INTO  Car (registration_number, brand, model, color, engine_number, passenger_car, driver_tribe_number) VALUES ( 'PUS-111', 'VOLKSWAGEN', 'Passat', 'white', 'thisisenginenumber', true, 111111);
INSERT INTO  Car (registration_number, brand, model, color, engine_number, passenger_car, driver_tribe_number) VALUES ( 'RIT-123', 'AUDI', 'A3', 'yellow', '654678', true, NULL);
INSERT INTO  Car (registration_number, brand, model, color, engine_number, passenger_car, driver_tribe_number) VALUES ( 'SQL-999', 'DODGE', 'Journey', 'black', '78946dfs746s', false, NULL);