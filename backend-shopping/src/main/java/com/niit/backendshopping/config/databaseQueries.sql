CREATE TABLE Product(
	id IDENTITY,
	code VARCHAR(50),
	name VARCHAR(50),
	brand VARCHAR(100),
	description VARCHAR(250),
	price DOUBLE,
	quantity INT,
	is_active BOOLEAN,
	category_id INT,
	user_id INT,
	purchases INT DEFAULT 0,
	views INT DEFAULT 0,
	
	CONSTRAINT pk_product_id PRIMARY KEY (id),
	CONSTRAINT fk_category_id FOREIGN KEY (category_id) REFERENCES Category(catID),
	CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES User_details(userID)
);


INSERT INTO Product (code, name, brand, description, price, quantity, is_active, category_id, user_id)
VALUES ('PRDABC123DEFX', 'Fastrack 500', 'Titan', 'This is one of the best watches available in the market right now!', 3000, 5, true, 3, 1 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDDEF123DEFX', 'Samsung s7', 'samsung', 'A smart phone by samsung!', 32000, 2, true, 3, 3 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDPQR123WGTX', 'Google Pixel', 'google', 'This is one of the best android smart phone available in the market right now!', 57000, 5, true, 3, 2 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDMNO123PQRX', ' Macbook Pro', 'apple', 'This is one of the best laptops available in the market right now!', 54000, 3, true, 1, 2 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDABCXYZDEFX', 'Dell Latitude E6510', 'dell', 'This is one of the best laptop series from dell that can be used!', 48000, 5, true, 1, 3 );


CREATE TABLE Category(
	catID IDENTITY,
	catName VARCHAR(50),
	catDescription VARCHAR(250),
	catImageURL VARCHAR(50),
	catIsActive BOOLEAN,
	
	CONSTRAINT pk_category_id PRIMARY KEY (catID)
);


CREATE TABLE User_details(
	userID IDENTITY,
	userFirstName VARCHAR(50),
	userLastName VARCHAR(50),
	userRole VARCHAR(50),
	userEnabled BOOLEAN,
	userEmail VARCHAR(100),
	userPassword VARCHAR(30),
	userContactNumber VARCHAR(10),
	
	CONSTRAINT pk_user_id PRIMARY KEY (userID)
);


INSERT INTO User_details 
(userFirstName, userLastName, userRole, userEnabled, userEmail, userPassword, userContactNumber) 
VALUES ('Virat', 'Kohli', 'ADMIN', true, 'vk@gmail.com', 'admin', '8888888888');

INSERT INTO user_detail 
(first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Ravindra', 'Jadeja', 'SUPPLIER', true, '12345', 'rj@gmail.com', '9999999999');

INSERT INTO user_detail 
(first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Ravichandra', 'Ashwin', 'SUPPLIER', true, '12345', 'ra@gmail.com', '7777777777');