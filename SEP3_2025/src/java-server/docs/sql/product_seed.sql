-- productdb seed
CREATE TABLE IF NOT EXISTS products (
  id UUID PRIMARY KEY,
  name TEXT,
  description TEXT,
  price NUMERIC,
  stock INTEGER
);
INSERT INTO products (id, name, description, price, stock) VALUES
('11111111-1111-1111-1111-111111111111', 'Sample Product A', 'An example product', 9.99, 10)
ON CONFLICT DO NOTHING;
