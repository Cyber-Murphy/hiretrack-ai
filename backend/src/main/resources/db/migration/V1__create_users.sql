CREATE EXTENSION IF NOT EXISTS "pgcrypto";
       CREATE TABLE users(
        id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
        name VARCHAR(100) NOT NULL,
        email VARCHAR(100) NOT NULL UNIQUE ,
        password VARCHAR(100) NOT NULL ,
        target_role VARCHAR(100),
        target_salary VARCHAR(100),
        resume_url VARCHAR(100),
        created_at TIMESTAMP DEFAULT current_timestamp,
        updated_at TIMESTAMP DEFAULT  current_timestamp



       )

