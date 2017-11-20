---UserName:root@localhost
---ProductName:MySQL
CREATE DATABASE sakila
CREATE TABLE actor( actor_id SMALLINT (5)NOT NULL
first_name VARCHAR (45)NOT NULL
last_name VARCHAR (45)NOT NULL
last_update TIMESTAMP (19)NOT NULL
);
CREATE TABLE address( address_id SMALLINT (5)NOT NULL
address VARCHAR (50)NOT NULL
address2 VARCHAR (50)NOT NULL
district VARCHAR (20)NOT NULL
city_id SMALLINT (5)NOT NULL
postal_code VARCHAR (10)NOT NULL
phone VARCHAR (20)NOT NULL
last_update TIMESTAMP (19)NOT NULL
);
CREATE TABLE category( category_id TINYINT (3)NOT NULL
name VARCHAR (25)NOT NULL
last_update TIMESTAMP (19)NOT NULL
);
CREATE TABLE city( city_id SMALLINT (5)NOT NULL
city VARCHAR (50)NOT NULL
country_id SMALLINT (5)NOT NULL
last_update TIMESTAMP (19)NOT NULL
);
CREATE TABLE country( country_id SMALLINT (5)NOT NULL
country VARCHAR (50)NOT NULL
last_update TIMESTAMP (19)NOT NULL
);
CREATE TABLE customer( customer_id SMALLINT (5)NOT NULL
store_id TINYINT (3)NOT NULL
first_name VARCHAR (45)NOT NULL
last_name VARCHAR (45)NOT NULL
email VARCHAR (50)NOT NULL
address_id SMALLINT (5)NOT NULL
active BIT (null)NOT NULL
create_date DATETIME (19)NOT NULL
last_update TIMESTAMP (19)NOT NULL
);
CREATE TABLE film( film_id SMALLINT (5)NOT NULL
title VARCHAR (255)NOT NULL
description TEXT (65535)NOT NULL
release_year YEAR (null)NOT NULL
language_id TINYINT (3)NOT NULL
original_language_id TINYINT (3)NOT NULL
rental_duration TINYINT (3)NOT NULL
rental_rate DECIMAL (4)  2length SMALLINT (5)NOT NULL
replacement_cost DECIMAL (5)  2rating ENUM (5)NOT NULL
special_features SET (54)NOT NULL
last_update TIMESTAMP (19)NOT NULL
);
CREATE TABLE film_actor( actor_id SMALLINT (5)NOT NULL
film_id SMALLINT (5)NOT NULL
last_update TIMESTAMP (19)NOT NULL
);
CREATE TABLE film_category( film_id SMALLINT (5)NOT NULL
category_id TINYINT (3)NOT NULL
last_update TIMESTAMP (19)NOT NULL
);
CREATE TABLE film_text( film_id SMALLINT (5)NOT NULL
title VARCHAR (255)NOT NULL
description TEXT (65535)NOT NULL
);
CREATE TABLE inventory( inventory_id MEDIUM (8)NOT NULL
film_id SMALLINT (5)NOT NULL
store_id TINYINT (3)NOT NULL
last_update TIMESTAMP (19)NOT NULL
);
CREATE TABLE language( language_id TINYINT (3)NOT NULL
name CHAR (20)NOT NULL
last_update TIMESTAMP (19)NOT NULL
);
CREATE TABLE payment( payment_id SMALLINT (5)NOT NULL
customer_id SMALLINT (5)NOT NULL
staff_id TINYINT (3)NOT NULL
rental_id INT (10)amount DECIMAL (5)  2payment_date DATETIME (19)NOT NULL
last_update TIMESTAMP (19)NOT NULL
);
CREATE TABLE rental( rental_id INT (10)rental_date DATETIME (19)NOT NULL
inventory_id MEDIUM (8)NOT NULL
customer_id SMALLINT (5)NOT NULL
return_date DATETIME (19)NOT NULL
staff_id TINYINT (3)NOT NULL
last_update TIMESTAMP (19)NOT NULL
);
CREATE TABLE staff( staff_id TINYINT (3)NOT NULL
first_name VARCHAR (45)NOT NULL
last_name VARCHAR (45)NOT NULL
address_id SMALLINT (5)NOT NULL
picture BLOB (65535)NOT NULL
email VARCHAR (50)NOT NULL
store_id TINYINT (3)NOT NULL
active BIT (null)NOT NULL
username VARCHAR (16)NOT NULL
password VARCHAR (40)NOT NULL
last_update TIMESTAMP (19)NOT NULL
);
CREATE TABLE store( store_id TINYINT (3)NOT NULL
manager_staff_id TINYINT (3)NOT NULL
address_id SMALLINT (5)NOT NULL
last_update TIMESTAMP (19)NOT NULL
);
CREATE TABLE actor_info( actor_id SMALLINT (5)NOT NULL
first_name VARCHAR (45)NOT NULL
last_name VARCHAR (45)NOT NULL
film_info TEXT (65535)NOT NULL
);
CREATE TABLE customer_list( ID SMALLINT (5)NOT NULL
name VARCHAR (91)NOT NULL
address VARCHAR (50)NOT NULL
zip code VARCHAR (10)NOT NULL
phone VARCHAR (20)NOT NULL
city VARCHAR (50)NOT NULL
country VARCHAR (50)NOT NULL
notes VARCHAR (6)NOT NULL
SID TINYINT (3)NOT NULL
);
CREATE TABLE film_list( FID SMALLINT (5)NOT NULL
title VARCHAR (255)NOT NULL
description TEXT (65535)NOT NULL
category VARCHAR (25)NOT NULL
price DECIMAL (4)  2length SMALLINT (5)NOT NULL
rating ENUM (5)NOT NULL
actors TEXT (65535)NOT NULL
);
CREATE TABLE nicer_but_slower_film_list( FID SMALLINT (5)NOT NULL
title VARCHAR (255)NOT NULL
description TEXT (65535)NOT NULL
category VARCHAR (25)NOT NULL
price DECIMAL (4)  2length SMALLINT (5)NOT NULL
rating ENUM (5)NOT NULL
actors TEXT (65535)NOT NULL
);
CREATE TABLE sales_by_film_category( category VARCHAR (25)NOT NULL
total_sales DECIMAL (27)  2);
CREATE TABLE sales_by_store( store VARCHAR (101)NOT NULL
manager VARCHAR (91)NOT NULL
total_sales DECIMAL (27)  2);
CREATE TABLE staff_list( ID TINYINT (3)NOT NULL
name VARCHAR (91)NOT NULL
address VARCHAR (50)NOT NULL
zip code VARCHAR (10)NOT NULL
phone VARCHAR (20)NOT NULL
city VARCHAR (50)NOT NULL
country VARCHAR (50)NOT NULL
SID TINYINT (3)NOT NULL
);
ALTER TABLE store_id ADD PRIMARY KEY (store);
ALTER TABLE inventory_id ADD PRIMARY KEY (inventory);
ALTER TABLE address_id ADD PRIMARY KEY (address);
ALTER TABLE language_id ADD PRIMARY KEY (language);
ALTER TABLE rental_id ADD PRIMARY KEY (rental);
ALTER TABLE category_id ADD PRIMARY KEY (film_category);
ALTER TABLE payment_id ADD PRIMARY KEY (payment);
ALTER TABLE staff_id ADD PRIMARY KEY (staff);
ALTER TABLE actor_id ADD PRIMARY KEY (film_actor);
ALTER TABLE film_id ADD PRIMARY KEY (film_text);
ALTER TABLE customer_id ADD PRIMARY KEY (customer);
ALTER TABLE country_id ADD PRIMARY KEY (country);
ALTER TABLE city_id ADD PRIMARY KEY (city);
