
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS productImages;
DROP TABLE IF EXISTS orders;

CREATE TABLE IF NOT EXISTS customers(
  customerId UUID DEFAULT uuid_generate_v4(),
  username VARCHAR(50) NOT NULL,
  email CHAR(50) NOT NULL UNIQUE,
  phone VARCHAR(15),
  passcode CHAR(50),
  createdAt TIMESTAMP DEFAULT NOW(),
  updatedAt TIMESTAMP DEFAULT NOW(),
  PRIMARY KEY(customerId),
  UNIQUE(phone)
);

CREATE UNIQUE INDEX CONCURRENTLY customers_customerId ON customers(customerId);

CREATE TABLE IF NOT EXISTS products(
  productId UUID DEFAULT uuid_generate_v4(),
  customerId UUID NOT NULL,
  productName VARCHAR NOT NULL,
  productCategory VARCHAR NOT NULL,
  productPrice DECIMAL(18, 2) NOT NULL,
  createdAt TIMESTAMP DEFAULT NOW(),
  updatedAt TIMESTAMP DEFAULT NOW(),
  PRIMARY KEY(productId),
  CONSTRAINT fk_customer
    FOREIGN KEY(customerId)
      REFERENCES customers(customerId)
      ON DELETE SET NULL -- if you want to keep the rest of the data
      -- ON DELETE CASCADE -- if you want to delete the entire row and loss the rest data
);

CREATE TABLE IF NOT EXISTS productImages(
  productImageId UUID DEFAULT uuid_generate_v4(),
  productId UUID NOT NULL,
  customerId UUID NOT NULL,
  productImage VARCHAR NOT NULL,
  createdAt TIMESTAMP DEFAULT NOW(),
  updatedAt TIMESTAMP DEFAULT NOW(),
  PRIMARY KEY(productImageId),
  CONSTRAINT fk_product
    FOREIGN KEY(productId)
      REFERENCES products(productId)
      ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS orders(
  orderId UUID DEFAULT uuid_generate_v4(),
  customerId UUID NOT NULL,
  productId UUID NOT NULL,
  deliveryAddr VARCHAR NULL,
  deliveryContact VARCHAR NOT NULL,
  deliveryNote VARCHAR NOT NULL,
  createdAt TIMESTAMP DEFAULT NOW(),
  updatedAt TIMESTAMP DEFAULT NOW(),
  PRIMARY KEY(orderId),
  CONSTRAINT fk_multiple
    FOREIGN KEY(customerId)
      REFERENCES customers(customerId)
      ON DELETE NO ACTION,
    FOREIGN KEY(productId)
      REFERENCES products(productId)
      ON DELETE NO ACTION
);