INSERT INTO users (id, is_active,created,first_name, last_name,modified, password, username)
VALUES
    (1, true,NOW(),'Admin', 'Adminov', NOW(), '6cf1643832d3199650e5b751fd97473490bc6dd4aa9343d9bfa23ba9ceb2e24d71360d42d571a2cabdbcec584bbda490','admin'),
    (2, true,NOW(), 'User', 'Userov',NOW(),  '6cf1643832d3199650e5b751fd97473490bc6dd4aa9343d9bfa23ba9ceb2e24d71360d42d571a2cabdbcec584bbda490', 'user'),
    (3, true,NOW(), 'Vanesa', 'Ilieva',NOW(), '6cf1643832d3199650e5b751fd97473490bc6dd4aa9343d9bfa23ba9ceb2e24d71360d42d571a2cabdbcec584bbda490', 'Vanesa06');


INSERT INTO roles (`id`, `role`)
VALUES
    (1, 'ADMIN'),
    (2, 'USER');

INSERT INTO users_user_role(`user_id`, `user_role_id`)
VALUES
    (1, 1),
    (1, 2),
    (2, 2);


INSERT INTO `brands` (`id`, `created`, `modified`, `name`)
VALUES
    (1,NOW(), NOW(),'Toyota'),
    (2,NOW(), NOW(), 'Ford'),
    (3,NOW(), NOW(), 'Trabant');

INSERT INTO `models` (`id`, `category`,`created`, `end_year`, `image_url`, `modified`, `name`,`start_year`, `brand_id`)
VALUES
    (1, 'CAR', NOW(),2010,  'https://img.freepik.com/free-vector/red-sedan-car-isolated-white-vector_53876-64366.jpg',NOW(),'Camry', 2007, 1),
    (2, 'CAR', NOW(),2012,  'https://img.freepik.com/free-vector/red-sedan-car-isolated-white-vector_53876-64366.jpg',NOW(),'Corolla', 2006, 1),
    (3, 'CAR', NOW(),2011,  'https://img.freepik.com/free-vector/red-sedan-car-isolated-white-vector_53876-64366.jpg',NOW(),'Focus', 2007, 2),
    (4, 'CAR',  NOW(),2014,  'https://img.freepik.com/free-vector/red-sedan-car-isolated-white-vector_53876-64366.jpg',NOW(),'Fiesta', 2007,2),
    (5, 'CAR', NOW(),2010,  'https://img.freepik.com/free-vector/red-sedan-car-isolated-white-vector_53876-64366.jpg',NOW(),'601', 2007, 3);

INSERT INTO `offers` (`id`, `description`, `engine`, `image_url`, `mileage`, `price`, `transmission`, `modified`, `created`, `year`, `model_id`, `seller_id`)
VALUES
    (1, 'Top Trabi 1!', 'DIESEL', 'https://upload.wikimedia.org/wikipedia/commons/thumb/b/b8/AWZ_Trabant_601S%2C_Verkehrszentrum_des_Deutschen_Museums.JPG/1200px-AWZ_Trabant_601S%2C_Verkehrszentrum_des_Deutschen_Museums.JPG', 24000, 2223, 'MANUAL', NOW(), NOW(), 1985, 5, 1),
    (2, 'Top Trabi 1!', 'DIESEL', 'https://upload.wikimedia.org/wikipedia/commons/thumb/b/b8/AWZ_Trabant_601S%2C_Verkehrszentrum_des_Deutschen_Museums.JPG/1200px-AWZ_Trabant_601S%2C_Verkehrszentrum_des_Deutschen_Museums.JPG', 24000, 2225, 'MANUAL', NOW(), NOW(), 1986, 5, 1),
    (3, 'Top Trabi 2!', 'DIESEL', 'https://upload.wikimedia.org/wikipedia/commons/thumb/b/b8/AWZ_Trabant_601S%2C_Verkehrszentrum_des_Deutschen_Museums.JPG/1200px-AWZ_Trabant_601S%2C_Verkehrszentrum_des_Deutschen_Museums.JPG', 24000, 2227, 'MANUAL', NOW(), NOW(), 1987, 5, 2),
    (4, 'Top Trabi 2!', 'DIESEL', 'https://upload.wikimedia.org/wikipedia/commons/thumb/b/b8/AWZ_Trabant_601S%2C_Verkehrszentrum_des_Deutschen_Museums.JPG/1200px-AWZ_Trabant_601S%2C_Verkehrszentrum_des_Deutschen_Museums.JPG', 24000, 2221, 'MANUAL', NOW(), NOW(), 1988, 5, 2),
    (5, 'Top Trabi 2!', 'DIESEL', 'https://upload.wikimedia.org/wikipedia/commons/thumb/b/b8/AWZ_Trabant_601S%2C_Verkehrszentrum_des_Deutschen_Museums.JPG/1200px-AWZ_Trabant_601S%2C_Verkehrszentrum_des_Deutschen_Museums.JPG', 24000, 2220, 'MANUAL',NOW(), NOW(), 1989, 5, 2);