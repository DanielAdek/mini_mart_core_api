-- customers
INSERT INTO customers (username, email, phone, passcode) VALUES ('John Wyclife', 'John@gmail.com', '+1950484888333', 'john.wyclife');
INSERT INTO customers (username, email, phone, passcode) VALUES ('Marry Wyclife', 'marry@gmail.com', '+1950484888323', 'marry.wyclife');
INSERT INTO customers (username, email, phone, passcode) VALUES ('John knox', 'knox@gmail.com', '+1950222388333', 'john.knox');
INSERT INTO customers (username, email, phone, passcode) VALUES ('Billy Graham', 'billy@yahoo.com', '+1950484999003', 'billy.graham');
INSERT INTO customers (username, email, phone, passcode) VALUES ('Wood McPhancy', 'wood@hotmail.com', '+1950484088333', 'wood.wyclife');
INSERT INTO customers (username, email, phone, passcode) VALUES ('Alli Mabel', 'mabel@yahoo.com', '+1950484888339', 'password@1234');
INSERT INTO customers (username, email, phone, passcode) VALUES ('Fred Jones', 'fred@gmail.com', '+1950484828333', 'password@1234');
INSERT INTO customers (username, email, phone, passcode) VALUES ('Alexander Bright', 'alex@nownow.com', '+195041188333', 'password@1234');
INSERT INTO customers (username, email, phone, passcode) VALUES ('Fred Anderson', 'fred@hotmail.com', '+1950484888335', 'password@1234');
INSERT INTO customers (username, email, phone, passcode) VALUES ('Adek Abram', 'adekabram@gmail.com', '+1950484888332', 'password@1234');
INSERT INTO customers (username, email, phone, passcode) VALUES ('Abraham Lincon', 'abraham@gmail.com', '+1950484888337', 'password@1234');
INSERT INTO customers (username, email, phone, passcode) VALUES ('Washinton Dollars', 'dollars@britney.co.uk', '+1950484888653', 'password@1234');
INSERT INTO customers (username, email, phone, passcode) VALUES ('Gorge Clinton', 'clinton@gmail.com', '+1950484888389', 'password@1234');

-- products
INSERT INTO products(customerId, productName, productCategory, productPrice) VALUES ('726f3ebe-e5be-4864-9da1-a5cce6666f4b', 'Blender', 'kitchen Equipment', 17000.00);
INSERT INTO products(customerId, productName, productCategory, productPrice) VALUES ('726f3ebe-e5be-4864-9da1-a5cce6666f4b', 'Microvave', 'kitchen Equipment', 45000.00);
INSERT INTO products(customerId, productName, productCategory, productPrice) VALUES ('726f3ebe-e5be-4864-9da1-a5cce6666f4b', 'Gas Cooker', 'kitchen Equipment', 24500.00);
INSERT INTO products(customerId, productName, productCategory, productPrice) VALUES ('bbbfbe00-aed4-406c-a02a-672fc10041b8', 'Blender', 'kitchen Equipment', 18000.00);
INSERT INTO products(customerId, productName, productCategory, productPrice) VALUES ('bbbfbe00-aed4-406c-a02a-672fc10041b8', 'Ox Standing Fan', 'Electronics', 11000.00);
INSERT INTO products(customerId, productName, productCategory, productPrice) VALUES ('bbbfbe00-aed4-406c-a02a-672fc10041b8', 'HP 15 Laptop', 'Computer', 140000.00);
INSERT INTO products(customerId, productName, productCategory, productPrice) VALUES ('006e2255-208a-4094-a900-be318db03885', 'Toyota Camry 2015', 'cars', 4000000.00);
INSERT INTO products(customerId, productName, productCategory, productPrice) VALUES ('006e2255-208a-4094-a900-be318db03885', 'Honda Civi 2005', 'cars', 1500000.00);
INSERT INTO products(customerId, productName, productCategory, productPrice) VALUES ('006e2255-208a-4094-a900-be318db03885', 'Solara 2012', 'cars', 2700000.00);

