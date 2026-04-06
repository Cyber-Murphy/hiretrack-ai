CREATE TYPE job_status AS ENUM ('APPLIED','INTERVIEW','OFFER','REJECTED');

CREATE TABLE jobs(
    id UUID PRIMARY KEY DEFAULT  gen_random_uuid(),
    user_id UUID NOT NULL REFERENCES users(id) ON DELETE CASCADE ,
    company_name VARCHAR(150) NOT NULL ,
    role VARCHAR(150) NOT NULL ,
    job_url VARCHAR(500) NOT NULL ,
    salary_range VARCHAR(100),
    location VARCHAR(100),
    status job_status NOT NULL DEFAULT 'APPLIED',
    source VARCHAR(100),
    notes TEXT,
    applied_date DATE DEFAULT  CURRENT_DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP

);

CREATE TABLE  skills(
    id UUID PRIMARY KEY  DEFAULT gen_random_uuid(),
    job_id UUID NOT NULL REFERENCES  jobs(id) ON DELETE CASCADE ,
    skill_name VARCHAR(100) NOT NULL,
    is_matched BOOLEAN DEFAULT FALSE
);