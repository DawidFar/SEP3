-- orderdb seed (empty initial schema)
CREATE TABLE IF NOT EXISTS orders_table (
  id UUID PRIMARY KEY,
  user_id TEXT,
  total_amount NUMERIC,
  status TEXT
);