-- orders
INSERT INTO orders(customerId, productId, deliveryAddr, deliveryContact, deliveryNote) VALUES ('74cbddcd-9178-4a11-bb81-6b2841dca6eb', '773bcdd3-9742-4fb3-8719-fd18baf2e780', 'MarryLand Ave plot 4', 'clinton@gmail.com', 'Early delivery please');
INSERT INTO orders(customerId, productId, deliveryAddr, deliveryContact, deliveryNote) VALUES ('9aa3e4b2-61d4-49d1-84a6-b1351c0e922d', '773bcdd3-9742-4fb3-8719-fd18baf2e780', 'MarryLand Ave plot 5', 'knox@gmail.com', 'Early delivery please');
INSERT INTO orders(customerId, productId, deliveryAddr, deliveryContact, deliveryNote) VALUES ('375ee652-75b0-4889-afc1-250ff37cd254', 'fb0cec5f-948c-4ca9-b331-90de7d134102', 'MarryLand Ave plot 6', 'wood@gmail.com', 'Early delivery please');
INSERT INTO orders(customerId, productId, deliveryAddr, deliveryContact, deliveryNote) VALUES ('33933bcf-ccf0-4f14-8711-95505f844b28', 'fb0cec5f-948c-4ca9-b331-90de7d134102', 'MarryLand Ave plot 7', 'mabel@gmail.com', 'Early delivery please');
INSERT INTO orders(customerId, productId, deliveryAddr, deliveryContact, deliveryNote) VALUES ('7d0c5876-0c77-4924-be27-b6a3a0b84245', 'fb0cec5f-948c-4ca9-b331-90de7d134102', 'MarryLand Ave plot 8', 'fred@gmail.com', 'Early delivery please');
INSERT INTO orders(customerId, productId, deliveryAddr, deliveryContact, deliveryNote) VALUES ('7d0c5876-0c77-4924-be27-b6a3a0b84245', '00c02c25-5928-4ac0-847b-8ccf3293f468', 'MarryLand Ave plot 9', 'fred@gmail.com', 'Early delivery please');
INSERT INTO orders(customerId, productId, deliveryAddr, deliveryContact, deliveryNote) VALUES ('a0ae5c2a-f3a7-490c-ba26-fd52ee2c8593', 'e3e47f49-9926-4295-b698-78f0f0b89820', 'MarryLand Ave plot 10', '+1950484999003', 'Early delivery please');
INSERT INTO orders(customerId, productId, deliveryAddr, deliveryContact, deliveryNote) VALUES ('f8aa9871-dc3c-4138-b812-0e4df0992ea7', '7b1cf9b2-29c6-4427-833b-c05c38c721fa', 'MarryLand Ave plot 10', '+1950484999003', 'Early delivery please');
INSERT INTO orders(customerId, productId, deliveryAddr, deliveryContact, deliveryNote) VALUES ('f438fcc3-6483-436a-b401-35b89a57879e', '7b1cf9b2-29c6-4427-833b-c05c38c721fa', 'MarryLand Ave plot 11', '+1950484888337', 'Early delivery please');
INSERT INTO orders(customerId, productId, deliveryAddr, deliveryContact, deliveryNote) VALUES ('8f26def1-bdd4-4ce5-809a-115ff4143c43', '4d5d2e0d-32e3-4824-aa2e-f058a04e6d81', 'MarryLand Ave plot 5', 'knox@gmail.com', 'Early delivery please');
INSERT INTO orders(customerId, productId, deliveryAddr, deliveryContact, deliveryNote) VALUES ('d27b23c8-77ad-4511-a4f2-8d9639a97413', 'e58f25f4-f5a6-47f7-a096-6b2227c9e0eb', 'MarryLand Ave plot 4', 'clinton@gmail.com', 'Early delivery please');
INSERT INTO orders(customerId, productId, deliveryAddr, deliveryContact, deliveryNote) VALUES ('d27b23c8-77ad-4511-a4f2-8d9639a97413', '704c9076-ee84-42ab-b935-cb08993ab153', 'MarryLand Ave plot 6', 'wood@gmail.com', 'Early delivery please');