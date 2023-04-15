
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS product_images;
DROP TABLE IF EXISTS orders;

CREATE TABLE IF NOT EXISTS customers (
  customer_id UUID DEFAULT uuid_generate_v4(),
  first_name VARCHAR,
  last_name VARCHAR,
  email VARCHAR NOT NULL UNIQUE,
  phone VARCHAR,
  "password" VARCHAR(225),
  created_at TIMESTAMP DEFAULT NOW(),
  updated_at TIMESTAMP DEFAULT NOW(),
  PRIMARY KEY(customer_id),
  UNIQUE(phone)
);

CREATE UNIQUE INDEX CONCURRENTLY customers_customer_id ON customers(customer_id);

CREATE TABLE IF NOT EXISTS products(
  product_id UUID DEFAULT uuid_generate_v4(),
  customer_id UUID NOT NULL,
  product_name VARCHAR NOT NULL,
  product_category VARCHAR NOT NULL,
  product_price DECIMAL(18, 2) NOT NULL,
  created_at TIMESTAMP DEFAULT NOW(),
  updated_at TIMESTAMP DEFAULT NOW(),
  PRIMARY KEY(product_id),
  CONSTRAINT fk_customer
    FOREIGN KEY(customer_id)
      REFERENCES customers(customer_id)
      ON DELETE SET NULL -- if you want to keep the rest of the data
      -- ON DELETE CASCADE -- if you want to delete the entire row and loss the rest data
);

CREATE TABLE IF NOT EXISTS product_images (
  product_image_id UUID DEFAULT uuid_generate_v4(),
  product_id UUID NOT NULL,
  customer_id UUID NOT NULL,
  product_image VARCHAR NOT NULL,
  created_at TIMESTAMP DEFAULT NOW(),
  updated_at TIMESTAMP DEFAULT NOW(),
  PRIMARY KEY(product_image_id),
  CONSTRAINT fk_product
    FOREIGN KEY(product_id)
      REFERENCES products(product_id)
      ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS orders(
  order_id UUID DEFAULT uuid_generate_v4(),
  customer_id UUID NOT NULL,
  product_id UUID NOT NULL,
  delivery_addr VARCHAR NULL,
  delivery_contact VARCHAR NOT NULL,
  delivery_note VARCHAR NOT NULL,
  created_at TIMESTAMP DEFAULT NOW(),
  updated_at TIMESTAMP DEFAULT NOW(),
  PRIMARY KEY(order_id),
  CONSTRAINT fk_multiple
    FOREIGN KEY(customer_id)
      REFERENCES customers(customer_id)
      ON DELETE NO ACTION,
    FOREIGN KEY(product_id)
      REFERENCES products(product_id)
      ON DELETE NO ACTION
);