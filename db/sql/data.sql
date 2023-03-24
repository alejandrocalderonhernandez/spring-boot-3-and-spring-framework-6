INSERT INTO hotel (name, address, rating, price) VALUES
                                                     ('El dorado', 'Grecia 21', 5, 70.05),
                                                     ('El mirador', 'Grecia 98', 4, 100.45),
                                                     ('La Odisea', 'Grecia 99', 5, 220.00),
                                                     ('Olimpo', 'Grecia 29', 5, 221.21),
                                                     ('Atenea', 'Grecia 43', 2, 56.43),
                                                     ('ice and fire', 'Icelandia 49', 3, 23.43),
                                                     ('Sky lights', 'Icelandia 98', 5, 130.45),
                                                     ('Vikings', 'Icelandia 01', 5, 99.99),
                                                     ('Dark ocean', 'Icelandia 100', 2, 199.99),
                                                     ('Nordic', 'Icelandia 300', 3, 109.99),
                                                     ('Cactus', 'Mexico 53', 4, 10.88),
                                                     ('Los chiles', 'Mexico 9', 3, 21.19),
                                                     ('Reforma', 'Mexico 922', 1, 33.33),
                                                     ('Catrina', 'Mexico 88', 5, 22.87),
                                                     ('Tequila', 'Mexico 348', 5, 32.42),
                                                     ('The lake', 'Canada 22', 5, 63.54),
                                                     ('Cascade', 'Canada 89', 4, 22.99),
                                                     ('Pino', 'Canada 38', 4, 99.42);

insert into fly (origin_lat, origin_lng, destiny_lng, destiny_lat, origin_name, destiny_name, aero_line, price) VALUES
                                                                                                                    (99.9999, 88.8888, 11.1111, 22.2222, 'Mexico', 'Grecia', 'aero_gold', 43.00),
                                                                                                                    (11.1111, 22.2222, 99.9999, 88.8888, 'Grecia', 'Mexico','aero_gold', 33.33),
                                                                                                                    (99.9999, 88.8888, 88.8888, 77.7777, 'Mexico', 'Iceland', 'aero_gold', 48.70),
                                                                                                                    (99.9999, 88.8888, 88.8888, 77.7777, 'Iceland', 'Mexico', 'aero_gold', 12.99),
                                                                                                                    (88.8888, 77.7777,  11.1111, 22.2222, 'Iceland', 'Gracia', 'aero_gold', 85.98),
                                                                                                                    (11.1111, 22.2222, 88.8888, 77.7777, 'Gracia', 'Iceland', 'aero_gold', 29.99),
                                                                                                                    (99.9999, 88.8888, 11.1111, 22.2222, 'Mexico', 'Grecia', 'blue_sky', 25.65),
                                                                                                                    (11.1111, 22.2222, 99.9999, 88.8888, 'Grecia', 'Mexico', 'blue_sky', 12.99),
                                                                                                                    (44.4444, 55.555,  11.1111, 22.2222, 'Canada', 'Mexico', 'aero_gold', 19.99),
                                                                                                                    (11.1111, 22.2222, 44.4444, 55.5555, 'Mexico', 'Canada', 'aero_gold', 15.65),
                                                                                                                    (99.9999, 88.8888, 88.8888, 77.7777, 'Mexico', 'Iceland', 'blue_sky', 42.99),
                                                                                                                    (99.9999, 88.8888, 88.8888, 77.7777, 'Iceland', 'Mexico', 'blue_sky', 21.54),
                                                                                                                    (88.8888, 77.7777,  11.1111, 22.2222, 'Iceland', 'Gracia', 'blue_sky', 12.00),
                                                                                                                    (44.4444, 55.555,  11.1111, 22.2222, 'Canada', 'Mexico', 'blue_sky', 16.99),
                                                                                                                    (11.1111, 22.2222, 44.4444, 55.5555, 'Mexico', 'Canada', 'blue_sky', 14.65);

insert into customer (dni, full_name, credit_card, total_flights, total_lodgings, total_tours, phone_number) VALUES
                                                                                                                 ('VIKI771012HMCRG093', 'Ragnar Lothbrok', '6473-9486-9372-0921', 0, 0, 0, '33-74-58-43'),
                                                                                                                 ('BBMB771012HMCRR022', 'Walter White', '4463-3326-9980-5454', 0, 0, 0, '55-83-32-22'),
                                                                                                                 ('WALA771012HCRGR054', 'Wednesday Addams', '6677-5244-94572-0165', 0, 0, 0, '33-24-41-54'),
                                                                                                                 ('GOTW771012HMRGR087', 'Khal Drogo', '6766-9484-9442-0222', 0, 0, 0, '55-78-33-11');

insert into reservation (id, date_reservation,  hotel_id, customer_id, date_start, date_end, total_days, price) VALUES
                                                                                                                    ('12345678-1234-5678-1234-567812345678', now(), 1, 'BBMB771012HMCRR022', '2024-08-01', '2020-01-07', 7, 77.00),
                                                                                                                    ('22345678-1234-5678-1234-567812345678', now(), 2, 'VIKI771012HMCRG093', '2024-08-01', '2020-01-07', 7, 22.00),
                                                                                                                    ('32345678-1234-5678-1234-567812345678', now(), 3, 'VIKI771012HMCRG093', '2024-08-01', '2024-08-01', 4, 112.00),
                                                                                                                    ('52345678-1234-5678-1234-567812345678', now(), 3, 'VIKI771012HMCRG093', '2024-08-12', '2020-01-14', 2, 74.00);

insert into ticket (id, price, fly_id, customer_id, departure_date, arrival_date, purchase_date) VALUES
                                                                                                     ('12345678-1234-5678-2236-567812345678', 330.05, 1, 'BBMB771012HMCRR022', '2024-08-01 14:00:00', '2024-08-01 16:00:00',now()),
                                                                                                     ('22345678-1234-5678-3235-567812345678', 220.33, 1, 'VIKI771012HMCRG093', '2024-08-01 14:00:00', '2024-08-01 16:00:00', now()),
                                                                                                     ('32345678-1234-5678-4234-567812345678', 320.00, 4, 'VIKI771012HMCRG093', '2024-08-01 12:00:00', '2024-08-01 15:00:00', now()),
                                                                                                     ('42345678-1234-5678-5233-567812345678', 560.77, 7, 'VIKI771012HMCRG093', '2024-08-12 20:00:00', '2020-01-14 22:00:00', now());